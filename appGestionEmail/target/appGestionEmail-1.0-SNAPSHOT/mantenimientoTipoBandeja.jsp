<%-- 
    mantenimientoTipoBandeja.jsp
    Página principal para listar, buscar, actualizar y eliminar tipos de bandeja.
    - Incluye un formulario de búsqueda por ID.
    - Muestra una tabla con todos los registros o el resultado de búsqueda.
    - Permite ir a actualizarTipoBandeja.jsp o eliminarTipoBandeja.jsp
--%>
<%@page import="Modelo.tipobandeja.TipoBandeja"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.tipobandeja.SrvTipoBandeja_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de un Tipo de Bandeja</title>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <%-- Menú principal --%>
        <%@include file="menu.jsp"%>
        
        <%-- =============================
             FORMULARIO DE BÚSQUEDA
        ============================== --%>
        <form name="frmMantenimiento" action="srvBuscarTipoBandeja" method="POST">
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
                                <th scope="row">ID del Tipo de Bandeja</th>
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
                                List<TipoBandeja> tb;
                                TipoBandeja tb1;
                                SrvTipoBandeja_Service tipoBandeja = new SrvTipoBandeja_Service();
                                
                                if(request.getAttribute("idTipoBandeja") != null){
                                    Integer idTipoBandeja = Integer.parseInt(request.getAttribute("idTipoBandeja").toString());
                                    tb1 = tipoBandeja.getSrvTipoBandejaPort().listarPorID(idTipoBandeja);
                            %>
                                    <tr>
                                        <td><%=tb1.getIdTipoBandeja()%></td>
                                        <td><%=tb1.getNombreTipo()%></td>
                                        <td><a href="actualizarTipoBandeja.jsp?id=<%=tb1.getIdTipoBandeja()%>" class="btn btn-dark">Actualizar</a></td>
                                        <td><a href="eliminarTipoBandeja.jsp?id=<%=tb1.getIdTipoBandeja()%>" class="btn btn-danger">Eliminar</a></td>
                                    </tr>
                            <%
                                } else {
                                    tb = tipoBandeja.getSrvTipoBandejaPort().listar(); 
                                    for(int i = 0; i < tb.size(); i++){
                            %>
                                        <tr>
                                            <td><%=tb.get(i).getIdTipoBandeja()%></td>
                                            <td><%=tb.get(i).getNombreTipo()%></td>
                                            <td><a href="actualizarTipoBandeja.jsp?id=<%=tb.get(i).getIdTipoBandeja()%>" class="btn btn-dark">Actualizar</a></td>
                                            <td><a href="eliminarTipoBandeja.jsp?id=<%=tb.get(i).getIdTipoBandeja()%>" class="btn btn-danger">Eliminar</a></td>
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
