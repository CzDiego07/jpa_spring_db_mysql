package com.diego.jpa_empleos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.jpa_empleos.models.Categoria;
import com.diego.jpa_empleos.repository.CategoriasRepository;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriasRepository categoria;

    public CategoriaController(CategoriasRepository categoria) {
        this.categoria = categoria;
    }

    // Obtener todos los registros de la base
    // Permite crear valores pero sin control sobre resultados de estado
    @GetMapping
    public List<Categoria> obtenerTodos() {
        return (List<Categoria>) categoria.findAll();
    }

    // Obtener por ID
    // Optional es usado en caso de que no exista un dato(Consulta por id y no
    // existe) para evitar error de dato no existente ya que devuelve un NULL en
    // caso de estar vacio
    @GetMapping("/{id}")
    public Optional<Categoria> obtenerPorID(@PathVariable Integer id) {
        return (Optional<Categoria>) categoria.findById(id);
    }

    // Agregar nuevo registro
    // Con Responde Entity es posible el mandar una respuesta de Estado y al mismo
    // tiempo mandar el cuerpo
    @PostMapping
    public ResponseEntity<Categoria> guardar(@RequestBody Categoria registro) {
        Categoria nuevo = categoria.save(registro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // Actualizar un registro existente
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Integer id, @RequestBody Categoria cambio) {
        if(!categoria.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        cambio.setId(id);
        Categoria actualizar = categoria.save(cambio);
        return ResponseEntity.ok(actualizar);
    }

    //Eliminar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> eliminar (@PathVariable Integer id){
        if(categoria.existsById(id)){
            categoria.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
