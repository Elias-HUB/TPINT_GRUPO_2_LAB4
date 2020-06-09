<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
		 <th>Legajo</th>
		 <th>Nombre</th>
		 <th>Apellido</th>
            </tr>
        </thead>
        <tbody>
       <tr>
          <th>21592</th>
		 <th>Oriana</th>
		 <th>Garcia</th>
       </tr>
              <tr>
          <th>22012</th>
		 <th>Elias</th>
		 <th>Valenzuela</th>
       </tr>
        </tbody>
      
    </table>

</body>
</html>