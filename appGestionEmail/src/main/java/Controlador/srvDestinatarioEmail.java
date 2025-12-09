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
 * Servlet encargado de manejar la inserción de nuevos destinatarios de email.
 * Se comunica con el servicio web (SrvDestinatarioEmail_Service) para registrar
 * un Destinatario de Email en la base de datos.
 */
public class srvDestinatarioEmail extends HttpServlet {

    /**
     * Método principal para procesar las peticiones (GET y POST).
     * Obtiene los datos del formulario, llama al servicio web y reenvía la respuesta
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            
            //Declaración de variables para los campos del formulario
            int idBandeja, respuesta;
            String usuarioDestinatario, tipoDestinatario;
            
            //Captura de datos del formulario
            idBandeja = Integer.parseInt(request.getParameter("txtIdBandeja").toString());
            usuarioDestinatario = request.getParameter("txtUsuarioDestinatario").toString();
            tipoDestinatario = request.getParameter("txtTipoDestinatario").toString();
            
            //Instancia al servicio web
            SrvDestinatarioEmail_Service destinatario = new SrvDestinatarioEmail_Service();
            
            //Llamada al método del servicio web para insertar
            respuesta = destinatario.getSrvDestinatarioEmailPort().insertar(idBandeja, usuarioDestinatario, tipoDestinatario);
            
            //Guardamos la respuesta en un atributo para enviarla a la vista
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos la respuesta a la vista (nuevoDestinatario.jsp)
            rd = request.getRequestDispatcher("nuevoDestinatario.jsp");
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
        return "Servlet para insertar nuevos destinatarios";
    }
}