package ar.edu.unlam.interfaz;

import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	private ArrayList<Docente> docentes = new ArrayList<Docente>();
	private Alumno alumno;

	public Universidad(String nombre) {
		this.nombre = nombre;

	}

	public Boolean agregarUnAlumno(Alumno alumno) {
		Boolean estado = false;
		this.alumnos.add(alumno);
		buscarAlumno(alumno);
		if (buscarAlumno(alumno).equals(alumno)) {
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

	public Alumno buscarAlumno(Alumno alumno) {
		Alumno resultado = null;
		for (int i = 0; i < alumnos.size(); i++) {
			alumnos.get(i).equals(alumno.getDni());
			resultado = alumnos.get(i);
			
		}
		return resultado;
	}
	
	public Boolean agregarDocentes(Docente docente, Docente docente2) {
		Boolean estado = false;
		this.docentes.add(docente);
		estado = true;
		if(this.docentes.equals(docente2)) {
			estado = false;
		}
		
		return estado;
	}

}
