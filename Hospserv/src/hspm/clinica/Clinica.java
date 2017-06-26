package hspm.clinica;

import java.io.Serializable;

public class Clinica implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codClinica;
	private String descricao;
	private String cpfDiretor;
	private String tipo;
	private String grupo;
	private String sexo;
	private String idadeMin;
	private String idadeMax;
	public String getCodClinica() {
		return codClinica;
	}
	public void setCodClinica(String codClinica) {
		this.codClinica = codClinica;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCpfDiretor() {
		return cpfDiretor;
	}
	public void setCpfDiretor(String cpfDiretor) {
		this.cpfDiretor = cpfDiretor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getIdadeMin() {
		return idadeMin;
	}
	public void setIdadeMin(String idadeMin) {
		this.idadeMin = idadeMin;
	}
	public String getIdadeMax() {
		return idadeMax;
	}
	public void setIdadeMax(String idadeMax) {
		this.idadeMax = idadeMax;
	}
	
	
}
