/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/
package br.com.sagti.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sagti.bean.ProblemaBean;
import br.com.sagti.form.ProblemaForm;
import br.com.sagti.model.dao.CompanhiaDAO;
import br.com.sagti.model.dao.ProblemaDAO;
import br.com.sagti.model.entity.ECompanhia;
import br.com.sagti.model.entity.EIncidente;
import br.com.sagti.model.entity.EProblema;
import br.com.sagti.model.entity.EUsuario;
import br.com.sagti.model.repository.CompanhiaRepository;
import br.com.sagti.model.repository.IncidenteRepository;
import br.com.sagti.model.repository.ProblemaRepository;
import br.com.sagti.model.repository.ServicoRepository;
import br.com.sagti.model.repository.UsuarioRepository;

/**
 * Serviço responsável pelas ações sobre Problema
 * 
 * @author felipe
 */
@Service
@Transactional
public class ProblemaServiceImpl implements ProblemaService {
	private static final Logger LOGGER = Logger.getLogger(CompanhiaDAO.class);

	@Autowired
	ProblemaDAO dao;
	@Autowired
	ProblemaRepository repositorio;
	@Autowired
	ServicoRepository servicoRepositorio;
	@Autowired
	CompanhiaRepository companhiaRepositorio;
	@Autowired
	IncidenteRepository incidenteRepositorio;
	@Autowired
	UsuarioRepository usuarioRepositorio;

	/**
	 * Insere Serviço no banco
	 * 
	 * @param bean
	 * @throws Exception
	 */
	public void inserir(ProblemaBean bean) {
		try {
			this.dao.create(bean);
		} catch (Exception e) {
			LOGGER.error(e);
			throw e;
		}
	}

	/**
	 * Busca Problema(s) no banco
	 * 
	 * @return List<ProblemaBean>
	 */
	public List<ProblemaBean> buscar() {
		return this.dao.findAll();
	}

