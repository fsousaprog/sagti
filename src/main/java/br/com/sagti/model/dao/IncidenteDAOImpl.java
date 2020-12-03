/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informações da PUC-SP 2017.*/

package br.com.sagti.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.sagti.bean.IncidenteBean;
import br.com.sagti.model.entity.EIncidente;
import br.com.sagti.model.repository.IncidenteRepository;

/**
 * Implementação do manipulador da entidade EIncidente
 * 
 * @author felipe
 */
@Repository
@Transactional
public class IncidenteDAOImpl implements IncidenteDAO {

	@Autowired
	IncidenteRepository repositorio;

	private static final Logger LOGGER = Logger.getLogger(IncidenteDAO.class);

	/**
	 * Cria entidade no banco
	 * 
	 * @param IncidenteBean
	 * @return EIncidente
	 * @throws Exception
	 */
	public EIncidente create(IncidenteBean bean) {

		EIncidente entity = new EIncidente();
		entity.setDao(this);
		this.beanToEntity(entity, bean);

		try {
			repositorio.save(entity);
			repositorio.flush();
		} catch (Exception e) {
			LOGGER.warn(e);
			throw e;
		}

		return entity;
	}

	/**
	 * Popula a Entidade com os dados do Bean
	 * 
	 * @param EIncidente
	 * @param IncidenteBean
	 */
	public void beanToEntity(EIncidente entity, IncidenteBean bean) {

		// Erro
		entity.setErroID(bean.getErroID());
		entity.setStatus(bean.getStatus());
		entity.setServico(bean.getServico());
		entity.setCategoria(bean.getCategoria());
		entity.setCompanhia(bean.getCompanhia());
		entity.setImpacto(bean.getImpacto());
		entity.setUrgencia(bean.getUrgencia());
		entity.setPrioridade(bean.getPrioridade());
		entity.setTitulo(bean.getTitulo());
		entity.setDescricao(bean.getDescricao());
		entity.setSolucao(bean.getSolucao());
		entity.setDataSolucao(bean.getDataSolucao());
		// Incidente
		entity.setDataInicio(bean.getDataInicio());
	}

	/**
	 * Gera bean da entidade passada
	 * 
	 * @param EIncidente
	 * @return IncidenteBean
	 */
	public IncidenteBean entityToBean(EIncidente entity) {
		IncidenteBean bean = new IncidenteBean();

		// Erro
		bean.setErroID(entity.getErroID());
		bean.setStatus(entity.getStatus());
		bean.setServico(entity.getServico());
		bean.setCategoria(entity.getCategoria());
		bean.setCompanhia(entity.getCompanhia());
		bean.setImpacto(entity.getImpacto());
		bean.setUrgencia(entity.getUrgencia());
		bean.setPrioridade(entity.getPrioridade());
		bean.setTitulo(entity.getTitulo());
		bean.setDescricao(entity.getDescricao());
		bean.setSolucao(entity.getSolucao());
		bean.setDataSolucao(entity.getDataSolucao());
		// Incidente
		bean.setDataInicio(entity.getDataInicio());

		return bean;
	}

	/**
	 * Busca lista de Incidentess no banco
	 * 
	 * @return List<IncidenteBean>
	 */
	public List<IncidenteBean> findAll() {
		List<IncidenteBean> lista = new ArrayList<>();
		List<EIncidente> listaEntities = new ArrayList<>();

		listaEntities = repositorio.findAll();
		for (EIncidente eIncidente : listaEntities) {
			lista.add(this.entityToBean(eIncidente));
		}
		return lista;
	}

	/**
	 * Monta a query de acordo com parametros de entrada e executa no banco
	 * TODO: Não funciona pois o spring boot é limitado em execução de queries
	 * 
	 * @param IncidenteBean
	 * @param findAll
	 * @return List<EIncidente>
	 */
	public List<EIncidente> findByQuery(IncidenteBean bean, boolean findAll) {
		String and = " ";
		String queryBuild = "SELECT i FROM Incidente i";

		// findAll
		if (findAll == true) {
			return repositorio.findByQuery(queryBuild);
		} else {
			queryBuild += " WHERE ";
		}
		// findById
		if (bean.getErroID() != 0) {
			queryBuild += "i.id = " + bean.getErroID();
			return repositorio.findByQuery(queryBuild);
		}

		// Valida todos os atributos e executa query
		if (bean.getStatus() != null && bean.getStatus().trim() != "") {
			queryBuild += "i.status LIKE " + bean.getDescricao();
			and = " AND ";
		}
		if (bean.getServico() != null && bean.getServico().getNome().trim() != "") {
			queryBuild += and + "i.servico.nome LIKE %" + bean.getServico().getNome() + "%";
			and = " AND ";
		}
		if (bean.getCategoria() != null && bean.getCategoria().trim() != "") {
			queryBuild += and + "i.categoria LIKE %" + bean.getCategoria() + "%";
			and = " AND ";
		}
		if (bean.getCompanhia() != null && bean.getCompanhia().getNome().trim() != "") {
			queryBuild += and + "i.companhia.nome LIKE %" + bean.getCompanhia().getNome() + "%";
			and = " AND ";
		}
		if (bean.getImpacto() != null && bean.getImpacto().trim() != "") {
			queryBuild += and + "i.impacto LIKE %" + bean.getImpacto() + "%";
			and = " AND ";
		}
		if (bean.getUrgencia() != null && bean.getUrgencia().trim() != "") {
			queryBuild += and + "i.urgencia LIKE %" + bean.getUrgencia() + "%";
			and = " AND ";
		}
		if (bean.getPrioridade() != null && bean.getPrioridade().trim() != "") {
			queryBuild += and + "i.prioridade = " + bean.getPrioridade();
			and = " AND ";
		}
		if (bean.getTitulo() != null && bean.getTitulo().trim() != "") {
			queryBuild += and + "i.titulo LIKE %" + bean.getTitulo() + "%";
			and = " AND ";
		}
		if (bean.getDescricao() != null && bean.getDescricao().trim() != "") {
			queryBuild += and + "i.descricao LIKE %" + bean.getDescricao() + "%";
			and = " AND ";
		}
		if (bean.getSolucao() != null && bean.getSolucao().trim() != "") {
			queryBuild += and + "i.solucao LIKE %" + bean.getSolucao() + "%";
			and = " AND ";
		}
		if (bean.getDataSolucao() != null) {
			queryBuild += and + "i.dataSolucao = " + bean.getDataSolucao();
			and = " AND ";
		}
		if (bean.getDataInicio() != null) {
			queryBuild += and + "i.dataInicio = " + bean.getDataInicio();
		}

		return repositorio.findByQuery(queryBuild);
	}

}
