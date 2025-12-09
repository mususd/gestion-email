<%-- 
    mantenimientoEstadoEmail.jsp
    Página principal para listar, buscar, actualizar y eliminar estados de email.
    - Incluye un formulario de búsqueda por ID.
    - Muestra una tabla con todos los registros o el resultado de búsqueda.
    - Permite ir a actualizarEstadoEmail.jsp o eliminarEstadoEmail.jsp
--%>

<%@page import="Modelo.estadoemail.EstadoEmail"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.estadoemail.SrvEstadoEmail_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Estado Email</title>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <%-- Menú principal --%>
        <%@include file="menu.jsp"%>
        
        <%-- =============================
             FORMULARIO DE BÚSQUEDA
        ============================== --%>
        <form name="frmMantenimiento" action="srvBuscarEstadoEmail" method="POST">
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
                                <th scope="row">ID del Estado Email</th>
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
                                <th>Nombre</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<EstadoEmail> e;
                                EstadoEmail e1;
                                SrvEstadoEmail_Service estadoEmail = new SrvEstadoEmail_Service();
                                
                                if(request.getAttribute("idEstadoEmail") != null){
                                    Integer idEstadoEmail = Integer.parseInt(request.getAttribute("idEstadoEmail").toString());
                                    e1 = estadoEmail.getSrvEstadoEmailPort().listarPorID(idEstadoEmail);
                            %>
                                    <tr>
                                        <td><%=e1.getIdEstadoEmail()%></td>
                                        <td><%=e1.getNombreEstado()%></td>
                                        <td><a href="actualizarEstadoEmail.jsp?id=<%=e1.getIdEstadoEmail()%>" class="btn btn-dark">Actualizar</a></td>
                                        <td><a href="eliminarEstadoEmail.jsp?id=<%=e1.getIdEstadoEmail()%>" class="btn btn-danger">Eliminar</a></td>
                                    </tr>
                            <%
                                } else {
                                    e = estadoEmail.getSrvEstadoEmailPort().listar(); 
                                    for(int i = 0; i < e.size(); i++){
                            %>
                                        <tr>
                                            <td><%=e.get(i).getIdEstadoEmail()%></td>
                                            <td><%=e.get(i).getNombreEstado()%></td>
                                            <td><a href="actualizarEstadoEmail.jsp?id=<%=e.get(i).getIdEstadoEmail()%>" class="btn btn-dark">Actualizar</a></td>
                                            <td><a href="eliminarEstadoEmail.jsp?id=<%=e.get(i).getIdEstadoEmail()%>" class="btn btn-danger">Eliminar</a></td>
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
                        swal("Eliminación", "Estado de email eliminado exitosamente", "success");
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
