package Servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import DaoImpl.AlumnoDaoImpl;
import DaoImpl.DocenteDaoImpl;
import DaoImpl.LocalidadDaoImpl;
import DaoImpl.MateriaDaoImpl;
import DaoImpl.ProvinciaDaoImpl;
import DaoImpl.TutoriaDaoImpl;
import DaoImpl.UsuarioImpl;
import Entidad.Alumno;
import Entidad.Docente;
import Entidad.Domicilio;
import Entidad.Localidad;
import Entidad.Materia;
import Entidad.Provincia;
import Entidad.Usuario;
import Entidad.Tutoria;

@WebServlet("/ServletTutoria")
public class ServletTutoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletTutoria() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DocenteDaoImpl dDao = new DocenteDaoImpl();
		AlumnoDaoImpl aDao = new AlumnoDaoImpl();
		TutoriaDaoImpl tDao = new TutoriaDaoImpl();
		
		if(request.getParameter("Param")!=null)
		{			
			List <Docente> listaDocentes = (ArrayList<Docente>)dDao.readAll();
			List<Alumno> listaAlumnos = (ArrayList<Alumno>) aDao.readTutoria();
			List<Alumno> listaAlumnosTodos = (ArrayList<Alumno>) aDao.readAllTutoria();
			List<Tutoria> listaTutoria = (ArrayList<Tutoria>) tDao.readAll();
			request.setAttribute("ListaDocentes",listaDocentes );
			request.setAttribute("ListaAlumnos", listaAlumnos);
			request.setAttribute("ListaAlumnosTodos", listaAlumnosTodos);
			request.setAttribute("ListaTutoria", listaTutoria);
			request.getRequestDispatcher("TutoriaAdmin.jsp").forward( request, response);
		}
		if(request.getParameter("Param1")!=null)
		{			
			HttpSession session = request.getSession();
			String Docente = session.getAttribute("Legajo").toString();
			int legajoDocente = Integer.parseInt(Docente);
			
			List<Alumno> listaAlumnosTodos = (ArrayList<Alumno>) aDao.readAllTutoria();
			List<Tutoria> listaTutoriaDoc = (ArrayList<Tutoria>) tDao.readAllDoc(legajoDocente);

			request.setAttribute("ListaAlumnosTodos", listaAlumnosTodos);
			request.setAttribute("ListaTutoriaDoc", listaTutoriaDoc);
			request.getRequestDispatcher("TutoriaDoc.jsp").forward( request, response);
		}
		if(request.getParameter("ParamLegajoDocente") != null && request.getParameter("ParamLegajoAlumno") != null)
		{
			String StringlegajoDocente = request.getParameter("ParamLegajoDocente");
			String StringlegajoAlumno = request.getParameter("ParamLegajoAlumno");
			int legajoDocente = Integer.parseInt(StringlegajoDocente);
			int legajoAlumno = Integer.parseInt(StringlegajoAlumno);;
			boolean borrarTutoria = tDao.delete(legajoDocente, legajoAlumno);
			
			if(borrarTutoria == true ) {
				request.setAttribute("SweetAlert", "Eliminado");
			}
			else {
				request.setAttribute("SweetAlert", "Error");
			}
			List <Docente> listaDocentes = (ArrayList<Docente>)dDao.readAll();
			List<Alumno> listaAlumnos = (ArrayList<Alumno>) aDao.readTutoria();
			List<Alumno> listaAlumnosTodos = (ArrayList<Alumno>) aDao.readAllTutoria();
			List<Tutoria> listaTutoria = (ArrayList<Tutoria>) tDao.readAll();
			request.setAttribute("ListaDocentes",listaDocentes );
			request.setAttribute("ListaAlumnos", listaAlumnos);
			request.setAttribute("ListaAlumnosTodos", listaAlumnosTodos);
			request.setAttribute("ListaTutoria", listaTutoria);
			request.getRequestDispatcher("TutoriaAdmin.jsp").forward( request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Tutoria tutoria = new Tutoria();
		DocenteDaoImpl dDao = new DocenteDaoImpl();
		AlumnoDaoImpl aDao = new AlumnoDaoImpl();
		TutoriaDaoImpl tDao = new TutoriaDaoImpl();

		if (request.getParameter("BtnAsignarTutor") != null) {
			
			int LegajoDoc=Integer.parseInt(request.getParameter("slDocente").toString());
			int LegajoAlumno=Integer.parseInt(request.getParameter("slAlumno").toString());
			tutoria.setLegajoDocente(LegajoDoc);
			tutoria.setLegajoAlumno(LegajoAlumno);
			tutoria.setObservaciones("");
			tutoria.setEstado(true);
			
			if (tDao.ExisteAlta(LegajoDoc, LegajoAlumno) == 0 && tDao.ExisteBaja( LegajoDoc, LegajoAlumno)==0) 
			{
				boolean Insert = tDao.insert(tutoria);
				
				if(Insert == true) {
					request.setAttribute("SweetAlert", "Cargado");
				}
				else {
					request.setAttribute("SweetAlert", "Error");
				}
			}
			else if (tDao.ExisteBaja( LegajoDoc, LegajoAlumno)>0 && tDao.ExisteAlta(LegajoDoc, LegajoAlumno) == 0) 
			{
				boolean Update = tDao.update(LegajoDoc, LegajoAlumno);
				if(Update == true) {
					request.setAttribute("SweetAlert", "Cargado");
				}
				else {
					request.setAttribute("SweetAlert", "Error");
				}
			}
			else if (tDao.ExisteAlta(LegajoDoc, LegajoAlumno)>0 && tDao.ExisteBaja( LegajoDoc, LegajoAlumno)==0) 
			{
				request.setAttribute("SweetAlert", "Existe");
			}
			List <Docente> listaDocentes = (ArrayList<Docente>)dDao.readAll();
			List<Alumno> listaAlumnos = (ArrayList<Alumno>) aDao.readTutoria();
			List<Alumno> listaAlumnosTodos = (ArrayList<Alumno>) aDao.readAllTutoria();
			List<Tutoria> listaTutoria = (ArrayList<Tutoria>) tDao.readAll();
			request.setAttribute("ListaDocentes",listaDocentes );
			request.setAttribute("ListaAlumnos", listaAlumnos);
			request.setAttribute("ListaAlumnosTodos", listaAlumnosTodos);
			request.setAttribute("ListaTutoria", listaTutoria);
			request.getRequestDispatcher("TutoriaAdmin.jsp").forward( request, response);



		}
		
		
		
		

	}
}