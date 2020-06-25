package Entidad;

import java.math.BigInteger;
import java.util.Date;

public class Alumno extends Persona {

	private Boolean Estado;

	public Alumno() {

	}
	
	public Alumno(int legajo, int dni, String nombre, String apellido, Date fechaNacimiento, Domicilio domicilio,
			String email, Long telefono) {
		super(legajo, dni, nombre, apellido, fechaNacimiento, domicilio, email, telefono);
		// TODO Auto-generated constructor stub
	}

	public Boolean getEstado() {
		return Estado;
	}

	public void setEstado(Boolean estado) {
		Estado = estado;
	}

}
