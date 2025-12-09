<%-- 
    eliminarBandeja.jsp
    Formulario de confirmación para eliminar una bandeja
    - Muestra los datos actuales
    - Envía al servlet srvEliminarBandeja
--%>

<%@page import="Modelo.bandeja.Bandeja"%>
<%@page import="Modelo.bandeja.SrvBandeja_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Bandeja</title>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
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
             FORMULARIO DE ELIMINACIÓN
        ============================== --%>
        <form name="frmBandeja" action="srvEliminarBandeja" method="POST">

                <div class="input-group mb-3">
                    <span class="input-group-text">ID</span>
                    <input type="text" class="form-control" name="txtIdBandeja" value="<%=b1.getIdBandeja()%>" readonly>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Usuario Remitente</span>
                    <input type="text" class="form-control" name="txtUsuarioRemitente" value="<%=b1.getUsuarioRemitente()%>" readonly>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">idTipoBandeja</span>
                    <input type="text" class="form-control" name="txtIdTipoBandeja" value="<%=b1.getIdTipoBandeja()%>" readonly>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">idEstadoEmail</span>
                    <input type="text" class="form-control" name="txtIdEstadoEmail" value="<%=b1.getIdEstadoEmail()%>" readonly>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Asunto</span>
                    <input type="text" class="form-control" name="txtAsunto" value="<%=b1.getAsunto()%>" readonly>
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Mensaje</span>
                    <input type="text" class="form-control" name="txtMensaje" value="<%=b1.getMensaje()%>" readonly>
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Fecha de Envío</span>
                    <input type="date" class="form-control" name="txtFechaEnvio" value="<%=b1.getFechaEnvio()%>" readonly>
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Adjunto</span>
                    <input type="text" class="form-control" name="txtAdjunto" value="<%=b1.getAdjunto()%>" readonly>
                </div>

            <button type="submit" class="btn btn-danger">Eliminar</button>
        </form>

        <%-- =============================
             MENSAJE DE RESPUESTA
        ============================== --%>
        <%
            if(request.getAttribute("respuesta") != null){
                int respuesta = Integer.parseInt(request.getAttribute("respuesta").toString());
                if(respuesta == 1){
        %>
                    <script> swal("Eliminación", "Registro eliminado exitosamente", "success"); </script>
        <%
                } else {
        %>
                    <script> swal("Error", "No se pudo eliminar la bandeja", "error"); </script>
        <%
                }
            }
        %>
        
    </body>
</html>
