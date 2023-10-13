package com.peliculas.tmdbapi.services;

import com.peliculas.tmdbapi.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * Implementación de la interfaz {@link IMovieService}.
 * MovieService es un servicio que interactúa con la API de The Movie Database (TMDb).
 * Proporciona métodos para obtener información de películas  de la api externa, guardar las películas consultadas
 * en la base de datos y consultar las películas guardadas allí.
 *
 * @see IMovieService
 * @see Movie
 */
@Service
public class MovieService implements  IMovieService{

    private final String tmdbUrl;
    private final String tmdbApiKey;
    private final String tmdbApiToken;

    /**
     * Constructor para la clase MovieService.
     *
     * @param tmdbUrl     La URL base de la API de The Movie Database.
     * @param tmdbApiKey  La clave API utilizada para autenticar con la API de The Movie Database.
     * @param tmdbApiToken El token API utilizado para autenticar con la API de The Movie Database.
     */
    @Autowired
    public MovieService(@Value("${api.tmdb.url}") String tmdbUrl,
                      @Value("${APIKEYPELICULASTMDB}") String tmdbApiKey,
                      @Value("${APITOKENPELICULASTMDB}") String tmdbApiToken) {
        this.tmdbUrl = tmdbUrl;
        this.tmdbApiKey = tmdbApiKey;
        this.tmdbApiToken = tmdbApiToken;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Movie getMovie(String title) throws IOException, InterruptedException {
        // La implementación de la lógica para obtener una película por su título
        // aún no está completa. Por ahora se conecta y trae la info de una pelicula preseteada
        // Se devuelve null temporalmente.

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.tmdbUrl + "movie/9354?api_key=" + this.tmdbApiKey))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + this.tmdbApiToken)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
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
