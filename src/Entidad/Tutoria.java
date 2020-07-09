package Entidad;

public class Tutoria {
	
	private int LegajoDocente;
	private int LegajoAlumno;
	private String Observaciones;
	private Boolean Estado;
	
	public Tutoria() {}
	
	public Tutoria(int legajoDocente, int legajoAlumno, String observaciones, Boolean estado) {
		super();
		LegajoDocente = legajoDocente;
		LegajoAlumno = legajoAlumno;
		Observaciones = observaciones;
		Estado = estado;
	}

	public int getLegajoDocente() {
		return LegajoDocente;
	}

	public void setLegajoDocente(int legajoDocente) {
		LegajoDocente = legajoDocente;
	}

	public int getLegajoAlumno() {
		return LegajoAlumno;
	}

	public void setLegajoAlumno(int legajoAlumno) {
		LegajoAlumno = legajoAlumno;
	}

	public String getObservaciones() {
		return Observaciones;
	}

	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}

	public Boolean getEstado() {
		return Estado;
	}

	public void setEstado(Boolean estado) {
		Estado = estado;
	}	
	
}