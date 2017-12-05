package br.com.servicemanager.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.servicemanager.dao.LocalidadeDAO;
import br.com.servicemanager.model.LocalidadeModel;
import br.com.servicemanager.uteis.Uteis;
 
@Named(value="consultarLocalidadeController")
@ViewScoped
public class ConsultarLocalidadeController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private LocalidadeModel localidadeModel;
 
	@Produces 
	private List<LocalidadeModel> localidades;
 
	@Inject transient
	private LocalidadeDAO localidadeRepository;
 
	public List<LocalidadeModel> getLocalidades() {
		return localidades;
	}
	public void setLocalidades(List<LocalidadeModel> localidades) {
		this.localidades = localidades;
	}		
	public LocalidadeModel getLocalidadeModel() {
		return localidadeModel;
	}
	public void setLocalidadeModel(LocalidadeModel localidadeModel) {
		this.localidadeModel = localidadeModel;
	}
 
	/***
	 * CARREGA AS LOCALIDADES NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		this.localidades = localidadeRepository.GetLocalidades();
	}
	
	/***
	 * CARREGA INFORMAÇÕES DE UMA LOCALIDADE PARA SER EDITADA
	 * @param localidadeModel
	 */
	public void Editar(LocalidadeModel localidadeModel){
  
		this.localidadeModel = localidadeModel;
 
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
 
		this.localidadeRepository.AlterarRegistro(this.localidadeModel);	
 
		Uteis.MensagemInfo("Registro alterado com sucesso");
		
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param localidadeModel
	 */
	public void ExcluirLocalidade(LocalidadeModel localidadeModel){
 
		this.localidadeRepository.ExcluirRegistro(localidadeModel.getCodigoLocal());
 
		this.localidades.remove(localidadeModel);
 
	}

}
