package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidad.Curso;
import Entidad.Usuario;

public class UsuarioImpl {
	private static final String read = " SELECT tipousuario FROM tpint_grupo2_lab4.usuarios where legajodocente= ? and contraseña= ? ;";

	public int read(String legajo, String contraseña) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		int tipo =0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(read);
			statement.setInt(1,Integer.parseInt((legajo).toString()));
			statement.setString(2, contraseña.toString());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				tipo=resultSet.getInt("tipousuario");
			}
		  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tipo;
	}

}