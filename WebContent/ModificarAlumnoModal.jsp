<!-- Modal -->
<div class="modal fade bd-example-modal-xl" id="ModalAlumnoModificar" tabindex="-1"
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
			<div class="modal-body">
				<!-- 			______________________________________________________ -->


				<div class="container">

					<div class="form-row ">

						<%--LEGAJO--%>
						<div class="form-group col-md-1">
							<div>
								<label Class="control-label">Legajo</label>
							</div>
							<input ID="TboxLegajo" onKeyPress="return soloNumeros(event)"
								onkeyup="validarLegajo(this.id)" onfocus="Seleccionar(this.id)"
								maxlength="8" placeholder="22012" Class="form-control">
							<p id="MensajeErrorLegajo"></p>
						</div>


						<%--Nombre--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Nombre</label>
							</div>
							<input ID="TboxNombre" onkeypress="return soloLetras(event)"
								onkeyup="validarVacio(this.id)" onfocus="Seleccionar(this.id)"
								maxlength="20" placeholder="Agustin" Class="form-control">
							<p id="MensajeErrorNombre"></p>
						</div>

						<%--Apellido--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Apellido</label>
							</div>
							<input ID="TboxApellido" onkeypress="return soloLetras(event)"
								onkeyup="validarVacio(this.id)" onfocus="Seleccionar(this.id)"
								maxlength="20" placeholder="Argento" Class="form-control">
							<p id="MensajeErrorApellido"></p>
						</div>
					</div>

					<div class="form-row ">

						<%--FechaNacimiento--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Fecha Nacimiento</label>
							</div>
							<input type="date" ID="TboxFechaNacimiento" name="bday" max="3000-12-31" min="1995-01-01"
								class="form-control">
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

								<input ID="TboxEmail" onkeyup="validarEmail()"
									onfocus="Seleccionar(this.id)" maxlength="33"
									placeholder="Example@gmail.com" Class="form-control">
								<p id="MensajeErrorEmail"></p>
							</div>
						</div>


						<%--Telefono--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Telefono</label>
							</div>
							<input ID="TboxTelefono" onkeypress="return soloNumeros(event)"
								onkeyup="validarVacio(this.id)" onfocus="Seleccionar(this.id)"
								maxlength="15" placeholder="1157412365" Class="form-control">
							<p id="MensajeErrorTelefono"></p>
						</div>

					</div>

					<div class="form-row">

						<%--Dirrecion--%>
						<div class="form-group col-md-5">
							<div>
								<label Class="control-label">Dirección</label>
							</div>
							<input ID="TboxDirreccion" onkeyup="validarVacio(this.id)"
								onfocus="Seleccionar(this.id)" maxlength="40"
								placeholder="Avenida Siempreviva 742" Class="form-control">
							<p id="MensajeErrorDireccion"></p>
						</div>

						<%--Localidad--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Localidad</label>
							</div>
							<input ID="TboxLocalidad" onkeyup="validarVacio(this.id)"
								onfocus="Seleccionar(this.id)" maxlength="20"
								placeholder="Talar" Class="form-control">
							<p id="MensajeErrorLocalidad"></p>
						</div>

						<%--Provincia--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Provincia</label>
							</div>
							<input ID="TboxProvincia" onKeyPress="return soloNumeros(event)"
								onkeyup="validarVacio(this.id)" onfocus="Seleccionar(this.id)"
								maxlength="16" placeholder="Buenos Aires" Class="form-control">
							<p id="MensajeErrorCP"></p>
						</div>
					</div>
				</div>

				<!-- 			______________________________________________________ -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cerrar</button>

				</div>
			</div>
		</div>
	</div>
</div>