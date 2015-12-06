package com.xpense.commons.commands;

import org.hibernate.Session;

import com.xpense.commons.dao.CommonsDAO;

public class CreateCommand<TBO> extends AbstractCommand<TBO>{
	
	public static String ACTION = "create";
	public CreateCommand() {
		super();
	}
	
	public CreateCommand(Session session, TBO tbo) {
		super(session,tbo);
	}

	@Override
	public void execute() {
		//execute(ACTION);
		CommonsDAO<TBO> commonsDAO = new CommonsDAO<TBO>(session,(Class<TBO>)tbo.getClass());
		commonsDAO.save(tbo);
	}
	
}
