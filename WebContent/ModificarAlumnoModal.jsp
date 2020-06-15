<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="HeadAdministrador.jsp"></jsp:include>
<jsp:include page="LibreriasJtable.jsp"></jsp:include>
</head>

		<div class="modal-dialog  modal-xl" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Alumno</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">

					<%--Legajo--%>
					<div >
						<label for="Legajo">Legajo</label> 
						<input type="text" id="txtLegajo" name="Legajo">
						 
						<%--Nombre--%>
							<label for="Nombre">Nombre</label> 
							<input type="text" id="txtNombre" name="Nombre">
						<%--Apellido--%>	
							<label for="Apellido">Apellido</label> 
							<input type="text" id="txtApellido" name="Apellido">
						</div>
						<br> 
					<%--Fecha nac--%>
					<div >
						<label for="FechaNac">Fecha Nacimiento</label> 
						<input type="date" id="txtFechaNac" name="FechaNac">
						
						<label for="Email">Email</label> 
						<input type="Email" id="txtEmail" name="Email">
						
						<label for="Telefono">Telefono</label> 
						<input type="text" id="txtTelefono" name="Telefono">
					</div>
					<br> 
					<div >
						<label for="Direccion">Direccion</label> 
						<input type="text" id="txtDireccion" name="Direccion">
						
						<label for="Localidad">Localidad</label> 
						<input type="text" id="txtLocalidad" name="Localidad">
						
						<label for="´Provincia">Provincia</label> 
						<input type="Provincia" id="txtProvincia" name="Provincia">
					</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cerrar</button>
							<button type="button" class="btn btn-primary">Aceptar</button>
						</div>
					</div>
				</div>
			</div>
</body>
</html>