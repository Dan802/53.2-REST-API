package com.example.demo.service;

import com.example.demo.model.Posteo;
import com.example.demo.repository.IposteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosteoService implements IservicePosteo{

    private final IposteoRepository iposteoRepository;

    public PosteoService(IposteoRepository iposteoRepository) {
        this.iposteoRepository = iposteoRepository;
    }

    @Override
    public List<Posteo> encontrarTodos() {
        return iposteoRepository.findAll();
    }

    @Override
    public Optional<Posteo> encontrarPorId(Long id) {
        return iposteoRepository.findById(id);
    }

    @Override
    public void guardar(Posteo posteo) {
        iposteoRepository.save(posteo);
    }

    @Override
    public void editarPersona(Long id, Posteo posteoActualizado) {
        //Saber si exsite
        Posteo posteoViejo = iposteoRepository.findById(id).orElse(null);

        if (posteoViejo != null){
            //Actualizar los campos de persona existente
            posteoViejo.setTitulo(posteoActualizado.getTitulo());
            posteoViejo.setContenido(posteoActualizado.getContenido());
            posteoViejo.setFechaCreacion(posteoActualizado.getFechaCreacion());

            // Guardo a la persona actualziada
            iposteoRepository.save(posteoViejo);
        } else {
            throw new RuntimeException("Post no encontrado con el id: " + id);
        }
    }

    @Override
    public void eliminarPost(Long id) {
        //Saber si exsite
        Posteo posteoViejo = iposteoRepository.findById(id).orElse(null);

        if(posteoViejo != null) {
            iposteoRepository.delete(posteoViejo);
        } else {
            throw new RuntimeException("Post no encontrado con el id: " + id);
        }
    }
}
