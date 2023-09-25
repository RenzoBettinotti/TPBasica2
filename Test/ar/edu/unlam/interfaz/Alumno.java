package ar.edu.unlam.interfaz;

import java.time.*;
import java.util.ArrayList;

public class Alumno {

	private Integer dni;
	private String nombre;
	private String apellido;
	private String fechaDeNacimiento;
	private LocalDate fechaIngreso;
	private ArrayList<Materia> materiasAprobadas;
	private ArrayList<Materia> materiasPendientes;
	private Materia materia;

	public Alumno() {

	}

	public Alumno(Integer dni, String nombre, String apellido, String fechaNacimiento) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.setFechaDeNacimiento(fechaNacimiento);
		materiasAprobadas = new ArrayList<Materia>();
		materiasPendientes = new ArrayList<Materia>();

	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void añadirMateriaAprobada(Materia materia) {
		if (this.materia.getEstado().equals(Estado.APROBADO) || this.materia.getEstado().equals(Estado.PROMOCIONADO)) {
			this.materiasAprobadas.add(materia);
		}
	}

	public void añadirMateriaPendiente(Materia materia) {
		if (this.materia.getEstado().equals(Estado.PENDIENTE)) {
			this.materiasPendientes.add(materia);
		}
	}

	public ArrayList<Materia> getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public void setMateriasAprobadas(ArrayList<Materia> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Integer obtenerPromedio(Materia materia) {
		Integer nota1 = 0;
		Integer nota2 = 0;
		Integer promedio = 0;
		nota1 = materia.getNota().getPrimerParcial();
		nota2 = materia.getNota().getSegundoParcial();

		promedio = (nota1 + nota2) / 2;

		return promedio;
	}

	public ArrayList<Materia> getMateriasPendientes() {
		return materiasPendientes;
	}

	public void setMateriasPendientes(ArrayList<Materia> materiasPendientes) {
		this.materiasPendientes = materiasPendientes;
	}

}
