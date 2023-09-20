package ar.edu.unlam.interfaz;

import java.time.*;
import ar.edu.unlam.interfaz.DuracionCiclo;


public class CicloLectivo {

	private Integer ID;
	private LocalDate fechaInicioCicloLectivo;
	private LocalDate fechaFinalizacionCicloLectivo;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinalizacionInscripcion;
	private DuracionCiclo duracion;
	
	
	public CicloLectivo(Integer id, LocalDate inicioI, LocalDate finalI ) {
		
		this.ID = id;
		this.fechaInicioInscripcion = inicioI;
		this.fechaFinalizacionInscripcion = finalI;
		
		this.fechaInicioInscripcion = LocalDate.of(2023,ahora , 20);
		
		
	}
	
	public void FinalInscripcion() {
		if(this.fechaFinalizacionInscripcion )
	}
	
	
	
}
