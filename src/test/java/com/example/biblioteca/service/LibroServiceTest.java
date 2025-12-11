package com.example.biblioteca.service;

import com.example.biblioteca.entity.Libro;
import com.example.biblioteca.repository.LibroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LibroServiceTest {

    @InjectMocks
    LibroServiceImpl servicio;

    @Mock
    LibroRepository libroRepository;

    @Test
    public void getLibroTest(){
        Libro libroEsperado = new Libro(1L, "TITULO 1", "AUTOR 1");
        Mockito.when(this.libroRepository.findById(1L)).thenReturn(Optional.of(libroEsperado));

        Optional<Libro> resultado = servicio.getLibro(1L);
        if(resultado.isPresent()){
            assertEquals(libroEsperado, resultado.get());
        }
        Mockito.verify(libroRepository).findById(1L);
    }

}
