/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

/**
 * 
 */
package br.com.sagti.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sagti.bean.UsuarioBean;
import br.com.sagti.form.UsuarioForm;
import br.com.sagti.model.dao.UsuarioDAO;
import br.com.sagti.model.entity.EUsuario;
import br.com.sagti.model.repository.UsuarioRepository;

/**
 * Serviço responsável pelas ações sobre Usuário
 * 
 * @author felipe
 */
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	private static final Logger LOGGER = Logger.getLogger(UsuarioServiceImpl.class);

	@Autowired
	UsuarioDAO dao;
	@Autowired
	UsuarioRepository repositorio;

	/**
	 * Insere usuário no banco
	 * 
	 * @param bean
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void inserir(UsuarioBean bean) throws Exception {
		EUsuario existente = this.repositorio.findByLogin(bean.getLogin());
		if (existente == null) {
			this.dao.create(bean);
		} else {
			throw new RuntimeException("Login já existe");
		}
	}

	/**
	 * Busca Usuário(s) no banco
	 * 
	 * @return List<UsuarioBean>
	 */
	public List<UsuarioBean> buscar() {
		return this.dao.findAll();
	}

	/**
	 * Atualiza dados do usuário passado no banco
	 * 
	 * @param bean
	 * @throws Exception
	 */
	public void atualizar(UsuarioBean bean) throws Exception {
		EUsuario entity = new EUsuario();
		this.dao.beanToEntity(entity, bean);
		try {
			this.repositorio.save(entity);
			LOGGER.info("Usuário de ID:" + entity.getId() + " foi atualizado com sucesso no banco");
		} catch (Exception e) {
			LOGGER.info("Não foi possivel atualizar o usuário de ID:" + entity.getId() + " no banco");
			throw e;
		}
	}

	/**
	 * Realiza login do usuário
	 * 
	 * @param login
	 * @param senha
	 * 
	 * @return 0-Não encontrado, 1-Encontrado, 2-Login ou senha inválidos
	 */
	public int login(String login, String senha) {
		return this.dao.login(login, senha);
	}

	/**
	 * Lê log do sistema em disco
	 * 
	 * @return String
	 */
	public String gerarLog() {
		String log = "";
		File file = new File("sagti.log");
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;

			while ((text = reader.readLine()) != null) {
				log += " <br><br> " + text;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}
		return log;
	}

	/**
	 * Converte um form em um bean
	 * 
	 * @param form
	 * @return UsuarioBean
	 */
	public UsuarioBean formToBean(UsuarioForm form) {
		UsuarioBean bean = new UsuarioBean();
		if (form.getId() != null && !form.getId().equals(""))
			bean.setId(Long.valueOf(form.getId()));
		if (form.getNivelAcesso() != null && !form.getNivelAcesso().equals(""))
			bean.setNivelAcesso(Integer.valueOf(form.getNivelAcesso()));
		bean.setLogin(form.getLogin());
		bean.setSenha(form.getSenha());
		bean.setCargo(form.getCargo());
		bean.setNome(form.getNome());

		return bean;
	}

	/**
	 * Converte um bean em um form
	 * 
	 * @param bean
	 * @return UsuarioForm
	 */
	public UsuarioForm beanToForm(UsuarioBean bean) {
		UsuarioForm form = new UsuarioForm();
		if (bean.getId() != 0)
			form.setId(String.valueOf(bean.getId()));
		if (bean.getNivelAcesso() != 0)
			form.setNivelAcesso(String.valueOf(bean.getNivelAcesso()));
		form.setLogin(bean.getLogin());
		form.setSenha(bean.getSenha());
		form.setCargo(bean.getCargo());
		form.setNome(bean.getNome());

		return form;
	}

}
