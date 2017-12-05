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
@Table(name = "tb_ticket")

@NamedQueries({

		@NamedQuery(name = "ticketEntity.findAll", query = "SELECT t FROM TicketEntity t"),
		@NamedQuery(name = "ticketEntity.findGraphic", query = "SELECT s.tipoResolucao, COUNT(s) AS Total FROM TicketEntity s GROUP BY s.tipoResolucao"),
		

})

public class TicketEntity {

	@Id
	@GeneratedValue
	@Column(name = "id_ticket")
	private String idTicket;

	@Column(name = "fonte_call")
	private String fonte;

	@Column(name = "data_abertura")
	private String dataAbertura;

	@Column(name = "id_empresa")
	private String identificacaoEmpresa;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "end_localidade")
	private String endLocalidade;

	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "titulo")
	private String titulo;

	@Column(name = "produto_impactado")
	private String produtoImpactado;

	@Column(name = "impacto")
	private String impacto;

	@Column(name = "severidade")
	private String severidade;

	@OneToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioEntity usuarioEntity;

	@Column(name = "tipo_solucao")
	private String tipoResolucao;

	@Column(name = "solucao")
	private String solucao;

	@Column(name = "fila")
	private String fila;

	public String getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(String idTicket) {
		this.idTicket = idTicket;
	}

	public String getFonte() {
		return fonte;
	}

	public void setFonte(String fonte) {
		this.fonte = fonte;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getIdentificacaoEmpresa() {
		return identificacaoEmpresa;
	}

	public void setIdentificacaoEmpresa(String identificacaoEmpresa) {
		this.identificacaoEmpresa = identificacaoEmpresa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndLocalidade() {
		return endLocalidade;
	}

	public void setEndLocalidade(String endLocalidade) {
		this.endLocalidade = endLocalidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getProdutoImpactado() {
		return produtoImpactado;
	}

	public void setProdutoImpactado(String produtoImpactado) {
		this.produtoImpactado = produtoImpactado;
	}

	public String getImpacto() {
		return impacto;
	}

	public void setImpacto(String impacto) {
		this.impacto = impacto;
	}

	public String getSeveridade() {
		return severidade;
	}

	public void setSeveridade(String severidade) {
		this.severidade = severidade;
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

	public String getTipoResolucao() {
		return tipoResolucao;
	}

	public void setTipoResolucao(String tipoResolucao) {
		this.tipoResolucao = tipoResolucao;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

}