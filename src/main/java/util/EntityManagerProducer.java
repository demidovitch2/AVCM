package util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {

	private EntityManagerFactory factory;

	public EntityManagerProducer() {

		factory = Persistence.createEntityManagerFactory("AVCM");
	}

	@Produces
	@RequestScoped
	public EntityManager cEntityManager() {
		return factory.createEntityManager();
	}

	public void closeEM(@Disposes EntityManager manager) {
		manager.close();
	}

}
