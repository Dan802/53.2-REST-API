package com.example.demo.controller;

import com.example.demo.model.Posteo;
import com.example.demo.service.PosteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PosteoController {

    private final PosteoService posteoService;

    public PosteoController(PosteoService posteoService) {
        this.posteoService = posteoService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Posteo>> obtenerPosteos() {
        List<Posteo> posteos = posteoService.encontrarTodos();
        return new ResponseEntity<>(posteos, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Optional<Posteo>> obtenerPosteoPorId(@PathVariable Long id) {

        Optional<Posteo> posteo = posteoService.encontrarPorId(id);
        return new ResponseEntity<>(posteo, HttpStatus.OK);
    }

    @PostMapping("/posts")
    public ResponseEntity<String> crearPosteo(@RequestBody Posteo posteo) {

//        example:
//        {
//            "titulo": "Hola mundo",
//            "contenido": "Les comparto mi primer proyecto de holaMundo",
//            "fechaCreacion": "2012-04-23"
//        }

        posteoService.guardar(posteo);
        return ResponseEntity.ok("Post agregado con exito");
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<String> actualizarPost(@PathVariable Long id, @RequestBody Posteo posteo) {
        posteoService.editarPersona(id, posteo);
        return ResponseEntity.ok("Post actualizado correctamente");
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> eliminarPost(@PathVariable Long id) {
        posteoService.eliminarPost(id);
        return ResponseEntity.ok("Post eliminado correctamente");
    }

}
