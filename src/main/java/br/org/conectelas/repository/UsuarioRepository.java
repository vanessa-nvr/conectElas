package br.org.conectelas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.conectelas.model.UsuarioModel;

@Repository 
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	
	Optional <UsuarioModel> findByEmail(String email);

}
