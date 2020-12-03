/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.bean;

import org.springframework.beans.BeanUtils;

import br.com.sagti.model.dao.UsuarioDAO;

/**
 * DTO manipulavel da entidade EUsuario
 * 
 * @author felipe
 */
public class UsuarioBean {

	private long id;
	private String nome;
	private String login;
	private String senha;
	private String cargo;
	private int nivelAcesso;
	private UsuarioDAO dao;

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return nivelAcesso
	 */
	public int getNivelAcesso() {
		return nivelAcesso;
	}

	/**
	 * @param nivelAcesso
	 */
	public void setNivelAcesso(int nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	/**
	 * @return cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return dao
	 */
	public UsuarioDAO getDao() {
		if (this.dao == null) {
			this.dao = BeanUtils.instantiate(UsuarioDAO.class);
		}
		return this.dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}

	/**
	 * Checa se bean está vazio
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		boolean vazio = true;

		if (this.id != 0 || !this.nome.equals("") || !this.login.equals("") || !this.senha.equals("")
				|| !this.cargo.equals("") || this.nivelAcesso != 0) {
			vazio = false;
		}

		return vazio;
	}

}
