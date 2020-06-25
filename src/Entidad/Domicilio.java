package Entidad;

public class Domicilio {
	

	private String Direccion;
	private Localidad Localidad;
	private Provincia Provincia;
	

	
	public Domicilio() {
		
	}



	public String getDireccion() {
		return Direccion;
	}



	public void setDireccion(String direccion) {
		Direccion = direccion;
	}



	public Localidad getLocalidad() {
		return Localidad;
	}



	public void setLocalidad(Localidad localidad) {
		Localidad = localidad;
	}



	public Provincia getProvincia() {
		return Provincia;
	}



	public void setProvincia(Provincia provincia) {
		Provincia = provincia;
	}
	

}
