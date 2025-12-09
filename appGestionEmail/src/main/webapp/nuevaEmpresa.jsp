<%-- 
    nuevaEmpresa.jsp
    Formulario para registrar una nueva empresa.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Nueva Empresa</title>
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
        
        <form name="frmEmpresa" action="srvEmpresa" method="POST">
            
            <div class="mb-3 row">
                <label class="col-sm-4 col-form-label">Nombre</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="txtNombre" required>
                </div>
            </div>
            
            <div class="mb-3 row">
                <label class="col-sm-4 col-form-label">Dirección</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="txtDireccion" required>
                </div>
            </div>
            
            <div class="mb-3 row">
                <label class="col-sm-4 col-form-label">Teléfono</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="txtTelefono" required>
                </div>
            </div>
            
            <div class="mb-3 row">
                <label class="col-sm-4 col-form-label">Correo electrónico</label>
                <div class="col-sm-8">
                    <input type="email" class="form-control" name="txtEmail" required>
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
                <script> swal("Registro", "Empresa registrada exitosamente", "success"); </script>
    <%
            } else {
    %>
                <script> swal("Error", "No se pudo registrar la empresa", "error"); </script>
    <%
            }
        }
    %>
    
</body>
</html>