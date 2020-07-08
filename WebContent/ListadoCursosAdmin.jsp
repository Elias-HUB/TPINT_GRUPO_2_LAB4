<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Curso"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Toast -->
<link rel="stylesheet" href="@sweetalert2/theme-bootstrap-4/bootstrap-4.css">
<script src="sweetalert2/dist/sweetalert2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

<jsp:include page="HeadAdministrador.jsp"></jsp:include>
<jsp:include page="LibreriasJtable.jsp"></jsp:include>

<link rel="stylesheet" href="Css/JTable.css">
</head>
<body>

	<div class="wrapper">
		<div id="formContent" class="table-responsive">
			<form method="post" action="ServeletCurso">
				<button type="submit" class="btn btn-block btn-outline-info"
					id="btnAgregarCurso" name="btnAgregarCurso"
					style="margin-bottom: 10px;">Agregar Curso</button>
			</form>
			<form method="get" action="ServeletCurso">
				<table id="example" class="table table-striped table-bordered"
					style="width: 100%">
					<thead >
						<tr>
							<th style="text-align: center">Curso</th>
							<th style="text-align: center">Materia</th>
							<th style="text-align: center">Cuatrimestre</th>
							<th style="text-align: center">Año</th>
							<th style="text-align: center">Turno</th>
							<th style="text-align: center">Docente</th>
							<th style="text-align: center">Acciones</th>
						</tr>
					</thead>
					<tbody>

						<%
							ArrayList<Curso> lista = null;

							if (request.getAttribute("ListaCursosAdmin") != null) {
								lista = (ArrayList<Curso>) request.getAttribute("ListaCursosAdmin");
							}
						%>

						<%
							if (lista != null) {
								for (Curso curso : lista) {
						%>
						<tr>
							<th><%=curso.getId()%> <input id=txtidCurso
								name="txtidCurso" value="<%=curso.getId()%>"
								style="visibility: hidden"></th>
							<th ><%=curso.Materia.getNombre()%></th>
							<th ><%=curso.getCuatrimestre()%></th>
							<th ><%=curso.getAño()%></th>
							<th ><%=curso.getTurno()%></th>
							<th ><%=curso.docente.getNombre()%> <%=curso.docente.getApellido()%></th>
							<th ><a
								href="ServletAlumno?ParamAlumnoXCursoAdmin=<%=curso.getId()%>"
								class="btn btn-outline-primary"> <img src="Imagenes/Ver.png"
									Width="22px" data-toggle="tooltip" data-placement="bottom"
									title="Ver alumnos" alt="x" />
							</a> <a href="ServeletCurso?ParamModificarCurso=<%=curso.getId()%>"
								class="btn btn-outline-warning" id="btnModificarCurso"
								name="btnModificarCurso"> <img src="Imagenes/Editar.png"
									Width="22px" data-toggle="tooltip" title="Modificar Curso" /></a>


								<button type="submit" id="BtnEliminar" name="BtnEliminar"
									class="btn btn-outline-danger">
									<img src="Imagenes/Eliminar.png" Width="22px" alt="x"
										data-toggle="tooltip" data-placement="bottom"
										title="Eliminar Alumno" />
								</button></th>

						</tr>

						<%
							}
							}
						%>

					</tbody>
				</table>
			</form>
		</div>
	</div>

	<script src="JS/DataTableListCursosAdminCONFIG.js"></script>
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
			  title: 'El curso se agregó de manera correcta.'
			})
		} else if(ToastR == "Eliminado"){	
			Toast.fire({			
			  icon: 'success',
			  title: 'El curso se eliminó de manera correcta.'
			})
		} else if(ToastR == "Modificado"){	
			Toast.fire({			
				  icon: 'success',
				  title: 'El curso se modificó de manera correcta.'
				})
			} else{	
				Toast.fire({			
					  icon: 'error',
					  title: 'Hubo un problema. Comunicarse con el área técnica.'
					})
				}
	}
	</script>
</body>
</html>