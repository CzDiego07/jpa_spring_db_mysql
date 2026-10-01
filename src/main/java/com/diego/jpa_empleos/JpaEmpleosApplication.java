package com.diego.jpa_empleos;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diego.jpa_empleos.models.Categoria;
import com.diego.jpa_empleos.repository.CategoriasRepository;

@SpringBootApplication
public class JpaEmpleosApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(JpaEmpleosApplication.class, args);
	}

	private final CategoriasRepository categoriasRepo;

	public JpaEmpleosApplication(CategoriasRepository categoriasRepo) {
		this.categoriasRepo = categoriasRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		modificar();
	}

	private void buscarPorId() {
		Optional<Categoria> categoriaBuscada = categoriasRepo.findById(1);
		if (categoriaBuscada.isPresent()) {
			System.out.println(categoriaBuscada.get());
		} else {
			System.out.println("Categoría no encontrada");
		}
	}

	private void guardar() {
		System.out.println("Guardando...");
		Categoria nuevaCategoria = new Categoria();
		nuevaCategoria.setNombre("Finanzas");
		nuevaCategoria.setDescripcion("Trabajos relacionados con finanzas y " +
				"contabilidad");
		categoriasRepo.save(nuevaCategoria);
		System.out.println(nuevaCategoria);
	}

	private void modificar() {
		Optional<Categoria> categoriaBuscada = categoriasRepo.findById(1);
		if (categoriaBuscada.isPresent()) {
			Categoria categoriaTmp = categoriaBuscada.get();
			categoriaTmp.setNombre("Ingeniería de Software");
			categoriaTmp.setDescripcion("Desarrollo de sistemas");
			categoriasRepo.save(categoriaTmp);

			System.out.println(categoriaBuscada);
			System.out.println("Categoría actualizada...");
		} else {
			System.out.println("Categoría no encontrada");
		}
	}
}