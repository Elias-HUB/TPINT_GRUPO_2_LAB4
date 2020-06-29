<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="Librerias.jsp"></jsp:include>
<link rel="stylesheet" href="Css/Head.css">
<link rel="stylesheet" href="Css/LoginCss.css">
<link rel="stylesheet" href="JS/Funciones.js">

</head>
<body>
	<div class="Cabecera">
		<div style="height: 100px;">
			<div class="snap-pm-user"
				style="margin-left: 80px; line-height: 2.35;">
				<h1 style="line-height: 2.35;">Gesti�n Educativa</h1>
			</div>
			<div class="topcorner">
				<img src="Imagenes/Cabecera.png" width="300px" class="topcorner"
					alt="Logo">
			</div>
		</div>
	</div>

	<form method="post" action="ServletLogin" >
		<div class="wrapper fadeInDown">
			<div id="formContent">

				<!-- Icon -->
				<div class="fadeIn first">

					<!-- Logo -->
					<img ID="Image1" src="Imagenes/Login.png" Width="50px"
						alt="Imagen no disponible" align="top">
				</div>

				<!-- Login -->
				<input type="text" class="fadeIn second" name="TxtLegajo" placeholder="Legajo"
					id="TxtLegajo">
					 <input type="text"	class="fadeIn third pass" name="TxtContrasenia" placeholder="Contrase�a"
					id="TxtContrasenia">
				<div>
		<button type="submit" class="btn btn-info" id="btnIngresar" name="btnIngresar" style="margin-bottom: 10px;">Ingreso</button>


					<!-- Ayuda -->
					<div id="formFooter">
						<a class="fadeIn five underlineHover" href="...">Ayuda</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>