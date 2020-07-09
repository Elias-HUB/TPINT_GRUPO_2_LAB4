package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.NotaDao;
import Entidad.Alumno;
import Entidad.Calificacion;
import Entidad.Curso;
import Entidad.Docente;

public class NotaDaoImpl implements NotaDao
{
	private static final String insert = "insert into Calificaciones  VALUES (?,?,?,?,?,?,?,?)";
	private static final String readNotasXCurso = "SELECT alumnos.legajo, alumnos.Nombre, alumnos.Apellido, alumnos.Dni, alumnos.email, calificaciones.Idcurso, parcialuno,parcialdos, recuperatoriouno, recuperatoriodos, alumnosporcurso.EstadoCurso, NotaFinal from calificaciones inner join alumnos on alumnos.legajo = calificaciones.legajo inner join alumnosporcurso on alumnosporcurso.idcurso = calificaciones.idcurso and alumnosporcurso.LegajoAlumnno = calificaciones.legajo where calificaciones.idcurso = ? and calificaciones.estadoCalificacion = 1;";
	private static final String updateNotasXCurso = "update tpint_grupo2_lab4.calificaciones inner join alumnosporcurso on alumnosporcurso.idcurso = calificaciones.idcurso and alumnosporcurso.LegajoAlumnno = calificaciones.legajo set ParcialUno = ? , ParcialDos = ? , Recuperatoriouno = ? , Recuperatoriodos = ?, NotaFinal = ?, alumnosporcurso.EstadoCurso = ? where calificaciones.idcurso = ? and legajo = ?; ";
	private static final String FuncionValidarNotas = "SELECT count(*) as total FROM Calificaciones cal where cal.legajo= ? and cal.idCurso= ? and estadoCalificacion = 1; "; 
	private static final String delete ="update calificaciones set estadoCalificacion = 0 where legajo = ? and idcurso= ? "; 
	@Override
	public boolean insert(String legajo, int idcurso) {
			PreparedStatement statement;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			boolean isInsertExitoso = false;
			try {
				statement = conexion.prepareStatement(insert);
				statement.setInt(1, idcurso);
				statement.setInt(2, Integer.parseInt(legajo));
				statement.setInt(3, 0);
				statement.setInt(4, 0);
				statement.setInt(5, 0);
				statement.setInt(6, 0);
				statement.setInt(7, 0);
				statement.setBoolean(8,true);
				if (statement.executeUpdate() > 0) {
					conexion.commit();
					isInsertExitoso = true;
				}
			} catch (SQLException e) {

				try {
					conexion.rollback();
				} catch (SQLException e1) {

				 isInsertExitoso = false;
				}
			}
			return isInsertExitoso;
		
	}

	@Override
	public boolean update(Calificacion Calificacion) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isupdateExitoso = false;
		try {
			statement = conexion.prepareStatement(updateNotasXCurso);
			statement.setInt(1, Calificacion.getParcial1());
			statement.setInt(2, Calificacion.getParcial2());
			statement.setInt(3, Calificacion.getRecu1());
			statement.setInt(4, Calificacion.getRecu2());
			statement.setInt(5, Calificacion.getNotafinal());
			statement.setString(6, Calificacion.getEstado());
			statement.setInt(7, Calificacion.getIdCurso());
			statement.setInt(8, Calificacion.getAlumno().getLegajo());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isupdateExitoso = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isupdateExitoso;
	}

	@Override
	public List<Calificacion> readNotasXAlumno(int idCurso) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Calificacion> Calificacion = new ArrayList<Calificacion>();
		Conexion conexion = Conexion.getConexion();		
		try {
			statement = conexion.getSQLConexion().prepareStatement(readNotasXCurso);
			statement.setInt(1,idCurso);
			resultSet = statement.executeQuery();			
			while (resultSet.next()) {
				Calificacion.add(GetCalificacion(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Calificacion;
	}

	private Calificacion GetCalificacion(ResultSet resultSet) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calificacion calificacion = new Calificacion();
		Alumno alumno = new Alumno();
		alumno.setLegajo(resultSet.getInt("legajo"));
		alumno.setNombre(resultSet.getString("Nombre"));
		alumno.setApellido((resultSet.getString("Apellido")));
		alumno.setDni((resultSet.getInt("Dni")));
		alumno.setEmail(resultSet.getString("email"));
		calificacion.setAlumno(alumno);
		calificacion.setIdCurso(resultSet.getInt("idcurso"));
		calificacion.setParcial1(resultSet.getInt("parcialuno"));
		calificacion.setParcial2(resultSet.getInt("parcialdos"));
		calificacion.setRecu1(resultSet.getInt("recuperatoriouno"));
		calificacion.setRecu2(resultSet.getInt("recuperatoriodos"));
		calificacion.setEstado(resultSet.getString("EstadoCurso"));
		calificacion.setNotafinal(resultSet.getInt("NotaFinal"));
		
		return calificacion;
		
	}
	
	public boolean BuscarCalificaciones(String legajo, int idcurso)
	{
  		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		int cant;
		try {
			statement = conexion.getSQLConexion().prepareStatement(FuncionValidarNotas);
			statement.setInt(1,Integer.parseInt(legajo));
			statement.setInt(2,idcurso);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cant=resultSet.getInt("total");
				if(cant>0)
				{
					return true;
				}
				else return false; 
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return false;
	}
	public boolean deleteCalificacion(int legajo, int idcurso)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, legajo);
			statement.setInt(2, idcurso);
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
