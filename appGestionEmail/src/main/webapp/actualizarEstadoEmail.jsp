<%-- 
    actualizarEstadoEmail.jsp
    Formulario para actualizar los datos de un estado de email.
    - Carga los datos actuales según el ID.
    - Envía cambios al servlet srvActualizarEstadoEmail.
--%>

<%@page import="Modelo.estadoemail.EstadoEmail"%>
<%@page import="Modelo.estadoemail.SrvEstadoEmail_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Estado Email</title>
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
            Integer idEstadoEmail = Integer.parseInt(request.getParameter("id"));
            SrvEstadoEmail_Service servicio = new SrvEstadoEmail_Service();
            EstadoEmail e1 = servicio.getSrvEstadoEmailPort().listarPorID(idEstadoEmail);
        %>

        <%-- =============================
             FORMULARIO DE ACTUALIZACIÓN
        ============================== --%>
        <div class="form-container">
            <h2>Actualizar Estado Email</h2>
            <form name="frmEstadoEmail" action="srvActualizarEstadoEmail" method="POST">

                <div class="input-group mb-3">
                    <span class="input-group-text">ID</span>
                    <input type="text" class="form-control" name="txtIdEstadoEmail" value="<%=e1.getIdEstadoEmail()%>" readonly>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Nombre</span>
                    <input type="text" class="form-control" name="txtNombreEstado" value="<%=e1.getNombreEstado()%>">
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
                    <script> swal("Actualización", "Información actualizada correctamente", "success"); </script>
        <%
                } else {
        %>
                    <script> swal("Error", "No se pudo actualizar el estado de email", "error"); </script>
        <%
                }
            }
        %>
        
    </body>
</html>
