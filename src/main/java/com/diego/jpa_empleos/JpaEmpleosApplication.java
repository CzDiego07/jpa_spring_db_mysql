package com.diego.jpa_empleos;

/* 
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/* 
import com.diego.jpa_empleos.models.Vacante;
import com.diego.jpa_empleos.models.EstatusVacante;
import com.diego.jpa_empleos.models.Categoria;
import com.diego.jpa_empleos.repository.VacantesRepository;
*/
@SpringBootApplication
public class JpaEmpleosApplication //implements CommandLineRunner 
{
	/*private final VacantesRepository vacantesRepo;

	public JpaEmpleosApplication(VacantesRepository vacantesRepo) {
		this.vacantesRepo = vacantesRepo;
	}

	*/
	public static void main(String[] args) {
		SpringApplication.run(JpaEmpleosApplication.class, args);
	}
	/*
	@Override
	public void run(String... args) throws Exception {
		//guardarVacante();
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

	// Guardar una nueva vacante
	private void guardarVacante() {
		Vacante vacante = new Vacante();
		vacante.setNombre("Desarrollador Java PRO");
		vacante.setDescripcion("Se busca desarrollador con experiencia en Spring Boot y JPA.");
		vacante.setFecha(new Date());
		vacante.setSalario(25000.0);
		vacante.setEstatus(EstatusVacante.Creada); // Enum, asegúrate que exista en tu proyecto
		vacante.setDestacado(1);
		vacante.setImagen("logo_empresa.png");
		vacante.setDetalles("Trabajo remoto con horario flexible. Beneficios y capacitación incluidos.");
		// Crear una categoría asociada
		Categoria categoria = new Categoria();
		categoria.setId(1); // Si ya existe en la BD, solo asignas el id
		// o puedes crear una nueva:
		// categoria.setNombre("Tecnología");
		// categoria.setDescripcion("Empleos relacionados con desarrollo y TI.");
		vacante.setCategoria(categoria);
		vacantesRepo.save(vacante);
	}
	*/
}