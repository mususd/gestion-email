package wsServicios;

import Modelo.csTipoBandeja;
import Modelo.TipoBandeja;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvTipoBandeja")
public class srvTipoBandeja {

    @WebMethod(operationName = "insertar")
    public int insertarTipoBandeja(@WebParam(name = "nombreTipo") String nombreTipo) {
        csTipoBandeja b = new csTipoBandeja();
        return b.insertarTipoBandeja(nombreTipo);
    }
    
    @WebMethod(operationName = "actualizacion")
    public int actualizarTipoBandeja(@WebParam(name = "nombreTipo") String nombreTipo, @WebParam(name = "idTipoBandeja") int idTipoBandeja){
        csTipoBandeja b = new csTipoBandeja();
        return b.actualizarTipoBandeja(nombreTipo, idTipoBandeja);
    }
    
    @WebMethod(operationName = "eliminar")
    public int eliminarTipoBandeja(@WebParam(name = "idTipoBandeja") int idTipoBandeja){
        csTipoBandeja b = new csTipoBandeja();
        return b.eliminarTipoBandeja(idTipoBandeja);
    }
    
    @WebMethod(operationName = "listar")
    public ArrayList <TipoBandeja> listarTipoBandeja() {
        csTipoBandeja b = new csTipoBandeja();
        return b.listarTipoBandeja();
    }
    
    @WebMethod(operationName = "listarPorID")
    public TipoBandeja listarTipoBandejaPorID(@WebParam(name = "idTipoBandeja") int idTipoBandeja){
        csTipoBandeja b = new csTipoBandeja();
        return b.listarTipoBandejaPorID(idTipoBandeja);
    }
}