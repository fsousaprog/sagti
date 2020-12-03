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
import br.com.sagti.model.entity.EIncidente;
import br.com.sagti.model.entity.EServico;

/**
 * INterface do manipulador da entidade EIncidente
 * 
 * @author felipe
 */
@Repository
public interface IncidenteRepository extends JpaRepository<EIncidente, Long> {

	/**
	 * Buscar por ID
	 * 
	 * @param erroId
	 * @return EIncidente
	 */
	public EIncidente findByErroID(long erroId);

	/**
	 * Buscar por Status
	 * 
	 * @param status
	 * @return List<EIncidente>
	 */
	public List<EIncidente> findByStatus(String status);

	/**
	 * Buscar por Servico
	 * 
	 * @param servico
	 * @return List<EIncidente>
	 */
	public List<EIncidente> findByServico(EServico servico);

	/**
	 * Buscar por Categoria
	 * 
	 * @param categoria
	 * @return List<EIncidente>
	 */
	public List<EIncidente> findByCategoria(String categoria);

	/**
	 * Buscar por Companhia
	 * 
	 * @param companhia
	 * @return List<EIncidente>
	 */
	public List<EIncidente> findByCompanhia(ECompanhia companhia);

	/**
	 * Buscar por Impacto
	 * 
	 * @param impacto
	 * @return List<EIncidente>
	 */
	public List<EIncidente> findByImpacto(String impacto);

	/**
	 * Buscar por Urgencia
	 * 
	 * @param urgencia
	 * @return List<EIncidente>
	 */
	public List<EIncidente> findByUrgencia(String urgencia);

	/**
	 * Buscar por Prioridade
	 * 
	 * @param prioridade
	 * @return List<EIncidente>
	 */
	public List<EIncidente> findByPrioridade(String prioridade);

	/**
	 * Buscar por Título ou parcial
	 * 
	 * @param titulo
	 * @return List<EIncidente>
	 */
	public List<EIncidente> findByTitulo(String titulo);

	/**
	 * Buscar por Data da Solução
	 * 
	 * @param dataSolucao
	 * @return List<EIncidente>
	 */
	public List<EIncidente> findByDataSolucao(@Temporal(TemporalType.DATE) Date dataSolucao);

	/**
	 * Buscar por Inicio do incidente
	 * 
	 * @param dataInicio
	 * @return List<EIncidente>
	 */
	public List<EIncidente> findByDataInicio(Date dataInicio);

	/**
	 * Executa query no banco
	 * 
	 * @param query
	 * @return List<EIncidente>
	 */
	@Query("SELECT i FROM EIncidente i WHERE i.titulo LIKE :query")
	public List<EIncidente> findByQuery(@Param("query") String query);

}
