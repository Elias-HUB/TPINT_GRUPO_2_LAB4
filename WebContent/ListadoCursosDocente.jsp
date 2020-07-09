<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Curso"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<jsp:include page="HeadDocente.jsp"></jsp:include>
<jsp:include page="LibreriasJtable.jsp"></jsp:include>

<link rel="stylesheet" href="Css/JTable.css">
</head>
<body>


	<div class="wrapper">
		<div id="formContent" class="table-responsive">

			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th style="text-align: center">Materia</th>
						<th style="text-align: center; width: 60px;">Cuatrimestre</th>
						<th style="text-align: center">Año</th>
						<th style="text-align: center">Turno</th>
						<th style="text-align: center">Inscriptos</th>
					</tr>
				</thead>
				<tbody>

					<%
						ArrayList<Curso> lista = null;

						if (request.getAttribute("ListaCursosDocente") != null) {
							lista = (ArrayList<Curso>) request.getAttribute("ListaCursosDocente");
						}
					%>

					<%
						if (lista != null) {
							for (Curso curso : lista) {
					%>
					<tr>

						<th><%=curso.Materia.getNombre()%></th>
						<th><%=curso.getCuatrimestre()%></th>
						<th><%=curso.getAño()%></th>
						<th><%=curso.getTurno()%></th>
						<th style="text-align: center">
						<a	href="ServletAlumno?ParamAlumnoXCursoDocente=<%=curso.getId()%>"
								class="btn btn-outline-primary"> <img src="Imagenes/Ver.png"
									Width="22px" data-toggle="tooltip" data-placement="bottom"
									title="Ver alumnos" alt="x"/> </a>
						<a style="width: 60px; heigth: 50px" href="ServletNota?ParamAlumnoXCursoDocente=<%=curso.getId()%>" 
						class="btn btn-outline-primary">
						<img src="Imagenes/prueba.png" Width="22px" data-toggle="tooltip"
							data-placement="bottom" title="Calificar" alt="x" />
						</a>	
						
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
<script src="JS/DataTableListCursosDocenteCONFIG.js"></script>
</body>
</html>
