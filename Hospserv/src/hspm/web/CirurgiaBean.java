package hspm.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hspm.centrocirurgico.cirurgia.Cirurgia;
import hspm.centrocirurgico.cirurgia.CirurgiaDAOOpenbase;

@ManagedBean(name = "cirurgiaBean")
@ViewScoped
public class CirurgiaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer ano;
	private String codClin;
	private String dtInicio;
	private String dtFim;
	private String porte;

	
	
	
	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	private Cirurgia cirurgia;

	private List<Cirurgia> listPorte;
	
	private List<Cirurgia> listaRealizadaClinica;
	
	private List<Cirurgia> listaCirHoraIniMaiorFim;
	
	private List<Cirurgia> listaAnestHoraIniMaiorFim;

	private List<Cirurgia> listaAnestHoraIniMaiorIniCirur;
	
	private List<Cirurgia> listaAnestHoraFimMenorFimCir;
	
	private List<Cirurgia> listarCampoEncaminhaVazio;
	
	
	public void popularAnestHoraFimMenorFimCir(){
		setListaAnestHoraFimMenorFimCir(new CirurgiaDAOOpenbase().listarFimAnestMenorFimCir(ano));
	}
	
	public void popularAnestHoraIniMaiorIniCirur(){
		setListaAnestHoraIniMaiorIniCirur(new CirurgiaDAOOpenbase().listarIniAnestMaiorIniCir(ano));
	}

	public void popularAnestHoraIniMaiorFim(){
		setListaAnestHoraIniMaiorFim(new CirurgiaDAOOpenbase().listarIniAnestMaiorFim(ano));
	}

	public void popularPorte() {
		setListPorte(new CirurgiaDAOOpenbase().listarPorte(porte, ano));
	}
	
	public void cirurgiasRealizadasClinicas(){
		setListaRealizadaClinica(new CirurgiaDAOOpenbase().listaCirurgiasRealizadasClicnica(dtInicio, dtFim, codClin));
	}
	
	public void popularCirurgiaHoraMaior(){
		setListaCirHoraIniMaiorFim(new CirurgiaDAOOpenbase().listarIniCirMaiorFim(ano));
	}

	public void popularListarCampoEncaminhaVazio(){
		setListarCampoEncaminhaVazio(new CirurgiaDAOOpenbase().listarCampoEncaminhaVazio());
	}
	

	public Cirurgia getCirurgia() {
		return cirurgia;
	}

	public void setCirurgia(Cirurgia cirurgia) {
		this.cirurgia = cirurgia;
	}
	
	
	public List<Cirurgia> getListaRealizadaClinica() {
		return listaRealizadaClinica;
	}

	public void setListaRealizadaClinica(List<Cirurgia> listaRealizadaClinica) {
		this.listaRealizadaClinica = listaRealizadaClinica;
	}
	

	public List<Cirurgia> getListaCirHoraIniMaiorFim() {
		return listaCirHoraIniMaiorFim;
	}

	public void setListaCirHoraIniMaiorFim(List<Cirurgia> listaCirHoraIniMaiorFim) {
		this.listaCirHoraIniMaiorFim = listaCirHoraIniMaiorFim;
	}

	public List<Cirurgia> getListaAnestHoraIniMaiorFim() {
		return listaAnestHoraIniMaiorFim;
	}

	public void setListaAnestHoraIniMaiorFim(List<Cirurgia> listaAnestHoraIniMaiorFim) {
		this.listaAnestHoraIniMaiorFim = listaAnestHoraIniMaiorFim;
	}
	

	public List<Cirurgia> getListaAnestHoraIniMaiorIniCirur() {
		return listaAnestHoraIniMaiorIniCirur;
	}

	public void setListaAnestHoraIniMaiorIniCirur(List<Cirurgia> listaAnestHoraIniMaiorIniCirur) {
		this.listaAnestHoraIniMaiorIniCirur = listaAnestHoraIniMaiorIniCirur;
	}
	

	public List<Cirurgia> getListaAnestHoraFimMenorFimCir() {
		return listaAnestHoraFimMenorFimCir;
	}

	public void setListaAnestHoraFimMenorFimCir(List<Cirurgia> listaAnestHoraFimMenorFimCir) {
		this.listaAnestHoraFimMenorFimCir = listaAnestHoraFimMenorFimCir;
	}

	
	public String getCodClin() {
		return codClin;
	}

	public void setCodClin(String codClin) {
		this.codClin = codClin;
	}


	public String getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getDtFim() {
		return dtFim;
	}

	public void setDtFim(String dtFim) {
		this.dtFim = dtFim;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
		
	public List<Cirurgia> getListPorte() {
		return listPorte;
	}

	public void setListPorte(List<Cirurgia> listPorte) {
		this.listPorte = listPorte;
	}

	public List<Cirurgia> getListarCampoEncaminhaVazio() {
		return listarCampoEncaminhaVazio;
	}

	public void setListarCampoEncaminhaVazio(List<Cirurgia> listarCampoEncaminhaVazio) {
		this.listarCampoEncaminhaVazio = listarCampoEncaminhaVazio;
	}
}
