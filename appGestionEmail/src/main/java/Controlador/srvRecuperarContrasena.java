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
 * Servlet encargado de manejar la inserción de recuperaciones de contrasena.
 * Se comunica con el servicio web (SrvRecuperarContrasena_Service) para registrar
 * una recuperación de contraseña en la base de datos.
 */
public class srvRecuperarContrasena extends HttpServlet {
    
    /**
    * Método principal para procesar las peticiones (GET y POST).
    * Obtiene los datos del formulario, llama al servicio web y reenvía la respuesta.
    */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            
            //Declaración de variables para los campos del formulario
            int respuesta;
            
            //Captura de datos del formulario
            String usuario = request.getParameter("txtUsuario").toString();
            String fechaSolicitud = request.getParameter("txtFechaSolicitud").toString();
            String codigoRecuperacion = request.getParameter("txtCodigoRecuperacion").toString();
            String estadoSolicitud = request.getParameter("txtEstadoSolicitud").toString();
            
            //No instanciamos un modelom, porque el modelo en este caso es el servicio web
            //Instanciamos el servicio web que contiene los métodos de inserción
            SrvRecuperarContrasena_Service recuperarContrasena = new SrvRecuperarContrasena_Service();
            
            //Llamada al método del servicio web para insertar una recuperación de contraseña
            //Devuelve un entero (1 = éxito, 0 = error)
            respuesta = recuperarContrasena.getSrvRecuperarContrasenaPort().insertar(usuario, fechaSolicitud, codigoRecuperacion, estadoSolicitud);
            
            //Guardamos la respuesta en un atributo para enviarla a la vista
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos la respuesta a la vista (nuevaRecuperarContrasena.jsp)
            rd = request.getRequestDispatcher("nuevaRecuperarContrasena.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * Maneja el método GET
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Maneja el método POST
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Información corta del servlet
     */
    @Override
    public String getServletInfo() {
        return "Servlet para insertar nuevas solicitudes de recuperación de contraseña";
    }
}