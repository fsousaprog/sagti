/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/
package br.com.sagti;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sagti.model.entity.EUsuario;
import br.com.sagti.model.repository.UsuarioRepository;

/**
 * Created by filipe on 15/03/16.
 */
@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repositorio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		EUsuario usuario = (EUsuario) repositorio.findByLogin(username);

		List<GrantedAuthority> autoridades = new ArrayList<>();
		autoridades.add(new SimpleGrantedAuthority("USER"));

		return this.buildUserForAuthentication(usuario, autoridades);
	}

	private User buildUserForAuthentication(EUsuario usuario, List<GrantedAuthority> autoridades) {
		return new User(usuario.getLogin(), usuario.getSenha(), true, true, true, true, autoridades);
	}
}
