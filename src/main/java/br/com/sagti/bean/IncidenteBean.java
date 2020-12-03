/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.bean;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import br.com.sagti.model.dao.IncidenteDAO;
import br.com.sagti.model.entity.EServico;

/**
 * DTO manipulavel da entidade EIncidente
 * 
 * @author felipe
 */
public class IncidenteBean extends ErroBean {

	private EServico servico;
	private Date dataInicio;
	private IncidenteDAO dao;

	/**
	 * @return servico
	 */
	public EServico getServico() {
		return servico;
	}

	/**
	 * @param servico
	 */
	public void setServico(EServico servico) {
		this.servico = servico;
	}

	/**
	 * @return dataInicio
	 */
	public Date getDataInicio() {
		return dataInicio;
	}

	/**
	 * @param dataInicio
	 */
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	/**
	 * @return dao
	 */
	public IncidenteDAO getDao() {
		if (this.dao == null) {
			this.dao = BeanUtils.instantiate(IncidenteDAO.class);
		}
		return (IncidenteDAO) this.dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(IncidenteDAO dao) {
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
			if (this.dataInicio != null || this.servico != null) {
				vazio = false;
			}
		}

		return vazio;
	}

}
