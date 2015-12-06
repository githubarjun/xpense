package com.xpense.bootstrap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.xpense.login.Ticket;

public class Main {

	private Map<String, Object> cache = new ConcurrentHashMap<String, Object>();
	private static Main main = new Main();
	private Map<String, Ticket> ticketMap = new LinkedHashMap<String, Ticket>();
	
	private Main(){
		
	}
	
	public synchronized static Main getInstance(){
		return main;
	}
	
	public void addToCache(String key, String value){
		cache.put(key, value);
	}
	
	public Object getFromCache(String key){
		return cache.get(key);
	}
	
	public void addTicket(String user,Ticket ticket){
		ticketMap.put(user, ticket);
	}
	
	public Ticket getTicket(String user){
		return ticketMap.get(user);
	}
}
