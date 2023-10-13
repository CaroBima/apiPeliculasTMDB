# Peliculas TMDB - tmdbapi

## Descripción

Microservicio que consume la api de películas de TMDB.

Api utilizada: https://developer.themoviedb.org/

## Endpoints
`/movies/{title}`: permite obtener la información de una película buscándola por su nombre.

`/movies/saved`: Devuelve un listado con todas las películas que han sido previamente consultadas

## Tecnologías

- Spring Boot 2.6.6
- Maven
- Java 11
- [The Movie Database](https://developer.themoviedb.org/)
- MySql connector 8.0.11
- Swagger


## Instalación

1. Clona el proyecto desde el repositorio.
2. Generar jar: `mvn clean package`
3. Ejecutar servicio: `java -jar <ruta-del-jar>`


## Estado del proyecto

El proyecto se encuentra en estado de desarrollo activo y actualmente está en la versión 0.0.1-SNAPSHOT. 

<!--
Uso
Instrucciones sobre cómo utilizar la API. Incluye ejemplos de solicitudes y respuestas si es relevante.

## Funcionalidades (aún en desarrollo)
- Permite obtener una película buscandola por el nombre
- Guarda un listado de las películas que han sido previamente consultadas


-->
