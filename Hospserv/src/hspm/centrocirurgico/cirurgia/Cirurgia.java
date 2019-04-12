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
	private Integer codProcedimento;
	private String descrProcedimento;
	
	
	
	private Integer qtdJan ;
	private Integer qtdFev ;
	private Integer qtdMar ;
	private Integer qtdAbr ;
	private Integer qtdMai ;
	private Integer qtdJun ;
	private Integer qtdJul ;
	private Integer qtdAgo ;
	private Integer qtdSet ;
	private Integer qtdOut ;
	private Integer qtdNov ;
	private Integer qtdDez ;
	private Integer total ;

	private String hrsJan ;
	private String hrsFev ;
	private String hrsMar ;
	private String hrsAbr ;
	private String hrsMai ;
	private String hrsJun ;
	private String hrsJul ;
	private String hrsAgo ;
	private String hrsSet ;
	private String hrsOut ;
	private String hrsNov ;
	private String hrsDez ;
	private String hrsTotal ;
	
	private Integer anoReferencia;
	private Integer codCirurgia;
	
	
	
	
	
	public Cirurgia(){
		this.qtdJan =0;
		this.qtdFev =0;
		this.qtdMar =0;
		this.qtdAbr =0;
		this.qtdMai =0;
		this.qtdJun =0;
		this.qtdJul =0;
		this.qtdAgo =0;
		this.qtdSet =0;
		this.qtdOut =0;
		this.qtdNov =0;
		this.qtdDez =0;
		this.total =0;
		this.hrsJan ="00:00" ;
		this.hrsFev ="00:00";
		this.hrsMar ="00:00";
		this.hrsAbr ="00:00";
		this.hrsMai ="00:00";
		this.hrsJun ="00:00";
		this.hrsJul ="00:00";
		this.hrsAgo ="00:00";
		this.hrsSet ="00:00";
		this.hrsOut ="00:00";
		this.hrsNov ="00:00";
		this.hrsDez ="00:00";
		this.hrsTotal ="00:00";
		this.setAnoReferencia(0);
		this.setCodCirurgia(0);
	}
	

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
	
	public Integer getQtdJan() {
		return qtdJan;
	}
	public void setQtdJan(Integer qtdJan) {
		this.qtdJan = qtdJan;
	}
	public Integer getQtdFev() {
		return qtdFev;
	}
	public void setQtdFev(Integer qtdFev) {
		this.qtdFev = qtdFev;
	}
	public Integer getQtdMar() {
		return qtdMar;
	}
	public void setQtdMar(Integer qtdMar) {
		this.qtdMar = qtdMar;
	}
	public Integer getQtdAbr() {
		return qtdAbr;
	}
	public void setQtdAbr(Integer qtdAbr) {
		this.qtdAbr = qtdAbr;
	}
	public Integer getQtdMai() {
		return qtdMai;
	}
	public void setQtdMai(Integer qtdMai) {
		this.qtdMai = qtdMai;
	}
	public Integer getQtdJun() {
		return qtdJun;
	}
	public void setQtdJun(Integer qtdJun) {
		this.qtdJun = qtdJun;
	}
	public Integer getQtdJul() {
		return qtdJul;
	}
	public void setQtdJul(Integer qtdJul) {
		this.qtdJul = qtdJul;
	}
	public Integer getQtdAgo() {
		return qtdAgo;
	}
	public void setQtdAgo(Integer qtdAgo) {
		this.qtdAgo = qtdAgo;
	}
	public Integer getQtdSet() {
		return qtdSet;
	}
	public void setQtdSet(Integer qtdSet) {
		this.qtdSet = qtdSet;
	}
	public Integer getQtdOut() {
		return qtdOut;
	}
	public void setQtdOut(Integer qtdOut) {
		this.qtdOut = qtdOut;
	}
	public Integer getQtdNov() {
		return qtdNov;
	}
	public void setQtdNov(Integer qtdNov) {
		this.qtdNov = qtdNov;
	}
	public Integer getQtdDez() {
		return qtdDez;
	}
	public void setQtdDez(Integer qtdDez) {
		this.qtdDez = qtdDez;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getHrsJan() {
		return hrsJan;
	}
	public void setHrsJan(String hrsJan) {
		this.hrsJan = hrsJan;
	}
	public String getHrsFev() {
		return hrsFev;
	}
	public void setHrsFev(String hrsFev) {
		this.hrsFev = hrsFev;
	}
	public String getHrsMar() {
		return hrsMar;
	}
	public void setHrsMar(String hrsMar) {
		this.hrsMar = hrsMar;
	}
	public String getHrsAbr() {
		return hrsAbr;
	}
	public void setHrsAbr(String hrsAbr) {
		this.hrsAbr = hrsAbr;
	}
	public String getHrsMai() {
		return hrsMai;
	}
	public void setHrsMai(String hrsMai) {
		this.hrsMai = hrsMai;
	}
	public String getHrsJun() {
		return hrsJun;
	}
	public void setHrsJun(String hrsJun) {
		this.hrsJun = hrsJun;
	}
	public String getHrsJul() {
		return hrsJul;
	}
	public void setHrsJul(String hrsJul) {
		this.hrsJul = hrsJul;
	}
	public String getHrsAgo() {
		return hrsAgo;
	}
	public void setHrsAgo(String hrsAgo) {
		this.hrsAgo = hrsAgo;
	}
	public String getHrsSet() {
		return hrsSet;
	}
	public void setHrsSet(String hrsSet) {
		this.hrsSet = hrsSet;
	}
	public String getHrsOut() {
		return hrsOut;
	}
	public void setHrsOut(String hrsOut) {
		this.hrsOut = hrsOut;
	}
	public String getHrsNov() {
		return hrsNov;
	}
	public void setHrsNov(String hrsNov) {
		this.hrsNov = hrsNov;
	}
	public String getHrsDez() {
		return hrsDez;
	}
	public void setHrsDez(String hrsDez) {
		this.hrsDez = hrsDez;
	}
	public String getHrsTotal() {
		return hrsTotal;
	}
	public void setHrsTotal(String hrsTotal) {
		this.hrsTotal = hrsTotal;
	}


	public Integer getAnoReferencia() {
		return anoReferencia;
	}


	public void setAnoReferencia(Integer anoReferencia) {
		this.anoReferencia = anoReferencia;
	}


	public Integer getCodCirurgia() {
		return codCirurgia;
	}


	public void setCodCirurgia(Integer codCirurgia) {
		this.codCirurgia = codCirurgia;
	}


	public Integer getCodProcedimento() {
		return codProcedimento;
	}


	public void setCodProcedimento(Integer codProcedimento) {
		this.codProcedimento = codProcedimento;
	}


	public String getDescrProcedimento() {
		return descrProcedimento;
	}


	public void setDescrProcedimento(String descrProcedimento) {
		this.descrProcedimento = descrProcedimento;
	}
	
}
