<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<jsp:include page="Librerias.jsp"></jsp:include>
<link rel="stylesheet" href="Css/Head.css">

<div class="Cabecera">
	<div style="height: 100px;">
		<div class="snap-pm-user" style="margin-left: 20px">
			<%
			session = request.getSession();
			String Nombre = session.getAttribute("NombreHead").toString();
			String Apellido = session.getAttribute("ApellidoHead").toString();			
			%>
							<h1><%=Nombre%> <%=Apellido%></h1>
				    
			<div style="margin-left: 80px; margin-top: 10px;">
			<a class="aHead" href="...">Perfil</a> -
				<a class="aHead" href="ServeletCurso?Param=2">Mis Cursos</a> - <a
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
</html>
