<%@page import="com.sun.javafx.scene.layout.region.Margins.Converter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Docente"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="HeadAdministrador.jsp"></jsp:include>
<jsp:include page="LibreriasJtable.jsp"></jsp:include>

<link rel="stylesheet" href="Css/JTable.css">	

</head>
<body>

	<div class="wrapper" >
		<div  id="formContent" class="table-responsive">
		
					<button type="button" class="btn btn-block btn-outline-info" onclick="ModalDocenteAgregar()"
				style="margin-bottom: 10px;">Agregar Docente</button>
		
		
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
						ArrayList<Docente> lista = null;

						if (request.getAttribute("ListaDocentes") != null) {
							lista = (ArrayList<Docente>) request.getAttribute("ListaDocentes");
						}					
						if (lista != null) {
							for (Docente doc : lista) {
								String datos = ("'" + doc.getLegajo() + "||" + doc.getNombre() + "||" + doc.getApellido()
								+ "||" + doc.getFechaNacimiento() + "||" + doc.getEmail() + "||"
								+ doc.getTelefono() + "||" + doc.getDomicilio().getDireccion() + "||"
								+ doc.getDomicilio().getProvincia().getNombre() + "||" + doc.getDomicilio().getLocalidad().getNombre() + "||" + doc.getDni()
								+ "||" + doc.getDomicilio().getLocalidad().getID() + "||" + doc.getDomicilio().getProvincia().getID()+ "||" + "Prueba" +"'")
										.toString();
					%>

						<th style="width: 80px;"><%=doc.getLegajo()%><input type="hidden"
							name="LegajoAlumno" value="<%=doc.getLegajo()%>"></th>						
						<th><%=doc.getApellido()%></th>
						<th><%=doc.getNombre()%></th>
						<th><%=doc.getDni()%></th>
						<th><%=doc.getEmail()%></th>
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





	<jsp:include page="VerDocenteModal.jsp"></jsp:include>
	<jsp:include page="ModificarDocenteModal.jsp"></jsp:include>
	<jsp:include page="AgregarDocenteModal.jsp"></jsp:include>
	
	<script src="JS/DataTableListadoDocentesCONFIG.js"></script>
	<script src="JS/DataTableListadoDocentes.js"></script>

</body>
</html>