<!-- Modal -->
<div class="modal fade modal-xl" id="ModalAlumnoVer" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog  modal-xl" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Alumno</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body modal-xl">

				<%--Legajo--%>
				<div>
					<label for="Legajo">Legajo</label> <input type="text"
						id="txtLegajo" name="Legajo" readonly>

					<%--Nombre--%>
					<label for="Nombre">Nombre</label> <input type="text"
						id="txtNombre" name="Nombre" readonly>
					<%--Apellido--%>
					<label for="Apellido">Apellido</label> <input type="text"
						id="txtApellido" name="Apellido" readonly>
				</div>
				<br>
				<%--Fecha nac--%>
				<div>
					<label for="FechaNac">Fecha Nacimiento</label> <input type="text"
						id="txtFechaNac" name="FechaNac" readonly> <label
						for="Email">Email</label> <input type="Email" id="txtEmail"
						name="Email" readonly> <label for="Telefono">Telefono</label>
					<input type="Telefono" id="txtTelefono" name="Telefono" readonly>
				</div>
				<br>
				<div>
					<label for="Direccion">Direccion</label> <input type="text"
						id="txtDireccion" name="Direccion" readonly> <label
						for="Localidad">Localidad</label> <input type="text"
						id="txtLocalidad" name="Localidad" readonly> <label
						for="´Provincia">Provincia</label> <input type="Provincia"
						id="txtProvincia" name="Provincia" readonly>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cerrar</button>

				</div>
			</div>
		</div>
	</div>
</div>