package com.peliculas.tmdbapi.controller;

import com.peliculas.tmdbapi.model.Movie;
import com.peliculas.tmdbapi.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

        private final IMovieService movieService;

        @Autowired
        public MovieController(IMovieService movieService) {
            this.movieService = movieService;
        }

        @GetMapping("/{title}")
        public ResponseEntity<Movie> getMovie(@PathVariable String title) {
            // Lógica para obtener información de una película por título
            return ResponseEntity.ok(movieService.getMovie(title));
        }

        @PostMapping
        public ResponseEntity<Void> saveMovie(@RequestBody Movie movie) {
            // Permitirá guardar una película en la bbdd
            movieService.saveMovie(movie);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        @GetMapping("/saved")
        public ResponseEntity<List<Movie>> getSavedMovies() {
            // Permitirá obtener la lista de películas guardadas
            return ResponseEntity.ok(movieService.getMoviesSaved());
        }

}
