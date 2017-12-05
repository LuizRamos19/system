package br.com.servicemanager.model;

public class LocalidadeModel {
	
	private String codigoLocal;
	private String identificacao;
	private String endereco;
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