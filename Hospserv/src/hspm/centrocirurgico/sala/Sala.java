package hspm.centrocirurgico.sala;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cir29")
public class Sala implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8467234168783360667L;

	private String codSala;
	private String nomeSala;
	private String status;
	private String tipo; //1-Cirurgica 2-Recuperacao
	private Integer numCir;
	
	
	public String getCodSala() {
		return codSala;
	}
	public void setCodSala(String codSala) {
		this.codSala = codSala;
	}
	public String getNomeSala() {
		return nomeSala;
	}
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getNumCir() {
		return numCir;
	}
	public void setNumCir(Integer numCir) {
		this.numCir = numCir;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codSala == null) ? 0 : codSala.hashCode());
		result = prime * result + ((nomeSala == null) ? 0 : nomeSala.hashCode());
		result = prime * result + ((numCir == null) ? 0 : numCir.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (codSala == null) {
			if (other.codSala != null)
				return false;
		} else if (!codSala.equals(other.codSala))
			return false;
		if (nomeSala == null) {
			if (other.nomeSala != null)
				return false;
		} else if (!nomeSala.equals(other.nomeSala))
			return false;
		if (numCir == null) {
			if (other.numCir != null)
				return false;
		} else if (!numCir.equals(other.numCir))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
}
