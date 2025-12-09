package Controlador;

import Modelo.usuario.SrvUsuario_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de actualizar la información de un usuario existente.
 */
public class srvActualizarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            Integer respuesta = 0;
            
            //Captura de parámetros enviados desde el formulario
            int idEmpresa = Integer.parseInt(request.getParameter("txtIdEmpresa").toString());
            String nombre = request.getParameter("txtNombre").toString();
            String apellido = request.getParameter("txtApellido").toString();
            String email = request.getParameter("txtEmail").toString();
            String contrasena = request.getParameter("txtContrasena").toString();
            String fechaRegistro = request.getParameter("txtFechaRegistro").toString();
            String estado = request.getParameter("txtEstado").toString();
            String usuario = request.getParameter("txtUsuario").toString();
            
            //Instanciamos el servicio web
            SrvUsuario_Service user = new SrvUsuario_Service();
            
            //Llamada al método de actualización
            respuesta = user.getSrvUsuarioPort().actualizacion(idEmpresa, nombre, apellido, email, contrasena, fechaRegistro, estado, usuario);
            
            //Guardamos la respuesta en el request
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos nuevamente al formulario de actualización con el mismo ID
            rd = request.getRequestDispatcher("actualizarUsuario.jsp?id=" + usuario);
            rd.forward(request, response);
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para actualizar usuarios";
    }
}