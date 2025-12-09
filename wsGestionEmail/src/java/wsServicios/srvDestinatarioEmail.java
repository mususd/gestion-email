package wsServicios;

import Modelo.DestinatarioEmail;
import Modelo.csDestinatarioEmail;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvDestinatarioEmail")
public class srvDestinatarioEmail {
    @WebMethod(operationName = "insertar")
    public int insertarDestinatarioEmail (@WebParam(name = "idBandeja") int idBandeja, @WebParam(name = "usuarioDestinatario") String usuarioDestinatario,
            @WebParam(name = "tipoDestinatario") String tipoDestinatario){
        csDestinatarioEmail d = new csDestinatarioEmail();
        return d.insertarDestinatarioEmail(idBandeja, usuarioDestinatario, tipoDestinatario);
    }
    
    @WebMethod(operationName = "actualizacion")
    public int actualizarDestinatarioEmail (@WebParam(name = "idDestinatario") int idDestinatario, @WebParam(name = "idBandeja") int idBandeja,
            @WebParam(name = "usuarioDestinatario") String usuarioDestinatario, @WebParam(name = "tipoDestinatario") String tipoDestinatario){
        csDestinatarioEmail d = new csDestinatarioEmail();
        return d.actualizarDestinatarioEmail(idDestinatario, idBandeja, usuarioDestinatario, tipoDestinatario);
    }
    
    @WebMethod(operationName = "eliminar")
    public int eliminarDestinatarioEmail(@WebParam(name = "idDestinatario") int idDestinatario){
        csDestinatarioEmail d = new csDestinatarioEmail();
        return d.eliminarDestinatarioEmail(idDestinatario);
    }
    
    @WebMethod(operationName = "listar")
    public ArrayList <DestinatarioEmail> listarDestinatarioEmail() {
        csDestinatarioEmail d = new csDestinatarioEmail();
        return d.listarDestinatarioEmail();
    }
    
    @WebMethod(operationName = "listarPorID")
    public DestinatarioEmail listarDestinatarioEmailPorID(@WebParam(name = "idDestinatario") int idDestinatario){
        csDestinatarioEmail d = new csDestinatarioEmail();
        return d.listarDestinatarioEmailPorID(idDestinatario);
    }
}