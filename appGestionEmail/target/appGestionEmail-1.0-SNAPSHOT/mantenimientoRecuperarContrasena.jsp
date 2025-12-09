<%-- 
    mantenimientoRecuperarContrasena.jsp
    Página principal para listar, buscar, actualizar y eliminar solicitudes de recuperación de contraseña.
    - Incluye un formulario de búsqueda por ID.
    - Muestra una tabla con todos los registros o el resultado de la búsqueda.
    - Permite ir a actualizarRecuperarContrasena.jsp o eliminarRecuperarContrasena.jsp
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.recuperarcontrasena.RecuperarContrasena"%>
<%@page import="Modelo.recuperarcontrasena.SrvRecuperarContrasena_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Recuperar Contraseña</title>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <%-- Menú principal --%>
        <%@include file="menu.jsp"%>
        
        <%-- =============================
             FORMULARIO DE BÚSQUEDA
        ============================== --%>
        <form name="frmMantenimientoRecuperarContrasena" action="srvBuscarRecuperarContrasena" method="POST">
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
                                <th scope="row">ID de Recuperación</th>
                                <td><input type="text" name="txtBuscar" value="" /></td>
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
                                <th>ID</th>
                                <th>Usuario</th>
                                <th>Fecha de Solicitud</th>
                                <th>Código de Recuperación</th>
                                <th>Estado de Solicitud</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<RecuperarContrasena> r;
                                RecuperarContrasena r1;
                                SrvRecuperarContrasena_Service recuperarContrasena = new SrvRecuperarContrasena_Service();
                                
                                if(request.getAttribute("idRecuperacion") != null){
                                    Integer idRecuperacion = Integer.parseInt(request.getAttribute("idRecuperacion").toString());
                                    r1 = recuperarContrasena.getSrvRecuperarContrasenaPort().listarPorID(idRecuperacion);
                            %>
                                    <tr>
                                        <td><%=r1.getIdRecuperacion()%></td>
                                        <td><%=r1.getUsuario()%></td>
                                        <td><%=r1.getFechaSolicitud()%></td>
                                        <td><%=r1.getCodigoRecuperacion()%></td>
                                        <td><%=r1.getEstadoSolicitud()%></td>
                                        <td><a href="actualizarRecuperarContrasena.jsp?id=<%=r1.getIdRecuperacion()%>" class="btn btn-dark">Actualizar</a></td>
                                        <td><a href="eliminarRecuperarContrasena.jsp?id=<%=r1.getIdRecuperacion()%>" class="btn btn-danger">Eliminar</a></td>
                                    </tr>
                            <%
                                } else {
                                    r = recuperarContrasena.getSrvRecuperarContrasenaPort().listar(); 
                                    for(int i = 0; i < r.size(); i++){
                            %>
                                        <tr>
                                            <td><%=r.get(i).getIdRecuperacion()%></td>
                                            <td><%=r.get(i).getUsuario()%></td>
                                            <td><%=r.get(i).getFechaSolicitud()%></td>
                                            <td><%=r.get(i).getCodigoRecuperacion()%></td>
                                            <td><%=r.get(i).getEstadoSolicitud()%></td>
                                            <td><a href="actualizarRecuperarContrasena.jsp?id=<%=r.get(i).getIdRecuperacion()%>" class="btn btn-dark">Actualizar</a></td>
                                            <td><a href="eliminarRecuperarContrasena.jsp?id=<%=r.get(i).getIdRecuperacion()%>" class="btn btn-danger">Eliminar</a></td>
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
