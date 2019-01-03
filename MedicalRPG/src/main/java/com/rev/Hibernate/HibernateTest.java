package com.rev.Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	
	private static SessionFactory sesFac;
	

	public static SessionFactory getSession()
	{
		if(HibernateTest.sesFac == null)
		{
			Configuration config = new Configuration();
			config.setProperty("hibernate.connection.username", System.getenv("BEARS_DB_USERNAME"));
			config.setProperty("hibernate.connection.password", System.getenv("BEARS_DB_PASS"));
			config.setProperty("hibernate.connection.url", System.getenv("BEARS_DB_URL"));
			config.configure();			
			HibernateTest.sesFac = config.buildSessionFactory();
		}
		return HibernateTest.sesFac;
	}
}
