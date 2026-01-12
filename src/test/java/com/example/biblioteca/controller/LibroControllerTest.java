package com.example.biblioteca.controller;

import com.example.biblioteca.entity.Libro;
import com.example.biblioteca.service.LibroService;
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
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LibroController.class)
@ActiveProfiles("test")
class LibroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibroService servicio;


    @Test
    void obtenerPorId() throws Exception{
        // Creamos el libro que vamos a devolver
        Libro libro = new Libro(1L, "TITULO 1", "AUTOR 1");

        // Mockeamos el servicio para que devuelva nuestro libro
        Mockito.when(servicio.getLibro(1L))
                .thenReturn(Optional.of(libro));

        // Creamos el RequestBuilder para la petición GET
        RequestBuilder request = MockMvcRequestBuilders.get("/libros/1");

        // Ejecutamos la petición con MockMvc
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.id").value(1L))
                .andExpect((ResultMatcher) jsonPath("$.titulo").value("TITULO 1"))
                .andExpect((ResultMatcher) jsonPath("$.autor").value("AUTOR 1"));

        // Verificamos que el servicio se llamó correctamente
        Mockito.verify(servicio).getLibro(1L);
    }


}