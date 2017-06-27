package hspm.centrocirurgico.cirurgia;

import java.util.List;

public interface CirurgiaDAO {
	
	public List<Cirurgia> listarIniCirMaiorFim(Integer ano);
	public List<Cirurgia> listarIniAnestMaiorFim(Integer ano);
	public List<Cirurgia> listarIniAnestMaiorIniCir(Integer ano);
	public List<Cirurgia> listarFimAnestMenorFimCir(Integer ano);
	public List<Cirurgia> listarPorte(String porte, Integer ano);
	public List<Cirurgia> listaCirurgiasRealizadasClicnica(String dtInicio, String dtFim, String codClin);
	public List<Cirurgia> listarPorteGrafico(Integer ano);
	public List<Cirurgia> listarCampoEncaminhaVazio();

	
}
