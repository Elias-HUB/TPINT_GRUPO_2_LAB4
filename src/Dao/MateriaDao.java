package Dao;

import java.util.List;

import Entidad.Materia;

public interface MateriaDao {
	
	public List<Materia> readAll();
	public Materia ReadMateria(int Materiaid);
}
