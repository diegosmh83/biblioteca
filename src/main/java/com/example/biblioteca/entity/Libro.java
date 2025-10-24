package com.example.biblioteca.entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Libro")

public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column
    private String autor;

}
