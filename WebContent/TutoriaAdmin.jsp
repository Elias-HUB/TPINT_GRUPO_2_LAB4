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
<jsp:include page="HeadAdministrador.jsp"></jsp:include>
<jsp:include page="LibreriasJtable.jsp"></jsp:include>
<link rel="stylesheet" href="Css/JTable.css">


</head>
<body>

	<br>
	<div>
	<form action="ServletTutoria" method="post">
		<div class="form-row" style="justify-content: center;">

			<!--DOCENTE -->
			<div class="form-group col-md-2">
				<div>
					<label for="Docente">Docente</label>
				</div>
				<%
					ArrayList<Docente> listaDocentes = null;
					if (request.getAttribute("ListaTutoria") != null) {
						listaDocentes = (ArrayList<Docente>) request.getAttribute("ListaDocentes");
					}

					if (listaDocentes != null) {
				%>
				<select id="slDocente" name="slDocente" class="custom-select">
					<%
						for (Docente doc : listaDocentes) {
					%>
					<option value=<%=doc.getLegajo()%> class="dropdown-item"><%=doc.getLegajo()%>
						<%=doc.getNombre()%>
						<%=doc.getApellido()%></option>

					<%
						}
					%>

					<%
						}
					%>
				</select>
			</div>

			<!--ALUMNO -->
			<div class="form-group col-md-2">
				<div>
					<label for="Alumno">Alumno</label>
				</div>
				<%
					ArrayList<Alumno> listaAlumnos = null;
					if (request.getAttribute("ListaAlumnos") != null) {
						listaAlumnos = (ArrayList<Alumno>) request.getAttribute("ListaAlumnos");
					}

					if (listaAlumnos != null) {
				%>
				<select id="slAlumno" name="slAlumno" class="custom-select">
					<%
						for (Alumno alu : listaAlumnos) {
					%>
					<option value=<%=alu.getLegajo()%> class="dropdown-item"><%=alu.getLegajo()%>
						<%=alu.getNombre()%><%=alu.getApellido()%>
					</option>

					<%
						}
					%>

					<%
						}
					%>
				</select>

			</div>
			
			<div class="form-group col-md-2" style="margin-top: 32px;">
				<button type="submit" id="BtnAsignarTutor" name="BtnAsignarTutor"
					class="btn btn-light Sombra">Asignar Tutor</button>
			</div>
			</form>

		</div>
		<br>
		<div></div>


		<div class="wrapper">
			<div id="formContent" class="table-responsive">
				<table id="example" class="table table-striped table-bordered"
					style="width: 100%">
					<thead class="thead-dark">
						<tr>
							<th style="text-align: center">Legajo Docente</th>
							<th style="text-align: center">Docente</th>
							<th style="text-align: center">Email</th>
							<th style="text-align: center">Legajo Alumno</th>
							<th style="text-align: center">Alumno</th>
							<th style="text-align: center">Email</th>
							<th style="text-align: center">Acciones</th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<Tutoria> listaTut = null;
							ArrayList<Docente> listaDoc = null;
							ArrayList<Alumno> listaAlu = null;

							if (request.getAttribute("ListaTutoria") != null) {
								listaTut = (ArrayList<Tutoria>) request.getAttribute("ListaTutoria");
								listaDoc = (ArrayList<Docente>) request.getAttribute("ListaDocentes");
								listaAlu = (ArrayList<Alumno>) request.getAttribute("ListaAlumnosTodos");
							}
							if (listaTut != null) {
								for (Tutoria tut : listaTut) {
						%>
						<tr>
							<form action="ServletTutoria" method="get">
								<th><%=tut.getLegajoDocente()%></th>
								<%
									for (Docente doc : listaDoc) {
										if (doc.getLegajo() == tut.getLegajoDocente()) {
								%>
								<th><%=doc.getNombre()%> <%=doc.getApellido()%></th>
								<th><%=doc.getEmail()%></th>
								<%
										}
									}
								%>
								<th><%=tut.getLegajoAlumno()%></th>
								<%
									for (Alumno alu : listaAlu) {
										if (alu.getLegajo() == tut.getLegajoAlumno()) {
								%>
								<th><%=alu.getNombre()%> <%=alu.getApellido()%></th>
								<th><%=alu.getEmail()%></th>
								<%
										}
									}
								%>

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