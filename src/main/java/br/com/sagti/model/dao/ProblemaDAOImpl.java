/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informações da PUC-SP 2017.*/

package br.com.sagti.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.sagti.bean.ProblemaBean;
import br.com.sagti.model.entity.EProblema;
import br.com.sagti.model.repository.ProblemaRepository;

/**
 * Implementação do manipulador da entidade EProblema
 * 
 * @author felipe
 */
@Repository
@Transactional
public class ProblemaDAOImpl implements ProblemaDAO {

	@Autowired
	ProblemaRepository repositorio;

	private static final Logger LOGGER = Logger.getLogger(ProblemaDAO.class);

	/**
	 * Cria entidade no banco
	 * 
	 * @param ProblemaBean
	 * @return boolean
	 * @throws Exception
	 */
	public boolean create(ProblemaBean bean) {

		EProblema entity = new EProblema();
		entity.setDao(this);
		this.beanToEntity(entity, bean);

		try {
			repositorio.save(entity);
			repositorio.flush();
		} catch (Exception e) {
			LOGGER.warn(e);
			throw e;
		}

		return true;
	}

	/**
	 * Popula a Entidade com os dados do Bean
	 * 
	 * @param EProblema
	 * @param ProblemaBean
	 */
	public void beanToEntity(EProblema entity, ProblemaBean bean) {
		// Erro
		entity.setErroID(bean.getErroID());
		entity.setStatus(bean.getStatus());
		entity.setCategoria(bean.getCategoria());
		entity.setCompanhia(bean.getCompanhia());
		entity.setImpacto(bean.getImpacto());
		entity.setUrgencia(bean.getUrgencia());
		entity.setPrioridade(bean.getPrioridade());
		entity.setTitulo(bean.getTitulo());
		entity.setDescricao(bean.getDescricao());
		entity.setSolucao(bean.getSolucao());
		entity.setDataSolucao(bean.getDataSolucao());
		// Problema
		entity.setFase(bean.getFase());
		entity.setResponsavel(bean.getResponsavel());
		entity.setIncidentesRelacionados(bean.getIncidentesRelacionados());
		entity.setPrevisaoSolucao(bean.getPrevisaoSolucao());
		entity.setCausaRaiz(bean.getCausaRaiz());
		entity.setErroConhecido(bean.getErroConhecido());
	}

	/**
	 * Gera bean da entidade passada
	 * 
	 * @param EProblema
	 * @return ProblemaBean
	 */
	public ProblemaBean entityToBean(EProblema entity) {
		ProblemaBean bean = new ProblemaBean();
		// Erro
		bean.setErroID(entity.getErroID());
		bean.setStatus(entity.getStatus());
		bean.setCategoria(entity.getCategoria());
		bean.setCompanhia(entity.getCompanhia());
		bean.setImpacto(entity.getImpacto());
		bean.setUrgencia(entity.getUrgencia());
		bean.setPrioridade(entity.getPrioridade());
		bean.setTitulo(entity.getTitulo());
		bean.setDescricao(entity.getDescricao());
		bean.setSolucao(entity.getSolucao());
		bean.setDataSolucao(entity.getDataSolucao());
		// Problema
		bean.setFase(entity.getFase());
		bean.setResponsavel(entity.getResponsavel());
		bean.setIncidentesRelacionados(entity.getIncidentesRelacionados());
		bean.setPrevisaoSolucao(entity.getPrevisaoSolucao());
		bean.setCausaRaiz(entity.getCausaRaiz());
		bean.setErroConhecido(entity.getErroConhecido());

		return bean;
	}

	/**
	 * Busca lista de Problemas no banco
	 * 
	 * @return List<ProblemaBean>
	 */
	public List<ProblemaBean> findAll() {
		List<ProblemaBean> lista = new ArrayList<>();
		List<EProblema> listaEntities = new ArrayList<>();

		listaEntities = repositorio.findAll();
		for (EProblema eProblema : listaEntities) {
			lista.add(this.entityToBean(eProblema));
		}
		return lista;
	}

