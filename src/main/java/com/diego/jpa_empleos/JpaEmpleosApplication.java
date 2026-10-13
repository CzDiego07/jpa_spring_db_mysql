package com.diego.jpa_empleos;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diego.jpa_empleos.models.Vacante;
import com.diego.jpa_empleos.repository.VacantesRepository;

@SpringBootApplication
public class JpaEmpleosApplication implements CommandLineRunner {
	private final VacantesRepository vacantesRepo;

	public JpaEmpleosApplication(VacantesRepository vacantesRepo) {
		this.vacantesRepo = vacantesRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaEmpleosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		buscarVacantesRelacionCategoriaNombre();
	}

	private void guardar() {
		System.out.println("guardando");
	}

	private void eliminar() {
		System.out.println("eliminando");
	}

	private void buscarVacantes() {
		List<Vacante> vacantes = vacantesRepo.findAll();
		for (Vacante vacante : vacantes) {
			System.out.println(vacante.getId() + ". " + vacante.getNombre());
		}
	}

	// Buscar vacantes agregando categoria y nombre
	public void buscarVacantesRelacionCategoriaNombre() {
		List<Vacante> vacantes = vacantesRepo.findAll();
		for (Vacante vacante : vacantes) {
			System.out.println(vacante.getId() + ". " + vacante.getNombre() +
					" -> " + vacante.getCategoria().getNombre());
		}
	}
}