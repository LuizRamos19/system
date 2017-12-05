package br.com.servicemanager.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.servicemanager.entity.UsuarioEntity;
import br.com.servicemanager.model.UsuarioModel;
import br.com.servicemanager.uteis.Uteis;

public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	UsuarioEntity usuarioEntity;
 
	EntityManager entityManager;
	
	public UsuarioEntity ValidaUsuario(UsuarioModel usuarioModel) {

		try {

			// QUERY QUE VAI SER EXECUTADA (UsuarioEntity.findUser)
			Query query = Uteis.JpaEntityManager().createNamedQuery("UsuarioEntity.findUser");

			// PARÂMETROS DA QUERY
			query.setParameter("usuario", usuarioModel.getUsuario());
			query.setParameter("senha", usuarioModel.getSenha());

			// RETORNA O USUÁRIO SE FOR LOCALIZADO
			return (UsuarioEntity) query.getSingleResult();

		} catch (Exception e) {

			return null;
		}

	}
	
	private UsuarioEntity GetUsuario(int codigo){
		 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(UsuarioEntity.class, codigo);
	}
	
	public void AlteraSenha(UsuarioModel usuarioModel){
		 
		entityManager =  Uteis.JpaEntityManager();
 
		UsuarioEntity usuarioEntity = this.GetUsuario(Integer.parseInt(usuarioModel.getCodigo()));

		usuarioEntity.setSenha(usuarioModel.getSenha());
		 
		entityManager.merge(usuarioEntity);
	}

}
