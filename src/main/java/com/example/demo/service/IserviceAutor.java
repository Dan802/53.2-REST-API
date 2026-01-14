package com.example.demo.service;

import com.example.demo.model.Autor;

import java.util.List;
import java.util.Optional;

public interface IserviceAutor {
    List<Autor> encontrarTodos();
    Optional<Autor> encontrarPorId(Long id);
    Autor guardar(Autor autor);
    void editarPersona(Long id, Autor autor);
    void eliminarAutor(Long id);
}
