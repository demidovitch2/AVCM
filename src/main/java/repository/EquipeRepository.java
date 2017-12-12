package repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Equipe;
import util.Uteis;

public class EquipeRepository {

	@Inject
	Equipe equipe;

	private EntityManager entityManager;

	public EquipeRepository() {

	}

	@Inject
	public EquipeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void salvarEquipe(Equipe equipe) {

		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(equipe);
		tx.commit();
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Equipe> getEquipes() {
		// TODO Auto-generated method stub

		List<Equipe> equipes = new ArrayList<Equipe>();
		entityManager = Uteis.JpaEntityManager();

		TypedQuery<Equipe> query = entityManager.createNamedQuery("Equipe.findAll", Equipe.class);

		equipes = query.getResultList();

		return equipes;
	}

}
