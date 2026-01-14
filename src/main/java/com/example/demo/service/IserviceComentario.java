package com.example.demo.service;

import com.example.demo.model.Comment;

import java.util.List;
import java.util.Optional;

public interface IserviceComentario {
    List<Comment> encontrarTodos();
    Optional<Comment> encontrarPorId(Long id);
    Comment guardar(Comment comment);
    void editarComentario(Long id, Comment comment);
    void eliminarComentario(Long id);
}
