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

	// Alumno

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
		estado = facu.revisarArray(alumno, alumno2);
//		estado2 = facu.revisarArray(alumno2);

		LocalDate ve = LocalDate.now();
		LocalDate vo = alumno.getFechaIngreso();
		LocalDate vo2 = alumno2.getFechaIngreso();

		// validacion
		assertEquals(ve, vo);
		assertEquals(ve, vo2);
		assertTrue(estado);

	}

	// Materia
	@Test
	public void queSePuedaCrearUnaMateriaConSusCorrelativas() {

		// preparacion
		String nombreUni = "UNLAM";
		Universidad facu = new Universidad(nombreUni);

		String nombre = "Programacion Basica 1";
		Integer id = 014;
		Materia pb1 = new Materia(nombre, id);

		String nombreC = "Programacion basica 2";
		Integer idC = 013;
		Materia pb2 = new Materia(nombreC, idC);

		Boolean estado = false;
		Boolean estadoM = false;

		Integer ve = 013;
		Integer vo = 0;

		// ejecucion
		facu.agregarMaterias(pb1);
		estado = pb1.agregarCorrelativa(pb2);
		estadoM = facu.verificacionMateria(idC, pb2);
		vo = pb1.getCorrelativa();

		// validacion

		assertTrue(estado);
		assertTrue(estadoM);
		assertEquals(ve, vo);

	}

	@Test
	public void queSePuedaEliminarUnaCorrelativa() {
		String nombreUni = "UNLAM";
		Universidad facu = new Universidad(nombreUni);

		String nombre = "Programacion Basica 1";
		Integer id = 014;
		Materia pb1 = new Materia(nombre, id);

		String nombreC = "Programacion basica 2";
		Integer idC = 015;
		Materia pb2 = new Materia(nombreC, idC);

		Boolean estado1 = false;
		Boolean estado2 = false;
		Boolean estado3 = false;

		facu.agregarMaterias(pb1);
		estado1 = pb1.agregarCorrelativa(pb2);
		estado2 = facu.verificacionMateria(idC, pb2);
		estado3 = pb1.eliminarCorrelativa(idC);

		assertTrue(estado1);
		assertTrue(estado2);
		assertTrue(estado3);
	}
	// Docente

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

	// Comision

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

}
