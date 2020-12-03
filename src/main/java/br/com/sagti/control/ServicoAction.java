/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/
package br.com.sagti.control;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sagti.bean.ServicoBean;
import br.com.sagti.form.ServicoForm;
import br.com.sagti.model.dao.ServicoDAO;
import br.com.sagti.model.repository.ServicoRepository;
import br.com.sagti.service.ServicoService;

/**
 * Controlador responsável pelas ações sobre Companhia
 * 
 * @author felipe
 */
@Controller
public class ServicoAction {
	private static final Logger LOGGER = Logger.getLogger(UsuarioAction.class);
	
	@Autowired
	ServicoService service;
	@Autowired
	ServicoDAO dao;
	@Autowired
	ServicoRepository repositorio;
	
	/**
	 * Insere servicoBean da tela de inserção de servico
	 */
	@RequestMapping(value = "/inserirServico", method = RequestMethod.POST)
	public String inserir(ServicoForm form, Model model) {
		try {
			ServicoBean bean = this.service.formToBean(form);
			this.service.inserir(bean);
			model.addAttribute("retorno","Serviço criado com sucesso!");
		} catch(Exception e) {
			LOGGER.warn(e);
			model.addAttribute("retorno","Erro ao criar serviço");
		}
		return "novoServico";
	}
	
	/**
	 * busca lista de servicos
	 */
	@RequestMapping(value = "/buscarServico", method = RequestMethod.GET)
	public String buscar(Model model) {
		try {
			model.addAttribute("lista", this.service.buscar());
		} catch(Exception e) {
			LOGGER.warn(e);
			return "Ocorreu um erro: \n" + e;
		}
		return "listaServico";
	}
	
	/**
	 * Carrega dados de atulização na página responsável
	 */
	@RequestMapping(value = "/paginaAtualizarServico", method = RequestMethod.GET)
	public String chamarAtualizar(String id, Model model) {
		ServicoBean bean = this.dao.entityToBean(this.repositorio.findById(Long.valueOf(id)));
		model.addAttribute("servico", this.service.beanToForm(bean));
		return "atualizarServico";
	}

	/**
	 * Atualiza os dados do servico passado
	 */
	@RequestMapping(value = "/atualizarServico", method = RequestMethod.POST)
	public String atualizar(ServicoForm form, Model model) {
		try {
			ServicoBean bean = this.service.formToBean(form);
			this.service.atualizar(bean);
			model.addAttribute("servico", this.service.beanToForm(bean));
			model.addAttribute("retorno", "Serviço atualizado com sucesso!");
		} catch (Exception e) {
			LOGGER.warn(e);
			model.addAttribute("retorno", "Erro ao atualizar serviço");
			return "Ocorreu um erro: \n" + e;
		}
		return "atualizarServico";
	}
}
