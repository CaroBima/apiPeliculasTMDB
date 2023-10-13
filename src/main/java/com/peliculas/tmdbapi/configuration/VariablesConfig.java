package com.peliculas.tmdbapi.configuration;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuración que permite tomar las variables de entorno para que puedan ser utilizadas desde los servicios.
 */
@Getter
@Configuration
public class VariablesConfig {
    static String tmdbApiKey = System.getenv("APIKEYPELICULASTMDB");
    static String tmdbApiToken = System.getenv("APITOKENPELICULASTMDB");
}
