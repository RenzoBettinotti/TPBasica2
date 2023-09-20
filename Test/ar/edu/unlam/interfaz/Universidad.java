package ar.edu.unlam.interfaz;

import java.util.ArrayList;
import java.util.Iterator;
import java.time.*;

public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	private ArrayList<Docente> docentes = new ArrayList<Docente>();
	private Alumno alumno;

	public Universidad(String nombre) {
		this.nombre = nombre;

	}

	public void agregarUnAlumno(Alumno alumno) {
		LocalDate ingreso = LocalDate.now();

		this.alumnos.add(alumno);

		alumno.setFechaIngreso(ingreso);

	}

	public Boolean revisarArray(Alumno alumno) {
		Boolean estado = false;
		String placeHolder= null;
		for (int i = 0; i < alumnos.size(); i++) {
			if ( alumnos.get(i).getNombre().equals(alumno.getNombre())) {
				estado = true;
				placeHolder = alumno.getNombre();
				if(placeHolder.equals(alumnos.get(i).getNombre())) {
					estado = false;
				}
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
		if (this.docentes.equals(docente2)) {
			estado = false;
		}

		return estado;
	}

}
