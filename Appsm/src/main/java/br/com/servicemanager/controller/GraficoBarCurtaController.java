package br.com.servicemanager.controller;

import java.util.Hashtable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.servicemanager.dao.CurtasDAO;
 
@Named(value="graficoBarCurtaController")
@RequestScoped
public class GraficoBarCurtaController {
 
	@Inject
	private CurtasDAO curtaRepository;
 
	private BarChartModel barChartModel;
 
	public BarChartModel getBarChartModel() {
		return barChartModel;
	}
 
	@PostConstruct
	public  void init(){
 
		this.barChartModel = new BarChartModel();
 
		this.MontaGrafico();
	}
 
	/***
	 * MONTA O GRÁFICO NA PÁGINA
	 */
	private void MontaGrafico(){
 
		Hashtable<String, Integer> hashtableRegistros = curtaRepository.GetMotivo();
 
		hashtableRegistros.forEach((chave, valor) -> {
 
			ChartSeries motivo = new ChartSeries();
			motivo.setLabel(chave);
			motivo.set(chave, valor);
			
			barChartModel.addSeries(motivo);
			

		});
 
		barChartModel.setTitle("Total de ligações curtas registradas por motivo");
		barChartModel.setAnimate(true);
		barChartModel.setLegendPosition("ne");
		Axis yAxis = barChartModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
        yAxis.setMax(60);

 
	}

}
