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
 * Servlet encargado de eliminar un destinatario existente de la base de datos.
 */
public class srvEliminarDestinatario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            Integer respuesta = 0;
            
            // Capturamos el ID del destinatario a eliminar
            Integer idDestinatario = Integer.parseInt(request.getParameter("txtIdDestinatario"));
            
            // Instanciamos el servicio web
            SrvDestinatarioEmail_Service destinatario = new SrvDestinatarioEmail_Service();
            
            // Llamamos al método de eliminación
            respuesta = destinatario.getSrvDestinatarioEmailPort().eliminar(idDestinatario);
            
            // Guardamos la respuesta en el request
            request.setAttribute("respuesta", respuesta);
            
            // Redirigimos al mantenimiento para mostrar el mensaje
            rd = request.getRequestDispatcher("mantenimientoDestinatario.jsp");
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
        return "Servlet para eliminar destinatarios";
    }
}