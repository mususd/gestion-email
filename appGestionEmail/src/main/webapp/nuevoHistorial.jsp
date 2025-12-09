<%-- 
    nuevoHistorial.jsp
    Formulario para registrar un nuevo historial de ingreso.
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Historial</title>
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

            <form name="frmHistorial" action="srvHistorialIngresos" method="POST">

                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Usuario</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="txtUsuario" required>
                    </div>
                </div>
                
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Fecha de ingreso</label>
                    <div class="col-sm-8">
                        <input type="date" class="form-control" name="txtFechaIngreso" required>
                    </div>
                </div>
                
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Fecha de salida</label>
                    <div class="col-sm-8">
                        <input type="date" class="form-control" name="txtFechaSalida" required>
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
                    <script> swal("Registro", "historial registrado exitosamente", "success"); </script>
        <%
                } else {
        %>
                    <script> swal("Error", "No se pudo registrar el historial", "error"); </script>
        <%
                }
            }
        %>
        
        <script>
            // Rellena automáticamente la fecha actual
            document.addEventListener("DOMContentLoaded", function() {
                const fechaInput = document.querySelector('input[name="txtFechaIngreso"]');
                if (fechaInput) {
                    const hoy = new Date().toISOString().split('T')[0];
                    fechaInput.value = hoy;
                }
            });
        </script>
        
    </body>
</html>
