package DaoImpl;

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
	private static final String readall = "Select IdCurso,m.IdMateria, m.Nombre as NombreMateria,Cuatrimestre,Año,Turno,d.Legajo,d.Nombre, d.Apellido,c.Estado from cursos c inner join Docentes d on c.LegajoDocente = d.Legajo inner join Materias m on m.IdMateria=c.IdMateria";

	@Override
	public boolean insert(Curso curso) {
		// TODO Auto-generated method stub
		return false;
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

}
