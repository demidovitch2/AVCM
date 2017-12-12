package repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Atleta;

public class AtletaRepository {

	@Inject
	Atleta atleta;

	private EntityManager entityManager;

	public AtletaRepository() {

	}

	@Inject
	public AtletaRepository(EntityManager manager) {
		this.entityManager = manager;

	}

	public void salvarAtleta(Atleta atleta) {

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();
		entityManager.persist(atleta);
		tx.commit();
	}

}
