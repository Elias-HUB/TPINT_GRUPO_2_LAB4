package Dao;

import java.util.List;

import Entidad.Docente;

public interface DocenteDao {
	public boolean insert(Docente docente);
	public boolean delete(int Legajo);
	public boolean update(Docente docente);
	public boolean recover(int Legajo);
	public List<Docente> readAll();
	public List<Docente> readrecover();
}
