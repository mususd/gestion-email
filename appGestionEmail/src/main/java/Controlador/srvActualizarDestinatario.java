package Controlador;

import Modelo.destinatarioemail.SrvDestinatarioEmail_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de actualizar la información de un destinatario existente.
 */

public class srvActualizarDestinatario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            Integer respuesta = 0;
            
            //Captura de parámetros enviados desde el formulario
            int idDestinatario = Integer.parseInt(request.getParameter("txtIdDestinatario").toString());
            int idBandeja = Integer.parseInt(request.getParameter("txtIdBandeja").toString());
            String usuarioDestinatario = request.getParameter("txtUsuarioDestinatario").toString();
            String tipoDestinatario = request.getParameter("txtTipoDestinatario").toString();
            
            //Instanciamos el servicio web
            SrvDestinatarioEmail_Service destinatario = new SrvDestinatarioEmail_Service();
            
            //Guardamos la respuesta en el request
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos nuevamente al formulario de actualización con el mismo ID
            rd = request.getRequestDispatcher("actualizarDestinatario.jsp?id=" + idDestinatario);
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
        return "Servlet para actualizar empresas";
    }
}