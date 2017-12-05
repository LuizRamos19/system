package br.com.servicemanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_contato")

@NamedQueries({
	 
	@NamedQuery(name = "ContatoEntity.findAll",query= "SELECT c FROM ContatoEntity c")
 
})

public class ContatoEntity {
	
	@Id
	@Column(name = "cpf")
	private String cpf;

	@Column(name = "nome_contato")
	private String nomeContato;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "departamento")
	private String departamento;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "end_localidade")
	private String endLocalidade;
	
	@Column(name = "id_empresa")
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