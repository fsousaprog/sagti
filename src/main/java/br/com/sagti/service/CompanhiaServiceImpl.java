/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/
package br.com.sagti.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sagti.bean.CompanhiaBean;
import br.com.sagti.form.CompanhiaForm;
import br.com.sagti.model.dao.CompanhiaDAO;
import br.com.sagti.model.entity.ECompanhia;
import br.com.sagti.model.entity.EServico;
import br.com.sagti.model.repository.CompanhiaRepository;
import br.com.sagti.model.repository.ServicoRepository;

/**
 * Serviço responsável pelas ações sobre Companhia
 * 
 * @author felipe
 */
@Service
@Transactional
public class CompanhiaServiceImpl implements CompanhiaService {
	private static final Logger LOGGER = Logger.getLogger(CompanhiaDAO.class);

	@Autowired
	CompanhiaDAO dao;
	@Autowired
	CompanhiaRepository repositorio;
	@Autowired
	ServicoRepository servicoRepository;
	@Autowired
	CompanhiaRepository companhiaRepository;

	/**
	 * Insere companhia no banco
	 * 
	 * @param bean
	 * @throws RuntimeException
	 */
	public void inserir(CompanhiaBean bean) {
		List<ECompanhia> registrosExistentes = this.companhiaRepository.findByNome(bean.getNome());
		if (registrosExistentes.isEmpty()) {
			this.dao.create(bean);
		} else {
			throw new RuntimeException("Nome já existe");
		}
	}

	/**
	 * Busca Companhia(s) no banco
	 * 
	 * @return List<CompanhiaBean>
	 */
	public List<CompanhiaBean> buscar() {
		return this.dao.findAll();
	}

	/**
	 * Atualiza dados do companhia passado no banco
	 * 
	 * @param bean
	 * @throws Exception
	 */
	public void atualizar(CompanhiaBean bean) throws Exception {
		ECompanhia entity = new ECompanhia();
		this.dao.beanToEntity(entity, bean);
		try {
			this.repositorio.save(entity);
			LOGGER.info("Companhia de ID:" + entity.getId() + " foi atualizado com sucesso no banco");
		} catch (Exception e) {
			LOGGER.info("Não foi possivel atualizar o companhia de ID:" + entity.getId() + " no banco");
			throw e;
		}
	}

	/**
	 * Converte um form em um bean
	 * 
	 * @param form
	 * @return CompanhiaBean
	 * @throws Exception
	 */
	public CompanhiaBean formToBean(CompanhiaForm form) throws Exception {
		String expectedPattern = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
		CompanhiaBean bean = new CompanhiaBean();

		if (form.getId() != null)
			bean.setId(Long.valueOf(form.getId()));
		if (form.getServicos() != null && !form.getServicos().equals("")) {
			try {
				List<String> servicosList = new ArrayList<String>(Arrays.asList(form.getServicos().split(",")));
				List<EServico> servicos = new ArrayList<>();
				for (String servicoID : servicosList) {
					EServico servico = servicoRepository.findById(Long.valueOf(servicoID));
					servicos.add(servico);
				}
				bean.setServicos(servicos);
			} catch (Exception e) {
				LOGGER.error("Erro ao encontrar e salvar lista de servicos: " + e);
				throw new Exception(e);
			}
		}
		if (form.getInicioParceria() != null && !form.getInicioParceria().equals(""))
			bean.setInicioParceria(formatter.parse(form.getInicioParceria()));
		bean.setNome(form.getNome());
		bean.setNomeFantasia(form.getNomeFantasia());
		bean.setRamo(form.getRamo());

		return bean;
	}

	/**
	 * Converte um bean em um form
	 * 
	 * @param bean
	 * @return CompanhiaForm
	 */
	public CompanhiaForm beanToForm(CompanhiaBean bean) {
		CompanhiaForm form = new CompanhiaForm();

		if (bean.getId() != 0)
			form.setId(String.valueOf(bean.getId()));
		if (!bean.getServicos().isEmpty()) {
			List<String> servicos = new ArrayList<>();
			for (EServico servico : bean.getServicos()) {
				servicos.add(String.valueOf(servico.getId()));
			}
			form.setServicos(String.join(", ", servicos));
		}
		if (bean.getInicioParceria() != null)
			form.setInicioParceria(String.valueOf(bean.getInicioParceria()));
		form.setNome(bean.getNome());
		form.setNomeFantasia(bean.getNomeFantasia());
		form.setRamo(bean.getRamo());

		return form;
	}

}
