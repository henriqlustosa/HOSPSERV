package hspm.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import hspm.clinica.Clinica;
import hspm.clinica.ClinicaDAOOpenbase;

@ManagedBean(name = "clinicaBean")
@RequestScoped
public class ClinicaBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String descricao;
	
	
	public List<Clinica> listaClinicas(){
	     List<Clinica> lista;
	     lista = new ClinicaDAOOpenbase().listarClinicas();//Carrega a lista do Banco de dados
	     return lista;
	}
	
	
	public String getCodigo() {
		
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
