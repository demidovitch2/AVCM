package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import model.Utilizador;
import repository.UtilizadorRepository;
import util.Uteis;

@Named(value = "utilizadorController")
@SessionScoped
public class UtilizadorController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Utilizador usuarioModel = new Utilizador();

	@Inject
	private UtilizadorRepository usuarioRepository;

	@Inject
	private Utilizador utilizador;

	public Utilizador getUsuarioModel() {
		return usuarioModel;
	}

	public void setUsuarioModel(Utilizador usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
	
	public Utilizador getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}

	public Utilizador GetUtilizadorSession() {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		return (Utilizador) facesContext.getExternalContext().getSessionMap().get("usuarioAutenticado");
	}

	public String Logout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "/index.xhtml?faces-redirect=true";
	}

	public String EfetuarLogin() {

		if (StringUtils.isEmpty(usuarioModel.getUtilizador()) || StringUtils.isBlank(usuarioModel.getUtilizador())) {

			Uteis.Mensagem("Favor informar o login!");
			return null;
		} else if (StringUtils.isEmpty(usuarioModel.getSenha()) || StringUtils.isBlank(usuarioModel.getSenha())) {

			Uteis.Mensagem("Favor informara senha!");
			return null;
		} else {

			utilizador = usuarioRepository.ValidaUsuario(usuarioModel);

			if (utilizador != null) {

				usuarioModel.setSenha(null);
				usuarioModel.setId(utilizador.getId());

				FacesContext facesContext = FacesContext.getCurrentInstance();

				facesContext.getExternalContext().getSessionMap().put("usuarioAutenticado", usuarioModel);

				return "sistema/home?faces-redirect=true";
			} else {

				Uteis.Mensagem("Não foi possível efetuar o login com esse usuário e senha!");
				return null;
			}
		}

	}

}