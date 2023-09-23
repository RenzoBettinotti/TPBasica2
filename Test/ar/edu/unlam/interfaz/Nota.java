package ar.edu.unlam.interfaz;

public class Nota {

	private Integer nota;
	private TipoNota tipo;

	public Nota(Integer nota) {
		if (nota > 1 && nota < 10) {
			this.nota = nota;
		}
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

}
