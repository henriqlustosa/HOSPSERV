package hspm.centrocirurgico.anestesia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cir30")
public class Anestesia {
	@Column(name = "c30codanest")
	private String codAnestesia;
	@Column(name = "c30nomeanest")
	private String descAnestesia;
	
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

	
	
public Anestesia(){
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
}
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getQtdJan() {
		return qtdJan;
	}

	public void setQtdJan(Integer qtdJan) {
			
		this.qtdJan += qtdJan;
	}

	public Integer getQtdFev() {
		return qtdFev;
	}

	public void setQtdFev(Integer qtdFev) {
		this.qtdFev += qtdFev;
	}

	public Integer getQtdMar() {
		return qtdMar;
	}

	public void setQtdMar(Integer qtdMar) {
		this.qtdMar += qtdMar;
	}

	public Integer getQtdAbr() {
		return qtdAbr;
	}

	public void setQtdAbr(Integer qtdAbr) {
		this.qtdAbr += qtdAbr;
	}

	public Integer getQtdMai() {
		return qtdMai;
	}

	public void setQtdMai(Integer qtdMai) {
		this.qtdMai += qtdMai;
	}

	public Integer getQtdJun() {
		return qtdJun;
	}

	public void setQtdJun(Integer qtdJun) {
		this.qtdJun  += qtdJun;
	}

	public Integer getQtdJul() {
		return qtdJul;
	}

	public void setQtdJul(Integer qtdJul) {
		this.qtdJul += qtdJul;
	}

	public Integer getQtdAgo() {
		return qtdAgo;
	}

	public void setQtdAgo(Integer qtdAgo) {
		this.qtdAgo += qtdAgo;
	}

	public Integer getQtdSet() {
		return qtdSet;
	}

	public void setQtdSet(Integer qtdSet) {
		this.qtdSet += qtdSet;
	}

	public Integer getQtdOut() {
		return qtdOut;
	}

	public void setQtdOut(Integer qtdOut) {
		this.qtdOut += qtdOut;
	}

	public Integer getQtdNov() {
		return qtdNov;
	}

	public void setQtdNov(Integer qtdNov) {
		this.qtdNov += qtdNov;
	}

	public Integer getQtdDez() {
		return qtdDez;
	}

	public void setQtdDez(Integer qtdDez) {
		this.qtdDez += qtdDez;
	}

	public String getCodAnestesia() {
		return codAnestesia;
	}

	public void setCodAnestesia(String codAnestesia) {
		this.codAnestesia = codAnestesia;
	}

	public String getDescAnestesia() {
		return descAnestesia;
	}

	public void setDescAnestesia(String descAnestesia) {
		this.descAnestesia = descAnestesia;
	}

}
