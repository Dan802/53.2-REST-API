package com.example.demo.service;

import com.example.demo.model.Posteo;

import java.util.List;
import java.util.Optional;

public interface IservicePosteo {
    List<Posteo> encontrarTodos();
    Optional<Posteo> encontrarPorId(Long id);
    void guardar(Posteo posteo);
    void editarPersona(Long id, Posteo postActualizado);

    void eliminarPost(Long id);
}
