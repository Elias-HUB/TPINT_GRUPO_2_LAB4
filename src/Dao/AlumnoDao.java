package Dao;

import java.util.List;
import Entidad.Alumno;
import Entidad.Docente;

public interface AlumnoDao {
	public boolean insert(Alumno alumno);
	public boolean delete(int alumno_a_eliminar);
	public boolean update(Alumno alumno_a_modificar);
	public boolean reporteestadoporcurso(String cadena);
	public List<Alumno> readAll();
	public boolean recover(int Legajo);
	public List<Alumno> readrecover();
}
