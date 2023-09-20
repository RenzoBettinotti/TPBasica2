package ar.edu.unlam;

import static org.junit.Assert.*;

import org.junit.Test;
import java.time.*;

import ar.edu.unlam.interfaz.Alumno;
import ar.edu.unlam.interfaz.Aula;
import ar.edu.unlam.interfaz.Docente;
import ar.edu.unlam.interfaz.Materia;
import ar.edu.unlam.interfaz.Universidad;

public class TestUniversidad {

	@Test
	public void queSePuedaRegistrarUnAlumno() {

		// preparacion
		Integer dni = 45318159;
		String nombre = "Renzo";
		String apellido = "Bettinotti";

		String fechaNacimiento = "16/03/2004";
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaNacimiento);

		String nombreUni = "UNLAM";
		Universidad facu = new Universidad(nombreUni);

		// ejecucion

		facu.agregarUnAlumno(alumno);
		String ve = "Renzo";
		String vo = alumno.getNombre();
		LocalDate ve2 = LocalDate.now();
		LocalDate vo2 = alumno.getFechaIngreso();

		// validacion
		assertEquals(ve, vo);
		assertEquals(ve2, vo2);
	}

	@Test
	public void queNoSePuedaAgregarUnAlumnoYaRegistrado() {

		// preparacion
		Integer dni = 45318159;
		String nombre = "Renzo";
		String apellido = "Bettinotti";
		String fechaNacimiento = "16/03/2004";
		Integer dni2 = 12345678;
		String nombre2 = "Julio";
		String apellido2 = "Miranda";
		String fechaNacimiento2 = "16/03/2003";

		Alumno alumno = new Alumno(dni, nombre, apellido, fechaNacimiento);
		Alumno alumno2 = new Alumno(dni2, nombre2, apellido2, fechaNacimiento2);

		String nombreUni = "UNLAM";
		Universidad facu = new Universidad(nombreUni);
		Boolean estado;
		Boolean estado2;

		// ejecucion

		facu.agregarUnAlumno(alumno);
		facu.agregarUnAlumno(alumno);
		estado = facu.revisarArray(alumno);
//		estado2 = facu.revisarArray(alumno2);
		 
		LocalDate ve = LocalDate.now();
		LocalDate vo = alumno.getFechaIngreso();
		LocalDate vo2 = alumno2.getFechaIngreso();

		// validacion
		assertEquals(ve, vo);
//		assertEquals(ve, vo2);
		assertTrue(estado);
//		assertTrue(estado2);
	}

	@Test
	public void queSePuedaCrearUnaMateriaConSusCorrelativas() {

		// preparacion
		String nombreUni = "UNLAM";
		Universidad facu = new Universidad(nombreUni);

		String nombre = "Programacion Basica 1";
		Integer id = 014;
		Materia pb1 = new Materia(nombre, id);

		String nombreC = "Programacion basica 2";
		Integer idC = 015;
		Materia pb2 = new Materia(nombreC, idC);

		Boolean estado = false;

		// ejecucion
		estado = pb1.agregarCorrelativa(pb2);

		// validacion

		assertTrue(estado);
	}

	@Test
	public void queSePuedanAgregarDocentes() {

		// preparacion

		String nombre = "Pablo";
		String apellido = "Manolo";
		Integer dni = 44444444;
		Docente profe1 = new Docente(nombre, apellido, dni);

		String nombre2 = "Juan";
		String apellido2 = "Carlos";
		Integer dni2 = 44444445;
		Docente profe2 = new Docente(nombre2, apellido2, dni2);

		String nombreUni = "UNLAM";
		Universidad facu = new Universidad(nombreUni);

		Boolean estado = false;

		// ejecucion

		estado = facu.agregarDocentes(profe1, profe2);

		// validacion
		assertTrue(estado);

	}
	
	
	@Test
	public void queSePuedaCrearUnaAula() {
		
		Integer numero = 271;
		Aula aula = new Aula(numero);
		
	}
	
	
	@Test 
	public void queSePuedaCrearUnaComision() {
		
		// preparacion
		
		Integer codigo = 4421;
		
		
	}

//	@Test 
//	public void queLosAlumnosSePuedanInscribirEnLasMaterias() {
//		
//		// preparacion
//		
//		
//	}

}
