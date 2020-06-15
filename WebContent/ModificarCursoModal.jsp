<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
    
} );
    </script>
    
 <style type="text/css">
    .modal-lg {
       max-width: 95%;
} </style>
   
 </head>
<body>
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModal">Probar</button>
	<!-- Modal -->
	<div class="modal fade modal-lg" id="exampleModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel">
		<div class="modal-dialog  modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Curso</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body form-group">

					<%--Legajo--%>
					<div class="row">
						<label for="Materia">Materia</label> 
					<div class="col-2">
						<select id="slMateria" name="slMateria" class="custom-select"selectedindex=-1>
							<option value="1" class="dropdown-item">Programacion II</option>
							<option value="2" class="dropdown-item">Programacion III</option>
							<option value="3" class="dropdown-item">Laboratiorio III</option>
							<option value="4" class="dropdown-item">Laboratorio IV</option>
						</select>
						</div>
						
						<label for="Cuatrimestre">Cuatrimestre</label>
					<div class="col-2">
						<select id="slCuatrimestre" name="slCuatrimestre" class="custom-select"
							selectedindex=-1>
							<option value="1" class="dropdown-item">1</option>
							<option value="2" class="dropdown-item">2</option>
						</select>
						</div>
							<label for="Año">Año</label>
						<div class="col-2">
						<select id="slAnio" name="slAnio" class="custom-select"
							selectedindex=-1>
							<option value="2018" class="dropdown-item">2018</option>
							<option value="2019" class="dropdown-item">2019</option>
							<option value="2020" class="dropdown-item">2020</option>
							<option value="2021" class="dropdown-item">2021</option>
						</select>
						</div>
						<label for="Docente">Docente</label> 
							<div class="col-2">
						<select id="slDocente" name="slDocente" class="custom-select"
							selectedindex=-1>
							<option value="1" class="dropdown-item">Tamara</option>
							<option value="2" class="dropdown-item">Carlos</option>
						</select>
						</div>
						
					</div>
					<br>
					<div>
					<div class="wrapper">
		<div id="formContent" class="table-responsive">
					<table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
         <th>Seleccionar</th>  
		 <th>Legajo</th>
		 <th>Nombre</th>
		 <th>Apellido</th>
            </tr>
        </thead>
        <tbody>
       <tr>
          <th><input type="checkbox"></th>
          <th>21592</th>
		 <th>Oriana</th>
		 <th>Garcia</th>
       </tr>
              <tr>
              <th><input type="checkbox"></th>
          <th>22012</th>
		 <th>Elias</th>
		 <th>Valenzuela</th>
       </tr>
        </tbody>
      
    </table>
			</div>	
			</div>			
					</div>
					<br>
					
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cerrar</button>
						<button type="button" class="btn btn-primary">Aceptar</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>