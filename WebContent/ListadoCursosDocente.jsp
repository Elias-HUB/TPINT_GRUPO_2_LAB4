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

<title>Person Information</title>
<meta charset="UTF-8">

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
		 <th style="text-align:center">Curso</th>
		 <th style="text-align:center">Materia</th>
		 <th style="text-align:center">Cuatrimestre</th>
		  <th style="text-align:center">Año</th>
		  <th style="text-align:center">Turno</th>
		  <th style="text-align:center">Alumnos</th>
		  <th style="text-align:center">Estado</th>
            </tr>
        </thead>
        <tbody>
        </tr>
              <tr>
          <th>21CM</th>
		 <th>Programación III</th>
		 <th>2C</th>
		  <th>2016</th>
		  <th>Mañana</th>
		  <th><a href='http://localhost:8020/TPINT_GRUPO_2_LAB4/ListadoAlumnosDocente.jsp'>Alumnos</a></th>
		  <th>Cerrado</th>
       </tr>
       <tr>
          <th>12CN</th>
		 <th>Inglés II</th>
		 <th>1C</th>
		 <th>2020</th>	
		 <th>Noche</th>	
		  <th><a href='http://localhost:8020/TPINT_GRUPO_2_LAB4/ListadoAlumnosDocente.jsp'>Alumnos</a></th>
		  <th>Abierto</th>		  
       </tr>
              <tr>
          <th>22CM</th>
		 <th>Laboratorio de Computación IV</th>
		 <th>1C</th>
		  <th>2020</th>
		  <th>Mañana</th>
		  <th><a href='http://localhost:8020/TPINT_GRUPO_2_LAB4/ListadoAlumnosDocente.jsp'>Alumnos</a></th>
		  <th>Abierto</th>
		  
       </tr>
        </tbody>
      
    </table>

</body>
</html>