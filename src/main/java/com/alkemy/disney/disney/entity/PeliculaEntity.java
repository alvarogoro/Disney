package com.alkemy.disney.disney.entity;

import javax.persistence.*;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pelicula")
@Getter
@Setter

public class PeliculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String titulo;

    @Column(name = "fecha_de_creacion")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private LocalDate fechaDeCreacion;

    private int calificacion;


    @Column(name = "personajes_asociados")
    private String personajesAsociados;

    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false, updatable = false)
    private GeneroEntity genero;


    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "pelicula_personaje",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))

    private Set<PersonajeEntity> personajes = new HashSet<>();
}
