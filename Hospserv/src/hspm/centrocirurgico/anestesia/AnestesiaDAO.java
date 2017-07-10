package hspm.centrocirurgico.anestesia;

import java.util.List;




public interface AnestesiaDAO {
	
	public List<Anestesia> listar();
	public List<Anestesia> listarQuantidadeAnestesia(Integer ano);
	public List<Anestesia> relatorioNumero3(Integer ano);
	public List<Anestesia> relatorioNumero4(Integer ano);

}
