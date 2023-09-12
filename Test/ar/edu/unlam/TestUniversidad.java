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

		// ejecucion

		Alumno alumno = new Alumno(dni, nombre, apellido);
		Universidad facu = new Universidad(nombre);
		Boolean estado = facu.registrarAlumno(alumno);
	
		//validacion
		 
		assertTrue(estado);
		assertNotNull(alumno);
		
		

	}

}
