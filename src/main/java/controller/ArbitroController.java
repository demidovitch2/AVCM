package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Arbitro;
import model.Pessoa;
import repository.ArbitroRepository;
import repository.PessoaRepository;
import util.Uteis;

@Named(value = "arbitroController")
@RequestScoped
public class ArbitroController {

	@Inject
	UtilizadorController usuarioController;

	private Arbitro arbitro = new Arbitro();
	private Pessoa pessoa = new Pessoa();

	@Inject
	ArbitroRepository arbitroRepository;

	@Inject
	PessoaRepository pessoaRepository;

	public Arbitro getArbitro() {
		return arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void salvarNovoArbitro() {

		pessoa.setUtilizador(this.usuarioController.GetUtilizadorSession());

		pessoaRepository.SalvarPessoa(pessoa);

		arbitro.setPessoa(pessoa);

		arbitroRepository.salvarArbitro(arbitro);

		arbitro = new Arbitro();
		pessoa = new Pessoa();

		Uteis.MensagemInfo("Árbitro Cadastrado com Sucesso");

	}

}
