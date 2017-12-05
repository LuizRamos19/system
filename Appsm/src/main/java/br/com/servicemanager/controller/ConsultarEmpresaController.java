package br.com.servicemanager.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.servicemanager.dao.EmpresaDAO;
import br.com.servicemanager.entity.EmpresaEntity;
import br.com.servicemanager.model.EmpresaModel;
import br.com.servicemanager.uteis.Uteis;
 
@Named(value="consultarEmpresaController")
@ViewScoped
public class ConsultarEmpresaController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private EmpresaModel empresaModel;
 
	@Produces 
	private List<EmpresaModel> empresas;
 
	@Inject transient
	private EmpresaDAO empresaRepository;
 
	public List<EmpresaModel> getEmpresas() {
		return empresas;
	}
	
	public void setEmpresas(List<EmpresaModel> empresas) {
		this.empresas = empresas;
	}		
	
	public EmpresaModel getEmpresaModel() {
		return empresaModel;
	}
	
	public void setEmpresaModel(EmpresaModel empresaModel) {
		this.empresaModel = empresaModel;
	}
 
	/***
	 * CARREGA AS empresas NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		this.empresas = empresaRepository.GetEmpresas();
	}
	
	/***
	 * CARREGA INFORMAÇÕES DE UMA EMPRESA PARA SER EDITADA
	 * @param empresaModel
	 */
	public void Editar(EmpresaModel empresaModel){
  
		this.empresaModel = empresaModel;
 
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
		
		EmpresaEntity empresaEntity = empresaRepository.ValidaNome(this.empresaModel.getNome());

		if (empresaEntity != null) {
						
			Uteis.MensagemAtencao("Já existe uma empresa com este nome cadastrada no sistema");
			
		} else {
			this.empresaRepository.AlterarRegistro(this.empresaModel);	
			
			Uteis.MensagemInfo("Registro alterado com sucesso");

			this.init();

		}
 		
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param empresaModel
	 */
	public void ExcluirEmpresa(EmpresaModel empresaModel){
 
		this.empresaRepository.ExcluirRegistro(empresaModel.getIdentificacao());
 
		this.empresas.remove(empresaModel);
 
	}

}
