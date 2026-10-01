package com.diego.jpa_empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.jpa_empleos.models.Categoria;

public interface CategoriasJPARepository extends JpaRepository<Categoria, Integer> {
}