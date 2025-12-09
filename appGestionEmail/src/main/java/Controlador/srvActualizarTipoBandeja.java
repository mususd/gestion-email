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
 * Servlet encargado de actualizar la información del tipo de bandeja existente.
 */
public class srvActualizarTipoBandeja extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            RequestDispatcher rd = null;
            Integer respuesta = 0;
            
            //Captura de parámetros enviados desde el formulario
            String nombreTipo = request.getParameter("txtNombreTipo").toString();
            int idTipoBandeja = Integer.parseInt(request.getParameter("txtIdTipoBandeja").toString());
            
            //Instancia del servicio web
            SrvTipoBandeja_Service tipoBandeja = new SrvTipoBandeja_Service();
            
            //Llamada al método de actualización
            respuesta = tipoBandeja.getSrvTipoBandejaPort().actualizacion(nombreTipo, idTipoBandeja);
            
            //Guardamos la respuesta en el request
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos nuevamente al formulario de actualización con el mismo ID
            rd = request.getRequestDispatcher("actualizarTipoBandeja.jsp?id=" + idTipoBandeja);
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
        return "Servlet para actualizar tipos de bandeja";
    }
}