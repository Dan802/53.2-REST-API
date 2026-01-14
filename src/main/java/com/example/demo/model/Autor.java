package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "Autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // A constrained String is valid as long as it’s not null, and the trimmed length is greater than zero.
    @NotBlank
    private String nombre;

    @Email(message = "Correo no valido")
    @NotBlank(message = "El correo no puede ser vacio")
    private String email;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference // Evita bucles
    private List<Posteo> posts;

    public Autor() {
    }

    public Autor(Long id, String nombre, String email, List<Posteo> posts) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Posteo> getPosts() {
        return posts;
    }

    public void setPosts(List<Posteo> posts) {
        this.posts = posts;
    }
}
