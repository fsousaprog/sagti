/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informações da PUC-SP 2017.*/

package br.com.sagti.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.sagti.bean.UsuarioBean;
import br.com.sagti.model.entity.EUsuario;
import br.com.sagti.model.repository.UsuarioRepository;

/**
 * Implementação do manipulador da entidade EUsuario
 * 
 * @author felipe
 */
@Repository
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	UsuarioRepository repositorio;

	private static final Logger LOGGER = Logger.getLogger(UsuarioDAOImpl.class);

	/**
	 * Cria entidade no banco
	 * 
	 * @param UsuarioBean
	 * @return EUsuario
	 * @throws Exception
	 */
	public EUsuario create(UsuarioBean bean) throws Exception {
		EUsuario entity = new EUsuario();
		entity.setDao(this);
		this.beanToEntity(entity, bean);

		try {
			this.repositorio.save(entity);
			this.repositorio.flush();
			LOGGER.info("Usuário de ID:" + entity.getId() + " criado com sucesso no banco!");
		} catch (Exception e) {
			LOGGER.warn(e);
			throw new Exception(e);
		}

		return entity;
	}

	/**
	 * Popula a Entidade com os dados do Bean
	 * 
	 * @param EUsuario
	 * @param UsuarioBean
	 */
	public void beanToEntity(EUsuario entity, UsuarioBean bean) {
		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		entity.setLogin(bean.getLogin());
		entity.setSenha(bean.getSenha());
		entity.setCargo(bean.getCargo());
		entity.setNivelAcesso(bean.getNivelAcesso());
	}

	/**
	 * Gera bean da entidade passada
	 * 
	 * @param EUsuario
	 * @return UsuarioBean
	 */
	public UsuarioBean entityToBean(EUsuario entity) {
		UsuarioBean bean = new UsuarioBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		bean.setLogin(entity.getLogin());
		bean.setSenha(entity.getSenha());
		bean.setCargo(entity.getCargo());
		bean.setNivelAcesso(entity.getNivelAcesso());

		return bean;
	}

	/**
	 * Busca lista de Usuários no banco
	 * 
	 * @return List<UsuarioBean>
	 */
	public List<UsuarioBean> findAll() {
		List<UsuarioBean> lista = new ArrayList<>();
		List<EUsuario> listaEntities = new ArrayList<>();

		listaEntities = repositorio.findAll();
		for (EUsuario eUsuario : listaEntities) {
			lista.add(this.entityToBean(eUsuario));
		}
		LOGGER.info("Busca de lsita de usuários realizada no banco");
		return lista;
	}

	/**
	 * Monta a query de acordo com parametros de entrada e executa no banco
	 * TODO: Não funciona pois o spring boot é limitado em execução de queries
	 * 
	 * @param UsuarioBean
	 * @param findAll
	 * @return List<EUsuario>
	 */
	public List<UsuarioBean> findByQuery(UsuarioBean bean, boolean findAll) {
		List<UsuarioBean> lista = new ArrayList<>();
		List<EUsuario> listaEntities = new ArrayList<>();
		String and = " AND ";
		String queryBuild = "";

		// findAll
		if (findAll == true) {
			listaEntities = repositorio.findAll();
			for (EUsuario eUsuario : listaEntities) {
				lista.add(this.entityToBean(eUsuario));
			}
			return lista;
		}

		// findById
		if (bean.getId() != 0) {
			EUsuario usuario = repositorio.findById(bean.getId());
			if (usuario != null)
				lista.add(this.entityToBean(usuario));
			return lista;
		}

		// Valida todos os atributos e executa query
		queryBuild += "'%" + bean.getNome() + "%'";
		if (bean.getLogin() != null && bean.getLogin().trim() != "") {
			queryBuild += and + "u.login LIKE '%" + bean.getLogin() + "%'";
		}
		if (bean.getCargo() != null && bean.getCargo().trim() != "") {
			queryBuild += and + "u.cargo LIKE '" + bean.getCargo() + "'";
		}
		if (bean.getNivelAcesso() != 0) {
			queryBuild += and + "u.nivelAcesso = " + bean.getNivelAcesso();
		}

		listaEntities = repositorio.findByQuery(queryBuild);
		for (EUsuario eUsuario : listaEntities) {
			lista.add(this.entityToBean(eUsuario));
		}
		return lista;
	}

	/**
	 * Verifica credenciais do usuário no banco
	 * 
	 * @param login
	 * @param senha
	 * @return int
	 */
	public int login(String login, String senha) {
		EUsuario usuario = this.repositorio.findByLogin(login);
		if (usuario != null) {
			if (usuario.getSenha().equals(senha)) {
				LOGGER.warn("Usuário " + usuario.getNome() + " logado com sucesso no sistema");
				return 1;
			} else {
				LOGGER.warn("Usuário " + usuario.getNome() + " inseriu credenciais incorretas");
				return 2;
			}
		}
		LOGGER.warn("Usuário " + login + " não encontrado");
		return 0;
	}

}
