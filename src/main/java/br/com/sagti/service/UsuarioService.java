/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.service;

import java.util.List;

import br.com.sagti.bean.UsuarioBean;
import br.com.sagti.form.UsuarioForm;

/**
 * Interface do Serviço responsável pelas ações sobre Usuário
 * 
 * @author felipe
 */
public interface UsuarioService {

	/**
	 * Insere usuário no banco
	 * 
	 * @param bean
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void inserir(UsuarioBean bean) throws Exception;

	/**
	 * Busca Usuário(s) no banco
	 * 
	 * @return List<UsuarioBean>
	 */
	public List<UsuarioBean> buscar();

	/**
	 * Atualiza dados do usuário passado no banco
	 * 
	 * @param bean
	 * @throws Exception
	 */
	public void atualizar(UsuarioBean bean) throws Exception;

	/**
	 * Realiza login do usuário
	 * 
	 * @param login
	 * @param senha
	 * 
	 * @return 0-Não encontrado, 1-Encontrado, 2-Login ou senha inválidos
	 */
	public int login(String login, String senha);

	/**
	 * Lê log do sistema em disco
	 * 
	 * @return String
	 */
	public String gerarLog();

	/**
	 * Converte um form em um bean
	 * 
	 * @param form
	 * @return UsuarioBean
	 */
	public UsuarioBean formToBean(UsuarioForm form);

	/**
	 * Converte um bean em um form
	 * 
	 * @param bean
	 * @return UsuarioForm
	 */
	public UsuarioForm beanToForm(UsuarioBean bean);

}
