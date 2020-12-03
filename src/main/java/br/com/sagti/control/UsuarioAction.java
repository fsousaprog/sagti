/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 *
 */
package br.com.sagti.control;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sagti.bean.UsuarioBean;
import br.com.sagti.form.UsuarioForm;
import br.com.sagti.model.dao.UsuarioDAO;
import br.com.sagti.model.repository.UsuarioRepository;
import br.com.sagti.service.UsuarioService;

/**
 * Controlador responsável pelas ações sobre Companhia
 *
 * @author felipe
 */
@Controller
public class UsuarioAction {
	private static final Logger LOGGER = Logger.getLogger(UsuarioAction.class);

	@Autowired
	UsuarioDAO dao;
	@Autowired
	UsuarioRepository repositorio;
	@Autowired
	UsuarioService service;

	/**
	 * Insere usuarioBean da tela de inserção de usuário
	 */
	@RequestMapping(value = "/inserirUsuario", method = RequestMethod.POST)
	public String inserir(UsuarioForm form, Model model) {
		try {
			UsuarioBean bean = this.service.formToBean(form);
			this.service.inserir(bean);
			model.addAttribute("retorno", "Usuário criado com sucesso!");
			LOGGER.info("Usuário de ID:" + bean.getId() + " criado com sucesso!");
		} catch (Exception e) {
			LOGGER.warn(e);
			model.addAttribute("retorno", "Erro ao criar usuário");
		}
		return "novoUsuario";
	}

	/**
	 * Busca lista de usuários
	 */
	@RequestMapping(value = "/buscarUsuario", method = RequestMethod.GET)
	public String buscar(Model model) {
		try {
			model.addAttribute("lista", this.service.buscar());
			LOGGER.info("Busca de lista de usuários feita no banco");
		} catch (Exception e) {
			LOGGER.warn(e);
			return "Ocorreu um erro: \n" + e;
		}
		return "listaUsuario";
	}

	/**
	 * Carrega dados de atulização na página responsável
	 */
	@RequestMapping(value = "/paginaAtualizarUsuario", method = RequestMethod.GET)
	public String chamarAtualizar(String id, Model model) {
		UsuarioBean bean = this.dao.entityToBean(this.repositorio.findById(Long.valueOf(id)));
		model.addAttribute("usuario", this.service.beanToForm(bean));
		return "atualizarUsuario";
	}

	/**
	 * Atualiza os dados do usuário passado
	 */
	@RequestMapping(value = "/atualizarUsuario", method = RequestMethod.POST)
	public String atualizar(UsuarioForm form, Model model) {
		try {
			UsuarioBean bean = this.service.formToBean(form);
			this.service.atualizar(bean);
			model.addAttribute("usuario", bean);
			model.addAttribute("retorno", "Usuário atualizado com sucesso!");
		} catch (Exception e) {
			LOGGER.warn(e);
			model.addAttribute("retorno", "Erro ao atualizar usuário");
			return "Ocorreu um erro: \n" + e;
		}
		return "atualizarUsuario";
	}

	/**
	 * Carrega dados do usuário atualmente logado e chama tela de edição
	 */
	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public String perfil(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (!user.getUsername().equals("admin")) {
			UsuarioBean bean = this.dao.entityToBean(this.repositorio.findByLogin(user.getUsername()));
			model.addAttribute("usuario", this.service.beanToForm(bean));
			return "atualizarUsuario";
		} else {
			model.addAttribute("erro", "Não é possível modificar os dados do Administrador");
			return "erro";
		}
	}

	/**
	 * Chama página de configuração do sistema
	 */
	@RequestMapping(value = "/configuracoes", method = RequestMethod.GET)
	public String configuracoes(Model model) {
		model.addAttribute("erro", "Página ainda em manutenção!");
		return "erro";
	}

	/**
	 * Carrega arquivo de log do sistema
	 */
	@RequestMapping(value = "/gerarLog", method = RequestMethod.GET)
	public String gerarLog(Model model) {
		model.addAttribute("log", this.service.gerarLog());
		return "logSistema";
	}
}
