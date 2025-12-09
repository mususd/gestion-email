package Controlador;

import Modelo.historialingresos.SrvHistorialIngresos_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de eliminar un historial de la base de datos.
 */
public class srvEliminarHistorial extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            Integer respuesta = 0;
            
            //Capturamos el ID del historial a eliminar
            Integer idHistorial = Integer.parseInt(request.getParameter("txtIdHistorial"));
            
            //Instanciamos el servicio web
            SrvHistorialIngresos_Service historial = new SrvHistorialIngresos_Service();
            
            //Llamamos al método de eliminación
            respuesta = historial.getSrvHistorialIngresosPort().eliminar(idHistorial);
            
            //Guardamos la respuesta en el request
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos al mantenimiento para mostrar el mensaje
            rd = request.getRequestDispatcher("mantenimientoHistorial.jsp");
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
        return "Servlet para eliminar historiales";
    }
}