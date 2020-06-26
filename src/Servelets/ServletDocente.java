package Servelets;

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
import DaoImpl.AlumnoDaoImpl;
import DaoImpl.DocenteDaoImpl;
import DaoImpl.LocalidadDaoImpl;
import DaoImpl.ProvinciaDaoImpl;
import Entidad.Alumno;
import Entidad.Docente;
import Entidad.Localidad;
import Entidad.Provincia;

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

		doGet(request, response);
		
	}

}
