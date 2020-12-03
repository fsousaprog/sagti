/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

package br.com.sagti.model.dao;

import java.util.List;

import br.com.sagti.bean.CompanhiaBean;
import br.com.sagti.model.entity.ECompanhia;

/**
 * Interface do manipulador da entidade ECompanhia
 * 
 * @author felipe
 */
public interface CompanhiaDAO {

	/**
	 * Cria entidade no banco
	 * 
	 * @param CompanhiaBean
	 * @return ECompanhia
	 * @throws Exception
	 */
	public ECompanhia create(CompanhiaBean bean);

	/**
	 * Popula a Entidade com os dados do Bean
	 * 
	 * @param ECompanhia
	 * @param CompanhiaBean
	 */
	public void beanToEntity(ECompanhia entity, CompanhiaBean bean);

	/**
	 * Gera bean da entidade passada
	 * 
	 * @param ECompanhia
	 * @return CompanhiaBean
	 */
	public CompanhiaBean entityToBean(ECompanhia entity);

	/**
	 * Busca lista de companhias no banco
	 * 
	 * @return List<ECompanhia>
	 */
	public List<CompanhiaBean> findAll();

	/**
	 * Monta a query de acordo com parametros de entrada e executa no banco
	 * TODO: Não funciona pois o spring boot é limitado em execução de queries
	 * 
	 * @param CompanhiaBean
	 * @param findAll
	 * @return List<ECompanhia>
	 */
	public List<ECompanhia> findByQuery(CompanhiaBean bean, boolean findAll);

}
