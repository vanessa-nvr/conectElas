package br.org.conectelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.conectelas.model.UsuarioModel;
import br.org.conectelas.service.UsuarioService;

@RestController
@RequestMapping
@CrossOrigin(origins="*", allowedHeaders="*")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody UsuarioModel usuario) {
		return service.registrar(usuario);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UsuarioModel usuario) {
		return service.login(usuario);
	}
	
}
