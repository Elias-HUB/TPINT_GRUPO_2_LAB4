<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="HeadAdministrador.jsp"></jsp:include>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
	
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
    </script>
    
        <style type="text/css">
    .modal-lg {
       max-width: 95%;
}
    </style>
   
 
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