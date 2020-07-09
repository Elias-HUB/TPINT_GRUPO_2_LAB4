$(document)
		.ready(
				function() {

					$('#example')
							.DataTable(
									{
										"columnDefs" : [ {
											"orderable" : false,
											"targets" : [ 0 ]
										} ],
										"lengthMenu" : [ [ 5, 10, -1 ],
												[ 5, 10, "Todos" ] ],
										// Para cambiar el lenguaje a espa�ol
										language : {
											"lengthMenu" : "Mostrar _MENU_ registros",
											"zeroRecords" : "No se encontraron resultados",
											"info" : "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
											"infoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
											"infoFiltered" : "(filtrado de un total de _MAX_ registros)",
											"sSearch" : "Buscar:",
											"oPaginate" : {
												"sFirst" : "Primero",
												"sLast" : "ultimo",
												"sNext" : "Siguiente",
												"sPrevious" : "Anterior"
											},
											"sProcessing" : "Procesando...",
										},									
									});					
				});