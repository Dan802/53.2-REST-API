package com.example.demo.service;

import com.example.demo.model.Comment;
import com.example.demo.repository.IcommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService implements IserviceComentario {

    private final IcommentRepository icommentRepository;

    public  ComentarioService(IcommentRepository icommentRepository) {
        this.icommentRepository = icommentRepository;
    }

    @Override
    public List<Comment> encontrarTodos() {
        return icommentRepository.findAll();
    }

    @Override
    public Optional<Comment> encontrarPorId(Long id) {
        Comment comment = icommentRepository.findById(id).orElseThrow();;

        return Optional.of(comment);
    }

    @Override
    public Comment guardar(Comment comment) {
        return icommentRepository.save(comment);
    }

    @Override
    public void editarComentario(Long id, Comment comment) {

    }

    @Override
    public void eliminarComentario(Long id) {

    }
}
