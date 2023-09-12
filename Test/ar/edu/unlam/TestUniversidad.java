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
		Universidad facu = new Universidad(nombreUni);
		facu.agregarAlumno(alumno);
	
		//validacion
		 
		
		
		
	
		
		
//		@Test
//		public void queNoSePuedaRegistrarUnAlumnoYaRegistrado() {
//			//preparacion 
//			Integer dni = 45318159;
//			String nombre = "Renzo";
//			String apellido = "Bettinotti";
//			Integer dni2 = 12345678;
//			String nombre2 = "Julio";
//			String apellido2 = "Miranda";
//			
//			// ejecucion
//			Alumno alumno = new Alumno(dni, nombre, apellido);
//			Alumno alumno2 = new Alumno(dni2, nombre2, apellido2);
//			facu.agregarAlumno(alumno);
//			facu.revisarArray(alumno);
//			
//		}

	}

}
