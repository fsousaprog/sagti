/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

package br.com.sagti.model.dao;

import java.util.List;

import br.com.sagti.bean.ProblemaBean;
import br.com.sagti.model.entity.EProblema;

/**
 * INterface do manipulador da entidade EProblema
 * 
 * @author felipe
 */
public interface ProblemaDAO {

	/**
	 * Cria entidade no banco
	 * 
	 * @param ProblemaBean
	 * @return boolean
	 * @throws Exception
	 */
	public boolean create(ProblemaBean bean);

	/**
	 * Popula a Entidade com os dados do Bean
	 * 
	 * @param EProblema
	 * @param ProblemaBean
	 */
	public void beanToEntity(EProblema entity, ProblemaBean bean);

	/**
	 * Gera bean da entidade passada
	 * 
	 * @param EProblema
	 * @return ProblemaBean
	 */
	public ProblemaBean entityToBean(EProblema entity);

	/**
	 * Busca lista de Problemas no banco
	 * 
	 * @return List<ProblemaBean>
	 */
	public List<ProblemaBean> findAll();

	/**
	 * Monta a query de acordo com parametros de entrada e executa no banco
	 * TODO: Não funciona pois o spring boot é limitado em execução de queries
	 * 
	 * @param ProblemaBean
	 * @param findAll
	 * @return List<ProblemaBean>
	 */
	public List<ProblemaBean> findByQuery(ProblemaBean bean, boolean findAll);

}
