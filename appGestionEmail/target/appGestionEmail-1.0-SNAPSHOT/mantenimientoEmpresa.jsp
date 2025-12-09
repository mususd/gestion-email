<%-- 
    mantenimientoEmpresa.jsp
    Página principal para listar, buscar, actualizar y eliminar empresas.
    - Incluye un formulario de búsqueda por ID.
    - Muestra una tabla con todos los registros o el resultado de búsqueda.
    - Permite ir a actualizarEmpresa.jsp o eliminarEmpresa.jsp
--%>

<%@page import="Modelo.empresa.Empresa"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.empresa.SrvEmpresa_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Empresa</title>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <%-- Menú principal --%>
        <%@include file="menu.jsp"%>
        
        <%-- =============================
             FORMULARIO DE BÚSQUEDA
        ============================== --%>
        <form name="frmMantenimiento" action="srvBuscarEmpresa" method="POST">
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
                                <th scope="row">ID de la Empresa</th>
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
                                <th>Dirección</th>
                                <th>Teléfono</th>
                                <th>Email</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Empresa> e;
                                Empresa e1;
                                SrvEmpresa_Service empresa = new SrvEmpresa_Service();
                                
                                if(request.getAttribute("idEmpresa") != null){
                                    Integer idEmpresa = Integer.parseInt(request.getAttribute("idEmpresa").toString());
                                    e1 = empresa.getSrvEmpresaPort().listarPorID(idEmpresa);
                            %>
                                    <tr>
                                        <td><%=e1.getIdEmpresa()%></td>
                                        <td><%=e1.getNombre()%></td>
                                        <td><%=e1.getDireccion()%></td>
                                        <td><%=e1.getTelefono()%></td>
                                        <td><%=e1.getEmail()%></td>
                                        <td><a href="actualizarEmpresa.jsp?id=<%=e1.getIdEmpresa()%>" class="btn btn-dark">Actualizar</a></td>
                                        <td><a href="eliminarEmpresa.jsp?id=<%=e1.getIdEmpresa()%>" class="btn btn-danger">Eliminar</a></td>
                                    </tr>
                            <%
                                } else {
                                    e = empresa.getSrvEmpresaPort().listar(); 
                                    for(int i = 0; i < e.size(); i++){
                            %>
                                        <tr>
                                            <td><%=e.get(i).getIdEmpresa()%></td>
                                            <td><%=e.get(i).getNombre()%></td>
                                            <td><%=e.get(i).getDireccion()%></td>
                                            <td><%=e.get(i).getTelefono()%></td>
                                            <td><%=e.get(i).getEmail()%></td>
                                            <td><a href="actualizarEmpresa.jsp?id=<%=e.get(i).getIdEmpresa()%>" class="btn btn-dark">Actualizar</a></td>
                                            <td><a href="eliminarEmpresa.jsp?id=<%=e.get(i).getIdEmpresa()%>" class="btn btn-danger">Eliminar</a></td>
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