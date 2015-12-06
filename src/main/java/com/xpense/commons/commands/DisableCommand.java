package com.xpense.commons.commands;

import org.hibernate.Session;

import com.xpense.commons.dao.CommonsDAO;

public class DisableCommand<TBO> extends AbstractCommand<TBO>{

	public static String ACTION = "create";
	public DisableCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DisableCommand(Session session, TBO tbo) {
		super(session,tbo);
	}

	@Override
	public void execute() {
		CommonsDAO<TBO> commonsDAO = new CommonsDAO<TBO>(session,(Class<TBO>)tbo.getClass());
		commonsDAO.update(tbo);
	}

}
