package com.example.demo.controller;

import com.example.demo.model.Autor;
import com.example.demo.model.Comment;
import com.example.demo.service.IserviceComentario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComentarioController {
    private final IserviceComentario iserviceComentario;

    public ComentarioController (IserviceComentario iserviceComentario) {
        this.iserviceComentario = iserviceComentario;
    }

    @GetMapping("/comentarios")
    public ResponseEntity<List<Comment>> obtenerAutores() {
        List<Comment> comentarios = iserviceComentario.encontrarTodos();
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }

    @PostMapping("/comentarios")
    public Comment crearComentario(@RequestBody Comment comment) {

        /*{
            "text" : "nuevo comentario",
            "createdat" : "2025-12-24"
        }*/

        return iserviceComentario.guardar(comment);
    }
}
