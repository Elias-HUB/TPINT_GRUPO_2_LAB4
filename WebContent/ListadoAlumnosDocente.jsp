<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<jsp:include page="Librerias.jsp"></jsp:include>
<link rel="stylesheet" href="Css/Head.css">
<link rel="stylesheet" href="Css/LoginCss.css">
<link rel="stylesheet" href="JS/Funciones.js">
<head>
<jsp:include page="HeadAdministrador.jsp"></jsp:include>
<jsp:include page="LibreriasJtable.jsp"></jsp:include>

<link rel="stylesheet" href="Css/JTable.css">

<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>

</head>
<body>
<div class="Cabecera">
	<div style="height: 100px;">
		<div class="snap-pm-user" style="margin-left: 20px">
			<h2>Nombre usuario</h2>
			<div style="margin-left: 80px; margin-top: 10px;">
			<a class="aHead" href="...">Perfil</a> -
				<a class="aHead" href="...">Mis Cursos</a> - <a
					class="aHead" id="snap-pm-logout" href="...">Salir</a>
			</div>
		</div>
		<div class="topcorner">
			<a class="aHead" href='...' class="topcorner"> <img src="Imagenes/Cabecera.png" width="300px"
				alt="Logo">
			</a>
		</div>
	</div>
</div>
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