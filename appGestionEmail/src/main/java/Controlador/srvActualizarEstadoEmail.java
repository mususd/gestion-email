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
 * Servlet encargado de actualizar la información del estado de email existente.
 */

public class srvActualizarEstadoEmail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            
            RequestDispatcher rd = null;
            Integer respuesta = 0;
            
            //Captura de parámtros enviados desde el formulario
            String nombreEstado = request.getParameter("txtNombreEstado").toString();
            int idEstadoEmail = Integer.parseInt(request.getParameter("txtIdEstadoEmail").toString());
            
            //Instancio del servicio web
            SrvEstadoEmail_Service estadoEmail = new SrvEstadoEmail_Service();
            
            //Llamada al método de actualización
            respuesta = estadoEmail.getSrvEstadoEmailPort().actualizacion(nombreEstado, idEstadoEmail);
            
            //Guardamos la respuesta en el request
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos nuevamente al formulario de actualización con el mismo ID
            rd = request.getRequestDispatcher("actualizarEstadoEmail.jsp?id=" + idEstadoEmail);
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
        return "Servlet para actualizar estados de email";
    }
}