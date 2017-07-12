package hspm.web;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import hspm.centrocirurgico.modelorelatorio.ModeloRelatorio;
import hspm.centrocirurgico.modelorelatorio.ModeloRelatorioDAOOpenbase;

@ManagedBean(name = "modeloRelatorioBean")
@ViewScoped
public class ModeloRelatorioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
private Integer ano;
	
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	private  List<ModeloRelatorio> relatorioNumero5;

	public List<ModeloRelatorio> getRelatorioNumero5() {
		return relatorioNumero5;
	}

	public void setRelatorioNumero5(List<ModeloRelatorio> relatorioNumero5) {
		this.relatorioNumero5 = relatorioNumero5;
	}
	public void popularRelatorioNumero5(){
		setRelatorioNumero5(new ModeloRelatorioDAOOpenbase().relatorioNumero5(ano));
	}

}
