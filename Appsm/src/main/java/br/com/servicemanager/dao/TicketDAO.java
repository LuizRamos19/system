package br.com.servicemanager.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.servicemanager.entity.ContatoEntity;
import br.com.servicemanager.entity.TicketEntity;
import br.com.servicemanager.entity.UsuarioEntity;
import br.com.servicemanager.model.TicketModel;
import br.com.servicemanager.model.UsuarioModel;
import br.com.servicemanager.uteis.Uteis;

public class TicketDAO {
	
	@Inject
	TicketEntity ticketEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UM NOVO TICKET
	 * @param TicketModel
	 */
	public void SalvarNovoRegistro(TicketModel ticketModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		ticketEntity = new TicketEntity();
	
		ticketEntity.setFonte(ticketModel.getFonte());
		ticketEntity.setDataAbertura(ticketModel.getDataAbertura());
		ticketEntity.setIdentificacaoEmpresa(ticketModel.getIdentificacaoEmpresa());
		ticketEntity.setCpf(ticketModel.getCpf());
		ticketEntity.setTelefone(ticketModel.getTelefone());
		ticketEntity.setNome(ticketModel.getNome());
		ticketEntity.setEndLocalidade(ticketModel.getEndLocalidade());
		ticketEntity.setDescricao(ticketModel.getDescricao());
		ticketEntity.setTitulo(ticketModel.getTitulo());
		ticketEntity.setProdutoImpactado(ticketModel.getProdutoImpactado());
		ticketEntity.setImpacto(ticketModel.getImpacto());
		ticketEntity.setSeveridade(ticketModel.getSeveridade());
		ticketEntity.setTipoResolucao(ticketModel.getTipoResolucao());
		ticketEntity.setSolucao(ticketModel.getSolucao());
		ticketEntity.setFila(ticketModel.getFila());
		
		UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, ticketModel.getUsuarioModel().getCodigo()); 
		
		ticketEntity.setUsuarioEntity(usuarioEntity);
		
		entityManager.persist(ticketEntity);
		
		Uteis.MensagemInfo("Registrado ticket de número '" + ticketEntity.getIdTicket() + "' com sucesso!");
		
	}
	
	/***
	 * MÉTODO PARA CONSULTAR TODOS OS tickets
	 * @return
	 */
	public List<TicketModel> GetTickets(){
 
		List<TicketModel> ticketsModel = new ArrayList<TicketModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("ticketEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<TicketEntity> ticketsEntity = (Collection<TicketEntity>)query.getResultList();
 
		TicketModel ticketModel = null;
 
		for (TicketEntity ticketEntity : ticketsEntity) {
 
			ticketModel = new TicketModel();
			
			ticketModel.setIdTicket(ticketEntity.getIdTicket());
			ticketModel.setFonte(ticketEntity.getFonte());
			ticketModel.setDataAbertura(ticketEntity.getDataAbertura());
			ticketModel.setIdentificacaoEmpresa(ticketEntity.getIdentificacaoEmpresa());
			ticketModel.setCpf(ticketEntity.getCpf());
			ticketModel.setTelefone(ticketEntity.getTelefone());
			ticketModel.setNome(ticketEntity.getNome());
			ticketModel.setEndLocalidade(ticketEntity.getEndLocalidade());
			ticketModel.setIdentificacaoEmpresa(ticketEntity.getIdentificacaoEmpresa());
			ticketModel.setDescricao(ticketEntity.getDescricao());
			ticketModel.setTitulo(ticketEntity.getTitulo());
			ticketModel.setProdutoImpactado(ticketEntity.getProdutoImpactado());
			ticketModel.setImpacto(ticketEntity.getImpacto());
			ticketModel.setSeveridade(ticketEntity.getSeveridade());
			ticketModel.setTipoResolucao(ticketEntity.getTipoResolucao());
			ticketModel.setSolucao(ticketEntity.getSolucao());
			ticketModel.setFila(ticketEntity.getFila());
			
			UsuarioEntity usuarioEntity =  ticketEntity.getUsuarioEntity();			
			 
			UsuarioModel usuarioModel = new UsuarioModel();
			usuarioModel.setUsuario(usuarioEntity.getUsuario());
 
			ticketModel.setUsuarioModel(usuarioModel);
			
			ticketsModel.add(ticketModel);
		
		}
 
		return ticketsModel;
 
	}
	
	/***
	 * RETORNA AS SOLUCOES
	 * @return
	 */
	public Hashtable<String, Integer> GetSolucao(){
 
		Hashtable<String, Integer> hashtableRegistros = new Hashtable<String,Integer>(); 
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("ticketEntity.findGraphic");
 
		@SuppressWarnings("unchecked")
		Collection<Object[]> collectionRegistros  = (Collection<Object[]>)query.getResultList();
 
		for (Object[] objects : collectionRegistros) {
 
 
			String tipoResolucao = (String)objects[0];
			int	totalDeRegistros = ((Number)objects[1]).intValue();
 
			if(tipoResolucao.equals("Resolvido")) {
				tipoResolucao = "Resolvido";
			} else if(tipoResolucao.equals("Sem ação")) {
				tipoResolucao = "Sem ação";
			} else if(tipoResolucao.equals("Direcionado")) {
				tipoResolucao = "Direcionado";
			} else if(tipoResolucao.equals("Pendente")) {
				tipoResolucao = "Pendente";
			}
			hashtableRegistros.put(tipoResolucao, totalDeRegistros);
 
		}
 
		return hashtableRegistros;
 
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