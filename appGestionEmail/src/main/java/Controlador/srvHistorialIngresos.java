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
 * Servlet encargado de manejar la inserción de nuevos historiales de ingreso.
 * Se comunica con el servicio web (SrvHistorialIngresos_Service) para registrar
 * un historial de ingreso en la base de datos
 */
public class srvHistorialIngresos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            
            //Declaración de variables para los campos del formulario
            String usuario, fechaIngreso, fechaSalida;
            int respuesta;
            
            //Captura de datos del formulario
            usuario = request.getParameter("txtUsuario").toString();
            fechaIngreso = request.getParameter("txtFechaIngreso").toString();
            fechaSalida = request.getParameter("txtFechaSalida").toString();
            
            //No instanciamos un modelo, porque el modelo en este caso es el servicio web
            //Instanciamos el servicio web que contiene los métodos de inserción
            SrvHistorialIngresos_Service historial = new SrvHistorialIngresos_Service();
            
            //Llamada al método del servicio web para insertar la empresa
            //Devuelve un entero (1 = éxito, 0 = error)
            respuesta = historial.getSrvHistorialIngresosPort().insertar(usuario, fechaIngreso, fechaSalida);
            
            //Guardamos la respuesta en un atributo para enviarlo a la vista
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos la respuesta a la vista (nuevoHistorial.jsp)
            rd = request.getRequestDispatcher("nuevoHistorial.jsp");
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
        return "Servlet para insertar nuevos historiales de ingreso";
    }
}