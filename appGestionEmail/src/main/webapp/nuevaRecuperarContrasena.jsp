<%-- 
    nuevaRecuperarContrasena.jsp
    Formulario para registrar solicitudes de recuperar contraseña.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Solicitud de Recuperación de Contraseña</title>
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
            <h2>Formulario de Recuperación de Contraseña</h2>

            <form name="frmRecuperarContrasena" action="srvRecuperarContrasena" method="POST">

                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Usuario</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="txtUsuario" required>
                    </div>
                </div>

                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Fecha de solicitud</label>
                    <div class="col-sm-8">
                        <input type="date" class="form-control" name="txtFechaSolicitud" required>
                    </div>
                </div>

                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Código de Recuperación</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="txtCodigoRecuperacion" required>
                    </div>
                </div>

                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Estado de la Solicitud</label>
                    <div class="col-sm-8">
                        <select class="form-select" name="txtEstadoSolicitud" required>
                            <option value="">Seleccione...</option>
                            <option value="Pendiente">Pendiente</option>
                            <option value="Confirmada">Confirmada</option>
                            <option value="Cancelada">Cancelada</option>
                            <option value="Completada">Completada</option>                            
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
                    <script> swal("Registro", "Solicitud de recuperación de contraseña registrada exitosamente", "success"); </script>
        <%
                } else {
        %>
                    <script> swal("Error", "No se pudo registrar la solicitud de recuperación de contraseña", "error"); </script>
        <%
                }
            }
        %>
        
        <script>
            // Rellena automáticamente la fecha actual
            document.addEventListener("DOMContentLoaded", function() {
                const fechaInput = document.querySelector('input[name="txtFechaSolicitud"]');
                if (fechaInput) {
                    const hoy = new Date().toISOString().split('T')[0];
                    fechaInput.value = hoy;
                }
            });
        </script>
        
    </body>
</html>