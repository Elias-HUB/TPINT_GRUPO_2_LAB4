package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.CursoDao;
import Entidad.Curso;
import Entidad.Docente;
import Entidad.Domicilio;
import Entidad.Materia;
import Entidad.Persona;

public class CursoDaoImpl implements CursoDao{
	private static final String insert = "insert into cursos (IdMateria, Cuatrimestre, Año, Turno, LegajoDocente, Estado) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String readall = "Select IdCurso,m.IdMateria, m.Nombre as NombreMateria,Cuatrimestre,Año,Turno,d.Legajo,d.Nombre, d.Apellido,c.Estado from cursos c inner join Docentes d on c.LegajoDocente = d.Legajo inner join Materias m on m.IdMateria=c.IdMateria";
	private static final String readCursosXDocente = "Select IdCurso,m.IdMateria, m.Nombre as NombreMateria,Cuatrimestre,Año,Turno,d.Legajo,d.Nombre, d.Apellido,c.Estado from cursos c inner join Docentes d on c.LegajoDocente = d.Legajo inner join Materias m on m.IdMateria=c.IdMateria where c.legajoDocente=?";
	private static final String insertAlumnosPorCurso = "insert into AlumnosPorCurso(IdCurso, LegajoAlumnno, EstadoCurso, Estado) VALUES (?, ? , 'Cursando',true)";
	@Override
	public boolean insert(Curso curso) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, curso.Materia.getIdMateria());
			statement.setInt(2, curso.getCuatrimestre());
			statement.setInt(3, curso.getAño());
			statement.setString(4, curso.getTurno());
			statement.setInt(5, curso.docente.getLegajo());
			statement.setBoolean(6, true);
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
	public boolean insertAlumnosPorCurso(int idCurso,String LegajoAlumno) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insertAlumnosPorCurso);
			statement.setInt(1, idCurso);
			statement.setInt(2, Integer.parseInt(LegajoAlumno.toString()));
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
	public boolean delete(Curso curso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Curso curso, String aux) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Curso> readAll() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Curso> Cursos = new ArrayList<Curso>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Cursos.add(GetCurso(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Cursos;
	}
	
	public List<Curso> readCursosXDocente(int legajo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Curso> Cursos = new ArrayList<Curso>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readCursosXDocente);
			statement.setInt(1,legajo);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Cursos.add(GetCurso(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Cursos;
	}

	private Curso GetCurso(ResultSet resultSet) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Curso curso = new Curso();
		curso.setId(resultSet.getInt("IdCurso"));
		Materia mat = new Materia();
		mat.setIdMateria(resultSet.getInt("IdMateria"));
		mat.setNombre(resultSet.getString("NombreMateria"));
		curso.setMateria(mat);
		curso.setCuatrimestre(resultSet.getInt("Cuatrimestre"));
		curso.setAño(resultSet.getInt("Año"));
		curso.setTurno(resultSet.getString("Turno"));
		Docente doc = new Docente(); 
		doc.setLegajo(resultSet.getInt("Legajo"));
		doc.setNombre(resultSet.getString("Nombre"));
		doc.setApellido(resultSet.getString("Apellido"));
		curso.setDocente(doc);
		curso.setEstado(resultSet.getString("Estado"));
		return curso;
	}
	public int DevuelveUltimoCurso()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		int ultimoID=0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement("SELECT idcurso FROM tpint_grupo2_lab4.Cursos order by idCurso desc LIMIT 1");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ultimoID= (resultSet.getInt("idcurso"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ultimoID;
	}

}
