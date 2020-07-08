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

public class CursoDaoImpl implements CursoDao {
	private static final String insert = "insert into cursos (IdMateria, Cuatrimestre, Año, Turno, LegajoDocente, Estado) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String readall = "Select IdCurso,m.IdMateria, m.Nombre as NombreMateria,Cuatrimestre,Año,Turno,d.Legajo,d.Nombre, d.Apellido,c.Estado from cursos c inner join Docentes d on c.LegajoDocente = d.Legajo inner join Materias m on m.IdMateria=c.IdMateria";
	private static final String readCursosXDocente = "Select IdCurso,m.IdMateria, m.Nombre as NombreMateria,Cuatrimestre,Año,Turno,d.Legajo,d.Nombre, d.Apellido,c.Estado from cursos c inner join Docentes d on c.LegajoDocente = d.Legajo inner join Materias m on m.IdMateria=c.IdMateria where c.legajoDocente=?";
	private static final String insertAlumnosPorCurso = "insert into AlumnosPorCurso(IdCurso, LegajoAlumnno, EstadoCurso, Estado) VALUES (?, ? , 'Cursando',true)";
	private static final String readCurso = "Select IdCurso,m.IdMateria, m.Nombre as NombreMateria,Cuatrimestre,Año,Turno,d.Legajo,d.Nombre, d.Apellido,c.Estado from cursos c inner join Docentes d on c.LegajoDocente = d.Legajo inner join Materias m on m.IdMateria=c.IdMateria where c.idCurso= ?";
	private static final String update = "update cursos set idMateria= ?  , Cuatrimestre= ?, Año= ?  , Turno= ? , LegajoDocente= ?  where IdCurso= ? ;";
	private static final String ListReporteEstadoCurso = "call ReporteEstadoCurso( ? , ? , ?);";
	private static final String ListReporteAprobadoPorMateria = "call ReporteAprobadoPorMateria( ? , ? , ?);";
	private static final String ListReporteAlumnosPorMateria = "call ReporteAlumnosPorMateria( ? , ? , ?);";
	private static final String deleteAlumnoXCurso = "update AlumnosPorCurso set estado = 0 where LegajoAlumnno= ? and idcurso= ? ;";
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

	public boolean insertAlumnosPorCurso(int idCurso, String LegajoAlumno) {
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
	public boolean update(Curso curso, String CursoMod) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isupdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setInt(1, curso.Materia.getIdMateria());
			statement.setInt(2, curso.getCuatrimestre());
			statement.setInt(3, curso.getAño());
			statement.setString(4, curso.getTurno());
			statement.setInt(5, curso.docente.getLegajo());
			statement.setString(6, CursoMod);

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
			statement.setInt(1, legajo);
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

	public int DevuelveUltimoCurso() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		int ultimoID = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion()
					.prepareStatement("SELECT idcurso FROM tpint_grupo2_lab4.Cursos order by idCurso desc LIMIT 1");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ultimoID = (resultSet.getInt("idcurso"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ultimoID;
	}
	
	public List<Curso>  Filtrar(int legajo, int idMateria, int Turno, int cuatrimestre, int anio)
    {
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
			statement = conexion.getSQLConexion().prepareStatement("exec sp_CursosFiltrado ?,?,?,?,?;");
		    if (legajo!=0)
            {
            	statement.setInt(1,legajo);
            }
		    else
            {
		    	statement.setString(1,"");
            }
		    if (idMateria!=0)
            {
		    	statement.setInt(2,idMateria);
            }
            else
            {
            	statement.setString(2,"");
            }

            if (Turno!=0)
            {
            	statement.setInt(3,Turno);
            }
            else
            {
            	statement.setString(3,"");
            }
		if (cuatrimestre!=0)
            {
				statement.setInt(4,cuatrimestre);
            }
            else
            {
            	statement.setString(4,"");
            }
		if (anio!=0)
            {
				statement.setInt(5,anio);
            }
            else
            {
            	statement.setString(5,"");
            }
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Cursos.add(GetCurso(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Cursos;

    }


	
	public Curso BuscarCurso(int idCurso)
	{
  		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Curso curso = new Curso();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readCurso);
			statement.setInt(1,idCurso);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				curso= (GetCurso(resultSet));			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
  		return curso;
	}

	@Override
	public String ReporteEstadoCurso(String Materia, String Cuatrimestre, String Anio) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		String tabla = "";
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(ListReporteEstadoCurso);
			if (Materia.equals("Todas")) {
				statement.setString(1, "%%");
			} else {
				statement.setString(1, Materia);								
			}
			if (Cuatrimestre.equals("-1")) {
				statement.setString(2, "%%");
			} else {
				statement.setString(2, Cuatrimestre);				
			}
			if (Anio.equals("-1")) {
				statement.setString(3, "%%");				
			} else {
				statement.setString(3, Anio);
			}
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				tabla += "<tr>" + 
					      "<th>" + resultSet.getString("EstadoCurso") + "</th>" +
					      "<th>" + resultSet.getString("CantidadAlumnos") + "</th>" +
					      "<th>" + Math.round(resultSet.getFloat("Porcentaje")*100.0)/100.0 + " %</th>" + 
			   			 "</tr>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tabla;
	}

	@Override
	public String ReporteAprobadoPorMateria(String Materia, String Cuatrimestre, String Anio) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		String tabla = "";
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(ListReporteAprobadoPorMateria);
			if (Materia.equals("Todas")) {
				statement.setString(1, "%%");
			} else {
				statement.setString(1, Materia);								
			}
			if (Cuatrimestre.equals("-1")) {
				statement.setString(2, "%%");
			} else {
				statement.setString(2, Cuatrimestre);				
			}
			if (Anio.equals("-1")) {
				statement.setString(3, "%%");				
			} else {
				statement.setString(3, Anio);
			}
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				tabla += "<tr>" + 
					      "<th>" + resultSet.getString("MateriaNombre") + "</th>" +
					      "<th>" + resultSet.getInt("CantidadAlumnosAprobados") + "</th>"+ 
					      "<th>" + resultSet.getInt("CantidadTotalAlumnos") + "</th>" +
					      "<th>" + Math.round(resultSet.getFloat("PorcentajeAprobados")*100.0)/100.0 + " %</th>" + 
			   			 "</tr>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tabla;
	}

	@Override	
	public String ReporteAlumnosPorMateria(String Materia, String Cuatrimestre, String Anio) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		String tabla = "";
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(ListReporteAlumnosPorMateria);
			if (Materia.equals("Todas")) {
				statement.setString(1, "%%");
			} else {
				statement.setString(1, Materia);								
			}
			if (Cuatrimestre.equals("-1")) {
				statement.setString(2, "%%");
			} else {
				statement.setString(2, Cuatrimestre);				
			}
			if (Anio.equals("-1")) {
				statement.setString(3, "%%");				
			} else {
				statement.setString(3, Anio);
			}
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				tabla += "<tr>" + 
					      "<th>" + resultSet.getString("MateriaNombre") + "</th>" +
					      "<th>" + resultSet.getInt("CantidadTotalAlumnos") + "</th>"+					      
			   			 "</tr>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tabla;
	}
	
	public boolean deleteAlumnoXCurso(int legajo, int idcurso)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(deleteAlumnoXCurso);
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
