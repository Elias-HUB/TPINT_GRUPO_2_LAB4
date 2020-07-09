<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="Librerias.jsp"></jsp:include>
<!-- Toast -->
<link rel="stylesheet" href="@sweetalert2/theme-bootstrap-4/bootstrap-4.css">
<script src="sweetalert2/dist/sweetalert2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<link rel="stylesheet" href="Css/LoginCss.css">
<link rel="stylesheet" href="JS/Funciones.js">
<link rel="stylesheet" href="Css/Head.css">
<style type="text/css">
body{
	width: 100%;
	position: Relative;
	height: 99%;
      background: rgba(36, 199, 220, 0.5),url("Imagenes/ImagenFondo.jpg");
      background: -webkit-linear-gradient(to right, rgba(81, 74, 157, 0.5), #24C6DC),url("Imagenes/ImagenFondo.jpg");
      background: linear-gradient(to right, #514A9D, rgba(36, 199, 220, 0.5)),url("Imagenes/ImagenFondo.jpg");
	background-attachment: fixed;
	background-position: center;
	background-size: cover;
}
.Cabecera {
    background: rgba(15, 32, 39, 0.600),url("Imagenes/ImagenFondo.jpg");
    background: -webkit-linear-gradient(to top, #2C5364, rgba(32, 58, 67, 0.600), #0F2027),url("Imagenes/ImagenFondo.jpg");
    background: linear-gradient(to top, #2C5364, rgba(32, 58, 67, 0.600), #0F2027),url("Imagenes/ImagenFondo.jpg");
		color: white;
}
</style>
</head>

<body>
<% 
		session = request.getSession();
		session.setAttribute("Legajo",null);

%>
	<div class="Cabecera">
		<div style="height: 100px;">
			<div class="snap-pm-user"
				style="margin-left: 80px; line-height: 2.35;">
				<h1 style="line-height: 2.35;">Gestión Educativa</h1>
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
				<input type="text" class="fadeIn second" required pattern="[0-9]+" title="Ingrese el legajo"
				name="TxtLegajo" placeholder="Legajo"
					id="TxtLegajo">
					 <input type="text"	class="fadeIn third pass" required name="TxtContrasenia" placeholder="Contraseña"
					id="TxtContrasenia">
				<div>
		<button type="submit" class="btn btn-info fadeIn third pass" id="btnIngresar" name="btnIngresar" style="margin-bottom: 10px;">Ingreso</button>
					<div id="formFooter">
					</div>

				</div>
			</div>
		</div>
	</form>
	
<script src="JS/Funciones.js"></script>	

	<script type="text/javascript">
	<%
	if(request.getAttribute("LoginInvalido")!=null)
	{
		String Resultado = request.getAttribute("LoginInvalido").toString();
		request.setAttribute("LoginInvalido", null);
		%>mostrarToast("<%=Resultado%>")<%
		
	}
	%>

		function mostrarToast(ToastR){
		const Toast = Swal.mixin({
			  toast: true,
			  position: 'bottom',
			  showConfirmButton: false,
			  timer: 3000,
			  timerProgressBar: true,
			  onOpen: (toast) => {
				    toast.addEventListener('mouseenter', Swal.stopTimer)
				    toast.addEventListener('mouseleave', Swal.resumeTimer)
			  }
			});
		if(ToastR == "LoginInvalido"){	
			Toast.fire({			
			  icon: 'error',
			  title: 'Usuario/Contraseña incorrectos.'
			})
		}
	}
		function modalEliminar(btn){
			const Toast = Swal.mixin({
				  toast: true,
				  position: 'top',
				  showConfirmButton: false,
				  timer: 3000,
				  timerProgressBar: true,
				  onOpen: (toast) => {
					    toast.addEventListener('mouseenter', Swal.stopTimer)
					    toast.addEventListener('mouseleave', Swal.resumeTimer)
				  }
				});
			var LegajoCurso = btn.id;
			Swal.fire({
				icon: 'warning',
				title:"¿Desea dar de baja este alumno?",			
				showCancelButton: true,
				confirmButtonColor: "#c82333",
			  cancelButtonText: "Cancelar",
			  confirmButtonText: "Dar de baja",
			  reverseButtons: true
			}).then((result) => {
				if(result.value){
					   $.ajax({
							url: 'ServeletCurso',
							type: 'POST',
							dataType : "json",
							data : {
								LegajoCurso: LegajoCurso
							},						
							success: function(LegajoCurso){
								if(LegajoCurso == "Exitoso"){
									Toast.fire({			
										  icon: 'success',
										  title: 'El alumno se está dando de baja...'
										}).then((result) => {
											location.replace('ServletAlumno?Param=1');
									})
								}else{
									Toast.fire({			
										  icon: 'error',
										  title: 'Hubo un problema. Comunicarse con el área técnica.'
										})
								}
							}
						});
					}
				})
		}
		</script>
</body>
</html>