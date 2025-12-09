<%-- 
    nuevoUsuario.jsp
    Formulario para registar un nuevo usuario.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Usuario</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
        
        <style>
        .form-container {
            max-width: 600px;         /* ancho del formulario */
            margin: 50px auto;        /* centrado vertical y horizontal */
            background: #fff;         
            padding: 30px;            /* espacio interno */
            border-radius: 10px;      /* bordes redondeados */
            box-shadow: 0 0 10px rgba(0,0,0,0.1); /* sombra suave */
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        </style>
        
    </head>
    <body>
        
        <%-- Menú principal --%>
        <%@include file="menu.jsp"%>

        <div class="form-container">
            <h2>Formulario de Registro</h2>

            <form name="frmUsuario" action="srvUsuario" method="POST">
                
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Usuario</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="txtUsuario" required>
                    </div>
                </div>
                
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">idEmpresa</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="txtIdEmpresa" required>
                    </div>
                </div>
                
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Nombre</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="txtNombre" required>
                    </div>
                </div>

                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Apellido</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="txtApellido" required>
                    </div>
                </div>

                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Email</label>
                    <div class="col-sm-8">
                        <input type="email" class="form-control" name="txtEmail" required>
                    </div>
                </div>

                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Contraseña</label>
                    <div class="col-sm-8 input-group">
                        <input type="password" class="form-control" id="txtContrasena" name="txtContrasena" required>
                        <button type="button" class="btn btn-outline-secondary" id="togglePassword">
                            👁️
                        </button>
                    </div>
                </div>
                
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Fecha de registro</label>
                    <div class="col-sm-8">
                        <input type="date" class="form-control" name="txtFechaRegistro" required>
                    </div>
                </div>
                
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Estado</label>
                    <div class="col-sm-8">
                        <select class="form-select" name="txtEstado" required>
                            <option value="">Seleccione...</option>
                            <option value="Activo">Activo</option>
                            <option value="Inactivo">Inactivo</option>
                        </select>
                    </div>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-dark">Registrar</button>
                </div>
            </form>
        </div>

        <%-- SweetAlert mensajes --%>
        <%
            if(request.getAttribute("respuesta") != null){
                int respuesta = Integer.parseInt(request.getAttribute("respuesta").toString());
                if(respuesta == 1){
        %>
                    <script> swal("Registro", "Usuario registrado exitosamente", "success"); </script>
        <%
                } else {
        %>
                    <script> swal("Error", "No se pudo registrar el usuario", "error"); </script>
        <%
                }
            }
        %>
        
        <script>
            // Rellena automáticamente la fecha actual
            document.addEventListener("DOMContentLoaded", function() {
                const fechaInput = document.querySelector('input[name="txtFechaRegistro"]');
                if (fechaInput) {
                    const hoy = new Date().toISOString().split('T')[0];
                    fechaInput.value = hoy;
                }
            });
        </script>
        
        <script>
            // Mostrar/ocultar contraseña
            document.addEventListener("DOMContentLoaded", function() {
                const passwordInput = document.getElementById("txtContrasena");
                const toggleButton = document.getElementById("togglePassword");

                toggleButton.addEventListener("click", function() {
                    const type = passwordInput.getAttribute("type") === "password" ? "text" : "password";
                    passwordInput.setAttribute("type", type);

                    // Cambiar el ícono (opcional)
                    this.textContent = type === "password" ? "👁️" : "👁️";
                });
            });
        </script>
        
    </body>
</html>