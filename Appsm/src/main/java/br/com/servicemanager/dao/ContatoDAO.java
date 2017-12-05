package br.com.servicemanager.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.servicemanager.entity.ContatoEntity;
import br.com.servicemanager.model.ContatoModel;
import br.com.servicemanager.uteis.Uteis;

public class ContatoDAO {
	
	@Inject
	ContatoEntity contatoEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UM NOVO CONTATO
	 * @param contatoModel
	 */
	public void SalvarNovoRegistro(ContatoModel contatoModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		contatoEntity = new ContatoEntity();
	
		contatoEntity.setCpf(contatoModel.getCpf());
		contatoEntity.setNomeContato(contatoModel.getNomeContato());
		contatoEntity.setEmail(contatoModel.getEmail());
		contatoEntity.setTelefone(contatoModel.getTelefone());
		contatoEntity.setDepartamento(contatoModel.getDepartamento());
		contatoEntity.setCargo(contatoModel.getCargo());
		contatoEntity.setEndLocalidade(contatoModel.getEndLocalidade());
		contatoEntity.setIdentificacaoEmpresa(contatoModel.getIdentificacaoEmpresa());

		entityManager.persist(contatoEntity);
		
	}
	
	/***
	 * MÉTODO PARA CONSULTAR O CONTATO
	 * @return
	 */
	public List<ContatoModel> GetContatos(){
 
		List<ContatoModel> contatosModel = new ArrayList<ContatoModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("ContatoEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<ContatoEntity> contatosEntity = (Collection<ContatoEntity>)query.getResultList();
 
		ContatoModel contatoModel = null;
 
		for (ContatoEntity contatoEntity : contatosEntity) {
 
			contatoModel = new ContatoModel();
			
			contatoModel.setCpf(contatoEntity.getCpf());
			contatoModel.setNomeContato(contatoEntity.getNomeContato());
			contatoModel.setEmail(contatoEntity.getEmail());
			contatoModel.setTelefone(contatoEntity.getTelefone());
			contatoModel.setDepartamento(contatoEntity.getDepartamento());
			contatoModel.setCargo(contatoEntity.getCargo());
			contatoModel.setEndLocalidade(contatoEntity.getEndLocalidade());
			contatoModel.setIdentificacaoEmpresa(contatoEntity.getIdentificacaoEmpresa());

			contatosModel.add(contatoModel);
		}
 
		return contatosModel;
 
	}
	
	/***
	 * CONSULTA UMA LOCALIDADE CADASTRADA PELA SUA IDENTIFICAÇÃO
	 * @param cpf
	 * @return
	 */
	private ContatoEntity GetContato(String cpf){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(ContatoEntity.class, cpf);
	}
 
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param contatoModel
	 */
	public void AlterarRegistro(ContatoModel contatoModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		ContatoEntity contatoEntity = this.GetContato(contatoModel.getCpf());
		
		contatoEntity.setCpf(contatoModel.getCpf());
		contatoEntity.setNomeContato(contatoModel.getNomeContato());
		contatoEntity.setEmail(contatoModel.getEmail());
		contatoEntity.setTelefone(contatoModel.getTelefone());
		contatoEntity.setDepartamento(contatoModel.getDepartamento());
		contatoEntity.setCargo(contatoModel.getCargo());
		contatoEntity.setEndLocalidade(contatoModel.getEndLocalidade());
		contatoEntity.setIdentificacaoEmpresa(contatoModel.getIdentificacaoEmpresa());
 
		entityManager.merge(contatoEntity);
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param cpf
	 */
	public void ExcluirRegistro(String cpf){
 
		entityManager =  Uteis.JpaEntityManager();		
 
		ContatoEntity contatoEntity = this.GetContato(cpf);
 
		entityManager.remove(contatoEntity);
	}
	
	/***
	 * VALIDA SE O CPF EXISTE NO BANCO DE DADOS
	 * @param cpf
	 */
	public ContatoEntity ValidaCpf(String cpf) {
		entityManager = Uteis.JpaEntityManager();
		
		return entityManager.find(ContatoEntity.class, cpf);
		
	}

}