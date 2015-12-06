package com.xpense.commons.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class CommonsDAO<TBO> {

	Session session;
	Class<TBO> clazz;
	
	public CommonsDAO() {
		super();
	}
	
	public CommonsDAO(Session session, Class<TBO> clazz) {
		super();
		this.session = session;
		this.clazz = clazz;
	}

	public void save(TBO tbo){
		session.save(tbo);
	}
	
	public void update(TBO tbo){
		session.saveOrUpdate(tbo);
	}
	
	public void delete(TBO tbo){
		session.delete(tbo);
	}
	
	public List<TBO> findBySpec(String specification) throws Exception{
		
		Query query = null;
		List<TBO> list = new ArrayList<TBO>();
		String strQuery = null;
		if(specification != null && "".equals(specification)){
			strQuery = "from "+clazz.getName()+" where 1=1";
		}else if(specification != null && !"".equals(specification)){
			strQuery = "from "+clazz.getName()+" where "+specification;
		}else{
			return null;
		}
		try{
			query = session.createQuery(strQuery);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	public TBO findById(Long id){
		TBO tbo = null;
		try{
			tbo = (TBO) session.get(clazz, id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tbo;
	}
	
	public List<Object[]> getProjectionById(String specification, String projection) throws Exception{
		Query query = null;
		List<Object[]> list = null;
		try{
			query = session.createQuery("select "+projection+" from "+clazz.getName()+" where "+specification);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return list;
	}
}
