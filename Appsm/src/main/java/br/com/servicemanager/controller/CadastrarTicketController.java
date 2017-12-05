package br.com.servicemanager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.servicemanager.dao.TicketDAO;
import br.com.servicemanager.entity.ContatoEntity;
import br.com.servicemanager.enumeration.Filas;
import br.com.servicemanager.enumeration.Fonte;
import br.com.servicemanager.enumeration.Impacto;
import br.com.servicemanager.enumeration.Produto;
import br.com.servicemanager.enumeration.Severidade;
import br.com.servicemanager.enumeration.Solucao;
import br.com.servicemanager.model.TicketModel;
import br.com.servicemanager.usuario.controller.UsuarioController;
import br.com.servicemanager.uteis.Uteis;

@Named(value = "cadastrarTicketController")
@RequestScoped
public class CadastrarTicketController {

	@Inject
	TicketModel ticketModel;

	@Inject
	UsuarioController usuarioController;

	@Inject
	TicketDAO ticketRepository;

	public TicketModel getTicketModel() {
		return ticketModel;
	}

	public void setTicketModel(TicketModel ticketModel) {
		this.ticketModel = ticketModel;
	}

	public String[] getFontes() {
		return Fonte.retornarFonte();
	}

	public String[] getProdutos() {
		return Produto.retornarProduto();
	}

	public String[] getFilas() {
		return Filas.retornarFila();
	}

	public String[] getSolucao() {
		return Solucao.retornarSolucaoEnum();
	}

	public String[] getImpacto() {
		return Impacto.retornarImpacto();
	}

	public String[] getSeveridade() {
		return Severidade.retornarSeveridade();
	}

	public String GerarData() {

		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");

		return formatarDate.format(data);
	}

	/**
	 * SALVA UM NOVO REGISTRO
	 */
	public void SalvarNovoTicket() {

		ContatoEntity contatoEntity = ticketRepository.ValidaCpf(this.ticketModel.getCpf());

		if (contatoEntity == null) {
			Uteis.MensagemAtencao("Não existem funcionários no sistema cadastrados com este CPF. Será necessário "
					+ "registrar este funcionário no sistema antes de poder registrar em seu nome!");
		} else {
			ticketModel.setDataAbertura(GerarData());

			ticketModel.setTelefone(contatoEntity.getTelefone());
			ticketModel.setNome(contatoEntity.getNomeContato());
			ticketModel.setEndLocalidade(contatoEntity.getEndLocalidade());
			ticketModel.setIdentificacaoEmpresa(contatoEntity.getIdentificacaoEmpresa());

			ticketModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());

			ticketRepository.SalvarNovoRegistro(this.ticketModel);

			this.ticketModel = null;

			
		}
	}

	/**
	 * VALIDA O CPF DIGITADO
	 */
	public void ValidarContato() {

		ContatoEntity contatoEntity = ticketRepository.ValidaCpf(this.ticketModel.getCpf());
		if (contatoEntity == null) {
			Uteis.MensagemAtencao("Não existem funcionários no sistema cadastrados com este CPF. Será necessário "
					+ "registrar este funcionário no sistema antes de poder registrar em seu nome!");
		} else {
			Uteis.MensagemInfo("Usuário encontrado e validado");

			ticketModel.setTelefone(contatoEntity.getTelefone());
			ticketModel.setNome(contatoEntity.getNomeContato());
			ticketModel.setEndLocalidade(contatoEntity.getEndLocalidade());
			ticketModel.setIdentificacaoEmpresa(contatoEntity.getIdentificacaoEmpresa());

		}

	}

}