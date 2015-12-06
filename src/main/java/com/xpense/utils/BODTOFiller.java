package com.xpense.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.xpense.commons.bo.BaseFieldsBO;
import com.xpense.commons.bo.MakerCheckerFieldsBO;
import com.xpense.commons.bo.MasterFieldsBO;
import com.xpense.commons.dto.BaseFieldsDTO;

public class BODTOFiller {
	private BODTOFiller() {
	}

	public static BaseFieldsDTO fillDTO(BaseFieldsDTO dto, BaseFieldsBO bo) {
		Class boClass = bo.getClass();
		Class dtoClass = dto.getClass();

		Method[] dtoMethods = dtoClass.getMethods();
		for (Method dtoMethod : dtoMethods) {
			String dtoMethodName = dtoMethod.getName();
			if (dtoMethodName.startsWith("set")) {
				String boMethodName = dtoMethodName.replaceFirst("^set", "get");
				try {
					Method boMethod = null;
					try
					{
						boMethod = boClass.getMethod(boMethodName,	new Class[] {});
					}
					catch(NoSuchMethodException ignore)
					{
						boMethodName = dtoMethodName.replaceFirst("^set","is");
						boMethod = boClass.getMethod(boMethodName,	new Class[] {});
					}
					
					Object returnValue = boMethod.invoke(bo, new Object[] {});
					if (returnValue instanceof Collection) {
						Collection<? extends BaseFieldsBO> bos = (Collection<? extends BaseFieldsBO>) returnValue;
						Collection<BaseFieldsDTO> dtos = null ;
						
						if (returnValue instanceof Set) 
							dtos = new LinkedHashSet<BaseFieldsDTO>();
						else if (returnValue instanceof List) 
							dtos = new ArrayList<BaseFieldsDTO>();
						
						// Doing Deep Copy
						for (BaseFieldsBO aBO : bos) {
						
							//added by GG
							//ReadValue of the parent should be applied to childs for viewprevious data 
							/*if (aBO instanceof MakerCheckerFieldsBO) {
								MakerCheckerFieldsBO makerBO = (MakerCheckerFieldsBO) aBO;
								if (bo instanceof MakerCheckerFieldsBO) {
									MakerCheckerFieldsBO parentBO = (MakerCheckerFieldsBO) bo;
									//makerBO.setReadValue(parentBO.getReadValue());
									
								}
							}*/
							
							dtos.add(aBO.toDTO());
						}
						
						dtoMethod.invoke(dto, new Object[] { dtos });
					} else {
						//if (dtoMethodName.equals("setId")) 
						if (dtoMethodName.endsWith("Id")) 
						{							
							if(returnValue != null)
							{
								Method getVersion = boClass.getMethod("getVersion",(Class[])null);
								Integer version = (Integer) getVersion.invoke(bo,(Object[])null); 
								//final String encryptedId = EncryptUtils.encryptId((Long)returnValue);
								final String encryptedId = returnValue.toString();
								dtoMethod.invoke(dto, new Object[] { encryptedId });
							}
							else
							{
								dtoMethod.invoke(dto, new Object[] { null });
							}
						}else if(returnValue instanceof BaseFieldsBO) {
							//BaseFieldsDTO baseDTO = ((BaseFieldsBO)returnValue).toDTO();
							//dtoMethod.invoke(dto, new Object[] { baseDTO });
						}else {
							dtoMethod.invoke(dto, new Object[] { returnValue });
						}
					}
				} catch (SecurityException ignore) {
				} catch (NoSuchMethodException ignore) {
				} catch (IllegalArgumentException ignore) {
				} catch (IllegalAccessException ignore) {
				} catch (InvocationTargetException ignore) {
				}
			}
		}
		return dto;
	}
	
