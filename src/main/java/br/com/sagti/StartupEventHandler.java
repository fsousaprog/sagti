/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/
package br.com.sagti;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.sagti.bean.CompanhiaBean;
import br.com.sagti.bean.IncidenteBean;
import br.com.sagti.bean.ProblemaBean;
import br.com.sagti.bean.ServicoBean;
import br.com.sagti.bean.UsuarioBean;
import br.com.sagti.form.CompanhiaForm;
import br.com.sagti.form.IncidenteForm;
import br.com.sagti.form.ProblemaForm;
import br.com.sagti.form.ServicoForm;
import br.com.sagti.form.UsuarioForm;
import br.com.sagti.model.dao.CompanhiaDAO;
import br.com.sagti.model.dao.IncidenteDAO;
import br.com.sagti.model.dao.ProblemaDAO;
import br.com.sagti.model.dao.ServicoDAO;
import br.com.sagti.model.dao.UsuarioDAO;
import br.com.sagti.service.CompanhiaService;
import br.com.sagti.service.IncidenteService;
import br.com.sagti.service.ProblemaService;
import br.com.sagti.service.ServicoService;
import br.com.sagti.service.UsuarioService;

@Component
@Transactional
public class StartupEventHandler implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	UsuarioDAO usuarioDAO;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	CompanhiaDAO companhiaDAO;
	@Autowired
	CompanhiaService companhiaService;
	@Autowired
	ServicoDAO servicoDAO;
	@Autowired
	ServicoService servicoService;
	@Autowired
	IncidenteDAO incidenteDAO;
	@Autowired
	IncidenteService incidenteService;
	@Autowired
	ProblemaDAO problemaDAO;
	@Autowired
	ProblemaService problemaService;

	private static final Logger LOGGER = Logger.getLogger(IncidenteDAO.class);
	private static String file = "src/main/webapp/META-INF/dump.xls";

	/**
	 * Executa seguência de código logo após inicialização do sistema
	 */
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		try {
			if (usuarioDAO != null && usuarioService != null && companhiaDAO != null && companhiaService != null
					&& servicoDAO != null && servicoService != null && incidenteDAO != null && incidenteService != null
					&& problemaDAO != null && problemaService != null) {
				boolean bancoPopulado = false;
				// Cria X usuários no banco de acordo com parametro abaixo
				if (this.usuarioDAO.findAll().isEmpty()) {
					for (UsuarioBean usuario : this.getListaUsuariosFromFile(11)) {
						usuarioDAO.create(usuario);
					}
					bancoPopulado = true;
				}
				// Cria X companhias no banco de acordo com parametro abaixo
				if (this.companhiaDAO.findAll().isEmpty()) {
					for (CompanhiaBean companhia : this.getListaCompanhiasFromFile(15)) {
						companhiaDAO.create(companhia);
					}
					bancoPopulado = true;
				}
				// Cria X serviços no banco de acordo com parametro abaixo
				if (this.servicoDAO.findAll().isEmpty()) {
					for (ServicoBean servico : this.getListaServicosFromFile(9)) {
						servicoDAO.create(servico);
					}
					bancoPopulado = true;
				}
				// Cria X incidentes no banco de acordo com parametro abaixo
				if (this.incidenteDAO.findAll().isEmpty()) {
					for (IncidenteBean incidente : this.getListaIncidentesFromFile(50)) {
						incidenteDAO.create(incidente);
					}
					bancoPopulado = true;
				}
				// Cria X problemas no banco de acordo com parametro abaixo
				if (this.problemaDAO.findAll().isEmpty()) {
					for (ProblemaBean problema : this.getListaProblemasFromFile(20)) {
						problemaDAO.create(problema);
					}
					bancoPopulado = true;
				}

				if (bancoPopulado == true) {
					LOGGER.info("BANCO POPULADO COM SUCESSO!");
					System.out.println("BANCO POPULADO COM SUCESSO!");
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
			e.printStackTrace();
		}
	}

	/**
	 * Lê arquivo de dump do banco e retorna beans gerados aleatoriamente de
	 * acordo com dados do arquivo na quantidade solicitada.
	 * 
	 * Posições do arquivo: B-Nome C-Login D-Senha E-Cargo F-Nível de Acesso
	 * 
	 * Index começa na linha: 2
	 * 
	 * @param qnt
	 * @return listaUsuarios
	 * @throws Exception
	 */
	public List<UsuarioBean> getListaUsuariosFromFile(int qnt) throws Exception {
		List<UsuarioBean> listaUsuarios = new ArrayList<>();
		Random random = new Random();
		Workbook wb = WorkbookFactory.create(new FileInputStream(file));
		Sheet sheet = wb.getSheetAt(0);

		for (int i = 2; i < qnt + 2; i++) {
			UsuarioForm usuario = new UsuarioForm();
			// Pega nome
			CellReference cellReference = new CellReference("B" + i);
			Row row = sheet.getRow(cellReference.getRow());
			Cell cell = row.getCell(cellReference.getCol());
			usuario.setNome(cell.getStringCellValue());

			// Pega login
			cellReference = new CellReference("C" + i);
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			usuario.setLogin(cell.getStringCellValue());

			// Pega senha
			cellReference = new CellReference("D" + (random.nextInt(6) + 2));
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			usuario.setSenha(cell.getStringCellValue());

			// Pega cargo
			cellReference = new CellReference("E" + (random.nextInt(3) + 2));
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			usuario.setCargo(cell.getStringCellValue());

			// Pega nivelAcesso
			usuario.setNivelAcesso(String.valueOf((random.nextInt(3) + 1)));

			listaUsuarios.add(this.usuarioService.formToBean(usuario));
		}

		wb.close();
		return listaUsuarios;
	}

	/**
	 * Lê arquivo de dump do banco e retorna beans gerados aleatoriamente de
	 * acordo com dados do arquivo na quantidade solicitada.
	 * 
	 * Posições do arquivo: H-Nome I-NomeFantasia J-InicioParceria K-Serviços
	 * L-Ramo
	 * 
	 * Index começa na linha: 2
	 * 
	 * @param qnt
	 * @return listaCompanhias
	 * @throws Exception
	 */
	public List<CompanhiaBean> getListaCompanhiasFromFile(int qnt) throws Exception {
		List<CompanhiaBean> listaCompanhias = new ArrayList<>();
		Workbook wb = WorkbookFactory.create(new FileInputStream(file));
		Sheet sheet = wb.getSheetAt(0);

		for (int i = 2; i < qnt + 2; i++) {
			CompanhiaForm companhia = new CompanhiaForm();
			// Pega nome
			CellReference cellReference = new CellReference("H" + i);
			Row row = sheet.getRow(cellReference.getRow());
			Cell cell = row.getCell(cellReference.getCol());
			companhia.setNome(cell.getStringCellValue());

			// Pega nomeFantasia
			cellReference = new CellReference("I" + i);
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			companhia.setNomeFantasia(cell.getStringCellValue());

			// Pega inicioParceria
			cellReference = new CellReference("J" + i);
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			companhia.setInicioParceria(cell.getStringCellValue());

			// Pega servicos
			// cellReference = new CellReference("K" + i);
			// row = sheet.getRow(cellReference.getRow());
			// cell = row.getCell(cellReference.getCol());
			// companhia.setServicos(cell.getStringCellValue());

			// Pega ramo
			cellReference = new CellReference("L" + i);
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			companhia.setRamo(cell.getStringCellValue());

			listaCompanhias.add(this.companhiaService.formToBean(companhia));
		}

		wb.close();
		return listaCompanhias;
	}

	/**
	 * Lê arquivo de dump do banco e retorna beans gerados aleatoriamente de
	 * acordo com dados do arquivo na quantidade solicitada.
	 * 
	 * Posições do arquivo: N-Nome O-Descrição P-CompanhiaID Q-Tipo R-Categoria
	 * S-Área
	 * 
	 * Index começa na linha: 2
	 * 
	 * @param qnt
	 * @return listaServicos
	 * @throws Exception
	 */
	public List<ServicoBean> getListaServicosFromFile(int qnt) throws Exception {
		List<ServicoBean> listaServicos = new ArrayList<>();
		Random random = new Random();
		Workbook wb = WorkbookFactory.create(new FileInputStream(file));
		Sheet sheet = wb.getSheetAt(0);

		for (int i = 2; i < qnt + 2; i++) {
			ServicoForm servico = new ServicoForm();
			// Pega nome
			CellReference cellReference = new CellReference("N" + i);
			Row row = sheet.getRow(cellReference.getRow());
			Cell cell = row.getCell(cellReference.getCol());
			servico.setNome(cell.getStringCellValue());

			// Pega descricao
			cellReference = new CellReference("O" + i);
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			servico.setDescricao(cell.getStringCellValue());

			// Pega companhiaID
			servico.setCompanhiaID(String.valueOf(random.nextInt(15) + 1));

			// Pega tipo
			cellReference = new CellReference("Q" + i);
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			servico.setTipo(cell.getStringCellValue());

			// Pega categoria
			cellReference = new CellReference("R" + i);
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			servico.setCategoria(cell.getStringCellValue());

			// Pega area
			cellReference = new CellReference("S" + i);
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			servico.setArea(cell.getStringCellValue());

			listaServicos.add(this.servicoService.formToBean(servico));
		}

		wb.close();
		return listaServicos;
	}

	/**
	 * Lê arquivo de dump do banco e retorna beans gerados aleatoriamente de
	 * acordo com dados do arquivo na quantidade solicitada.
	 * 
	 * Posições do arquivo-ERRO: U-Status V-Categoria W-CompanhiaID X-Impacto
	 * Y-Urgência Z-Prioridade AA-Título AB-Descrição AC-Solução AD-DataSolução
	 * Posições do arquivo-ICIDENTE: AF-ServiçoID AG-DataInício
	 * 
	 * Index começa na linha: 2
	 * 
	 * @param qnt
	 * @return listaIncidentes
	 * @throws Exception
	 */
	public List<IncidenteBean> getListaIncidentesFromFile(int qnt) throws Exception {
		List<IncidenteBean> listaIncidentes = new ArrayList<>();
		Random random = new Random();
		Workbook wb = WorkbookFactory.create(new FileInputStream(file));
		Sheet sheet = wb.getSheetAt(0);

		for (int i = 0 + 2; i < qnt + 2; i++) {
			IncidenteForm incidente = new IncidenteForm();
			////////////// ERRO
			// Pega status
			CellReference cellReference = new CellReference("U" + (random.nextInt(4) + 2));
			Row row = sheet.getRow(cellReference.getRow());
			Cell cell = row.getCell(cellReference.getCol());
			incidente.setStatus(cell.getStringCellValue());

			// Pega categoria
			cellReference = new CellReference("V" + (random.nextInt(7) + 2));
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			incidente.setCategoria(cell.getStringCellValue());

			// Pega companhiaID
			incidente.setCompanhiaID(String.valueOf((random.nextInt(15) + 1)));

			// Pega impacto
			cellReference = new CellReference("X" + (random.nextInt(3) + 2));
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			incidente.setImpacto(cell.getStringCellValue());

			// Pega urgencia
			cellReference = new CellReference("Y" + (random.nextInt(5) + 2));
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			incidente.setUrgencia(cell.getStringCellValue());

			// Pega prioridade
			cellReference = new CellReference("Z" + (random.nextInt(3) + 2));
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			incidente.setPrioridade(cell.getStringCellValue());

			// Pega titulo
			int titulo = random.nextInt(12) + 2;
			cellReference = new CellReference("AA" + titulo);
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			incidente.setTitulo(cell.getStringCellValue());

			// Pega descricao
			cellReference = new CellReference("AB" + titulo);
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			incidente.setDescricao(cell.getStringCellValue());

			// SOLUCAO
			if (incidente.getStatus().equals("Fechado")) {
				// Pega solucao
				cellReference = new CellReference("AC" + (random.nextInt(7) + 2));
				row = sheet.getRow(cellReference.getRow());
				cell = row.getCell(cellReference.getCol());
				incidente.setSolucao(cell.getStringCellValue());

				// Pega datasolucao
				cellReference = new CellReference("AD" + (random.nextInt(10) + 2));
				row = sheet.getRow(cellReference.getRow());
				cell = row.getCell(cellReference.getCol());
				incidente.setDataSolucao(cell.getStringCellValue());
			}

			//////////////// INCIDENTE
			// Pega servicoID
			incidente.setServicoID(String.valueOf(random.nextInt(9) + 1));

			// Pega dataInicio
			cellReference = new CellReference("AG" + (random.nextInt(10) + 2));
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			incidente.setDataInicio(cell.getStringCellValue());

			listaIncidentes.add(this.incidenteService.formToBean(incidente));
		}

		wb.close();
		return listaIncidentes;
	}

	/**
	 * Lê arquivo de dump do banco e retorna beans gerados aleatoriamente de
	 * acordo com dados do arquivo na quantidade solicitada.
	 * 
	 * Posições do arquivo-ERRO: U-Status V-Categoria W-CompanhiaID X-Impacto
	 * Y-Urgência Z-Prioridade AA-Título AB-Descrição AC-Solução AD-DataSolução
	 * Posições do arquivo-PROBLEMA: AI-Fase AJ-ResponsávelID
	 * AK-IncidentesRelacionados AL-PrevisãoSolução AM-CausaRaiz
	 * AN-ErroConhecido
	 * 
	 * Index começa na linha: 2
	 * 
	 * @param qnt
	 * @return listaProblemas
	 * @throws Exception
	 */
	public List<ProblemaBean> getListaProblemasFromFile(int qnt) throws Exception {
		List<ProblemaBean> listaProblemas = new ArrayList<>();
		Random random = new Random();
		Workbook wb = WorkbookFactory.create(new FileInputStream(file));
		Sheet sheet = wb.getSheetAt(0);

		for (int i = 0; i < qnt; i++) {
			ProblemaForm problema = new ProblemaForm();
			////////////// ERRO
			// Pega status
			CellReference cellReference = new CellReference("U" + (random.nextInt(4) + 2));
			Row row = sheet.getRow(cellReference.getRow());
			Cell cell = row.getCell(cellReference.getCol());
			problema.setStatus(cell.getStringCellValue());

			// Pega categoria
			cellReference = new CellReference("V" + (random.nextInt(7) + 2));
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			problema.setCategoria(cell.getStringCellValue());

			// Pega companhiaID
			problema.setCompanhiaID(String.valueOf((random.nextInt(15) + 1)));

			// Pega impacto
			cellReference = new CellReference("X" + (random.nextInt(3) + 2));
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			problema.setImpacto(cell.getStringCellValue());

			// Pega urgencia
			cellReference = new CellReference("Y" + (random.nextInt(5) + 2));
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			problema.setUrgencia(cell.getStringCellValue());

			// Pega prioridade
			cellReference = new CellReference("Z" + (random.nextInt(3) + 2));
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			problema.setPrioridade(cell.getStringCellValue());

			// Pega titulo
			int titulo = random.nextInt(12) + 2;
			cellReference = new CellReference("AA" + titulo);
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			problema.setTitulo(cell.getStringCellValue());

			// Pega descricao
			cellReference = new CellReference("AB" + titulo);
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			problema.setDescricao(cell.getStringCellValue());

			// SOLUCAO
			if (problema.getStatus().equals("Fechado")) {
				// Pega solucao
				cellReference = new CellReference("AC" + (random.nextInt(7) + 2));
				row = sheet.getRow(cellReference.getRow());
				cell = row.getCell(cellReference.getCol());
				problema.setSolucao(cell.getStringCellValue());

				// Pega datasolucao
				cellReference = new CellReference("AD" + (random.nextInt(10) + 2));
				row = sheet.getRow(cellReference.getRow());
				cell = row.getCell(cellReference.getCol());
				problema.setDataSolucao(cell.getStringCellValue());

				//////////////// PROBLEMA
				// Pega erroConhecido
				problema.setErroConhecido("true");
			} else {
				// Pega erroConhecido
				problema.setErroConhecido("false");
			}

			// Pega fase
			cellReference = new CellReference("AI" + (random.nextInt(5) + 2));
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			problema.setFase(cell.getStringCellValue());

			// Pega responsavelID
			problema.setResponsavelID(String.valueOf(random.nextInt(10) + 1));

			// Pega incidentesRelacionados
			// int incidenteA = (random.nextInt(50) + 1);
			// int incidenteB = (random.nextInt(50) + 1);
			// while (incidenteB == incidenteA) {
			// incidenteB = (random.nextInt(50) + 1);
			// }
			// problema.setIncidentesRelacionados(incidenteA + ", " +
			// incidenteB);

			// Pega previsaoSolucao
			cellReference = new CellReference("AL" + (random.nextInt(10) + 2));
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			problema.setPrevisaoSolucao(cell.getStringCellValue());

			// Pega causaRaiz
			cellReference = new CellReference("AM" + (random.nextInt(8) + 2));
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			problema.setCausaRaiz(cell.getStringCellValue());

			listaProblemas.add(this.problemaService.formToBean(problema));
		}

		wb.close();
		return listaProblemas;
	}

}