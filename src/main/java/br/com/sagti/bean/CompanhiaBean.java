/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.bean;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.sagti.model.dao.CompanhiaDAO;
import br.com.sagti.model.entity.EServico;

/**
 * DTO manipulavel da entidade ECompanhia
 * 
 * @author felipe
 */
public class CompanhiaBean {

	private long id;
	private String nome;
	private String nomeFantasia;
	private Date inicioParceria;
	private List<EServico> servicos;
	private String ramo;
	private CompanhiaDAO dao;

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
	 * @return nomeFantasia
	 */
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	/**
	 * @param nomeFantasia
	 */
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	/**
	 * @return inicioParceria
	 */
	public Date getInicioParceria() {
		return inicioParceria;
	}

	/**
	 * @param inicioParceria
	 */
	public void setInicioParceria(Date inicioParceria) {
		this.inicioParceria = inicioParceria;
	}

	/**
	 * @return servicos
	 */
	public List<EServico> getServicos() {
		return servicos;
	}

	/**
	 * @param servicos
	 */
	public void setServicos(List<EServico> servicos) {
		this.servicos = servicos;
	}

	/**
	 * @return ramo
	 */
	public String getRamo() {
		return ramo;
	}

	/**
	 * @param ramo
	 */
	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	/**
	 * @return dao
	 */
	public CompanhiaDAO getDao() {
		if (this.dao == null) {
			this.dao = BeanUtils.instantiate(CompanhiaDAO.class);
		}
		return this.dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(CompanhiaDAO dao) {
		this.dao = dao;
	}

	/**
	 * Checa se bean está vazio
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		boolean vazio = true;

		if (this.id != 0 || !this.nome.equals("") || !this.nomeFantasia.equals("") || this.inicioParceria != null
				|| this.servicos != null || !this.ramo.equals("")) {
			vazio = false;
		}

		return vazio;
	}

}
