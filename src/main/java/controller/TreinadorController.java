package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Pessoa;
import model.Treinador;
import repository.PessoaRepository;
import repository.TreinadorRepository;
import util.Uteis;

@Named(value = "treinadorController")
@RequestScoped
public class TreinadorController {

	private Treinador treinador = new Treinador();
	private Pessoa pessoa = new Pessoa();
	
	public Treinador getTreinador() {
		return treinador;
	}

	public void setTreinador(Treinador treinador) {
		this.treinador = treinador;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Inject
	UtilizadorController usuarioController;

	@Inject
	PessoaRepository pessoaRepository;

	@Inject
	TreinadorRepository treinadorRepository;

	public void salvarNovoTreinador() {

		pessoa.setUtilizador(this.usuarioController.GetUtilizadorSession());

		pessoaRepository.SalvarPessoa(pessoa);

		treinador.setPessoa(pessoa);

		treinadorRepository.salvarTreinador(treinador);

		treinador = new Treinador();

		pessoa = new Pessoa();

		Uteis.MensagemInfo("Treinador Cadastrado com Sucesso");
	}

}
