package com.rev.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Util used to make a single sessionfactory to be referenced by other classes
 * @author Darius
 *
 */
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