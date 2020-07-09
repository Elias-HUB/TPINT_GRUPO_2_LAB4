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
<%
		session = request.getSession();
		if(session.getAttribute("Legajo") == null) {
		request.getRequestDispatcher("Login.jsp").forward(request, response);}
%>

	<div class="wrapper">
		<div id="formContent" class="table-responsive">
		
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

							if (request.getAttribute("ListaCursosRecuperar") != null) {
								lista = (ArrayList<Curso>) request.getAttribute("ListaCursosRecuperar");
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
							</a> 
							<a href="ServeletCurso?ParamRecuperar=<%=curso.getId()%>"
								class="btn btn-outline-warning" > <img src="Imagenes/revertir.png"
									Width="22px" data-toggle="tooltip" title="Recuperar Curso" /></a>
					</th>

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
	if(request.getAttribute("Mensaje")!=null)
	{
		String Resultado = request.getAttribute("Mensaje").toString();
		%>mostrarToast("<%=Resultado%>")<%
		request.setAttribute("Mensaje",null);
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
		if(ToastR == "Recuperado"){	
			Toast.fire({			
			  icon: 'success',
			  title: 'El curso se recupero de manera correcta.'
			})
		} 
	} 
		</script>
</body>
</html>