/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/
package br.com.sagti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sagti.bean.ServicoBean;
import br.com.sagti.control.ServicoAction;
import br.com.sagti.form.ServicoForm;
import br.com.sagti.model.dao.ServicoDAO;
import br.com.sagti.model.entity.EServico;
import br.com.sagti.model.repository.CompanhiaRepository;
import br.com.sagti.model.repository.ServicoRepository;

/**
 * Serviço responsável pelas ações sobre Servico
 * 
 * @author felipe
 */
@Service
@Transactional
public class ServicoServiceImpl implements ServicoService {
	private static final Logger LOGGER = Logger.getLogger(ServicoAction.class);

	@Autowired
	ServicoDAO dao;
	@Autowired
	ServicoRepository repositorio;
	@Autowired
	CompanhiaRepository companhiaRepositorio;

	/**
	 * Insere Serviço no banco
	 * 
	 * @param bean
	 */
	public void inserir(ServicoBean bean) {
		this.dao.create(bean);
	}

	/**
	 * Busca Servico(s) no banco
	 * 
	 * @return List<ServicoBean>
	 */
	public List<ServicoBean> buscar() {
		return this.dao.findAll();
	}

	/**
	 * Atualiza dados do servico passado no banco
	 * 
	 * @param bean
	 * @throws Exception
	 */
	public void atualizar(ServicoBean bean) throws Exception {
		EServico entity = new EServico();
		this.dao.beanToEntity(entity, bean);
		try {
			this.repositorio.save(entity);
			LOGGER.info("Serviço de ID:" + entity.getId() + " foi atualizado com sucesso no banco");
		} catch (Exception e) {
			LOGGER.info("Não foi possivel atualizar o serviço de ID:" + entity.getId() + " no banco");
			throw e;
		}
	}

	/**
	 * Converte um form em um bean
	 * 
	 * @param form
	 * @return ServicoBean
	 * @throws Exception
	 */
	public ServicoBean formToBean(ServicoForm form) throws Exception {
		ServicoBean bean = new ServicoBean();

		if (form.getId() != null)
			bean.setId(Long.valueOf(form.getId()));
		if (form.getCompanhiaID() != "" && form.getCompanhiaID() != null) {
			try {
				bean.setCompanhia(this.companhiaRepositorio.findById(Long.valueOf(form.getCompanhiaID())));
			} catch (Exception e) {
				LOGGER.error("Problema ao buscar companhia" + e);
				throw new Exception(e);
			}
		}
		bean.setCategoria(form.getCategoria());
		bean.setDescricao(form.getDescricao());
		bean.setArea(form.getArea());
		bean.setNome(form.getNome());
		bean.setTipo(form.getTipo());

		return bean;
	}

	/**
	 * Converte um bean em um form
	 * 
	 * @param bean
	 * @return ServicoForm
	 */
	public ServicoForm beanToForm(ServicoBean bean) {
		ServicoForm form = new ServicoForm();

		if (bean.getId() != 0)
			form.setId(String.valueOf(bean.getId()));
		if (bean.getCompanhia() != null) {
			form.setCompanhiaID(String.valueOf(bean.getCompanhia().getId()));
		}
		form.setCategoria(bean.getCategoria());
		form.setDescricao(bean.getDescricao());
		form.setArea(bean.getArea());
		form.setNome(bean.getNome());
		form.setTipo(bean.getTipo());

		return form;
	}

}
