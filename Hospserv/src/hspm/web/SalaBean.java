package hspm.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import hspm.centrocirurgico.sala.Sala;
import hspm.centrocirurgico.sala.SalaDAOOpenbase;

@ManagedBean(name="salaBean")
@RequestScoped
public class SalaBean {
	private Sala sala;
	private String descricao;
	

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public String buscarSala(String codSala){
		Sala sala = new SalaDAOOpenbase().buscarPorSala(codSala);
		descricao = sala.getNomeSala();
		return descricao;
	}
}
