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
import DaoImpl.DocenteDaoImpl;
import DaoImpl.UsuarioImpl;
import Entidad.Curso;
import Entidad.Docente;
import javax.servlet.http.HttpSession;
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // String Param= request.getParameter("Param");
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if( request.getParameter("btnIngresar")!=null)
		{
		 	UsuarioImpl usuarioImpl = new UsuarioImpl();
		 	DocenteDaoImpl docImpl = new DocenteDaoImpl();
		 	Docente docente = new Docente();
			String legajo = request.getParameter("TxtLegajo").toString();
			String contrasenia = request.getParameter("TxtContrasenia").toString();
			HttpSession session = request.getSession(true);
			session.setAttribute("Legajo",legajo);
			int validador =usuarioImpl.read(legajo,contrasenia);
			docente = docImpl.Buscar(legajo);
			session.setAttribute("NombreHead",docente.getNombre().toString());
			session.setAttribute("ApellidoHead",docente.getApellido().toString());
			
			if (validador==1){
				
						CursoDaoImpl cDao = new CursoDaoImpl();
						List<Curso> listaCursos = (ArrayList<Curso>) cDao.readAll();

						request.setAttribute("ListaCursos", listaCursos);

						request.getRequestDispatcher("MenuPrincipalAdmin.jsp").forward(request, response);
					} 
			else if (validador==2) {
				
						CursoDaoImpl cDao = new CursoDaoImpl();
						int legajoD = Integer.parseInt(request.getParameter("TxtLegajo").toString());
						List<Curso> listaCursos = (ArrayList<Curso>) cDao.readCursosXDocente(legajoD);

						request.setAttribute("ListaCursos", listaCursos);

						request.getRequestDispatcher("MenuPrincipalDocente.jsp").forward(request, response);
					}
			else {
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			
			
		}
	}

}