	/**
	 * Monta a query de acordo com parametros de entrada e executa no banco
	 * TODO: Não funciona pois o spring boot é limitado em execução de queries
	 * 
	 * @param ProblemaBean
	 * @param findAll
	 * @return List<ProblemaBean>
	 */
	public List<ProblemaBean> findByQuery(ProblemaBean bean, boolean findAll) {
		List<ProblemaBean> lista = new ArrayList<>();
		List<EProblema> listaEntities = new ArrayList<>();
		String and = " AND ";
		String queryBuild = "";

		// findAll
		if (findAll == true) {
			listaEntities = repositorio.findAll();
			for (EProblema eProblema : listaEntities) {
				lista.add(this.entityToBean(eProblema));
			}
			return lista;
		}

		// findById
		if (bean.getErroID() != 0) {
			EProblema problema = repositorio.findByErroID(bean.getErroID());
			if (problema != null)
				lista.add(this.entityToBean(problema));
			return lista;
		}

		// Valida todos os atributos e executa query
		queryBuild += "p.status LIKE " + bean.getDescricao();
		if (bean.getStatus() != null && bean.getStatus().trim() != "") {
			queryBuild += and + "p.status LIKE '%" + bean.getStatus() + "%'";
		}
		if (bean.getCategoria() != null && bean.getCategoria().trim() != "") {
			queryBuild += and + "p.categoria LIKE '%" + bean.getCategoria() + "%'";
		}
		if (bean.getCompanhia() != null && bean.getCompanhia().getNome().trim() != "") {
			queryBuild += and + "p.companhia.nome LIKE '%" + bean.getCompanhia().getNome() + "%'";
		}
		if (bean.getImpacto() != null && bean.getImpacto().trim() != "") {
			queryBuild += and + "p.impacto LIKE '%" + bean.getImpacto() + "%'";
		}
		if (bean.getUrgencia() != null && bean.getUrgencia().trim() != "") {
			queryBuild += and + "p.urgencia LIKE '%" + bean.getUrgencia() + "%'";
		}
		if (bean.getPrioridade() != null && bean.getPrioridade().trim() != "") {
			queryBuild += and + "p.prioridade = '" + bean.getPrioridade() + "'";
		}
		if (bean.getDescricao() != null && bean.getDescricao().trim() != "") {
			queryBuild += and + "p.descricao LIKE ''%" + bean.getDescricao() + "%'";
		}
		if (bean.getSolucao() != null && bean.getSolucao().trim() != "") {
			queryBuild += and + "p.solucao LIKE %" + bean.getSolucao() + "%'";
		}
		if (bean.getDataSolucao() != null) {
			queryBuild += and + "p.dataSolucao = " + bean.getDataSolucao();
		}
		if (bean.getFase() != null && bean.getFase().trim() != "") {
			queryBuild += and + "p.fase LIKE '%" + bean.getFase() + "%'";
		}
		if (bean.getResponsavel() != null && bean.getResponsavel().getNome().trim() != "") {
			queryBuild += and + "p.responsavel.nome LIKE '%" + bean.getResponsavel().getNome() + "%'";
		}
		if (bean.getPrevisaoSolucao() != null) {
			queryBuild += and + "p.previsaoSolucao = " + bean.getPrevisaoSolucao();
		}
		if (bean.getCausaRaiz() != null && bean.getCausaRaiz().trim() != "") {
			queryBuild += and + "p.causaRaiz LIKE '%" + bean.getCausaRaiz() + "%'";
		}
		if (bean.getErroConhecido()) {
			queryBuild += and + "p.erroConhecido = " + bean.getErroConhecido();
		}

		listaEntities = repositorio.findByQuery(queryBuild);
		for (EProblema problema : listaEntities) {
			lista.add(this.entityToBean(problema));
		}
		return lista;
	}

}
