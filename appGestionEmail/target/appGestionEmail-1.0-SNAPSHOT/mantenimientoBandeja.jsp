<%-- 
    mantenimientoBandeja.jsp
    Página principal para listar, buscar, actualizar y eliminar empresas.
    - Incluye un formulario de búsqueda por ID
    - Muesta una tabla con todos los registros o el resultado de búsqueda.
    - Permite ir a actualizarBandeja.jsp o eliminarBandeja.jsp
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.bandeja.Bandeja"%>
<%@page import="Modelo.bandeja.SrvBandeja_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Bandeja</title>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <%-- Menú principal --%>
        <%@include file="menu.jsp"%>
        
        <%-- =============================
             FORMULARIO DE BÚSQUEDA
        ============================== --%>
        <form name="frmMantenimiento" action="srvBuscarBandeja" method="POST">
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
                                <th scope="row">ID de la Bandeja</th>
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
                                <th>Usuario Remitente</th>
                                <th>idTipoBandeja</th>
                                <th>idEstadoEmail</th>
                                <th>Asunto</th>
                                <th>Mensaje</th>
                                <th>Fecha de Envío</th>
                                <th>Adjunto</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Bandeja> b;
                                Bandeja b1;
                                SrvBandeja_Service bandeja = new SrvBandeja_Service();
                                
                                if(request.getAttribute("idBandeja") != null){
                                    Integer idBandeja = Integer.parseInt(request.getAttribute("idBandeja").toString());
                                    b1 = bandeja.getSrvBandejaPort().listarPorID(idBandeja);
                            %>
                                    <tr>
                                        <td><%=b1.getIdBandeja()%></td>
                                        <td><%=b1.getUsuarioRemitente()%></td>
                                        <td><%=b1.getIdTipoBandeja()%></td>
                                        <td><%=b1.getIdEstadoEmail()%></td>
                                        <td><%=b1.getAsunto()%></td>
                                        <td><%=b1.getMensaje()%></td>
                                        <td><%=b1.getFechaEnvio()%></td>
                                        <td><%=b1.getAdjunto()%></td>
                                        <td><a href="actualizarBandeja.jsp?id=<%=b1.getIdBandeja()%>" class="btn btn-dark">Actualizar</a></td>
                                        <td><a href="eliminarBandeja.jsp?id=<%=b1.getIdBandeja()%>" class="btn btn-danger">Eliminar</a></td>
                                    </tr>
                            <%
                                } else {
                                    b = bandeja.getSrvBandejaPort().listar(); 
                                    for(int i = 0; i < b.size(); i++){
                            %>
                                        <tr>
                                            <td><%=b.get(i).getIdBandeja()%></td>
                                            <td><%=b.get(i).getUsuarioRemitente()%></td>
                                            <td><%=b.get(i).getIdTipoBandeja()%></td>
                                            <td><%=b.get(i).getIdEstadoEmail()%></td>
                                            <td><%=b.get(i).getAsunto()%></td>
                                            td><%=b.get(i).getMensaje()%></td>
                                            <td><%=b.get(i).getFechaEnvio()%></td>
                                            <td><%=b.get(i).getAdjunto()%></td>
                                            <td><a href="actualizarBandeja.jsp?id=<%=b.get(i).getIdBandeja()%>" class="btn btn-dark">Actualizar</a></td>
                                            <td><a href="eliminarBandeja.jsp?id=<%=b.get(i).getIdBandeja()%>" class="btn btn-danger">Eliminar</a></td>
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
