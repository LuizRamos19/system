package br.com.servicemanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_localidade")

@NamedQueries({
	 
	@NamedQuery(name = "LocalidadeEntity.findAll",query= "SELECT l FROM LocalidadeEntity l")
 
})

public class LocalidadeEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "id_localidade")
	private String codigoLocal;
	
	@Column(name = "id_empresa")
	private String identificacao;
	
	@Column(name = "end_localidade")
	private String endereco;
	
	@Column(name = "criticidade")
	private String critico;

	public String getCodigoLocal() {
		//vai retornar o número do ticket com o prefixo TAR
		return codigoLocal;
	}

	public void setCodigoLocal(String codigoLocal) {
		this.codigoLocal = codigoLocal;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCritico() {
		return critico;
	}

	public void setCritico(String critico) {
		this.critico = critico;
	}

}