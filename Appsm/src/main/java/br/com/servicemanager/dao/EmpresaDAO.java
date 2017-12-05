package br.com.servicemanager.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.servicemanager.entity.EmpresaEntity;
import br.com.servicemanager.entity.UsuarioEntity;
import br.com.servicemanager.model.EmpresaModel;
import br.com.servicemanager.model.UsuarioModel;
import br.com.servicemanager.uteis.Uteis;

public class EmpresaDAO {

	@Inject
	EmpresaEntity empresaEntity;

	EntityManager entityManager;

	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVA EMPRESA
	 * 
	 * @param empresaModel
	 */
	public void SalvarNovoRegistro(EmpresaModel empresaModel) {

		entityManager = Uteis.JpaEntityManager();

		empresaEntity = new EmpresaEntity();
		empresaEntity.setIdentificacao(empresaModel.getIdentificacao());
		empresaEntity.setNome(empresaModel.getNome());

		UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class,
				empresaModel.getUsuarioModel().getCodigo());

		empresaEntity.setUsuarioEntity(usuarioEntity);

		entityManager.persist(empresaEntity);

	}

	/***
	 * MÉTODO PARA CONSULTAR A EMPRESA
	 * 
	 * @return
	 */
	public List<EmpresaModel> GetEmpresas() {

		List<EmpresaModel> empresasModel = new ArrayList<EmpresaModel>();

		entityManager = Uteis.JpaEntityManager();

		Query query = entityManager.createNamedQuery("EmpresaEntity.findAll");

		@SuppressWarnings("unchecked")
		Collection<EmpresaEntity> empresasEntity = (Collection<EmpresaEntity>) query.getResultList();

		EmpresaModel empresaModel = null;

		for (EmpresaEntity empresaEntity : empresasEntity) {

			empresaModel = new EmpresaModel();
			empresaModel.setIdentificacao(empresaEntity.getIdentificacao());
			empresaModel.setNome(empresaEntity.getNome());

			UsuarioEntity usuarioEntity = empresaEntity.getUsuarioEntity();

			UsuarioModel usuarioModel = new UsuarioModel();
			usuarioModel.setUsuario(usuarioEntity.getUsuario());

			empresaModel.setUsuarioModel(usuarioModel);

			empresasModel.add(empresaModel);
		}

		return empresasModel;

	}

	/***
	 * CONSULTA UMA EMPRESA CADASTRADA PELA SUA IDENTIFICAÇÃO
	 * 
	 * @param identificacao
	 * @return
	 */
	private EmpresaEntity GetEmpresa(String identificacao) {

		entityManager = Uteis.JpaEntityManager();

		return entityManager.find(EmpresaEntity.class, identificacao);
	}

	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * 
	 * @param empresaModel
	 */
	public void AlterarRegistro(EmpresaModel empresaModel) {

		entityManager = Uteis.JpaEntityManager();

		EmpresaEntity empresaEntity = this.GetEmpresa(empresaModel.getIdentificacao());

		empresaEntity.setNome(empresaModel.getNome());

		entityManager.merge(empresaEntity);
	}

	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * 
	 * @param identificacao
	 */
	public void ExcluirRegistro(String identificacao) {

		entityManager = Uteis.JpaEntityManager();

		EmpresaEntity empresaEntity = this.GetEmpresa(identificacao);

		entityManager.remove(empresaEntity);
	}

	/***
	 * VALIDA SE A IDENTIFICAÇÃO DA EMRPESA JÁ EXISTE NO BANCO DE DADOS
	 * 
	 * @param id
	 */
	public EmpresaEntity ValidaId(String id) {
		entityManager = Uteis.JpaEntityManager();

		return entityManager.find(EmpresaEntity.class, id);

	}

	/***
	 * VALIDA SE O NOME DA EMPRESA JÁ EXISTE NO BANCO DE DADOS
	 * 
	 * @param nome
	 */
	public EmpresaEntity ValidaNome(String nome) {
		
		try {

			Query query = Uteis.JpaEntityManager().createNamedQuery("EmpresaEntity.findName");

			query.setParameter("nome", nome);
				
			return (EmpresaEntity) query.getSingleResult();
		}catch(Exception e) {
			return null;
		}

	}

}
