package ar.edu.unlam.interfaz;

public class Nota {

	private Integer nota;
	private TipoNota tipo;
	private Integer primerParcial;
	private Integer segundoParcial;
	private Integer notaFinal;
	private Integer notaRecu;
	private Estado estadoPrimerParcial;
	private Estado estadoSegundoParcial;

	public Nota() {

	}

	public Boolean verificarNota(Integer nota) {
		Boolean resultado = false;
		if (nota > 1 && nota < 10) {
			resultado = true;
		}

		return resultado;
	}

	public void asignarNotaPrimerParcial(Integer nota) {
		this.primerParcial = nota;
		if (nota < 4) {
			this.estadoPrimerParcial = Estado.DESAPROBADO;
		} else if (nota >= 4 && nota < 7) {
			this.estadoPrimerParcial = Estado.APROBADO;
		} else if (nota >= 7) {
			this.estadoPrimerParcial = Estado.PROMOCIONADO;
		}
	}

	public void asignarNotaSegundoParcial(Integer nota) {
		this.segundoParcial = nota;
		if (nota < 4) {
			this.estadoSegundoParcial = Estado.DESAPROBADO;
		} else if (nota >= 4 && nota < 7) {
			this.estadoSegundoParcial = Estado.APROBADO;
		} else if (nota >= 7) {
			this.estadoSegundoParcial = Estado.PROMOCIONADO;
		}
	}

	public Boolean asignarNotaFinal(Integer nota) {
		Boolean resultado = false;

		if (this.estadoPrimerParcial.equals(Estado.APROBADO) && this.estadoSegundoParcial.equals(Estado.APROBADO)
				|| this.estadoPrimerParcial.equals(Estado.PROMOCIONADO)
						&& this.estadoSegundoParcial.equals(Estado.PROMOCIONADO)) {

			this.notaFinal = nota;
			resultado = true;

		} else if (this.estadoPrimerParcial.equals(Estado.APROBADO)
				&& this.estadoSegundoParcial.equals(Estado.PROMOCIONADO)
				|| this.estadoPrimerParcial.equals(Estado.PROMOCIONADO)
						&& this.estadoSegundoParcial.equals(Estado.APROBADO)) {
			this.notaFinal = nota;
			resultado = true;
		}
		return resultado;
	}

	public Integer notaRecuperatorio(Integer nota) {
		this.notaRecu = nota;
		return this.notaRecu;
	}

	public void asignarTipo(TipoNota tipo) {
		this.tipo = tipo;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public TipoNota getTipo() {
		return tipo;
	}

	public void setTipo(TipoNota tipo) {
		this.tipo = tipo;
	}

	public Integer getPrimerParcial() {
		return primerParcial;
	}

	public void setPrimerParcial(Integer primerParcial) {
		this.primerParcial = primerParcial;
	}

	public Integer getSegundoParcial() {
		return segundoParcial;
	}

	public void setSegundoParcial(Integer segundoParcial) {
		this.segundoParcial = segundoParcial;
	}

	public Integer getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(Integer notaFinal) {
		this.notaFinal = notaFinal;
	}

	public Integer getNotaRecu() {
		return notaRecu;
	}

	public void setNotaRecu(Integer notaRecu) {
		this.notaRecu = notaRecu;
	}

	public Estado getEstadoPrimerParcial() {
		return estadoPrimerParcial;
	}

	public void setEstadoPrimerParcial(Estado estadoPrimerParcial) {
		this.estadoPrimerParcial = estadoPrimerParcial;
	}

	public Estado getEstadoSegundoParcial() {
		return estadoSegundoParcial;
	}

	public void setEstadoSegundoParcial(Estado estadoSegundoParcial) {
		this.estadoSegundoParcial = estadoSegundoParcial;
	}

}
