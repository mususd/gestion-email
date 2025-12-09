<%-- 
    actualizarTipoBandeja.jsp
    Formulario para actualizar los datos de un tipo de bandeja.
    - Carga los datos actuales según el ID.
    - Envía cambios al servlet srvActualizarTipoBandeja.
--%>

<%@page import="Modelo.tipobandeja.TipoBandeja" %>
<%@page import="Modelo.tipobandeja.SrvTipoBandeja_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Tipo Bandeja</title>
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
        Integer idTipoBandeja = Integer.parseInt(request.getParameter("id"));
        SrvTipoBandeja_Service servicio = new SrvTipoBandeja_Service();
        TipoBandeja tb1 = servicio.getSrvTipoBandejaPort().listarPorID(idTipoBandeja);
    %>
    
    <%-- =============================
         FORMULARIO DE ACTUALIZACIÓN
    ============================== --%>
    <div class="form-container">
        <h2>Actualizar Tipo Bandeja</h2>
        <form name="frmTipoBandeja" action="srvActualizarTipoBandeja" method="POST">
            
            <div class="input-group mb-3">
                <span class="input-group-text">ID</span>
                <input type="text" class="form-control" name="txtIdTipoBandeja" value="<%=tb1.getIdTipoBandeja()%>" readonly>
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text">NombreTipo</span>
                <input type="text" class="form-control" name="txtNombreTipo" value="<%=tb1.getNombreTipo()%>">
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
                <script> swal("Error", "No se pudo actualizar el tipo de bandeja", "error"); </script>
    <%
            }
        }
    %>
    </body>
</html>
