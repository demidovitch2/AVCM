package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tb_documento")
@Entity	
public class DocumentoEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_documento")
	private Integer id;
    private String numero;
    private String tipo;
    private String estadoDcumento;
    private Date dataEmissao;
    private Date dataValidade;
    private String fotoFrontalPath;
    private String fotoTraseiraPath;
    private byte[] fotoFrontal;
    private byte[] fotoTraseira;
    private String localEmissao;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstadoDcumento() {
        return estadoDcumento;
    }

    public void setEstadoDcumento(String estadoDcumento) {
        this.estadoDcumento = estadoDcumento;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getFotoFrontalPath() {
        return fotoFrontalPath;
    }

    public void setFotoFrontalPath(String fotoFrontalPath) {
        this.fotoFrontalPath = fotoFrontalPath;
    }

    public String getFotoTraseiraPath() {
        return fotoTraseiraPath;
    }

    public void setFotoTraseiraPath(String fotoTraseiraPath) {
        this.fotoTraseiraPath = fotoTraseiraPath;
    }

    public byte[] getFotoFrontal() {
        return fotoFrontal;
    }

    public void setFotoFrontal(byte[] fotoFrontal) {
        this.fotoFrontal = fotoFrontal;
    }

    public byte[] getFotoTraseira() {
        return fotoTraseira;
    }

    public void setFotoTraseira(byte[] fotoTraseira) {
        this.fotoTraseira = fotoTraseira;
    }

    public String getLocalEmissao() {
        return localEmissao;
    }

    public void setLocalEmissao(String localEmissao) {
        this.localEmissao = localEmissao;
    }

}
