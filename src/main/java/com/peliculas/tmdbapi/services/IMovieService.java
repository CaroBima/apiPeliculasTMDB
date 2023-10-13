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
    /**
     * Obtiene una película por su título.
     *
     * @param title Título de la película que se desea obtener.
     * @return La película correspondiente al título especificado, o {@code null} si no se encuentra.
     */
    public Movie getMovie(String title);

    /**
     * Permite guardar una película en la base de datos.
     *
     * @param movie La película que se va a guardar.
     */
    public void saveMovie(Movie movie);

    /**
     * Obtiene la lista de películas guardadas en la base de datos.
     *
     * @return Lista de películas almacenadas en la base de datos.
     */
    public List<Movie> getMoviesSaved();


}
