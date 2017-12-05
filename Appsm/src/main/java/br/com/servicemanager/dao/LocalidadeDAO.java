package br.com.servicemanager.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.servicemanager.entity.LocalidadeEntity;
import br.com.servicemanager.model.LocalidadeModel;
import br.com.servicemanager.uteis.Uteis;

public class LocalidadeDAO {
	
	@Inject
	LocalidadeEntity localidadeEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVA LOCALIDADE
	 * @param localidadeModel
	 */
	public void SalvarNovoRegistro(LocalidadeModel localidadeModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		localidadeEntity = new LocalidadeEntity();
		
		localidadeEntity.setIdentificacao(localidadeModel.getIdentificacao());
		localidadeEntity.setEndereco(localidadeModel.getEndereco());
		localidadeEntity.setCritico(localidadeModel.getCritico());

		entityManager.persist(localidadeEntity);
		
	}
	
	/***
	 * MÉTODO PARA CONSULTAR A LOCALIDADE
	 * @return
	 */
	public List<LocalidadeModel> GetLocalidades(){
 
		List<LocalidadeModel> localidadesModel = new ArrayList<LocalidadeModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("LocalidadeEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<LocalidadeEntity> localidadesEntity = (Collection<LocalidadeEntity>)query.getResultList();
 
		LocalidadeModel localidadeModel = null;
 
		for (LocalidadeEntity localidadeEntity : localidadesEntity) {
 
			localidadeModel = new LocalidadeModel();
			localidadeModel.setCodigoLocal(localidadeEntity.getCodigoLocal());
			localidadeModel.setIdentificacao(localidadeEntity.getIdentificacao());
			localidadeModel.setEndereco(localidadeEntity.getEndereco());
			localidadeModel.setCritico(localidadeEntity.getCritico());
  
			localidadesModel.add(localidadeModel);
		}
 
		return localidadesModel;
 
	}
	
	/***
	 * CONSULTA UMA LOCALIDADE CADASTRADA PELA SUA IDENTIFICAÇÃO
	 * @param codigoLocal
	 * @return
	 */
	private LocalidadeEntity GetLocalidade(String codigoLocal){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(LocalidadeEntity.class, codigoLocal);
	}
 
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param empresaModel
	 */
	public void AlterarRegistro(LocalidadeModel localidadeModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		LocalidadeEntity localidadeEntity = this.GetLocalidade(localidadeModel.getCodigoLocal());

		localidadeEntity.setIdentificacao(localidadeModel.getIdentificacao());
		localidadeEntity.setEndereco(localidadeModel.getEndereco());
		localidadeEntity.setCritico(localidadeModel.getCritico());
 
		entityManager.merge(localidadeEntity);
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigoLocal
	 */
	public void ExcluirRegistro(String codigoLocal){
 
		entityManager =  Uteis.JpaEntityManager();		
 
		LocalidadeEntity localidadeEntity = this.GetLocalidade(codigoLocal);
 
		entityManager.remove(localidadeEntity);
	}

}
