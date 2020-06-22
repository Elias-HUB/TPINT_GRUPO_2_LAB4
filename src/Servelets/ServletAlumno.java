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

import DaoImpl.AlumnoDaoImpl;
import Entidad.Alumno;
import Entidad.Domicilio;

@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAlumno() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("Param") != null) {
			AlumnoDaoImpl aDao = new AlumnoDaoImpl();
			
			List<Alumno> listaAlumnos = (ArrayList<Alumno>) aDao.readAll();
			request.setAttribute("ListaAlumnos", listaAlumnos);
			request.getRequestDispatcher("ListadoAlumnosAdmin.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AlumnoDaoImpl aDao = new AlumnoDaoImpl();
		
		if (request.getParameter("BtnEliminar") != null) {
			int Legajo = Integer.parseInt(request.getParameter("LegajoAlumno"));
			aDao.delete(Legajo);
			
			List<Alumno> listaAlumnos = (ArrayList<Alumno>) aDao.readAll();
			request.setAttribute("ListaAlumnos", listaAlumnos);
			request.getRequestDispatcher("ListadoAlumnosAdmin.jsp").forward(request, response);
		}
		
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
			alumno.setTelefono((long) Integer.parseInt(request.getParameter("TboxTelefonoM")));
			alumno.setDni(Integer.parseInt(request.getParameter("TboxDniM")));
			alumno.setEstado(true);

			alumno.domicilio = new Domicilio();
			alumno.domicilio.setDireccion(request.getParameter("TboxDirreccionM"));
			alumno.domicilio.setLocalidad(request.getParameter("TboxLocalidadM"));
			alumno.domicilio.setProvincia(request.getParameter("TboxProvinciaM"));

			
			aDao.update(alumno);		
			List<Alumno> listaAlumnos = (ArrayList<Alumno>) aDao.readAll();
			request.setAttribute("ListaAlumnos", listaAlumnos);
			request.getRequestDispatcher("ListadoAlumnosAdmin.jsp").forward(request, response);			
		}
		
		
		if (request.getParameter("BtnAgregar") != null) {
			Alumno alumno = new Alumno();
//			alumno.setLegajo(Integer.parseInt(request.getParameter("TboxLegajoM")));
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
			alumno.setTelefono((long) Integer.parseInt(request.getParameter("TboxTelefonoA")));
			
			alumno.setEstado(true);

			alumno.domicilio = new Domicilio();
			alumno.domicilio.setDireccion(request.getParameter("TboxDirreccionA"));
			alumno.domicilio.setLocalidad(request.getParameter("TboxLocalidadA"));
			alumno.domicilio.setProvincia(request.getParameter("TboxProvinciaA"));
			alumno.setEstado(true);
			
			aDao.insert(alumno);		
			List<Alumno> listaAlumnos = (ArrayList<Alumno>) aDao.readAll();
			request.setAttribute("ListaAlumnos", listaAlumnos);
			request.getRequestDispatcher("ListadoAlumnosAdmin.jsp").forward(request, response);			
		}

		// response.setContentType( "text/html; charset=iso-8859-1" );
		//// response.setContentType("text/plain");
		// PrintWriter out = response.getWriter();
		//
		// String fullname = request.getParameter("fullname");
		//// String apellido = request.getParameter("apellido");
		//
		// Alumno alumno = new Alumno();
		// alumno.setNombre("Elias");
		// out.println(alumno);
		//// out.print(alumno);
		//// out.println("Hello" + alumno.getNombre());
		//// doGet(request, response);
	}

}
