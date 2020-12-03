/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

package br.com.sagti.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.BeanUtils;

import br.com.sagti.model.dao.CompanhiaDAO;

/**
 * Entidade Companhia (Tabela companhia do banco)
 * 
 * @author felipe
 */
@Entity
@Table(name = "companhia")
public class ECompanhia {

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
	@Id
	@Column(name = "companhiaID")
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
	 * @return nomeFantasia
	 */
	@Column(length = 100)
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
	@ManyToMany
	@JoinColumn(name = "servicoID")
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
	@Column(length = 100)
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
	@Transient
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

}
