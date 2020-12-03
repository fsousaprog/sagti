/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

package br.com.sagti.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.BeanUtils;

import br.com.sagti.model.dao.ServicoDAO;

/**
 * Entidade Servico (Tabela servico do banco)
 * 
 * @author felipe
 */
@Entity
@Table(name = "servico")
public class EServico {

	private long id;
	private String nome;
	private String descricao;
	private ECompanhia companhia;
	private String tipo;
	private String categoria;
	private String area;
	private ServicoDAO dao;

	/**
	 * @return id
	 */
	@Id
	@Column(name = "servicoID")
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
	 * @return descricao
	 */
	@Column(length = 255)
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return companhia
	 */
	@ManyToOne
	@JoinColumn(name = "companhiaID")
	public ECompanhia getCompanhia() {
		return companhia;
	}

	/**
	 * @param companhia
	 */
	public void setCompanhia(ECompanhia companhia) {
		this.companhia = companhia;
	}

	/**
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return dao
	 */
	@Transient
	public ServicoDAO getDao() {
		if (this.dao == null) {
			this.dao = BeanUtils.instantiate(ServicoDAO.class);
		}
		return this.dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(ServicoDAO dao) {
		this.dao = dao;
	}

}
