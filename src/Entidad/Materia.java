package Entidad;

public class Materia {
	
	private int IdMateria;
	private String Nombre;
	private Boolean Estado;
	
	
	public Materia(Materia materia) {
		IdMateria = materia.IdMateria;
		Nombre = materia.Nombre;
		Estado = materia.Estado;
	}
	public Materia() {
	}
	
	public int getIdMateria() {
		return IdMateria;
	}
	public void setIdMateria(int idMateria) {
		IdMateria = idMateria;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Boolean getEstado() {
		return Estado;
	}
	public void setEstado(Boolean estado) {
		Estado = estado;
	}
	
	
}
