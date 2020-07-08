package Entidad;

public class Calificacion {
	public Alumno alumno; 
	private int idCurso;
	private int parcial1; 
	private int parcial2;
	private int recu1;
	private int recu2;
	private int Notafinal;
	private String Estado;
	
	public Calificacion()
	{
		
	}	

	@Override
	public String toString() {
		return "Calificacion [alumno=" + alumno + ", idCurso=" + idCurso + ", parcial1=" + parcial1 + ", parcial2="
				+ parcial2 + ", recu1=" + recu1 + ", recu2=" + recu2 + "]";
	}



	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getParcial1() {
		return parcial1;
	}

	public void setParcial1(int parcial1) {
		this.parcial1 = parcial1;
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

	public int getParcial2() {
		return parcial2;
	}

	public void setParcial2(int parcial2) {
		this.parcial2 = parcial2;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public int getNotafinal() {
		return Notafinal;
	}

	public void setNotafinal(int notafinal) {
		Notafinal = notafinal;
	}
}
