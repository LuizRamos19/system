package br.com.servicemanager.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.servicemanager.dao.EmpresaDAO;
import br.com.servicemanager.entity.EmpresaEntity;
import br.com.servicemanager.model.EmpresaModel;
import br.com.servicemanager.usuario.controller.UsuarioController;
import br.com.servicemanager.uteis.Uteis;

@Named(value = "cadastrarEmpresaController")
@RequestScoped
public class CadastrarEmpresaController {

	@Inject
	EmpresaModel empresaModel;

	@Inject
	UsuarioController usuarioController;

	@Inject
	EmpresaDAO empresaRepository;

	public EmpresaModel getEmpresaModel() {
		return empresaModel;
	}

	public void setEmpresaModel(EmpresaModel empresaModel) {
		this.empresaModel = empresaModel;
	}

	/**
	 * SALVA UM NOVO REGISTRO
	 */
	public void SalvarNovaEmpresa() {

		EmpresaEntity empresaEntity = empresaRepository.ValidaId(this.empresaModel.getIdentificacao());
		EmpresaEntity empresaEntity1 = empresaRepository.ValidaNome(this.empresaModel.getNome());

		if (empresaEntity != null) {
			
			Uteis.MensagemAtencao("Já existe uma empresa com esta identificação cadastrada no sistema");
			
		} else if (empresaEntity1 != null) {
			
			Uteis.MensagemAtencao("Já existe uma empresa com este nome cadastrada no sistema");
			
		} else {
			empresaModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());
			
			empresaRepository.SalvarNovoRegistro(this.empresaModel);

			this.empresaModel = null;

			Uteis.MensagemInfo("Registro cadastrado com sucesso");

		}
		
	}

}