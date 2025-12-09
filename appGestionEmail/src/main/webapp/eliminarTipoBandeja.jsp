<%-- 
    eliminarTipoBandeja.jsp
    Formulario de confirmación para eliminar un tipo de bandeja.
    - Muestra los datos actuales.
    - Envía al servlet srvEliminarTipoBandeja.
--%>

<%@page import="Modelo.tipobandeja.TipoBandeja"%>
<%@page import="Modelo.tipobandeja.SrvTipoBandeja_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Tipo de Bandeja</title>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
    </head>
    <body>
        <%-- Menú principal --%>
        <%@include file="menu.jsp"%>

        <%-- =============================
             CARGA DE DATOS EXISTENTES
        ============================== --%>
        <%
            Integer idTipoBandeja = Integer.parseInt(request.getParameter("id"));
            SrvTipoBandeja_Service servicio = new SrvTipoBandeja_Service();
            TipoBandeja tb1 = servicio.getSrvTipoBandejaPort().listarPorID(idTipoBandeja);
        %>

        <%-- =============================
             FORMULARIO DE ELIMINACIÓN
        ============================== --%>
        <form name="frmTipoBandeja" action="srvEliminarTipoBandeja" method="POST">

            <div class="input-group mb-3">
                <span class="input-group-text">ID</span>
                <input type="text" class="form-control" name="txtIdTipoBandeja" value="<%=tb1.getIdTipoBandeja()%>" readonly>
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text">NombreTipo</span>
                <input type="text" class="form-control" value="<%=tb1.getNombreTipo()%>" readonly>
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
                    <script> swal("Error", "No se pudo eliminar el tipo de bandeja", "error"); </script>
        <%
                }
            }
        %>
    </body>
</html>
