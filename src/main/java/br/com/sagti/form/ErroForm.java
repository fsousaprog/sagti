/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.form;

/**
 * DTO manipulavel da entidade EErro
 * 
 * @author felipe
 */
public class ErroForm {

	protected String erroID;
	protected String status;
	protected String categoria;
	protected String companhiaID;
	protected String impacto;
	protected String urgencia;
	protected String prioridade;
	protected String titulo;
	protected String descricao;
	protected String solucao;
	protected String dataSolucao;

	/**
	 * @return erroID
	 */
	public String getErroID() {
		return erroID;
	}

	/**
	 * @param erroID
	 */
	public void setErroID(String erroID) {
		this.erroID = erroID;
	}

	/**
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return impacto
	 */
	public String getImpacto() {
		return impacto;
	}

	/**
	 * @param impacto
	 */
	public void setImpacto(String impacto) {
		this.impacto = impacto;
	}

	/**
	 * @return urgencia
	 */
	public String getUrgencia() {
		return urgencia;
	}

	/**
	 * @param urgencia
	 */
	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}

	/**
	 * @return prioridade
	 */
	public String getPrioridade() {
		return prioridade;
	}

	/**
	 * @param prioridade
	 */
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	/**
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	 * @return solucao
	 */
	public String getSolucao() {
		return solucao;
	}

	/**
	 * @param solucao
	 */
	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	/**
	 * @return dataSolucao
	 */
	public String getDataSolucao() {
		return dataSolucao;
	}

	/**
	 * @param dataSolucao
	 */
	public void setDataSolucao(String dataSolucao) {
		this.dataSolucao = dataSolucao;
	}

}
