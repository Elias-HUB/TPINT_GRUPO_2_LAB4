package Entidad;

public class TipoUsuario {

	private int id;
	private String TipoUsuario;
	
	public TipoUsuario()
	{
		
	}
	
	public TipoUsuario(TipoUsuario TipoUsuario)
	{
		this.id= TipoUsuario.id;
		this.TipoUsuario= TipoUsuario.TipoUsuario;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoUsuario() {
		return TipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}
	
	
}
