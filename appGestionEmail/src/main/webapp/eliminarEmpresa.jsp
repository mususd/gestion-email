<%-- 
    eliminarEmpresa.jsp
    Formulario de confirmación para eliminar una empresa.
    - Muestra los datos actuales.
    - Envía al servlet srvEliminarEmpresa.
--%>

<%@page import="Modelo.empresa.Empresa"%>
<%@page import="Modelo.empresa.SrvEmpresa_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Eliminar Empresa</title>
    <script src="js/sweetalert.min.js" type="text/javascript"></script>
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
         FORMULARIO DE ELIMINACIÓN
    ============================== --%>
    <form name="frmEmpresa" action="srvEliminarEmpresa" method="POST">
        
        <div class="input-group mb-3">
            <span class="input-group-text">ID</span>
            <input type="text" class="form-control" name="txtIdEmpresa" value="<%=e1.getIdEmpresa()%>" readonly>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">Nombre</span>
            <input type="text" class="form-control" value="<%=e1.getNombre()%>" readonly>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">Dirección</span>
            <input type="text" class="form-control" value="<%=e1.getDireccion()%>" readonly>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text">Teléfono y correo electrónico</span>
            <input type="text" class="form-control" value="<%=e1.getTelefono()%>" readonly>
            <input type="text" class="form-control" value="<%=e1.getEmail()%>" readonly>
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
                <script> swal("Error", "No se pudo eliminar la empresa", "error"); </script>
    <%
            }
        }
    %>
    
</body>
</html>