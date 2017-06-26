package hspm.centrocirurgico.cirurgia;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="cir38")
public class Cirurgia implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5439813732288921546L;
	
	@Column(name="numero")
	private Integer numCirurgia;
	private Integer anoCirurgia;
	private Integer prontuario;
	private String dtCirurgia;
	private String hInicioCirur;
	private String hfimCirur;
	private String hInicioAnest;
	private String hFimAnest;
	private String salaCirurcica;
	private String Medico;
	private String salaRec;
	private Integer dtEntrec;
	private String hEntrec;
	private String hSairec;
	private Integer numBoletim;
	private String tempoCirur;
	private String tempoAnest;
	private String tempoRPA;
	private Integer qtdPorte;
	
	
	public Integer getQtdPorte() {
		return qtdPorte;
	}
	public void setQtdPorte(Integer qtdPorte) {
		this.qtdPorte = qtdPorte;
	}
	public String getTempoCirur() {
		return tempoCirur;
	}
	public void setTempoCirur(String tempoCirur) {
		this.tempoCirur = tempoCirur;
	}
	public String getTempoAnest() {
		return tempoAnest;
	}
	public void setTempoAnest(String tempoAnest) {
		this.tempoAnest = tempoAnest;
	}
	public String getTempoRPA() {
		return tempoRPA;
	}
	public void setTempoRPA(String tempoRPA) {
		this.tempoRPA = tempoRPA;
	}
	public Integer getNumBoletim() {
		return numBoletim;
	}
	public void setNumBoletim(Integer numBoletim) {
		this.numBoletim = numBoletim;
	}
	private String porte;
	
	public Integer getNumCirurgia() {
		return numCirurgia;
	}
	public void setNumCirurgia(Integer numCirurgia) {
		this.numCirurgia = numCirurgia;
	}
	public Integer getAnoCirurgia() {
		return anoCirurgia;
	}
	public void setAnoCirurgia(Integer anoCirurgia) {
		this.anoCirurgia = anoCirurgia;
	}
	public Integer getProntuario() {
		return prontuario;
	}
	public void setProntuario(Integer prontuario) {
		this.prontuario = prontuario;
	}
	public String getDtCirurgia() {
		return dtCirurgia;
	}
	public void setDtCirurgia(String dtCirurgia) {
		this.dtCirurgia = dtCirurgia;
	}
	public String gethInicioCirur() {
		return hInicioCirur;
	}
	public void sethInicioCirur(String hInicioCirur) {
		this.hInicioCirur = hInicioCirur;
	}
	public String getHfimCirur() {
		return hfimCirur;
	}
	public void setHfimCirur(String hfimCirur) {
		this.hfimCirur = hfimCirur;
	}
	public String gethInicioAnest() {
		return hInicioAnest;
	}
	public void sethInicioAnest(String hInicioAnest) {
		this.hInicioAnest = hInicioAnest;
	}
	public String gethFimAnest() {
		return hFimAnest;
	}
	public void sethFimAnest(String hFimAnest) {
		this.hFimAnest = hFimAnest;
	}
	public String getSalaCirurcica() {
		return salaCirurcica;
	}
	public void setSalaCirurcica(String salaCirurcica) {
		this.salaCirurcica = salaCirurcica;
	}
	public String getMedico() {
		return Medico;
	}
	public void setMedico(String Medico) {
		this.Medico = Medico;
	}
	public String getSalaRec() {
		return salaRec;
	}
	public void setSalaRec(String salaRec) {
		this.salaRec = salaRec;
	}
	public Integer getDtEntrec() {
		return dtEntrec;
	}
	public void setDtEntrec(Integer dtEntrec) {
		this.dtEntrec = dtEntrec;
	}
	public String gethEntrec() {
		return hEntrec;
	}
	public void sethEntrec(String hEntrec) {
		this.hEntrec = hEntrec;
	}
	
	public String gethSairec() {
		return hSairec;
	}
	public void sethSairec(String hSairec) {
		this.hSairec = hSairec;
	}
	public String getPorte() {
		return porte;
	}
	public void setPorte(String porte) {
		this.porte = porte;
	}
}
