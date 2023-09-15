package ar.edu.unlam.interfaz;

import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnos = new ArrayList<Alumno>(10);
	private Alumno alumno;

	public Universidad(String nombre) {
		this.nombre = nombre;

	}

	public Boolean agregarUnAlumno(Alumno alumno) {
		Boolean estado = false;
		this.alumnos.add(alumno);
		buscarAlumno(alumno);
		if (buscarAlumno(alumno).equals(true)) {
			estado = true;;
			alumno.setFechaIngreso("14/9/2023");
		}
		return estado;
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

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Boolean buscarAlumno(Alumno alumno) {
		Boolean resultado = false;
		for (int i = 0; i < alumnos.size(); i++) {
			alumnos.get(i).equals(alumno.getDni());
			resultado = true;
			
		}
		return resultado;
	}

}
