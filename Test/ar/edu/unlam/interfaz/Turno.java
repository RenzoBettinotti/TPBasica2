package ar.edu.unlam.interfaz;

import ar.edu.unlam.interfaz.Hora;
import ar.edu.unlam.interfaz.Dia;

public class Turno {

	private Hora hora;
	private Dia dia;

	public Turno(Hora hora, Dia dia) {
		this.dia = dia;
		this.hora = hora;
	}

	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

}
