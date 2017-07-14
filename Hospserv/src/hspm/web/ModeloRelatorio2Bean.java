package hspm.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hspm.centrocirurgico.modelorelatorio2.ModeloRelatorio2;
import hspm.centrocirurgico.modelorelatorio2.ModeloRelatorio2DAOOpenbase;



@ManagedBean(name = "modeloRelatorioBean2")
@ViewScoped


public class ModeloRelatorio2Bean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer ano;

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	private List<ModeloRelatorio2> relatorioNumero9;
	private List<ModeloRelatorio2> relatorioNumero10;



	public List<ModeloRelatorio2> getRelatorioNumero9() {
		return relatorioNumero9;
	}

	public void setRelatorioNumero9(List<ModeloRelatorio2> relatorioNumero9) {
		this.relatorioNumero9 = relatorioNumero9;
	}

	public void popularRelatorioNumero10() {
		setRelatorioNumero10(new ModeloRelatorio2DAOOpenbase().relatorioNumero10(ano));
	}

	public void popularRelatorioNumero9() {
		setRelatorioNumero9(new ModeloRelatorio2DAOOpenbase().relatorioNumero9(ano));
	}

	public List<ModeloRelatorio2> getRelatorioNumero10() {
		return relatorioNumero10;
	}

	public void setRelatorioNumero10(List<ModeloRelatorio2> relatorioNumero10) {
		this.relatorioNumero10 = relatorioNumero10;
	}

	

}
