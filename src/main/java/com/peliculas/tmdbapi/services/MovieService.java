package com.peliculas.tmdbapi.services;

import com.peliculas.tmdbapi.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements  IMovieService{
    @Override
    public Movie getMovie(String title) {
        return null;
    }

    @Override
    public void saveMovie(Movie movie) {

    }

    @Override
    public List<Movie> getMoviesSaved() {
        return null;
    }
}
