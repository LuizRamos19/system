package br.com.servicemanager.model;

public class CurtasModel {
	
	private String idCurtas;
	private String motivo;
	private String ticketNumber;
	private UsuarioModel usuarioModel;
	
	public String getIdCurtas() {
		return idCurtas;
	}
	
	public void setIdCurtas(String idCurtas) {
		this.idCurtas= idCurtas;
	}
	
	public String getMotivo() {
		return motivo;
	}
	
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public String getTicketNumber() {
		return ticketNumber;
	}
	
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
		
}