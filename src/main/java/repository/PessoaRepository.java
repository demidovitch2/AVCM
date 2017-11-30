package repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entity.DocumentoEntity;
import entity.PessoaEntity;
import entity.UsuarioEntity;
import util.Uteis;

public class PessoaRepository {

	@Inject
	PessoaEntity pessoaEntity;

	@Inject
	DocumentoEntity documentoEntity;

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
	public void SalvarPessoa(PessoaEntity pessoa) {
		
		UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, pessoa.getUsuarioEntity().getId());
		pessoaEntity.setUsuarioEntity(usuarioEntity);

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();
		entityManager.persist(pessoaEntity);

		tx.commit();
	}
	

	/**
	 * 
	 * @return
	 */
	public List<PessoaEntity> getPessoas() {
		// TODO Auto-generated method stub

		List<PessoaEntity> pessoas = new ArrayList<PessoaEntity>();
		entityManager = Uteis.JpaEntityManager();

		TypedQuery<PessoaEntity> query = entityManager.createNamedQuery("PessoaEntity.findAll", PessoaEntity.class);

		pessoas = query.getResultList();

		return pessoas;
	}

}
