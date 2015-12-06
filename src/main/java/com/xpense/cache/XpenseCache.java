package com.xpense.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XpenseCache {

	private static XpenseCache cache = new XpenseCache();
	private ConcurrentHashMap<String, Map<String, CacheItem>> cacheMap = new ConcurrentHashMap<String, Map<String,CacheItem>>();
	
	private XpenseCache(){
	}

	public static XpenseCache getInstance(){
		return cache; 
	}
	
	public void addToCache(final String module,String key,String value){
		CacheItem cacheItem= new CacheItem(module, key, value);
		Map<String,CacheItem> hashMap = null;

		synchronized(module){
			if(cacheMap.get(module) == null){
				//hashMap =  Collections.synchronizedMap(new HashMap<String, CacheItem>());
				hashMap =  new HashMap<String, CacheItem>();
				hashMap.put(key, cacheItem);
				cacheMap.put(module, hashMap);
			}else{
				hashMap = cacheMap.get(module);
				hashMap.put(key, cacheItem);
			}
		}
	}
	
	public Object getFromCache(String module,String key){
		Map<String,CacheItem> hashMap = cacheMap.get(module);
		if(hashMap == null){
			return null;
		}else{
			CacheItem cacheItem = hashMap.get(key);
			return cacheItem.getValue();
		}
	}
	
}