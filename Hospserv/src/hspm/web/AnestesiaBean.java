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
	
	
	private Integer ano;
	
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	private List<Anestesia> listarQuantidadeAnestesia;
	
	public void popularListarQuantidadeAnestesia(){
		setListarQuantidadeAnestesia(new AnestesiaDAOOpenbase().listarQuantidadeAnestesia(ano));
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
}
