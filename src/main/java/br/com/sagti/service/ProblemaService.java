/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.service;

import java.util.List;
import java.util.Map;

import br.com.sagti.bean.ProblemaBean;
import br.com.sagti.form.ProblemaForm;

/**
 * Interface do Serviço responsável pelas ações sobre Problema
 * 
 * @author felipe
 */
public interface ProblemaService {

	/**
	 * Insere Serviço no banco
	 * 
	 * @param bean
	 * @throws Exception
	 */
	public void inserir(ProblemaBean bean);

	/**
	 * Busca Problema(s) no banco
	 * 
	 * @return List<ProblemaBean>
	 */
	public List<ProblemaBean> buscar();

	/**
	 * Atualiza dados do problema passado no banco
	 * 
	 * @param bean
	 * @throws Exception
	 */
	public void atualizar(ProblemaBean bean) throws Exception;

	/**
	 * Gera JSONs na estrutura do ChartJs com dados do banco
	 * 
	 * @return HashMap<String, List>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, List> gerarRelatorios() throws Exception;

	/**
	 * Converte um form em um bean
	 * 
	 * @param form
	 * @return ProblemaBean
	 * @throws Exception
	 */
	public ProblemaBean formToBean(ProblemaForm form) throws Exception;

	/**
	 * Converte um bean em um form
	 * 
	 * @param bean
	 * @return ProblemaForm
	 */
	public ProblemaForm beanToForm(ProblemaBean bean);

}
