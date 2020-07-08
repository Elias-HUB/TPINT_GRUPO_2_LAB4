<%@page import="com.sun.javafx.scene.layout.region.Margins.Converter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Alumno"%>
<%@ page import="javax.servlet.http.HttpSession"%>

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
	request.getRequestDispatcher("Login.jsp").forward(request, response);
}
%>


	<div class="wrapper">
		<div id="formContent" class="table-responsive">



			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead class="thead-dark">
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
							ArrayList<Alumno> lista = null;
							if (request.getAttribute("ListaAlumnosRecup") != null) {
								lista = (ArrayList<Alumno>) request.getAttribute("ListaAlumnosRecup");
							}

							if (lista != null) {
								for (Alumno alumno : lista) {
									String datos = ("'" + alumno.getLegajo() + "||" + alumno.getNombre() + "||" + alumno.getApellido()
											+ "||" + alumno.getFechaNacimiento() + "||" + alumno.getEmail() + "||"
											+ alumno.getTelefono() + "||" + alumno.getDomicilio().getDireccion() + "||"
											+ alumno.getDomicilio().getProvincia().getNombre() + "||"
											+ alumno.getDomicilio().getLocalidad().getNombre() + "||" + alumno.getDni() + "||"
											+ alumno.getDomicilio().getLocalidad().getID() + "||"
											+ alumno.getDomicilio().getProvincia().getID() + "||" + "Prueba" + "'").toString();
						%>
					<tr>						
						<form action="ServletAlumno" method="post">
						<th style="width: 80px;"><%=alumno.getLegajo()%> <input
							type="hidden" name="LegajoAlumno" value="<%=alumno.getLegajo()%>"></th>
						<th><%=alumno.getApellido()%></th>
						<th><%=alumno.getNombre()%></th>
						<th><%=alumno.getDni()%></th>
						<th><%=alumno.getEmail()%></th>
						<th style="width: 250px;">
							<!-- Button trigger modal -->
							<button type="button" onclick="ModalVerCargaDatos(<%=datos%>)"
								class="btn btn-outline-primary">
								<img src="Imagenes/Ver.png" Width="22px" data-toggle="tooltip"
									data-placement="bottom" title="ver Alumno" alt="x" />
							</button>

							<a href="ServletAlumno?ParamRecuperarAlumno=<%=alumno.getLegajo()%>"
								class="btn btn-outline-primary"><img src="Imagenes/revertir.png" Width="22px" data-toggle="tooltip"
									data-placement="bottom" title="Recuperar" alt="x" /></a>
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

	<jsp:include page="VerAlumnoModal.jsp"></jsp:include>

	<script src="JS/DataTableListAlumnosAdminCONFIG.js"></script>
	<script src="JS/DataTableListAlumnosAdmin.js"></script>
	
	<script type="text/javascript">
	<%
	if(request.getAttribute("SweetAlert")!=null)
	{
		String Resultado = request.getAttribute("SweetAlert").toString();
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
			  title: 'El alumno se recuperó de manera correcta.'
			})
		} else if(ToastR == "Eliminado"){	
			Toast.fire({			
			  icon: 'success',
			  title: 'El alumno se eliminó de manera correcta.'
			})
		} else if(ToastR == "Modificado"){	
			Toast.fire({			
				  icon: 'success',
				  title: 'El alumno se modificó de manera correcta.'
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
		var LegajoAlumno = btn.id;
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
						url: 'ServletAlumno',
						type: 'POST',
						dataType : "json",
						data : {
							LegajoAlumno: LegajoAlumno
						},						
						success: function(LegajoAlumno){
							if(LegajoAlumno == "Exitoso"){
								Toast.fire({			
									  icon: 'success',
									  title: 'El alumno se está dando de baja...'
									}).then((result) => {
										location.reload();
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