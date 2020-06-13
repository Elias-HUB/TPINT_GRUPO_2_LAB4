package Entidad;

public class Domicilio {
	

	private String Direccion;
	private String Localidad;
	private String Provincia;

	
	public Domicilio() {
		
	}
	
	public Domicilio(String direccion, String localidad, String provincia) {
		Direccion = direccion;
		Localidad = localidad;
		Provincia = provincia;
	}
		
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	
}
