package Servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.DocenteDaoImpl;
import DaoImpl.UsuarioImpl;
import Entidad.Docente;
import Entidad.Usuario;
import javax.servlet.http.HttpSession;
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String Param= request.getParameter("Param");
			if( request.getParameter("btnIngresar")!=null)
				{
				 	UsuarioImpl usuarioImpl = new UsuarioImpl();
				 	DocenteDaoImpl docImpl = new DocenteDaoImpl();
				 	Docente docente = new Docente();
					String legajo = request.getParameter("TxtLegajo").toString();
					String contrasenia = request.getParameter("TxtContrasenia").toString();
					HttpSession session = request.getSession();
					session.setAttribute("Legajo",legajo);
					int validador =usuarioImpl.Validar(legajo,contrasenia);
					docente = docImpl.Buscar(legajo);
					session.setAttribute("NombreHead",docente.getNombre().toString());
					session.setAttribute("ApellidoHead",docente.getApellido().toString());
					if(validador==1)
					{
						request.getRequestDispatcher("ServeletCurso?ParamLogin=1").forward( request, response);
					}
					else if(validador==2)
					{
						request.getRequestDispatcher("ServeletCurso?ParamLogin=2").forward( request, response);
					}
					else if(validador==0)
					{
						request.getRequestDispatcher("Login.jsp").forward( request, response);
					}
					
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
