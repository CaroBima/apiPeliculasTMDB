package com.peliculas.tmdbapi.services;

import com.peliculas.tmdbapi.model.Movie;

import java.util.List;

/**
 * Interfaz que define operaciones para interactuar con películas en un servicio.
 * Proporciona métodos para obtener peliculas de la api, guardar películas consultadas en la base de datos y
 * recuperar películas previamente consultadas.
 *
 * @see Movie
 */

public interface IMovieService {
    public Movie getMovie(String title);
    public void saveMovie(Movie movie);
    public List<Movie> getMoviesSaved();


}
