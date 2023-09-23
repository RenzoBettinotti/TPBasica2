package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class Materia {

	private String nombre;
	private Integer id;
	private ArrayList<Materia> correlativas;

	public Materia() {

	}

	public Materia(String nombre, Integer id) {
		this.nombre = nombre;
		this.id = id;
		correlativas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(ArrayList<Materia> correlativas) {
		this.correlativas = correlativas;
	}

	public Boolean agregarCorrelativa(Materia correlativa) {
		Boolean estado = false;
		if (this.id != correlativa.getId()) {
			this.correlativas.add(correlativa);
			estado = true;
		}
		return estado;
	}

	public Integer getCorrelativa() {
		Integer correlativa = 0;
		for (int i = 0; i < correlativas.size(); i++) {
			correlativa = correlativas.get(i).getId();
		}

		return correlativa;

	}

	public Boolean eliminarCorrelativa(Integer idC) {
		boolean estado = false;
		for (int i = 0; i < correlativas.size(); i++) {
			if (correlativas.get(i).getId().equals(idC)) {
				this.correlativas.remove(i);
				estado = true;
				break;
			} else {
				estado = false;
			}
		}
		return estado;

	}

}
