<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Curso"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="HeadDocente.jsp"></jsp:include>
</head>
<body>
<div class="row" style="margin-left: 25px; margin-right: 25px;">
	
    	<%
						ArrayList<Curso> lista = null;

						if (request.getAttribute("ListaCursos") != null) {
							lista = (ArrayList<Curso>) request.getAttribute("ListaCursos");
						}
					
						if (lista != null) {
							for (Curso curso : lista) {
					%>
				 
        <div class="col-sm-4" style="margin-top: 25px;">
            <div class="card">
                <div class="card text-center border-info">
                    <div class="card-header bg-white">
                    <h1><%=curso.Materia.getNombre()%></h1>
                    </div>
                    <div class="card-body ">
                        <h5 class="card-title"> <%=curso.getAño()%> <%=curso.getCuatrimestre()%>C</h5>
                        <p class="card-text"><%=curso.getTurno()%></p>
                        <p class="card-text"><%=curso.docente.getNombre()%> <%=curso.docente.getApellido()%></p>
                    <a href="ListadoAlumnosDocente.jsp" class="btn btn-lg btn-info">Alumnos</a>
                    </div>
                    <div class="card-footer bg-transparent">
                       
                    </div>
                </div>
            </div>
        </div>
       

						<%
							}
							}
						%>
						
						    </div>
</body>
</html>