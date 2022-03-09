package br.org.conectelas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.conectelas.model.UsuarioModel;
import br.org.conectelas.repository.UsuarioRepository;

@Service

public class UsuarioService {

	@Autowired
	private UserDetailsServiceImpl usuarioService;
	@Autowired
	private UsuarioRepository repository;

	public ResponseEntity<UsuarioModel> registrar(UsuarioModel usuario) {
		usuario.setSenha(passwordEncoder().encode(usuario.getSenha()));
		return ResponseEntity.ok(repository.save(usuario));

	}
	
	public ResponseEntity<UsuarioModel> login(UsuarioModel usuario) {
		usuarioService.loadUserByUsername(usuario.getEmail());
		return ResponseEntity.ok().body(usuario);
	}
	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
