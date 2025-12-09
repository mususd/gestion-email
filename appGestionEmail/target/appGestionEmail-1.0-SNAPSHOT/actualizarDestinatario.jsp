<%-- 
    actualizarDestinatario.jsp
    Formulario para actualizar los datos de un destinatario
    - Carga los datos actuales según el ID.
    - Envía los cambios al servlet srvActualizarDestinatario
--%>

<%@page import="Modelo.destinatarioemail.DestinatarioEmail"%>
<%@page import="Modelo.destinatarioemail.SrvDestinatarioEmail_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Destinatario</title>
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
            Integer idDestinatario = Integer.parseInt(request.getParameter("id"));
            SrvDestinatarioEmail_Service servicio = new SrvDestinatarioEmail_Service();
            DestinatarioEmail d1 = servicio.getSrvDestinatarioEmailPort().listarPorID(idDestinatario);
        %>

        <%-- =============================
             FORMULARIO DE ACTUALIZACIÓN
        ============================== --%>
        <div class="form-container">
            <h2>Actualizar Destinatario</h2>
            <form name="frmDestinatario" action="srvActualizarDestinatario" method="POST">

                <div class="input-group mb-3">
                    <span class="input-group-text">ID</span>
                    <input type="text" class="form-control" name="txtIdDestinatario" value="<%=d1.getIdDestinatario()%>" readonly>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">idBandeja</span>
                    <input type="text" class="form-control" name="txtIdBandeja" value="<%=d1.getIdBandeja()%>">
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Usuario Destinatario</span>
                    <input type="text" class="form-control" name="txtUsuarioDestinatario" value="<%=d1.getUsuarioDestinatario()%>">
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Tipo de Destinatario</span>
                    <input type="text" class="form-control" name="txtTipoDestinatario" value="<%=d1.getTipoDestinatario()%>">
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
                    <script> swal("Error", "No se pudo actualizar el destinatario", "error"); </script>
        <%
                }
            }
        %>
        
    </body>
</html>
