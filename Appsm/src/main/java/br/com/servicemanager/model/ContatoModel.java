package br.com.servicemanager.model;

public class ContatoModel {
	
	private String cpf;
	private String nomeContato;
	private String email;
	private String telefone;
	private String departamento;
	private String cargo;
	private String endLocalidade;
	private String identificacaoEmpresa;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNomeContato() {
		return nomeContato;
	}
	
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getEndLocalidade() {
		return endLocalidade;
	}
	
	public void setEndLocalidade(String endLocalidade) {
		this.endLocalidade = endLocalidade;
	}
	
	public String getIdentificacaoEmpresa() {
		return identificacaoEmpresa;
	}
	
	public void setIdentificacaoEmpresa(String identificacaoEmpresa) {
		this.identificacaoEmpresa = identificacaoEmpresa;
	}

}