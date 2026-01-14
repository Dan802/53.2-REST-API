package com.example.demo.service;

import com.example.demo.model.Autor;
import com.example.demo.repository.IautorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements IserviceAutor{

    private final IautorRepository iautorRepository;

    public AutorService(IautorRepository iautorRepository) {
        this.iautorRepository = iautorRepository;
    }

    @Override
    public List<Autor> encontrarTodos() {
        return iautorRepository.findAll();
    }

    @Override
    public Optional<Autor> encontrarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public Autor guardar(Autor autor) {
        return iautorRepository.save(autor);
    }

    @Override
    public void editarPersona(Long id, Autor autor) {

    }

    @Override
    public void eliminarAutor(Long id) {

    }
}
