/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.service;

import java.util.List;

import br.com.sagti.bean.CompanhiaBean;
import br.com.sagti.form.CompanhiaForm;

/**
 * Interface do servico responsável pelas ações sobre Companhia
 * 
 * @author felipe
 */
public interface CompanhiaService {

	/**
	 * Insere companhia no banco
	 * 
	 * @param bean
	 * @throws RuntimeException
	 */
	public void inserir(CompanhiaBean bean);

	/**
	 * Busca Companhia(s) no banco
	 * 
	 * @return List<CompanhiaBean>
	 */
	public List<CompanhiaBean> buscar();

	/**
	 * Atualiza dados do companhia passado no banco
	 * 
	 * @param bean
	 * @throws Exception
	 */
	public void atualizar(CompanhiaBean bean) throws Exception;

	/**
	 * Converte um form em um bean
	 * 
	 * @param form
	 * @return CompanhiaBean
	 * @throws Exception
	 */
	public CompanhiaBean formToBean(CompanhiaForm form) throws Exception;

	/**
	 * Converte um bean em um form
	 * 
	 * @param bean
	 * @return CompanhiaForm
	 */
	public CompanhiaForm beanToForm(CompanhiaBean bean);

}
