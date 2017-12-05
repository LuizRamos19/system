package br.com.servicemanager.model;

public class TicketModel {
	
	private String idTicket;
	private String fonte;
	private String dataAbertura;
	private String identificacaoEmpresa;
	private String cpf;
	private String telefone;
	private String nome;
	private String endLocalidade;
	private String titulo;
	private String descricao;
	private String produtoImpactado;
	private String impacto;
	private String severidade;
	private UsuarioModel usuarioModel;
	private String tipoResolucao;
	private String solucao;
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
	
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
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