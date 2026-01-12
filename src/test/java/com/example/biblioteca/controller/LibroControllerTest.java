package com.example.biblioteca.controller;

import com.example.biblioteca.entity.Libro;
import com.example.biblioteca.service.LibroService;
import com.example.biblioteca.service.LibroServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static java.lang.reflect.Array.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@WebMvcTest(LibroController.class)
@ActiveProfiles("test")
class LibroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibroServiceImpl libroServiceImpl;


    @Test
    void obtenerPorId() throws Exception {
        // Creamos el libro que vamos a devolver
        Libro libro = new Libro(1L, "TITULO 1", "AUTOR 1");

        // Mockeamos el servicio
        Mockito.when(libroServiceImpl.getLibro(1L))
                .thenReturn(Optional.of(libro));

        // Ejecutamos la petición con MockMvc
        mockMvc.perform(get("/api/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.titulo").value("TITULO 1"))
                .andExpect(jsonPath("$.autor").value("AUTOR 1"));

        // Verificamos que el servicio se llamó correctamente
        Mockito.verify(libroServiceImpl).getLibro(1L);
    }



}