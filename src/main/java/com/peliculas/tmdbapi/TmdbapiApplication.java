package com.peliculas.tmdbapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Map;

/**
 * Api que consume la api de The Movie DataBase (https://www.themoviedb.org/)
 * @author Caro Bima
 * @version 0.0.1-SNAPSHOT
 */
//@SpringBootApplication(scanBasePackages = {"com.peliculas.tmdbapi"})
//@EntityScan(basePackages = {"com.peliculas.tmdbapi.entities.movies", "com.peliculas.tmdbapi.entities.users"})
@SpringBootApplication(scanBasePackages={"com.*"})
@EntityScan( basePackages = {"com.*"} )
@EnableJpaRepositories( basePackages = {"com.*"} )
public class TmdbapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmdbapiApplication.class, args);
	}

}
