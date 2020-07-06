package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidad.Alumno;
import Entidad.Curso;
import Entidad.Usuario;

public class UsuarioImpl {
	private static final String read = " SELECT tipousuario FROM tpint_grupo2_lab4.usuarios where legajodocente= ? and contraseña= ? ;";
	private static final String insert = "insert into usuarios(LegajoDocente, Email, Contraseña, TipoUsuario, Estado) "
			+ "VALUES((SELECT MAX(Legajo) from docentes), ?, ?, ?, ?);";
	private static final String update = "UPDATE usuarios set Email=?, Contraseña=? where LegajoDocente =? ;";
	private static final String delete = "UPDATE usuarios set Estado = 0 WHERE LegajoDocente = ?";
/*	public int ValidarLogin(String legajo, String contraseÃ±a) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		int tipo = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(read);
			statement.setInt(1, Integer.parseInt((legajo).toString()));
			statement.setString(2, contraseÃ±a);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				tipo = (resultSet.getInt("tipousuario"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tipo;
	}*/

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
	
	public boolean insert(Usuario usuario) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			
			statement = conexion.prepareStatement(insert);

			statement.setString(1, usuario.getEmail());
			statement.setString(2, usuario.getContraseña());
			statement.setInt(3, usuario.getTipo());
			statement.setBoolean(4, usuario.getEstado());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}
		} catch (SQLException e) {

			try {
				conexion.rollback();
			} catch (SQLException e1) {

				return isInsertExitoso = false;
			}
		}
		return isInsertExitoso;
	}
	

	public boolean update(Usuario usuario) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isupdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setString(1, usuario.getEmail());
			statement.setString(2, usuario.getContraseña());
			statement.setInt(3, usuario.getLegajo());


			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isupdateExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isupdateExitoso;
	}
	public boolean delete(int Legajo) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, Legajo);
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isdeleteExitoso = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}


}