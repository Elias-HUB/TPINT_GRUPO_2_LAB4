package Servelets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoImpl.AlumnoDaoImpl;
import DaoImpl.NotaDaoImpl;
import Entidad.Alumno;
import Entidad.Calificacion;

/**
 * Servlet implementation class ServletNota
 */
@WebServlet("/ServletNota")
public class ServletNota extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletNota() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		NotaDaoImpl nDao = new NotaDaoImpl();
		AlumnoDaoImpl aDao = new AlumnoDaoImpl();
		if (request.getParameter("ParamAlumnoXCursoDocente") != null) {
			String Curso = request.getParameter("ParamAlumnoXCursoDocente").toString();
			int curso = Integer.parseInt(Curso);
			session.setAttribute("CursoNotas", curso);
			List<Calificacion> ListaCalificaciones = (ArrayList<Calificacion>) nDao.readNotasXAlumno(curso);
			request.setAttribute("ListaCalificaciones", ListaCalificaciones);
			request.getRequestDispatcher("AlumnosPorCursoDocente.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		NotaDaoImpl nDao = new NotaDaoImpl();
		AlumnoDaoImpl aDao = new AlumnoDaoImpl();
		if (request.getParameter("btnCalificar") != null) {
			// String Calificacion ;
			String[] Calificaciones;
			int Contador = 0;
			request.getParameter("Alumno");
			request.getParameter("slEstado");
			Calificaciones = request.getParameterValues("CalificacionAlumno");
			if (Calificaciones != null) {
				for (int i = 0; i < Calificaciones.length; i += 7) {
					Calificacion calificacion = new Calificacion();
					Alumno alumno = new Alumno();
					alumno.setLegajo(Integer.parseInt(Calificaciones[i + 0]));
					calificacion.setAlumno(alumno);

					// Parcial1
					if (Calificaciones[i + 1].equals("")) {
						calificacion.setParcial1(0);
					} else {
						calificacion.setParcial1(Integer.parseInt(Calificaciones[i + 1]));
					}

					// Parcial2
					if (Calificaciones[i + 2].equals(""))
						calificacion.setParcial2(0);
					else
						calificacion.setParcial2(Integer.parseInt(Calificaciones[i + 2]));

					// Recu1
					if (Calificaciones[i + 3].equals(""))
						calificacion.setRecu1(0);
					else
						calificacion.setRecu1(Integer.parseInt(Calificaciones[i + 3]));

					// Recu2
					if (Calificaciones[i + 4].equals(""))
						calificacion.setRecu2(0);
					else
						calificacion.setRecu2(Integer.parseInt(Calificaciones[i + 4]));

					// Notafinal
					if (Calificaciones[i + 5].equals(""))
						calificacion.setNotafinal(0);
					else
						calificacion.setNotafinal(Integer.parseInt(Calificaciones[i + 5]));

					calificacion.setEstado(Calificaciones[i + 6]);
					String Curso = session.getAttribute("CursoNotas").toString();
					int curso = Integer.parseInt(Curso);
					calificacion.setIdCurso(curso);

					nDao.update(calificacion);
				}
			}
			List<Calificacion> ListaCalificaciones = (ArrayList<Calificacion>) nDao
					.readNotasXAlumno(Integer.parseInt(session.getAttribute("CursoNotas").toString()));
			request.setAttribute("ListaCalificaciones", ListaCalificaciones);
			request.setAttribute("SweetAlert","Cargado");
			request.getRequestDispatcher("AlumnosPorCursoDocente.jsp").forward(request, response);
		}

		// doGet(request, response);
	}

}
