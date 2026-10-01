package com.diego.jpa_empleos;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diego.jpa_empleos.models.Categoria;
import com.diego.jpa_empleos.repository.CategoriasJPARepository;

@SpringBootApplication
public class JpaEmpleosApplication implements CommandLineRunner {

	private final CategoriasJPARepository categoriasJPARepo;

	public JpaEmpleosApplication(CategoriasJPARepository categoriasJPARepo) {
		this.categoriasJPARepo = categoriasJPARepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaEmpleosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		borrarTodasEnBloque();
	}

	private void buscarTodasJPA() {
		List<Categoria> categorias = categoriasJPARepo.findAll();
		for (Categoria categoria : categorias) {
			System.out.println(categoria.getId() + " " + categoria.getNombre());
		}
	}

	private void borrarTodasEnBloque() {
		categoriasJPARepo.deleteAllInBatch();
	}

	private void guardar() {
		System.out.println("guardando");
	}

	private void eliminar() {
		System.out.println("eliminando");
	}
}