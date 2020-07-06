$(document)
		.ready(
				function() {					
					$('#example')
							.DataTable(
									{
										"columnDefs" : [ {
											"orderable" : false,
											"targets" : [ 5 ]
										} ],
										"lengthMenu" : [ [ 5, 10, -1 ],
												[ 5, 10, "Todos" ] ],
										// Para cambiar el lenguaje a español
										language : {
											"lengthMenu" : "Mostrar _MENU_ registros",
											"zeroRecords" : "No se encontraron resultados",
											"info" : "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
											"infoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
											"infoFiltered" : "(filtrado de un total de _MAX_ registros)",
											"sSearch" : "Buscar:",
											"oPaginate" : {
												"sFirst" : "Primero",
												"sLast" : "Último",
												"sNext" : "Siguiente",
												"sPrevious" : "Anterior"
											},
											"sProcessing" : "Procesando...",
										},
										// para usar los botones
										dom : 'lfrBtip',
										buttons : [
												{
													extend : 'copy',
													text : '<i class="fa fa-copy"></i> ',
													titleAttr : 'Copiar todo',
													className : 'btn btn-secondary',
													exportOptions : {
														columns : ':visible'
													}
												},
												{
													extend : 'excel',
													text : '<i class="fas fa-file-excel"></i> ',
													titleAttr : 'Exportar a Excel',
													className : 'btn btn-success',
													exportOptions : {
														columns : ':visible'
													}
												},
												{
													extend : 'pdfHtml5',
													text : '<i class="fas fa-file-pdf"></i> ',
													titleAttr : 'Exportar a PDF',
													className : 'btn btn-danger',
													exportOptions : {
														columns : ':visible'
													}
												},
												{
													extend : 'print',
													text : '<i class="fa fa-print"></i>',
													titleAttr : 'Imprimir',
													className : 'btn btn-info',
													exportOptions : {
														columns : ':visible'
													}
												},
												{
													extend : 'columnToggle',
													text : '<i class="fa fa-eye-slash" ></i> ',
													titleAttr : 'Sacar Columna Acciones',
													className : 'btn btn-info',
													columns : 5
												}, ]
									});
				});