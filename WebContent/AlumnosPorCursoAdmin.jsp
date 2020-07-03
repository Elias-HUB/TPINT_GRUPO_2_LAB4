<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Alumno"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="HeadAdministrador.jsp"></jsp:include>
<jsp:include page="LibreriasJtable.jsp"></jsp:include>

<link rel="stylesheet" href="Css/JTable.css">
</head>
<body>

	<div class="wrapper">
		<div id="formContent" class="table-responsive">
		
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead class="thead-dark">
					<tr>
						<th style="text-align: center">Legajo</th>
						<th style="text-align: center">Apellido</th>
						<th style="text-align: center">Nombre</th>
						<th style="text-align: center">Documento</th>
						<th style="text-align: center">Email</th>
					</tr>
				</thead>
				<tbody>
					<tr>
					<%
						ArrayList<Alumno> lista = null;
						if (request.getAttribute("ListaAlumnos") != null) {
							lista = (ArrayList<Alumno>) request.getAttribute("ListaAlumnos");
						}

						if (lista != null) {
							for (Alumno alumno : lista) {
								
					%>
						<th style="width: 80px;"><%=alumno.getLegajo()%> <input type="hidden"
							name="LegajoAlumno" value="<%=alumno.getLegajo()%>"></th>
						<th><%=alumno.getApellido()%></th>
						<th><%=alumno.getNombre()%></th>
						<th><%=alumno.getDni()%></th>
						<th><%=alumno.getEmail()%></th>
					</tr>
					<%
						}
						}
					%>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>