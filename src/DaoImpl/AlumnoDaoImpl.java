package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.AlumnoDao;
import Entidad.Alumno;
import Entidad.Domicilio;

public class AlumnoDaoImpl implements AlumnoDao {

	private static final String insert = "insert into Alumnos(Dni, Nombre, Apellido, FechaNacimiento, Direccion, Localidad, Provincia, Email, Telefono, Estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "UPDATE Alumnos set Estado = 0 WHERE Dni = ?";
	private static final String update = "UPDATE Alumnos set Dni=?, Nombre=?, Apellido=?, FechaNacimiento=?, Direccion=?, Localidad=?, Provincia=?, Email=?, Telefono=?, Estado=? where Dni =?";
	private static final String readall = "SELECT * FROM Alumnos where Estado = 1";

	@Override
	public boolean insert(Alumno alumno) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, alumno.getDni());
			statement.setString(2, alumno.getNombre());
			statement.setString(3, alumno.getApellido());
			statement.setDate(4, (Date) alumno.getFechaNacimiento());
			statement.setString(5, alumno.getDomicilio().getDireccion());
			statement.setString(6, alumno.getDomicilio().getLocalidad());
			statement.setString(7, alumno.getDomicilio().getProvincia());
			statement.setString(8, alumno.getEmail());
			statement.setLong(9, alumno.getTelefono());
			statement.setBoolean(10, alumno.getEstado());
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

	@Override
	public boolean delete(Alumno alumno) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, alumno.getDni());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isdeleteExitoso = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}

	@Override
	public boolean update(Alumno alumno, String aux) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isupdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setInt(1, alumno.getDni());
			statement.setString(2, alumno.getNombre());
			statement.setString(3, alumno.getApellido());
			statement.setDate(4, (Date) alumno.getFechaNacimiento());
			statement.setString(5, alumno.getDomicilio().getDireccion());
			statement.setString(6, alumno.getDomicilio().getLocalidad());
			statement.setString(7, alumno.getDomicilio().getProvincia());
			statement.setString(8, alumno.getEmail());
			statement.setLong(9, alumno.getTelefono());
			statement.setBoolean(10, alumno.getEstado());

			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isupdateExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isupdateExitoso;
	}

	@Override
	public List<Alumno> readAll() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Alumno> Alumnos = new ArrayList<Alumno>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Alumnos.add(GetAlumno(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Alumnos;
	}

	private Alumno GetAlumno(ResultSet resultSet) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alumno alumno = new Alumno();
		alumno.setLegajo(resultSet.getInt("Legajo"));
		alumno.setDni(resultSet.getInt("Dni"));
		alumno.setNombre(resultSet.getString("Nombre"));
		alumno.setApellido(resultSet.getString("Apellido"));
		alumno.setFechaNacimiento(resultSet.getDate("FechaNacimiento"));
		alumno.setEmail(resultSet.getString("Email"));
		alumno.setTelefono(resultSet.getLong("Telefono"));
		alumno.setEstado(resultSet.getBoolean("Estado"));
		Domicilio domicilio = new Domicilio();
		domicilio.setDireccion(resultSet.getString("Direccion"));
		domicilio.setLocalidad(resultSet.getString("Localidad"));
		domicilio.setProvincia(resultSet.getString("Provincia"));
		alumno.setDomicilio(domicilio);

		return alumno;
	}

}
