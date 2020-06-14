package Entidad;

import java.math.BigInteger;
import java.util.Date;

public class Docente extends Persona {

	private Boolean Estado;
	private TipoUsuario tipo;
	private String contraseña;

	public Docente() {

	}

	public Docente(int legajo, int dni, String nombre, String apellido, Date fechaNacimiento, String email,
			long telefono, Domicilio domicilio, Boolean estado, TipoUsuario tipoU) {
		super(legajo, dni, nombre, apellido, fechaNacimiento, email, telefono, domicilio);
		Estado = estado;
		tipo = new TipoUsuario(tipoU);
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
