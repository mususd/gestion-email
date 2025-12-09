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
 * Servlet encargado de manejar la inserción de nuevas bandejas.
 * Se comunica con el servicio web (SrvBandeja_Service) para registrar
 * una bandeja en la base de datos.
 */
public class srvBandeja extends HttpServlet {

    /**
     * Método principal para procesar las peticiones (GET y POST).
     * Obtiene los datos del formulario, llama al servicio web y reenvía la respuesta.
    */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            
            //Declaración de variables para los campos del formulario
            String usuarioRemitente, asunto, mensaje, fechaEnvio, adjunto;
            int idTipoBandeja, idEstadoEmail, respuesta;
            
            //Captura de datos del formulario
            usuarioRemitente = request.getParameter("txtUsuarioRemitente").toString();
            idTipoBandeja = Integer.parseInt(request.getParameter("txtIdTipoBandeja").toString());
            idEstadoEmail = Integer.parseInt(request.getParameter("txtIdEstadoEmail").toString());
            asunto = request.getParameter("txtAsunto").toString();
            mensaje = request.getParameter("txtMensaje").toString();
            fechaEnvio = request.getParameter("txtFechaEnvio").toString();
            adjunto = request.getParameter("txtAdjunto").toString();
            
            //No instanciamos un modelo, porque el modelo en este caso es el servicio web
            //Instanciamos el servicio web que contiene el método de inserción
            SrvBandeja_Service bandeja = new SrvBandeja_Service();
            
            //Llamada al método del servicio web para insertar una bandeja
            //Devuelve un entero (1 = éxito, 0 = error)
            respuesta = bandeja.getSrvBandejaPort().insertar(usuarioRemitente, idTipoBandeja, idEstadoEmail, asunto, mensaje, fechaEnvio, adjunto);
            
            //Guardamos la respuesta en un atributo para enviarla a la vista
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos la respuesta a la vista (nuevaBandeja.jsp)
            rd = request.getRequestDispatcher("nuevaBandeja.jsp");
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
        return "Servlet para insertar nuevas bandejas";
    }
}