/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

package br.com.sagti.model.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sagti.model.entity.ECompanhia;
import br.com.sagti.model.entity.EProblema;
import br.com.sagti.model.entity.EUsuario;

/**
 * INterface do manipulador da entidade EProblema
 * 
 * @author felipe
 */
@Repository
public interface ProblemaRepository extends JpaRepository<EProblema, Long> {

	/**
	 * Buscar por ID
	 * 
	 * @param erroId
	 * @return EProblema
	 */
	public EProblema findByErroID(long erroId);

	/**
	 * Buscar por Status
	 * 
	 * @param status
	 * @return List<EProblema>
	 */
	public List<EProblema> findByStatus(String status);

	/**
	 * Buscar por Categoria
	 * 
	 * @param categoria
	 * @return List<EProblema>
	 */
	public List<EProblema> findByCategoria(String categoria);

	/**
	 * Buscar por Companhia
	 * 
	 * @param companhia
	 * @return List<EProblema>
	 */
	public List<EProblema> findByCompanhia(ECompanhia companhia);

	/**
	 * Buscar por Impacto
	 * 
	 * @param impacto
	 * @return List<EProblema>
	 */
	public List<EProblema> findByImpacto(String impacto);

	/**
	 * Buscar por Urgencia
	 * 
	 * @param urgencia
	 * @return List<EProblema>
	 */
	public List<EProblema> findByUrgencia(String urgencia);

	/**
	 * Buscar por Prioridade
	 * 
	 * @param prioridade
	 * @return List<EProblema>
	 */
	public List<EProblema> findByPrioridade(String prioridade);

	/**
	 * Buscar por Título ou parcial
	 * 
	 * @param titulo
	 * @return List<EProblema>
	 */
	public List<EProblema> findByTitulo(String titulo);

	/**
	 * Buscar por Data da Solução
	 * 
	 * @param dataSolucao
	 * @return List<EProblema>
	 */
	public List<EProblema> findByDataSolucao(@Temporal(TemporalType.DATE) Date dataSolucao);

	/**
	 * Buscar por Fase
	 * 
	 * @param fase
	 * @return List<EProblema>
	 */
	public List<EProblema> findByFase(String fase);

	/**
	 * Buscar por Responsável
	 * 
	 * @param responsavel
	 * @return List<EProblema>
	 */
	public List<EProblema> findByResponsavel(EUsuario responsavel);

	/**
	 * Buscar por Incidentes Relacionados
	 * 
	 * @param incidentes
	 * @return List<EProblema>
	 */
	@SuppressWarnings("rawtypes")
	public List<EProblema> findByIncidentesRelacionados(List incidentes);

	/**
	 * Buscar por Previsão de Solução
	 * 
	 * @param previsaoSolucao
	 * @return List<EProblema>
	 */
	public List<EProblema> findByPrevisaoSolucao(Date previsaoSolucao);

	/**
	 * Buscar por Erro Conhecido
	 * 
	 * @param erroConhecido
	 * @return List<EProblema>
	 */
	public List<EProblema> findByErroConhecido(boolean erroConhecido);

	/**
	 * Executa query no banco
	 * 
	 * @param query
	 * @return List<EProblema>
	 */
	@Query("SELECT p FROM EProblema p WHERE p.titulo LIKE :query")
	public List<EProblema> findByQuery(@Param("query") String query);

}
