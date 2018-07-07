package com.scp.HibernateCRUD;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utilities {

	private static SessionFactory factory;

	public static SessionFactory getSessionFactory() {
		try {
			if (factory == null)
				factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
		return factory;
	}
}
