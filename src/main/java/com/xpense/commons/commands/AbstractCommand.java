package com.xpense.commons.commands;

import java.util.Date;

import org.hibernate.Session;

import com.xpense.commons.bo.MakerCheckerFieldsBO;
import com.xpense.commons.bo.MasterFieldsBO;

public abstract class AbstractCommand<TBO> implements Command{

	protected Session session;
	protected TBO tbo;
	
	public AbstractCommand() {
		super();
	}
	
	public void execute(String action){
		if(tbo instanceof MasterFieldsBO){
			MasterFieldsBO fieldsBO = (MasterFieldsBO)tbo;
			fieldsBO.setActive(true);
			fieldsBO.setEnabled(true);
			fieldsBO.setEffectiveFrom(new Date());
			fieldsBO.setEffectiveTill(null);
		}
		
		if(tbo instanceof MakerCheckerFieldsBO){
			
			MakerCheckerFieldsBO fieldsBO = (MakerCheckerFieldsBO)tbo;
			fieldsBO.setLastStatus(action);
			fieldsBO.setCreatedBy("System");
			fieldsBO.setCreatedDate(new Date());
			fieldsBO.setModifiedBy(null);
			fieldsBO.setModifiedDate(null);
		}
	}
	
	public AbstractCommand(Session session,TBO tbo) {
		super();
		this.session = session;
		this.tbo = tbo;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}

	public TBO getTbo() {
		return tbo;
	}

	public void setTbo(TBO tbo) {
		this.tbo = tbo;
	}

}
