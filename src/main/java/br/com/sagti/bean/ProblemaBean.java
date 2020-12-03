/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.bean;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.sagti.model.dao.ProblemaDAO;
import br.com.sagti.model.entity.EIncidente;
import br.com.sagti.model.entity.EUsuario;

/**
 * DTO manipulavel da entidade EProblema
 * 
 * @author felipe
 */
public class ProblemaBean extends ErroBean {

	private String fase;
	private EUsuario responsavel;
	private List<EIncidente> incidentesRelacionados;
	private Date previsaoSolucao;
	private String causaRaiz;
	private boolean erroConhecido;
	private ProblemaDAO dao;

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
	public EUsuario getResponsavel() {
		return responsavel;
	}

	/**
	 * @param responsavel
	 */
	public void setResponsavel(EUsuario responsavel) {
		this.responsavel = responsavel;
	}

	/**
	 * @return incidentesRelacionados
	 */
	public List<EIncidente> getIncidentesRelacionados() {
		return incidentesRelacionados;
	}

	/**
	 * @param incidentesRelacionados
	 */
	public void setIncidentesRelacionados(List<EIncidente> incidentesRelacionados) {
		this.incidentesRelacionados = incidentesRelacionados;
	}

	/**
	 * @return previsaoSolucao
	 */
	public Date getPrevisaoSolucao() {
		return previsaoSolucao;
	}

	/**
	 * @param previsaoSolucao
	 */
	public void setPrevisaoSolucao(Date previsaoSolucao) {
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
	public boolean getErroConhecido() {
		return erroConhecido;
	}

	/**
	 * @param erroConhecido
	 */
	public void setErroConhecido(boolean erroConhecido) {
		this.erroConhecido = erroConhecido;
	}

	/**
	 * @return dao
	 */
	public ProblemaDAO getDao() {
		if (this.dao == null) {
			this.dao = BeanUtils.instantiate(ProblemaDAO.class);
		}
		return (ProblemaDAO) this.dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(ProblemaDAO dao) {
		this.dao = dao;
	}

	/**
	 * Checa se bean está vazio
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		boolean vazio = true;

		if (!super.isEmpty()) {
			vazio = false;
		} else {
			if (!this.fase.equals("") || this.responsavel != null || this.incidentesRelacionados != null
					|| this.previsaoSolucao != null || !this.causaRaiz.equals("")) {
				vazio = false;
			}
		}

		return vazio;
	}

}
