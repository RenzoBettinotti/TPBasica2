package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class Materia {

	private String nombre;
	private Integer id;
	private ArrayList<Materia> correlativas;
	private Estado estado;
	private Nota nota;
	private final Integer INTENTOS_RECUPERATORIO_MAX = 1;
	private Integer intentosRecuperatorioActuales;

	public Materia() {

	}

	public Materia(String nombre, Integer id) {
		this.nombre = nombre;
		this.id = id;
		this.estado = Estado.PENDIENTE;
		correlativas = new ArrayList<>();
		this.intentosRecuperatorioActuales = 0;
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

	public Integer verificarEstado(Integer nota) {
		Integer resultado = 0;
		for (int i = 0; i < correlativas.size(); i++) {
			if (correlativas.get(i).getEstado().equals(Estado.DESAPROBADO) && nota >= 7) {
				resultado = 6;
			} else {
				resultado = nota;
			}
		}
		return resultado;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Integer rendirRecuperatorio() {
		Integer resultado = null;

		if (this.intentosRecuperatorioActuales >= this.INTENTOS_RECUPERATORIO_MAX) {
			resultado = null;
		} else {
			resultado = 5;
			this.intentosRecuperatorioActuales++;

		}

		return resultado;

	}

	public void cargarNotaFinal(Integer nota) {

		if (this.nota.getEstadoPrimerParcial().equals(Estado.APROBADO)
				|| this.nota.getEstadoPrimerParcial().equals(Estado.PROMOCIONADO)
						&& this.nota.getEstadoSegundoParcial().equals(Estado.APROBADO)
				|| this.nota.getEstadoSegundoParcial().equals(Estado.PROMOCIONADO)) {
			this.nota.asignarNotaFinal(nota);
		}

	}

}
