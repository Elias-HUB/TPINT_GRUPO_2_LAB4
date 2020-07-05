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
import DaoImpl.MateriaDaoImpl;
import DaoImpl.UsuarioImpl;
import Entidad.Curso;
import Entidad.Docente;
import Entidad.Materia;

import javax.servlet.http.HttpSession;
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// LISTAR CUANDO HACEN CLICK EN LA IMAGEN
		if(request.getParameter("LogoHead")!=null)
		{
			int aux = Integer.parseInt(request.getParameter("LogoHead").toString());
			if (aux==2) {
				CursoDaoImpl cDao = new CursoDaoImpl();
				HttpSession session = request.getSession();
				int legajoD = Integer.parseInt(session.getAttribute("Legajo").toString());
				List<Curso> listaCursos = (ArrayList<Curso>) cDao.readCursosXDocente(legajoD);
				request.setAttribute("ListaCursos", listaCursos);
				request.getRequestDispatcher("MenuPrincipalDocente.jsp").forward(request, response);
			}
			else if (aux==1) {
				CursoDaoImpl cDao = new CursoDaoImpl();
				List<Curso> listaCursos = (ArrayList<Curso>) cDao.readAll();
				MateriaDaoImpl mDao = new MateriaDaoImpl();
				List<Materia> listaMaterias = (ArrayList<Materia>)mDao.readAll();
				DocenteDaoImpl dDao = new DocenteDaoImpl(); 
				List<Docente> listaDocentes = (ArrayList<Docente>)dDao.readAll();
				request.setAttribute("ListaCursos", listaCursos);
				request.setAttribute("ListaMaterias", listaMaterias);
				request.setAttribute("ListaDocentes",listaDocentes);
				request.getRequestDispatcher("MenuPrincipalAdmin.jsp").forward(request, response);
			}
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursoDaoImpl cDao = new CursoDaoImpl();
		if( request.getParameter("btnIngresar")!=null)
		{
		 	UsuarioImpl usuarioImpl = new UsuarioImpl();
		 	DocenteDaoImpl docImpl = new DocenteDaoImpl();
		 	Docente docente = new Docente();
			String legajo = request.getParameter("TxtLegajo").toString();
			String contrasenia = request.getParameter("TxtContrasenia").toString();
			HttpSession session = request.getSession(true);
			
			int validador =usuarioImpl.read(legajo,contrasenia);
			
			if(validador==1 || validador==2)
			{
				session.setAttribute("Legajo",legajo);
				docente = docImpl.Buscar(legajo);
				session.setAttribute("NombreHead",docente.getNombre().toString());
				session.setAttribute("ApellidoHead",docente.getApellido().toString());
			}
			
			if (validador==1){
				
						List<Curso> listaCursos = (ArrayList<Curso>) cDao.readAll();
						MateriaDaoImpl mDao = new MateriaDaoImpl();
						List<Materia> listaMaterias = (ArrayList<Materia>)mDao.readAll();
						DocenteDaoImpl dDao = new DocenteDaoImpl(); 
						List<Docente> listaDocentes = (ArrayList<Docente>)dDao.readAll();
						request.setAttribute("ListaCursos", listaCursos);
						request.setAttribute("ListaMaterias", listaMaterias);
						request.setAttribute("ListaDocentes",listaDocentes);
						request.getRequestDispatcher("MenuPrincipalAdmin.jsp").forward(request, response);
					} 
			else if (validador==2) {
				
						int legajoD = Integer.parseInt(request.getParameter("TxtLegajo").toString());
						List<Curso> listaCursos = (ArrayList<Curso>) cDao.readCursosXDocente(legajoD);

						request.setAttribute("ListaCursos", listaCursos);

						request.getRequestDispatcher("MenuPrincipalDocente.jsp").forward(request, response);
					}
			else {
				request.setAttribute("LoginInvalido","LoginInvalido");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			if(request.getParameter("LogoHead")!=null)
			{
				int aux = Integer.parseInt(request.getParameter("LogoHead").toString());
				if (aux==2) {
					CursoDaoImpl cDao = new CursoDaoImpl();
					int legajoD = (int) session.getAttribute("Legajo");
					List<Curso> listaCursos = (ArrayList<Curso>) cDao.readCursosXDocente(legajoD);
					request.setAttribute("ListaCursos", listaCursos);
					request.getRequestDispatcher("MenuPrincipalDocente.jsp").forward(request, response);
				}
			}
		}
	}

}
