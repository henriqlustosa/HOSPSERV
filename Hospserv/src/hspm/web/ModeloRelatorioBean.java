package hspm.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hspm.centrocirurgico.modelorelatorio.ModeloRelatorio;
import hspm.centrocirurgico.modelorelatorio.ModeloRelatorioDAOOpenbase;

@ManagedBean(name = "modeloRelatorioBean")
@ViewScoped
public class ModeloRelatorioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer ano;

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	private List<ModeloRelatorio> relatorioNumero5;
	private List<ModeloRelatorio> relatorioNumero6;
	private List<ModeloRelatorio> relatorioNumero7;
	private List<ModeloRelatorio> relatorioNumero8;

	public List<ModeloRelatorio> getRelatorioNumero8() {
		return relatorioNumero8;
	}

	public void setRelatorioNumero8(List<ModeloRelatorio> relatorioNumero8) {
		this.relatorioNumero8 = relatorioNumero8;
	}

	public List<ModeloRelatorio> getRelatorioNumero7() {
		return relatorioNumero7;
	}

	public void setRelatorioNumero7(List<ModeloRelatorio> relatorioNumero7) {
		this.relatorioNumero7 = relatorioNumero7;
	}

	public List<ModeloRelatorio> getRelatorioNumero6() {
		return relatorioNumero6;
	}

	public void setRelatorioNumero6(List<ModeloRelatorio> relatorioNumero6) {
		this.relatorioNumero6 = relatorioNumero6;
	}

	public List<ModeloRelatorio> getRelatorioNumero5() {
		return relatorioNumero5;
	}

	public void setRelatorioNumero5(List<ModeloRelatorio> relatorioNumero5) {
		this.relatorioNumero5 = relatorioNumero5;
	}

	public void popularRelatorioNumero6() {
		setRelatorioNumero6(new ModeloRelatorioDAOOpenbase().relatorioNumero6(ano));
	}

	public void popularRelatorioNumero5() {
		setRelatorioNumero5(new ModeloRelatorioDAOOpenbase().relatorioNumero5(ano));
	}

	public void popularRelatorioNumero7() {
		setRelatorioNumero7(new ModeloRelatorioDAOOpenbase().relatorioNumero7(ano));
	}

	public void popularRelatorioNumero8() {
		setRelatorioNumero8(new ModeloRelatorioDAOOpenbase().relatorioNumero8(ano));
	}

}
