package Servelets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    
	//LISTAR TODOS LOS CURSOS PARA EL ADMIN
		if (request.getParameter("Param") != null) {
			if (ParamListar.equals("1")) {
				CursoDaoImpl cDao = new CursoDaoImpl();
				List<Curso> listaCursos = (ArrayList<Curso>) cDao.readAll();
				request.setAttribute("ListaCursosAdmin", listaCursos);
				request.getRequestDispatcher("ListadoCursosAdmin.jsp").forward(request, response);
			}
      
	// LISTAR LOS CURSOS PARA UN DOCENTE LOGUEADO
		else if (ParamListar.equals("2")) {
				CursoDaoImpl cDao = new CursoDaoImpl();
				
				int legajo = Integer.parseInt(session.getAttribute("Legajo").toString());
				List<Curso> listaCursos = (ArrayList<Curso>) cDao.readCursosXDocente(legajo);
				request.setAttribute("ListaCursosDocente", listaCursos);
				request.getRequestDispatcher("ListadoCursosDocente.jsp").forward(request, response);
			}
		}

		//BOTON PARA ABRIR LA MODIFICACION DE UN CURSO
			if(request.getParameter("ParamModificarCurso")!=null)
				{
					MateriaDaoImpl mDao = new MateriaDaoImpl();
					List<Materia> listaMaterias = (ArrayList<Materia>)mDao.readAll();
					DocenteDaoImpl dDao = new DocenteDaoImpl(); 
					List<Docente> listaDocentes = (ArrayList<Docente>)dDao.readAll();
					AlumnoDaoImpl aDao = new AlumnoDaoImpl();
					String aux= request.getParameter("ParamModificarCurso").toString();
					int cursoMod = Integer.parseInt(aux);
					session.setAttribute("CursoModificar", cursoMod);
					CursoDaoImpl cdao = new CursoDaoImpl();
					Curso curso = cdao.BuscarCurso(cursoMod);
					//String doc = String.valueOf(curso.docente.get)
					List<Alumno> listaAlumnosCurso = (ArrayList<Alumno>)aDao.readAlumnosXCurso(cursoMod);
					List<Alumno>listaAlumnosTodos = (ArrayList<Alumno>) aDao.readAll();
					session.setAttribute("CursoMod", curso);
					request.setAttribute("ListaAlumnosCurso", listaAlumnosCurso);
					request.setAttribute("ListaAlumnosTodos", listaAlumnosTodos);
					request.setAttribute("ListaDocentes",listaDocentes);
					request.setAttribute("ListaMaterias", listaMaterias);
					request.getRequestDispatcher("ModificarCurso.jsp").forward(request, response);
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
			request.setAttribute("ListaDocentes",listaDocentes);
			request.setAttribute("ListaMaterias", listaMaterias);
			request.getRequestDispatcher("AltaCurso.jsp").forward(request, response);
		}
    
// BOTON PARA QUE SE GUARDE EN LA BD EL CURSO NUEVO
		if(request.getParameter("btnGuardarCurso") != null)
	    {
			Curso curso = new Curso();		
			String[] AlumnosXCurso; 
			curso.setCuatrimestre(Integer.parseInt(request.getParameter("slCuatrimestre").toString()));
			curso.docente = new Docente( );
			curso.docente.setLegajo(Integer.parseInt(request.getParameter("slDocente").toString()));
			curso.Materia  = new Materia();
			curso.Materia.setIdMateria(Integer.parseInt(request.getParameter("slMateria").toString()));
			curso.setA�o(Integer.parseInt(request.getParameter("slAnio").toString()));
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
			
			int legajo= (Integer.parseInt(request.getParameter("slDocente").toString()));
			List<Curso> listaCursos = (ArrayList<Curso>) cursoImpl.readCursosXDocente(legajo);
			MateriaDaoImpl mDao = new MateriaDaoImpl();
			List<Materia> listaMaterias = (ArrayList<Materia>)mDao.readAll();
			DocenteDaoImpl dDao = new DocenteDaoImpl(); 
			List<Docente> listaDocentes = (ArrayList<Docente>)dDao.readAll();
			request.setAttribute("ListaCursos", listaCursos);
			request.setAttribute("ListaMaterias", listaMaterias);
			request.setAttribute("ListaDocentes",listaDocentes);
			request.getRequestDispatcher("MenuPrincipalAdmin.jsp").forward(request, response);
		}
    
		// BOTON PARA GUARDAR LA MODIFICACION DE UN CURSO 
		if(request.getParameter("btnModificarCurso") != null)
		{
			Curso curso = new Curso();
			String IDcursoMod = session.getAttribute("CursoModificar").toString();
			String[] AlumnosXCurso; 
			curso.setCuatrimestre(Integer.parseInt(request.getParameter("slCuatrimestre").toString()));
			curso.docente = new Docente( );
			curso.docente.setLegajo(Integer.parseInt(request.getParameter("slDocente").toString()));
			curso.Materia  = new Materia();
			curso.Materia.setIdMateria(Integer.parseInt(request.getParameter("slMateria").toString()));
			curso.setA�o(Integer.parseInt(request.getParameter("slAnio").toString()));
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
		
	}

}
