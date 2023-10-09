package com.peliculas.tmdbapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class TmdbapiApplication {

	@Value("${tmdb.api.key}")
	private static String tmdbApiKey;
	public static void main(String[] args) {
		SpringApplication.run(TmdbapiApplication.class, args);
		String valor = System.getenv("APIKEYPELICULASTMDB");
		System.out.println(tmdbApiKey);
		System.out.println(valor);

		Map<String, String> env = System.getenv();
		for (String key : env.keySet()) {
			System.out.println(key + ": " + env.get(key));
		}

	}

}
