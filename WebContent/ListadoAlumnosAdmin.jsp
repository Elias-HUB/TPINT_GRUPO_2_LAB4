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
	$(document).ready(function() {
		$('#example').DataTable( 
				{		
	    			"columnDefs": [
	      			    { "orderable": false, "targets": [4]}
	      			    ],
					"lengthMenu": [[5, 10 , -1], [5, 10, "Todos"]],				
					//Para cambiar el lenguaje a español
					language: {
		                "lengthMenu": "Mostrar _MENU_ registros",
		                "zeroRecords": "No se encontraron resultados",
		                "info": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
		                "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
		                "infoFiltered": "(filtrado de un total de _MAX_ registros)",
		                "sSearch": "Buscar:",
		                "oPaginate": {
		                    "sFirst": "Primero",
		                    "sLast":"Último",
		                    "sNext":"Siguiente",
		                    "sPrevious": "Anterior"
					     },
					     "sProcessing":"Procesando...",
		            },
		        //para usar los botones
		        dom: 'lfrBtip',
		        buttons: [
		        	{
						extend:    'copy',
						text:      '<i class="fa fa-copy"></i> ',
						titleAttr: 'Copiar todo',
						className: 'btn btn-secondary',
						exportOptions: {
							columns: ':visible'
						}
					},
					{
						extend:    'excel',
						text:      '<i class="fas fa-file-excel"></i> ',
						titleAttr: 'Exportar a Excel',
						className: 'btn btn-success',
						exportOptions: {
							columns: ':visible'
						}
					},
					{
						extend:    'pdfHtml5',
						text:      '<i class="fas fa-file-pdf"></i> ',
						titleAttr: 'Exportar a PDF',
						className: 'btn btn-danger',
						exportOptions: {
							columns: ':visible'
						}
					},
					{
						extend:    'print',
						text:      '<i class="fa fa-print"></i>',
						titleAttr: 'Imprimir',
						className: 'btn btn-info',
						exportOptions: {
							columns: ':visible'
						}						
					},
					{
				        extend: 'columnToggle',
				        text:      '<i class="fa fa-eye-slash" ></i> ',
						titleAttr: 'Sacar Columna Acciones',
						className: 'btn btn-info',
				        columns: 4
				    },					
				] 
		    });     
		});
</script>


<style type="text/css">

</style>
</head>
<body>

	<div class="wrapper">
		<div id="formContent" class="table-responsive">
<!-- 		        <asp:Button Text="Agregar Alumno" OnClick="BtnAlumno_Click" ID="BtnAlumno" runat="server" class="btn btn-block btn-info" /> -->
		<button type="submit" class="btn btn-block btn-outline-info" style="margin-bottom: 10px;">Agregar Alumno</button>
<!-- 		<button type="submit" class="btn"><img src="Imagenes/Nuevo.png" data-toggle="tooltip" data-placement="bottom" title="Agregar Alumno" alt="x" /></button> -->
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead class="thead-dark">
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
							<button type="button" class="btn btn-outline-primary" data-toggle="modal"
								data-target="#ModalAlumnoVer"><img src="Imagenes/Ver.png" Width="22px" data-toggle="tooltip" data-placement="bottom" title="ver Alumno" alt="x" /></button>
								<button type="button" class="btn btn-outline-warning" data-toggle="modal"
								data-target="#ModalAlumnoModificar"><img src="Imagenes/Editar.png" Width="22px" alt="x" data-toggle="tooltip" data-placement="bottom" title="Modificar Alumno"/></button>
							<button type="submit" class="btn btn-outline-danger"><img src="Imagenes/Eliminar.png" Width="22px" alt="x" data-toggle="tooltip" data-placement="bottom" title="Eliminar Alumno"/></button>

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
	
</body>
</html>