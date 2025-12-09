<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>

<%
    HttpSession sesion = request.getSession();
    
    if (request.getParameter("cerrar") != null) {
        sesion.invalidate();                 // destruir sesión
        response.sendRedirect("login.jsp");  // redirigir a login
        return;                              // detener ejecución
    }

    if (sesion.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Menu Principal</title>
    
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="menu.jsp">Gestion de Email</a>
        
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" 
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            
            <ul class="navbar-nav mr-auto">
                <!-- Menú Empresa -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                        Empresa
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="nuevaEmpresa.jsp">Nueva empresa</a>
                        <a class="dropdown-item" href="mantenimientoEmpresa.jsp">Mantenimiento</a>
                    </div>
                </li>
                
                <!-- Menú Tipo Bandeja -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                        Tipo de Bandeja
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="nuevoTipoBandeja.jsp">Nuevo tipo de bandeja</a>
                        <a class="dropdown-item" href="mantenimientoTipoBandeja.jsp">Mantenimiento</a>
                    </div>
                </li>
                
                <!-- Menú Estado Email -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                        Estado Email
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="nuevoEstadoEmail.jsp">Nuevo estado de email</a>
                        <a class="dropdown-item" href="mantenimientoEstadoEmail.jsp">Mantenimiento</a>
                    </div>
                </li>
                
                <!-- Menú Usuario -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                        Usuario
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="nuevoUsuario.jsp">Nuevo usuario</a>
                        <a class="dropdown-item" href="mantenimientoUsuario.jsp">Mantenimiento</a>
                    </div>
                </li>
                
                <!-- Menú Recuperar Contraseña -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                        Recuperar Contraseña
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="nuevaRecuperarContrasena.jsp">Nueva solicitud de Recuperar Contraseña</a>
                        <a class="dropdown-item" href="mantenimientoRecuperarContrasena.jsp">Mantenimiento</a>
                    </div>
                </li>
                
                <!-- Menú Historial de Ingreso -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                        Historial de Ingreso
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="nuevoHistorial.jsp">Nuevo historial de ingreso</a>
                        <a class="dropdown-item" href="mantenimientoHistorial.jsp">Mantenimiento</a>
                    </div>
                </li>
                
                <!-- Menú Bandeja -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                        Bandeja
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="nuevaBandeja.jsp">Nueva bandeja</a>
                        <a class="dropdown-item" href="mantenimientoBandeja.jsp">Mantenimiento</a>
                    </div>
                </li>
                
                <!-- Menú Destinatario Email -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                        Destinatario Email
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="nuevoDestinatario.jsp">Nuevo Destinatario Email</a>
                        <a class="dropdown-item" href="mantenimientoDestinatario.jsp">Mantenimiento</a>
                    </div>
                </li>
                
                <!-- Menú Reportes -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                        Reportes
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="rptUsuario.jsp">Usuario</a>
                        <a class="dropdown-item" href="rptBandeja.jsp">Bandeja</a>
                        <a class="dropdown-item" href="rptRecuperarContrasena.jsp">Recuperar Contraseña</a>
                        <a class="dropdown-item" href="rptEmpresa.jsp">Empresa</a>
                        <a class="dropdown-item" href="rptHistorialIngresos.jsp">Historial de Ingresos</a>
                        <a class="dropdown-item" href="rptDestinatarioEmail.jsp">Destinatario de Email</a>
                        <a class="dropdown-item" href="rptEstadoEmail.jsp">Estado Email</a>
                        <a class="dropdown-item" href="rptTipoBandeja.jsp">Tipo de Bandeja</a>
                    </div>
                </li>
            </ul>
            
            <!-- Barra de búsqueda + botón cerrar sesión -->
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                
                <!-- Botón de cerrar sesión -->
                <a href="menu.jsp?cerrar=true" class="btn btn-dark ml-2">Cerrar Sesión</a>
            </form>
        </div>
    </nav>
</body>
</html>