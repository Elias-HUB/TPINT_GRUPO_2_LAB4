<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable(
	{
		//Para cambiar el lenguaje a español
		"language" : {
			"lengthMenu" : "Mostrar _MENU_ registros",
			"zeroRecords" : "No se encontraron resultados",
			"info" : "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
			"infoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
			"infoFilteres" : "(filtrado de un total de _MAX_ registros)",
			"sSearch" : "Buscar:",
			"oPaginate" : {
				"sFirst" : "Primero",
				"sLast" : "Ultimo",
				"sNext" : "Siguiente",
				"sPrevious" : "Anterior"
			},
			"sProcessing" : "Procesando...",
		}
	});
    
} );
    </script>
   
 </head>
<body>
				<div>
					<div class="form-row">
						<label for="Materia">Materia</label> 
					<div class="col-2">
					<%
						ArrayList<Materia> listaMaterias = null;
						if (request.getAttribute("ListaMaterias") != null) {
							listaMaterias = (ArrayList<Materia>) request.getAttribute("ListaMaterias");
						}

						if (listaMaterias != null) {
							%>	<select id="slMateria" name="slMateria" class="custom-select"selectedindex=-1>
						<%	for (Materia materia : listaMaterias) {
					%>
						<option value=<%=materia.getIdMateria()%> class="dropdown-item"><%=materia.getNombre()%></option>
					
						<%
						}
						%>	
						</select>
						</div>
						
						<%
						}
					%>
					
				</div>
					<div>
						<label for="Cuatrimestre">Cuatrimestre</label>
					<div class="col-2">
						<select id="slCuatrimestre" name="slCuatrimestre" class="custom-select"
							selectedindex=-1>
							<option value="1" class="dropdown-item">1</option>
							<option value="2" class="dropdown-item">2</option>
						</select>
						</div>
							<label for="Año">Año</label>
						<div class="col-2">
						<select id="slAnio" name="slAnio" class="custom-select"
							selectedindex=-1>
							<option value="2018" class="dropdown-item">2018</option>
							<option value="2019" class="dropdown-item">2019</option>
							<option value="2020" class="dropdown-item">2020</option>
							<option value="2021" class="dropdown-item">2021</option>
						</select>
						</div>
						<div>
						<label for="Docente">Docente</label> 
					<div class="col-2">
						<%
						ArrayList<Docente> listaDocentes = null;
						if (request.getAttribute("ListaDocentes") != null) {
							listaDocentes = (ArrayList<Docente>) request.getAttribute("ListaDocentes");
						}

						if (listaDocentes != null) {
							%>	<select id="slDocente" name="slDocente" class="custom-select"selectedindex=1>
						<%	for (Docente doc : listaDocentes) {
					%>
						<option value=<%=doc.getLegajo()%> class="dropdown-item"><%=doc.getNombre()%> <%=doc.getApellido()%></option>
					
						<%
						}
						%>	
						</select>
						</div>
						
						<%
						}
					%>
						</div>
					</div>
					
					<br>
					<div>
				</div>
		<div class="wrapper">
		<div id="formContent" class="table-responsive">
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead class="thead-dark">
					<tr>
						<th style="text-align: center">Seleccionar </th>
						<th style="text-align: center">Legajo</th>
						<th style="text-align: center">Apellido</th>
						<th style="text-align: center">Nombre</th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Alumno> lista = null;
						if (request.getAttribute("ListaAlumnos") != null) {
							lista = (ArrayList<Alumno>) request.getAttribute("ListaAlumnos");
						}

						if (lista != null) {
							for (Alumno alumno : lista) {
					%>
					<tr>
						<th><input type="checkbox" id="cbox1" value="cboxAlumno"> </th>
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
					</div>
					<br>
				<form method="post" action="ServeletCurso">
				<button type="submit" class="btn btn-block btn-outline-info"
               id="btnAltaCurso" name="btnGuardarCurso">Guardar Curso</button>
				</form>

</body>
</html>