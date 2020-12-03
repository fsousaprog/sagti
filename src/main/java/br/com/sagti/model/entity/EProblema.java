/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

package br.com.sagti.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.BeanUtils;

import br.com.sagti.model.dao.ProblemaDAO;

/**
 * Entidade Problema (Tabela problema do banco)
 * 
 * @author felipe
 */
@Entity
@Table(name = "problema")
public class EProblema {
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
	// Problema
	private String fase;
	private EUsuario responsavel;
	private List<EIncidente> incidentesRelacionados;
	private Date previsaoSolucao;
	private String causaRaiz;
	private boolean erroConhecido;
	private ProblemaDAO dao;

	/**
	 * @return id
	 */
	@Id
	@Column(name = "problemaID")
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
	 * @return fase
	 */
	@Column(nullable = false)
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
	@ManyToOne
	@JoinColumn(name = "usuarioID")
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
	@OneToMany(cascade = CascadeType.ALL, targetEntity = EIncidente.class, fetch = FetchType.EAGER)
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
	@Column(length = 255)
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
	@Column(nullable = false)
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
	@Transient
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

}
