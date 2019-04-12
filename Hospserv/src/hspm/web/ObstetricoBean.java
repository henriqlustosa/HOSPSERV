package hspm.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hspm.centrocirurgico.cirurgia.Cirurgia;
import hspm.centrocirurgico.cirurgia.CirurgiaDAOOpenbase;

@ManagedBean(name = "obstetricoBean")
@ViewScoped
public class ObstetricoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer ano;
	private Cirurgia cirurgia;
	private List<Cirurgia> listaRealizadaCID;
	

	private List<Cirurgia> relatorioNumero5;
	
	public void cirurgiasRealizadasCID(){
		setRelatorioNumero5(new CirurgiaDAOOpenbase().listaCirurgiasRealizadasCID(ano));
	}
	
	
	
/* Getters and Setters */
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Cirurgia getCirurgia() {
		return cirurgia;
	}

	public void setCirurgia(Cirurgia cirurgia) {
		this.cirurgia = cirurgia;
	}

	public List<Cirurgia> getListaRealizadaCID() {
		return listaRealizadaCID;
	}

	public void setListaRealizadaCID(List<Cirurgia> listaRealizadaCID) {
		this.listaRealizadaCID = listaRealizadaCID;
	}



	public List<Cirurgia> getRelatorioNumero5() {
		return relatorioNumero5;
	}



	public void setRelatorioNumero5(List<Cirurgia> relatorioNumero5) {
		this.relatorioNumero5 = relatorioNumero5;
	}

}
