<%@page import="com.sun.javafx.scene.layout.region.Margins.Converter"%>
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
		
		
			
			<button type="button" class="btn btn-block btn-outline-info" onclick="ModalAlumnoAgregar()"
				style="margin-bottom: 10px;">Agregar Alumno</button>


			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead class="thead-dark">
					<tr>
						<th style="text-align: center">Legajo</th>
						<th style="text-align: center">Apellido</th>
						<th style="text-align: center">Nombre</th>
						<th style="text-align: center">Documento</th>
						<th style="text-align: center">Email</th>
						<th style="text-align: center">Acciones</th>
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
								String datos = ("'" + alumno.getLegajo() + "||" + alumno.getNombre() + "||" + alumno.getApellido()
										+ "||" + alumno.getFechaNacimiento() + "||" + alumno.getEmail() + "||"
										+ alumno.getTelefono() + "||" + alumno.getDomicilio().getDireccion() + "||"
										+ alumno.getDomicilio().getProvincia().getNombre() + "||" + alumno.getDomicilio().getLocalidad().getNombre() + "||" + alumno.getDni()
										+ "||" + alumno.getDomicilio().getLocalidad().getID() + "||" + alumno.getDomicilio().getProvincia().getID()+ "||" + "Prueba" +"'")
												.toString();
					%>
						<form action="ServletAlumno" method="post">
						<th style="width: 80px;"><%=alumno.getLegajo()%> <input type="hidden"
							name="LegajoAlumno" value="<%=alumno.getLegajo()%>"></th>
						<th><%=alumno.getApellido()%></th>
						<th><%=alumno.getNombre()%></th>
						<th><%=alumno.getDni()%></th>
						<th><%=alumno.getEmail()%></th>
						<th style="width: 250px;">
						
							<!-- Button trigger modal -->
							<button type="button" onclick="ModalVerCargaDatos(<%=datos%>)"
								class="btn btn-outline-primary">
								<img src="Imagenes/Ver.png" Width="22px" data-toggle="tooltip"
									data-placement="bottom" title="ver Alumno" alt="x" />
							</button>

							<button type="button"
								onclick="ModalModificarCargaDatos(<%=datos%>)"
								class="btn btn-outline-warning">
								<img src="Imagenes/Editar.png" Width="22px" alt="x"
									data-toggle="tooltip" data-placement="bottom"
									title="Modificar Alumno" />
							</button>

							<button type="submit" id="BtnEliminar" name="BtnEliminar"
								class="btn btn-outline-danger">
								<img src="Imagenes/Eliminar.png" Width="22px" alt="x"
									data-toggle="tooltip" data-placement="bottom"
									title="Eliminar Alumno" />
							</button>
							</form>
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

	<jsp:include page="VerAlumnoModal.jsp"></jsp:include>
	<jsp:include page="ModificarAlumnoModal.jsp"></jsp:include>
	<jsp:include page="AgregarAlumnoModal.jsp"></jsp:include>

	<script src="JS/DataTableListAlumnosAdminCONFIG.js"></script>
	<script src="JS/DataTableListAlumnosAdmin.js"></script>

</body>
</html>