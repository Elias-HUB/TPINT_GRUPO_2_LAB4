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
import Entidad.Curso;

/**
 * Servlet implementation class ServeletCurso
 */
@WebServlet("/ServeletCurso")
public class ServeletCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ServeletCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 String Param= request.getParameter("Param");
		if(Param.equals("3"))
			{
			 	CursoDaoImpl cDao = new CursoDaoImpl();
				List <Curso> listaCursos = (ArrayList<Curso>)cDao.readAll();
				
				request.setAttribute("ListaCursos",listaCursos );
				
				request.getRequestDispatcher("ListadoCursosAdmin.jsp").forward( request, response);
			}
		else if(Param.equals("4"))
		{
			CursoDaoImpl cDao = new CursoDaoImpl();
			List <Curso> listaCursos = (ArrayList<Curso>)cDao.readAll();
			
			request.setAttribute("ListaCursos",listaCursos );
			
			request.getRequestDispatcher("MenuPrincipalAdmin.jsp").forward( request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
