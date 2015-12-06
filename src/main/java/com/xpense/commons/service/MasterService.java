package com.xpense.commons.service;

public class MasterService<TBO,TDTO> extends MakerCheckerService<TBO, TDTO>{

	public MasterService() {
		super();
	}
	
	public MasterService(Class<TBO> clazz) {
		super(clazz);
	}
	

	/**
	 * 1.Enable
	 * 2.Disable
	 */
}
