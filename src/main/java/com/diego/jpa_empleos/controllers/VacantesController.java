package com.diego.jpa_empleos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diego.jpa_empleos.models.EstatusVacante;
import com.diego.jpa_empleos.models.Vacante;
import com.diego.jpa_empleos.repository.VacantesRepository;

@RestController
@RequestMapping("/api/jpa-vacante-query")
public class VacantesController {
    @Autowired
    private VacantesRepository vacanteJPA;

    public VacantesController(VacantesRepository vacanteJPA) {
        this.vacanteJPA = vacanteJPA;
    }

    @GetMapping("/estatus-varios")
    public List<Vacante> obtenerVariosEstados(@RequestParam EstatusVacante[] estatus) {
        return vacanteJPA.findByEstatusIn(estatus);
    }

    @GetMapping("/salario")
    public List<Vacante> obtenerPorRangoSalario(
            @RequestParam Double minimo,
            @RequestParam Double maximo) {
        return vacanteJPA.findBySalarioBetween(minimo, maximo);
    }

    @GetMapping("/salario/desc")
    public List<Vacante> obtenerPorRangoSalarioDesc(
            @RequestParam Double minimo,
            @RequestParam Double maximo) {
        return vacanteJPA.findBySalarioBetweenOrderBySalarioDesc(minimo, maximo);
    }

    @GetMapping("/destacadas")
    public List<Vacante> obtenerDestacadasYEstatus(
            @RequestParam int destacado,
            @RequestParam EstatusVacante estatus) {
        return vacanteJPA.findByDestacadoAndEstatusOrderByIdDesc(destacado, estatus);
    }

    @GetMapping("/estatus")
    public List<Vacante> obtenerPorEstatus(@RequestParam EstatusVacante estatus) {
        return vacanteJPA.findByEstatus(estatus);
    }
}
