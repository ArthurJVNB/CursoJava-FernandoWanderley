package br.com.fwinternetbanking.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateSessionFactory {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	static {
		AnnotationConfiguration acfg = new AnnotationConfiguration();
		acfg.configure();
		
		SessionFactory sessionFactory = acfg.buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	public static Session getSession() {
		if(session==null || !session.isOpen()){
            session = sessionFactory.openSession();
        }
		return session;
	}
}
