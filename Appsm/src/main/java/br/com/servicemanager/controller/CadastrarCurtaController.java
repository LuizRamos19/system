package br.com.servicemanager.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.servicemanager.dao.CurtasDAO;
import br.com.servicemanager.entity.TicketEntity;
import br.com.servicemanager.enumeration.Curtas;
import br.com.servicemanager.model.CurtasModel;
import br.com.servicemanager.usuario.controller.UsuarioController;
import br.com.servicemanager.uteis.Uteis;

@Named(value = "cadastrarCurtaController")
@RequestScoped
public class CadastrarCurtaController {

	@Inject
	CurtasModel curtaModel;

	@Inject
	UsuarioController usuarioController;

	@Inject
	CurtasDAO curtaRepository;

	public CurtasModel getCurtasModel() {
		return curtaModel;
	}

	public void setCurtasModel(CurtasModel curtaModel) {
		this.curtaModel = curtaModel;
	}

	public String[] getCurtas() {
		return Curtas.retornarCurtas();
	}

	/**
	 * SALVA UM NOVO REGISTRO
	 */
	public void SalvarNovaCurta() {

		if ((curtaModel.getMotivo().equals("Consulta de chamado")) && (curtaModel.getTicketNumber() == "")) {

			Uteis.MensagemAtencao("É necessário colocar o número do ticket para o motivo Consulta de Chamado");

		} else if (curtaModel.getMotivo().equals("Consulta de chamado")) {

			TicketEntity ticketEntity = curtaRepository.GetTicketNumber(this.curtaModel.getTicketNumber());

			if (ticketEntity == null) {

				Uteis.MensagemAtencao("Este número de chamado não foi encontrado no sistema");

			} else {

				curtaModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());

				curtaRepository.SalvarNovoRegistro(this.curtaModel);

				this.curtaModel = null;

				Uteis.MensagemInfo("Registro cadastrado com sucesso");

			}
		} else {
			
			curtaModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());

			curtaRepository.SalvarNovoRegistro(this.curtaModel);

			this.curtaModel = null;

			Uteis.MensagemInfo("Registro cadastrado com sucesso");

		}
	}
}