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

import DaoImpl.CursoDaoImpl;
import Entidad.Curso;

/**
 * Servlet implementation class ServeletCurso
 */
@WebServlet("/ServeletCurso")
public class ServeletCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServeletCurso() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ParamLogin = request.getParameter("ParamLogin");
		String ParamListar = request.getParameter("Param");
		
		if (request.getParameter("ParamLogin") != null) {
			if (ParamLogin.equals("1")) {
				CursoDaoImpl cDao = new CursoDaoImpl();
				List<Curso> listaCursos = (ArrayList<Curso>) cDao.readAll();

				request.setAttribute("ListaCursos", listaCursos);

				request.getRequestDispatcher("MenuPrincipalAdmin.jsp").forward(request, response);
			} else {
				CursoDaoImpl cDao = new CursoDaoImpl();
				int legajo = Integer.parseInt(request.getParameter("TxtLegajo").toString());
				List<Curso> listaCursos = (ArrayList<Curso>) cDao.readCursosXDocente(legajo);

				request.setAttribute("ListaCursos", listaCursos);

				request.getRequestDispatcher("MenuPrincipalDocente.jsp").forward(request, response);
			}
		}
	
		if (request.getParameter("Param") != null) {
			if (ParamListar.equals("1")) {
				CursoDaoImpl cDao = new CursoDaoImpl();
				List<Curso> listaCursos = (ArrayList<Curso>) cDao.readAll();

				request.setAttribute("ListaCursosAdmin", listaCursos);

				request.getRequestDispatcher("ListadoCursosAdmin.jsp").forward(request, response);
			} else {
				CursoDaoImpl cDao = new CursoDaoImpl();
				HttpSession session = request.getSession();
				int legajo = Integer.parseInt(session.getAttribute("Legajo").toString());
				List<Curso> listaCursos = (ArrayList<Curso>) cDao.readCursosXDocente(legajo);

				request.setAttribute("ListaCursosDocente", listaCursos);

				request.getRequestDispatcher("ListadoCursosDocente.jsp").forward(request, response);
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
