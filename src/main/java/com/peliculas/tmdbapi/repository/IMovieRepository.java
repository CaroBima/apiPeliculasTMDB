package com.peliculas.tmdbapi.repository;

import com.peliculas.tmdbapi.entities.MovieEntity;
import com.peliculas.tmdbapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IMovieRepository extends JpaRepository<MovieEntity, Long> {
    List<Movie> findByTitle(String movieTitle);
    List<MovieEntity> findByConsultationDate(LocalDateTime consultationDate);
}


