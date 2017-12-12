package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Atleta;
import model.Equipe;
import model.Pessoa;
import repository.AtletaRepository;
import repository.EquipeRepository;
import repository.PessoaRepository;
import util.Uteis;

@Named(value = "atletaController")
@RequestScoped
public class AtletaController {

	private Atleta atleta = new Atleta();
	private Pessoa pessoa = new Pessoa();
	private List<Equipe> equipes = new ArrayList<>();

	@Inject
	UtilizadorController usuarioController;

	@Inject
	AtletaRepository atletaRepository;

	@Inject
	PessoaRepository pessoaRepository;

	@Inject
	EquipeRepository equipeRepository;

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	/***
	 * CARREGA AS PESSOAS NA INICIALIZAÇÃO
	 */
	@PostConstruct
	public void init() {

		// RETORNAR AS EQUIPES CADASTRADAS
		this.equipes = equipeRepository.getEquipes();
	}

	public void salvarNovoAtleta() {

		pessoa.setUtilizador(this.usuarioController.GetUtilizadorSession());

		pessoaRepository.SalvarPessoa(pessoa);

		atleta.setPessoa(pessoa);

		atletaRepository.salvarAtleta(atleta);

		atleta = new Atleta();

		pessoa = new Pessoa();

		Uteis.MensagemInfo("Atleta Cadastrado com Sucesso");
	}
}
