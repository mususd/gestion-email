<%-- 
    eliminarUsuario.jsp
    Formulario de confirmación para eliminar un usuario.
    - Muestra los datos actuales.
    - Envía al servlet srvEliminarUsuario.
--%>

<%@page import="Modelo.usuario.Usuario"%>
<%@page import="Modelo.usuario.SrvUsuario_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Usuario</title>
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
            String usuario = request.getParameter("id");
            SrvUsuario_Service servicio = new SrvUsuario_Service();
            Usuario user1 = servicio.getSrvUsuarioPort().listarPorID(usuario);
        %>

        <%-- =============================
             FORMULARIO DE ELIMINACIÓN
        ============================== --%>
        <form name="frmUsuario" action="srvEliminarUsuario" method="POST">

                <div class="input-group mb-3">
                    <span class="input-group-text">Usuario</span>
                    <input type="text" class="form-control" name="txtUsuario" value="<%=user1.getUsuario()%>" readonly>
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">idEmpresa</span>
                    <input type="text" class="form-control" name="txtIdEmpresa" value="<%=user1.getIdEmpresa()%>" readonly>
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Nombre</span>
                    <input type="text" class="form-control" name="txtNombre" value="<%=user1.getNombre()%>" readonly>
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Apellido</span>
                    <input type="text" class="form-control" name="txtApellido" value="<%=user1.getApellido()%>" readonly>
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Email</span>
                    <input type="text" class="form-control" name="txtEmail" value="<%=user1.getEmail()%>" readonly>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Contraseña</span>
                    <input type="password" class="form-control" id="txtContrasena" name="txtContrasena" value="<%=user1.getContrasena()%>" readonly>
                        <button type="button" class="btn btn-outline-secondary" id="togglePassword">
                            👁️
                        </button>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Fecha de Registro</span>
                    <input type="date" class="form-control" name="txtFechaRegistro" value="<%=user1.getFechaRegistro()%>" readonly>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Estado</span>
                    <div class="col-sm-8">
                        <select class="form-select" name="txtEstado">
                            <option value="" readonly>Seleccione...</option>
                            <option value="Activo">Activo</option>
                            <option value="Inactivo">Inactivo</option>
                        </select>
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
                    <script> swal("Error", "No se pudo eliminar el usuario", "error"); </script>
        <%
                }
            }
        %>
        
    </body>
</html>
