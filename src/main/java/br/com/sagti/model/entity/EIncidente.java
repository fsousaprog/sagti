/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

package br.com.sagti.model.entity;

import java.util.Date;

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

import br.com.sagti.model.dao.IncidenteDAO;

/**
 * Entidade Incidente (Tabela incidente do banco)
 * 
 * @author felipe
 */
@Entity
@Table(name = "incidente")
public class EIncidente {
	// Erro
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
	// Incidente
	protected EServico servico;
	private Date dataInicio;
	private IncidenteDAO dao;

	/**
	 * @return id
	 */
	@Id
	@Column(name = "incidenteID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getErroID() {
		return this.erroID;
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
	@Column(nullable = false)
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
	 * @return servico
	 */
	@ManyToOne
	@JoinColumn(name = "servicoID")
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
	@Column(nullable = false)
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
	@Column(nullable = false)
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
	@Column(nullable = false)
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
	@Transient
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

}
