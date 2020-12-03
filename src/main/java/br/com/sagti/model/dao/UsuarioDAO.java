/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

package br.com.sagti.model.dao;

import java.util.List;

import br.com.sagti.bean.UsuarioBean;
import br.com.sagti.model.entity.EUsuario;

/**
 * Interface do manipulador da entidade EUsuario
 * 
 * @author felipe
 */
public interface UsuarioDAO {

	/**
	 * Cria entidade no banco
	 * 
	 * @param UsuarioBean
	 * @return EUsuario
	 * @throws Exception
	 */
	public EUsuario create(UsuarioBean bean) throws Exception;
	
	/**
	 * Popula a Entidade com os dados do Bean
	 * 
	 * @param EUsuario
	 * @param UsuarioBean
	 */
	public void beanToEntity(EUsuario entity, UsuarioBean bean);
	
	/**
	 * Gera bean da entidade passada
	 * 
	 * @param EUsuario
	 * @return UsuarioBean
	 */
	public UsuarioBean entityToBean(EUsuario entity);
	
	/**
	 * Busca lista de Usuários no banco
	 * 
	 * @return List<UsuarioBean>
	 */
	public List<UsuarioBean> findAll();
	
	/**
	 * Realiza busca no banco de acordo com parametros passados
	 * TODO: Não funciona pois o spring boot é limitado em execução de queries
	 * 
	 * @param UsuarioBean
	 * @param findAll
	 * @return List<UsuarioBean>
	 */
	public List<UsuarioBean> findByQuery(UsuarioBean bean, boolean findAll);
	
	/**
	 * Verifica credenciais do usuário no banco
	 * 
	 * @param login
	 * @param senha
	 * @return int
	 */
	public int login(String login, String senha);
	
}
