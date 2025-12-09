package Controlador;

import Modelo.tipobandeja.SrvTipoBandeja_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de manejar la inserción de nuevos tipo de bandeja.
 * Se comunica con el servicio web (SrvEmpresa_Service) para registrar
 * una empresa en la base de datos.
 */

public class srvTipoBandeja extends HttpServlet {
    
    /**
     * Método principal para procesar las peticiones (GET y POST).
     * Obtiene los datos del formulario, llama al servicio web y reenvía la respuesta.
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            
            // Declaración de variables para los campos del formulario
            String nombreTipo;
            int respuesta;
            
            //Captura de datos del formulario
            nombreTipo = request.getParameter("txtNombreTipo").toString();
            
            //No instanciamos un modelo, porque el modelo en este caso es el servicio web
            //Instanciamos el servicio web que contiene los métodos de inserción
            SrvTipoBandeja_Service tipoBandeja = new SrvTipoBandeja_Service();
            
            //Llamada al método del servicio web para insertar el tipo de bandeja
            //Devuelve un entero (1 = exito, 0 = error)
            respuesta = tipoBandeja.getSrvTipoBandejaPort().insertar(nombreTipo);
            
            //Guardamos la respuesta en un atributo para enviarla a la vista
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos la respuesta a la vista (nuevoTipoBandeja.jsp)
            rd = request.getRequestDispatcher("nuevoTipoBandeja.jsp");
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
        return "Servlet para insertar nuevos tipos de bandeja";
    }

}
