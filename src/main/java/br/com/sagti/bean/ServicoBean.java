/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.bean;

import org.springframework.beans.BeanUtils;

import br.com.sagti.model.dao.ServicoDAO;
import br.com.sagti.model.entity.ECompanhia;

/**
 * DTO manipulavel da entidade EServico
 * 
 * @author felipe
 */
public class ServicoBean {

	private long id;
	private String descricao;
	private String nome;
	private ECompanhia companhia;
	private String tipo;
	private String categoria;
	private String area;
	private ServicoDAO dao;

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
	 * @return descricao
	 */
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

	/**
	 * Checa se bean está vazio
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		boolean vazio = true;

		if (this.id != 0 || !this.nome.equals("") || !this.descricao.equals("") || this.companhia != null
				|| !this.tipo.equals("") || !this.categoria.equals("") || !this.area.equals("")) {
			vazio = false;
		}

		return vazio;
	}

}
