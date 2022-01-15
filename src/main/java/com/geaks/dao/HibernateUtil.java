package com.geaks.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	private HibernateUtil() {

	}

	public static SessionFactory getInstance() {
		Configuration configuration = new Configuration().configure();
		configuration.configure("hibernate.cfg.xml");

		if (sessionFactory == null) {
			sessionFactory = configuration.buildSessionFactory();
		}

		return sessionFactory;
	}
}
