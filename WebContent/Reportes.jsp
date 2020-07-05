<%@page import="com.sun.javafx.scene.layout.region.Margins.Converter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Materia"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="HeadAdministrador.jsp"></jsp:include>
<jsp:include page="LibreriasJtable.jsp"></jsp:include>

<!-- <link rel="stylesheet" href="Css/JTable.css"> -->
<link rel="stylesheet" href="Css/ReporteCss.css">
</head>
<body>

	<form action="ServeletReporte" method="post">
		<div class="row Centrado"
			style="margin-top: 10px; margin-left: 10px; max-width: 99%;">

			<%--Tipo de Reporte--%>
			<div class="form-group col-md-4">
				<label Class="control-label">Tipo de reporte</label> <select
					class="custom-select Sombra" selectedindex=-1
					id="selectTipoReporte" name="selectTipoReporte"
					data-toggle="tooltip" data-placement="bottom"
					title="Seleccionar el tipo de reporte">
					<option value="1">Porcentaje aprobados por materia</option>
					<option value="2">Porcentaje estado por curso</option>
					<option value="3">Cantidad de alumnos por materia</option>
				</select>
			</div>

			<%--Materia--%>
			<div class="form-group col-lg-2">
				<label Class="control-label">Materias</label> <select
					class="custom-select Sombra" selectedindex=-1
					id="selectTipoMateria" name="selectTipoMateria"
					data-toggle="tooltip" data-placement="bottom"
					title="Seleccionar la materia">
					<option value="Todas">Todas</option>
					<%
						ArrayList<Materia> listaMaterias = null;
						if (request.getAttribute("ListaMaterias") != null) {
							listaMaterias = (ArrayList<Materia>) request.getAttribute("ListaMaterias");
						}
						if (listaMaterias != null) {
							for (Materia materia : listaMaterias) {
					%>
					<option value=<%=materia.getIdMateria()%> class="dropdown-item"><%=materia.getNombre()%></option>
					<%
						}
						}
					%>
				</select>
			</div>

			<%--Cuatrimestre--%>
			<div class="form-group col-lg-2">
				<label Class="control-label">Cuatrimestre</label> <select
					class="custom-select Sombra" selectedindex=-1
					id="selectTipoCuatrimestre" name="selectTipoCuatrimestre"
					data-toggle="tooltip" data-placement="bottom"
					title="Seleccionar el cuatrimestre">
					<option value="-1">Todos</option>
					<option value="1">Primer</option>
					<option value="2">Segundo</option>
				</select>
			</div>

			<%--Año--%>
			<div class="form-group col-md-2">
				<div>
					<label Class="control-label">Año</label>
				</div>
				<select class="custom-select Sombra" selectedindex=-1
					id="selectTipoAnio" name="selectTipoAnio" data-toggle="tooltip"
					data-placement="bottom" title="Seleccionar el Año">
					<option value="-1">Todos</option>
					<option value="2020">2020</option>
					<option value="2019">2019</option>
					<option value="2018">2018</option>
				</select>
			</div>

			<div class="form-group col-md-2" style="margin-top: 32px;">
				<button type="submit" id="BtnReporte" name="BtnReporte"
					class="btn btn-outline-dark Sombra">Generar Reporte</button>
			</div>
		</div>
	</form>


	<div class="wrapper fadeInDown">
		<div id="formContent" class="table-responsive fadeIn first">
			<%
				String Mensaje = null;
				if (request.getAttribute("Mensaje") != null) {
					Mensaje = request.getAttribute("Mensaje").toString();
			%>
			<div style="text-align: center;">
			<h2 class="fadeIn first"><%=Mensaje%></h2>
			</div>
			<%
				}
			%>
			<table id="example" class="table table-striped table-bordered fadeIn third"
				style="width: 100%">
				<thead class="thead-dark fadeIn third">
					<tr>

						<!--TablaReporteAlumnosPorMateria -->
						<%
							String TablaReporteAlumnosPorMateria = null;
							if (request.getAttribute("TablaReporteAlumnosPorMateria") != null) {
								TablaReporteAlumnosPorMateria = request.getAttribute("TablaReporteAlumnosPorMateria").toString();
						%>

						<th style="text-align: center">Materia</th>
						<th style="text-align: center">Porcentaje</th>
					</tr>
				</thead>
				<tbody class="fadeIn fourth">
					<%=TablaReporteAlumnosPorMateria%>
				</tbody>
				<%
					}
				%>

				<!--ReporteAprobadoPorMateria -->
				<%
					String TablaReporteAprobadoPorMateria = null;
					if (request.getAttribute("TablaReporteAprobadoPorMateria") != null) {
						TablaReporteAprobadoPorMateria = request.getAttribute("TablaReporteAprobadoPorMateria").toString();
				%>

				<th style="text-align: center">Materia</th>
				<th style="text-align: center">Cant. aprobados</th>
				<th style="text-align: center">Cant. alumnos</th>
				<th style="text-align: center">Porcentaje</th>
				</tr>
				</thead>
				<tbody>
					<%=TablaReporteAprobadoPorMateria%>
				</tbody>
				<%
					}
				%>
				<!--ReporteEstadoCurso -->
				<%
					String TablaReporteEstadoCurso = null;
					if (request.getAttribute("TablaReporteEstadoCurso") != null) {
						TablaReporteEstadoCurso = request.getAttribute("TablaReporteEstadoCurso").toString();
				%>

				<th style="text-align: center">Estado</th>
				<th style="text-align: center">Cant. alumnos</th>
				<th style="text-align: center">Porcentaje</th>
				</tr>
				</thead>
				<tbody>
					<%=TablaReporteEstadoCurso%>
				</tbody>
				<%
					}
				%>

			</table>
		</div>
	</div>


	<script src="JS/Reporte.js"></script>
</body>
</html>