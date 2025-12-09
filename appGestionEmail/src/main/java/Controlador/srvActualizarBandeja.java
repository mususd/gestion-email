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
 * Servlet encargado de actualizar la información de una bandeja existente.
 */
public class srvActualizarBandeja extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            Integer respuesta = 0;
            
            //Captura de parámetros enviados desde el formulario
            int idBandeja = Integer.parseInt(request.getParameter("txtIdBandeja").toString());
            String usuarioRemitente = request.getParameter("txtUsuarioRemitente").toString();
            int idTipoBandeja = Integer.parseInt(request.getParameter("txtIdTipoBandeja").toString());
            int idEstadoEmail = Integer.parseInt(request.getParameter("txtIdEstadoEmail").toString());
            String asunto = request.getParameter("txtAsunto").toString();
            String mensaje = request.getParameter("txtMensaje").toString();
            String fechaEnvio = request.getParameter("txtFechaEnvio").toString();
            String adjunto = request.getParameter("txtAdjunto").toString();
            
            //Instancia del servicio web
            SrvBandeja_Service bandeja = new SrvBandeja_Service();
            
            //Llamada al método de actualización
            respuesta = bandeja.getSrvBandejaPort().actualizacion(idBandeja, usuarioRemitente, idTipoBandeja, idEstadoEmail, asunto, mensaje, fechaEnvio, adjunto);
            
            //Guardamos la respuesta en el request
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos nuevamente al formulario de actualización con el mismo ID
            rd = request.getRequestDispatcher("actualizarBandeja.jsp?id=" + idBandeja);
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
        return "Servlet para actualizar bandejas";
    }
}