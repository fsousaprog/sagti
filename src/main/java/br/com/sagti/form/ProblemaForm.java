/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.form;

/**
 * DTO manipulavel da entidade EProblema
 * 
 * @author felipe
 */
public class ProblemaForm extends ErroForm {

	private String fase;
	private String responsavelID;
	private String incidentesRelacionados;
	private String previsaoSolucao;
	private String causaRaiz;
	private String erroConhecido;

	/**
	 * @return fase
	 */
	public String getFase() {
		return fase;
	}

	/**
	 * @param fase
	 */
	public void setFase(String fase) {
		this.fase = fase;
	}

	/**
	 * @return responsavel
	 */
	public String getResponsavelID() {
		return responsavelID;
	}

	/**
	 * @param responsavel
	 */
	public void setResponsavelID(String responsavelID) {
		this.responsavelID = responsavelID;
	}

	/**
	 * @return incidentesRelacionados
	 */
	public String getIncidentesRelacionados() {
		return incidentesRelacionados;
	}

	/**
	 * @param incidentesRelacionados
	 */
	public void setIncidentesRelacionados(String incidentesRelacionados) {
		this.incidentesRelacionados = incidentesRelacionados;
	}

	/**
	 * @return previsaoSolucao
	 */
	public String getPrevisaoSolucao() {
		return previsaoSolucao;
	}

	/**
	 * @param previsaoSolucao
	 */
	public void setPrevisaoSolucao(String previsaoSolucao) {
		this.previsaoSolucao = previsaoSolucao;
	}

	/**
	 * @return causaRaiz
	 */
	public String getCausaRaiz() {
		return causaRaiz;
	}

	/**
	 * @param causaRaiz
	 */
	public void setCausaRaiz(String causaRaiz) {
		this.causaRaiz = causaRaiz;
	}

	/**
	 * @return erroConhecido
	 */
	public String getErroConhecido() {
		return erroConhecido;
	}

	/**
	 * @param erroConhecido
	 */
	public void setErroConhecido(String erroConhecido) {
		this.erroConhecido = erroConhecido;
	}

}
