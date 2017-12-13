package repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Treinador;
import util.Uteis;

public class TreinadorRepository {

	@Inject
	Treinador treinador;

	private EntityManager entityManager;

	public TreinadorRepository() {

	}

	@Inject
	public TreinadorRepository(EntityManager manager) {
		this.entityManager = manager;
	}

	public void salvarTreinador(Treinador treinador) {
		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();
		entityManager.persist(treinador);

		tx.commit();
	}

	/**
	 * 
	 * @return Lista de Treinadores
	 */
	public List<Treinador> getTreinadores() {
		// TODO Auto-generated method stub

		List<Treinador> treinadores = new ArrayList<Treinador>();
		entityManager = Uteis.JpaEntityManager();

		TypedQuery<Treinador> query = entityManager.createNamedQuery("Treinador.findAll", Treinador.class);

		treinadores = query.getResultList();

		return treinadores;
	}

	/**
	 * 
	 * @param id
	 * @return Treinador
	 */
	public Treinador findById(Long id) {
		return entityManager.find(Treinador.class, id);
	}

}
