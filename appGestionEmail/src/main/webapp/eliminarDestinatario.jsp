<%-- 
    eliminarDestinatario.jsp
    Formulario de confirmación para eliminar un destinatario
    - Muestra los datos actuales.
    - Envíal al servlet srvEliminarDestinatario
--%>

<%@page import="Modelo.destinatarioemail.DestinatarioEmail"%>
<%@page import="Modelo.destinatarioemail.SrvDestinatarioEmail_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Destinatario</title>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <%-- Menú principal --%>
        <%@include file="menu.jsp"%>

        <%-- =============================
             CARGA DE DATOS EXISTENTES
        ============================== --%>
        <%
            Integer idDestinatario = Integer.parseInt(request.getParameter("id"));
            SrvDestinatarioEmail_Service servicio = new SrvDestinatarioEmail_Service();
            DestinatarioEmail d1 = servicio.getSrvDestinatarioEmailPort().listarPorID(idDestinatario);
        %>

        <%-- =============================
             FORMULARIO DE ELIMINACIÓN
        ============================== --%>
        <form name="frmDestinatario" action="srvEliminarDestinatario" method="POST">

            <div class="input-group mb-3">
                    <span class="input-group-text">ID</span>
                    <input type="text" class="form-control" name="txtIdDestinatario" value="<%=d1.getIdDestinatario()%>" readonly>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">idBandeja</span>
                    <input type="text" class="form-control" name="txtIdBandeja" value="<%=d1.getIdBandeja()%>" readonly>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Usuario Destinatario</span>
                    <input type="text" class="form-control" name="txtUsuarioDestinatario" value="<%=d1.getUsuarioDestinatario()%>" readonly>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Tipo de Destinatario</span>
                    <input type="text" class="form-control" name="txtTipoDestinatario" value="<%=d1.getTipoDestinatario()%>" readonly>
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
                    <script> swal("Error", "No se pudo eliminar el destinatario", "error"); </script>
        <%
                }
            }
        %>
    
        
    </body>
</html>