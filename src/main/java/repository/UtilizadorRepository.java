package repository;

import java.io.Serializable;

import javax.persistence.Query;

import model.Utilizador;
import util.Uteis;

public class UtilizadorRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	public Utilizador ValidaUsuario(Utilizador utilizador) {

		try {

			// QUERY QUE VAI SER EXECUTADA (UsuarioEntity.findUser)
			Query query = Uteis.JpaEntityManager().createNamedQuery("Utilizador.findUser");

			// PARÂMETROS DA QUERY
			query.setParameter("utilizador", utilizador.getUtilizador());
			query.setParameter("senha", utilizador.getSenha());

			// RETORNA O USUÁRIO SE FOR LOCALIZADO
			return (Utilizador) query.getSingleResult();

		} catch (Exception e) {

			return null;
		}

	}
}