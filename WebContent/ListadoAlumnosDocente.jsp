<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Person Information</title>
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
		 <th>Legajo</th>
		 <th>Nombre</th>
		 <th>Apellido</th>
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
		 <th>Oriana</th>
		 <th>Garcia</th>
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
		 <th>Elias</th>
		 <th>Valenzuela</th>
		  <th><input type="number" value="9" style="width : 60px; heigth : 50px" min="1" max="10"/></th>
		  <th><input type="number" value="8" style="width : 60px; heigth : 50px"/></th>
		  <th><input type="number" placeholder="-"  style="width : 60px; heigth : 50px"/></th>
		  <th><input type="number" placeholder="-"  style="width : 60px; heigth : 50px"/></th>
		  <th><input type="number" value="8" style="width : 60px; heigth : 50px"/></th>
		  <th>
		   <div class="col"><select id="slEstado" name="slEstado" class="custom-select">
	 		 	<option value="-1" class="dropdown-item">Cursando</option>
	 		 	<option value="1" class="dropdown-item">Promocion</option>
	 		 	<option value="2" class="dropdown-item">Regular</option>
	 		 	<option value="2" class="dropdown-item">Libre</option> 
	 			 </select></div>
       </tr>
        </tbody>
      
    </table>

</body>
</html>