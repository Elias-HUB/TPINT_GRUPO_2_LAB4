package Entidad;

import java.util.ArrayList;

public class Curso {


	private int Id;
	private Materia Materia;
	private String Cuatrimestre;
	private int Año;
	private Docente docente;
	private ArrayList<Alumno> Alumnos;
	
	public Curso(int iD, Materia materia, String cuatrimestre, int año, Docente docente,
			ArrayList<Alumno> alumnos) {
		
		Id = iD;
		Materia = materia;
		Cuatrimestre = cuatrimestre;
		Año = año;
		this.docente = docente;
		Alumnos = alumnos;
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
	public String getCuatrimestre() {
		return Cuatrimestre;
	}
	public void setCuatrimestre(String cuatrimestre) {
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
	
	
}
