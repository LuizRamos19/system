package br.com.servicemanager.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.servicemanager.dao.ContatoDAO;
import br.com.servicemanager.entity.ContatoEntity;
import br.com.servicemanager.model.ContatoModel;
import br.com.servicemanager.uteis.Uteis;

@Named(value = "cadastrarContatoController")
@RequestScoped
public class CadastrarContatoController {

	@Inject
	ContatoModel contatoModel;

	@Inject
	ContatoDAO contatoRepository;

	public ContatoModel getContatoModel() {
		return contatoModel;
	}

	public void setContatoModel(ContatoModel contatoModel) {
		this.contatoModel = contatoModel;
	}

	/**
	 * SALVA UM NOVO REGISTRO
	 */
	public void SalvarNovoContato() {

		ContatoEntity contatoEntity = contatoRepository.ValidaCpf(this.contatoModel.getCpf());

		if (contatoEntity == null) {

			contatoRepository.SalvarNovoRegistro(this.contatoModel);

			this.contatoModel = null;

			Uteis.MensagemInfo("Registro cadastrado com sucesso");

		} else {
			Uteis.MensagemAtencao("Já existe um funcionário com este CPF no sistema!");
		}

	}

}
