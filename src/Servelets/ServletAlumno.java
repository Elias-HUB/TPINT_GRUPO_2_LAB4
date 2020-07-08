package Servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Dao.LocalidadDao;
import Dao.ProvinciaDao;
import DaoImpl.AlumnoDaoImpl;
import DaoImpl.CursoDaoImpl;
import DaoImpl.DocenteDaoImpl;
import DaoImpl.LocalidadDaoImpl;
import DaoImpl.NotaDaoImpl;
import DaoImpl.ProvinciaDaoImpl;
import DaoImpl.UsuarioImpl;
import Entidad.Alumno;
import Entidad.Calificacion;
import Entidad.Curso;
import Entidad.Docente;
import Entidad.Domicilio;
import Entidad.Localidad;
import Entidad.Provincia;

@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAlumno() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Curso curso = new Curso();
		CursoDaoImpl cdao= new CursoDaoImpl();
		if(session.getAttribute("Legajo") == null) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		AlumnoDaoImpl aDao = new AlumnoDaoImpl();
		ProvinciaDaoImpl pDao = new ProvinciaDaoImpl();
		LocalidadDaoImpl lDao = new LocalidadDaoImpl();
		if (request.getParameter("Param") != null) {

			List<Alumno> listaAlumnos = (ArrayList<Alumno>) aDao.readAll();
			List<Provincia> listaProvincia = (ArrayList<Provincia>) pDao.readAll();
			List<Localidad> listaLocalidad = (ArrayList<Localidad>) lDao.ListarLocalidades();
			request.setAttribute("ListaAlumnos", listaAlumnos);
			request.setAttribute("ListaProvincia", listaProvincia);
			request.setAttribute("ListaLocalidad", listaLocalidad);			
			request.getRequestDispatcher("ListadoAlumnosAdmin.jsp").forward(request, response);
		}
		if(request.getParameter("ParamAlumnoXCursoAdmin")!=null)
		{
			AlumnoDaoImpl aDao1 = new AlumnoDaoImpl();
			String Curso = request.getParameter("ParamAlumnoXCursoAdmin").toString();
			int cursoBuscar = Integer.parseInt(Curso);
			curso = cdao.BuscarCurso(cursoBuscar);
			session.setAttribute("CursoAListar",curso);
			List<Alumno> listaAlumnos = (ArrayList<Alumno>) aDao1.readAlumnosXCurso(cursoBuscar);
			request.setAttribute("ListaAlumnos", listaAlumnos);
			request.getRequestDispatcher("AlumnosPorCursoAdmin.jsp").forward(request, response);
		}
		if(request.getParameter("ParamRecuperarAlumno") != null)
		{
			String StringlegajoRecupero = request.getParameter("ParamRecuperarAlumno");
			int legajoRecupero = Integer.parseInt(StringlegajoRecupero);
			AlumnoDaoImpl rDao= new AlumnoDaoImpl();
			boolean recover = rDao.recover(legajoRecupero);
			
			if(recover == true) {
				request.setAttribute("SweetAlert", "Cargado");
			}
			else {
				request.setAttribute("SweetAlert", "Error");
			}
			
			List<Alumno> ListaAlumnosRecup = (ArrayList<Alumno>)rDao.readrecover();
			request.setAttribute("ListaAlumnosRecup", ListaAlumnosRecup);
			request.getRequestDispatcher("RecuperarAlumnos.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AlumnoDaoImpl aDao = new AlumnoDaoImpl();
		ProvinciaDaoImpl pDao = new ProvinciaDaoImpl();
		LocalidadDaoImpl lDao = new LocalidadDaoImpl();

		if (request.getParameter("BtnActualizar") != null) {
			Alumno alumno = new Alumno();
			alumno.setLegajo(Integer.parseInt(request.getParameter("TboxLegajoM")));
			alumno.setNombre(request.getParameter("TboxNombreM"));
			alumno.setApellido(request.getParameter("TboxApellidoM"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date parsed = null;
			try {
				parsed = format.parse(request.getParameter("TboxFechaNacimientoM"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sql = new java.sql.Date(parsed.getTime());
			alumno.setFechaNacimiento(sql);
			alumno.setEmail(request.getParameter("TboxEmailM"));
			alumno.setTelefono(Long.parseLong(request.getParameter("TboxTelefonoM")));
			alumno.setDni(Integer.parseInt(request.getParameter("TboxDniM")));
			alumno.setEstado(true);

			alumno.domicilio = new Domicilio();
			alumno.domicilio.setDireccion(request.getParameter("TboxDirreccionM"));

			String Localidad = request.getParameter("TboxLocalidadM").toString();
			String Provincia = request.getParameter("TboxProvinciaM").toString();
			Localidad localidad = new Localidad();
			localidad.setID(Integer.parseInt(Localidad));
			Provincia provincia = new Provincia();
			provincia.setID(Integer.parseInt(Provincia));

			alumno.domicilio.setLocalidad(localidad);
			alumno.domicilio.setProvincia(provincia);

			boolean Update;
			Update =aDao.update(alumno);
			
			if(Update == true) {
				request.setAttribute("SweetAlert", "Modificado");
			}
			else {
				request.setAttribute("SweetAlert", "Error");
			}
			List<Alumno> listaAlumnos = (ArrayList<Alumno>) aDao.readAll();
			List<Provincia> listaProvincia = (ArrayList<Provincia>) pDao.readAll();
			List<Localidad> listaLocalidad = (ArrayList<Localidad>) lDao.ListarLocalidades();
			request.setAttribute("ListaAlumnos", listaAlumnos);
			request.setAttribute("ListaProvincia", listaProvincia);
			request.setAttribute("ListaLocalidad", listaLocalidad);
			request.getRequestDispatcher("ListadoAlumnosAdmin.jsp").forward(request, response);
		}
		if(request.getParameter("btnRecuperarAlumno") != null)
		{
			AlumnoDaoImpl rDao= new AlumnoDaoImpl();
			List<Alumno> ListaAlumnosRecup = (ArrayList<Alumno>)rDao.readrecover();
			request.setAttribute("ListaAlumnosRecup", ListaAlumnosRecup);
			request.getRequestDispatcher("RecuperarAlumnos.jsp").forward(request, response);
		}

		if (request.getParameter("BtnAgregar") != null) {
			Alumno alumno = new Alumno();
			alumno.setDni(Integer.parseInt(request.getParameter("TboxDniA").toString()));
			alumno.setNombre(request.getParameter("TboxNombreA"));
			alumno.setApellido(request.getParameter("TboxApellidoA"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date parsed = null;
			try {
				parsed = format.parse(request.getParameter("TboxFechaNacimientoA"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sql = new java.sql.Date(parsed.getTime());
			alumno.setFechaNacimiento(sql);
			alumno.setEmail(request.getParameter("TboxEmailA"));
			alumno.setTelefono(Long.parseLong(request.getParameter("TboxTelefonoA")));

			alumno.domicilio = new Domicilio();
			alumno.domicilio.setDireccion(request.getParameter("TboxDirreccionA"));

			String Localidad = request.getParameter("TboxLocalidadA").toString();
			String Provincia = request.getParameter("TboxProvinciaA").toString();
			Localidad localidad = new Localidad();
			localidad.setID(Integer.parseInt(Localidad));
			Provincia provincia = new Provincia();
			provincia.setID(Integer.parseInt(Provincia));

			alumno.domicilio.setLocalidad(localidad);
			alumno.domicilio.setProvincia(provincia);

			alumno.setEstado(true);
			boolean Insert;
			Insert = aDao.insert(alumno);
			
			if(Insert == true) {
				request.setAttribute("SweetAlert", "Cargado");
			}
			else {
				request.setAttribute("SweetAlert", "Error");
			}
			
			List<Alumno> listaAlumnos = (ArrayList<Alumno>) aDao.readAll();
			List<Provincia> listaProvincia = (ArrayList<Provincia>) pDao.readAll();
			List<Localidad> listaLocalidad = (ArrayList<Localidad>) lDao.ListarLocalidades();
			request.setAttribute("ListaAlumnos", listaAlumnos);
			request.setAttribute("ListaProvincia", listaProvincia);
			request.setAttribute("ListaLocalidad", listaLocalidad);
			request.getRequestDispatcher("ListadoAlumnosAdmin.jsp").forward(request, response);
		}
		
		
		String LegajoAlumno = request.getParameter("LegajoAlumno");
		if (LegajoAlumno != null) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			boolean Delete;
			Delete = aDao.delete(Integer.parseInt(LegajoAlumno));
			
//			if(Delete == true) {
//				request.setAttribute("SweetAlert", "Eliminado");
//			}
//			else {
//				request.setAttribute("SweetAlert", "Error");
//			}			
			Gson gson = new Gson();
			String json = gson.toJson("Exitoso");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		}
//		String algo = request.getParameter("BtnEliminar");
//		if (request.getParameter("BtnEliminar") != null) {
//			int Legajo = Integer.parseInt(request.getParameter("LegajoAlumno"));
//			
//			boolean Delete;
//			Delete = aDao.delete(Legajo);
//			
//			if(Delete == true) {
//				request.setAttribute("SweetAlert", "Eliminado");
//			}
//			else {
//				request.setAttribute("SweetAlert", "Error");
//			}
//
//			List<Alumno> listaAlumnos = (ArrayList<Alumno>) aDao.readAll();
//			List<Provincia> listaProvincia = (ArrayList<Provincia>) pDao.readAll();
//			List<Localidad> listaLocalidad = (ArrayList<Localidad>) lDao.ListarLocalidades();
//			request.setAttribute("ListaAlumnos", listaAlumnos);
//			request.setAttribute("ListaProvincia", listaProvincia);
//			request.setAttribute("ListaLocalidad", listaLocalidad);
//			request.getRequestDispatcher("ListadoAlumnosAdmin.jsp").forward(request, response);
//		}

	}

}
