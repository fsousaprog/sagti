/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import br.com.sagti.bean.IncidenteBean;
import br.com.sagti.form.IncidenteForm;

/**
 * Interface do servico responsável pelas ações sobre Incidente
 * 
 * @author felipe
 */
public interface IncidenteService {

	/**
	 * Insere Serviço no banco
	 * 
	 * @param bean
	 * @throws Exception
	 */
	public void inserir(IncidenteBean bean);

	/**
	 * Busca Incidente(s) no banco
	 * 
	 * @return List<IncidenteBean>
	 */
	public List<IncidenteBean> buscar();

	/**
	 * Atualiza dados do incidente passado no banco
	 * 
	 * @param bean
	 * @throws Exception
	 */
	public void atualizar(IncidenteBean bean) throws Exception;

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
	 * @return IncidenteBean
	 * @throws ParseException
	 */
	public IncidenteBean formToBean(IncidenteForm form) throws ParseException;

	/**
	 * Converte um bean em um form
	 * 
	 * @param bean
	 * @return IncidenteForm
	 */
	public IncidenteForm beanToForm(IncidenteBean bean);

}
