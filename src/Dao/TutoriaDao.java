package Dao;

import java.util.List;

import Entidad.Alumno;
import Entidad.Docente;
import Entidad.Tutoria;

public interface TutoriaDao {
	public boolean insert(Tutoria tutoria);
	public boolean update(int legajodocente, int legajoalumno);
	public boolean delete(int legajodocente, int legajoalumno);
	public List<Tutoria> readAll();
	public List<Tutoria> readAllDoc(int legajodocente);
}
