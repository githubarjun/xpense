package com.xpense.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.print("Inside sessionCreated");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.print("Inside sessionDestroyed");
		se.getSession().setAttribute("Ticket", null);
	}

	
	
}
