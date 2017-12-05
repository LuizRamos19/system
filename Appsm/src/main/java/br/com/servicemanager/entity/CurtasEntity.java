package br.com.servicemanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_curtas")

@NamedQueries({

		@NamedQuery(name = "curtasEntity.findAll", query = "SELECT t FROM CurtasEntity t"),
		@NamedQuery(name = "curtasEntity.findGraphic", query = "SELECT s.motivo, COUNT(s) AS Total FROM CurtasEntity s GROUP BY s.motivo"),

})

public class CurtasEntity {

	@Id
	@GeneratedValue
	@Column(name = "id_curta")
	private String idCurta;
	
	@Column(name = "motivo")
	private String motivo;
	
	@Column(name = "ticket_number")
	private String ticketNumber;
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioEntity usuarioEntity;
	
	public String getIdCurta() {
		return idCurta;
	}
	
	public void setIdCurta(String idCurta) {
		this.idCurta = idCurta;
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
	
	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}
	
	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

}