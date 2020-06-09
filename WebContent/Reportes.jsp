<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="HeadAdministrador.jsp"></jsp:include>
<jsp:include page="ReporteJS.jsp"></jsp:include>
<jsp:include page="Librerias.jsp"></jsp:include>
<link rel="stylesheet" href="Css/ReporteCss.css">

</head>
<body>
	<div>
  <select class="custom-select" id="inputGroupSelect01">
    <option selected>Choose...</option>
    <option value="1">One</option>
    <option value="2">Two</option>
    <option value="3">Three</option>
  </select>
	</div>
<!-- 	<div class="wrapper fadeInDown"> -->
<!-- 		<div id="formContent"> -->
<!-- 			<canvas id="myChart"></canvas> -->
<!-- 		</div> -->
<!-- 	</div> -->
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