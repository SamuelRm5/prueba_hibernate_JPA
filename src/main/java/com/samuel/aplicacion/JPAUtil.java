package com.samuel.aplicacion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final String UINIDAD_DE_PERSISTENCIA = "PruebaHibernate";
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if ( factory == null ) {
			factory = Persistence.createEntityManagerFactory(UINIDAD_DE_PERSISTENCIA);
		}
		return factory;
	}
	
	public static void shutdown() {
		if ( factory != null ) {
			factory.close();
			factory = null;
		}
	}

}
