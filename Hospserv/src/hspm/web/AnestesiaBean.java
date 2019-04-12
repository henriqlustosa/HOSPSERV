package hspm.web;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hspm.centrocirurgico.anestesia.Anestesia;
import hspm.centrocirurgico.anestesia.AnestesiaDAOOpenbase;

@ManagedBean(name = "anestesiaBean")
@ViewScoped

public class AnestesiaBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Define local da realização (centro Cirúrgico ou Centro Obstétrico
	 * Código 1 - Centro Cirurgico
	 * Código 2 - Centro Obstétrico
	 */
	private Integer local;
	
	
	private Integer ano;
	
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	private List<Anestesia> listarQuantidadeAnestesia;
	private List<Anestesia> relatorioNumero3;
	private List<Anestesia> relatorioNumero4;
	private List<Anestesia> relatorioNumero5;
	
	
	public List<Anestesia> getRelatorioNumero4() {
		return relatorioNumero4;
	}
	
	public List<Anestesia> getRelatorioNumero5(){
		return relatorioNumero5;
	}

	public void setRelatorioNumero4(List<Anestesia> relatorioNumero4) {
		this.relatorioNumero4 = relatorioNumero4;
	}

	public void setRelatorioNumero5(List<Anestesia> relatorioNumero5){
		this.relatorioNumero5 = relatorioNumero5;
	}
	
	public void popularRelatorioNumero3(){
		setRelatorioNumero3(new AnestesiaDAOOpenbase().relatorioNumero3(ano));
	}
	public void popularRelatorioNumero4(){
		setRelatorioNumero4(new AnestesiaDAOOpenbase().relatorioNumero4(ano));
	}
	
	public void popularRelatorioNumero5(){
		setRelatorioNumero5(new AnestesiaDAOOpenbase().relatorioNumero5(ano));
	}
	
	
	public List<Anestesia> getRelatorioNumero3() {
		return relatorioNumero3;
	}

	public void setRelatorioNumero3(List<Anestesia> relatorioNumero3) {
		this.relatorioNumero3 = relatorioNumero3;
	}

	public void popularListarQuantidadeAnestesia(){
		setListarQuantidadeAnestesia(new AnestesiaDAOOpenbase().listarQuantidadeAnestesia(ano, local));
	}

	public List<Anestesia> getListarQuantidadeAnestesia() {
		return listarQuantidadeAnestesia;
	}

	public void setListarQuantidadeAnestesia(List<Anestesia> listarQuantidadeAnestesia) {
		this.listarQuantidadeAnestesia = listarQuantidadeAnestesia;
	}
	public List<Anestesia> listaAnestesias(){
	     List<Anestesia> lista;
	     lista = new AnestesiaDAOOpenbase().listar();//Carrega a lista do Banco de dados
	     return lista;
	}

	public Integer getLocal() {
		return local;
	}

	public void setLocal(Integer local) {
		this.local = local;
	}
}
