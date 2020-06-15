package Servelest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DocenteDao;
import DaoImpl.DocenteDaoImpl;
import Entidad.Docente;

/**
 * Servlet implementation class ServletDocente
 */
@WebServlet("/ServletDocente")
public class ServletDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletDocente() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnMostrar")!=null)
		{
			DocenteDaoImpl dDao = new DocenteDaoImpl();
			List <Docente> listaDocentes = (ArrayList<Docente>)dDao.readAll();
			
			request.setAttribute("ListaDoc",listaDocentes );
			
			RequestDispatcher rd = request.getRequestDispatcher("ListadoDocentes.jsp");
			rd.forward( request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btnMostrar")!=null)
		{
			DocenteDaoImpl dDao = new DocenteDaoImpl();
			List <Docente> listaDocentes = (ArrayList<Docente>)dDao.readAll();
			
			request.setAttribute("ListaDoc",listaDocentes );
			
			RequestDispatcher rd = request.getRequestDispatcher("ListadoDocentes.jsp");
			rd.forward( request, response);
		}
		
		
	}

}
