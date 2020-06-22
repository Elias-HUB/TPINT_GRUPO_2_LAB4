package Dao;

import java.util.List;
import Entidad.Alumno;

public interface AlumnoDao {
	public boolean insert(Alumno alumno);
	public boolean delete(int alumno_a_eliminar);
	public boolean update(Alumno alumno_a_modificar);
	public List<Alumno> readAll();
}
