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
