package repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.AtletaEntity;
import entity.PessoaEntity;

public class AtletaRepository {

	@Inject
	AtletaEntity atletaEntity;

	@Inject
	PessoaEntity pessoaEntity;

	private EntityManager entityManager;

	public AtletaRepository() {

	}

	@Inject
	public AtletaRepository(EntityManager manager) {
		this.entityManager = manager;

	}

	public void salvarAtleta(AtletaEntity atletaEntity) {

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();
		entityManager.persist(atletaEntity);
		tx.commit();
	}

}
