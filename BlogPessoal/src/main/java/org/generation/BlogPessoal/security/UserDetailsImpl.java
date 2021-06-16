package org.generation.BlogPessoal.security;

import java.util.Collection;
import java.util.List;

import org.generation.BlogPessoal.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String senha;
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl(Usuario usuarioBatatinha) {
		this.usuario = usuarioBatatinha.getUsuario();
		this.senha = usuarioBatatinha.getSenha();
	}
	
	public UserDetailsImpl() { //vazio?
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	

	

}
