package com.xpense.cache;

public class CacheTest {

	public static void main(String[] args) {
		
		XpenseCache cache = XpenseCache.getInstance();
		Subject s1 = new Subject(cache,"User","1","arjun");
		s1.start();
		//fails for new String("User");
		//TODO
		Subject s2 = new Subject(cache,new String("User"),"2","arjun");
		s2.start();
		
	}

}

class Subject extends Thread{
	
	XpenseCache cache;
	String module;
	String key;
	String value;
	
	public Subject(XpenseCache cache, String module,
			String key, String value) {
		this.cache = cache;
		this.module = module;
		this.key = key;
		this.value = value;
	}

	public Subject(){
	}
	
	public XpenseCache getCache() {
		return cache;
	}

	public void setCache(XpenseCache cache) {
		this.cache = cache;
	}
	
	@Override
	public void run() {
		cache.addToCache(module,key,value);
	}
}