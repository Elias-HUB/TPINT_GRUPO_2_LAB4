package Entidad;

import java.math.BigInteger;
import java.util.Date;

public class Alumno extends Persona {

	private Boolean Estado;

	public Alumno() {

	}

	public Alumno(int legajo, int dni, String nombre, String apellido, Date fechaNacimiento, String email,
			long telefono, Domicilio domicilio, Boolean estado) {
		super(legajo, dni, nombre, apellido, fechaNacimiento, email, telefono, domicilio);
		Estado = estado;
	}

	public Boolean getEstado() {
		return Estado;
	}

	public void setEstado(Boolean estado) {
		Estado = estado;
	}

}
