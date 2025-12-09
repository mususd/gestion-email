package wsServicios;

import Modelo.csUsuario;
import Modelo.Usuario;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvUsuario")
public class srvUsuario {

    @WebMethod(operationName = "insertar")
    public int insertarUsuario(@WebParam(name = "usuario") String usuario, @WebParam(name = "idEmpresa") int idEmpresa, @WebParam(name = "nombre") String nombre,
            @WebParam(name = "apellido") String apellido, @WebParam(name = "email") String email, @WebParam(name = "contrasena") String contrasena, 
            @WebParam(name = "fechaRegistro") String fechaRegistro, @WebParam(name = "estado") String estado){
        csUsuario u = new csUsuario();
        return u.insertarUsuario(usuario, idEmpresa, nombre, apellido, email, contrasena, fechaRegistro, estado);
    }
    
    @WebMethod(operationName = "actualizacion")
    public int actualizarUsuario (@WebParam(name = "idEmpresa") int idEmpresa, @WebParam(name = "nombre") String nombre,
            @WebParam(name = "apellido") String apellido, @WebParam(name = "email") String email, @WebParam(name = "contrasena") String contrasena, 
            @WebParam(name = "fechaRegistro") String fechaRegistro, @WebParam(name = "estado") String estado, @WebParam(name = "usuario") String usuario){
        csUsuario u = new csUsuario();
        return u.actualizarUsuario(idEmpresa, nombre, apellido, email, contrasena, fechaRegistro, estado, usuario);
    }
    
    @WebMethod(operationName = "eliminar")
    public int eliminarUsuario(@WebParam(name = "usuario") String usuario){
        csUsuario u = new csUsuario();
        return u.eliminarUsuario(usuario);
    }
    
    @WebMethod(operationName = "listar")
    public ArrayList <Usuario> listarUsuario() {
        csUsuario u = new csUsuario();
        return u.listarUsuario();
    }
    
    @WebMethod(operationName = "listarPorID")
    public Usuario listarUsuarioPorID(@WebParam(name = "usuario") String usuario){
        csUsuario u = new csUsuario();
        return u.listarUsuarioPorID(usuario);
    }
    
    @WebMethod(operationName = "autenticar")
    public Usuario autenticar(@WebParam(name = "usuario") String usuario, @WebParam(name = "contrasena") String contrasena){
        csUsuario u = new csUsuario();
        return u.autenticar(usuario, contrasena);
    }
}