<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

</head>
<jsp:include page="HeadDocente.jsp"></jsp:include>
<jsp:include page="LibreriasJtable.jsp"></jsp:include>

<link rel="stylesheet" href="Css/JTable.css">


<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
</head>
<body>

	<div class="wrapper">
		<div id="formContent" class="table-responsive">
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th style="text-align: center">Curso</th>
						<th style="text-align: center">Materia</th>
						<th style="text-align: center">Cuatrimestre</th>
						<th style="text-align: center">Año</th>
						<th style="text-align: center">Turno</th>
						<th style="text-align: center">Alumnos</th>
						<th style="text-align: center">Estado</th>
					</tr>
				</thead>
				<tbody>
					</tr>
					<tr>
						<th>21CM</th>
						<th>Programación III</th>
						<th>2C</th>
						<th>2016</th>
						<th>Mañana</th>
						<th><a
							href='http://localhost:8020/TPINT_GRUPO_2_LAB4/ListadoAlumnosDocente.jsp'>Alumnos</a></th>
						<th>Cerrado</th>
					</tr>
					<tr>
						<th>12CN</th>
						<th>Inglés II</th>
						<th>1C</th>
						<th>2020</th>
						<th>Noche</th>
						<th><a
							href='http://localhost:8020/TPINT_GRUPO_2_LAB4/ListadoAlumnosDocente.jsp'>Alumnos</a></th>
						<th>Abierto</th>
					</tr>
					<tr>
						<th>22CM</th>
						<th>Laboratorio de Computación IV</th>
						<th>1C</th>
						<th>2020</th>
						<th>Mañana</th>
						<th><a
							href='http://localhost:8020/TPINT_GRUPO_2_LAB4/ListadoAlumnosDocente.jsp'>Alumnos</a></th>
						<th>Abierto</th>

					</tr>
				</tbody>

			</table>

		</div>
	</div>
</body>
</html>
