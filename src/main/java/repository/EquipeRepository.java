package repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.EquipeEntity;

public class EquipeRepository {

	@Inject
	EquipeEntity entity;

	private EntityManager entityManager;

	public EquipeRepository() {

	}

	@Inject
	public EquipeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void salvarEquipe(EquipeEntity entity) {

		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(entity);
		tx.commit();
	}

}
