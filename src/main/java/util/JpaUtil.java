package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static final EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("AVCM");
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
