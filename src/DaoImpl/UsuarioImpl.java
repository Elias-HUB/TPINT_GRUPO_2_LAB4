package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidad.Usuario;

public class UsuarioImpl {
	private static final String read = "SELECT * FROM usuarios where LegajoDocente=? and Contraseña=?";
	
public boolean Validar(String legajo, String contraseña) {
		boolean existe = false; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
			 
			if  (usuario.getLegajo()>0)
			{
				existe=true; 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe; 
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

//public boolean validarIngreso(int legajo, String contra) {
//	try {
//		Class.forName("com.mysql.jdbc.Driver");
//	}
//	catch(ClassNotFoundException e){
//		e.printStackTrace();
//	}
//	String Usuario;
//	Usuario = "SELECT * FROM USUARIOS WHERE Legajo = '" + legajo + "'"; 
//	try {
//		PreparedStatement statement;
//		ResultSet rs; // Guarda el resultado de la query
//		//Usuario usuario = new Usuario();
//		Conexion conexion = Conexion.getConexion();
//		statement = conexion.getSQLConexion().prepareStatement(Usuario);
//		rs = statement.executeQuery();
//		while(rs.next())
//		{
//			if(contra.equals(rs.getString("Contraseña"))) {
//				return true;						
//				}
//				else {
//					return false;
//				}
//			}
//		return false; 
//		} catch (SQLException e) {
//		e.printStackTrace();
//	}
//
//	
//}
}