package Controlador;

import Modelo.recuperarcontrasena.SrvRecuperarContrasena_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de actualizar la información de una recuperación de contraseña existente.
 */

public class srvActualizarRecuperarContrasena extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            Integer respuesta = 0;
            
            //Captura de parámetros enviados desde el formulario
            int idRecuperacion = Integer.parseInt(request.getParameter("txtIdRecuperacion").toString());
            String usuario = request.getParameter("txtUsuario").toString();
            String fechaSolicitud = request.getParameter("txtFechaSolicitud").toString();
            String codigoRecuperacion = request.getParameter("txtCodigoRecuperacion").toString();
            String estadoSolicitud = request.getParameter("txtEstadoSolicitud").toString();
            
            
            //Instanciamos el servicio web
            SrvRecuperarContrasena_Service recuperarContrasena = new SrvRecuperarContrasena_Service();
            
            //Llamada al método de actualización
            respuesta = recuperarContrasena.getSrvRecuperarContrasenaPort().actualizacion(idRecuperacion, usuario, fechaSolicitud, codigoRecuperacion, estadoSolicitud);
            
            //Guardamos la respuesta en el request
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos nuevamente al formulario de actualización con el mismo ID
            rd = request.getRequestDispatcher("actualizarRecuperarContrasena.jsp?id=" + idRecuperacion);
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
        return "Servlet para actualizar solicitudes de recuperación de contraseña";
    }
}