package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.TutoriaDao;
import Entidad.Docente;
import Entidad.Localidad;
import Entidad.Tutoria;
import Entidad.Alumno;
import Entidad.Curso;

public class TutoriaDaoImpl implements TutoriaDao {

	private static final String insert = "insert into Tutorias(LegajoDocente, LegajoAlumno, Observaciones, Estado) VALUES(?, ?, ?, ?)";
	private static final String update = "UPDATE Tutorias set Estado=1 where LegajoDocente =? and LegajoAlumno= ?";
	private static final String delete = "UPDATE Tutorias set Estado = 0 WHERE LegajoDocente = ? and LegajoAlumno= ?";	
	private static final String readall = "SELECT tutorias.LegajoDocente, tutorias.LegajoAlumno, tutorias.Observaciones FROM tpint_grupo2_lab4.tutorias where Estado = 1;";
	private static final String readAllDoc = "SELECT tutorias.LegajoDocente, tutorias.LegajoAlumno, tutorias.Observaciones FROM tpint_grupo2_lab4.tutorias where Estado = 1 and tutorias.LegajoDocente = ? order by tutorias.LegajoAlumno asc;"; 
	private static final String ExisteAlta = "SELECT count(*) as total FROM tutorias where LegajoDocente= ? and LegajoAlumno= ? and estado= 1" ;
	private static final String ExisteBaja= "SELECT count(*) as total FROM tutorias where LegajoDocente= ? and LegajoAlumno= ? and estado= 0" ;

	@Override
	public boolean insert(Tutoria tutoria) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, tutoria.getLegajoDocente());
			statement.setInt(2, tutoria.getLegajoAlumno());
			statement.setString(3, tutoria.getObservaciones());
			statement.setBoolean(4, tutoria.getEstado());

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
	public boolean delete(int legajodocente, int legajoalumno) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, legajodocente);
			statement.setInt(2, legajoalumno);
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
	public boolean update(int legajodocente, int legajoalumno) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isupdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);			
			statement.setInt(1, legajodocente);
			statement.setInt(2, legajoalumno);

			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isupdateExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isupdateExitoso;
	}
	
	private Tutoria GetTutoria(ResultSet resultSet) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Tutoria tutoria = new Tutoria();
		tutoria.setLegajoDocente(resultSet.getInt("tutorias.LegajoDocente"));
		tutoria.setLegajoAlumno(resultSet.getInt("tutorias.LegajoAlumno"));
		tutoria.setObservaciones(resultSet.getString("tutorias.Observaciones"));
		
		return tutoria;
	}
	
	
	@Override
	public List<Tutoria> readAll() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Tutoria> Tutoria = new ArrayList<Tutoria>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Tutoria.add(GetTutoria(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Tutoria;
	}

	@Override
	public List<Tutoria> readAllDoc(int legajodocente) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Tutoria> tutoria = new ArrayList<Tutoria>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readAllDoc);
			statement.setInt(1, legajodocente);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				tutoria.add(GetTutoria(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tutoria;
	}
	public int ExisteAlta(int LegajoDoc, int LegajoAlumno)
	{
  		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		int cant = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(ExisteAlta);
			statement.setInt(1,LegajoDoc);
			statement.setInt(2,LegajoAlumno);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cant=resultSet.getInt("total");		}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return cant; 
	}
	public int ExisteBaja(int LegajoDoc, int LegajoAlumno)
	{
  		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		int cant = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(ExisteBaja);
			statement.setInt(1,LegajoDoc);
			statement.setInt(2,LegajoAlumno);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cant=resultSet.getInt("total");		}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return cant; 
	}
}
