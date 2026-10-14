package com.diego.jpa_empleos;
/*
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/* 
import com.diego.jpa_empleos.models.Categoria;
import com.diego.jpa_empleos.models.EstatusVacante;
import com.diego.jpa_empleos.models.Perfil;
import com.diego.jpa_empleos.models.Usuario;
import com.diego.jpa_empleos.models.Vacante;
import com.diego.jpa_empleos.repository.PerfilesRepository;
import com.diego.jpa_empleos.repository.UsuarioRepository;
import com.diego.jpa_empleos.repository.VacantesRepository;
 */
@SpringBootApplication
public class JpaEmpleosApplication //implements CommandLineRunner 
{
	/* 
	private final VacantesRepository vacantesRepo;
	private final PerfilesRepository perfilesRepo;
	private final UsuarioRepository usuarioRepo;

	public JpaEmpleosApplication(VacantesRepository vacantesRepo, PerfilesRepository perfilesRepo,
			UsuarioRepository usuarioRepo) {
		this.vacantesRepo = vacantesRepo;
		this.perfilesRepo = perfilesRepo;
		this.usuarioRepo = usuarioRepo;
	}
	*/
	public static void main(String[] args) {
		SpringApplication.run(JpaEmpleosApplication.class, args);
	}
	/* 
	@Override
	public void run(String... args) throws Exception {
		buscarUsuario();
	}

	private void crearPerfiles() {
		perfilesRepo.saveAll(obtenerPerfiles());
	}

	private List<Perfil> obtenerPerfiles() {
		List<Perfil> perfiles = new LinkedList<>();
		Perfil perfil1 = new Perfil();
		perfil1.setPerfil("SUPERVISOR");
		Perfil perfil2 = new Perfil();
		perfil2.setPerfil("ADMINISTRADOR");
		Perfil perfil3 = new Perfil();
		perfil3.setPerfil("USUARIO");
		perfiles.add(perfil1);
		perfiles.add(perfil2);
		perfiles.add(perfil3);
		return perfiles;
	}

	private void crearUsuarioConPerfiles() {
		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setNombre("José García");
		nuevoUsuario.setEmail("jose@gmail.com");
		nuevoUsuario.setUsername("joseg"); // 👈 nombre de usuario
		nuevoUsuario.setPassword("12345");
		nuevoUsuario.setEstatus(1); // activo por defecto
		nuevoUsuario.setFechaRegistro(LocalDate.now()); // 👈 fecha actual
		// Supongamos que ya tienes dos perfiles obtenidos del repositorio
		Perfil perfil1 = new Perfil();
		perfil1.setId(2);
		Perfil perfil2 = new Perfil();
		perfil2.setId(3);
		// Crear el conjunto de perfiles y asignarlo
		Set<Perfil> perfilesUsuario = new HashSet<>();
		perfilesUsuario.add(perfil1);
		perfilesUsuario.add(perfil2);
		nuevoUsuario.setPerfiles(perfilesUsuario);
		usuarioRepo.save(nuevoUsuario);
	}

	public void buscarUsuario() {
		Optional<Usuario> usuarioOptional = usuarioRepo.findById(1);
		if (usuarioOptional.isPresent()) {
			Usuario usuario = usuarioOptional.get();
			System.out.println("Nombre: " + usuario.getNombre());
			System.out.println("Perfiles asignados");
			for (Perfil perfil : usuario.getPerfiles()) {
				System.out.println(perfil.getPerfil());
			}
		}
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