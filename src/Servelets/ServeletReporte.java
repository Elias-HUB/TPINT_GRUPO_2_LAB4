package Servelets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.CursoDaoImpl;
import DaoImpl.MateriaDaoImpl;
import Entidad.Alumno;
import Entidad.Curso;
import Entidad.Localidad;
import Entidad.Materia;
import Entidad.Provincia;

/**
 * Servlet implementation class ServeletReporte
 */
@WebServlet("/ServeletReporte")
public class ServeletReporte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServeletReporte() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MateriaDaoImpl mDao = new MateriaDaoImpl();

		if (request.getParameter("Param") != null) {

			List<Materia> listaMateria = (ArrayList<Materia>) mDao.readAll();
			request.setAttribute("ListaMaterias", listaMateria);
			request.getRequestDispatcher("Reportes.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MateriaDaoImpl mDao = new MateriaDaoImpl();
		CursoDaoImpl cDao = new CursoDaoImpl();
		if (request.getParameter("BtnReporte") != null) {
			String TipoReporte = request.getParameter("selectTipoReporte").toString();
			String Materia = request.getParameter("selectTipoMateria").toString();
			String Cuatrimestre = request.getParameter("selectTipoCuatrimestre").toString();
			String Anio = request.getParameter("selectTipoAnio").toString();		
			String Mensaje = "";
			if (TipoReporte.equals("1")) {
				Mensaje += "Porcentaje aprobados por materia - ";
				String tabla = cDao.ReporteAprobadoPorMateria(Materia, Cuatrimestre, Anio);
				request.setAttribute("TablaReporteAprobadoPorMateria", tabla);
			} else if (TipoReporte.equals("2")) {
				Mensaje += "Porcentaje estado por curso - ";
				String tabla = cDao.ReporteEstadoCurso(Materia, Cuatrimestre, Anio);
				request.setAttribute("TablaReporteEstadoCurso", tabla);
			} else if (TipoReporte.equals("3")) {
				Mensaje += "Cantidad de alumnos por materia - ";
				String tabla = cDao.ReporteAlumnosPorMateria(Materia, Cuatrimestre, Anio);
				request.setAttribute("TablaReporteAlumnosPorMateria", tabla);
			}
			
			
			if (Materia.equals("Todas")) {
				Mensaje += " Todas - ";
			} else {
				Materia materia = new Materia();
				materia = mDao.ReadMateria(Integer.parseInt(Materia));
				Mensaje += materia.getNombre() + " - ";							
			}
			if (Cuatrimestre.equals("-1")) {
				Mensaje += " Todos - ";
			} else {
				Mensaje += (Cuatrimestre + "° Cuatrimestre - ");		
			}
			if (Anio.equals("-1")) {
				Mensaje += " Todos";		
			} else {
				Mensaje += Anio;
			}
			List<Materia> listaMateria = (ArrayList<Materia>) mDao.readAll();
			request.setAttribute("ListaMaterias", listaMateria);
			request.setAttribute("Mensaje", Mensaje);
			
			request.getRequestDispatcher("Reportes.jsp").forward(request, response);
		}
	}

}
