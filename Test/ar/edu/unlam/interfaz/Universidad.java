package ar.edu.unlam.interfaz;

import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnos;

	public Universidad(String nombre) {
		this.nombre = nombre;

	}
	
	public Boolean registrarAlumno(Alumno alumno) {
		
		for (int i = 0; i < alumnos.length(); i++) {
			if (alumnos[i].getNombre() = alumno.getNombre) {}
		}
	}

}
