package br.com.testehibernate.dados.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionFactoryUtil {

	private static AnnotationConfiguration acfg;
	private static SessionFactory sessionFactory;
	private static Session session;
	
	static {
		acfg = new AnnotationConfiguration();
		acfg.configure();
		
		sessionFactory = acfg.buildSessionFactory();
	}
	
	public static Session getSession() {
		session = sessionFactory.openSession();
		
		return session;
	}
}
