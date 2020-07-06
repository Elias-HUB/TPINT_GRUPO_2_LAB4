$( document ).ready(function() {
    var now = new Date();
    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);
    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
    $("#TboxFechaNacimientoA").val(today);  
});

function mostrarPassword(){
	var cambio = document.getElementById("txtPassword");
	if(cambio.type == "password"){
		cambio.type = "text";
		$('.icon').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
	}else{
		cambio.type = "password";
		$('.icon').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
	}
}

function mostrarPasswordA(){
	var cambio = document.getElementById("txtPasswordA");
	if(cambio.type == "password"){
		cambio.type = "text";
		$('.icon').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
	}else{
		cambio.type = "password";
		$('.icon').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
	}
} 


function ModalDocenteAgregar() {
	$("#TboxProvincia").val('1');
	$("#TboxLocalidad").val('1');
	jQuery.noConflict();
	$('#ModalDocenteAgregar').modal('show');
}

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
	$('#ModalDocenteVer').modal('show');
	$('#ModalDocenteVer').find('.modal-title').text("Docente")
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

function cambia_LocalidadAgregar(){ 
	var ProvinciaId;
	ProvinciaId = document.getElementById('TboxProvinciaA').value;
	$.ajax({
		type : 'POST',
		url : 'ServeletLocalidad',
		dataType : "json",
		data : {
			Provinciaid : ProvinciaId
		},
		success : function(result) {
			if (result) {
				$("#TboxLocalidadA option:not(:disabled)").remove();
				$.each(result, function(index, option) {
					console.log("option: " + option)
					$("#TboxLocalidadA").append(
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
					$('#ModalDocenteModificar').modal('show');
					$('#ModalDocenteModificar').find('.modal-title').text(
							"Modificar Docente");
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


