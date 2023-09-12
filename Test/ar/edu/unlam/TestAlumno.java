package ar.edu.unlam;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.interfaz.Alumno;

public class TestAlumno {

	@Test
	public void queSePuedaCrearUnAlumno() {
		
		// preparacion
		
		Integer dni = 45318159;
		String nombre = "Renzo";
		String apellido = "Bettinotti";
		
		// ejecucion 
		
		Alumno alumno = new Alumno(dni, nombre, apellido);
		
		
		// verificacion
		
		assertNotNull(alumno);
		
		
	}

}
