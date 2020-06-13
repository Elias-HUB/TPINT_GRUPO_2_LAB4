package Entidad;

import java.util.ArrayList;

public class Curso {


	private int Id;
	private Materia Materia;
	private String Cuatrimestre;
	private int A�o;
	private Docente docente;
	private ArrayList<Alumno> Alumnos;
	
	public Curso(int iD, Materia materia, String cuatrimestre, int a�o, Docente docente,
			ArrayList<Alumno> alumnos) {
		
		Id = iD;
		Materia = materia;
		Cuatrimestre = cuatrimestre;
		A�o = a�o;
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
	public int getA�o() {
		return A�o;
	}
	public void setA�o(int a�o) {
		A�o = a�o;
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
