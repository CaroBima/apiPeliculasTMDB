package com.peliculas.tmdbapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Data Transfer Object (DTO) utilizado para representar la información procesada de las películas consultadas.
 * Contiene detalles como el título, título original, ruta del póster, descripción, presupuesto, fecha de lanzamiento y ingresos.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MovieDto {
    /**
     * Título de la película.
     */
    private String title;

    /**
     * Título original.
     */
    private String original_title;

    /**
     * Url de la imagen del poster.
     */
    private String poster_path;// (foto)

    /**
     * Descripción general de la trama.
     */
    private String overview;

    /**
     * Fecha de lanzamiento.
     */
    private Date release_date;

    /**
     * Calificación promedio otorgada por los usuarios
     */
    private Double vote_average;

    /**
     * Cantidad de usuarios que calificaron la película.
     */
    private Long vote_count;

}
