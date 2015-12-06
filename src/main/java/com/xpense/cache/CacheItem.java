package com.xpense.cache;

public class CacheItem {
	
	private String module;
	private String key;
	private Object value;

	public CacheItem(String module, String key, Object value) {
		super();
		this.module = module;
		this.key = key;
		this.value = value;
	}
	public CacheItem() {
		super();
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}

}