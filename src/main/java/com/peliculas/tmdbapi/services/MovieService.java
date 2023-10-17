package com.peliculas.tmdbapi.services;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peliculas.tmdbapi.model.Movie;
import com.peliculas.tmdbapi.model.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Movie> getMovie(String title) throws IOException, InterruptedException {

        //Trae una lista de peliculas, falta agregarlas a un listado y devolver el listado.
        //Falta guardar las peliculas en la base de datos y pasar solo los datos del dto a la controller
        //falta además validar si trae resultados o no, cuantas paginas de resultados trae y recorrer las paginas para
        // traer todas las películas (ahora solo recupera la primera pagina)

        ObjectMapper objectMapper = new ObjectMapper(); //utilizado para mapear el resultado devuelto por la api externa en un objeto Movie
        Movies movieListApiExt = new Movies();
        List<Movie> movieListReturned = new ArrayList<Movie>();


        //trae la info de la api externa
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.tmdbUrl + "search/movie?query="+title +"&include_adult=false&language=es-LA&page=1&api_key=" + this.tmdbApiKey ))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + this.tmdbApiToken)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        try { //Parseo el resultado traido a una Movie
            movieListApiExt = objectMapper.readValue(response.body(), Movies.class);

            //recorro la lista de movies devuelta por la api y guardo cada pelicula en la lista de peliculas
            movieListReturned = movieListApiExt.getResults().stream()
                    .map(oneMovie -> {
                        Movie movie = new Movie();
                        movie.setId(oneMovie.getId());
                        movie.setTitle(oneMovie.getTitle());
                        movie.setOriginal_title(oneMovie.getOriginal_title());
                        movie.setPoster_path(oneMovie.getPoster_path());
                        movie.setOverview(oneMovie.getOverview());
                        movie.setRelease_date(oneMovie.getRelease_date());
                        movie.setVote_average(oneMovie.getVote_average());
                        movie.setVote_count(oneMovie.getVote_count());
                        return movie;
                    })
                    .collect(Collectors.toList());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(response.body());
        return movieListReturned;
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
