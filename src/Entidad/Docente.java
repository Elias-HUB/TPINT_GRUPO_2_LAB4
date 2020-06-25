package Entidad;

import java.math.BigInteger;
import java.util.Date;

public class Docente extends Persona {

	private Boolean Estado;
	private TipoUsuario tipo;
	private String contraseña;

	public Docente() {

	}

	public Docente(int legajo, int dni, String nombre, String apellido, Date fechaNacimiento, Domicilio domicilio,
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

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
