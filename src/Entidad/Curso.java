package Entidad;

import java.util.ArrayList;

public class Curso {


	private int Id;
	public Materia Materia;
	private int Cuatrimestre;
	private int Año;
	public Docente docente;
	private String turno;
	private ArrayList<Alumno> Alumnos;
	private String estado; 
	
	public Curso() {
		
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int iD) {
		Id = iD;
	}
	public Materia getMateria() {
		return Materia;
	}
	public void setMateria(Materia materia) {
		Materia = materia;
	}
	public int getCuatrimestre() {
		return Cuatrimestre;
	}
	public void setCuatrimestre(int cuatrimestre) {
		Cuatrimestre = cuatrimestre;
	}
	public int getAño() {
		return Año;
	}
	public void setAño(int año) {
		Año = año;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public ArrayList<Alumno> getAlumnos() {
		return Alumnos;
	}
	public void setAlumnos(ArrayList<Alumno> alumnos) {
		Alumnos = alumnos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
}
