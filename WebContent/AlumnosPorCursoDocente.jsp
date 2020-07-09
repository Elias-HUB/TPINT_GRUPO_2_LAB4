<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Alumno"%>
<%@ page import="Entidad.Calificacion"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Toast -->
<link rel="stylesheet" href="@sweetalert2/theme-bootstrap-4/bootstrap-4.css">
<script src="sweetalert2/dist/sweetalert2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<jsp:include page="HeadDocente.jsp"></jsp:include>
<jsp:include page="LibreriasJtable.jsp"></jsp:include>

<link rel="stylesheet" href="Css/JTable.css">
<style>
.btn-outline-info {
	border-color: -webkit-linear-gradient(to bottom, #86fde8, #acb6e5);
	background: #ffffff;
	color: -webkit-linear-gradient(to bottom, #86fde8, #acb6e5);
}

.btn-outline-info:hover, .btn-outline-info:active, .btn-outline-info:visited,
	.btn-outline-info:focus {
	border-color: #acb6e5;
	background: #acb6e5;
	background: -webkit-linear-gradient(to bottom, #86fde8, #acb6e5);
	background: linear-gradient(to bottom, #86fde8, #acb6e5);
	color: white;
}
</style>
</head>
<body>
	<form action="ServletNota" method="post">
		<div class="wrapper">
			<button type="submit" class="btn btn-block btn-outline-info"
				id="btnCalificar" name="btnCalificar">Guardar Notas</button>
			<br>
			<div id="formContent" class="table-responsive">

				<table id="example" class="table table-striped table-bordered"
					style="width: 100%">
					<thead class="thead-dark">
						<tr style="text-align: center">
							<th style="text-align: center">Legajo</th>
							<th style="text-align: center">Alumno</th>
							<th style="text-align: center">Documento</th>
							<th>Par.1</th>
							<th>Par.2</th>
							<th>Recu.1</th>
							<th>Recu.2</th>
							<th>Nota Final</th>
							<th>Estado</th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<Calificacion> lista = null;
							if (request.getAttribute("ListaCalificaciones") != null) {
								lista = (ArrayList<Calificacion>) request.getAttribute("ListaCalificaciones");
							}
							if (lista != null) {
								for (Calificacion calificacion : lista) {
						%>
						<tr>
							<th style="width: 80px;"><%=calificacion.getAlumno().getLegajo()%>
								<input type="hidden" name="CalificacionAlumno"
								value="<%=calificacion.getAlumno().getLegajo()%>"></th>
							<th><%=calificacion.getAlumno().getApellido()%> <%=calificacion.getAlumno().getNombre()%></th>
							<th><%=calificacion.getAlumno().getDni()%></th>

							<%if (calificacion.getParcial1() == 0) {%>
							<th><input class="form-control" type="number" value=""
								placeholder="-" style="width: 60px; heigth: 50px" min="1"
								max="10" name="CalificacionAlumno"  id="CalificacionAlumno"/></th>
							<%} else {%>
							<th><input class="form-control" type="number"
								value="<%=calificacion.getParcial1()%>" placeholder="-"
								style="width: 60px; heigth: 50px" min="1" max="10" name="CalificacionAlumno"  id="CalificacionAlumno"/></th>
							<%}%>

							<%if (calificacion.getParcial2() == 0) {%>
							<th><input class="form-control" type="number" value=""
								placeholder="-" style="width: 60px; heigth: 50px" min="1"
								max="10" name="parcial2"  id="parcial2"/></th>
							<%} else {%>
							<th><input class="form-control" type="number"
								value="<%=calificacion.getParcial2()%>" placeholder="-"
								style="width: 60px; heigth: 50px" min="1" max="10" name="CalificacionAlumno"  id="CalificacionAlumno"/></th>
							<%}%>

							<%if (calificacion.getRecu1() == 0) {%>
							<th><input class="form-control" type="number" value=""
								placeholder="-" style="width: 60px; heigth: 50px" min="1"
								max="10" name="CalificacionAlumno"  id="CalificacionAlumno"/></th>
							<%} else {%>
							<th><input class="form-control" type="number"
								value="<%=calificacion.getRecu1()%>" placeholder="-"
								style="width: 60px; heigth: 50px" min="1" max="10" name="CalificacionAlumno"  id="CalificacionAlumno"/></th>
							<%}%>

							<%if (calificacion.getRecu2() == 0) {%>
							<th><input class="form-control" type="number" value=""
								placeholder="-" style="width: 60px; heigth: 50px" min="1"
								max="10" name="CalificacionAlumno"  id="CalificacionAlumno"/></th>
							<%} else {%>
							<th><input class="form-control" type="number"
								value="<%=calificacion.getRecu2()%>" placeholder="-"
								style="width: 60px; heigth: 50px" min="1" max="10" name="CalificacionAlumno"  id="CalificacionAlumno"/></th>
							<%}%>

							<%if (calificacion.getNotafinal() == 0) {%>
							<th><input class="form-control" type="number" value=""
								placeholder="-" style="width: 60px; heigth: 50px" min="1"
								max="10" name="CalificacionAlumno"  id="CalificacionAlumno"/></th>
							<%} else {%>
							<th><input class="form-control" type="number"
								value="<%=calificacion.getNotafinal()%>" placeholder="-"
								style="width: 60px; heigth: 50px" min="1" max="10" name="CalificacionAlumno"  id="CalificacionAlumno"/></th>
							<%}%>

							<th>
								<div class="col">
									<select id="slEstado" name="CalificacionAlumno" class="custom-select">
										<option value="<%=calificacion.getEstado()%>" selected
											style="visibility: hidden"><%=calificacion.getEstado()%></option>
										<option value="Cursando" class="dropdown-item">Cursando</option>
										<option value="Promocionado" class="dropdown-item">Promocionado</option>
										<option value="Regular" class="dropdown-item">Regular</option>
										<option value="Libre" class="dropdown-item">Libre</option>
									</select>
								</div>
							</th>
						</tr>
						<%
							}
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</form>
	
	<script type="text/javascript">
	function cargarNotas(){
		var table = $('#example').DataTable();
		table.rows().invalidate();
		var data = table.rows().data();
		$.post("ServletNota",{"Notas": data}, function(responseJson) {

		});
		
	}
	</script>
	<script src="JS/DataTableListAlumnosDocenteCONFIG.js"></script>
	
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
			  title: 'Las notas se cargaron de manera correcta.'
			})
		}  else{	
				Toast.fire({			
					  icon: 'error',
					  title: 'Hubo un problema. Comunicarse con el área técnica.'
					})
				}
	}
		</script>
</body>
</html>