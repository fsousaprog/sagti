/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/
package br.com.sagti.control;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sagti.bean.IncidenteBean;
import br.com.sagti.bean.UsuarioBean;
import br.com.sagti.form.IncidenteForm;
import br.com.sagti.model.dao.IncidenteDAO;
import br.com.sagti.model.dao.UsuarioDAO;
import br.com.sagti.model.repository.IncidenteRepository;
import br.com.sagti.service.IncidenteService;

/**
 * Controlador responsável pelas ações sobre Incidente
 * 
 * @author felipe
 */
@Controller
public class IncidenteAction {
	private static final Logger LOGGER = Logger.getLogger(UsuarioAction.class);

	@Autowired
	IncidenteService service;
	@Autowired
	IncidenteDAO dao;
	@Autowired
	IncidenteRepository repositorio;
	@Autowired
	UsuarioDAO usuarioDAO;

	/**
	 * Insere incidenteBean da tela de inserção de incidente
	 */
	@RequestMapping(value = "/inserirIncidente", method = RequestMethod.POST)
	public String inserir(IncidenteForm form, Model model) {
		try {
			IncidenteBean bean = this.service.formToBean(form);
			this.service.inserir(bean);
			model.addAttribute("retorno", "Incidente criado com sucesso!");
		} catch (Exception e) {
			LOGGER.warn(e);
			model.addAttribute("retorno", "Erro ao criar incidente");
		}
		return "novoIncidente";
	}

	/**
	 * busca lista de incidentes
	 */
	@RequestMapping(value = "/buscarIncidente", method = RequestMethod.GET)
	public String buscar(Model model) {
		try {
			model.addAttribute("lista", this.service.buscar());
		} catch (Exception e) {
			LOGGER.warn(e);
			return "Ocorreu um erro: \n" + e;
		}
		return "listaIncidente";
	}

	/**
	 * Carrega dados de atulização na página responsável
	 */
	@RequestMapping(value = "/paginaAtualizarIncidente", method = RequestMethod.GET)
	public String chamarAtualizar(String id, Model model) {
		IncidenteBean bean = this.dao.entityToBean(this.repositorio.findByErroID(Long.valueOf(id)));
		model.addAttribute("erro", this.service.beanToForm(bean));
		return "atualizarIncidente";
	}

	/**
	 * Atualiza os dados do incidente passado
	 */
	@RequestMapping(value = "/atualizarIncidente", method = RequestMethod.POST)
	public String atualizar(IncidenteForm form, Model model) {
		try {
			IncidenteBean bean = this.service.formToBean(form);
			this.service.atualizar(bean);
			model.addAttribute("incidente", bean);
			model.addAttribute("retorno", "Incidente atualizado com sucesso!");
		} catch (Exception e) {
			LOGGER.warn(e);
			model.addAttribute("retorno", "Erro ao atualizar incidente");
			return "Ocorreu um erro: \n" + e;
		}
		return "atualizarIncidente";
	}

	/**
	 * Carrega dados de incidentes do banco e chama tela de relatorios
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/gerarRelatoriosIncidente", method = RequestMethod.GET)
	public String gerarRelatorios(Model model) throws Exception {
		Map<String, List> listas = this.service.gerarRelatorios();

		// Dados JSON
		model.addAttribute("statusLabel", listas.get("statusLabel"));
		model.addAttribute("statusData", listas.get("statusData"));
		model.addAttribute("categoriasLabel", listas.get("categoriasLabel"));
		model.addAttribute("categoriasData", listas.get("categoriasData"));
		model.addAttribute("companhiasLabel", listas.get("companhiasLabel"));
		model.addAttribute("companhiasData", listas.get("companhiasData"));
		model.addAttribute("servicosLabel", listas.get("servicosLabel"));
		model.addAttribute("servicosData", listas.get("servicosData"));
		// Dados para as estatísticas da tela
		List<UsuarioBean> usuarios = usuarioDAO.findAll();
		List<IncidenteBean> incidentes = dao.findAll();
		model.addAttribute("incidentesQnt", incidentes.size());
		model.addAttribute("companhiasQnt", listas.get("companhiasLabel").size());
		model.addAttribute("servicosQnt", listas.get("servicosLabel").size());
		model.addAttribute("usuariosIncidentes", ((float) incidentes.size()) / usuarios.size());

		return "relatorioIncidente";
	}
}
