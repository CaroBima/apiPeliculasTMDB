package com.peliculas.tmdbapi.repository.users;

import com.peliculas.tmdbapi.entities.users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {


    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}