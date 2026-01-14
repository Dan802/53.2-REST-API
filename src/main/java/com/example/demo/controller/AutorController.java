package com.example.demo.controller;

import com.example.demo.model.Autor;
import com.example.demo.service.IserviceAutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutorController {

    private final IserviceAutor iserviceAutor;

    public AutorController(IserviceAutor iserviceAutor) {
        this.iserviceAutor = iserviceAutor;
    }

    @GetMapping("/autores")
    public ResponseEntity<List<Autor>> obtenerAutores() {
        List<Autor> autores = iserviceAutor.encontrarTodos();
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    @PostMapping("/autores")
    public Autor crearAutor(@RequestBody Autor autor) {

        /*{
            "nombre": "Juan",
            "email": "juan@correo.com"
        }*/

        return iserviceAutor.guardar(autor);
    }
}