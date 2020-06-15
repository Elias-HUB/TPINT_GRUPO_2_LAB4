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

import DaoImpl.AlumnoDaoImpl;
import Entidad.Alumno;


@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ServletAlumno() {
        super();
    }
    
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("Param")!=null)
		{
			AlumnoDaoImpl aDao = new AlumnoDaoImpl();
			List <Alumno> listaAlumnos = (ArrayList<Alumno>)aDao.readAll();
			
			request.setAttribute("ListaAlumnos",listaAlumnos );
			
			request.getRequestDispatcher("ListadoAlumnosAdmin.jsp").forward( request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    	AlumnoDaoImpl aDao = new AlumnoDaoImpl();
				List <Alumno> listaAlumnos = (ArrayList<Alumno>)aDao.readAll();
				
				request.setAttribute("ListaAlumnos",listaAlumnos );
				
				RequestDispatcher rd = request.getRequestDispatcher("/ListadoAlumnosAdmin.jsp");
				rd.forward( request, response);
		
	}

}
