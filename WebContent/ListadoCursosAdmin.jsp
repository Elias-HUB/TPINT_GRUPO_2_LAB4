<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Curso"%>
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
<br>
<form method="post" action="ServeletCurso">
<button type="submit" class="btn btn-block btn-outline-info"
               id="btnAgregarCurso" name="btnAgregarCurso" style="margin-bottom: 10px;">Agregar Curso</button>
</form>
	<div class="wrapper">
		<div id="formContent" class="table-responsive">

			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th style="text-align: center">Curso</th>
						<th style="text-align: center">Materia</th>
						<th style="text-align: center">Cuatrimestre</th>
						<th style="text-align: center">Año</th>
						<th style="text-align: center">Turno</th>
						<th style="text-align: center">Docente</th>
						<th style="text-align: center">Estado</th>
						<th style="text-align: center">Acciones</th>
					</tr>
				</thead>
				<tbody>

					<%
						ArrayList<Curso> lista = null;

						if (request.getAttribute("ListaCursosAdmin") != null) {
							lista = (ArrayList<Curso>) request.getAttribute("ListaCursosAdmin");
						}
					%>

					<%
						if (lista != null) {
							for (Curso curso : lista) {
					%>
					<tr>

						<th><%=curso.getId()%></th>
						<th><%=curso.Materia.getNombre()%></th>
						<th><%=curso.getCuatrimestre()%></th>
						<th><%=curso.getAño()%></th>
						<th><%=curso.getTurno()%></th>
						<th><%=curso.docente.getNombre()%> <%=curso.docente.getApellido()%></th>
						<th><%=curso.getEstado()%></th>
						<th style="width: 250px;">
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