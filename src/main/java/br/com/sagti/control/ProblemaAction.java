/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.control;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sagti.bean.ProblemaBean;
import br.com.sagti.bean.UsuarioBean;
import br.com.sagti.form.ProblemaForm;
import br.com.sagti.model.dao.ProblemaDAO;
import br.com.sagti.model.dao.UsuarioDAO;
import br.com.sagti.model.repository.ProblemaRepository;
import br.com.sagti.service.ProblemaService;

/**
 * Controlador responsável pelas ações sobre Problema
 * 
 * @author felipe
 */
@Controller
public class ProblemaAction {
	private static final Logger LOGGER = Logger.getLogger(UsuarioAction.class);

	@Autowired
	ProblemaService service;
	@Autowired
	ProblemaDAO dao;
	@Autowired
	ProblemaRepository repositorio;
	@Autowired
	UsuarioDAO usuarioDAO;

	/**
	 * Insere problemaBean da tela de inserção de problema
	 */
	@RequestMapping(value = "/inserirProblema", method = RequestMethod.POST)
	public String inserir(ProblemaForm form, Model model) {
		try {
			ProblemaBean bean = this.service.formToBean(form);
			this.service.inserir(bean);
			model.addAttribute("retorno", "Problema criado com sucesso!");
		} catch (Exception e) {
			LOGGER.warn(e);
			model.addAttribute("retorno", "Erro ao criar problema");
		}
		return "novoProblema";
	}

	/**
	 * busca lista de problemas
	 */
	@RequestMapping(value = "/buscarProblema", method = RequestMethod.GET)
	public String buscar(Model model) {
		try {
			model.addAttribute("lista", this.service.buscar());
		} catch (Exception e) {
			LOGGER.warn(e);
			return "Ocorreu um erro: \n" + e;
		}
		return "listaProblema";
	}

	/**
	 * Carrega dados de atulização na página responsável
	 */
	@RequestMapping(value = "/paginaAtualizarProblema", method = RequestMethod.GET)
	public String chamarAtualizar(String id, Model model) {
		ProblemaBean bean = this.dao.entityToBean(this.repositorio.findByErroID(Long.valueOf(id)));
		model.addAttribute("erro", this.service.beanToForm(bean));
		return "atualizarProblema";
	}

	/**
	 * Atualiza os dados do problema passado
	 */
	@RequestMapping(value = "/atualizarProblema", method = RequestMethod.POST)
	public String atualizar(ProblemaForm form, Model model) {
		try {
			ProblemaBean bean = this.service.formToBean(form);
			this.service.atualizar(bean);
			model.addAttribute("problema", bean);
			model.addAttribute("retorno", "Problema atualizado com sucesso!");
		} catch (Exception e) {
			LOGGER.warn(e);
			model.addAttribute("retorno", "Erro ao atualizar problema");
			return "Ocorreu um erro: \n" + e;
		}
		return "atualizarProblema";
	}

	/**
	 * Carrega dados de problemas do banco e chama tela de relatorios
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/gerarRelatoriosProblema", method = RequestMethod.GET)
	public String gerarRelatorios(Model model) throws Exception {
		Map<String, List> listas = this.service.gerarRelatorios();

		// Dados JSON
		model.addAttribute("statusLabel", listas.get("statusLabel"));
		model.addAttribute("statusData", listas.get("statusData"));
		model.addAttribute("categoriasLabel", listas.get("categoriasLabel"));
		model.addAttribute("categoriasData", listas.get("categoriasData"));
		model.addAttribute("companhiasLabel", listas.get("companhiasLabel"));
		model.addAttribute("companhiasData", listas.get("companhiasData"));
		// Dados para as estatísticas da tela
		List<UsuarioBean> usuarios = usuarioDAO.findAll();
		List<ProblemaBean> problemas = dao.findAll();
		model.addAttribute("problemasQnt", problemas.size());
		model.addAttribute("usuariosQnt", usuarios.size());
		model.addAttribute("companhiasQnt", listas.get("companhiasLabel").size());
		model.addAttribute("usuariosProblemas", (((float) problemas.size()) / usuarios.size()));

		return "relatorioProblema";
	}
}
