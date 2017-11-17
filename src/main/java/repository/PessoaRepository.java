package repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.PessoaEntity;
import entity.UsuarioEntity;
import model.Pessoa;
import model.UsuarioModel;
import util.Uteis;

public class PessoaRepository {

	@Inject
	PessoaEntity pessoaEntity;

	EntityManager entityManager;

	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVA PESSOA
	 * 
	 * @param pessoa
	 */
	public void SalvarPessoa(Pessoa pessoa) {

		entityManager = Uteis.JpaEntityManager();

		pessoaEntity = new PessoaEntity();
		pessoaEntity.setId(pessoa.getId());
		pessoaEntity.setNome(pessoa.getNome());
		pessoaEntity.setApelido(pessoa.getApelido());
		pessoaEntity.setGenero(pessoa.getGenero());
		pessoaEntity.setDataNascimento(pessoa.getDataNascimento());
		pessoaEntity.setNomeMae(pessoa.getNomeMae());
		pessoaEntity.setNomePai(pessoa.getNomePai());
		pessoaEntity.setNacionalidade(pessoa.getNacionalidade());
		pessoaEntity.setNaturalidade(pessoa.getNaturalidade());
		pessoaEntity.setEstadoCivil(pessoa.getEstadoCivil());
		pessoaEntity.setEndereco(pessoa.getEndereco());
		pessoaEntity.setTelefone(pessoa.getTelefone());
		pessoaEntity.setCelular(pessoa.getCelular());
		pessoaEntity.setEmail(pessoa.getEmail());
		pessoaEntity.setNuit(pessoa.getNuit());
		pessoaEntity.setImagem(pessoa.getImagem());
		pessoaEntity.setImagemPath(pessoa.getImagemPath());

		UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, pessoa.getUsuarioModel().getId());

		pessoaEntity.setUsuarioEntity(usuarioEntity);

		entityManager.persist(pessoaEntity);
	}

	public List<Pessoa> getPessoas() {
		// TODO Auto-generated method stub

		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		entityManager = Uteis.JpaEntityManager();

		Query query = entityManager.createNamedQuery("PessoaEntity.findAll");

		@SuppressWarnings("unchecked")
		Collection<PessoaEntity> pessoasEntity = (Collection<PessoaEntity>) query.getResultList();

		Pessoa pessoa = null;

		for (PessoaEntity pessoaEntity : pessoasEntity) {

			pessoa = new Pessoa();
			pessoa.setId(pessoaEntity.getId());
			pessoa.setNome(pessoaEntity.getNome());
			pessoa.setApelido(pessoaEntity.getApelido());
			pessoa.setGenero(pessoaEntity.getGenero());
			pessoa.setDataNascimento(pessoaEntity.getDataNascimento());
			pessoa.setEndereco(pessoaEntity.getEndereco());
			pessoa.setCelular(pessoaEntity.getCelular());
			pessoa.setEmail(pessoaEntity.getEmail());

			if (pessoaEntity.getGenero().equals("M"))
				pessoa.setGenero("Masculino");
			else
				pessoa.setGenero("Feminino");

			UsuarioEntity usuarioEntity = pessoaEntity.getUsuarioEntity();

			UsuarioModel usuarioModel = new UsuarioModel();
			usuarioModel.setUsuario(usuarioEntity.getUsuario());

			pessoa.setUsuarioModel(usuarioModel);

			pessoas.add(pessoa);
		}

		return pessoas;
	}

}
