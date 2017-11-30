package repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.DocumentoEntity;

public class DocumentoRepository {

	@Inject
	DocumentoEntity documentoEntity;

	private EntityManager entityManager;

	public DocumentoRepository() {
	}

	@Inject
	public DocumentoRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UM NOVO DOCUMENTO
	 * 
	 * @param documento
	 */
	public void SalvarDocumento(DocumentoEntity documento) {

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();

		entityManager.persist(documentoEntity);

		tx.commit();
	}

}
