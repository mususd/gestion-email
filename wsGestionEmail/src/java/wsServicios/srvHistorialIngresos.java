package wsServicios;

import Modelo.HistorialIngresos;
import Modelo.csHistorialIngresos;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvHistorialIngresos")
public class srvHistorialIngresos {
    @WebMethod(operationName = "insertar")
    public int insertarHistorialIngresos (@WebParam(name = "usuario") String usuario, @WebParam(name = "fechaIngreso") String fechaIngreso,
            @WebParam(name = "fechaSalida") String fechaSalida){
        csHistorialIngresos h = new csHistorialIngresos();
        return h.insertarHistorialIngresos(usuario, fechaIngreso, fechaSalida);
    }
    
    @WebMethod(operationName = "actualizacion")
    public int actualizarHistorialIngresos (@WebParam(name = "idHistorial") int idHistorial, @WebParam(name = "usuario") String usuario, 
            @WebParam(name = "fechaIngreso") String fechaIngreso, @WebParam(name = "fechaSalida") String fechaSalida){
        csHistorialIngresos h = new csHistorialIngresos();
        return h.actualizarHistorialIngresos(idHistorial, usuario, fechaIngreso, fechaSalida);
    }
    
    @WebMethod(operationName = "eliminar")
    public int eliminarHistorialIngresos(@WebParam(name = "idHistorial") int idHistorial){
        csHistorialIngresos h = new csHistorialIngresos();
        return h.eliminarHistorialIngresos(idHistorial);
    }
    
    @WebMethod(operationName = "listar")
    public ArrayList <HistorialIngresos> listarHistorialIngresos() {
        csHistorialIngresos h = new csHistorialIngresos();
        return h.listarHistorialIngresos();
    }
    
    @WebMethod(operationName = "listarPorID")
    public HistorialIngresos listarHistorialIngresosPorID(@WebParam(name = "idHistorial") int idHistorial){
        csHistorialIngresos h = new csHistorialIngresos();
        return h.listarHistorialIngresosPorID(idHistorial);
    }
}