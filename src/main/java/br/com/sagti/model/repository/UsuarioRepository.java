/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/

package br.com.sagti.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sagti.model.entity.EUsuario;

/**
 * Interface do manipulador da entidade EUsuario
 * 
 * @author felipe
 */
@Repository
public interface UsuarioRepository extends JpaRepository<EUsuario, Long> {
	
	/**
	 * Buscar por ID
	 * 
	 * @param usuarioId
	 * @return EUsuario
	 */
	public EUsuario findById(long usuarioId);
	
	/**
	 * Buscar por nome ou parcial
	 * 
	 * @param nome
	 * @return List<EUsuario>
	 */
	public List<EUsuario> findByNome(String nome);
	
	/**
	 * Buscar por login
	 * 
	 * @param login
	 * @return EUsuario
	 */
	public EUsuario findByLogin(String login);
	
	/**
	 * Buscar por Cargo
	 * 
	 * @param cargo
	 * @return List<EUsuario>
	 */
	public List<EUsuario> findByCargo(String cargo);
	
	/**
	 * Buscar por Nivel de Acesso
	 * 
	 * @param nivelAcesso
	 * @return List<EUsuario>
	 */
	public List<EUsuario> findByNivelAcesso(int nivelAcesso);
	
	/**
	 * Executa query no banco
	 * 
	 * @param query
	 * @return List<EUsuario>
	 */
	@Query("SELECT u FROM EUsuario u WHERE u.nome LIKE :query")
	public List<EUsuario> findByQuery(@Param("query") String query);
	
}
