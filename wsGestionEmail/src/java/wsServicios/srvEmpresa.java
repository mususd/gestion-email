package wsServicios;

import Modelo.csEmpresa;
import Modelo.empresa;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvEmpresa")
public class srvEmpresa {

    /**
     * This is a sample web service operation
     * MODELO, VISTA, CONTROLADOR MVC
     */
    @WebMethod(operationName = "insertar")
    public int insertar(@WebParam(name = "nombre") String nombre, @WebParam(name = "direccion") String direccion, 
            @WebParam(name = "telefono") String telefono, @WebParam(name = "email") String email) {
        csEmpresa e = new csEmpresa();
        return e.insertar(nombre, direccion, telefono, email);
    }
    
    @WebMethod(operationName = "actualizacion")
    public int actualizar(@WebParam(name = "nombre") String nombre, @WebParam(name = "direccion") String direccion, 
            @WebParam(name = "telefono") String telefono, @WebParam(name = "email") String email, @WebParam(name = "idEmpresa") int idEmpresa){
        csEmpresa e = new csEmpresa();
        return e.actualizar(nombre, direccion, telefono, email, idEmpresa);
    }
    
    @WebMethod(operationName = "eliminar")
    public int eliminar(@WebParam(name = "idEmpresa") int idEmpresa){
        csEmpresa e = new csEmpresa();
        return e.eliminar(idEmpresa);
    }
    
    @WebMethod(operationName = "listar")
    public ArrayList <empresa> listar() {
        csEmpresa e = new csEmpresa();
        return e.listarEmpresa();
    }
    
    @WebMethod(operationName = "listarPorID")
    public empresa listarPorID(@WebParam(name = "idEmpresa") int idEmpresa){
        csEmpresa e = new csEmpresa();
        return e.listarEmpresaPorID(idEmpresa);
    }
}