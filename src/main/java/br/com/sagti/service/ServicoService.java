/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.service;

import java.util.List;

import br.com.sagti.bean.ServicoBean;
import br.com.sagti.form.ServicoForm;

/**
 * Interface do serviço responsável pelas ações sobre Companhia
 * 
 * @author felipe
 */
public interface ServicoService {

	/**
	 * Insere Serviço no banco
	 * 
	 * @param bean
	 */
	public void inserir(ServicoBean bean);

	/**
	 * Busca Servico(s) no banco
	 * 
	 * @return List<ServicoBean>
	 */
	public List<ServicoBean> buscar();

	/**
	 * Atualiza dados do servico passado no banco
	 * 
	 * @param bean
	 * @throws Exception
	 */
	public void atualizar(ServicoBean bean) throws Exception;

	/**
	 * Converte um form em um bean
	 * 
	 * @param form
	 * @return ServicoBean
	 * @throws Exception
	 */
	public ServicoBean formToBean(ServicoForm form) throws Exception;

	/**
	 * Converte um bean em um form
	 * 
	 * @param bean
	 * @return ServicoForm
	 */
	public ServicoForm beanToForm(ServicoBean bean);

}
