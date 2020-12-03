/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

package br.com.sagti.model.dao;

import java.util.List;

import br.com.sagti.bean.ServicoBean;
import br.com.sagti.model.entity.EServico;

/**
 * INterface do manipulador da entidade EServico
 * 
 * @author felipe
 */
public interface ServicoDAO {

	/**
	 * Cria entidade no banco
	 * 
	 * @param ServicoBean
	 * @return EServico
	 * @throws Exception
	 */
	public EServico create(ServicoBean bean);
	
	/**
	 * Popula a Entidade com os dados do Bean
	 * 
	 * @param EServico
	 * @param ServicoBean
	 */
	public void beanToEntity(EServico entity, ServicoBean bean);
	
	/**
	 * Gera bean da entidade passada
	 * 
	 * @param EServico
	 * @return ServicoBean
	 */
	public ServicoBean entityToBean(EServico entity);
	
	/**
	 * Busca lista de serviços no banco
	 * 
	 * @return List<ServicoBean>
	 */
	public List<ServicoBean> findAll();
	
	/**
	 * Monta a query de acordo com parametros de entrada e executa no banco
	 * TODO: Não funciona pois o spring boot é limitado em execução de queries
	 * 
	 * @param ServicoBean
	 * @param findAll
	 * @return List<EServico>
	 */
	public List<EServico> findByQuery(ServicoBean bean, boolean findAll);
	
}
