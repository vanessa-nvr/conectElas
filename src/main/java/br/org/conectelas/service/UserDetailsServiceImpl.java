package br.org.conectelas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.conectelas.model.UsuarioModel;
import br.org.conectelas.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UsuarioModel user = repository.findByEmail(username).map(resp -> resp)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));

		String senha = user.getSenha();
		
		UserDetailsImpl usuario = new UserDetailsImpl(username, senha);
		return usuario;
	}
	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
