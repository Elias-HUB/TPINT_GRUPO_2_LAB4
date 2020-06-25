function ModalVerCargaDatos(datos) {
	var alumno = datos.split('||');
	$("#TboxLegajo").val(alumno[0]);
	$("#TboxNombre").val(alumno[1]);
	$("#TboxApellido").val(alumno[2]);
	$("#TboxFechaNacimiento").val(alumno[3]);
	$("#TboxEmail").val(alumno[4]);
	$("#TboxTelefono").val(alumno[5]);
	$("#TboxDirreccion").val(alumno[6]);
	$("#TboxProvincia").val(alumno[7]);
	$("#TboxLocalidad").val(alumno[8]);
	$("#TboxDni").val(alumno[9]);
	jQuery.noConflict();
	$('#ModalAlumnoVer').modal('show');
	$('#ModalAlumnoVer').find('.modal-title').text("Alumno")
}

function cambia_Localidad(){ 
	var ProvinciaId;
	ProvinciaId = document.getElementById('TboxProvinciaM').value;
	$.ajax({
		type : 'POST',
		url : 'ServeletLocalidad',
		dataType : "json",
		data : {
			Provinciaid : ProvinciaId
		},
		success : function(result) {
			if (result) {
				$("#TboxLocalidadM option:not(:disabled)").remove();
				$.each(result, function(index, option) {
					console.log("option: " + option)
					$("#TboxLocalidadM").append(
							'<option value="' + option.ID + '">'
									+ option.Nombre + '</option>')					
				});
			}
		},
		error : function(data) {
			alert('fail');
		}
	})
};

function ModalModificarCargaDatos(datos) {
	var alumno = datos.split('||');
	$("#TboxLegajoM").val(alumno[0]);
	$("#TboxNombreM").val(alumno[1]);
	$("#TboxApellidoM").val(alumno[2]);
	$("#TboxFechaNacimientoM").val(alumno[3]);
	$("#TboxEmailM").val(alumno[4]);
	$("#TboxTelefonoM").val(alumno[5]);
	$("#TboxDirreccionM").val(alumno[6]);
	$("#TboxDniM").val(alumno[9]);
	$("#TboxProvinciaM").val(alumno[10]);
	var ProvinciaId;
	ProvinciaId = document.getElementById('TboxProvinciaM').value;
	$.ajax({
		type : 'POST',
		url : 'ServeletLocalidad',
		dataType : "json",
		data : {
			Provinciaid : ProvinciaId
		},
		success : function(result) {
			if (result) {
				$("#TboxLocalidadM option:not(:disabled)").remove();
				$.each(result, function(index, option) {
					console.log("option: " + option)
					$("#TboxLocalidadM").append(
							'<option value="' + option.ID + '">'
									+ option.Nombre + '</option>')
					jQuery.noConflict();
					$('#ModalAlumnoModificar').modal('show');
					$('#ModalAlumnoModificar').find('.modal-title').text(
							"Modificar Alumno");
					$("#TboxLocalidadM").val(alumno[11]);
				});
			}
		},
		error : function(data) {
			alert('fail');
		}
	})
}

function Cambia_Localidad() {
	var Provincia;
	Provincia = document.getElementById('TboxProvinciaM').value;
}

$(document)
		.ready(
				function() {

					$('#example')
							.DataTable(
									{
										"columnDefs" : [ {
											"orderable" : false,
											"targets" : [ 4 ]
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
													columns : 4
												}, ]
									});
					
				});
//ACA TA BIEN

