package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.AtletaEntity;
import entity.PessoaEntity;
import repository.AtletaRepository;
import util.Uteis;

@Named(value = "atletaController")
@RequestScoped
public class AtletaController {

	private AtletaEntity atletaEntity = new AtletaEntity();
	private PessoaEntity pessoa = new PessoaEntity();

	@Inject
	AtletaRepository atletaRepository;

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

		atletaRepository.salvarAtleta(atletaEntity);

		atletaEntity = new AtletaEntity();
		pessoa = new PessoaEntity();

		Uteis.MensagemInfo("Atleta Cadastrado com Sucesso");
	}
}
