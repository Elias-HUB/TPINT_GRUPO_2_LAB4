package Entidad;

import java.util.Date;

public class Persona {
	private int Legajo; 
	private int Dni;
	private String Nombre;
	private String Apellido;
	private Date FechaNacimiento;
	public Domicilio domicilio;
	private String Email; 
	private Long Telefono;
	
	public Persona() {
	
	}
	
	public Persona(int legajo, int dni, String nombre, String apellido, Date fechaNacimiento, String email,
			Long telefono, Domicilio domicilio ) {
		Legajo = legajo;
		Dni = dni;
		Nombre = nombre;
		Apellido = apellido;
		FechaNacimiento = fechaNacimiento;
		Email = email;
		Telefono = telefono;
		this.domicilio= domicilio; 
	}
	
	public int getLegajo() {
		return Legajo;
	}
	public void setLegajo(int legajo) {
		Legajo = legajo;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
		public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
		public int getDni() {
		return Dni;
	}
	public void setDni(int dni) {
		Dni = dni;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Long getTelefono() {
		return Telefono;
	}
	public void setTelefono(Long telefono) {
		Telefono = telefono;
	}	
}
