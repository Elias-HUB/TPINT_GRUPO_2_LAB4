<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="styles.css">
<script type="text/javascript" src="js/funciones.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
<link href="https://unpkg.com/bootstrap-datepicker@1.9.0/dist/css/bootstrap-datepicker3.min.css" rel="stylesheet">
<script src="https://unpkg.com/bootstrap-datepicker@1.9.0/dist/js/bootstrap-datepicker.min.js"></script>
<script src="https://unpkg.com/bootstrap-datepicker@1.9.0/dist/locales/bootstrap-datepicker.es.min.js" charset="UTF-8"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable(
    		 {
    			  "columnDefs": [
    			    { "orderable": false, "targets": [2,3,4,5,6,7]}
    			    ]
    			} 		
    )
},
);
    </script>
</head>
<body>
<table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
		 <th>Legajo</th>
		 <th>Alumno</th>
		  <th>Par.1</th>
		  <th>Par.2</th>
		  <th>Recu.1</th>
		  <th>Recu.2</th>
		  <th>Nota Final</th>
		  <th>Estado</th>
            </tr>
        </thead>
        <tbody>
       <tr>
          <th>21592</th>
		 <th>Oriana Garcia</th>
		  <th><input type="number" value="10" style="width : 60px; heigth : 50px" min="1" max="10"/></th>
		  <th><input type="number" value="10" style="width : 60px; heigth : 50px"min="1" max="10"/></th>
		  <th><input type="number" placeholder="-"  style="width : 60px; heigth : 50px"min="1" max="10"/></th>
		  <th><input type="number" placeholder="-"  style="width : 60px; heigth : 50px"min="1" max="10"/></th>
		  <th><input type="number" value="10" style="width : 60px; heigth : 50px" min="1" max="10"/></th>
		  <th>
		   <div class="col"><select id="slAño" name="slAño" class="custom-select">
	 		 	<option value="-1" class="dropdown-item">Cursando</option>
	 		 	<option value="1" class="dropdown-item">Promocion</option>
	 		 	<option value="2" class="dropdown-item">Regular</option>
	 		 	<option value="2" class="dropdown-item">Libre</option> 
	 			 </select></div>
       </tr>
              <tr>
          <th>22012</th>
		 <th>Elias Valenzuela</th>
		  <th><input type="number" value="9" style="width : 60px; heigth : 50px" min="1" max="10"/></th>
		  <th><input type="number" value="8" style="width : 60px; heigth : 50px"/></th>
		  <th><input type="number" placeholder="-"  style="width : 60px; heigth : 50px"/></th>
		  <th><input type="number" placeholder="-"  style="width : 60px; heigth : 50px"/></th>
		  <th><input type="number" value="8" style="width : 60px; heigth : 50px"/></th>
		  <th>
		   <div class="col"><select id="slEstado" name="slEstado" class="custom-select" selectedindex=-1>
	 		 	<option value="Cursando" class="dropdown-item">Cursando</option>
	 		 	<option value="Promocion" class="dropdown-item">Promocion</option>
	 		 	<option value="Regular" class="dropdown-item">Regular</option>
	 		 	<option value="Libre" class="dropdown-item">Libre</option> 
	 			 </select></div>
       </tr>
        </tbody>
      
    </table>

<button type="submit" class="btn btn-primary" id="btnCargarNotas">Cargar Notas</button>
</body>
</html>