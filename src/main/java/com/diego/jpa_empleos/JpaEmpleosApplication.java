package com.diego.jpa_empleos;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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
		buscarTodosPaginacion();
	}

	private void buscarTodosPaginacion() {
		Page<Categoria> page = categoriasJPARepo.findAll(PageRequest.of(0, 5));
		System.out.println("Total Registros: " + page.getTotalElements());
		System.out.println("Total Paginas: " + page.getTotalPages());
		for (Categoria c : page.getContent()) {
			System.out.println(c.getId() + " " + c.getNombre());
		}
	}

	private void buscarTodosOrdenadosDescendente() {
		List<Categoria> categorias = categoriasJPARepo.findAll(Sort.by("nombre").descending());
		for (Categoria categoria : categorias) {
			System.out.println(categoria.getId() + " " + categoria.getNombre());
		}
	}

	private void buscarTodosOrdenadosAscendente() {
		List<Categoria> categorias = categoriasJPARepo.findAll(Sort.by("nombre"));
		for (Categoria categoria : categorias) {
			System.out.println(categoria.getId() + " " + categoria.getNombre());
		}
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