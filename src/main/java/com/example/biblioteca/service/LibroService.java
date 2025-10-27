package com.example.biblioteca.service;

import com.example.biblioteca.entity.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {

    List<Libro> getLibros();
    Optional<Libro> getLibro(Long id);
    void guardar0ActualizarLibros(Libro libro);
    void eliminarLibro(Long id);
}