	public static BaseFieldsBO fillBO(BaseFieldsBO bo, BaseFieldsDTO dto) {
		Class boClass = bo.getClass();  
		Class dtoClass = dto.getClass();

		Method[] dtoMethods = dtoClass.getMethods();

		for (Method dtoMethod : dtoMethods) {
			String dtoMethodName = dtoMethod.getName();
			if (dtoMethodName.startsWith("get")) {
				String boMethodName = dtoMethodName.replaceFirst("^get", "set");
				try {
//					if (!boMethodName.equals("setId")) {
					if (!boMethodName.endsWith("Id")) {
						
						Object returnValue = dtoMethod.invoke(dto,new Object[] {});
						dtoMethod.getReturnType();
						Method boMethod = null;
						
						if(returnValue instanceof BaseFieldsDTO){
							String boClassName = ((BaseFieldsDTO)returnValue).getBOClassName();
							Class<BaseFieldsBO> localBoClass = null;
							BaseFieldsBO fieldsBO = null;
							try {
								localBoClass = (Class<BaseFieldsBO>) Class.forName(boClassName);
								fieldsBO = localBoClass.newInstance();
							} catch (ClassNotFoundException e) {} 
							  catch (InstantiationException e) {}
							
							BODTOFiller.fillBO(fieldsBO, (BaseFieldsDTO)returnValue);
							boMethod = boClass.getMethod(boMethodName,new Class[] { localBoClass });
							makeNonAccessibleMethodAccessible(boMethod);
							boMethod.invoke(bo, new Object[] { fieldsBO });
							
						}else if(!(returnValue instanceof Collection)){
							boMethod = boClass.getMethod(boMethodName,new Class[] { dtoMethod.getReturnType() });
							makeNonAccessibleMethodAccessible(boMethod);
							boMethod.invoke(bo, new Object[] { returnValue });
						
						}else if(returnValue instanceof Collection){
							//Convert Collection DTO's to Bo's
							if(returnValue instanceof Set){
								Set<BaseFieldsDTO> set = (Set<BaseFieldsDTO>) returnValue;
								Set<BaseFieldsBO> bos = new LinkedHashSet<BaseFieldsBO>();
								Class<BaseFieldsBO> name = null;
								BaseFieldsBO fieldsBO = null;
								for(BaseFieldsDTO fieldsDTO : set){
									String boClassName = fieldsDTO.getBOClassName();
									try {
										name = (Class<BaseFieldsBO>) Class.forName(boClassName);
										fieldsBO = name.newInstance();
									} catch (Exception e) {
										e.printStackTrace();
									}
									BODTOFiller.fillBO(fieldsBO, fieldsDTO);
									bos.add(fieldsBO);
								}
								
								boMethod = boClass.getMethod(boMethodName,new Class[] {Set.class});
								makeNonAccessibleMethodAccessible(boMethod);
								boMethod.invoke(bo, new Object[] { bos });
								
							}
							
						}
					}
					else
					{
						Object returnValue = dtoMethod.invoke(dto,new Object[] {});
						Long id = null;
							if(returnValue != null)
							{
								if (!returnValue.toString().equals("0"))
								{
									//id = EncryptUtils.decryptId(returnValue.toString());
									id = Long.parseLong(returnValue.toString());
								}
								else if(returnValue.toString().equals("0")){
									id=0L;
								}
							}
							
								Method boMethod = null;
								if (boMethodName.equals("setId")) {
									//since setId is private in BaseBO we have to travel till BaseBO Class 
									//if (bo instanceof ParentMasterFieldsBO  ) {
									if(false){
										boMethod = boClass
											.getSuperclass()	//ParentMasterBO
											.getSuperclass()	//MasterBO
											.getSuperclass()	//MakerCheckerBO
											.getSuperclass()	//BaseBO
											.getDeclaredMethod(boMethodName,
													new Class[] { Long.class });
										
									}
									//else if (bo instanceof MasterFieldsBO || bo instanceof ParentMakerCheckerFieldsBO) {
									else if(bo instanceof MasterFieldsBO){
										boMethod = boClass
											.getSuperclass()	//MasterBO or ParentMakerCheckerBO
											.getSuperclass()	//MakerCheckerBO
											.getSuperclass()	//BaseBO
											.getDeclaredMethod(boMethodName,
													new Class[] { Long.class });
										
									}else if (bo instanceof MakerCheckerFieldsBO) {
										boMethod = boClass
										.getSuperclass()	//MakerCheckerBO
										.getSuperclass()	//BaseBO
										.getDeclaredMethod(boMethodName,
												new Class[] { Long.class });

									}else {	
										try{
										boMethod = boClass
										.getSuperclass() //BaseBO
										.getDeclaredMethod(boMethodName,
												new Class[] { Long.class });
										}catch (NoSuchMethodException e) {
											try{
											boMethod = boClass
											.getSuperclass() 
											.getSuperclass()
											.getDeclaredMethod(boMethodName,
													new Class[] { Long.class });
											}catch (NoSuchMethodException e1) {
												boMethod = boClass
												.getSuperclass() 
												.getSuperclass() 
												.getSuperclass()
												.getDeclaredMethod(boMethodName,
														new Class[] { Long.class });
											}

										}
									}
								}else
								{
									boMethod = boClass.getMethod(boMethodName,new Class[] { Long.class });
								}
								makeNonAccessibleMethodAccessible(boMethod);
								boMethod.invoke(bo, new Object[] { id });
					}
				} catch (SecurityException ignore) {
				} catch (NoSuchMethodException ignore) {
				} catch (IllegalArgumentException ignore) {
				} catch (IllegalAccessException ignore) {
				} catch (InvocationTargetException ignore) {
				}
			}
		}
		return bo;
	}
	
	private static void makeNonAccessibleMethodAccessible(Method boMethod) {
		int modifiers = boMethod.getModifiers();
		if(Modifier.isPrivate(modifiers) || Modifier.isProtected(modifiers))
			boMethod.setAccessible(true);
	}
}
