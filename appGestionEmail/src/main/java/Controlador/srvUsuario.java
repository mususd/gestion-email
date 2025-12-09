package Controlador;

import Modelo.usuario.SrvUsuario_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de manejar la inserción de nuevos usuarios.
 * Se comunica con el servicio web (SrvUsuario_Service) para registrar
 * un usuario en la base de datos
 */

public class srvUsuario extends HttpServlet {

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
            String usuario, nombre, apellido, email, contrasena, fechaRegistro, estado;
            int idEmpresa, respuesta;
            
            //Captura de datos del formulario
            usuario = request.getParameter("txtUsuario").toString();
            idEmpresa = Integer.parseInt(request.getParameter("txtIdEmpresa").toString());
            nombre = request.getParameter("txtNombre").toString();
            apellido = request.getParameter("txtApellido").toString();
            email = request.getParameter("txtEmail").toString();
            contrasena = request.getParameter("txtContrasena").toString();
            fechaRegistro = request.getParameter("txtFechaRegistro").toString();
            estado = request.getParameter("txtEstado").toString();
            
            //No instanciamos un modelo, porque el modelo en este caso es el servicio web
            //Instanciamos el servicio web que contiene los métodos de inserción
            SrvUsuario_Service user = new SrvUsuario_Service();
            
            //Llamada al método del servicio web para instear al usuario
            //Devuelve un entero (1 = éxito, 0 = error)
            respuesta = user.getSrvUsuarioPort().insertar(usuario, idEmpresa, nombre, apellido, email, contrasena, fechaRegistro, estado);
            
            //Guardamos la respuesta en un atributo para enviarla a la vista
            request.setAttribute("respuesta", respuesta);
            
            //Redirigimos la respuesta a la vista (nuevoUsuario.jsp)
            rd = request.getRequestDispatcher("nuevoUsuario.jsp");
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
        return "Servlet para insertar nuevos usuarios";
    }
}