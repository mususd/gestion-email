package Modelo;

public class RecuperarContrasena {
    private int idRecuperacion;
    private String usuario;
    private String fechaSolicitud;
    private String codigoRecuperacion;
    private String estadoSolicitud;
    
    //Constructor
    public RecuperarContrasena(int idRecuperacion, String usuario, String fechaSolicitud, String codigoRecuperacion, String estadoSolicitud) {
        this.idRecuperacion = idRecuperacion;
        this.usuario = usuario;
        this.fechaSolicitud = fechaSolicitud;
        this.codigoRecuperacion = codigoRecuperacion;
        this.estadoSolicitud = estadoSolicitud;
    }
    
    //Métodos GET-SET
    public int getIdRecuperacion() {
        return idRecuperacion;
    }

    public void setIdRecuperacion(int idRecuperacion) {
        this.idRecuperacion = idRecuperacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getCodigoRecuperacion() {
        return codigoRecuperacion;
    }

    public void setCodigoRecuperacion(String codigoRecuperacion) {
        this.codigoRecuperacion = codigoRecuperacion;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }
}