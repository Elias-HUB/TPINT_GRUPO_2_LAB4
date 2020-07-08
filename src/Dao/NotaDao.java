package Dao;

import java.util.List;

import Entidad.Calificacion;

public interface NotaDao {
	public boolean insert(String l,int c);
	public boolean update(Calificacion Calificacion);
	public List<Calificacion> readNotasXAlumno(int idCurso);
}