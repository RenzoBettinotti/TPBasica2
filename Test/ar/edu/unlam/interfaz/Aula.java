package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class Aula {

	private Integer numero;
	private final Integer CANTIDAD_MAXIMA_ALUMNOS = 40;
	private Integer cantidadDeAlumnosActuales;
	private ArrayList<Docente> docentes;

	public Aula(Integer numero) {
		this.numero = numero;
		this.cantidadDeAlumnosActuales = 0;
		docentes = new ArrayList<Docente>();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCantidadDeAlumnosActuales() {
		return cantidadDeAlumnosActuales;
	}

	public void setCantidadDeAlumnosActuales(Integer cantidadDeAlumnosActuales) {
		this.cantidadDeAlumnosActuales = cantidadDeAlumnosActuales;
	}

	public Integer getCANTIDAD_MAXIMA_ALUMNOS() {
		return CANTIDAD_MAXIMA_ALUMNOS;
	}

	public Boolean agregarAlumno(Alumno alumno) {
		Boolean estado = false;
		if (this.CANTIDAD_MAXIMA_ALUMNOS < this.cantidadDeAlumnosActuales) {
			cantidadDeAlumnosActuales++;
			estado = true;
		}
		if (estaLleno() == true) {
			estado = false;
		}

		return estado;

	}

	public Boolean estaLleno() {
		Boolean lleno = false;
		if (this.CANTIDAD_MAXIMA_ALUMNOS == this.cantidadDeAlumnosActuales) {
			lleno = true;
		} else {
			lleno = false;
		}
		return lleno;
	}

	public void agregarUnDocente(Docente docente, Docente docenteExtra1) {
		if (this.cantidadDeAlumnosActuales.equals(20)) {
			this.docentes.add(docente);
		} else if (this.cantidadDeAlumnosActuales.equals(40)) {
			this.docentes.add(docenteExtra1);
		}

	}

}
