package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Pessoa;
import repository.PessoaRepository;
import util.Uteis;

@Named(value="cadastrarPessoaController")
@RequestScoped
public class CadastrarPessoaController {
	
	@Inject
	Pessoa pessoa;
	
	@Inject
	UsuarioController usuarioController;
	
	@Inject
	PessoaRepository pessoaRepository;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public void SalvarNovaPessoa(){
		pessoa.setUsuarioModel(this.usuarioController.GetUsuarioSession());
		
		pessoaRepository.SalvarPessoa(pessoa);
		
		this.pessoa= null;
		
		Uteis.MensagemInfo("Pessoa Cadastrada com Sucesso");
	}

}
