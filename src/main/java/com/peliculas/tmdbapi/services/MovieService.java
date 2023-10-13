package com.peliculas.tmdbapi.services;

import com.peliculas.tmdbapi.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de la interfaz {@link IMovieService} que proporciona lógica
 * para interactuar con películas en un servicio.
 *
 * @see IMovieService
 * @see Movie
 */
@Service
public class MovieService implements  IMovieService{

    /**
     * {@inheritDoc}
     */
    @Override
    public Movie getMovie(String title) {
        // La implementación de la lógica para obtener una película por su título
        // aún no está definida. Se devuelve null temporalmente.
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveMovie(Movie movie) {
        // La implementación de la lógica para guardar una película
        // aún no está definida.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Movie> getMoviesSaved() {
        // La implementación de la lógica para obtener la lista de películas
        // guardadas aún no está definida. Se devuelve null temporalmente.
        return null;
    }
}
