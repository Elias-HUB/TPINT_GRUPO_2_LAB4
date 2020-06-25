package Dao;

import java.util.List;

import Entidad.Localidad;
import Entidad.Provincia;

public interface LocalidadDao {
	public List<Localidad> ListarLocalidades();
	public List<Localidad> ListarLocalidadesProvincia(int ProvinciaId);
}
