<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Alumno"%>
<%@ page import="Entidad.Calificacion"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="HeadDocente.jsp"></jsp:include>
<jsp:include page="LibreriasJtable.jsp"></jsp:include>

<link rel="stylesheet" href="Css/JTable.css">
</head>
<body>

	<div class="wrapper">
	<button type="submit" class="btn btn-block btn-outline-info" id="btnCalificar" name="btnCalificar">Guardar Notas</button>
			<br>
		<div id="formContent" class="table-responsive">
		
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead class="thead-dark">
					<tr>
						<th style="text-align: center">Legajo</th>
						<th style="text-align: center">Alumno</th>
						<th style="text-align: center">Documento</th>
						<th>Par.1</th>
						<th>Par.2</th>
						<th>Recu.1</th>
						<th>Recu.2</th>
						<th>Nota Final</th>
						<th>Estado</th>
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
						ArrayList<Calificacion> listaCalificaciones = null;
						if(request.getAttribute("ListCalificaciones")!=null)
						{
							 listaCalificaciones = (ArrayList<Calificacion>)request.getAttribute("ListaCalificaciones");
						}
						if (lista != null) {
							for (Alumno alumno : lista) {
								for (Calificacion calificacion : listaCalificaciones) {
									if (calificacion.getLegajo() == alumno.getLegajo())
									{
								
					%>
						<th style="width: 80px;"><%=alumno.getLegajo()%> <input type="hidden"
							name="LegajoAlumno" value="<%=alumno.getLegajo()%>"></th>
						<th><%=alumno.getApellido()%> <%=alumno.getNombre()%></th>
						<th><%=alumno.getDni()%></th>
						<th><input type="text" value="<%=calificacion.getParcial1()%>"
							style="width: 60px; heigth: 50px" min="1" max="10" /></th>
						<th><input type="number" value="<%=calificacion.getParcial2()%>"
							style="width: 60px; heigth: 50px" min="1" max="10" /></th>
						<th><input type="number" placeholder="-"
							style="width: 60px; heigth: 50px" min="1" max="10" /></th>
						<th><input type="number" placeholder="-"
							style="width: 60px; heigth: 50px" min="1" max="10" /></th>
						<th><input type="number" value="10"
							style="width: 60px; heigth: 50px" min="1" max="10" /></th>
						<th>
							<div class="col">
								<select id="slEstado" name="slEstado" class="custom-select">
									<option value="-1" class="dropdown-item">Cursando</option>
									<option value="1" class="dropdown-item">Promocion</option>
									<option value="2" class="dropdown-item">Regular</option>
									<option value="2" class="dropdown-item">Libre</option>
								</select>
							</div>
						<th><%=alumno.getEmail()%></th>
						
					</tr>
					<%
						}
						}
						}
						}
					%>
				</tbody>
			</table>
		</div>
	
	</div>

</body>
</html>