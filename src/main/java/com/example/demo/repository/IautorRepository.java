package com.example.demo.repository;

import com.example.demo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IautorRepository extends JpaRepository<Autor, Long> {
}
