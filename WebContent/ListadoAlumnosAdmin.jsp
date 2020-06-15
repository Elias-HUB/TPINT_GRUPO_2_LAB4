<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Alumno"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="HeadAdministrador.jsp"></jsp:include>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
    </script>

</head>
<body>
<table id="example" class="table table-striped table-bordered" style="width:100%">
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
   						if(request.getAttribute("ListaAlumnos")!=null)
   						{
   							lista=	(ArrayList<Alumno>) request.getAttribute("ListaAlumnos");
   						}
					
						
						if (lista != null) {
							for (Alumno alumno : lista) {
					%>
					<tr>
						<th><%=alumno.getLegajo()%></th>
						<th><%=alumno.getApellido()%></th>
						<th><%=alumno.getNombre()%></th>
						<th><%=alumno.getEmail()%></th>
						<th>
							<div class="btn-group" style="text-align: center">

								<!-- Button trigger modal -->
								<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalAlumnoVer">Ver</button>
								<button type="submit" class="btn btn-primary">Modificar</button>
								<button type="submit" class="btn btn-primary">Eliminar</button>
							</div>
						</th>
					</tr>
					<%
						}
						}
					%>
        </tbody>
      
    </table>

</body>
</html>