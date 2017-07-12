package hspm.centrocirurgico.modelorelatorio;

public class ModeloRelatorio {
	
	
	public ModeloRelatorio()
	{
		this.nomeMes ="";
		this.qtdMesProcDia =0;
		this.qtdMesProcNoite =0;
		this.qtdMesProcManha =0;
		this.qtdMesProcTotalLinha =0;
		this.tempoMesProcDia ="00:00";
		this.tempolMesProcNoite ="00:00";
		this.tempoMesProcManha ="00:00";
		this.tempoMesProcTotalLinha ="00:00";
		
		
			
	}
	

	private String nomeMes ;
	private Integer qtdMesProcDia ;
	private Integer qtdMesProcManha  ;
	private Integer qtdMesProcNoite  ;
	private Integer qtdMesProcTotalLinha ;
	private String tempoMesProcDia ;
	private String tempoMesProcManha  ;
	private String tempolMesProcNoite  ;
	private String tempoMesProcTotalLinha ;
	
	
	public String getNomeMes() {
		return nomeMes;
	}
	public void setNomeMes(String nomeMes) {
		this.nomeMes = nomeMes;
	}
	public Integer getQtdMesProcDia() {
		return qtdMesProcDia;
	}
	public void setQtdMesProcDia(Integer qtdMesProcDia) {
		this.qtdMesProcDia += qtdMesProcDia;
	}
	public Integer getQtdMesProcManha() {
		return qtdMesProcManha;
	}
	public void setQtdMesProcManha(Integer qtdMesProcManha) {
		this.qtdMesProcManha += qtdMesProcManha;
	}
	public Integer getQtdMesProcNoite() {
		return qtdMesProcNoite;
	}
	public void setQtdMesProcNoite(Integer qtdMesProcNoite) {
		this.qtdMesProcNoite += qtdMesProcNoite;
	}
	public Integer getQtdMesProcTotalLinha() {
		return qtdMesProcTotalLinha;
	}
	public void setQtdMesProcTotalLinha(Integer qtdMesProcTotalLinha) {
		this.qtdMesProcTotalLinha += qtdMesProcTotalLinha;
	}
	
	public String getTempoMesProcDia() {
		return tempoMesProcDia;
	}
	public void setTempoMesProcDia(String tempoMesProcDia) {
		this.tempoMesProcDia = tempoMesProcDia;
	}
	public String getTempoMesProcManha() {
		return tempoMesProcManha;
	}
	public void setTempoMesProcManha(String tempoMesProcManha) {
		this.tempoMesProcManha = tempoMesProcManha;
	}
	public String getTempolMesProcNoite() {
		return tempolMesProcNoite;
	}
	public void setTempolMesProcNoite(String tempolMesProcNoite) {
		this.tempolMesProcNoite = tempolMesProcNoite;
	}
	public String getTempoMesProcTotalLinha() {
		return tempoMesProcTotalLinha;
	}
	public void setTempoMesProcTotalLinha(String tempoMesProcTotalLinha) {
		this.tempoMesProcTotalLinha = tempoMesProcTotalLinha;
	}
	


}
