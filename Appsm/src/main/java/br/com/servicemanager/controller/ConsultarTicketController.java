package br.com.servicemanager.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.servicemanager.dao.TicketDAO;
import br.com.servicemanager.model.TicketModel;
 
@Named(value="consultarTicketController")
@ViewScoped
public class ConsultarTicketController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private TicketModel ticketModel;
 
	@Produces 
	private List<TicketModel> tickets;
	
	private List<TicketModel> ticketsFiltered;
	
	@Inject transient
	private TicketDAO ticketRepository;
 
	
	public List<TicketModel> getTickets() {
		return tickets;
	}
	public void setTickets(List<TicketModel> tickets) {
		this.tickets = tickets;
	}
	
	public List<TicketModel> getTicketsFiltered() {
		return ticketsFiltered;
	}
	public void setTicketsFiltered(List<TicketModel> ticketsFiltered) {
		this.ticketsFiltered = ticketsFiltered;
	}
	
	public TicketModel getTicketModel() {
		return ticketModel;
	}
	public void setTicketModel(TicketModel ticketModel) {
		this.ticketModel = ticketModel;
	}
 
	/***
	 * CARREGA OS TICKETS NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		this.tickets = ticketRepository.GetTickets();
		this.ticketsFiltered = ticketRepository.GetTickets();
		ticketsFiltered.add(ticketModel);
	}
	
	/***
	 * CARREGA INFORMAÇÕES DE UM TICKET PARA SER VISUALIZADO
	 * @param ticketModel
	 */
	public void Visualizar(TicketModel ticketModel){
  
		this.ticketModel = ticketModel;
 
	}
 
}