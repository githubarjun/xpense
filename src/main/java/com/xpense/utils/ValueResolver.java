package com.xpense.utils;

import java.lang.reflect.Method;

public class ValueResolver {
	
	public static final String USER_SERVICE = "com.xpense.master.service.impl.UserServiceImpl";
	
	public static Object getValueById(String service,Long id){
		Object object = null;
		try {
			Class c = Class.forName(service);
			Object newInstance = c.newInstance();
			Method method = c.getMethod("findById", new Class[]{java.lang.String.class,java.lang.Long.class});
			object = method.invoke(newInstance, new Object[]{service,id});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return object;
	}
	
}
