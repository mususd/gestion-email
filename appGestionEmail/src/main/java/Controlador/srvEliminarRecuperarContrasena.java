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
 * Servlet encargado de eliminar una solicitud de recuperación de contraseña existente en la base de datos.
 */
public class srvEliminarRecuperarContrasena extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            Integer respuesta = 0;
            
            //Capturamos el ID de la solicitud de recuperación de contraseña a eliminar
            Integer idRecuperacion = Integer.parseInt(request.getParameter("txtIdRecuperacion").toString());
            
            //Instanciamos el servicio web
            SrvRecuperarContrasena_Service recuperarContrasena = new SrvRecuperarContrasena_Service();
            
            //Llamamos al método de eliminación
            respuesta = recuperarContrasena.getSrvRecuperarContrasenaPort().eliminar(idRecuperacion);
            
            //Guardamos la respuesta en el request
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos al mantenimiento para mostrar el mensaje
            rd = request.getRequestDispatcher("mantenimientoRecuperarContrasena.jsp");
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
        return "Servlet para eliminar una solicitud de recuperación de contraseña";
    }
}