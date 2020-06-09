<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="HeadAdministrador.jsp"></jsp:include>
<jsp:include page="ReporteJS.jsp"></jsp:include>
<jsp:include page="Librerias.jsp"></jsp:include>
<jsp:include page="CorrectoModal.jsp"></jsp:include>
<link rel="stylesheet" href="Css/ReporteCss.css">

</head>
<body>

	<div class="row Centrado" style="margin-top: 10px; max-width: 99%;">
		<div class="col-3">
			<select class="custom-select Sombra" selectedindex=-1 id="selectGrafico">
				<option value="1">Grafico de Barras</option>
				<option value="2">Grafico de Torta</option>
				<option value="3">Listado</option>
			</select>
		</div>
		<div class="col-7">
			<select class="custom-select Sombra" selectedindex=-1
				id="selectTipoReporte ">
				<option value="1">Porcentaje aprobados por materia</option>
				<option value="2">Porcentaje Libres, Regularizados y
					Promocionados por materia</option>
				<option value="3">Cantidad de alumnos por materia</option>
			</select>
		</div>
	</div>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<canvas id="myChart"></canvas>
		</div>
	</div>
</body>
<script>
	var ctx = document.getElementById("myChart").getContext("2d");
	var myChart = new Chart(ctx, {
		type : "pie",
		data : {
			labels : [ 'Programacion I', 'Laboratorio III', 'Estadistica',
					'Diseño y Administración de Base de Datos' ],
			datasets : [ {
				label : 'Num datos',
				data : [ 10, 20, 15, 2 ],
				backgroundColor : [ 'rgb(66, 134, 244,1)',
						'rgb(74, 135, 72,1)', 'rgb(229, 89, 50,1)',
						'rgb(51, 255, 230,1)' ]
			} ]
		},
	});
</script>
</html>