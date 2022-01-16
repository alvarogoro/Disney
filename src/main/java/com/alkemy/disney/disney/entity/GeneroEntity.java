package com.alkemy.disney.disney.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genero")
@Getter
@Setter

public class GeneroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private String imagen;

    @Column(name = "pelicula_asociada")
    private String peliculaAsociada;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genero")
    private List<PeliculaEntity> peliculas;


}
