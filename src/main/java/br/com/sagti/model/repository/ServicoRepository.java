/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

package br.com.sagti.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sagti.model.entity.ECompanhia;
import br.com.sagti.model.entity.EServico;

/**
 * INterface do manipulador da entidade EServico
 * 
 * @author felipe
 */
@Repository
public interface ServicoRepository  extends JpaRepository<EServico, Long> {
	
	/**
	 * Buscar por ID
	 * 
	 * @param servicoId
	 * @return EServico
	 */
	public EServico findById(long servicoId);
	
	/**
	 * Buscar por nome ou parcial
	 * 
	 * @param nome
	 * @return List<EServico>
	 */
	public List<EServico> findByNome(String nome);
	
	/**
	 * Buscar por Companhia
	 * 
	 * @param companhia
	 * @return List<EServico>
	 */
	public List<EServico> findByCompanhia(ECompanhia companhia);
	
	/**
	 * Buscar por Tipo
	 * 
	 * @param tipo
	 * @return List<EServico>
	 */
	public List<EServico> findByTipo(String tipo);
	
	/**
	 * Buscar por Categoria
	 * 
	 * @param categoria
	 * @return List<EServico>
	 */
	public List<EServico> findByCategoria(String categoria);
	
	/**
	 * Buscar por Área
	 * 
	 * @param area
	 * @return List<EServico>
	 */
	public List<EServico> findByArea(String area);
	
	/**
	 * Executa query no banco
	 * 
	 * @param query
	 * @return List<EServico>
	 */
	@Query("SELECT s FROM EServico s WHERE s.nome LIKE :query")
	public List<EServico> findByQuery(@Param("query") String query);
	
}