	/**
	 * Atualiza dados do problema passado no banco
	 * 
	 * @param bean
	 * @throws Exception
	 */
	public void atualizar(ProblemaBean bean) throws Exception {
		EProblema entity = new EProblema();
		this.dao.beanToEntity(entity, bean);
		try {
			this.repositorio.save(entity);
			LOGGER.info("Problema de ID:" + entity.getErroID() + " foi atualizado com sucesso no banco");
		} catch (Exception e) {
			LOGGER.info("Não foi possivel atualizar o problema de ID:" + entity.getErroID() + " no banco");
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
		List<ProblemaBean> problemas = this.dao.findAll();

		// Monta json de acordo com a estrutura do chartjs
		// No Map, a string é o nome do item
		// e o integer é a quantidade daquele item
		Map<String, Integer> statusMap = new HashMap<>();
		Map<String, Integer> categoriaMap = new HashMap<>();
		Map<String, Integer> companhiaMap = new HashMap<>();

		try {

			// Separa por atributo e gera a quantidade de cada atributo
			for (ProblemaBean problema : problemas) {
				String status = problema.getStatus();
				String categoria = problema.getCategoria();
				String companhia = "";

				if (problema.getCompanhia() != null) {
					companhia = problema.getCompanhia().getNome();
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
					if (!categoriaMap.containsKey(categoria)) {
						categoriaMap.put(categoria, 1);
					} else {
						categoriaMap.replace(categoria, categoriaMap.get(categoria) + 1);
					}
				}
				// Companhia
				if (!companhia.equals("")) {
					if (!companhiaMap.containsKey(companhia)) {
						companhiaMap.put(companhia, 1);
					} else {
						companhiaMap.replace(companhia, companhiaMap.get(companhia) + 1);
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

			statusLabelList.addAll(statusMap.keySet());
			statusData.addAll(statusMap.values());
			categoriasLabelList.addAll(categoriaMap.keySet());
			categoriasData.addAll(categoriaMap.values());
			companhiasLabelList.addAll(companhiaMap.keySet());
			companhiasData.addAll(companhiaMap.values());

			// Tranforma as chaves em strings de maneira que o chartjs entenda
			List<String> statusLabel = new ArrayList<>();
			List<String> categoriasLabel = new ArrayList<>();
			List<String> companhiasLabel = new ArrayList<>();

			for (int i = 0; i < statusLabelList.size(); i++) {
				statusLabel.add("\"" + statusLabelList.get(i) + "\"");
			}
			for (int i = 0; i < categoriasLabelList.size(); i++) {
				categoriasLabel.add("\"" + categoriasLabelList.get(i) + "\"");
			}
			for (int i = 0; i < companhiasLabelList.size(); i++) {
				companhiasLabel.add("\"" + companhiasLabelList.get(i) + "\"");
			}

			// seta os dados em uma lista para enviar para a action
			listas.put("statusLabel", statusLabel);
			listas.put("statusData", statusData);
			listas.put("categoriasLabel", categoriasLabel);
			listas.put("categoriasData", categoriasData);
			listas.put("companhiasLabel", companhiasLabel);
			listas.put("companhiasData", companhiasData);

		} catch (Exception e) {
			LOGGER.info("Problemas ao gerar relatório de problemas");
			throw new Exception(e);
		}

		LOGGER.info("Relatório de problemas gerado e encaminhado para ProblemaAction");
		return listas;
	}

	/**
	 * Converte um form em um bean
	 * 
	 * @param form
	 * @return ProblemaBean
	 * @throws Exception
	 */
	public ProblemaBean formToBean(ProblemaForm form) throws Exception {
		String expectedPattern = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
		ProblemaBean bean = new ProblemaBean();

		if (form.getErroID() != null)
			bean.setErroID(Long.valueOf(form.getErroID()));
		if (form.getCompanhiaID() != "" && form.getCompanhiaID() != null) {
			ECompanhia companhia = this.companhiaRepositorio.findById(Long.valueOf(form.getCompanhiaID()));
			if (companhia != null)
				bean.setCompanhia(companhia);
		}
		if (form.getDataSolucao() != "" && form.getDataSolucao() != null)
			bean.setDataSolucao(formatter.parse(form.getDataSolucao()));
		if (form.getIncidentesRelacionados() != null && !form.getIncidentesRelacionados().equals("")) {
			try {
				List<String> incidentesList = new ArrayList<String>(
						Arrays.asList(form.getIncidentesRelacionados().split(", ")));
				List<EIncidente> incidentes = new ArrayList<>();
				for (String incidente : incidentesList) {
					incidentes.add(this.incidenteRepositorio.findByErroID(Long.valueOf(incidente)));
				}
				bean.setIncidentesRelacionados(incidentes);
			} catch (Exception e) {
				LOGGER.error("Erro ao encontrar e salvar lista de incidentes relacionados: " + e);
				throw new Exception(e);
			}
		}
		if (form.getResponsavelID() != null && !form.getResponsavelID().equals("")) {
			EUsuario responsavel = this.usuarioRepositorio.findById(Long.valueOf(form.getResponsavelID()));
			if (responsavel != null)
				bean.setResponsavel(responsavel);
		}
		bean.setCategoria(form.getCategoria());
		bean.setDescricao(form.getDescricao());
		bean.setImpacto(form.getImpacto());
		bean.setPrioridade(form.getPrioridade());
		bean.setSolucao(form.getSolucao());
		bean.setStatus(form.getStatus());
		bean.setTitulo(form.getTitulo());
		bean.setUrgencia(form.getUrgencia());
		bean.setCausaRaiz(form.getCausaRaiz());
		bean.setFase(form.getFase());

		return bean;
	}

	/**
	 * Converte um bean em um form
	 * 
	 * @param bean
	 * @return ProblemaForm
	 */
	public ProblemaForm beanToForm(ProblemaBean bean) {
		ProblemaForm form = new ProblemaForm();

		if (bean.getErroID() != 0)
			form.setErroID(String.valueOf(bean.getErroID()));
		if (bean.getCompanhia() != null)
			form.setCompanhiaID(String.valueOf(bean.getCompanhia().getId()));
		if (bean.getDataSolucao() != null)
			form.setDataSolucao(String.valueOf(bean.getDataSolucao()));
		if (!bean.getIncidentesRelacionados().isEmpty()) {
			List<String> incidentes = new ArrayList<>();
			for (EIncidente incidente : bean.getIncidentesRelacionados()) {
				incidentes.add(String.valueOf(incidente.getErroID()));
			}
			form.setIncidentesRelacionados(String.join(", ", incidentes));
		}
		if (bean.getResponsavel() != null)
			form.setResponsavelID(String.valueOf(bean.getResponsavel().getId()));
		form.setCategoria(bean.getCategoria());
		form.setDescricao(bean.getDescricao());
		form.setImpacto(bean.getImpacto());
		form.setPrioridade(bean.getPrioridade());
		form.setSolucao(bean.getSolucao());
		form.setStatus(bean.getStatus());
		form.setTitulo(bean.getTitulo());
		form.setUrgencia(bean.getUrgencia());
		form.setCausaRaiz(bean.getCausaRaiz());
		form.setFase(bean.getFase());
		form.setErroConhecido(String.valueOf(bean.getErroConhecido()));

		return form;
	}

}
