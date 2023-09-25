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
import ar.edu.unlam.interfaz.Estado;
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

		String nombreD = "Pablo";
		String apellidoD = "Manolo";
		Integer dniD = 44444444;
		Docente profe1 = new Docente(nombreD, apellidoD, dniD);

		String nombreD2 = "Juan";
		String apellidoD2 = "Carlos";
		Integer dniD2 = 44444445;
		Docente profe2 = new Docente(nombreD2, apellidoD2, dniD2);

		aula.agregarUnDocente(profe1, profe2);

	}

	@Test
	public void queSePuedaCrearUnaComision() {

		// preparacion

		Boolean estado = false;

		// AULA

		Integer numero = 271;
		Aula aula = new Aula(numero);

		// ALUMNO

		Integer dni = 45318159;
		String nombre = "Renzo";
		String apellido = "Bettinotti";

		String fechaNacimiento = "16/03/2004";
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaNacimiento);

		// DOCENTE

		String nombreD = "Pablo";
		String apellidoD = "Manolo";
		Integer dniD = 44444444;
		Docente profe1 = new Docente(nombreD, apellidoD, dniD);

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

		// MATERIA

		String nombre2 = "Programacion Basica 2";
		Integer id = 014;
		Materia pb2 = new Materia(nombre2, id);

		// COMISION

		Integer codigo = 4421;
		Comision comision = new Comision(codigo, pb2, turno, aula);

		comision.asignarCiclo(duracion);
		estado = comision.revisarCiclo(duracion, duracion2);
		comision.asignarMateria(pb2);

		comision.asignarTurno(turno);
		comision.agregarUnAlumno(alumno);

		comision.agregarUnDocente(profe1);

		assertNotNull(comision);
		assertTrue(estado);

	}

	@Test
	public void queNoSePuedaAgregarUnMismoAlumnoAUnaComision() {

		Boolean estado = false;

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

		// AULA

		Integer numero = 271;
		Aula aula = new Aula(numero);

		// DOCENTE

		String nombreD = "Pablo";
		String apellidoD = "Manolo";
		Integer dniD = 44444444;
		Docente profe1 = new Docente(nombreD, apellidoD, dniD);

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

		// MATERIA

		String nombre2 = "Programacion Basica 2";
		Integer id = 014;
		Materia pb2 = new Materia(nombre2, id);

		// COMISION

		Integer codigo = 4421;
		Comision comision = new Comision(codigo, pb2, turno, aula);

		comision.agregarUnAlumno(alumno);
		estado = comision.revisarAlumno(alumno, alumno2);

		assertTrue(estado);
	}

	public void queNoSePuedaAgregarUnMismoDocenteAUnaComision() {

		Boolean estado = false;
		// AULA

		Integer numero = 271;
		Aula aula = new Aula(numero);

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

		// MATERIA

		String nombre2 = "Programacion Basica 2";
		Integer id = 014;
		Materia pb2 = new Materia(nombre2, id);

		// COMISION

		Integer codigo = 4421;
		Comision comision = new Comision(codigo, pb2, turno, aula);

		comision.agregarUnDocente(profe1);
		estado = comision.revisarDocente(profe1, profe2);

		assertTrue(estado);

	}

	@Test
	public void queNoSePuedaAgregarUnMismoCicloAUnaComision() {
		Boolean estado = false;
		// AULA

		Integer numero = 271;
		Aula aula = new Aula(numero);

		// DOCENTE

		String nombreD = "Pablo";
		String apellidoD = "Manolo";
		Integer dniD = 44444444;
		Docente profe1 = new Docente(nombreD, apellidoD, dniD);

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

		// COMISION

		Integer codigo = 4421;
		Comision comision = new Comision(codigo, pb2, turno, aula);

		comision.asignarTurno(turno);
		estado = comision.revisarTurno(turno, turno2);

		assertTrue(estado);
	}

	@Test
	public void queNoSePuedaAgregarUnaMismaMateriaAUnaComision() {
		Boolean estado = false;
		// AULA

		Integer numero = 271;
		Aula aula = new Aula(numero);

		// DOCENTE

		String nombreD = "Pablo";
		String apellidoD = "Manolo";
		Integer dniD = 44444444;
		Docente profe1 = new Docente(nombreD, apellidoD, dniD);

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

		// MATERIA

		String nombre2 = "Programacion Basica 2";
		Integer id = 014;
		Materia pb2 = new Materia(nombre2, id);

		String nombre3 = "Programacion Basica 1";
		Integer id2 = 015;
		Materia pb1 = new Materia(nombre3, id2);

//		// FACULTAD

		String nombreUni = "UNLAM";
		Universidad facu = new Universidad(nombreUni);
		facu.agregarMaterias(pb2);
		pb2.agregarCorrelativa(pb1);

		// COMISION

		Integer codigo = 4421;
		Comision comision = new Comision(codigo, pb2, turno, aula);

		comision.asignarMateria(pb2);
		estado = comision.revisarMateria(pb2, pb1);

		assertTrue(estado);

	}

	// Notas

	@Test
	public void queSePuedaRegistrarNotasDeUnAlumno() {

		Boolean estado = false;
		Boolean estado2 = false;
		Boolean estadoFinal = false;

		// AULA

		Integer numero = 271;
		Aula aula = new Aula(numero);

		// MATERIA

		String nombre = "Programacion Basica 2";
		Integer id = 014;
		Materia pb2 = new Materia(nombre, id);

		String nombre2 = "Programacion Basica 1";
		Integer id2 = 013;
		Materia pb1 = new Materia(nombre2, id2);

		pb1.setEstado(Estado.DESAPROBADO);
		pb2.agregarCorrelativa(pb1);

		// COMISION
		Hora hora = Hora.DE_8_A_12;
		Dia dia = Dia.LUNES_Y_MIERCOLES;

		Turno turno = new Turno(hora, dia);

		Integer codigo = 4421;
		Comision comision = new Comision(codigo, pb2, turno, aula);

		// ALUMNO

		Integer dni = 45318159;
		String nombreAlumno = "Renzo";
		String apellido = "Bettinotti";

		String fechaNacimiento = "16/03/2004";
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido, fechaNacimiento);

		// NOTA

		Integer nota1 = 3;
		Integer nota2 = 7;
		Integer notaFinal = 5;
		Nota notaAlumno = new Nota();
		nota1 = pb2.verificarEstado(nota1);
		estado = notaAlumno.verificarNota(nota1);
		notaAlumno.asignarNotaPrimerParcial(nota1);

		nota1 = pb2.rendirRecuperatorio();
		notaAlumno.asignarNotaPrimerParcial(nota1);

		nota2 = pb2.verificarEstado(nota2);
		estado2 = notaAlumno.verificarNota(nota2);
		notaAlumno.asignarNotaSegundoParcial(nota2);

		estadoFinal = notaAlumno.asignarNotaFinal(notaFinal);

		assertTrue(estado);
		assertTrue(estado2);
		assertTrue(estadoFinal);
	}

}
