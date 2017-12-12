package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Documento;
import model.Pessoa;
import repository.PessoaRepository;
import util.Uteis;

@Named(value = "cadastrarPessoaController")
@RequestScoped
public class CadastrarPessoaController {

	private Pessoa pessoa = new Pessoa();
	private Documento documento = new Documento();

	@Inject
	private UtilizadorController usuarioController;

	@Inject
	PessoaRepository pessoaRepository;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	/**
	 * 
	 */
	public void SalvarNovaPessoa() {
		pessoa.setUtilizador(this.usuarioController.GetUtilizadorSession());

		// pessoa.setDocumento(documento);

		pessoaRepository.SalvarPessoa(pessoa);

		this.pessoa = new Pessoa();
		this.documento = new Documento();

		Uteis.MensagemInfo("Pessoa Cadastrada com Sucesso");
	}

}
