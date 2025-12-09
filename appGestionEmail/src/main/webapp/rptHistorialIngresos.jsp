<%-- 
    rptHistorialIngresos.jsp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reportes - Historial de Ingresos</title>
    </head>
    <body>
        
        <%-- Menú principal --%>
        <%@include file="menu.jsp"%>
        
        <%-- =============================
             FORMULARIO DE BÚSQUEDA
        ============================== --%>
        <form name="frmReportes" action="srvPdfHistorial" method="POST">
            <div class="row d-flex justify-content-center">
                <div class="col-md-3">
                    <table class="table">
                        <thead>
                                <h5>Visor de Datos - Historial de Ingresos</h5>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">idHistorial</th>
                                <td><input type="text" name="txtIdHistorial" value="" /></td>
                                <td><button type="submit" class="btn btn-dark" name="btnBuscarIdHistorial">Buscar</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>  
        </form>
        
        <%-- ===============================================
             FORMULARIO DE BÚSQUEDA PARA TODOS LOS DATOS
        ==================================================== --%>
        <form name="frmReportes2" action="srvPdfHistorial" method="POST">
            <div class="row d-flex justify-content-center">
                <div class="col-md-3">
                    <table class="table">
                        <thead>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">Visualizar todos los Registros</th>
                                <td><button type="submit" class="btn btn-dark" name="btnReporte">Visualizar</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>  
        </form>
        
    </body>
</html>
