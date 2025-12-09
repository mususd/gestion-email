<%-- 
    actualizarBandeja.jsp
    Formulario para actualizar los datos de una bandeja.
    - Carga los datos actuales según el ID.
    - Envía cambios al servlet srvActualizarBandeja.
--%>

<%@page import="Modelo.bandeja.Bandeja"%>
<%@page import="Modelo.bandeja.SrvBandeja_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Bandeja</title>
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
            Integer idBandeja = Integer.parseInt(request.getParameter("id"));
            SrvBandeja_Service servicio = new SrvBandeja_Service();
            Bandeja b1 = servicio.getSrvBandejaPort().listarPorID(idBandeja);
        %>

        <%-- =============================
             FORMULARIO DE ACTUALIZACIÓN
        ============================== --%>
        <div class="form-container">
            <h2>Actualizar Bandeja</h2>
            <form name="frmBandeja" action="srvActualizarBandeja" method="POST">

                <div class="input-group mb-3">
                    <span class="input-group-text">ID</span>
                    <input type="text" class="form-control" name="txtIdBandeja" value="<%=b1.getIdBandeja()%>" readonly>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Usuario Remitente</span>
                    <input type="text" class="form-control" name="txtUsuarioRemitente" value="<%=b1.getUsuarioRemitente()%>">
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">idTipoBandeja</span>
                    <input type="text" class="form-control" name="txtIdTipoBandeja" value="<%=b1.getIdTipoBandeja()%>">
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">idEstadoEmail</span>
                    <input type="text" class="form-control" name="txtIdEstadoEmail" value="<%=b1.getIdEstadoEmail()%>">
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Asunto</span>
                    <input type="text" class="form-control" name="txtAsunto" value="<%=b1.getAsunto()%>">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Mensaje</span>
                    <input type="text" class="form-control" name="txtMensaje" value="<%=b1.getMensaje()%>">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Fecha de Envío</span>
                    <input type="date" class="form-control" name="txtFechaEnvio" value="<%=b1.getFechaEnvio()%>">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Adjunto</span>
                    <input type="text" class="form-control" name="txtAdjunto" value="<%=b1.getAdjunto()%>">
                </div>

                <button type="submit" class="btn btn-dark">Actualizar</button>
            </form>
        </div>

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
                    <script> swal("Error", "No se pudo actualizar la bandeja", "error"); </script>
        <%
                }
            }
        %>
        
    </body>
</html>
