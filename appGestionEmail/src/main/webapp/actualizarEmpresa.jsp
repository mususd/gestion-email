<%-- 
    actualizarEmpresa.jsp
    Formulario para actualizar los datos de una empresa.
    - Carga los datos actuales según el ID.
    - Envía cambios al servlet srvActualizarEmpresa.
--%>

<%@page import="Modelo.empresa.Empresa"%>
<%@page import="Modelo.empresa.SrvEmpresa_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Actualizar Empresa</title>
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
        Integer idEmpresa = Integer.parseInt(request.getParameter("id"));
        SrvEmpresa_Service servicio = new SrvEmpresa_Service();
        Empresa e1 = servicio.getSrvEmpresaPort().listarPorID(idEmpresa);
    %>
    
    <%-- =============================
         FORMULARIO DE ACTUALIZACIÓN
    ============================== --%>
    <div class="form-container">
        <h2>Actualizar Empresa</h2>
        <form name="frmEmpresa" action="srvActualizarEmpresa" method="POST">
            
            <div class="input-group mb-3">
                <span class="input-group-text">ID</span>
                <input type="text" class="form-control" name="txtIdEmpresa" value="<%=e1.getIdEmpresa()%>" readonly>
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text">Nombre</span>
                <input type="text" class="form-control" name="txtNombre" value="<%=e1.getNombre()%>">
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text">Dirección</span>
                <input type="text" class="form-control" name="txtDireccion" value="<%=e1.getDireccion()%>">
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text">Teléfono</span>
                <input type="text" class="form-control" name="txtTelefono" value="<%=e1.getTelefono()%>">
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text">Email</span>
                <input type="text" class="form-control" name="txtEmail" value="<%=e1.getEmail()%>">
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
                <script> swal("Error", "No se pudo actualizar la empresa", "error"); </script>
    <%
            }
        }
    %>
    
</body>
</html>