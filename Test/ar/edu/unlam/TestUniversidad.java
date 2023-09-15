package ar.edu.unlam;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.interfaz.Alumno;
import ar.edu.unlam.interfaz.Universidad;

public class TestUniversidad {

	@Test
	public void queSePuedaRegistrarUnAlumno() {

		// preparacion

		Integer dni = 45318159;
		String nombre = "Renzo";
		String apellido = "Bettinotti";
		String nombreUni = "UNLAM";
		String fechaNacimiento = "16/03/2004";
		
		

		// ejecucion

		Alumno alumno = new Alumno(dni, nombre, apellido, fechaNacimiento);
		Universidad facu = new Universidad(nombreUni);
		facu.agregarUnAlumno(alumno);
		String ve = "Renzo";
		String vo = alumno.getNombre();
		String ve2 = "14/9/2023";
		String vo2 = alumno.getFechaIngreso();
	
		//validacion
		 assertEquals(ve, vo);
		 assertEquals (ve2, vo2);
	}
	
	@Test
	public void queNoSePuedaAgregarUnAlumnoYaRegistrado() {
		Integer dni = 45318159;
		String nombre = "Renzo";
		String apellido = "Bettinotti";
		String fechaNacimiento = "16/03/2004";
		Integer dni2 = 12345678;
		String nombre2 = "Julio";
		String apellido2 = "Miranda";
		String fechaNacimiento2 = "16/03/2003";
		String nombreUni = "UNLAM";
		Boolean estado;
		
		// ejecucion
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaNacimiento);
		Alumno alumno2 = new Alumno(dni2, nombre2, apellido2, fechaNacimiento2);
		Universidad facu = new Universidad(nombreUni);
		facu.agregarUnAlumno(alumno);
		estado = facu.revisarArray(alumno);
		
		// validacion 
		
		assertFalse(estado);
	}

}
