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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import DaoImpl.AlumnoDaoImpl;
import DaoImpl.CursoDaoImpl;
import DaoImpl.DocenteDaoImpl;
import DaoImpl.MateriaDaoImpl;
import DaoImpl.NotaDaoImpl;
import Entidad.Alumno;
import Entidad.Calificacion;
import Entidad.Curso;
import Entidad.Docente;
import Entidad.Materia;

/**
 * Servlet implementation class ServeletCurso
 */
@WebServlet("/ServeletCurso")
public class ServeletCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServeletCurso() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String ParamListar = request.getParameter("Param");
		CursoDaoImpl cDao = new CursoDaoImpl();
		// LISTAR TODOS LOS CURSOS PARA EL ADMIN
		if (request.getParameter("Param") != null) {
			if (ParamListar.equals("1")) {
				List<Curso> listaCursos = (ArrayList<Curso>) cDao.readAll();
				request.setAttribute("ListaCursosAdmin", listaCursos);				

				request.getRequestDispatcher("ListadoCursosAdmin.jsp").forward(request, response);
			}

			// LISTAR LOS CURSOS PARA UN DOCENTE LOGUEADO
			else if (ParamListar.equals("2")) {
				int legajo = Integer.parseInt(session.getAttribute("Legajo").toString());
				List<Curso> listaCursos = (ArrayList<Curso>) cDao.readCursosXDocente(legajo);
				request.setAttribute("ListaCursosDocente", listaCursos);
				request.getRequestDispatcher("ListadoCursosDocente.jsp").forward(request, response);
			}
		}

		// BOTON PARA ABRIR LA MODIFICACION DE UN CURSO
		if (request.getParameter("ParamModificarCurso") != null) {
			MateriaDaoImpl mDao = new MateriaDaoImpl();
			List<Materia> listaMaterias = (ArrayList<Materia>) mDao.readAll();
			DocenteDaoImpl dDao = new DocenteDaoImpl();
			List<Docente> listaDocentes = (ArrayList<Docente>) dDao.readAll();
			AlumnoDaoImpl aDao = new AlumnoDaoImpl();
			String aux = request.getParameter("ParamModificarCurso").toString();
			int cursoMod = Integer.parseInt(aux);
			session.setAttribute("CursoModificar", cursoMod);
			CursoDaoImpl cdao = new CursoDaoImpl();
			Curso curso = cdao.BuscarCurso(cursoMod);
			// String doc = String.valueOf(curso.docente.get)
			List<Alumno> listaAlumnosCurso = (ArrayList<Alumno>) aDao.readAlumnosXCurso(cursoMod);
			List<Alumno> listaAlumnosTodos = (ArrayList<Alumno>) aDao.readAll();
			session.setAttribute("CursoMod", curso);
			request.setAttribute("ListaAlumnosCurso", listaAlumnosCurso);
			request.setAttribute("ListaAlumnosTodos", listaAlumnosTodos);
			request.setAttribute("ListaDocentes", listaDocentes);
			request.setAttribute("ListaMaterias", listaMaterias);
			request.getRequestDispatcher("ModificarCurso.jsp").forward(request, response);
		}
			//PARAMETRO PARA RECUPERAR CURSO
		
		if(request.getParameter("ParamRecuperar")!=null)
		{
			String IDRecupero = request.getParameter("ParamRecuperar");
			int intRecupero = Integer.parseInt(IDRecupero); 
			cDao.Recuperar(intRecupero);
			request.setAttribute("SweetAlert", "Recuperado" );
			List<Curso> listaCursos = (ArrayList<Curso>) cDao.readBajas();
			request.setAttribute("ListaCursosRecuperar", listaCursos);
			request.setAttribute("Mensaje", "Recuperado");
			request.getRequestDispatcher("RecuperarCurso.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// BOTON PARA QUE SE ABRA LA PANTALLA DAR DE ALTA UN CURSO Y ELEGIR ALUMNOS
		HttpSession session = request.getSession();
		NotaDaoImpl ndao = new NotaDaoImpl();
		CursoDaoImpl cursoImpl = new CursoDaoImpl();

		AlumnoDaoImpl aDao = new AlumnoDaoImpl();
		if(request.getParameter("btnAgregarCurso") != null)
		{
			MateriaDaoImpl mDao = new MateriaDaoImpl();
			List<Materia> listaMaterias = (ArrayList<Materia>)mDao.readAll();
			DocenteDaoImpl dDao = new DocenteDaoImpl(); 
			List<Docente> listaDocentes = (ArrayList<Docente>)dDao.readAll();
			List<Alumno> listaAlumnos = (ArrayList<Alumno>)aDao.readAll();
			request.setAttribute("ListaAlumnos", listaAlumnos);
			request.setAttribute("ListaDocentes", listaDocentes);
			request.setAttribute("ListaMaterias", listaMaterias);
			request.getRequestDispatcher("AltaCurso.jsp").forward(request, response);
		}
// BOTON PARA QUE SE GUARDE EN LA BD EL CURSO NUEVO
		if(request.getParameter("btnGuardarCurso") != null)
	    {
			Curso curso = new Curso();		
			String[] AlumnosXCurso; 
			curso.setCuatrimestre(Integer.parseInt(request.getParameter("slCuatrimestre").toString()));
			curso.docente = new Docente();
			curso.docente.setLegajo(Integer.parseInt(request.getParameter("slDocente").toString()));
			curso.Materia = new Materia();
			curso.Materia.setIdMateria(Integer.parseInt(request.getParameter("slMateria").toString()));
			curso.setAño(Integer.parseInt(request.getParameter("slAnio").toString()));
			curso.setTurno((request.getParameter("slTurno").toString()));
			curso.setEstado("1");
			boolean insert= cursoImpl.insert(curso);
			AlumnosXCurso = request.getParameterValues("cboxAlumno");
			int ultimoCurso = cursoImpl.DevuelveUltimoCurso();
			for (int x=0; x<AlumnosXCurso.length;x++)
			{
				cursoImpl.insertAlumnosPorCurso(ultimoCurso,AlumnosXCurso[x]);
				ndao.insert(AlumnosXCurso[x], ultimoCurso);				
			} 

			List<Curso> listaCursos = (ArrayList<Curso>) cursoImpl.readAll();
			request.setAttribute("ListaCursosAdmin", listaCursos);
			if(insert==true)
			{
				request.setAttribute("SweetAlert", "Cargado" );
			}
			else {
				request.setAttribute("SweetAlert", "Error" );
			}
			request.getRequestDispatcher("ListadoCursosAdmin.jsp").forward(request, response);
		}    
		//BOTON PARA FILTRO DEL MENU PRINCIPAL
		if(request.getParameter("btnBuscar")!=null)
		{
			CursoDaoImpl cDao = new CursoDaoImpl();
			int legajo= (Integer.parseInt(request.getParameter("slDocente").toString()));
			MateriaDaoImpl mDao = new MateriaDaoImpl();
			List<Materia> listaMaterias = (ArrayList<Materia>) mDao.readAll();
			DocenteDaoImpl dDao = new DocenteDaoImpl();
			List<Docente> listaDocentes = (ArrayList<Docente>) dDao.readAll();

			String Materia = request.getParameter("slMateria").toString();
			String Cuatrimestre = request.getParameter("slCuatrimestre").toString();
			String Anio = request.getParameter("slAnio").toString();
			String Turno = request.getParameter("slTurno").toString();
			String Docente = request.getParameter("slDocente").toString();
			Docente docente = new Docente();
			docente = dDao.Buscar(Docente);
			String Mensaje = "";
			List<Curso> listaCursos = (ArrayList<Curso>) cDao.readMenuAdmin(Docente, Materia, Cuatrimestre, Anio,
					Turno);

			if (Materia.equals("0")) {
				Mensaje += "Materia: Todas - ";
			} else {
				Materia materia = new Materia();
				materia = mDao.ReadMateria(Integer.parseInt(Materia));
				Mensaje += "Materia: " + materia.getNombre() + " - ";
			}
			if (Cuatrimestre.equals("0")) {
				Mensaje += "Cuatrimestre: Todos - ";
			} else {
				Mensaje += (Cuatrimestre + "Año Cuatrimestre - ");
			}
			if (Anio.equals("0")) {
				Mensaje += "Año: Todos - ";
			} else {
				Mensaje += ("Año: " + Anio + " - ");
			}
			if (Turno.equals("0")) {
				Mensaje += "Turno: Todos - ";
			} else {
				Mensaje += ("Turno: " + Turno + " - ");
			}
			if (Docente.equals("0")) {
				Mensaje += "Docente: Todos";
			} else {
				Mensaje += ("Docente: " + docente.getApellido() + " " + docente.getNombre());
			}

			request.setAttribute("Mensaje", Mensaje);
			request.setAttribute("ListaCursos", listaCursos);
			request.setAttribute("ListaMaterias", listaMaterias);
			request.setAttribute("ListaDocentes", listaDocentes);
			request.getRequestDispatcher("MenuPrincipalAdmin.jsp").forward(request, response);
		}
		
		//BOTON PARA FILTRO DEL MENU PRINCIPAL DOCENTE
		if(request.getParameter("btnBuscarDOCENTE")!=null)
		{
			CursoDaoImpl cDao = new CursoDaoImpl();
			MateriaDaoImpl mDao = new MateriaDaoImpl();
			List<Materia> listaMaterias = (ArrayList<Materia>) mDao.readAll();			

			String Materia = request.getParameter("slMateria").toString();
			String Cuatrimestre = request.getParameter("slCuatrimestre").toString();
			String Anio = request.getParameter("slAnio").toString();
			String Turno = request.getParameter("slTurno").toString();
			String Docente = session.getAttribute("Legajo").toString();
			
			String Mensaje = "";
			List<Curso> listaCursos = (ArrayList<Curso>) cDao.readMenuAdmin(Docente, Materia, Cuatrimestre, Anio,
					Turno);

			if (Materia.equals("0")) {
				Mensaje += "Materia: Todas - ";
			} else {
				Materia materia = new Materia();
				materia = mDao.ReadMateria(Integer.parseInt(Materia));
				Mensaje += "Materia: " + materia.getNombre() + " - ";
			}
			if (Cuatrimestre.equals("0")) {
				Mensaje += "Cuatrimestre: Todos - ";
			} else {
				Mensaje += (Cuatrimestre + "Año Cuatrimestre - ");
			}
			if (Anio.equals("0")) {
				Mensaje += "Año: Todos - ";
			} else {
				Mensaje += ("Año: " + Anio + " - ");
			}
			if (Turno.equals("0")) {
				Mensaje += "Turno: Todos";
			} else {
				Mensaje += ("Turno: " + Turno);
			}

			request.setAttribute("Mensaje", Mensaje);
			request.setAttribute("ListaCursos", listaCursos);
			request.setAttribute("ListaMaterias", listaMaterias);
			request.getRequestDispatcher("MenuPrincipalDocente.jsp").forward(request, response);
		}
		
		
		// BOTON PARA GUARDAR LA MODIFICACION DE UN CURSO 
		if(request.getParameter("btnModificarCurso") != null)
		{
			Curso curso = new Curso();
			String IDcursoMod = session.getAttribute("CursoModificar").toString();
			String[] AlumnosXCurso;
			curso.setCuatrimestre(Integer.parseInt(request.getParameter("slCuatrimestre").toString()));
			curso.docente = new Docente();
			curso.docente.setLegajo(Integer.parseInt(request.getParameter("slDocente").toString()));
			curso.Materia = new Materia();
			curso.Materia.setIdMateria(Integer.parseInt(request.getParameter("slMateria").toString()));
			curso.setAño(Integer.parseInt(request.getParameter("slAnio").toString()));
			curso.setTurno((request.getParameter("slTurno").toString()));
			boolean update = cursoImpl.update(curso,IDcursoMod);
			AlumnosXCurso = request.getParameterValues("cboxAlumno");
			int INTcursomod = Integer.parseInt(IDcursoMod);
			List <Alumno> InscriptosIncialmente = aDao.readAlumnosXCurso(INTcursomod);
			for (int x=0; x<AlumnosXCurso.length ; x++)
			{
				if(ndao.BuscarCalificaciones(AlumnosXCurso[x], INTcursomod)!=true)
				{
					cursoImpl.insertAlumnosPorCurso(INTcursomod,AlumnosXCurso[x]);
					ndao.insert(AlumnosXCurso[x], INTcursomod);
				}
			}
			for(Alumno alumnoInicial : InscriptosIncialmente)
			{
				boolean existeAlumno = false;
				for (int i=0; i<AlumnosXCurso.length ; i++)
				{
					if(alumnoInicial.getLegajo()==Integer.parseInt(AlumnosXCurso[i]))
					{
						existeAlumno = true; 
					}
				}
				if(existeAlumno==false)
				{
					cursoImpl.deleteAlumnoXCurso(alumnoInicial.getLegajo(), INTcursomod);
					ndao.deleteCalificacion(alumnoInicial.getLegajo(), INTcursomod);
				}
				
			}
			if(update==true)
			{
				request.setAttribute("SweetAlert", "Modificado" );
			}
			else {
				request.setAttribute("SweetAlert", "Error" );
			}
			List<Curso> listaCursos = (ArrayList<Curso>) cursoImpl.readAll();
			request.setAttribute("ListaCursosAdmin", listaCursos);
			request.getRequestDispatcher("ListadoCursosAdmin.jsp").forward(request, response);
		}
		
		
		String Legajocurso = request.getParameter("Legajocurso");
		if (Legajocurso != null) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			boolean Delete;
			Delete = cursoImpl.delete(Integer.parseInt(Legajocurso));		
			
//			if(Delete == true) {
//				request.setAttribute("SweetAlert", "Eliminado");
//			}
//			else {
//				request.setAttribute("SweetAlert", "Error");
//			}			
			Gson gson = new Gson();
			String json = gson.toJson("Exitoso");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		}
		if(request.getParameter("btnRecuperarCurso")!=null)
		{
			CursoDaoImpl cDao = new CursoDaoImpl();
			List<Curso> listaCursos = (ArrayList<Curso>) cDao.readBajas();
			request.setAttribute("ListaCursosRecuperar", listaCursos);				
			request.getRequestDispatcher("RecuperarCurso.jsp").forward(request, response);
		}
	}

}
