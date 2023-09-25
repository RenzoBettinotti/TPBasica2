package ar.edu.unlam.interfaz;

import java.time.LocalDate;
import java.util.ArrayList;

public class Comision {

	private Aula aula;
	private Integer id;
	private Materia materia;
//	private CicloLectivo duracion;
	private Turno turno;
	private ArrayList<CicloLectivo> ciclos;
	private ArrayList<Materia> materias;
	private ArrayList<Turno> turnos;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Docente> docentes;

	public Comision(Integer codigo, Materia pb1, Turno turno, Aula aula) {
		this.id = codigo;
		this.materia = pb1;
		this.turno = turno;
		this.aula = aula;
		ciclos = new ArrayList<CicloLectivo>();
		materias = new ArrayList<Materia>();
		turnos = new ArrayList<Turno>();
		alumnos = new ArrayList<Alumno>();
		docentes = new ArrayList<Docente>();
	}

	public Boolean revisarCiclo(CicloLectivo cicloV, CicloLectivo cicloN) {
		Boolean estado = false;
		if (buscarCiclo(cicloV).equals(cicloN.getID())) {
			estado = false;
		} else {
			asignarCiclo(cicloN);
			estado = true;

		}

		return estado;

	}

	public Integer buscarCiclo(CicloLectivo ciclo) {
		Integer resultado = 0;
		for (int i = 0; i < ciclos.size(); i++) {
			ciclos.get(i).equals(ciclo.getID());
			resultado = ciclos.get(i).getID();

		}
		return resultado;
	}

	public void asignarCiclo(CicloLectivo ciclo) {

		this.ciclos.add(ciclo);

	}

	public Boolean revisarMateria(Materia MateriaV, Materia MateriaN) {
		Boolean estado = false;
		if (buscarMateria(MateriaV).equals(MateriaN.getId())) {
			estado = false;
		} else {
			asignarMateria(MateriaN);
			estado = true;

		}

		return estado;

	}

	public Integer buscarMateria(Materia Materias) {
		Integer resultado = 0;
		for (int i = 0; i < materias.size(); i++) {
			materias.get(i).equals(Materias.getId());
			resultado = materias.get(i).getId();

		}
		return resultado;
	}

	public void asignarMateria(Materia Materias) {

		this.materias.add(Materias);

	}

	public Boolean revisarTurno(Turno turnoV, Turno turnoN) {
		Boolean estado = false;
		if (buscarHora(turnoV).equals(turnoN.getHora()) && buscarDia(turnoV).equals(turnoN.getDia())) {
			estado = false;
		} else {
			asignarTurno(turnoN);
			estado = true;

		}

		return estado;

	}

	public Hora buscarHora(Turno turno) {
		Hora resultado = null;
		for (int i = 0; i < turnos.size(); i++) {
			turnos.get(i).equals(turno.getHora());
			resultado = turnos.get(i).getHora();
			break;

		}
		return resultado;
	}

	public Dia buscarDia(Turno turno) {
		Dia resultado = null;
		for (int i = 0; i < turnos.size(); i++) {
			turnos.get(i).equals(turno.getDia());
			resultado = turnos.get(i).getDia();
			break;

		}
		return resultado;
	}

	public void asignarTurno(Turno turno) {

		this.turnos.add(turno);

	}

	public void agregarUnAlumno(Alumno alumno) {
		LocalDate ingreso = LocalDate.now();

		this.alumnos.add(alumno);
		alumno.setFechaIngreso(ingreso);

	}

	public Boolean revisarAlumno(Alumno alumnoR, Alumno alumnoN) {
		Boolean estado = false;
		LocalDate ingreso = LocalDate.now();
		if (buscarAlumno(alumnoR).equals(alumnoN.getDni())) {
			estado = false;
		} else {
			agregarUnAlumno(alumnoN);
			estado = true;
			alumnoN.setFechaIngreso(ingreso);
		}

		return estado;

	}

	public Integer buscarAlumno(Alumno alumno) {
		Integer resultado = 0;
		for (int i = 0; i < alumnos.size(); i++) {
			alumnos.get(i).equals(alumno.getDni());
			resultado = alumnos.get(i).getDni();

		}
		return resultado;
	}

	public void agregarUnDocente(Docente docente) {

		this.docentes.add(docente);

	}

	public Boolean revisarDocente(Docente docenteV, Docente docenteN) {
		Boolean estado = false;

		if (buscarDocente(docenteV).equals(docenteN.getDni())) {
			estado = false;
		} else {
			agregarUnDocente(docenteN);
			estado = true;

		}

		return estado;

	}

	public Integer buscarDocente(Docente docente) {
		Integer resultado = 0;
		for (int i = 0; i < docentes.size(); i++) {
			docentes.get(i).equals(docente.getDni());
			resultado = docentes.get(i).getDni();

		}
		return resultado;
	}
}
