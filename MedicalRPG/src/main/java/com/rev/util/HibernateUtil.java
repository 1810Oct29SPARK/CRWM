package com.rev.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory(){
		if(HibernateUtil.sessionFactory == null)
		{
			Configuration c = new Configuration();
			c.setProperty("hibernate.connection.username", System.getenv("MedGame_DB_Username"));
			c.setProperty("hibernate.connection.password", System.getenv("MedGame_DB_Password"));
			c.setProperty("hibernate.connection.url", System.getenv("MedGame_DB_Url"));
			c.configure();
			HibernateUtil.sessionFactory = c.buildSessionFactory();
		}
		return HibernateUtil.sessionFactory;
	}

}

//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class HibernateUtil {
//
//	private static SessionFactory mainSessionFactory;
//	private static SessionFactory testSessionFactory;
//
//	public static SessionFactory getSessionFactory() {
//
//		if (HibernateUtil.mainSessionFactory == null) {
//			Properties props = new Properties();
//			ClassLoader cl = Thread.currentThread().getContextClassLoader();
//			try (InputStream in = cl.getResourceAsStream("hibernate.connection.main.properties")) {
//				props.load(in);
//				Configuration config = new Configuration();
//				config.configure("hibernate.cfg.xml");
//				config.addProperties(props);
//				HibernateUtil.mainSessionFactory = config.buildSessionFactory();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return HibernateUtil.mainSessionFactory;
//
//	}