package com.diego.jpa_empleos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		guardar();
		eliminar();
		System.out.println(categoriasRepo);
	}

	private void guardar() {
		System.out.println("guardando");
	}

	private void eliminar() {
		System.out.println("eliminando");
	}
}