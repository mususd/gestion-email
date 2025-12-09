package wsServicios;

import Modelo.csEstadoEmail;
import Modelo.EstadoEmail;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvEstadoEmail")
public class srvEstadoEmail {

    @WebMethod(operationName = "insertar")
    public int insertarEstadoEmail(@WebParam(name = "nombreEstado") String nombreEstado) {
        csEstadoEmail es = new csEstadoEmail();
        return es.insertarEstadoEmail(nombreEstado);
    }
    
    @WebMethod(operationName = "actualizacion")
    public int actualizarEstadoEmail (@WebParam(name = "nombreEstado") String nombreEstado, @WebParam(name = "idEstadoEmail") int idEstadoEmail){
        csEstadoEmail es = new csEstadoEmail();
        return es.actualizarEstadoEmail(nombreEstado, idEstadoEmail);
    }
    
    @WebMethod(operationName = "eliminar")
    public int eliminarEstadoEmail(@WebParam(name = "idEstadoEmail") int idEstadoEmail){
        csEstadoEmail es = new csEstadoEmail();
        return es.eliminarEstadoEmail(idEstadoEmail);
    }
    
    @WebMethod(operationName = "listar")
    public ArrayList <EstadoEmail> listarEstadoEmail() {
        csEstadoEmail es = new csEstadoEmail();
        return es.listarEstadoEmail();
    }
    
    @WebMethod(operationName = "listarPorID")
    public EstadoEmail listarEstadoEmailPorID(@WebParam(name = "idEstadoEmail") int idEstadoEmail){
        csEstadoEmail es = new csEstadoEmail();
        return es.listarEstadoEmailPorID(idEstadoEmail);
    }
}
