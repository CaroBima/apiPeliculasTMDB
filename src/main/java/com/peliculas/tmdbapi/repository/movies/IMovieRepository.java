package com.peliculas.tmdbapi.repository.movies;

import com.peliculas.tmdbapi.entities.movies.MovieEntity;
import com.peliculas.tmdbapi.model.movies.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IMovieRepository extends JpaRepository<MovieEntity, Long> {
    List<Movie> findByTitle(String movieTitle);
    List<MovieEntity> findByConsultationDate(LocalDate consultationDate);
}


