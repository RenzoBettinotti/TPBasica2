package ar.edu.unlam.interfaz;

public class Aula {

	private Integer numero;
	private final Integer CANTIDAD_MAXIMA_ALUMNOS = 20;
	private  Integer cantidadDeAlumnosActuales;
	
	
	public Aula (Integer numero) {
		this.numero = numero;
		this.cantidadDeAlumnosActuales = 0;
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
			cantidadDeAlumnosActuales ++;
			estado = true;
		}
		if (estaLleno() == true) {
			estado = false;
		}
		
		
		
		return estado;
		
	}
	
	public Boolean estaLleno () {
		Boolean lleno = false;
		if (this.CANTIDAD_MAXIMA_ALUMNOS == this.cantidadDeAlumnosActuales) {
			lleno = true;
		}
		return lleno; 
	}
	
	
	
}
