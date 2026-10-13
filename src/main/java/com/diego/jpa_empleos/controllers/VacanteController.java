package com.diego.jpa_empleos.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.jpa_empleos.models.Vacante;
import com.diego.jpa_empleos.repository.VacantesRepository;

@RestController
@RequestMapping("/api/jpa-vacante")
public class VacanteController {
    @Autowired
    private VacantesRepository vacanteJPA;

    public VacanteController(VacantesRepository vacanteJPA) {
        this.vacanteJPA = vacanteJPA;
    }

    // Obtener todas las vacantes
    @GetMapping
    public List<Vacante> obtenerVacantes() {
        return (List<Vacante>) vacanteJPA.findAll();
    }

    // Guardar una vacante
    @PostMapping ("/guardar")
    public ResponseEntity<Vacante> guardarVacante(@RequestBody Vacante vacante){
        if (vacante.getFecha() == null) {
            vacante.setFecha(new Date());
        }
        Vacante nuevaVacante = vacanteJPA.save(vacante);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaVacante);
    }
}
