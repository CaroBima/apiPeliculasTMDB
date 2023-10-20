package com.peliculas.tmdbapi.services;


import com.peliculas.tmdbapi.entities.users.Usuario;

public interface IUsuarioService {
    public Usuario crearUsuario(Usuario usuario);

    public Usuario buscarUnUsuario(Long idUsuario);

    public boolean logueoUsuario(Usuario usuario);


}