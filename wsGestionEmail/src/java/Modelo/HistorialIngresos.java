package Modelo;

public class HistorialIngresos {
    private int idHistorial;
    private String usuario;
    private String fechaIngreso;
    private String fechaSalida;
    
    //Constructor
    public HistorialIngresos(int idHistorial, String usuario, String fechaIngreso, String fechaSalida) {
        this.idHistorial = idHistorial;
        this.usuario = usuario;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }
    
    //Métodos GET-SET
    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }   
}