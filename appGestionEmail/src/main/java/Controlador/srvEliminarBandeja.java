package Controlador;

import Modelo.bandeja.SrvBandeja_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de eliminar una bandeja existente de la base de datos.
 */
public class srvEliminarBandeja extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            Integer respuesta = 0;
            
            //Capturamos el ID de la bandeja a eliminar
            Integer idBandeja = Integer.parseInt(request.getParameter("txtIdBandeja").toString());
            System.out.println("ID recibido para eliminar: " + idBandeja);
            
            //Instanciamos el servicio web
            SrvBandeja_Service bandeja = new SrvBandeja_Service();
            
            //Llamamos al método de eliminación
            respuesta = bandeja.getSrvBandejaPort().eliminar(idBandeja);
            
            //Guardamos la respuesta en el request
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos al mantenimiento para mostrar el mensaje
            rd = request.getRequestDispatcher("mantenimientoBandeja.jsp");
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
        return "Servlet para eliminar bandejas";
    }
}