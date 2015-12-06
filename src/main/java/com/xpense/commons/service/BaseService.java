package com.xpense.commons.service;

public class BaseService<TBO,TDTO> {

	protected Class<TBO> boClazz;
	
	public BaseService() {
		super();
	}

	public BaseService(Class<TBO> clazz) {
		super();
		this.boClazz = clazz;
	}

}
