package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.MateriaDao;
import Entidad.Materia;

public class MateriaDaoImpl implements MateriaDao{
	private static final String readall = "Select * from materias";
	@Override
	public List<Materia> readAll() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Materia> Materias = new ArrayList<Materia>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Materias.add(GetMateria(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Materias;
	}
	
	private Materia GetMateria(ResultSet resultSet) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Materia materia = new Materia();
		materia.setIdMateria(resultSet.getInt("IdMateria"));
		materia.setNombre(resultSet.getString("Nombre"));
		return materia;
	}
}
