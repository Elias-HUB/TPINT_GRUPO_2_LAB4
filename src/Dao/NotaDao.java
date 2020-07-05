package Dao;

import java.util.List;

import Entidad.Calificacion;

public interface NotaDao {
	public boolean insert(Calificacion calificacion);
	public boolean update(Calificacion Calificacion);
	public List<Calificacion> readNotasXAlumno(int idCurso);
}