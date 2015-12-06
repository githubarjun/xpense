package com.xpense.commons.service;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xpense.HibernateSessionFactory;
import com.xpense.commons.bo.BaseFieldsBO;
import com.xpense.commons.commands.CreateCommand;
import com.xpense.commons.commands.DeleteCommand;
import com.xpense.commons.commands.UpdateCommand;
import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.commons.dto.MakerCheckerFieldsDTO;
import com.xpense.commons.dto.MasterFieldsDTO;
import com.xpense.utils.BODTOFiller;

public class MakerCheckerService<TBO,TDTO> extends BaseService<TBO, TDTO> {

	public MakerCheckerService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MakerCheckerService(Class<TBO> clazz) {
		super(clazz);
	}
	
	/**
	 * 1.Create
	 * 2.Update
	 * 3.Delete
	 * 4.FindByHQL
	 */
	
	public void create(TDTO tdto)throws Exception{
		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		try{
			TBO tbo = boClazz.newInstance() ;
			BaseFieldsBO bo = (BaseFieldsBO) tbo;
			BaseFieldsDTO dto = (BaseFieldsDTO) tdto;
			//convert DTO to BO
			BODTOFiller.fillBO(bo, dto);
			CreateCommand<TBO> command = new CreateCommand<TBO>(session,tbo);
			command.execute();
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		
	}

	public void update(TDTO tdto)throws Exception{
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		try{
			TBO tbo = boClazz.newInstance();
			BaseFieldsBO bo = (BaseFieldsBO) tbo;
			BaseFieldsDTO dto = (BaseFieldsDTO) tdto;
			//convert DTO to BO
			BODTOFiller.fillBO(bo, dto);
			UpdateCommand<TBO> command = new UpdateCommand<TBO>(session,tbo);
			command.execute();
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}finally{
			HibernateSessionFactory.closeSession();
		}

		
	}
	
	public void delete(TDTO tdto)throws Exception{
		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		try{
			TBO tbo = null;
			DeleteCommand<TBO> command = new DeleteCommand<TBO>(session,tbo);
			command.execute();
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
	}
	
	public void setFields(BaseFieldsDTO tbo,String action){
		if(tbo instanceof MasterFieldsDTO){
			MasterFieldsDTO fieldsDTO = (MasterFieldsDTO)tbo;
			fieldsDTO.setActive(true);
			fieldsDTO.setEnabled(true);
			fieldsDTO.setEffectiveFrom(new Date());
			fieldsDTO.setEffectiveTill(null);
		}
		
		if(tbo instanceof MakerCheckerFieldsDTO){
			
			MakerCheckerFieldsDTO fieldsDTO = (MakerCheckerFieldsDTO)tbo;
			fieldsDTO.setLastStatus(action);
			fieldsDTO.setCreatedBy("System");
			fieldsDTO.setCreatedDate(new Date());
			fieldsDTO.setModifiedBy(null);
			fieldsDTO.setModifiedDate(null);
		}
	}
	public void setFieldsUpdate(BaseFieldsDTO tbo,String action){
		if(tbo instanceof MasterFieldsDTO){
			/*MasterFieldsDTO fieldsDTO = (MasterFieldsDTO)tbo;
			fieldsDTO.setActive(true);
			fieldsDTO.setEnabled(true);
			fieldsDTO.setEffectiveFrom(new Date());
			fieldsDTO.setEffectiveTill(null);*/
		}
		
		if(tbo instanceof MakerCheckerFieldsDTO){
			
			MakerCheckerFieldsDTO fieldsDTO = (MakerCheckerFieldsDTO)tbo;
			fieldsDTO.setLastStatus(action);
			//fieldsDTO.setCreatedBy("System");
			//fieldsDTO.setCreatedDate(new Date());
			fieldsDTO.setModifiedBy("System");
			fieldsDTO.setModifiedDate(new Date());
		}
	}
}
