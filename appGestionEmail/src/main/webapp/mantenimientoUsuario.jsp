<%-- 
    mantenimientoUsuario.jsp
    Página principal para listar, buscar, actualizar y eliminar usuarios.
    - Incluye un formulario de búsqueda por ID.
    - Muestra una tabla con todos los registros o el resultado de búsqueda.
    - Permite ir a actualizarUsuario.jsp o eliminarUsuario.jsp
--%>

<%@page import ="Modelo.usuario.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.usuario.SrvUsuario_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Usuario</title>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <%-- Menú principal --%>
        <%@include file="menu.jsp"%>
        
        <%-- =============================
             FORMULARIO DE BÚSQUEDA
        ============================== --%>
        <form name="frmMantenimientoUsuario" action="srvBuscarUsuario" method="POST">
            <div class="row d-flex justify-content-center">
                <div class="col-md-3">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Búsqueda</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">ID del usuario</th>
                                <td><input type="text" name="txtUsuario" value="" /></td>
                                <td><button type="submit" class="btn btn-dark">Buscar</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>  
        </form>
        
        <%-- =============================
             TABLA DE RESULTADOS
        ============================== --%>
        <div align="center">
            <div class="row d-flex justify-content-center">
                <div class="col-md-10">
                    
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Usuario</th>
                                <th>idEmpresa</th>
                                <th>Nombre</th>
                                <<th>Apellido</th>
                                <th>Email</th>
                                <<th>Contraseña</th>
                                <th>Fecha de registro</th>
                                <th>Estado</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Usuario> user;
                                Usuario user1;
                                SrvUsuario_Service Usuario = new SrvUsuario_Service();
                                
                                if(request.getAttribute("usuario") != null){
                                    String usuario = request.getAttribute("usuario").toString();
                                    user1 = Usuario.getSrvUsuarioPort().listarPorID(usuario);
                            %>
                                    <tr>
                                        <<td><%=user1.getUsuario()%></td>
                                        <td><%=user1.getIdEmpresa()%></td>
                                        <td><%=user1.getNombre()%></td>
                                        <td><%=user1.getApellido()%></td>
                                        <td><%=user1.getEmail()%></td>
                                        <td><%=user1.getContrasena()%></td>
                                        <td><%=user1.getFechaRegistro()%></td>
                                        <td><%=user1.getEstado()%></td>
                                        
                                        <td><a href="actualizarUsuario.jsp?id=<%=user1.getUsuario()%>" class="btn btn-dark">Actualizar</a></td>
                                        <td><a href="eliminarUsuario.jsp?id=<%=user1.getUsuario()%>" class="btn btn-danger">Eliminar</a></td>
                                    </tr>
                            <%
                                } else {
                                    user = Usuario.getSrvUsuarioPort().listar(); 
                                    for(int i = 0; i < user.size(); i++){
                            %>
                                        <tr>
                                            <td><%=user.get(i).getUsuario()%></td>
                                            <td><%=user.get(i).getIdEmpresa()%></td>
                                            <td><%=user.get(i).getNombre()%></td>
                                            <td><%=user.get(i).getApellido()%></td>
                                            <td><%=user.get(i).getEmail()%></td>
                                            <td><%=user.get(i).getContrasena()%></td>
                                            <td><%=user.get(i).getFechaRegistro()%></td>
                                            <td><%=user.get(i).getEstado()%></td>
                                            
                                            <td><a href="actualizarUsuario.jsp?id=<%=user.get(i).getUsuario()%>" class="btn btn-dark">Actualizar</a></td>
                                            <td><a href="eliminarUsuario.jsp?id=<%=user.get(i).getUsuario()%>" class="btn btn-danger">Eliminar</a></td>
                                        </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                    
                </div>
            </div>
        </div>  
        
        <%-- =============================
             MENSAJE DE RESPUESTA
        ============================== --%>
        <%
            if(request.getAttribute("respuesta") != null){
                int respuesta = Integer.parseInt(request.getAttribute("respuesta").toString());
                if(respuesta == 1){
        %>
                    <script>
                        swal("Eliminación", "Registro eliminado exitosamente", "success");
                    </script>
        <%
                } else {
        %>
                    <script>
                        swal("Error", "No se realizó la eliminación", "error");
                    </script>
        <%
                }
            }
        %>
        
    </body>
</html>
