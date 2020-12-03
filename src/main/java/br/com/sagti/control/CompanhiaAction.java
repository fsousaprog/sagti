/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/
package br.com.sagti.control;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sagti.bean.CompanhiaBean;
import br.com.sagti.form.CompanhiaForm;
import br.com.sagti.model.dao.CompanhiaDAO;
import br.com.sagti.model.repository.CompanhiaRepository;
import br.com.sagti.service.CompanhiaService;

/**
 * Controlador responsável pelas ações sobre Companhia
 * 
 * @author felipe
 */
@Controller
public class CompanhiaAction {
	private static final Logger LOGGER = Logger.getLogger(CompanhiaAction.class);

	@Autowired
	CompanhiaService service;
	@Autowired
	CompanhiaDAO dao;
	@Autowired
	CompanhiaRepository repositorio;

	/**
	 * Insere companhiaBean da tela de inserção de companhia
	 */
	@RequestMapping(value = "/inserirCompanhia", method = RequestMethod.POST)
	public String inserir(CompanhiaForm form, Model model) {
		try {
			CompanhiaBean bean = this.service.formToBean(form);
			this.service.inserir(bean);
			model.addAttribute("retorno", "Companhia criada com sucesso!");
		} catch (Exception e) {
			LOGGER.warn(e);
			model.addAttribute("retorno", "Erro ao criar companhia");
		}
		return "novaCompanhia";
	}

	/**
	 * busca lista de companhias utilizando filtro
	 */
	@RequestMapping(value = "/buscarCompanhia", method = RequestMethod.GET)
	public String buscar(Model model) {
		try {
			model.addAttribute("lista", this.service.buscar());
		} catch (Exception e) {
			LOGGER.warn(e);
			return "Ocorreu um erro: \n" + e;
		}
		return "listaCompanhia";
	}

	/**
	 * Carrega dados de atulização na página responsável
	 */
	@RequestMapping(value = "/paginaAtualizarCompanhia", method = RequestMethod.GET)
	public String chamarAtualizar(String id, Model model) {
		CompanhiaBean bean = this.dao.entityToBean(this.repositorio.findById(Long.valueOf(id)));
		model.addAttribute("companhia", this.service.beanToForm(bean));
		return "atualizarCompanhia";
	}

	/**
	 * Atualiza os dados do usuário passado
	 */
	@RequestMapping(value = "/atualizarCompanhia", method = RequestMethod.POST)
	public String atualizar(CompanhiaForm form, Model model) {
		try {
			CompanhiaBean bean = this.service.formToBean(form);
			this.service.atualizar(bean);
			model.addAttribute("companhia", bean);
			model.addAttribute("retorno", "Companhia atualizada com sucesso!");
		} catch (Exception e) {
			LOGGER.warn(e);
			model.addAttribute("retorno", "Erro ao atualizar companhia: <br>" + e);
			return "erro";
		}
		return "atualizarCompanhia";
	}
}
