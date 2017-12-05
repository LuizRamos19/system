package br.com.servicemanager.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.servicemanager.dao.LocalidadeDAO;
import br.com.servicemanager.model.LocalidadeModel;
import br.com.servicemanager.uteis.Uteis;

@Named(value="cadastrarLocalidadeController")
@RequestScoped
public class CadastrarLocalidadeController {
	
	@Inject
	LocalidadeModel localidadeModel;

	@Inject
	LocalidadeDAO localidadeRepository;
	
	public LocalidadeModel getLocalidadeModel() {
		return localidadeModel;
	}

	public void setLocalidadeModel(LocalidadeModel localidadeModel) {
		this.localidadeModel = localidadeModel;
	}
	
	/**
	 * SALVA UM NOVO REGISTRO
	 */
	public void SalvarNovaLocalidade() {

		localidadeRepository.SalvarNovoRegistro(this.localidadeModel);

		this.localidadeModel = null;

		Uteis.MensagemInfo("Registro cadastrado com sucesso");

	}

}
