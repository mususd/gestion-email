<%-- 
    actualizarRecuperarContrasena.jsp
    Formulario para actualizar los datos de una solicitud de recuperar contraseña
    - Carga los datos actuales según el ID.
    - Envía los cambios al servlet srvActualizarRecuperarContrasena.
--%>

<%@page import="Modelo.recuperarcontrasena.RecuperarContrasena"%>
<%@page import="Modelo.recuperarcontrasena.SrvRecuperarContrasena_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Recuperación de Contraseña</title>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        
        <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 25px;
            background: #fff;
            border-radius: 12px;
            box-shadow: 0px 4px 12px rgba(0,0,0,0.15);
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #343a40;
        }
        .btn-dark {
            width: 100%;
        }
        </style>
        
    </head>
    <body>
        
        <%-- Menú principal --%>
        <%@include file="menu.jsp"%>

        <%-- =============================
             CARGA DE DATOS EXISTENTES
        ============================== --%>
        <%
            Integer idRecuperacion = Integer.parseInt(request.getParameter("id"));
            SrvRecuperarContrasena_Service servicio = new SrvRecuperarContrasena_Service();
            RecuperarContrasena recuperar1 = servicio.getSrvRecuperarContrasenaPort().listarPorID(idRecuperacion);
        %>

        <%-- =============================
             FORMULARIO DE ACTUALIZACIÓN
        ============================== --%>
        <div class="form-container">
            <h2>Actualizar Solicitud de Recuperación de Contraseña</h2>
            <form name="frmRecuperarContrasena" action="srvActualizarRecuperarContrasena" method="POST">
                
                <div class="input-group mb-3">
                    <span class="input-group-text">idRecuperacion</span>
                    <input type="text" class="form-control" name="txtIdRecuperacion" value="<%=recuperar1.getIdRecuperacion()%>" readonly>
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Usuario</span>
                    <input type="text" class="form-control" name="txtUsuario" value="<%=recuperar1.getUsuario()%>">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Fecha de Solicitud</span>
                    <input type="date" class="form-control" name="txtFechaSolicitud" value="<%=recuperar1.getFechaSolicitud()%>">
                </div>
                                
                <div class="input-group mb-3">
                    <span class="input-group-text">Código de Recuperación</span>
                    <input type="text" class="form-control" name="txtCodigoRecuperacion" value="<%=recuperar1.getCodigoRecuperacion()%>">
                </div>              

                <div class="input-group mb-3">
                    <span class="input-group-text">Estado de la Solicitud</span>
                    <div class="col-sm-8">
                        <select class="form-select" name="txtEstadoSolicitud">
                            <option value="">Seleccione...</option>
                            <option value="Pendiente">Pendiente</option>
                            <option value="Confirmada">Confirmada</option>
                            <option value="Cancelada">Cancelada</option>
                            <option value="Completada">Completada</option>
                        </select>
                    </div>
                </div>

                <button type="submit" class="btn btn-dark">Actualizar</button>
            </form>
        

        <%-- =============================
             MENSAJE DE RESPUESTA
        ============================== --%>
        <%
            if(request.getAttribute("respuesta") != null){
                int respuesta = Integer.parseInt(request.getAttribute("respuesta").toString());
                if(respuesta == 1){
        %>
                    <script> swal("Actualización", "Datos actualizados correctamente", "success"); </script>
        <%
                } else {
        %>
                    <script> swal("Error", "No se pudo actualizar la solicitud de recuperar contraseña", "error"); </script>
        <%
                }
            }
        %>
        
    </body>
</html>