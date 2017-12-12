package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Equipe;
import model.Treinador;
import repository.EquipeRepository;
import repository.TreinadorRepository;
import util.Uteis;

@Named(value = "equipeController")
@RequestScoped
public class EquipeController {

	private Equipe equipe = new Equipe();
	private List<Treinador> treinadores;

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public List<Treinador> getTreinadores() {
		return treinadores;
	}

	public void setTreinadores(List<Treinador> treinadores) {
		this.treinadores = treinadores;
	}

	@Inject
	EquipeRepository equipeRepository;

	@Inject
	TreinadorRepository treinadorRepository;

	public void salvarNovaEquipe() {

		equipeRepository.salvarEquipe(equipe);

		equipe = new Equipe();

		Uteis.MensagemInfo("Equipe Cadastrada com Sucesso");
	}

	/***
	 * CARREGA oS Treinadores NA INICIALIZAÇÃO
	 */
	@PostConstruct
	public void init() {

		// RETORNAR AS EQUIPES CADASTRADAS
		this.treinadores = treinadorRepository.getTreinadores();
	}

}
