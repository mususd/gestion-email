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
 * Servlet encargado de actualizar la información de un historial existente.
 */

public class srvActualizarHistorial extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            Integer respuesta = 0;
            
            //Captura de parámetros enviados desde el formulario
            int idHistorial = Integer.parseInt(request.getParameter("txtIdHistorial").toString());
            String usuario = request.getParameter("txtUsuario").toString();
            String fechaIngreso = request.getParameter("txtFechaIngreso").toString();
            String fechaSalida = request.getParameter("txtFechaSalida").toString();
            
            //Instanciamos el servicio web
            SrvHistorialIngresos_Service historial = new SrvHistorialIngresos_Service();
            
            //Llamada al método de actualización
            respuesta = historial.getSrvHistorialIngresosPort().actualizacion(idHistorial, usuario, fechaIngreso, fechaSalida);
            
            //Guardamos la respuesta en el request
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos nuevamente al formulario de actualización con el mismo ID.
            rd = request.getRequestDispatcher("actualizarHistorial.jsp?id=" + idHistorial);
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
        return "Servlet para actualizar historiales";
    }
}