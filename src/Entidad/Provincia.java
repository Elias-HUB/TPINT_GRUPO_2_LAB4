package Entidad;

public class Provincia {
	private int ID;
	private String Nombre;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	@Override
	public String toString() {
		return "Provincia [ID=" + ID + ", Nombre=" + Nombre + "]";
	}
	
}
