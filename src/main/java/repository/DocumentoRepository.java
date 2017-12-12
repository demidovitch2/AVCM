package repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Documento;

public class DocumentoRepository {

	@Inject
	Documento documento;

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
	public void SalvarDocumento(Documento documento) {

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();

		entityManager.persist(documento);

		tx.commit();
	}

}
