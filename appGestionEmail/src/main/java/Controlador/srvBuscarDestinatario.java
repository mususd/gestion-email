package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de buscar destinatarios por su ID.
 * Recibe un parámetro del formulario, lo guarda en el request y reenvía la petición
 * a mantenimientoDestinatario.jsp
 */
public class srvBuscarDestinatario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            
            //Captura del parámetro de búsqueda (ID del destinatario)
            Integer idDestinatario = Integer.parseInt(request.getParameter("txtBuscar").toString());
            
            //Guardamos el ID como atributo para que lo use la vista
            request.setAttribute("idDestinatario", idDestinatario);
            
            //Redirigimos la petición al JSP de mantenimiento
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
        return "Servlet para buscar destinatarios por ID";
    }
}