package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ProvinciaDao;
import Entidad.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao {

	private static final String readall = "SELECT * FROM tpint_grupo2_lab4.provincias;";	
	@Override
	public List<Provincia> readAll() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Provincia> Provincia = new ArrayList<Provincia>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Provincia.add(GetProvincia(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Provincia;
	}
	
	private Provincia GetProvincia(ResultSet resultSet) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Provincia provincia = new Provincia();
		provincia.setID(resultSet.getInt("id"));
		provincia.setNombre(resultSet.getString("provincia"));		

		return provincia;
	}

}
