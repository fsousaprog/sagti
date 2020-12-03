/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

package br.com.sagti.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.BeanUtils;

import br.com.sagti.model.dao.UsuarioDAO;

/**
 * Entidade Usuario (Tabela Usuario do banco)
 * 
 * @author felipe
 */
@Entity
@Table(name = "usuario")
public class EUsuario {

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
	@Id
	@Column(name = "usuarioID")
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@Column(length = 100, nullable = false)
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
	@Column(nullable = false)
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
	@Column(nullable = false)
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
	@Column(length = 30, nullable = false)
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
	@Transient
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

}
