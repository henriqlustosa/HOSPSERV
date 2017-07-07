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
	private String nomeProfissional;
	private Long cpfProfissional;
	
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
	

	
	
public String getNomeProfissional() {
		return nomeProfissional;
	}
	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}
	public Long getCpfProfissional() {
		return cpfProfissional;
	}
	public void setCpfProfissional(Long cpfProfissional) {
		this.cpfProfissional = cpfProfissional;
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
	this.hrsJan ="0" ;
	this.hrsFev ="0";
	this.hrsMar ="0";
	this.hrsAbr ="0";
	this.hrsMai ="0";
	this.hrsJun ="0";
	this.hrsJul ="0";
	this.hrsAgo ="0";
	this.hrsSet ="0";
	this.hrsOut ="0";
	this.hrsNov ="0";
	this.hrsDez ="0";
	this.hrsTotal ="0";
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
