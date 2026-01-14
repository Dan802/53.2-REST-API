package com.example.demo.repository;
import com.example.demo.model.Posteo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IposteoRepository extends JpaRepository<Posteo, Long> {
}
