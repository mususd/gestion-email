<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session = "true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
    </head>
    <body>
            <div class="container">
            <h2 class="text-center">Iniciar Sesión</h2>
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <form class="login-form" name="frmUser" action="srvUser" method="POST">
                        <div class="form-group">
                            <label for="username">Usuario</label>
                            <input type="text" id="username" name="username" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Contraseña</label>
                            <input type="password" id="password" name="password" required>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Iniciar Sesión</button>
                    </form>
                </div>
            </div>
            </div>
        
        <%
        HttpSession sesion = request.getSession();
        if(request.getAttribute("usuario")!= null){
            if(request.getAttribute("respuesta") == "True"){
            sesion.setAttribute("usuario", request.getAttribute("usuario"));
                response.sendRedirect("menu.jsp");
            }else{
                %>
                <script> swal("Acceso Incorrecto", "Usuario y contraseña incorrecta", "error");</script>
                    <%
            }
        }
        %>
    </body>
</html>