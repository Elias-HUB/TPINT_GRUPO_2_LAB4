package Entidad;

public class Usuario {

	private int IdUsuario;
	private int Legajo;
	private String Contrase�a;
	private String Email;
	private int Tipo;
	private Boolean Estado;
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	public int getLegajo() {
		return Legajo;
	}
	public void setLegajo(int legajo) {
		Legajo = legajo;
	}
	public String getContrase�a() {
		return Contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		Contrase�a = contrase�a;
	}
	public int getTipo() {
		return Tipo;
	}
	public void setTipo(int tipo) {
		Tipo = tipo;
	}
	public Boolean getEstado() {
		return Estado;
	}
	public void setEstado(Boolean estado) {
		Estado = estado;
	}
	
	public Usuario()
	{
		
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
