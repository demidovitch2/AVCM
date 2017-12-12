package repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Documento;
import model.Pessoa;
import util.Uteis;

public class PessoaRepository {

	@Inject
	Pessoa pessoa;

	@Inject
	Documento documento;

	private EntityManager entityManager;

	public PessoaRepository() {

	}

	@Inject
	public PessoaRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVA PESSOA
	 * 
	 * @param pessoa
	 */
	public void SalvarPessoa(Pessoa pessoa) {

		/*
		 * UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class,
		 * pessoa.getUsuarioEntity().getId());
		 * pessoaEntity.setUsuarioEntity(usuarioEntity);
		 */

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();
		entityManager.persist(pessoa);

		tx.commit();
	}

	/**
	 * 
	 * @return lista de Pessoas
	 */
	public List<Pessoa> getPessoas() {
		// TODO Auto-generated method stub

		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		entityManager = Uteis.JpaEntityManager();

		TypedQuery<Pessoa> query = entityManager.createNamedQuery("Pessoa.findAll", Pessoa.class);

		pessoas = query.getResultList();

		return pessoas;
	}

}
