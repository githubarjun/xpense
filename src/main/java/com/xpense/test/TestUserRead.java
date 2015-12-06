package com.xpense.test;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.hibernate.Session;

import com.xpense.HibernateSessionFactory;
import com.xpense.master.bo.UserBO;

public class TestUserRead {

	public static void main(String[] a){
		
		Session session = HibernateSessionFactory.getSession();
		
		session.beginTransaction();
		
		UserBO user = (UserBO)session.get(UserBO.class, new Long(7));
		
		System.out.println(user);
		System.out.println(Integer.MAX_VALUE);
		try{
			FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Arjun\\Desktop\\LP.jpg");
			InputStream inputStream = user.getUserImage().getBinaryStream();
			byte[] chunk = new byte[128];
			while(inputStream.read(chunk) != -1){
				fileOutputStream.write(chunk);
			}
			
			//fileOutputStream.write(user.getUserImage());
			//fileOutputStream.write(user.getUserImage().getBinaryStream());
			//BufferedOutputStream outputStream = null;
			//Hibernate.
			fileOutputStream.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

		
		session.beginTransaction().commit();
		System.out.println("Done...");
	}
}
