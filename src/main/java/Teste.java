import javax.persistence.EntityManager;

import util.JpaUtil;
import util.Uteis;

public class Teste {

	public static void main(String[] args) {
		EntityManager entityManager = JpaUtil.getEntityManager();
	}

}
