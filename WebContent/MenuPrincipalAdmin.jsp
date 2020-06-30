<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Curso"%>
<%@ page import="Entidad.Materia"%>
<%@ page import="Entidad.Docente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="HeadAdministrador.jsp"></jsp:include>
</head>
<body>
	<form method="post" action="ServeletCurso">
		<div class="form-row">
			<!--FILTRO MATERIA -->
			<div class="form-group col-md-2">
				<div>
					<label for="Materia">Materia</label>
				</div>
				<%
					ArrayList<Materia> listaMaterias = null;
					if (request.getAttribute("ListaMaterias") != null) {
						listaMaterias = (ArrayList<Materia>) request.getAttribute("ListaMaterias");
					}

					if (listaMaterias != null) {
				%>
				<select id="slMateria" name="slMateria" class="custom-select">
				<option value="0" class="dropdown-item">-</option>
					<%
						for (Materia materia : listaMaterias) {
					%>
					<option value=<%=materia.getIdMateria()%> class="dropdown-item"><%=materia.getNombre()%></option>

					<%
						}
					%>

					<%
						}
					%>
				</select>

			</div>

			<!--FILTRO CUATRIMESTRE -->
			<div class="form-group col-md-2">
				<div>
					<label for="Cuatrimestre">Cuatrimestre</label>
				</div>
				<select id="slCuatrimestre" name="slCuatrimestre"
					class="custom-select">
					<option value="0" class="dropdown-item">-</option>
					<option value="1" class="dropdown-item">1</option>
					<option value="2" class="dropdown-item">2</option>
				</select>
			</div>


			<!--FILTRO AÑO -->
			<div class="form-group col-md-1">
				<div>
					<label for="Año">Año</label>
				</div>
				<select id="slAnio" name="slAnio" class="custom-select">
					<option value="0" class="dropdown-item">-</option>
					<option value="2018" class="dropdown-item">2018</option>
					<option value="2019" class="dropdown-item">2019</option>
					<option value="2020" class="dropdown-item">2020</option>
				</select>
			</div>

			<!--FILTRO TURNO -->
			<div class="form-group col-md-1">
				<div>
					<label for="Turno">Turno</label>
				</div>
				<select id="slTurno" name="slTurno" class="custom-select">
					<option value="0" class="dropdown-item">-</option>
					<option value="Mañana" class="dropdown-item">Mañana</option>
					<option value="Tarde" class="dropdown-item">Tarde</option>
					<option value="Noche" class="dropdown-item">Noche</option>
				</select>
			</div>


			<!--FILTRO DOCENTE -->
			<div class="form-group col-md-2">
				<div>
					<label for="Docente">Docente</label>
				</div>
				<%
					ArrayList<Docente> listaDocentes = null;
					if (request.getAttribute("ListaDocentes") != null) {
						listaDocentes = (ArrayList<Docente>) request.getAttribute("ListaDocentes");
					}

					if (listaDocentes != null) {
				%>
				<select id="slDocente" name="slDocente" class="custom-select">
					<option value="0" class="dropdown-item">-</option>
					<%
						for (Docente doc : listaDocentes) {
					%>
					<option value=<%=doc.getLegajo()%> class="dropdown-item"><%=doc.getNombre()%>
						<%=doc.getApellido()%></option>
					<%
						}
					%>

					<%
						}
					%>
				</select>

			</div>
			<div class="form-group col-md-2" style="margin-top: 32px;">
				<button type="submit" class="btn btn-info" id="btnBuscar"
					name="btnBuscar">Buscar</button>
			</div>
		</div>


	</form>
	<div class="row" style="margin-left: 25px; margin-right: 25px;">

		<%
			ArrayList<Curso> lista = null;

			if (request.getAttribute("ListaCursos") != null) {
				lista = (ArrayList<Curso>) request.getAttribute("ListaCursos");
			}

			if (lista != null) {
				for (Curso curso : lista) {
		%>

		<div class="col-sm-4" style="margin-top: 25px;">
			<div class="card">
				<div class="card text-center border-info">
					<div class="card-header bg-white">
						<h1><%=curso.Materia.getNombre()%></h1>
					</div>
					<div class="card-body ">
						<h5 class="card-title">
							<%=curso.getAño()%>
							<%=curso.getCuatrimestre()%>C
						</h5>
						<p class="card-text"><%=curso.getTurno()%></p>
						<p class="card-text"><%=curso.docente.getNombre()%>
							<%=curso.docente.getApellido()%></p>
						<a href="ServletAlumno?ParamAxC=<%=curso.getId()%>" class="btn btn-lg btn-info">Alumnos</a>
					</div>
					<div class="card-footer bg-transparent"> 
					<input id="txtID" name="txtID" value="<%=curso.getId()%>" style="visibility:hidden" ></div>
				</div>
			</div>
		</div>

	<%
			}
			}
		%>

	</div>
</body>
</html>