package Servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.UsuarioImpl;
import Entidad.Usuario;

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
					//Usuario usuario = new Usuario();
					String legajo = request.getParameter("TxtLegajo").toString();
					String contrasenia = request.getParameter("TxtContrasenia").toString();
					//usuario= usuarioImpl.Validar(legajo,contraseña);
					
					if(usuarioImpl.Validar(legajo,contrasenia))
					{
						request.getRequestDispatcher("ServeletCurso?Param=4").forward( request, response);
					}
					else
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
