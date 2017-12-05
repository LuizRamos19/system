package br.com.servicemanager.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.servicemanager.entity.CurtasEntity;
import br.com.servicemanager.entity.TicketEntity;
import br.com.servicemanager.entity.UsuarioEntity;
import br.com.servicemanager.model.CurtasModel;
import br.com.servicemanager.model.UsuarioModel;
import br.com.servicemanager.uteis.Uteis;

public class CurtasDAO {
	
	@Inject
	CurtasEntity curtaEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVA LIGAÇÃO CURTA
	 * @param TicketModel
	 */
	public void SalvarNovoRegistro(CurtasModel curtaModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		curtaEntity = new CurtasEntity();
	
		curtaEntity.setMotivo(curtaModel.getMotivo());
		curtaEntity.setTicketNumber(curtaModel.getTicketNumber());
		
		
		UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, curtaModel.getUsuarioModel().getCodigo()); 
		
		curtaEntity.setUsuarioEntity(usuarioEntity);
		
		entityManager.persist(curtaEntity);
		
	}
	
	/***
	 * MÉTODO PARA CONSULTAR O ticket
	 * @return
	 */
	public List<CurtasModel> GetCurtas(){
 
		List<CurtasModel> curtasModel = new ArrayList<CurtasModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("curtasEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<CurtasEntity> curtasEntity = (Collection<CurtasEntity>)query.getResultList();
 
		CurtasModel curtaModel = null;
 
		for (CurtasEntity curtaEntity : curtasEntity) {
 
			curtaModel = new CurtasModel();
			
			curtaModel.setMotivo(curtaEntity.getMotivo());
			curtaModel.setTicketNumber(curtaEntity.getTicketNumber());

			UsuarioEntity usuarioEntity =  curtaEntity.getUsuarioEntity();			
			 
			UsuarioModel usuarioModel = new UsuarioModel();
			usuarioModel.setUsuario(usuarioEntity.getUsuario());
 
			curtaModel.setUsuarioModel(usuarioModel);
			
			curtasModel.add(curtaModel);
		
		}
 
		return curtasModel;
 
	}
	
	/***
	 * RETORNA OS MOTIVOS
	 * @return
	 */
	public Hashtable<String, Integer> GetMotivo(){
 
		Hashtable<String, Integer> hashtableRegistros = new Hashtable<String,Integer>(); 
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("curtasEntity.findGraphic");
 
		@SuppressWarnings("unchecked")
		Collection<Object[]> collectionRegistros  = (Collection<Object[]>)query.getResultList();
 
		for (Object[] objects : collectionRegistros) {
 
 
			String motivo = (String)objects[0];
			int	totalDeRegistros = ((Number)objects[1]).intValue();
 
			if(motivo.equals("Engano")) {
				motivo = "Engano";
			} else if(motivo.equals("Queda de ligação")) {
				motivo = "Queda de ligação";
			} else if(motivo.equals("Consulta de chamado")) {
				motivo = "Consulta de chamado";
			} else if(motivo.equals("Transferência de ligação")) {
				motivo = "Transferência de ligação";
			}
			hashtableRegistros.put(motivo, totalDeRegistros);
 
		}
 
		return hashtableRegistros;
 
	}
	
	/***
	 * CONSULTA UM TICKET CADASTRADO PELA SUA IDENTIFICAÇÃO
	 * @param id
	 * @return
	 */
	public TicketEntity GetTicketNumber(String id){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(TicketEntity.class, id);
	}

}