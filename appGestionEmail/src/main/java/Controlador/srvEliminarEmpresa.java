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
 * Servlet encargado de eliminar una empresa existente de la base de datos.
 */
public class srvEliminarEmpresa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            Integer respuesta = 0;
            
            // Capturamos el ID de la empresa a eliminar
            Integer idEmpresa = Integer.parseInt(request.getParameter("txtIdEmpresa"));
            
            // Instanciamos el servicio web
            SrvEmpresa_Service empresa = new SrvEmpresa_Service();
            
            // Llamamos al método de eliminación
            respuesta = empresa.getSrvEmpresaPort().eliminar(idEmpresa);
            
            // Guardamos la respuesta en el request
            request.setAttribute("respuesta", respuesta);
            
            // Redirigimos al mantenimiento para mostrar el mensaje
            rd = request.getRequestDispatcher("mantenimientoEmpresa.jsp");
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
        return "Servlet para eliminar empresas";
    }
}