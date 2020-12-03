/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/
package br.com.sagti.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sagti.bean.IncidenteBean;
import br.com.sagti.form.IncidenteForm;
import br.com.sagti.model.dao.CompanhiaDAO;
import br.com.sagti.model.dao.IncidenteDAO;
import br.com.sagti.model.entity.ECompanhia;
import br.com.sagti.model.entity.EIncidente;
import br.com.sagti.model.entity.EServico;
import br.com.sagti.model.repository.CompanhiaRepository;
import br.com.sagti.model.repository.IncidenteRepository;
import br.com.sagti.model.repository.ServicoRepository;

/**
 * Incidente responsável pelas ações sobre Incidente
 * 
 * @author felipe
 */
@Service
@Transactional
public class IncidenteServiceImpl implements IncidenteService {
	private static final Logger LOGGER = Logger.getLogger(CompanhiaDAO.class);

	@Autowired
	IncidenteDAO dao;
	@Autowired
	IncidenteRepository repositorio;
	@Autowired
	ServicoRepository servicoRepositorio;
	@Autowired
	CompanhiaRepository companhiaRepositorio;

	/**
	 * Insere Serviço no banco
	 * 
	 * @param bean
	 * @throws Exception
	 */
	public void inserir(IncidenteBean bean) {
		try {
			this.dao.create(bean);
		} catch (Exception e) {
			LOGGER.error(e);
			throw e;
		}
	}

	/**
	 * Busca Incidente(s) no banco
	 * 
	 * @return List<IncidenteBean>
	 */
	public List<IncidenteBean> buscar() {
		return this.dao.findAll();
	}

	/**
	 * Atualiza dados do incidente passado no banco
	 * 
	 * @param bean
	 * @throws Exception
	 */
	public void atualizar(IncidenteBean bean) throws Exception {
		EIncidente entity = new EIncidente();
		this.dao.beanToEntity(entity, bean);
		try {
			this.repositorio.save(entity);
			LOGGER.info("Incidente de ID:" + entity.getErroID() + " foi atualizado com sucesso no banco");
		} catch (Exception e) {
			LOGGER.info("Não foi possivel atualizar o incidente de ID:" + entity.getErroID() + " no banco");
			throw e;
		}
	}

