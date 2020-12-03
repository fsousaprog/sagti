/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.form;

/**
 * DTO manipulavel da entidade ECompanhia
 * 
 * @author felipe
 */
public class CompanhiaForm {

	private String id;
	private String nome;
	private String nomeFantasia;
	private String inicioParceria;
	private String servicos;
	private String ramo;

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
	public String getInicioParceria() {
		return inicioParceria;
	}

	/**
	 * @param inicioParceria
	 */
	public void setInicioParceria(String inicioParceria) {
		this.inicioParceria = inicioParceria;
	}

	/**
	 * @return servicos
	 */
	public String getServicos() {
		return servicos;
	}

	/**
	 * @param servicos
	 */
	public void setServicos(String servicos) {
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

}
