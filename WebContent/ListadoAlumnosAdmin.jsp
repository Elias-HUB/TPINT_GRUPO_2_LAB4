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

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#example')
								.DataTable(
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
					});
</script>

</head>
<body>

	<div class="wrapper">
		<div id="formContent" class="table-responsive">
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th style="text-align: center">Legajo</th>
						<th style="text-align: center">Apellido</th>
						<th style="text-align: center">Nombre</th>
						<th style="text-align: center">Email</th>
						<th style="text-align: center">Acciones</th>
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
						<th><%=alumno.getLegajo()%></th>
						<th><%=alumno.getApellido()%></th>
						<th><%=alumno.getNombre()%></th>
						<th><%=alumno.getEmail()%></th>
						<th style="width: 250px;">
							<!-- Button trigger modal -->
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#ModalAlumnoVer">Ver</button>
							<button type="submit" class="btn btn-primary">Modificar</button>
							<button type="submit" class="btn btn-primary">Eliminar</button>

						</th>
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