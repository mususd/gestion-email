<%-- 
    eliminarEstadoEmail.jsp
    Formulario de confirmación para eliminar un estado de email
    - Muestra los datos actuales
    - Envía al servlet srvEliminarEstadoEmail
--%>

<%@page import="Modelo.estadoemail.EstadoEmail"%>
<%@page import="Modelo.estadoemail.SrvEstadoEmail_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Estado Email</title>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <%-- Menú principal --%>
        <%@include file="menu.jsp"%>

        <%-- =============================
             CARGA DE DATOS EXISTENTES
        ============================== --%>
        <%
            Integer idEstadoEmail = Integer.parseInt(request.getParameter("id"));
            SrvEstadoEmail_Service servicio = new SrvEstadoEmail_Service();
            EstadoEmail e1 = servicio.getSrvEstadoEmailPort().listarPorID(idEstadoEmail);
        %>

        <%-- =============================
             FORMULARIO DE ELIMINACIÓN
        ============================== --%>
        <form name="frmEstadoEmail" action="srvEliminarEstadoEmail" method="POST">

            <div class="input-group mb-3">
                <span class="input-group-text">ID</span>
                <input type="text" class="form-control" name="txtIdEstadoEmail" value="<%=e1.getIdEstadoEmail()%>" readonly>
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text">Nombre</span>
                <input type="text" class="form-control" value="<%=e1.getNombreEstado()%>" readonly>
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
                    <script> swal("Eliminación", "Estado de email eliminado exitosamente", "success"); </script>
        <%
                } else {
        %>
                    <script> swal("Error", "No se pudo eliminar el estado de email", "error"); </script>
        <%
                }
            }
        %>
        
    </body>
</html>
