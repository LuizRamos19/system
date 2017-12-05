package br.com.servicemanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_empresa")

@NamedQueries({
	 
	@NamedQuery(name = "EmpresaEntity.findAll",query= "SELECT e FROM EmpresaEntity e"),
	@NamedQuery(name = "EmpresaEntity.findName",query= "SELECT n FROM EmpresaEntity n WHERE n.nome = :nome")
 
})

public class EmpresaEntity {
	
	@Id
	@Column(name = "id_empresa")
	private String identificacao;
 
	@Column(name = "nome_empresa")
	private String  nome;
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private UsuarioEntity usuarioEntity;

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}
	
	

}
