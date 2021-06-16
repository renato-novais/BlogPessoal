package org.generation.BlogPessoal.security;

import java.util.Optional;

import org.generation.BlogPessoal.model.Usuario;
import org.generation.BlogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/* Optional<Usuario> username = usuarioRepository.findByUsuario(username);
		 * usuario.orElseThrow(() -> new
		 * UsernameNotFoundException("Usuario não encontrado"));
		 * 
		 * return usuario.map(UserDetailsImpl::new).get();
		 */
		Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
		if (usuario.isPresent()) {
			return new UserDetailsImpl(usuario.get());
		} else {
			throw new UsernameNotFoundException(username + " not found.");
		}
	}

}
