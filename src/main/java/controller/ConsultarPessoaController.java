package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.PessoaEntity;
import repository.PessoaRepository;

@Named(value = "consultarPessoaController")
@ViewScoped
public class ConsultarPessoaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	transient private PessoaEntity pessoaModel;

	@Produces
	private List<PessoaEntity> pessoas;

	@Inject
	transient private PessoaRepository pessoaRepository;

	public List<PessoaEntity> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<PessoaEntity> pessoas) {
		this.pessoas = pessoas;
	}

	public PessoaEntity getPessoa() {
		return pessoaModel;
	}

	public void setPessoa(PessoaEntity pessoaModel) {
		this.pessoaModel = pessoaModel;
	}

	/***
	 * CARREGA AS PESSOAS NA INICIALIZAÇÃO
	 */
	@PostConstruct
	public void init() {

		// RETORNAR AS PESSOAS CADASTRADAS
		this.pessoas = pessoaRepository.getPessoas();
	}
}
