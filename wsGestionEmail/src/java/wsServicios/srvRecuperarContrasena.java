package wsServicios;

import Modelo.csRecuperarContrasena;
import Modelo.RecuperarContrasena;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvRecuperarContrasena")
public class srvRecuperarContrasena {
    @WebMethod(operationName = "insertar")
    public int insertarRecuperarContrasena (@WebParam(name = "usuario") String usuario, @WebParam(name = "fechaSolicitud") String fechaSolicitud,
            @WebParam(name = "codigoRecuperacion") String codigoRecuperacion, @WebParam(name = "estadoSolicitud") String estadoSolicitud){
        csRecuperarContrasena rc = new csRecuperarContrasena();
        return rc.insertarRecuperarContrasena(usuario, fechaSolicitud, codigoRecuperacion, estadoSolicitud);
    }
    
    @WebMethod(operationName = "actualizacion")
    public int actualizarRecuperarContrasena (@WebParam(name = "idRecuperacion") int idRecuperacion, @WebParam(name = "usuario") String usuario,
            @WebParam(name = "fechaSolicitud") String fechaSolicitud,
            @WebParam(name = "codigoRecuperacion") String codigoRecuperacion, @WebParam(name = "estadoSolicitud") String estadoSolicitud){
        System.out.println("[WS srvRecuperarContrasena] actualizacion llamada con -> id:" + idRecuperacion + ", usuario:" + usuario + ", fecha:" + fechaSolicitud + ", codigo:" + codigoRecuperacion + ", estado:" + estadoSolicitud);
        csRecuperarContrasena rc = new csRecuperarContrasena();
        int resultado = rc.actualizarRecuperarContrasena(idRecuperacion, usuario, fechaSolicitud, codigoRecuperacion, estadoSolicitud);
        System.out.println("[WS srvRecuperarContrasena] resultado actualizacion: " + resultado);
        return resultado;
    }
    
    @WebMethod(operationName = "eliminar")
    public int eliminarRecuperarContrasena(@WebParam(name = "idRecuperacion") int idRecuperacion){
        csRecuperarContrasena rc = new csRecuperarContrasena();
        return rc.eliminarRecuperarContrasena(idRecuperacion);
    }
    
    @WebMethod(operationName = "listar")
    public ArrayList <RecuperarContrasena> listarRecuperarContrasena() {
        csRecuperarContrasena rc = new csRecuperarContrasena();
        return rc.listarRecuperarContrasena();
    }
    
    @WebMethod(operationName = "listarPorID")
    public RecuperarContrasena listarRecuperarContrasenaPorID(@WebParam(name = "idRecuperacion") int idRecuperacion){
        csRecuperarContrasena rc = new csRecuperarContrasena();
        return rc.listarRecuperarContrasenaPorID(idRecuperacion);
    }
}
