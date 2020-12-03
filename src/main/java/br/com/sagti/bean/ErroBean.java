/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.bean;

import java.util.Date;

import br.com.sagti.model.entity.ECompanhia;

/**
 * DTO manipulavel da entidade EErro
 * 
 * @author felipe
 */
public class ErroBean {

	protected long erroID;
	protected String status;
	protected String categoria;
	protected ECompanhia companhia;
	protected String impacto;
	protected String urgencia;
	protected String prioridade;
	protected String titulo;
	protected String descricao;
	protected String solucao;
	protected Date dataSolucao;

	/**
	 * @return erroID
	 */
	public long getErroID() {
		return erroID;
	}

	/**
	 * @param erroID
	 */
	public void setErroID(long erroID) {
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
	public Date getDataSolucao() {
		return dataSolucao;
	}

	/**
	 * @param dataSolucao
	 */
	public void setDataSolucao(Date dataSolucao) {
		this.dataSolucao = dataSolucao;
	}

	/**
	 * Checa se bean está vazio
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		boolean vazio = true;

		if (this.erroID != 0 || !this.status.equals("") || !this.categoria.equals("") || this.companhia != null
				|| !this.impacto.equals("") || !this.urgencia.equals("") || !this.prioridade.equals("")
				|| !this.titulo.equals("") || !this.descricao.equals("") || !this.solucao.equals("")
				|| this.dataSolucao != null) {
			vazio = false;
		}

		return vazio;
	}

}
