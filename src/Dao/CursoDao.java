package Dao;

import java.util.List;

import Entidad.Curso;

public interface CursoDao {
	public boolean insert(Curso curso);
	public boolean delete(Curso curso);
	public boolean update(Curso curso, String aux);
	public List<Curso> readAll();
	public String ReporteEstadoCurso(String Materia, String Cuatrimestre, String Anio);
	public String ReporteAprobadoPorMateria (String Materia, String Cuatrimestre, String Anio);
	public String ReporteAlumnosPorMateria (String Materia, String Cuatrimestre, String Anio);	
}
