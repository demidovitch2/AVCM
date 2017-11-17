package model;

import java.io.Serializable;

public class AtletaModel implements Serializable {
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private Integer id;
	    private Pessoa pessoa;
	    private String posicao;
	    private String escalao;
	    private double altura;
	    private double peso;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Pessoa getPessoa() {
			return pessoa;
		}

		public void setPessoa(Pessoa pessoa) {
			this.pessoa = pessoa;
		}

		public String getPosicao() {
			return posicao;
		}

		public void setPosicao(String posicao) {
			this.posicao = posicao;
		}

		public String getEscalao() {
			return escalao;
		}

		public void setEscalao(String escalao) {
			this.escalao = escalao;
		}

		public double getAltura() {
			return altura;
		}

		public void setAltura(double altura) {
			this.altura = altura;
		}

		public double getPeso() {
			return peso;
		}

		public void setPeso(double peso) {
			this.peso = peso;
		}

	    
}
