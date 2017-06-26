package hspm.centrocirurgico.grafico;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import hspm.centrocirurgico.cirurgia.Cirurgia;
import hspm.centrocirurgico.cirurgia.CirurgiaDAOOpenbase;

@ManagedBean(name="porteBean")
@RequestScoped
public class PorteBean {
	private Integer ano;
	private PieChartModel piemodelPorte;
	private BarChartModel barModel;
	private ChartSeries porteData;
	private List<Cirurgia> lista;

	public void gerarGraficoPorte(){
		CirurgiaDAOOpenbase dao;
		lista = new ArrayList<Cirurgia>();
		try{
			dao = new CirurgiaDAOOpenbase();
			lista = dao.listarPorteGrafico(ano);
			graficar(lista);
			createBarModel(lista);
		}catch (Exception e) {
			System.out.println("Erro ao listar porte. Mensagem: " + e.getMessage());
		}
	}
	
	
	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();
		
        porteData = new ChartSeries();
        porteData.setLabel("Porte");
        for(Cirurgia p:lista){
			porteData.set(p.getPorte(), p.getQtdPorte());
		}
        model.addSeries(porteData);
        return model;
    }
	private void createBarModel(List<Cirurgia> lista) {
        barModel = initBarModel();
         
        barModel.setTitle("Porte Cirúrgico");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Porte");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Quantidade");
        yAxis.setMin(0);
        yAxis.setMax(3000);
    }
	
		
	private void graficar(List<Cirurgia> lista){
		piemodelPorte = new PieChartModel();
		
		for(Cirurgia porte:lista){
			piemodelPorte.set(porte.getPorte(), porte.getQtdPorte());
		}
		piemodelPorte.setTitle("Porte Cirúrgico");
		piemodelPorte.setLegendPosition("e");
		piemodelPorte.setFill(false);
		piemodelPorte.setShowDataLabels(true);
		piemodelPorte.setDiameter(200);
	}
	
	public PieChartModel getPiemodelPorte() {
		return piemodelPorte;
	}

	public void setPiemodelPorte(PieChartModel piemodelPorte) {
		this.piemodelPorte = piemodelPorte;
	}
	

	
	public BarChartModel getBarModel() {
		return barModel;
	}

	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}

	
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	
}
