/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.form;

/**
 * DTO manipulavel da entidade EIncidente
 * 
 * @author felipe
 */
public class IncidenteForm extends ErroForm {

	protected String servicoID;
	private String dataInicio;

	/**
	 * @return servico
	 */
	public String getServicoID() {
		return servicoID;
	}

	/**
	 * @param servico
	 */
	public void setServicoID(String servicoID) {
		this.servicoID = servicoID;
	}
	
	/**
	 * @return dataInicio
	 */
	public String getDataInicio() {
		return dataInicio;
	}

	/**
	 * @param dataInicio
	 */
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

}
