package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_equipe")
@Entity
public class EquipeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_equipe")
	private Integer id;
	private String nome;
	private String codigo;
	private TreinadorEntity treinador;
	private String medico;
	private String fisioterapeuta;
	private TreinadorEntity treinadorAdjunto;
	private String presidente;
	private String Delegado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public TreinadorEntity getTreinador() {
		return treinador;
	}

	public void setTreinador(TreinadorEntity treinador) {
		this.treinador = treinador;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getFisioterapeuta() {
		return fisioterapeuta;
	}

	public void setFisioterapeuta(String fisioterapeuta) {
		this.fisioterapeuta = fisioterapeuta;
	}

	public TreinadorEntity getTreinadorAdjunto() {
		return treinadorAdjunto;
	}

	public void setTreinadorAdjunto(TreinadorEntity treinadorAdjunto) {
		this.treinadorAdjunto = treinadorAdjunto;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public String getDelegado() {
		return Delegado;
	}

	public void setDelegado(String delegado) {
		Delegado = delegado;
	}

}
