package ar.edu.unlam.interfaz;

import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnos;
	private Alumno alumno;

	public Universidad(String nombre) {
		this.nombre = nombre;

	}

	public void agregarAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
//		if (!this.alumnos.contains(alumno)) {
//			
//		}
	}

	public Boolean revisarArray(Alumno alumno) {
		Boolean estado = false;
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getNombre().equals(alumno.getNombre())) {
				estado = false;
			}
		}

		return estado;

	}

//	public Alumno getAlumno(Alumno alumno) {
//
//		for (int i = 0; i < alumnos.size(); i++) {
//			alumnos.get(i).|
//		}
//		return null;
//	}

}
