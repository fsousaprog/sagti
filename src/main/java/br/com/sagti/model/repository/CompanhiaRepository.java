/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

package br.com.sagti.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sagti.model.entity.ECompanhia;

/**
 * Interface do manipulador da entidade ECompanhia
 * 
 * @author felipe
 */
@Repository
public interface CompanhiaRepository extends JpaRepository<ECompanhia, Long> {

	/**
	 * Buscar por ID
	 * 
	 * @param companhiaId
	 * @return ECompanhia
	 */
	public ECompanhia findById(long companhiaId);

	/**
	 * Buscar por nome ou parcial
	 * 
	 * @param nome
	 * @return List<ECompanhia>
	 */
	public List<ECompanhia> findByNome(String nome);

	/**
	 * Buscar por nome fantasia, ou parcial
	 * 
	 * @param nomeFantasia
	 * @return List<ECompanhia>
	 */
	public List<ECompanhia> findByNomeFantasia(String nomeFantasia);

	/**
	 * Buscar por Inicio Parceria
	 * 
	 * @param inicioParceria
	 * @return List<ECompanhia>
	 */
	public List<ECompanhia> findByInicioParceria(Date inicioParceria);

	/**
	 * Buscar por Ramo
	 * 
	 * @param ramo
	 * @return List<ECompanhia>
	 */
	public List<ECompanhia> findByRamo(String ramo);

	/**
	 * Executa query no banco
	 * 
	 * @param query
	 * @return List<ECompanhia>
	 */
	@Query("SELECT c FROM ECompanhia c WHERE c.nome LIKE :query")
	public List<ECompanhia> findByQuery(@Param("query") String query);

}
