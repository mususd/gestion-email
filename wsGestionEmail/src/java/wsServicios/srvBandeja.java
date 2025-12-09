package wsServicios;

import Modelo.Bandeja;
import Modelo.csBandeja;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvBandeja")
public class srvBandeja {
    @WebMethod(operationName = "insertar")
    public int insertarBandeja (@WebParam(name = "usuarioRemitente") String usuarioRemitente, @WebParam(name = "idTipoBandeja") int idTipoBandeja,
            @WebParam(name = "idEstadoEmail") int idEstadoEmail, @WebParam(name = "asunto") String asunto, @WebParam (name = "mensaje") String mensaje,
            @WebParam(name = "fechaEnvio") String fechaEnvio, @WebParam(name = "adjunto") String adjunto){
        csBandeja cb = new csBandeja();
        return cb.insertarBandeja(usuarioRemitente, idTipoBandeja, idEstadoEmail, asunto, mensaje, fechaEnvio, adjunto);
    }
    
    @WebMethod(operationName = "actualizacion")
    public int actualizarBandeja (@WebParam(name = "idBandeja") int idBandeja, @WebParam(name = "usuarioRemitente") String usuarioRemitente, @WebParam(name = "idTipoBandeja") int idTipoBandeja,
            @WebParam(name = "idEstadoEmail") int idEstadoEmail, @WebParam(name = "asunto") String asunto, @WebParam (name = "mensaje") String mensaje,
            @WebParam(name = "fechaEnvio") String fechaEnvio, @WebParam(name = "adjunto") String adjunto){
        csBandeja cb = new csBandeja();
        return cb.actualizarBandeja(idBandeja, usuarioRemitente, idTipoBandeja, idEstadoEmail, asunto, mensaje, fechaEnvio, adjunto);
    }
    
    @WebMethod(operationName = "eliminar")
    public int eliminarBandeja(@WebParam(name = "idBandeja") int idBandeja){
        csBandeja cb = new csBandeja();
        return cb.eliminarBandeja(idBandeja);
    }
    
    @WebMethod(operationName = "listar")
    public ArrayList <Bandeja> listarBandeja() {
        csBandeja cb = new csBandeja();
        return cb.listarBandeja();
    }
    
    @WebMethod(operationName = "listarPorID")
    public Bandeja listarBandejaPorID(@WebParam(name = "idBandeja") int idBandeja){
        csBandeja cb = new csBandeja();
        return cb.listarBandejaPorID(idBandeja);
    }
}