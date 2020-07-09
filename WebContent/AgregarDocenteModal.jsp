<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Provincia"%>
<%@ page import="Entidad.Localidad"%>

<!-- Modal -->
<div class="modal fade bd-example-modal-xl zoomIn" id="ModalDocenteAgregar"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog  modal-xl" role="document">
		<form action="ServletDocente" method="post">
			<div class="modal-content">
				<div class="modal-header Cabecera text-white">
					<h5 class="modal-title" id="exampleModalLabel">Agregar Nuevo
						Docente</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="form-row ">

						<%--Nombre--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Nombre</label>
							</div>
							<input ID="TboxNombreA" required pattern="[A-Za-z ]+" name="TboxNombreA"
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
							<input ID="TboxApellidoA" required pattern="[A-Za-z ]+" name="TboxApellidoA"
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
							<input id="TboxDniA" required pattern="[0-9]+" name="TboxDniA"
								onkeypress="return soloNumeros(event)"
								onkeyup="validarVacio(this.id)" onfocus="Seleccionar(this.id)"
								minlength="8" maxlength="8" placeholder="40174332" Class="form-control">
							<p id="MensajeErrorADni"></p>
						</div>
					</div>



					<div class="form-row ">
						<%--Email--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Email</label>
							</div>
							<div class="input-group">
								<div class="input-group-prepend">
									<div class="input-group-text">@</div>
								</div>
								<input ID="TboxEmailA" required type= "email" name="TboxEmailA"
									onkeyup="validarEmail()" onfocus="Seleccionar(this.id)"
									maxlength="33" placeholder="Example@gmail.com"
									Class="form-control">
								<p id="MensajeErrorEmail"></p>
							</div>
						</div>

						<%--Constraseña--%>
						<div class="col-md-3">
							<label>Contraseña</label>
							<div class="input-group">
								<input ID="txtPasswordA" required type="Password" name="TboxContraseñaA" Class="form-control">
								<div class="input-group-append">
									<button id="show_password" class="btn btn-secondary"
										type="button" onclick="mostrarPasswordA()">
										<span class="fa fa-eye-slash icon"></span>
									</button>
								</div>
							</div>
						</div>
						
					</div>

					<div class="form-row ">

						<%--FechaNacimiento--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Fecha Nacimiento</label>
							</div>
							<input type="date" required ID="TboxFechaNacimientoA"
								name="TboxFechaNacimientoA" max="3000-12-31" min="1900-01-01"
								class="form-control">
						</div>




						<%--Telefono--%>
						<div class="form-group col-md-3">
							<div>
								<label Class="control-label">Telefono</label>
							</div>
							<input ID="TboxTelefonoA" required pattern="[0-9]+" name="TboxTelefonoA"
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
							<input ID="TboxDirreccionA" required name="TboxDirreccionA"
								onkeyup="validarVacio(this.id)" onfocus="Seleccionar(this.id)"
								maxlength="40" placeholder="Avenida Siempreviva 742"
								Class="form-control">
							<p id="MensajeErrorDireccion"></p>
						</div>


						<%--Provincia--%>
						<div class="form-group col-md-3">
							<div>
								<label for="TboxProvinciaA" class="col-form-label">Provincia</label>
							</div>
							<select id="TboxProvinciaA" name="TboxProvinciaA"
								class="form-control" tabindex="6"
								onchange="cambia_LocalidadAgregar()">

								<%
									ArrayList<Provincia> lista = null;
									if (request.getAttribute("ListaProvincia") != null) {
										lista = (ArrayList<Provincia>) request.getAttribute("ListaProvincia");
									}

									if (lista != null) {
										for (Provincia provincia : lista) {
								%>
								<option value="<%=provincia.getID()%>"><%=provincia.getNombre()%></option>
								<%
									}
									}
								%>
							</select>
						</div>


						<%--Localidad--%>
						<div class="form-group col-md-3">
							<div>
								<label for="TboxLocalidadA" class="col-form-label">Localidad</label>
							</div>
							<select id="TboxLocalidadA" name="TboxLocalidadA"
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
									}
									}
								%>
							</select>
						</div>
					</div>
				</div>

				<!-- 			______________________________________________________ -->
				<div class="modal-footer">
					<button type="submit" id="BtnAgregar" name="BtnAgregar"
						class="btn btn-primary">Crear</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cerrar</button>

				</div>
			</div>
		</form>
	</div>
</div>