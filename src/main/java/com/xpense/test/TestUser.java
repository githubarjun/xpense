package com.xpense.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.xpense.HibernateSessionFactory;
import com.xpense.master.bo.UserBO;

public class TestUser {

	public static void main(String[] a){
		
		/*try{
			System.out.println(getImage().length);
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		Session session = null;
		
		try{
			session = HibernateSessionFactory.getSession();
			
			session.beginTransaction();
			
			UserBO user = new UserBO();
			user.setVersion(0);
			
			user.setUserName("Arjunp");
			user.setPassword("gunsnroses");
			//user.setUserImage(getImage());
			user.setUserImage(getBlobImage());
			
			session.save(user);
			
			session.beginTransaction().commit();
			System.out.println("Done....");
		}catch (Exception e) {
			e.printStackTrace();
			session.beginTransaction().rollback();
		}
	}
	
	public static byte[] getImage()throws IOException{
		
		File file = new File("C:\\Users\\Arjun\\Desktop\\liverpool.jpg");
		byte[] imageBytes = null;
		if(file != null && file.exists()){
			
			imageBytes = new byte[(int)file.length()];
			
			FileInputStream inputStream = new FileInputStream(file);
			inputStream.read(imageBytes);
			
			//System.out.println(imageBytes);
			
		}
		
		return imageBytes;
	}
	
	public static Blob getBlobImage()throws IOException{
		
		File file = new File("C:\\Users\\Arjun\\Desktop\\rrr.jpg");
		Blob blob = null;
		if(file != null && file.exists()){
			FileInputStream inputStream = new FileInputStream(file);
			blob = Hibernate.createBlob(inputStream);
		}
		
		return blob;
	}
	
	
}
