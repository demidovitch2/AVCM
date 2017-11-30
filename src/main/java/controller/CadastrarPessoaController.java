package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.DocumentoEntity;
import entity.PessoaEntity;
import repository.PessoaRepository;
import util.Uteis;

@Named(value = "cadastrarPessoaController")
@RequestScoped
public class CadastrarPessoaController {

	private PessoaEntity pessoa = new PessoaEntity();
	private DocumentoEntity documento = new DocumentoEntity();

	@Inject
	private UsuarioController usuarioController;

	@Inject
	PessoaRepository pessoaRepository;

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa = pessoa;
	}

	public DocumentoEntity getDocumento() {
		return documento;
	}

	public void setDocumento(DocumentoEntity documento) {
		this.documento = documento;
	}

	/**
	 * 
	 */
	public void SalvarNovaPessoa() {
		pessoa.setUsuarioEntity(this.usuarioController.GetUsuarioSession());

		// pessoa.setDocumento(documento);

		pessoaRepository.SalvarPessoa(pessoa);

		this.pessoa = new PessoaEntity();
		this.documento = new DocumentoEntity();

		Uteis.MensagemInfo("Pessoa Cadastrada com Sucesso");
	}

}
