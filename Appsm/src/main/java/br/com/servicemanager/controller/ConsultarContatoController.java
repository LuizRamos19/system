package br.com.servicemanager.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.servicemanager.dao.ContatoDAO;
import br.com.servicemanager.model.ContatoModel;
import br.com.servicemanager.uteis.Uteis;
 
@Named(value="consultarContatoController")
@ViewScoped
public class ConsultarContatoController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private ContatoModel contatoModel;
 
	@Produces 
	private List<ContatoModel> contatos;
	
	private List<ContatoModel> contatosFiltered;
 
	@Inject transient
	private ContatoDAO contatoRepository;
 
	public List<ContatoModel> getContatos() {
		return contatos;
	}
	public void setContatos(List<ContatoModel> contatos) {
		this.contatos = contatos;
	}	
	public List<ContatoModel> getContatosFiltered() {
		return contatosFiltered;
	}
	public void setContatosFiltered(List<ContatoModel> contatosFiltered) {
		this.contatosFiltered = contatosFiltered;
	}
	public ContatoModel getContatoModel() {
		return contatoModel;
	}
	public void setContatoModel(ContatoModel contatoModel) {
		this.contatoModel = contatoModel;
	}
 
	/***
	 * CARREGA OS CONTATOS NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		this.contatos = contatoRepository.GetContatos();
		this.contatosFiltered = contatoRepository.GetContatos();
		contatosFiltered.add(contatoModel);
	}
	
	/***
	 * CARREGA INFORMAÇÕES DE UM CONTATO PARA SER EDITADO
	 * @param contatoModel
	 */
	public void Editar(ContatoModel contatoModel){
  
		this.contatoModel = contatoModel;
 
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
 
		this.contatoRepository.AlterarRegistro(this.contatoModel);	
		
		Uteis.MensagemInfo("Registro alterado com sucesso");
		
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param contatoModel
	 */
	public void ExcluirContato(ContatoModel contatoModel){
 
		this.contatoRepository.ExcluirRegistro(contatoModel.getCpf());
 
		this.contatos.remove(contatoModel);
 
	}

}
