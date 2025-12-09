<%-- 
    nuevaBandeja.jsp
    Formulario para registrar una nueva bandeja.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Bandeja</title>
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

            <form name="frmBandeja" action="srvBandeja" method="POST">

                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Usuario Remitente</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="txtUsuarioRemitente" required>
                    </div>
                </div>

                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">idTipoBandeja</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="txtIdTipoBandeja" required>
                    </div>
                </div>

                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">idEstadoEmail</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="txtIdEstadoEmail" required>
                    </div>
                </div>
                
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Asunto</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="txtAsunto" required>
                    </div>
                </div>

                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Mensaje</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="txtMensaje" required>
                    </div>
                </div>
                
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Fecha de Envío</label>
                    <div class="col-sm-8">
                        <input type="date" class="form-control" name="txtFechaEnvio" required>
                    </div>
                </div>
                
                <div class="mb-3 row">
                    <label class="col-sm-4 col-form-label">Adjunto</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="txtAdjunto" required>
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
                    <script> swal("Registro", "Bandeja registrada exitosamente", "success"); </script>
        <%
                } else {
        %>
                    <script> swal("Error", "No se pudo registrar la bandeja", "error"); </script>
        <%
                }
            }
        %>
        
    </body>
</html>
