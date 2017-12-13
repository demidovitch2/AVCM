package repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Arbitro;

public class ArbitroRepository {

	@Inject
	Arbitro arbitro;

	private EntityManager entityManager;

	public ArbitroRepository() {

	}

	@Inject
	public ArbitroRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void salvarArbitro(Arbitro arbitro) {
		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();
		entityManager.persist(arbitro);
		tx.commit();
	}

}
