<%-- 
    actualizarHistorial.jsp
    Formulario para actualizar los datos de un historial
    - Carga los datos actuales según el ID.
    - Envía cambios al servlet srvActualizarHistorial.
--%>

<%@page import="Modelo.historialingresos.HistorialIngresos"%>
<%@page import="Modelo.historialingresos.SrvHistorialIngresos_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Historial de Ingreso</title>
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
            Integer idHistorial = Integer.parseInt(request.getParameter("id"));
            SrvHistorialIngresos_Service servicio = new SrvHistorialIngresos_Service();
            HistorialIngresos h1 = servicio.getSrvHistorialIngresosPort().listarPorID(idHistorial);
        %>

        <%-- =============================
             FORMULARIO DE ACTUALIZACIÓN
        ============================== --%>
        <div class="form-container">
            <h2>Actualizar Historial</h2>
            <form name="frmHistorial" action="srvActualizarHistorial" method="POST">

                <div class="input-group mb-3">
                    <span class="input-group-text">ID</span>
                    <input type="text" class="form-control" name="txtIdHistorial" value="<%=h1.getIdHistorial()%>" readonly>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Usuario</span>
                    <input type="text" class="form-control" name="txtUsuario" value="<%=h1.getUsuario()%>">
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Fecha de Ingreso</span>
                    <input type="datetime" class="form-control" name="txtFechaIngreso" value="<%=h1.getFechaIngreso()%>">
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Fecha de Salida</span>
                    <input type="datetime" class="form-control" name="txtFechaSalida" value="<%=h1.getFechaSalida()%>">
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
                    <script> swal("Error", "No se pudo actualizar el historial", "error"); </script>
        <%
                }
            }
        %>
        
    </body>
</html>
