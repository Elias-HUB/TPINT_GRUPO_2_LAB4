package Servelets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.DocenteDaoImpl;
import DaoImpl.LocalidadDaoImpl;
import DaoImpl.ProvinciaDaoImpl;
import DaoImpl.UsuarioImpl;
import Entidad.Docente;
import Entidad.Domicilio;
import Entidad.Localidad;
import Entidad.Provincia;
import Entidad.Usuario;

@WebServlet("/ServletDocente")
public class ServletDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletDocente() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("Param")!=null)
		{
			DocenteDaoImpl dDao = new DocenteDaoImpl();
			ProvinciaDaoImpl pDao = new ProvinciaDaoImpl();
			LocalidadDaoImpl lDao = new LocalidadDaoImpl();			
			
			List <Docente> listaDocentes = (ArrayList<Docente>)dDao.readAll();
			List<Provincia> listaProvincia = (ArrayList<Provincia>) pDao.readAll();
			List<Localidad> listaLocalidad = (ArrayList<Localidad>) lDao.ListarLocalidades();			
			
			request.setAttribute("ListaDocentes",listaDocentes );
			request.setAttribute("ListaProvincia", listaProvincia);
			request.setAttribute("ListaLocalidad", listaLocalidad);
			request.getRequestDispatcher("ListadoDocentes.jsp").forward( request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DocenteDaoImpl dDao = new DocenteDaoImpl();
		ProvinciaDaoImpl pDao = new ProvinciaDaoImpl();
		LocalidadDaoImpl lDao = new LocalidadDaoImpl();
		UsuarioImpl uDao= new UsuarioImpl();

		
		if (request.getParameter("BtnEliminar") != null) {
			String algo = request.getParameter("LegajoDocente");
			int Legajo = Integer.parseInt(request.getParameter("LegajoDocente"));
			
			dDao.delete(Legajo);		
			uDao.delete(Legajo);		
			List <Docente> listaDocentesEliminar = (ArrayList<Docente>)dDao.readAll();
			List<Provincia> listaProvinciaEliminar = (ArrayList<Provincia>) pDao.readAll();
			List<Localidad> listaLocalidadEliminar = (ArrayList<Localidad>) lDao.ListarLocalidades();			
			
			request.setAttribute("ListaDocentes",listaDocentesEliminar );
			request.setAttribute("ListaProvincia", listaProvinciaEliminar);
			request.setAttribute("ListaLocalidad", listaLocalidadEliminar);
			request.getRequestDispatcher("ListadoDocentes.jsp").forward( request, response);
		}

		//ANALIZAR CONTRASEÑA Y USUARIO
		if (request.getParameter("BtnActualizar") != null) {
			Docente docente = new Docente();
			Usuario usuario = new Usuario();
			docente.setLegajo(Integer.parseInt(request.getParameter("TboxLegajoM")));
			docente.setNombre(request.getParameter("TboxNombreM"));
			docente.setApellido(request.getParameter("TboxApellidoM"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date parsed = null;
			try {
				parsed = format.parse(request.getParameter("TboxFechaNacimientoM"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sql = new java.sql.Date(parsed.getTime());
			docente.setFechaNacimiento(sql);
			docente.setEmail(request.getParameter("TboxEmailM"));
			docente.setTelefono((long) Integer.parseInt(request.getParameter("TboxTelefonoM")));
			docente.setDni(Integer.parseInt(request.getParameter("TboxDniM")));
			docente.setEstado(true);

			docente.domicilio = new Domicilio();
			docente.domicilio.setDireccion(request.getParameter("TboxDirreccionM"));

			String Localidad = request.getParameter("TboxLocalidadM").toString();
			String Provincia = request.getParameter("TboxProvinciaM").toString();
			Localidad localidad = new Localidad();
			localidad.setID(Integer.parseInt(Localidad));
			Provincia provincia = new Provincia();
			provincia.setID(Integer.parseInt(Provincia));

			docente.domicilio.setLocalidad(localidad);
			docente.domicilio.setProvincia(provincia);
			usuario.setLegajo(Integer.parseInt(request.getParameter("TboxLegajoM")));
			usuario.setEmail(request.getParameter("TboxEmailM"));
			usuario.setContraseña(request.getParameter("TboxContraseña"));

			dDao.update(docente);
			uDao.update(usuario);
			List <Docente> listaDocentes = (ArrayList<Docente>)dDao.readAll();
			List<Provincia> listaProvincia = (ArrayList<Provincia>) pDao.readAll();
			List<Localidad> listaLocalidad = (ArrayList<Localidad>) lDao.ListarLocalidades();			
			
			request.setAttribute("ListaDocentes",listaDocentes );
			request.setAttribute("ListaProvincia", listaProvincia);
			request.setAttribute("ListaLocalidad", listaLocalidad);
			request.getRequestDispatcher("ListadoDocentes.jsp").forward( request, response);
		}

		//ANALIZAR CONTRASEÑA Y USUARIO
		if (request.getParameter("BtnAgregar") != null) {
			Docente docente = new Docente();
			Usuario usuario = new Usuario();
			docente.setDni(Integer.parseInt(request.getParameter("TboxDniA").toString()));
			docente.setNombre(request.getParameter("TboxNombreA"));
			docente.setApellido(request.getParameter("TboxApellidoA"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date parsed = null;
			try {
				parsed = format.parse(request.getParameter("TboxFechaNacimientoA"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sql = new java.sql.Date(parsed.getTime());
			docente.setFechaNacimiento(sql);
			docente.setEmail(request.getParameter("TboxEmailA"));
			docente.setTelefono((long) Integer.parseInt(request.getParameter("TboxTelefonoA")));

			docente.domicilio = new Domicilio();
			docente.domicilio.setDireccion(request.getParameter("TboxDirreccionA"));

			String Localidad = request.getParameter("TboxLocalidadA").toString();
			String Provincia = request.getParameter("TboxProvinciaA").toString();
			Localidad localidad = new Localidad();
			localidad.setID(Integer.parseInt(Localidad));
			Provincia provincia = new Provincia();
			provincia.setID(Integer.parseInt(Provincia));

			docente.domicilio.setLocalidad(localidad);
			docente.domicilio.setProvincia(provincia);

			docente.setEstado(true);
			dDao.insert(docente);			

			usuario.setEmail(request.getParameter("TboxEmailA"));
			usuario.setContraseña(request.getParameter("TboxContraseñaA"));
			usuario.setTipo(2);
			usuario.setEstado(true);
			
			uDao.insert(usuario);
			List <Docente> listaDocentes = (ArrayList<Docente>)dDao.readAll();
			List<Provincia> listaProvincia = (ArrayList<Provincia>) pDao.readAll();
			List<Localidad> listaLocalidad = (ArrayList<Localidad>) lDao.ListarLocalidades();			
			
			request.setAttribute("ListaDocentes",listaDocentes );
			request.setAttribute("ListaProvincia", listaProvincia);
			request.setAttribute("ListaLocalidad", listaLocalidad);
			request.getRequestDispatcher("ListadoDocentes.jsp").forward( request, response);
		}		
	}
}