<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Curso"%>
<%@ page import="Entidad.Materia"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="HeadDocente.jsp"></jsp:include>
<link rel="stylesheet" href="Css/MenuAdmin.css">
</head>
<body>

	<form method="post" action="ServeletCurso">
		<div class="form-row" style="justify-content: center; width: 98%;">
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
					<option value="0" class="dropdown-item">Todas</option>
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
					<option value="0" class="dropdown-item">Todos</option>
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
					<option value="0" class="dropdown-item">Todos</option>
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
					<option value="0" class="dropdown-item">Todos</option>
					<option value="Mañana" class="dropdown-item">Mañana</option>
					<option value="Tarde" class="dropdown-item">Tarde</option>
					<option value="Noche" class="dropdown-item">Noche</option>
				</select>
			</div>

			<div class="form-group col-1" style="margin-top: 32px;">
				<button type="submit" class="btn btn-info" id="btnBuscarDOCENTE"
					name="btnBuscarDOCENTE">Buscar</button>
			</div>
		</div>

	</form>

	<%
		String Mensaje = null;
		if (request.getAttribute("Mensaje") != null) {
			Mensaje = request.getAttribute("Mensaje").toString();
	%>
	<div class="zoomInDown" style="text-align: center;">
		<h2><%=Mensaje%></h2>
	</div>
	<%
		}
	%>





	<div class="row fadeIn" style="margin-left: 25px; margin-right: 25px;">

		<%
			ArrayList<Curso> lista = null;

			if (request.getAttribute("ListaCursos") != null) {
				lista = (ArrayList<Curso>) request.getAttribute("ListaCursos");
			}

			if (lista != null) {
				for (Curso curso : lista) {
		%>

		<div class="col-sm-4" style="margin-top: 25px;">
			<div class="card colores">
				<div class="card text-center border-dark">
					<div class="card-header">
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
						<div class="form-row" style="justify-content: center;">
							<a
								href="ServletAlumno?ParamAlumnoXCursoDocente=<%=curso.getId()%>"
								class="btn btn-lg btn-dark" style="margin-right: 5px;">Alumnos</a> <a
								href="ServletNota?ParamAlumnoXCursoDocente=<%=curso.getId()%>"
								class="btn btn-lg btn-dark" style="margin-left: 5px;">Calificar</a>
						</div>
					</div>
					<div class="card-footer bg-transparent ">

						<input id="txtID" name="txtID" value="<%=curso.getId()%>"
							style="visibility: hidden">
					</div>

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