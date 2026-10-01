package com.diego.jpa_empleos;

import java.util.Optional;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.diego.jpa_empleos.models.Categoria;
//import com.diego.jpa_empleos.repository.CategoriasRepository;

@SpringBootApplication
public class JpaEmpleosApplication //implements CommandLineRunner 
{
	public static void main(String[] args) {
		SpringApplication.run(JpaEmpleosApplication.class, args);
	}

	/* 
	private final CategoriasRepository categoriasRepo;

	public JpaEmpleosApplication(CategoriasRepository categoriasRepo) {
		this.categoriasRepo = categoriasRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		eliminar();
	}

	// Para eliminar se hace uso de la funcion deleteByID
	private void eliminar() {
		int idCategoria = 1;
		categoriasRepo.deleteById(idCategoria);
		System.out.println("Registro eliminado...");
	}

	// Para la busqueda de un registro especifico primero se berifica que exista con optional ya que si no se encuentra un valor devuelve null y evita errores al realizarbusquedas con funciones 
	private void buscarPorId() {
		Optional<Categoria> categoriaBuscada = categoriasRepo.findById(1);
		if (categoriaBuscada.isPresent()) {
			System.out.println(categoriaBuscada.get());
		} else {
			System.out.println("Categoría no encontrada");
		}
	}
	// Para guardar y modificar la funcion save lo permite, para guardar se usa el objeto sin ID, y para modificar se menciona la ID y se verifica que exista antes
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
	*/
}