package com.example.biblioteca;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BienvenidoController {

    @GetMapping
    public String bienvenida(){
        return "Bienvenid@ al Monte Naranco";
    }
}
