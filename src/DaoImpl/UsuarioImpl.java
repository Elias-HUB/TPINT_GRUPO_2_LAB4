package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidad.Usuario;

public class UsuarioImpl {
	private static final String read = "SELECT * FROM usuarios where LegajoDocente=? and Contraseña=?";
	
public int Validar(String legajo, String contraseña) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int tipo=0;
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Usuario usuario = new Usuario();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(read);
			statement.setInt(1,Integer.parseInt(legajo));
			statement.setString(2, contraseña);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				usuario = GetUsuario(resultSet);
			}
			 
			if  (usuario.getTipo()==1)
			{
				tipo=1; 
			}
			else if(usuario.getTipo()==2)
			{
				tipo=2;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tipo; 
	}

	private Usuario GetUsuario(ResultSet resultSet) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(resultSet.getInt("IdUsuario"));
		usuario.setLegajo(resultSet.getInt("LegajoDocente"));
		usuario.setEmail(resultSet.getString("Email"));
		usuario.setContraseña(resultSet.getString("Contraseña"));
		usuario.setTipo(resultSet.getInt("TipoUsuario"));
		usuario.setEstado(resultSet.getBoolean("Estado"));
		return usuario;
	}
	
	
public Usuario BuscarUsuario(String legajo, String contraseña) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Usuario usuario = new Usuario();
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(read);
			statement.setInt(1,Integer.parseInt(legajo));
			statement.setString(2, contraseña);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				usuario = GetUsuario(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario; 
	}

}