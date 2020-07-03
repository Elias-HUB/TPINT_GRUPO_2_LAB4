package Entidad;

public class Calificacion {
	private int Legajo; 
	private int idCurso;
	private int parcial1; 
	private int parcial2;
	private int recu1;
	private int recu2;
	
	public Calificacion()
	{
		
	}
	public int getParcial1() {
		return parcial1;
	}
	public void setParcial1(int parcial1) {
		this.parcial1 = parcial1;
	}
	public int getParcial2() {
		return parcial2;
	}
	public void setParcial2(int parcial2) {
		this.parcial2 = parcial2;
	}
	public int getRecu1() {
		return recu1;
	}
	public void setRecu1(int recu1) {
		this.recu1 = recu1;
	}
	public int getRecu2() {
		return recu2;
	}
	public void setRecu2(int recu2) {
		this.recu2 = recu2;
	}
	public int getLegajo() {
		return Legajo;
	}
	public void setLegajo(int legajo) {
		Legajo = legajo;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	} 
	
	
	
}
