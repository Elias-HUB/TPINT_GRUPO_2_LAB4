package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.NotaDao;
import Entidad.Calificacion;

public class NotaDaoImpl implements NotaDao
{
	private static final String readNotasXCurso = "SELECT idcurso, legajo, parcialuno,parcialdos, recuperatoriouno, recuperatoriodos from calificaciones where idcurso= ? and legajo= ? ; ";
	@Override
	public boolean insert(Calificacion calificacion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Calificacion Calificacion_a_modificar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Calificacion readNotasXAlumno(int idCurso, int legajo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		Calificacion calificacion = new Calificacion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readNotasXCurso);
			statement.setInt(1,idCurso);
			statement.setInt(2,legajo);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				calificacion.setIdCurso(resultSet.getInt("idcurso"));
				calificacion.setLegajo(resultSet.getInt("legajo"));
				calificacion.setParcial1(resultSet.getInt("parcialuno"));
				calificacion.setParcial2(resultSet.getInt("parcialdos"));
				calificacion.setRecu1(resultSet.getInt("recuperatoriouno"));
				calificacion.setRecu2(resultSet.getInt("recuperatoriodos"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return calificacion;
	}

	private Calificacion GetCalificacion(ResultSet resultSet) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calificacion calificacion = new Calificacion();
		calificacion.setLegajo(resultSet.getInt("legajo"));
		calificacion.setIdCurso(resultSet.getInt("idcurso"));
		calificacion.setParcial1(resultSet.getInt("parcialuno"));
		calificacion.setParcial1(resultSet.getInt("parcialdos"));
		calificacion.setRecu1(resultSet.getInt("recuperatoriouno"));
		calificacion.setRecu2(resultSet.getInt("recuperatoriodos"));
		return calificacion;
		
	}
}
