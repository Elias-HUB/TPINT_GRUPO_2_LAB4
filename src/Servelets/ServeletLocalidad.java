package Servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DaoImpl.LocalidadDaoImpl;
import Entidad.Localidad;

/**
 * Servlet implementation class ServeletLocalidad
 */
@WebServlet("/ServeletLocalidad")
public class ServeletLocalidad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServeletLocalidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.setContentType( "text/html; charset=iso-8859-1" );
		LocalidadDaoImpl daoImpl = new LocalidadDaoImpl();
		// response.setContentType("text/plain");

		//

		String Provinciaid = request.getParameter("Provinciaid");
		if (Provinciaid != null) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			List<Localidad> listalocalidades = (ArrayList<Localidad>) daoImpl
					.ListarLocalidadesProvincia(Integer.parseInt(Provinciaid));

			Gson gson = new Gson();
			String json = gson.toJson(listalocalidades);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		}
	}

}
