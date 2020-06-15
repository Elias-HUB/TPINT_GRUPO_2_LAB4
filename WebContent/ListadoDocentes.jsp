<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ page import =  "java.util.ArrayList" %>
<%@ page import = "Entidad.Docente" %>

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
		 <th style="text-align:center">Legajo</th>
		 <th style="text-align:center">Apellido</th>
		 <th style="text-align:center">Nombre</th>
		  <th style="text-align:center">Email</th>
		  <th style="text-align:center">Acciones</th>
            </tr>
        </thead>
        <tbody>
          <tr>
          <th>21705</th>
		 <th>Herrera</th>
		 <th>Tamara</th>
		  <th>therrera.utn@gmail.com</th>		  
		  <th>
			  <div class="btn-group" style="text-align:center">
			  <button type="submit" class="btn btn-primary" onclick="location.href='http://localhost:8020/TPINT_GRUPO_2_LAB4/VerDocenteModal.jsp'">Ver</button>
			  <button type="submit" class="btn btn-primary" onclick="location.href='http://localhost:8020/TPINT_GRUPO_2_LAB4/ModificarDocenteModal.jsp'">Modificar</button>
			  <button type="submit" class="btn btn-primary">Eliminar</button>
			  </div>
		  </th>	
		  
       </tr>
       <tr>
          <th>19605</th>
		 <th>Rodriguez</th>
		 <th>Carlos Javier</th>
		 <th>carlosjrodriguezutn@hotmail.com</th>	
		 <th>
			  <div class="btn-group" style="text-align:center">
			  <button type="submit" class="btn btn-primary" onclick="location.href='http://localhost:8020/TPINT_GRUPO_2_LAB4/VerDocenteModal.jsp'">Ver</button>
			  <button type="submit" class="btn btn-primary" onclick="location.href='http://localhost:8020/TPINT_GRUPO_2_LAB4/ModificarDocenteModal.jsp'">Modificar</button>
			  <button type="submit" class="btn btn-primary">Eliminar</button>
			  </div>
		  </th>		  
       </tr>
              <tr>
          <th>22980</th>
		 <th>Fernandez</th>
		 <th>Caudio</th>
		  <th>claudiomarcelofernandez@gmail.com</th>
		  <th>		  
			  <div class="btn-group" style="text-align:center">
			  <button type="submit" class="btn btn-primary" onclick="location.href='http://localhost:8020/TPINT_GRUPO_2_LAB4/VerDocenteModal.jsp'">Ver</button>
			  <button type="submit" class="btn btn-primary" onclick="location.href='http://localhost:8020/TPINT_GRUPO_2_LAB4/ModificarDocenteModal.jsp'">Modificar</button>
			  <button type="submit" class="btn btn-primary">Eliminar</button>
			  </div>
		  </th>
		  
       </tr>
        </tbody>
      
    </table>
    <form action="ServletDocente" id="Form" method="get" >
	<button id="btnMostrar" value="Agregar" type="submit" class="btn btn-primary" name="btnMostrar">Agregar</button>
		
	 </form>
	
 <% 
  	ArrayList<Docente> lista=null;
 
	 if ( request.getAttribute("ListaDoc")!=null) 
	 {
		 lista= (ArrayList<Docente>)request.getAttribute("ListaDoc");
	 }
 
 %>
 
  <table border=1>
  	<thead>
         <tr>
		 <th>Legajo</th>
		 <th>Dni</th>
		 <th>Nombre</th>
		 <th>Apellido</th>
		 <th>FechaNacimiento</th>
		 <th>Direccion</th>
		 <th>Localidad</th>
		 <th>Provincia</th>
		 <th>Email</th>
		 <th>Telefono</th>
		 <th>Estado</th>
         </tr>
     </thead>
 
 
 
  <% 
 	 if (lista!=null) 
	 {
		for ( Docente doc : lista)
		{
			 %>
			 <tr>
			 <th>  <%= doc.getLegajo() %> </th>
			 <th>  <%= doc.getDni() %> </th>
			 <th>  <%= doc.getNombre() %> </th>
			 <th>  <%= doc.getApellido() %> </th>
			 <th>  <%= doc.getFechaNacimiento() %> </th>
			 <th>  <%= doc.domicilio.getDireccion() %> </th>
			 <th>  <%= doc.domicilio.getLocalidad() %> </th>
			 <th>  <%= doc.domicilio.getProvincia() %> </th>
			 <th>  <%= doc.getEmail() %> </th>
			 <th>  <%= doc.getTelefono() %> </th>
			 <th>  <%= doc.getEstado() %> </th>
	</tr>
	 <%
		}
	 }
 
 %>
 
 
 </table>
</body>
</html>