package com.diego.jpa_empleos.repository;

import org.springframework.data.repository.CrudRepository;

import com.diego.jpa_empleos.models.Categoria;

public interface CategoriasRepository extends CrudRepository<Categoria, Integer> {
}
