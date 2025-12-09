<%-- 
    mantenimientoDestinatario.jsp
    Página principal para listar, buscar, actualizar y eliminar destinatarios
    - Incluye un formulario de búsqueda por ID.
    - Muestra una tabla con todos los registros o el resultado de búsqueda.
    - Permite ir a actualizarDestinatario.jsp o eliminarDestinatario.jsp
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.destinatarioemail.DestinatarioEmail"%>
<%@page import="Modelo.destinatarioemail.SrvDestinatarioEmail_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Destinatario</title>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <%-- Menú principal --%>
        <%@include file="menu.jsp"%>
        
        <%-- =============================
             FORMULARIO DE BÚSQUEDA
        ============================== --%>
        <form name="frmMantenimiento" action="srvBuscarDestinatario" method="POST">
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
                                <th scope="row">ID del Destinatario</th>
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
                                <th>idBandeja</th>
                                <th>Usuario Destinatario</th>
                                <th>Tipo de Destinatario</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<DestinatarioEmail> d;
                                DestinatarioEmail d1;
                                SrvDestinatarioEmail_Service destinatario = new SrvDestinatarioEmail_Service();
                                
                                if(request.getAttribute("idDestinatario") != null){
                                    Integer idDestinatario = Integer.parseInt(request.getAttribute("idDestinatario").toString());
                                    d1 = destinatario.getSrvDestinatarioEmailPort().listarPorID(idDestinatario);
                            %>
                                    <tr>
                                        <td><%=d1.getIdDestinatario()%></td>
                                        <td><%=d1.getIdBandeja()%></td>
                                        <td><%=d1.getUsuarioDestinatario()%></td>
                                        <td><%=d1.getTipoDestinatario()%></td>
                                        <td><a href="actualizarDestinatario.jsp?id=<%=d1.getIdDestinatario()%>" class="btn btn-dark">Actualizar</a></td>
                                        <td><a href="eliminarDestinatario.jsp?id=<%=d1.getIdDestinatario()%>" class="btn btn-danger">Eliminar</a></td>
                                    </tr>
                            <%
                                } else {
                                    d = destinatario.getSrvDestinatarioEmailPort().listar(); 
                                    for(int i = 0; i < d.size(); i++){
                            %>
                                        <tr>
                                            <td><%=d.get(i).getIdDestinatario()%></td>
                                            <td><%=d.get(i).getIdBandeja()%></td>
                                            <td><%=d.get(i).getUsuarioDestinatario()%></td>
                                            <td><%=d.get(i).getTipoDestinatario()%></td>
                                            <td><a href="actualizarDestinatario.jsp?id=<%=d.get(i).getIdDestinatario()%>" class="btn btn-dark">Actualizar</a></td>
                                            <td><a href="eliminarDestinatario.jsp?id=<%=d.get(i).getIdDestinatario()%>" class="btn btn-danger">Eliminar</a></td>
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
