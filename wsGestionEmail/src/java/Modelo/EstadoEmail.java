package Modelo;

public class EstadoEmail {
    private int idEstadoEmail;
    private String nombreEstado;
    
    //Constructor
    public EstadoEmail(int idEstadoEmail, String nombreEstado) {
        this.idEstadoEmail = idEstadoEmail;
        this.nombreEstado = nombreEstado;
    }
    
    //Métodos GET-SET
    public int getIdEstadoEmail() {
        return idEstadoEmail;
    }

    public void setIdEstadoEmail(int idEstadoEmail) {
        this.idEstadoEmail = idEstadoEmail;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }   
}