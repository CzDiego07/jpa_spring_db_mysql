package com.diego.jpa_empleos.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.jpa_empleos.models.Perfil;
import com.diego.jpa_empleos.models.Usuario;
import com.diego.jpa_empleos.repository.PerfilesRepository;
import com.diego.jpa_empleos.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/jpa-perfil")
public class PerfilController {
    @Autowired
    private PerfilesRepository perfilJPA;
    private UsuarioRepository usuarioJPA;

    public PerfilController(PerfilesRepository perfilJPA, UsuarioRepository usuarioJPA) {
        this.perfilJPA = perfilJPA;
        this.usuarioJPA = usuarioJPA;
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscarUsuarioPorID(@PathVariable Integer id) {
        return usuarioJPA.findById(id);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioNuevo = usuarioJPA.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioNuevo);
    }

    @PostMapping("/perfil/guardar")
    public ResponseEntity<Perfil> guardarPerfil(@RequestBody Perfil perfil){
        Perfil perfilNuevo = perfilJPA.save(perfil);
        return  ResponseEntity.status(HttpStatus.CREATED).body(perfilNuevo);
    }

}
