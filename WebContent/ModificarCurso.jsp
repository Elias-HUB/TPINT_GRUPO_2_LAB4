<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Materia"%>
<%@ page import="Entidad.Docente"%>
<%@ page import="Entidad.Alumno"%>
<%@ page import="Entidad.Curso"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="HeadAdministrador.jsp"></jsp:include>
<jsp:include page="LibreriasJtable.jsp"></jsp:include>
<link rel="stylesheet" href="Css/JTable.css">

<style>
.btn-outline-info {
	border-color: -webkit-linear-gradient(to bottom, #86fde8, #acb6e5);
	background: #ffffff;
	color: -webkit-linear-gradient(to bottom, #86fde8, #acb6e5);
}

.btn-outline-info:hover, .btn-outline-info:active, .btn-outline-info:visited,
	.btn-outline-info:focus {
	border-color: #acb6e5;
	background: #acb6e5;
	background: -webkit-linear-gradient(to bottom, #86fde8, #acb6e5);
	background: linear-gradient(to bottom, #86fde8, #acb6e5);
	color: white;
}
</style>

</head>

<body>
	<form method="post" action="ServeletCurso">
		<div>
			<div class="form-row" style="justify-content: center; width: 98%;"">
			<% Curso cursoMod = (Curso)(session.getAttribute("CursoMod")); %>
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
					<option value="<%=cursoMod.Materia.getIdMateria()%>" selected style="visibility:hidden"><%=cursoMod.Materia.getNombre()%></option>
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
						<option value="<%=cursoMod.getCuatrimestre()%>" selected style="visibility:hidden"><%=cursoMod.getCuatrimestre()%></option>
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
						<option value="<%=cursoMod.getAño()%>" selected style="visibility:hidden"><%=cursoMod.getAño()%></option>
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
							<option value="<%=cursoMod.getTurno()%>" selected style="visibility:hidden"><%=cursoMod.getTurno()%></option>
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
						<option value="<%=cursoMod.docente.getLegajo()%>" selected style="visibility:hidden">
						<%=cursoMod.docente.getNombre()%> <%=cursoMod.docente.getApellido()%></option>
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

			</div>
			
		
		<div class="wrapper">
			<div id="formContent" class="table-responsive">
				<table id="example" class="table table-striped table-bordered"
					style="width: 100%">
					<thead class="thead-dark">
						<tr>
							<th style="text-align: center">Seleccionar</th>
							<th style="text-align: center">Legajo</th>
							<th style="text-align: center">Apellido</th>
							<th style="text-align: center">Nombre</th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<Alumno> lista = null;
						    ArrayList<Alumno> listaAlumnosXcurso = null;
							
						    if (request.getAttribute("ListaAlumnosTodos") != null) {
								lista = (ArrayList<Alumno>) request.getAttribute("ListaAlumnosTodos");
						    }
								if (request.getAttribute("ListaAlumnosCurso") != null) {
								 listaAlumnosXcurso = (ArrayList<Alumno>) request.getAttribute("ListaAlumnosCurso");
							}

							if (lista != null) {
								for (Alumno alumno : lista) {
						%>
						<tr>
							<th><input type="checkbox" id="cboxAlumno" name="cboxAlumno"
							value="<%=alumno.getLegajo()%>" 
							<%
								for (Alumno  alumnoInscripto : listaAlumnosXcurso)
								{
									if(alumnoInscripto.getLegajo()==alumno.getLegajo())
									{
										%>  checked
										 <% 
								 	}
								}
							
							%>
						    ></th>
							<th><%=alumno.getLegajo()%></th>
							<th><%=alumno.getApellido()%></th>
							<th><%=alumno.getNombre()%></th>
						</tr>
						<%
							}
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
		
		<button type="submit" class="btn btn-block btn-outline-info"
			id="btnModificarCurso" name="btnModificarCurso">Modificar Curso</button>
			</form>
			
<!-- <script src="JS/DataTableListAltaCursoCONFIG.js"></script>			 -->
</body>
</html>