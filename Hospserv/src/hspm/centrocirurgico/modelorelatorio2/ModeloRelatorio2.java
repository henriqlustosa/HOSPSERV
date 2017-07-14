package hspm.centrocirurgico.modelorelatorio2;

public class ModeloRelatorio2 {
	
	
	public ModeloRelatorio2()
	{
		this.nomeSala ="";
		this.procEletivos =0;
		this.procUrgencia =0;
		this.procTotal =0;
		
		this.ocupEletivos ="00:00";
		this.ocupUrgencia ="00:00";
		this.ocupTotal ="00:00";
	
		}
	
	
	private String nomeSala ;
	private Integer procEletivos;
	private Integer procUrgencia;
	private Integer procTotal;
	private String ocupEletivos;
	private String ocupUrgencia;
	private String ocupTotal;
	
	public String getNomeSala() {
		return nomeSala;
	}
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}

	public Integer getProcEletivos() {
		return procEletivos;
	}
	public void setProcEletivos(Integer procEletivos) {
		this.procEletivos += procEletivos;
	}
	public Integer getProcUrgencia() {
		return procUrgencia;
	}
	public void setProcUrgencia(Integer procUrgencia) {
		this.procUrgencia += procUrgencia;
	}
	public Integer getProcTotal() {
		return procTotal;
	}
	public void setProcTotal(Integer procTotal) {
		this.procTotal += procTotal;
	}
	public String getOcupEletivos() {
		return ocupEletivos;
	}
	public void setOcupEletivos(String ocupEletivos) {
		this.ocupEletivos = ocupEletivos;
	}
	public String getOcupUrgencia() {
		return ocupUrgencia;
	}
	public void setOcupUrgencia(String ocupUrgencia) {
		this.ocupUrgencia = ocupUrgencia;
	}
	public String getOcupTotal() {
		return ocupTotal;
	}
	public void setOcupTotal(String ocupTotal) {
		this.ocupTotal = ocupTotal;
	}
	
	

}
