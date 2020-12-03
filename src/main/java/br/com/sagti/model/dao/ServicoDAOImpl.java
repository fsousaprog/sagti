/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informações da PUC-SP 2017.*/

package br.com.sagti.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.sagti.bean.ServicoBean;
import br.com.sagti.model.entity.EServico;
import br.com.sagti.model.repository.ServicoRepository;

/**
 * Implementação do manipulador da entidade EServico
 * 
 * @author felipe
 */
@Repository
@Transactional
public class ServicoDAOImpl implements ServicoDAO{
	
	@Autowired
	ServicoRepository repositorio;
	
	private static final Logger LOGGER = Logger.getLogger(ServicoDAO.class);
	
	/**
	 * Cria entidade no banco
	 * 
	 * @param ServicoBean
	 * @return EServico
	 * @throws Exception
	 */
	public EServico create(ServicoBean bean) {
		
		EServico entity = new EServico();
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
	 * @param EServico
	 * @param ServicoBean
	 */
	public void beanToEntity(EServico entity, ServicoBean bean) {
		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		entity.setCompanhia(bean.getCompanhia());
		entity.setDescricao(bean.getDescricao());
		entity.setTipo(bean.getTipo());
		entity.setCategoria(bean.getCategoria());
		entity.setArea(bean.getArea());
	}
	
	/**
	 * Gera bean da entidade passada
	 * 
	 * @param EServico
	 * @return ServicoBean
	 */
	public ServicoBean entityToBean(EServico entity) {
		ServicoBean bean = new ServicoBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		bean.setCompanhia(entity.getCompanhia());
		bean.setDescricao(entity.getDescricao());
		bean.setTipo(entity.getTipo());
		bean.setCategoria(entity.getCategoria());
		bean.setArea(entity.getArea());
		
		return bean;
	}
	
	/**
	 * Busca lista de serviços no banco
	 * 
	 * @return List<ServicoBean>
	 */
	public List<ServicoBean> findAll() {
		List<ServicoBean> lista = new ArrayList<>();
		List<EServico> listaEntities = new ArrayList<>();
		
		listaEntities = repositorio.findAll();
		for (EServico eServico : listaEntities) {
			lista.add(this.entityToBean(eServico));
		}
		return lista;
	}
	
	/**
	 * Monta a query de acordo com parametros de entrada e executa no banco
	 * TODO: Não funciona pois o spring boot é limitado em execução de queries
	 * 
	 * @param ServicoBean
	 * @param findAll
	 * @return List<EServico>
	 */
	public List<EServico> findByQuery(ServicoBean bean, boolean findAll) {
		String and = " ";
		String queryBuild = "SELECT s FROM Servico s";
		
		// findAll
		if (findAll == true) {
			return (List<EServico>) repositorio.findByQuery(queryBuild);
		} else {
			queryBuild += " WHERE ";
		}
		// findById
		if (bean.getId() != 0) {
			queryBuild += "s.id = " + bean.getId();
			return (List<EServico>) repositorio.findByQuery(queryBuild);
		}
		
		// Valida todos os atributos e executa query
		if (bean.getDescricao() != null && bean.getDescricao().trim() != "") {
			queryBuild += "s.descricao LIKE %" + bean.getDescricao() + "%";
			and = " AND ";
		}		
		if (bean.getNome() != null && bean.getNome().trim() != "") {
			queryBuild += and + "s.nome LIKE %" + bean.getNome() + "%";
			and = " AND ";
		}		
		if (bean.getCompanhia() != null && bean.getCompanhia().getNome().trim() != "") {
			queryBuild += and + "s.companhia.nome LIKE %" + bean.getCompanhia().getNome() + "%";
			and = " AND ";
		}	
		if (bean.getTipo() != null && bean.getTipo().trim() != "") {
			queryBuild += and + "s.tipo LIKE %" + bean.getTipo() + "%";
			and = " AND ";
		}
		if (bean.getCategoria() != null && bean.getCategoria().trim() != "") {
			queryBuild += and + "s.categoria LIKE %" + bean.getCategoria() + "%";
			and = " AND ";
		}
		if (bean.getArea() != null && bean.getArea().trim() != "") {
			queryBuild += and + "s.area LIKE %" + bean.getArea() + "%";
		}
		
		return (List<EServico>) repositorio.findByQuery(queryBuild);
	}

}

	