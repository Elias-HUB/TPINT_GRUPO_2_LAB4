package Dao;

import java.util.List;

import Entidad.Docente;

public interface DocenteDao {
	public boolean insert(Docente docente);
	public boolean delete(Docente docente);
	public boolean update(Docente docente, String aux);
	public List<Docente> readAll();
}
