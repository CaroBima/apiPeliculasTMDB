package com.peliculas.tmdbapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

/**
 * Api que consume la api de The Movie DataBase (https://www.themoviedb.org/)
 * @author Caro Bima
 * @version 1.0
 */
@SpringBootApplication
public class TmdbapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmdbapiApplication.class, args);
	}

}
