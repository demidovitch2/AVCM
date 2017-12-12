package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Pessoa;
import repository.PessoaRepository;

@Named(value = "consultarPessoaController")
@ViewScoped
public class ConsultarPessoaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	transient private Pessoa pessoaModel;

	@Produces
	private List<Pessoa> pessoas;

	@Inject
	transient private PessoaRepository pessoaRepository;

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoa() {
		return pessoaModel;
	}

	public void setPessoa(Pessoa pessoaModel) {
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
