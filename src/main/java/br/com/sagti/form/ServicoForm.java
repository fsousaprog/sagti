/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.form;

/**
 * DTO manipulavel da entidade EServico
 * 
 * @author felipe
 */
public class ServicoForm {

	private String id;
	private String descricao;
	private String nome;
	private String companhiaID;
	private String tipo;
	private String categoria;
	private String area;

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
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
	public String getCompanhiaID() {
		return companhiaID;
	}

	/**
	 * @param companhia
	 */
	public void setCompanhiaID(String companhiaID) {
		this.companhiaID = companhiaID;
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

}