	/**
	 * Gera JSONs na estrutura do ChartJs com dados do banco
	 * 
	 * @return HashMap<String, List>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, List> gerarRelatorios() throws Exception {
		Map<String, List> listas = new HashMap<String, List>();
		List<IncidenteBean> incidentes = this.dao.findAll();

		// Monta json de acordo com a estrutura do chartjs
		// No Map, a string é o nome do item
		// e o integer é a quantidade daquele item
		Map<String, Integer> statusMap = new HashMap<>();
		Map<String, Integer> categoriasMap = new HashMap<>();
		Map<String, Integer> companhiasMap = new HashMap<>();
		Map<String, Integer> servicosMap = new HashMap<>();

		try {

			// Separa por atributo e gera a quantidade de cada atributo
			for (IncidenteBean incidente : incidentes) {
				String status = incidente.getStatus();
				String categoria = incidente.getCategoria();
				String companhia = "";
				String servico = "";

				if (incidente.getCompanhia() != null) {
					companhia = incidente.getCompanhia().getNome();
				}
				if (incidente.getServico() != null) {
					servico = incidente.getServico().getNome();
				}

				// Status
				if (!status.equals("")) {
					if (!statusMap.containsKey(status)) {
						statusMap.put(status, 1);
					} else {
						statusMap.replace(status, statusMap.get(status) + 1);
					}
				}
				// Categoria
				if (!categoria.equals("")) {
					if (!categoriasMap.containsKey(categoria)) {
						categoriasMap.put(categoria, 1);
					} else {
						categoriasMap.replace(categoria, categoriasMap.get(categoria) + 1);
					}
				}
				// Companhia
				if (!companhia.equals("")) {
					if (!companhiasMap.containsKey(companhia)) {
						companhiasMap.put(companhia, 1);
					} else {
						companhiasMap.replace(companhia, companhiasMap.get(companhia) + 1);
					}
				}
				// Serviço
				if (!servico.equals("")) {
					if (!servicosMap.containsKey(servico)) {
						servicosMap.put(servico, 1);
					} else {
						servicosMap.replace(servico, servicosMap.get(servico) + 1);
					}
				}

			}

			// Separa as chaves dos valores em listas
			List<String> statusLabelList = new ArrayList<>();
			List<Integer> statusData = new ArrayList<>();
			List<String> categoriasLabelList = new ArrayList<>();
			List<Integer> categoriasData = new ArrayList<>();
			List<String> companhiasLabelList = new ArrayList<>();
			List<Integer> companhiasData = new ArrayList<>();
			List<String> servicosLabelList = new ArrayList<>();
			List<Integer> servicosData = new ArrayList<>();

			statusLabelList.addAll(statusMap.keySet());
			statusData.addAll(statusMap.values());
			categoriasLabelList.addAll(categoriasMap.keySet());
			categoriasData.addAll(categoriasMap.values());
			companhiasLabelList.addAll(companhiasMap.keySet());
			companhiasData.addAll(companhiasMap.values());
			servicosLabelList.addAll(servicosMap.keySet());
			servicosData.addAll(servicosMap.values());

			// Tranforma as chaves em strings de maneira que o chartjs entenda
			List<String> statusLabel = new ArrayList<>();
			List<String> categoriasLabel = new ArrayList<>();
			List<String> companhiasLabel = new ArrayList<>();
			List<String> servicosLabel = new ArrayList<>();

			for (int i = 0; i < statusLabelList.size(); i++) {
				statusLabel.add("\"" + statusLabelList.get(i) + "\"");
			}
			for (int i = 0; i < categoriasLabelList.size(); i++) {
				categoriasLabel.add("\"" + categoriasLabelList.get(i) + "\"");
			}
			for (int i = 0; i < companhiasLabelList.size(); i++) {
				companhiasLabel.add("\"" + companhiasLabelList.get(i) + "\"");
			}
			for (int i = 0; i < servicosLabelList.size(); i++) {
				servicosLabel.add("\"" + servicosLabelList.get(i) + "\"");
			}

			// seta os dados em uma lista para enviar para a action
			listas.put("statusLabel", statusLabel);
			listas.put("statusData", statusData);
			listas.put("categoriasLabel", categoriasLabel);
			listas.put("categoriasData", categoriasData);
			listas.put("companhiasLabel", companhiasLabel);
			listas.put("companhiasData", companhiasData);
			listas.put("servicosLabel", servicosLabel);
			listas.put("servicosData", servicosData);

		} catch (Exception e) {
			LOGGER.info("Problemas ao gerar relatório de incidentes");
			throw new Exception(e);
		}

		LOGGER.info("Relatório de incidentes gerado e encaminhado para IncidenteAction");
		return listas;
	}

	/**
	 * Converte um form em um bean
	 * 
	 * @param form
	 * @return IncidenteBean
	 * @throws ParseException
	 */
	public IncidenteBean formToBean(IncidenteForm form) throws ParseException {
		String expectedPattern = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
		IncidenteBean bean = new IncidenteBean();

		if (form.getErroID() != null)
			bean.setErroID(Long.valueOf(form.getErroID()));
		if (form.getCompanhiaID() != "" && form.getCompanhiaID() != null) {
			ECompanhia companhia = this.companhiaRepositorio.findById(Long.valueOf(form.getCompanhiaID()));
			if (companhia != null)
				bean.setCompanhia(companhia);
		}
		if (form.getServicoID() != "" && form.getServicoID() != null) {
			EServico servico = this.servicoRepositorio.findById(Long.valueOf(form.getServicoID()));
			if (servico != null)
				bean.setServico(servico);
		}
		if (form.getDataInicio() != "" && form.getDataInicio() != null)
			bean.setDataInicio(formatter.parse(form.getDataInicio()));
		if (form.getDataSolucao() != "" && form.getDataSolucao() != null)
			bean.setDataSolucao(formatter.parse(form.getDataSolucao()));
		bean.setPrioridade(form.getPrioridade());
		bean.setCategoria(form.getCategoria());
		bean.setDescricao(form.getDescricao());
		bean.setImpacto(form.getImpacto());
		bean.setSolucao(form.getSolucao());
		bean.setStatus(form.getStatus());
		bean.setTitulo(form.getTitulo());
		bean.setUrgencia(form.getUrgencia());

		return bean;
	}

	/**
	 * Converte um bean em um form
	 * 
	 * @param bean
	 * @return IncidenteForm
	 */
	public IncidenteForm beanToForm(IncidenteBean bean) {
		IncidenteForm form = new IncidenteForm();

		if (bean.getErroID() != 0)
			form.setErroID(String.valueOf(bean.getErroID()));
		if (bean.getCompanhia() != null)
			form.setCompanhiaID(String.valueOf(bean.getCompanhia().getId()));
		if (bean.getServico() != null)
			form.setServicoID(String.valueOf(bean.getServico().getId()));
		if (bean.getDataInicio() != null)
			form.setDataInicio(String.valueOf(bean.getDataInicio()));
		if (bean.getDataSolucao() != null)
			form.setDataSolucao(String.valueOf(bean.getDataSolucao()));
		form.setPrioridade(bean.getPrioridade());
		form.setCategoria(bean.getCategoria());
		form.setDescricao(bean.getDescricao());
		form.setImpacto(bean.getImpacto());
		form.setSolucao(bean.getSolucao());
		form.setStatus(bean.getStatus());
		form.setTitulo(bean.getTitulo());
		form.setUrgencia(bean.getUrgencia());

		return form;
	}

}
