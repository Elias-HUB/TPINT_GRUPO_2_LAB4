<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Materia"%>
<%@ page import="Entidad.Docente"%>
<%@ page import="Entidad.Alumno"%>
<%@ page import="Entidad.Tutoria"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Toast -->
<link rel="stylesheet" href="@sweetalert2/theme-bootstrap-4/bootstrap-4.css">
<script src="sweetalert2/dist/sweetalert2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

<!-- Head -->
<jsp:include page="HeadDocente.jsp"></jsp:include>
<jsp:include page="LibreriasJtable.jsp"></jsp:include>
<link rel="stylesheet" href="Css/JTable.css">


</head>
<body>

	<br>
	<div>
	

		</div>
		<br>
		<div></div>


		<div class="wrapper">
			<div id="formContent" class="table-responsive">
				<table id="example" class="table table-striped table-bordered"
					style="width: 100%">
					<thead class="thead-dark">
						<tr>
							<th style="text-align: center">Legajo</th>
							<th style="text-align: center">Dni</th>
							<th style="text-align: center">Nombre</th>
							<th style="text-align: center">Apellido</th>
							<th style="text-align: center">Email</th>
							<th style="text-align: center">Observaciones</th>
							<th style="text-align: center">Acciones</th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<Tutoria> listaTut = null;
							ArrayList<Alumno> listaAlu = null;

							if (request.getAttribute("ListaTutoriaDoc") != null) {
								listaTut = (ArrayList<Tutoria>) request.getAttribute("ListaTutoriaDoc");
								listaAlu = (ArrayList<Alumno>) request.getAttribute("ListaAlumnosTodos");
							}
							if (listaTut != null) {
								for (Tutoria tut : listaTut) {
						%>
						<tr>
							<form action="ServletTutoria" method="get">
								
								<th><%=tut.getLegajoAlumno()%></th>
								
								<%for(Alumno alu : listaAlu)
								{
									if(tut.getLegajoAlumno() == alu.getLegajo())
									{%>
										<th><%=alu.getDni()%></th>
										<th><%=alu.getNombre()%></th>
										<th><%=alu.getApellido()%></th>
										<th><%=alu.getEmail()%></th>
									<%}
								} %>
								<th><%=tut.getObservaciones()%></th>
								
								<th style="width: 250px;">
									<!-- Button trigger modal --> 
									<a href="ServletTutoria?ParamLegajoDocente=<%=tut.getLegajoDocente()%>&ParamLegajoAlumno=<%=tut.getLegajoAlumno()%>"
								    class="btn btn-outline-primary"><img src="Imagenes/Eliminar.png" Width="22px" data-toggle="tooltip"
									data-placement="bottom" title="Eliminar" alt="x" /></a>

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
		
		<script src="JS/DataTableTutoriaAdminCONFIG.js"></script>		

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
			  title: 'La asignación de tutor se creó manera correcta.'
			})
		} else if(ToastR == "Eliminado"){	
			Toast.fire({			
			  icon: 'success',
			  title: 'La asignación de tutor eliminó de manera correcta.'
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
	</script>
	</div>

	

</body>
</html>