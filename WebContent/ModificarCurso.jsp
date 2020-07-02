<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Materia"%>
<%@ page import="Entidad.Docente"%>
<%@ page import="Entidad.Alumno"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="HeadAdministrador.jsp"></jsp:include>
<jsp:include page="LibreriasJtable.jsp"></jsp:include>
<link rel="stylesheet" href="Css/JTable.css">
</head>
<body>
<body>
	<form method="post" action="ServeletCurso">
		<br>
		<div>
			<div class="form-row">

				<!--MATERIA -->
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

				<!--CUATRIMESTRE -->
				<div class="form-group col-md-2">
					<div>
						<label for="Cuatrimestre">Cuatrimestre</label>
					</div>
					<select id="slCuatrimestre" name="slCuatrimestre"
						class="custom-select">
						<option value="1" class="dropdown-item">1</option>
						<option value="2" class="dropdown-item">2</option>
					</select>
				</div>


				<!--AÑO -->
				<div class="form-group col-md-1">
					<div>
						<label for="Año">Año</label>
					</div>
					<select id="slAnio" name="slAnio" class="custom-select">
						<option value="2018" class="dropdown-item">2018</option>
						<option value="2019" class="dropdown-item">2019</option>
						<option value="2020" class="dropdown-item">2020</option>
					</select>
				</div>

				<!--TURNO -->
				<div class="form-group col-md-1">
					<div>
						<label for="Turno">Turno</label>
					</div>
							<select id="slTurno" name="slTurno" class="custom-select">
								<option value="Mañana" class="dropdown-item">Mañana</option>
								<option value="Tarde" class="dropdown-item">Tarde</option>
								<option value="Noche" class="dropdown-item">Noche</option>
							</select>
					</div>
					
					<!--DOCENTE -->
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
				</div>

				<br>
				<div></div>
			</div>
		</form>
</body>
</html>