package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "tb_utilizador")
@Entity
@NamedQuery(name = "Utilizador.findUser", query = "SELECT u FROM Utilizador u WHERE u.utilizador = :utilizador AND u.senha = :senha")
public class Utilizador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_usuario")
	private String id;

	@Column(name = "ds_login")
	private String utilizador;

	@Column(name = "ds_senha")
	private String senha;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(String usuario) {
		this.utilizador = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
