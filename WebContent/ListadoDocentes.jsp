<%@page import="com.sun.javafx.scene.layout.region.Margins.Converter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Docente"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Toast -->
<link rel="stylesheet" href="@sweetalert2/theme-bootstrap-4/bootstrap-4.css">
<script src="sweetalert2/dist/sweetalert2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

<!-- Head -->
<jsp:include page="HeadAdministrador.jsp"></jsp:include>
<jsp:include page="LibreriasJtable.jsp"></jsp:include>

<link rel="stylesheet" href="Css/JTable.css">

</head>
<body>
<%
		session = request.getSession();
		if(session.getAttribute("Legajo") == null) {
		request.getRequestDispatcher("Login.jsp").forward(request, response);}
%>
	<div class="wrapper">
		<div id="formContent" class="table-responsive">
<div class="btn-group">
			<button type="button" class="btn btn-block btn-outline-info"
				onclick="ModalDocenteAgregar()" style="margin-bottom: 10px;">Agregar Docente</button>
</div>				
<div class="btn-group">		
<form action="ServletDocente" method="post">	
			<button type="submit" class="btn btn-block btn-outline-info"
				id="btnRecuperarDocente" name="btnRecuperarDocente" style="margin-bottom: 10px;">Recuperar Docente</button>
</form>
</div>
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead class="">
					<tr>
						<th style="text-align: center">Legajo</th>
						<th style="text-align: center">Apellido</th>
						<th style="text-align: center">Nombre</th>
						<th style="text-align: center">Documento</th>
						<th style="text-align: center">Email</th>
						<th style="text-align: center">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Docente> lista = null;

						if (request.getAttribute("ListaDocentes") != null) {
							lista = (ArrayList<Docente>) request.getAttribute("ListaDocentes");
						}
						if (lista != null) {
							for (Docente doc : lista) {
								String datos = ("'" + doc.getLegajo() + "||" + doc.getNombre() + "||" + doc.getApellido() + "||"
										+ doc.getFechaNacimiento() + "||" + doc.getEmail() + "||" + doc.getTelefono() + "||"
										+ doc.getDomicilio().getDireccion() + "||" + doc.getDomicilio().getProvincia().getNombre()
										+ "||" + doc.getDomicilio().getLocalidad().getNombre() + "||" + doc.getDni() + "||"
										+ doc.getDomicilio().getLocalidad().getID() + "||"
										+ doc.getDomicilio().getProvincia().getID() + "||" + "Prueba" + "'").toString();
					%>
					<tr>
						<form action="ServletDocente" method="post">
						<th style="width: 80px;"><%=doc.getLegajo()%><input
							type="hidden" id="LegajoDocente" name="LegajoDocente"
							value="<%=doc.getLegajo()%>"></th>
						<th><%=doc.getApellido()%></th>
						<th><%=doc.getNombre()%></th>
						<th><%=doc.getDni()%></th>
						<th><%=doc.getEmail()%></th>
						<th style="width: 250px;">
							<!-- Button trigger modal -->
							<button type="button" onclick="ModalVerCargaDatos(<%=datos%>)"
								class="btn btn-outline-primary">
								<img src="Imagenes/Ver.png" Width="22px" data-toggle="tooltip"
									data-placement="bottom" title="ver Alumno" alt="x" />
							</button>

							<button type="button"
								onclick="ModalModificarCargaDatos(<%=datos%>)"
								class="btn btn-outline-warning">
								<img src="Imagenes/Editar.png" Width="22px" alt="x"
									data-toggle="tooltip" data-placement="bottom"
									title="Modificar Alumno" />
							</button>

							<button type="button" id="<%=doc.getLegajo()%>" onClick="modalEliminar(this)" name="BtnEliminar"
								class="btn btn-outline-danger">
								<img src="Imagenes/Eliminar.png" Width="22px" alt="x"
									data-toggle="tooltip" data-placement="bottom"
									title="Eliminar Alumno" />
							</button>
						</th>
						</form>
					</tr>
					<%
						}
						}
					%>
				</tbody>
			</table>
		</div>
	</div>

	<jsp:include page="VerDocenteModal.jsp"></jsp:include>
	<jsp:include page="ModificarDocenteModal.jsp"></jsp:include>
	<jsp:include page="AgregarDocenteModal.jsp"></jsp:include>

	<script src="JS/DataTableListadoDocentesCONFIG.js"></script>
	<script src="JS/DataTableListadoDocentes.js"></script>

	<script type="text/javascript">
	<%
	if(request.getAttribute("SweetAlert")!=null)
	{
		String Resultado = request.getAttribute("SweetAlert").toString();
		request.setAttribute("SweetAlert", null);
		%>mostrarToast("<%=Resultado%>")<%
	}
	%>


	function mostrarToast(ToastR){
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
		if(ToastR == "Cargado"){	
			Toast.fire({			
			  icon: 'success',
			  title: 'El docente se agregó de manera correcta.'
			})
		} else if(ToastR == "Eliminado"){	
			Toast.fire({			
			  icon: 'success',
			  title: 'El docente se eliminó de manera correcta.'
			})
		} else if(ToastR == "Modificado"){	
			Toast.fire({			
				  icon: 'success',
				  title: 'El docente se modificó de manera correcta.'
				})
			} else{	
				Toast.fire({			
					  icon: 'error',
					  title: 'Hubo un problema. Comunicarse con el área técnica.'
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
		var LegajoDocente = btn.id;
		Swal.fire({
			icon: 'warning',
			title:"¿Desea dar de baja este docente?",			
			showCancelButton: true,
			confirmButtonColor: "#c82333",
		  cancelButtonText: "Cancelar",
		  confirmButtonText: "Dar de baja",
		  reverseButtons: true
		}).then((result) => {
			if(result.value){
				   $.ajax({
						url: 'ServletDocente',
						type: 'POST',
						dataType : "json",
						data : {
							LegajoDocente: LegajoDocente
						},						
						success: function(LegajoDocente){
							if(LegajoDocente == "Exitoso"){
								Toast.fire({			
									  icon: 'success',
									  title: 'El alumno se está dando de baja...'
									}).then((result) => {
										location.replace('ServletDocente?Param=2');
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