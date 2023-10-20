package com.peliculas.tmdbapi.entities.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idUsuario;

    @Column(unique = true, nullable = false)
    private String nombreUsuario;

    private String contrasenia;

    private String email;

    @ManyToOne
    private RolUsuario rolUsuario;
}