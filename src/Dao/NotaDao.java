package Dao;

import java.util.List;

import Entidad.Calificacion;

public interface NotaDao {
	public boolean insert(Calificacion calificacion);
	public boolean update(Calificacion Calificacion_a_modificar);
	public Calificacion readNotasXAlumno(int idCurso, int Legajo);
}
