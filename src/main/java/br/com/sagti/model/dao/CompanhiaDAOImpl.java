/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informações da PUC-SP 2017.*/

package br.com.sagti.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.sagti.bean.CompanhiaBean;
import br.com.sagti.model.entity.ECompanhia;
import br.com.sagti.model.repository.CompanhiaRepository;

/**
 * Implementação do manipulador da entidade ECompanhia
 * 
 * @author felipe
 */
@Repository
@Transactional
public class CompanhiaDAOImpl implements CompanhiaDAO {

	@Autowired
	CompanhiaRepository repositorio;

	private static final Logger LOGGER = Logger.getLogger(CompanhiaDAO.class);

	/**
	 * Cria entidade no banco
	 * 
	 * @param CompanhiaBean
	 * @return ECompanhia
	 * @throws Exception
	 */
	public ECompanhia create(CompanhiaBean bean) {
		ECompanhia entity = new ECompanhia();
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
	 * @param ECompanhia
	 * @param CompanhiaBean
	 */
	public void beanToEntity(ECompanhia entity, CompanhiaBean bean) {
		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		entity.setNomeFantasia(bean.getNomeFantasia());
		entity.setInicioParceria(bean.getInicioParceria());
		entity.setServicos(bean.getServicos());
		entity.setRamo(bean.getRamo());
	}

	/**
	 * Gera bean da entidade passada
	 * 
	 * @param ECompanhia
	 * @return CompanhiaBean
	 */
	public CompanhiaBean entityToBean(ECompanhia entity) {
		CompanhiaBean bean = new CompanhiaBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		bean.setNomeFantasia(entity.getNomeFantasia());
		bean.setInicioParceria(entity.getInicioParceria());
		bean.setServicos(entity.getServicos());
		bean.setRamo(entity.getRamo());

		return bean;
	}

	/**
	 * Busca lista de companhias no banco
	 * 
	 * @return List<ECompanhia>
	 */
	public List<CompanhiaBean> findAll() {
		List<CompanhiaBean> lista = new ArrayList<>();
		List<ECompanhia> listaEntities = new ArrayList<>();

		listaEntities = repositorio.findAll();
		for (ECompanhia eCompanhia : listaEntities) {
			lista.add(this.entityToBean(eCompanhia));
		}
		return lista;
	}

	/**
	 * Monta a query de acordo com parametros de entrada e executa no banco
	 * TODO: Não funciona pois o spring boot é limitado em execução de queries
	 * 
	 * @param CompanhiaBean
	 * @param findAll
	 * @return List<ECompanhia>
	 */
	public List<ECompanhia> findByQuery(CompanhiaBean bean, boolean findAll) {
		String and = " ";
		String queryBuild = "SELECT c FROM Companhia c";

		// findAll
		if (findAll == true) {
			return (List<ECompanhia>) repositorio.findByQuery(queryBuild);
		} else {
			queryBuild += " WHERE ";
		}
		// findById
		if (bean.getId() != 0) {
			queryBuild += "c.id = " + bean.getId();
			return (List<ECompanhia>) repositorio.findByQuery(queryBuild);
		}

		// Valida todos os atributos e executa query
		if (bean.getNome() != null && bean.getNome().trim() != "") {
			queryBuild += "c.nome LIKE %" + bean.getNome() + "%";
			and = " AND ";
		}
		if (bean.getNomeFantasia() != null && bean.getNomeFantasia().trim() != "") {
			queryBuild += and + "c.nomeFantasia LIKE %" + bean.getNomeFantasia() + "%";
			and = " AND ";
		}
		if (bean.getInicioParceria() != null) {
			queryBuild += and + "c.inicioParceria = %" + bean.getInicioParceria() + "%";
			and = " AND ";
		}
		if (bean.getRamo() != null && bean.getRamo().trim() != "") {
			queryBuild += and + "c.ramo LIKE %" + bean.getRamo() + "%";
		}

		return (List<ECompanhia>) repositorio.findByQuery(queryBuild);
	}

}
