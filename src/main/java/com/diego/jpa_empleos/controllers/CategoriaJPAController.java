package com.diego.jpa_empleos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diego.jpa_empleos.models.Categoria;
import com.diego.jpa_empleos.repository.CategoriasJPARepository;

@RestController
@RequestMapping("/api/jpa-categorias")
public class CategoriaJPAController {
    @Autowired
    private CategoriasJPARepository categoriasJPA;

    public CategoriaJPAController(CategoriasJPARepository categoriasJPA) {
        this.categoriasJPA = categoriasJPA;
    }

    // 1. Obtener todas las categorías
    @GetMapping
    public List<Categoria> obtenerTodasCategorias() {
        return (List<Categoria>) categoriasJPA.findAll();
    }

    // 2. Obtener categorías ordenadas por nombre
    @GetMapping("/ordenadas")
    public List<Categoria> obtenerCategoriasByNombre() {
        return (List<Categoria>) categoriasJPA.findAll(Sort.by("nombre").descending());
    }

    // 3. Obtener categorías con paginación
    @GetMapping("/paginadas")
    public Page<Categoria> categoriasPaginadas(@RequestParam Integer pagina, @RequestParam Integer cantidad) {
        return (Page<Categoria>) categoriasJPA.findAll(PageRequest.of(pagina, cantidad));
    }

    // 4. Obtener categorías con paginación y orden
    @GetMapping("/paginadas/ordenadas")
    public Page<Categoria> categoriasPaginadasDescendente(@RequestParam Integer pagina,
            @RequestParam Integer cantidad) {
        return (Page<Categoria>) categoriasJPA.findAll(
                PageRequest.of(pagina, cantidad,
                        Sort.by("nombre").descending()));
    }

    // 5. Eliminar todas las categorías
    @DeleteMapping("/todas")
    public ResponseEntity<Categoria> eliminar() {
        categoriasJPA.deleteAllInBatch();
        return ResponseEntity.noContent().build();
    }

}