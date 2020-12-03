/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

package br.com.sagti.model.dao;

import java.util.List;

import br.com.sagti.bean.IncidenteBean;
import br.com.sagti.model.entity.EIncidente;

/**
 * INterface do manipulador da entidade EIncidente
 * 
 * @author felipe
 */
public interface IncidenteDAO {

	/**
	 * Cria entidade no banco
	 * 
	 * @param IncidenteBean
	 * @return EIncidente
	 * @throws Exception
	 */
	public EIncidente create(IncidenteBean bean);

	/**
	 * Popula a Entidade com os dados do Bean
	 * 
	 * @param EIncidente
	 * @param IncidenteBean
	 */
	public void beanToEntity(EIncidente entity, IncidenteBean bean);

	/**
	 * Gera bean da entidade passada
	 * 
	 * @param EIncidente
	 * @return IncidenteBean
	 */
	public IncidenteBean entityToBean(EIncidente entity);

	/**
	 * Busca lista de Incidentess no banco
	 * 
	 * @return List<IncidenteBean>
	 */
	public List<IncidenteBean> findAll();

	/**
	 * Monta a query de acordo com parametros de entrada e executa no banco
	 * TODO: Não funciona pois o spring boot é limitado em execução de queries
	 * 
	 * @param IncidenteBean
	 * @param findAll
	 * @return List<EIncidente>
	 */
	public List<EIncidente> findByQuery(IncidenteBean bean, boolean findAll);

}
