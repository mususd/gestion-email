package Controlador;

import Modelo.estadoemail.SrvEstadoEmail_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de manejar la inserción de nuevos estados de email.
 * Se comunica con el servicio web (SrvEstadoEmail_Service) para registrar
 * un estado de email en la base de datos.
 */

public class srvEstadoEmail extends HttpServlet {
    
    /**
     * Método principal para procesar las peticiones (GET y POST).
     * Obtiene los datos del formulario, llama al servicio web y reenvía la respuesta.
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            
            //Declaración de variable para el campo del formulario
            String nombreEstado;
            int respuesta;
            
            //Capturamos el dato del formulario
            nombreEstado = request.getParameter("txtNombreEstado").toString();
            
            // No instanciamos un modelo, porque el modelo en este caso es el servicio web
            // Instanciamos el servicio web que contiene los métodos de inserción
            SrvEstadoEmail_Service estadoEmail = new SrvEstadoEmail_Service();
            
            // Llamada al método del servicio web para insertar el estado de email
            // Devuelve un entero (1 = éxito, 0 = error)
            respuesta = estadoEmail.getSrvEstadoEmailPort().insertar(nombreEstado);
            
            // Guardamos la respuesta en un atributo para enviarla a la vista
            request.setAttribute("respuesta", respuesta);
            
            // Redirigimos la respuesta a la vista (nuevoEstadoEmail.jsp)
            rd = request.getRequestDispatcher("nuevoEstadoEmail.jsp");
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
        return "Servlet para insertar nuevos estados de email";
    }
}