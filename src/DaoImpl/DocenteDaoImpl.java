package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.DocenteDao;
import Entidad.Docente;
import Entidad.Domicilio;
import Entidad.Localidad;
import Entidad.Provincia;

public class DocenteDaoImpl implements DocenteDao {

	private static final String insert = "insert into Docentes(Dni, Nombre, Apellido, FechaNacimiento, Direccion, Localidad, Provincia, Email, Telefono, Estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "UPDATE Docentes set Estado = 0 WHERE Dni = ?";
	private static final String update = "UPDATE Docentes set Dni=?, Nombre=?, Apellido=?, FechaNacimiento=?, Direccion=?, Localidad=?, Provincia=?, Email=?, Telefono=?, Estado=? where Dni =?";
	private static final String readall = "SELECT docentes.Legajo, docentes.Dni, docentes.Nombre, docentes.Apellido, docentes.FechaNacimiento, docentes.Email, docentes.Telefono, docentes.Estado, docentes.Direccion, docentes.Provincia as 'ProvinciaId', provincias.provincia as 'ProvinciaNombre', docentes.Localidad as 'LocalidadId', localidades.localidad as 'LocalidadNombre' FROM tpint_grupo2_lab4.docentes inner join tpint_grupo2_lab4.provincias on docentes.Provincia = provincias.id inner join tpint_grupo2_lab4.localidades on docentes.Localidad = localidades.id where Estado = 1;";
	private static final String readUno = "SELECT * FROM Docentes where legajo=?"; 
	@Override
	public boolean insert(Docente docente) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, docente.getDni());
			statement.setString(2, docente.getNombre());
			statement.setString(3, docente.getApellido());
			statement.setDate(4, (Date) docente.getFechaNacimiento());
			statement.setString(5, docente.getDomicilio().getDireccion());
			statement.setInt(6, docente.getDomicilio().getLocalidad().getID());
			statement.setInt(7, docente.getDomicilio().getProvincia().getID());
			statement.setString(8, docente.getEmail());
			statement.setLong(9, docente.getTelefono());
			statement.setBoolean(10, docente.getEstado());
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
	public boolean delete(Docente docente) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, docente.getDni());
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
	public boolean update(Docente docente, String aux) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isupdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setInt(1, docente.getDni());
			statement.setString(2, docente.getNombre());
			statement.setString(3, docente.getApellido());
			statement.setDate(4, (Date) docente.getFechaNacimiento());
			statement.setString(5, docente.getDomicilio().getDireccion());
			statement.setInt(6, docente.getDomicilio().getLocalidad().getID());
			statement.setInt(7, docente.getDomicilio().getProvincia().getID());
			statement.setString(8, docente.getEmail());
			statement.setLong(9, docente.getTelefono());
			statement.setBoolean(10, docente.getEstado());

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
	public List<Docente> readAll() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Docente> Docentes = new ArrayList<Docente>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Docentes.add(GetDocente(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Docentes;
	}

	private Docente GetDocente(ResultSet resultSet) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Docente docente = new Docente();
		docente.setLegajo(resultSet.getInt("Legajo"));
		docente.setDni(resultSet.getInt("Dni"));
		docente.setNombre(resultSet.getString("Nombre"));
		docente.setApellido(resultSet.getString("Apellido"));
		docente.setFechaNacimiento(resultSet.getDate("FechaNacimiento"));
		docente.setEmail(resultSet.getString("Email"));
		docente.setTelefono(resultSet.getLong("Telefono"));
		docente.setEstado(resultSet.getBoolean("Estado"));
		Domicilio domicilio = new Domicilio();
		domicilio.setDireccion(resultSet.getString("Direccion"));
		
		Localidad localidad = new Localidad();
		localidad.setID((resultSet.getInt("ProvinciaId")));
		localidad.setNombre((resultSet.getString("ProvinciaNombre")));
		
		Provincia provincia = new Provincia();
		provincia.setID((resultSet.getInt("LocalidadId")));
		provincia.setNombre((resultSet.getString("LocalidadNombre")));
		
		domicilio.setLocalidad(localidad);
		domicilio.setProvincia(provincia);
		docente.setDomicilio(domicilio);

		return docente;
	}
public Docente Buscar(String legajo) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Docente docente = new Docente();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readUno);
			statement.setInt(1,Integer.parseInt(legajo));
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				docente=(GetDocente(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return docente;
	}
}
