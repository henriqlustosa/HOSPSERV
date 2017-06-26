package hspm.profissional;

import java.io.Serializable;

public class Profissional implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cpf;
	private Integer matricula;
	private String nome;
	private String cr;
	private String nomeGuerra;
	private String telefone;
	private String codOcupacao;
	private String atuacao;
	private String codAtividade;
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCr() {
		return cr;
	}
	public void setCr(String cr) {
		this.cr = cr;
	}
	public String getNomeGuerra() {
		return nomeGuerra;
	}
	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCodOcupacao() {
		return codOcupacao;
	}
	public void setCodOcupacao(String codOcupacao) {
		this.codOcupacao = codOcupacao;
	}
	public String getAtuacao() {
		return atuacao;
	}
	public void setAtuacao(String atuacao) {
		this.atuacao = atuacao;
	}
	public String getCodAtividade() {
		return codAtividade;
	}
	public void setCodAtividade(String codAtividade) {
		this.codAtividade = codAtividade;
	}
	
	
}
