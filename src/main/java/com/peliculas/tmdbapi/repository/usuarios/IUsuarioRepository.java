package com.peliculas.tmdbapi.repository.usuarios;

import com.peliculas.tmdbapi.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {


    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}