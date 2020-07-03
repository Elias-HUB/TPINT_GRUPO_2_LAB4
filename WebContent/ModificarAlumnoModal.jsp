<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Provincia"%>
<%@ page import="Entidad.Localidad"%>
<!-- Inicio Modal -->
<div class="modal fade bd-example-modal-xl" id="ModalAlumnoModificar"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog  modal-xl" role="document">
		<div class="modal-content">
			<div class="modal-header bg-secondary text-white">
				<h5 class="modal-title" id="exampleModalLabel">Alumno</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form action="ServletAlumno" method="post">
				<div class="modal-body">



						<div class="form-row ">

							<%--LEGAJO--%>
							<div class="form-group col-md-1">
								<div>
									<label Class="control-label">Legajo</label>
								</div>
								<input ID="TboxLegajoM" name="TboxLegajoM"
									onKeyPress="return soloNumeros(event)"
									onkeyup="validarLegajo(this.id)" onfocus="Seleccionar(this.id)"
									maxlength="8" placeholder="22012" Class="form-control"
									readonly="readonly">
								<p id="MensajeErrorLegajo"></p>
							</div>


							<%--Nombre--%>
							<div class="form-group col-md-3">
								<div>
									<label Class="control-label">Nombre</label>
								</div>
								<input ID="TboxNombreM" required pattern="[A-Za-z ]+" name="TboxNombreM"
									onkeypress="return soloLetras(event)"
									onkeyup="validarVacio(this.id)" onfocus="Seleccionar(this.id)"
									maxlength="20" placeholder="Agustin" Class="form-control">
								<p id="MensajeErrorNombre"></p>
							</div>

							<%--Apellido--%>
							<div class="form-group col-md-3">
								<div>
									<label Class="control-label">Apellido</label>
								</div>
								<input ID="TboxApellidoM" required pattern="[A-Za-z ]+" name="TboxApellidoM"
									onkeypress="return soloLetras(event)"
									onkeyup="validarVacio(this.id)" onfocus="Seleccionar(this.id)"
									maxlength="20" placeholder="Argento" Class="form-control">
								<p id="MensajeErrorApellido"></p>
							</div>

							<%--Dni--%>
							<div class="form-group col-md-2">
								<div>
									<label Class="control-label">Dni</label>
								</div>
								<input id="TboxDniM" required pattern="[0-9]+" name="TboxDniM"
									onkeypress="return soloNumeros(event)"
									onkeyup="validarVacio(this.id)" onfocus="Seleccionar(this.id)"
									minlength="8" maxlength="8" placeholder="40174332" Class="form-control">
								<p id="MensajeErrorADni"></p>
							</div>
						</div>

	



					<div class="form-row ">

						<%--FechaNacimiento--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Fecha Nacimiento</label>
							</div>
							<input type="date" required pattern="[0-9]+" ID="TboxFechaNacimientoM"
								name="TboxFechaNacimientoM" max="3000-12-31" min="1900-01-01"
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

								<input ID="TboxEmailM" required type= "email" name="TboxEmailM"
									onkeyup="validarEmail()" onfocus="Seleccionar(this.id)"
									maxlength="33" placeholder="Example@gmail.com"
									Class="form-control">
								<p id="MensajeErrorEmail"></p>
							</div>
						</div>


						<%--Telefono--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Telefono</label>
							</div>
							<input ID="TboxTelefonoM" required pattern="[0-9]+" name="TboxTelefonoM"
								onkeypress="return soloNumeros(event)"
								onkeyup="validarVacio(this.id)" onfocus="Seleccionar(this.id)"
								minlength="8" maxlength="15" placeholder="1157412365" Class="form-control">
							<p id="MensajeErrorTelefono"></p>
						</div>

					</div>

					<div class="form-row">

						<%--Dirrecion--%>
						<div class="form-group col-md-5" style="margin-top: 7px">
							<div>
								<label Class="control-label">Dirección</label>
							</div>
							<input ID="TboxDirreccionM" required name="TboxDirreccionM"
								onkeyup="validarVacio(this.id)" onfocus="Seleccionar(this.id)"
								maxlength="40" placeholder="Avenida Siempreviva 742"
								Class="form-control">
							<p id="MensajeErrorDireccion"></p>
						</div>

						<%--Provincia--%>
						<div class="form-group col-md-3">
							<label for="TboxProvinciaM" class="col-form-label">Provincia</label>
							<select id="TboxProvinciaM" name="TboxProvinciaM"
								class="form-control" tabindex="6" onchange="cambia_Localidad()">
								
					<%
						ArrayList<Provincia> lista = null;
						if (request.getAttribute("ListaProvincia") != null) {
							lista = (ArrayList<Provincia>) request.getAttribute("ListaProvincia");
						}

						if (lista != null) {
							for (Provincia provincia : lista) {
					%>
					<option value="<%=provincia.getID()%>" ><%=provincia.getNombre()%></option>
								<%
							}}
								%>	
							</select>
						</div>


						<%--Localidad--%>
						<div class="form-group col-md-3">
							<label for="TboxLocalidadM" class="col-form-label">Localidad</label>
							<select id="TboxLocalidadM" name="TboxLocalidadM"
								class="form-control" tabindex="6">
								
					<%
						ArrayList<Localidad> ListaLocalidades = null;
						if (request.getAttribute("ListaLocalidad") != null) {
							ListaLocalidades = (ArrayList<Localidad>) request.getAttribute("ListaLocalidad");
						}

						if (lista != null) {
							for (Localidad localidad : ListaLocalidades) {
					%>
					<option value="<%=localidad.getID()%>"><%=localidad.getNombre()%></option>
								<%
							}}
								%>	
							</select>
						</div>

					</div>
				</div>

				<!-- 			______________________________________________________ -->
				<div class="modal-footer">
					<button type="submit" id="BtnActualizar" name="BtnActualizar"
						class="btn btn-primary">Actualizar</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cerrar</button>

				</div>
		</div>
		</form>
	</div>
</div>
</div>

<!-- Inicio Modal -->