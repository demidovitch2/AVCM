package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.AtletaEntity;
import entity.PessoaEntity;
import repository.AtletaRepository;
import repository.PessoaRepository;
import util.Uteis;

@Named(value = "atletaController")
@RequestScoped
public class AtletaController {

	private AtletaEntity atletaEntity = new AtletaEntity();
	private PessoaEntity pessoa = new PessoaEntity();

	@Inject
	UsuarioController usuarioController;

	@Inject
	AtletaRepository atletaRepository;

	@Inject
	PessoaRepository pessoaRepository;

	public AtletaEntity getAtletaEntity() {
		return atletaEntity;
	}

	public void setAtletaEntity(AtletaEntity atletaEntity) {
		this.atletaEntity = atletaEntity;
	}

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoaEntity) {
		this.pessoa = pessoaEntity;
	}

	public void salvarNovoAtleta() {

		pessoa.setUsuarioEntity(this.usuarioController.GetUsuarioSession());

		pessoaRepository.SalvarPessoa(pessoa);

		atletaEntity.setPessoa(pessoa);

		atletaRepository.salvarAtleta(atletaEntity);

		atletaEntity = new AtletaEntity();

		pessoa = new PessoaEntity();

		Uteis.MensagemInfo("Atleta Cadastrado com Sucesso");
	}
}
