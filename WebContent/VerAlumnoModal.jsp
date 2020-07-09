<!-- Modal -->
<div class="modal fade bd-example-modal-xl zoomIn" id="ModalAlumnoVer"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog  modal-xl" role="document">
		<div class="modal-content">
			<div class="modal-header Cabecera text-white">
				<h5 class="modal-title" id="exampleModalLabel">Alumno</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">




					<div class="form-row">

						<%--LEGAJO--%>
						<div class="form-group col-md-1">
							<div>
								<label Class="control-label">Legajo</label>
							</div>
							<input id="TboxLegajo" name="TboxLegajo"
								Class="form-control input_valores_provisionales"
								readonly="readonly">
							<p id="MensajeErrorLegajo"></p>
						</div>


						<%--Nombre--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Nombre</label>
							</div>
							<input ID="TboxNombre" Class="form-control" readonly="readonly">
							<p id="MensajeErrorNombre"></p>
						</div>

						<%--Apellido--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Apellido</label>
							</div>
							<input ID="TboxApellido" Class="form-control" readonly="readonly">
							<p id="MensajeErrorApellido"></p>
						</div>
						
						<%--Dni--%>
							<div class="form-group col-md-3">
								<div>
									<label Class="control-label">Dni</label>
								</div>
								<input id="TboxDni" Class="form-control" readonly="readonly">
								<p id="MensajeErrorDni"></p>
							</div>
						</div>



					
						
					<div class="form-row ">

						<%--FechaNacimiento--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Fecha Nacimiento</label>
							</div>
							<input type="date" ID="TboxFechaNacimiento" class="form-control"
								readonly="readonly">
						</div>

						<%--Email--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Email</label>
							</div>

							<div class="input-group">
								<div class="input-group-prepend">
									<div class="input-group-text">@</div>
								</div>

								<input ID="TboxEmail" Class="form-control" readonly="readonly">
								<p id="MensajeErrorEmail"></p>
							</div>
						</div>


						<%--Telefono--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Telefono</label>
							</div>
							<input ID="TboxTelefono" Class="form-control" readonly="readonly">
							<p id="MensajeErrorTelefono"></p>
						</div>

					</div>

					<div class="form-row">

						<%--Dirrecion--%>
						<div class="form-group col-md-5">
							<div>
								<label Class="control-label">Dirección</label>
							</div>
							<input ID="TboxDirreccion" Class="form-control"
								readonly="readonly">
							<p id="MensajeErrorDireccion"></p>
						</div>

						<%--Provincia--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Provincia</label>
							</div>
							<input ID="TboxProvincia" Class="form-control"
								readonly="readonly">
							<p id="MensajeErrorProvincia"></p>
						</div>
						
						<%--Localidad--%>						
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Localidad</label>
							</div>
							<input ID="TboxLocalidad" Class="form-control"
								readonly="readonly">
							<p id="MensajeErrorLocalidad"></p>
						</div>
					</div>
				</div>


				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cerrar</button>

				</div>
			</div>
		</div>
	</div>
</div>