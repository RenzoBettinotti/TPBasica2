package ar.edu.unlam;

import static org.junit.Assert.*;

import org.junit.Test;
import java.time.*;

import ar.edu.unlam.interfaz.Alumno;
import ar.edu.unlam.interfaz.Aula;
import ar.edu.unlam.interfaz.Docente;
import ar.edu.unlam.interfaz.Materia;
import ar.edu.unlam.interfaz.Nota;
import ar.edu.unlam.interfaz.Turno;
import ar.edu.unlam.interfaz.Universidad;
import ar.edu.unlam.interfaz.CicloLectivo;
import ar.edu.unlam.interfaz.Comision;
import ar.edu.unlam.interfaz.DuracionCiclo;
import ar.edu.unlam.interfaz.Dia;
import ar.edu.unlam.interfaz.Hora;

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

		String nombre = "Programacion Basica 2";
		Integer id = 014;
		Materia pb2 = new Materia(nombre, id);

		String nombreC = "Programacion basica 1";
		Integer idC = 013;
		Materia pb1 = new Materia(nombreC, idC);

		Boolean estado = false;
		Boolean estadoM = false;

		Integer ve = 013;
		Integer vo = 0;

		// ejecucion
		facu.agregarMaterias(pb2);
		estado = pb2.agregarCorrelativa(pb1);
		estadoM = facu.verificacionMateria(idC, pb2);
		vo = pb2.getCorrelativa();

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

		Boolean estado = false;
		Boolean estado2 = false;
		Boolean estado3 = false;
		Boolean estado4 = false;
		Boolean estado5 = false;
		Boolean estado6 = false;

		// ALUMNO

		Integer dni = 45318159;
		String nombre = "Renzo";
		String apellido = "Bettinotti";

		String fechaNacimiento = "16/03/2004";
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaNacimiento);

		Integer dni2 = 1111111;
		String nombreA = "Julio";
		String apellidoA = "Miranda";

		String fechaNacimiento2 = "15/03/2004";
		Alumno alumno2 = new Alumno(dni2, nombreA, apellidoA, fechaNacimiento2);

		// DOCENTE

		String nombreD = "Pablo";
		String apellidoD = "Manolo";
		Integer dniD = 44444444;
		Docente profe1 = new Docente(nombreD, apellidoD, dniD);

		String nombreD2 = "Juan";
		String apellidoD2 = "Carlos";
		Integer dniD2 = 44444445;
		Docente profe2 = new Docente(nombreD2, apellidoD2, dniD2);

		// CICLO Y TURNO

		Integer ID = 12;
		LocalDate inscripcion = LocalDate.of(2023, 9, 23);
		LocalDate hoy = LocalDate.now();
		CicloLectivo duracion = new CicloLectivo(ID, inscripcion, hoy);

		Integer ID2 = 13;
		CicloLectivo duracion2 = new CicloLectivo(ID2, inscripcion, hoy);

		Hora hora = Hora.DE_8_A_12;
		Dia dia = Dia.LUNES_Y_MIERCOLES;

		Turno turno = new Turno(hora, dia);

		Hora hora2 = Hora.DE_12_A_2;
		Dia dia2 = Dia.MARTES_Y_VIERNES;

		Turno turno2 = new Turno(hora2, dia2);

		// MATERIA

		String nombre2 = "Programacion Basica 2";
		Integer id = 014;
		Materia pb2 = new Materia(nombre2, id);

		String nombre3 = "Programacion Basica 1";
		Integer id2 = 015;
		Materia pb1 = new Materia(nombre3, id2);

		// FACULTAD

		String nombreUni = "UNLAM";
		Universidad facu = new Universidad(nombreUni);
		facu.agregarUnAlumno(alumno);
		facu.agregarMaterias(pb2);
		estado6 = pb2.agregarCorrelativa(pb1);

		// COMISION

		Integer codigo = 4421;
		Comision comision = new Comision(codigo, pb2, turno);

		comision.asignarCiclo(duracion);
		estado = comision.revisarCiclo(duracion, duracion2);
		comision.asignarMateria(pb2);
		estado2 = comision.revisarMateria(pb2, pb1);
		comision.asignarTurno(turno);
		estado3 = comision.revisarTurno(turno, turno2);
		comision.agregarUnAlumno(alumno);
		estado4 = comision.revisarAlumno(alumno, alumno2);
		comision.agregarUnDocente(profe1);
		estado5 = comision.revisarDocente(profe1, profe2);

		assertNotNull(comision);
		assertTrue(estado);
		assertTrue(estado2);
		assertTrue(estado3);
		assertTrue(estado4);
		assertTrue(estado5);
		assertTrue(estado6);

	}

	// Notas

	@Test
	public void queSePuedaRegistrarNotasDeUnAlumno() {

		// COMISION

		String nombre2 = "Programacion Basica 2";
		Integer id = 014;
		Materia pb2 = new Materia(nombre2, id);

		Hora hora = Hora.DE_8_A_12;
		Dia dia = Dia.LUNES_Y_MIERCOLES;

		Turno turno = new Turno(hora, dia);

		Integer codigo = 4421;
		Comision comision = new Comision(codigo, pb2, turno);

		// ALUMNO

		Integer dni = 45318159;
		String nombre = "Renzo";
		String apellido = "Bettinotti";

		String fechaNacimiento = "16/03/2004";
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaNacimiento);

		// NOTA

		Integer nota = 6;
		Nota notaAlumno = new Nota(nota);

	}

}
