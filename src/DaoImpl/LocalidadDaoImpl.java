package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.LocalidadDao;
import Entidad.Localidad;

public class LocalidadDaoImpl implements LocalidadDao {

	private static final String readall = "SELECT * FROM tpint_grupo2_lab4.localidades order by id asc;";
	private static final String readallPorProvincia = "SELECT * FROM tpint_grupo2_lab4.localidades where id_privincia = ?;";
	
	@Override
	public List<Localidad> ListarLocalidades() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Localidad> Localidad = new ArrayList<Localidad>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Localidad.add(GetLocalidad(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Localidad;
	}
	
	private Localidad GetLocalidad(ResultSet resultSet) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Localidad localidad = new Localidad();
		localidad.setID(resultSet.getInt("id"));
		localidad.setNombre(resultSet.getString("localidad"));		

		return localidad;
	}

	@Override
	public List<Localidad> ListarLocalidadesProvincia(int ProvinciaId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Localidad> Localidad = new ArrayList<Localidad>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readallPorProvincia);
			statement.setInt(1, ProvinciaId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Localidad.add(GetLocalidad(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Localidad;
	}

}
