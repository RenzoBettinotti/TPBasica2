package ar.edu.unlam.interfaz;

import java.time.*;
import ar.edu.unlam.interfaz.DuracionCiclo;

public class CicloLectivo {

	private Integer ID;
	private LocalDate fechaInicioCicloLectivo;
	private LocalDate hoy;
	private LocalDate fechaFinalizacionCicloLectivo;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinalizacionInscripcion;
	private DuracionCiclo duracion;

	public CicloLectivo(Integer id, LocalDate inicioI, LocalDate hoy) {

		this.hoy = hoy;
		this.ID = id;
		this.fechaInicioInscripcion = inicioI;
		this.fechaFinalizacionInscripcion = inicioI.plusWeeks(1);

	}

	public Boolean FinalInscripcion() {
		Boolean estado = false;
		if (this.hoy.equals(fechaFinalizacionCicloLectivo)) {
			estado = true;
		} else {
			estado = false;
		}
		return estado;
	}

	public void inicioCursada(LocalDate inicio, DuracionCiclo duracion) {
		this.fechaInicioCicloLectivo = inicio;
		this.fechaFinalizacionCicloLectivo = this.fechaInicioCicloLectivo.plusMonths(3);
		this.duracion = duracion;

	}

	public Boolean finalCursada() {
		Boolean estado = false;

		if (this.hoy.equals(fechaFinalizacionCicloLectivo)) {
			estado = true;
		} else {
			estado = false;
		}

		return null;

	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public LocalDate getFechaInicioCicloLectivo() {
		return fechaInicioCicloLectivo;
	}

	public void setFechaInicioCicloLectivo(LocalDate fechaInicioCicloLectivo) {
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
	}

	public LocalDate getHoy() {
		return hoy;
	}

	public void setHoy(LocalDate hoy) {
		this.hoy = hoy;
	}

	public LocalDate getFechaFinalizacionCicloLectivo() {
		return fechaFinalizacionCicloLectivo;
	}

	public void setFechaFinalizacionCicloLectivo(LocalDate fechaFinalizacionCicloLectivo) {
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
	}

	public LocalDate getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}

	public void setFechaInicioInscripcion(LocalDate fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}

	public LocalDate getFechaFinalizacionInscripcion() {
		return fechaFinalizacionInscripcion;
	}

	public void setFechaFinalizacionInscripcion(LocalDate fechaFinalizacionInscripcion) {
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
	}

	public DuracionCiclo getDuracion() {
		return duracion;
	}

	public void setDuracion(DuracionCiclo duracion) {
		this.duracion = duracion;
	}

}
