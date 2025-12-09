package Controlador;

import Modelo.empresa.SrvEmpresa_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de actualizar la información de una empresa existente.
 */
public class srvActualizarEmpresa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            RequestDispatcher rd = null;
            Integer respuesta = 0;
            
            // Captura de parámetros enviados desde el formulario
            String nombre = request.getParameter("txtNombre").toString();
            String direccion = request.getParameter("txtDireccion").toString();
            String telefono = request.getParameter("txtTelefono").toString();
            String email = request.getParameter("txtEmail").toString();
            int idEmpresa = Integer.parseInt(request.getParameter("txtIdEmpresa").toString());
            
            // Instancia del servicio web
            SrvEmpresa_Service empresa = new SrvEmpresa_Service();
            
            // Llamada al método de actualización
            respuesta = empresa.getSrvEmpresaPort().actualizacion(nombre, direccion, telefono, email, idEmpresa);
            
            // Guardamos la respuesta en el request
            request.setAttribute("respuesta", respuesta);
            
            // Redirigimos nuevamente al formulario de actualización con el mismo ID
            rd = request.getRequestDispatcher("actualizarEmpresa.jsp?id=" + idEmpresa);
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