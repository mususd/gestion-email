<%-- 
    nuevoTipoBandeja.jsp
    Formulario para registrar un nuevo tipo de bandeja.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Tipo de Bandeja</title>
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
        <%@include file="menu.jsp" %>
        
        <div class="form-container">
        <h2>Formulario para agregar un nuevo tipo de bandeja</h2>
        
        <form name="frmTipoBandeja" action="srvTipoBandeja" method="POST">
            
            <div class="mb-3 row">
                <label class="col-sm-4 col-form-label">Nombre de la bandeja</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="txtNombreTipo" required>
                </div>
            </div>
            
            <div class="text-center">
                <button type="submit" class="btn btn-dark">Agregar</button>
            </div>
        </form>
    </div>
        
    <%-- SweetAlert mensajes --%>
    <%
        if(request.getAttribute("respuesta") != null){
            int respuesta = Integer.parseInt(request.getAttribute("respuesta").toString());
            if(respuesta == 1){
    %>
                <script> swal("Registro", "Tipo de bandeja registrada exitosamente", "success"); </script>
    <%
            } else {
    %>
                <script> swal("Error", "No se pudo registrar el tipo de bandeja", "error"); </script>
    <%
            }
        }
    %>
        
    </body>
</html>
