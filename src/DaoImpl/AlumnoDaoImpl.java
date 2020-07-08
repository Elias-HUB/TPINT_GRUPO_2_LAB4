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
import Entidad.Localidad;
import Entidad.Provincia;

public class AlumnoDaoImpl implements AlumnoDao {

	private static final String insert = "insert into Alumnos(Dni, Nombre, Apellido, FechaNacimiento, Direccion, Localidad, Provincia, Email, Telefono, Estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String delete = "UPDATE Alumnos set Estado = 0 WHERE Legajo = ?;";
	private static final String update = "UPDATE Alumnos set Dni=?, Nombre=?, Apellido=?, FechaNacimiento=?, Direccion=?, Localidad=?, Provincia=?, Email=?, Telefono=?, Estado=? where Legajo =? ;";
	private static final String readall = "SELECT alumnos.Legajo, alumnos.Dni, alumnos.Nombre, alumnos.Apellido, alumnos.FechaNacimiento, alumnos.Email, alumnos.Telefono, alumnos.Estado, alumnos.Direccion, alumnos.Provincia as 'ProvinciaId', provincias.provincia as 'ProvinciaNombre', alumnos.Localidad as 'LocalidadId', localidades.localidad as 'LocalidadNombre' FROM tpint_grupo2_lab4.alumnos inner join tpint_grupo2_lab4.provincias on alumnos.Provincia = provincias.id inner join tpint_grupo2_lab4.localidades on alumnos.Localidad = localidades.id where Estado = 1;";
	private static final String readAlumnosXCurso = "SELECT a.Legajo, a.Dni, a.Nombre, a.Apellido, a.Email FROM alumnos a inner join AlumnosPorCurso ac on a.legajo = ac.LegajoAlumnno where ac.idcurso = ? and ac.estado=1 ;";
	private static final String readreporteestadoporcurso = "SELECT * FROM tpint_grupo2_lab4.cursos INNER JOIN tpint_grupo2_lab4.alumnosporcurso on alumnosporcurso.IdCurso = cursos.IdCurso where alumnosporcurso.IdCurso = cursos.IdCurso";


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
			statement.setInt(6, alumno.getDomicilio().getLocalidad().getID());
			statement.setInt(7, alumno.getDomicilio().getProvincia().getID());
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

	@Override
	public boolean update(Alumno alumno) {
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
			statement.setInt(6, alumno.getDomicilio().getLocalidad().getID());
			statement.setInt(7, alumno.getDomicilio().getProvincia().getID());
			statement.setString(8, alumno.getEmail());
			statement.setLong(9, alumno.getTelefono());
			statement.setBoolean(10, alumno.getEstado());
			statement.setInt(11, alumno.getLegajo());

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
		alumno.setLegajo(resultSet.getInt("alumnos.Legajo"));
		alumno.setDni(resultSet.getInt("alumnos.Dni"));
		alumno.setNombre(resultSet.getString("alumnos.Nombre"));
		alumno.setApellido(resultSet.getString("alumnos.Apellido"));
		alumno.setFechaNacimiento(resultSet.getDate("alumnos.FechaNacimiento"));
		alumno.setEmail(resultSet.getString("alumnos.Email"));
		alumno.setTelefono(resultSet.getLong("alumnos.Telefono"));
		alumno.setEstado(resultSet.getBoolean("alumnos.Estado"));
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
		alumno.setDomicilio(domicilio);

		return alumno;
	}

	@Override
	public boolean reporteestadoporcurso(String cadena) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

public List<Alumno> readAlumnosXCurso(int idCurso)
	{
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
			statement = conexion.getSQLConexion().prepareStatement(readAlumnosXCurso);
			statement.setInt(1,idCurso);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Alumno alumno = new Alumno();
				alumno.setLegajo(resultSet.getInt("Legajo"));
				alumno.setDni(resultSet.getInt("Dni"));
				alumno.setNombre(resultSet.getString("Nombre"));
				alumno.setApellido(resultSet.getString("Apellido"));
				alumno.setEmail(resultSet.getString("Email"));
				Alumnos.add(alumno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Alumnos;
	}
	

}
