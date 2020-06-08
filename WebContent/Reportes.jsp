<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <link rel="stylesheet" href="Css/LoginCss.css">
    	<jsp:include page="Librerias.jsp"></jsp:include>
    	<jsp:include page="HeadAdministrador.jsp"></jsp:include>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.css">
    </head>
    <body>
    <div class="wrapper fadeInDown">
    <div id="formContent">
        <canvas id="myChart"></canvas>
        </div>
        </div>
    </body>
    <script>
        var ctx= document.getElementById("myChart").getContext("2d");
        var myChart= new Chart(ctx,{
            type:"pie",
            data:{
                labels:['Programacion I','Laboratorio III','Estadistica','Estadistica','Estadistica'],
                datasets:[{
                        label:'Num datos',
                        data:[10,20,15,2,8],
                        backgroundColor:[
                            'rgb(66, 134, 244,1)',
                            'rgb(74, 135, 72,1)',
                            'rgb(229, 89, 50,1)',
                            'rgb(51, 255, 230,1)',
                            'rgb(181, 51, 255,1)'
                        ]
                }]
            },
        });
    </script>
</html>