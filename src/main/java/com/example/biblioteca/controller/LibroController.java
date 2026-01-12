package com.example.biblioteca.controller;

import com.example.biblioteca.entity.Libro;
import com.example.biblioteca.service.LibroService;
import com.example.biblioteca.service.LibroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api")
public class LibroController {


        @Autowired
        private LibroService libroService;; // Se inyecta la dependencia

        @GetMapping
        public List<Libro> obtenerTodos() {
            return this.libroService.getLibros();
        }

        @GetMapping("/{id}")
        public Optional<Libro> obtenerPorId(@PathVariable Long id) {
            return this.libroService.getLibro(id);
        }

        @PostMapping
        public void guardar0ActualizarLibros(@RequestBody Libro libro) {
             this.libroService.guardar0ActualizarLibros(libro);
        }

        @DeleteMapping("/{id}")
        public void eliminar(@PathVariable("id") Long id) {
            this.libroService.eliminarLibro(id);
        }

}
