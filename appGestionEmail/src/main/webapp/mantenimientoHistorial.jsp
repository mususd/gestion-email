<%-- 
    mantenimientoHistorial.jsp
    Página principal para listar, buscar, actualizar y eliminar historiales.
    - Incluye un formulario de búsqueda por ID.
    - Muestra una tabla con todos los registros o el resultado de búsqueda.
    - Permite ir a actualizarHistorial.jsp o eliminarHistorial.jsp
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.historialingresos.HistorialIngresos"%>
<%@page import="Modelo.historialingresos.SrvHistorialIngresos_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Historiales de Ingreso</title>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <%-- Menú principal --%>
        <%@include file="menu.jsp"%>
        
        <%-- =============================
             FORMULARIO DE BÚSQUEDA
        ============================== --%>
        <form name="frmMantenimiento" action="srvBuscarHistorial" method="POST">
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
                                <th scope="row">ID del Historial</th>
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
                                <th>Fecha de Ingreso</th>
                                <th>Fecha de Salida</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<HistorialIngresos> h;
                                HistorialIngresos h1;
                                SrvHistorialIngresos_Service historial = new SrvHistorialIngresos_Service();
                                
                                if(request.getAttribute("idHistorial") != null){
                                    Integer idHistorial = Integer.parseInt(request.getAttribute("idHistorial").toString());
                                    h1 = historial.getSrvHistorialIngresosPort().listarPorID(idHistorial);
                            %>
                                    <tr>
                                        <td><%=h1.getIdHistorial()%></td>
                                        <td><%=h1.getUsuario()%></td>
                                        <td><%=h1.getFechaIngreso()%></td>
                                        <td><%=h1.getFechaSalida()%></td>
                                        <td><a href="actualizarHistorial.jsp?id=<%=h1.getIdHistorial()%>" class="btn btn-dark">Actualizar</a></td>
                                        <td><a href="eliminarHistorial.jsp?id=<%=h1.getIdHistorial()%>" class="btn btn-danger">Eliminar</a></td>
                                    </tr>
                            <%
                                } else {
                                    h = historial.getSrvHistorialIngresosPort().listar(); 
                                    for(int i = 0; i < h.size(); i++){
                            %>
                                        <tr>
                                            <td><%=h.get(i).getIdHistorial()%></td>
                                            <td><%=h.get(i).getUsuario()%></td>
                                            <td><%=h.get(i).getFechaIngreso()%></td>
                                            <td><%=h.get(i).getFechaSalida()%></td>
                                            <td><a href="actualizarHistorial.jsp?id=<%=h.get(i).getIdHistorial()%>" class="btn btn-dark">Actualizar</a></td>
                                            <td><a href="eliminarHistorial.jsp?id=<%=h.get(i).getIdHistorial()%>" class="btn btn-danger">Eliminar</a></td>
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
                        swal("Eliminación", "Historial eliminado exitosamente", "success");
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
