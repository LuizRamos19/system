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

import br.com.servicemanager.dao.TicketDAO;
 
@Named(value="graficoBarController")
@RequestScoped
public class GraficoBarController {
 
	@Inject
	private TicketDAO ticketRepository;
 
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
 
		Hashtable<String, Integer> hashtableRegistros = ticketRepository.GetSolucao();
		
		hashtableRegistros.forEach((chave, valor) -> {
 
			ChartSeries solucao = new ChartSeries();
			solucao.setLabel(chave);
			solucao.set(chave, valor);
			
			barChartModel.addSeries(solucao);
			

		});
 
		barChartModel.setTitle("Total de tickets registrados por tipo de solução");
		barChartModel.setAnimate(true);
		barChartModel.setLegendPosition("ne");
		Axis yAxis = barChartModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
        yAxis.setMax(60);

 
	}

}
