package Modelo;

public class TipoBandeja {
    private int idTipoBandeja;
    private String nombreTipo;
    
    //Constructor
    public TipoBandeja(int idTipoBandeja, String nombreTipo) {
        this.idTipoBandeja = idTipoBandeja;
        this.nombreTipo = nombreTipo;
    }
    
    //Métodos GET-SET
    public int getIdTipoBandeja() {
        return idTipoBandeja;
    }

    public void setIdTipoBandeja(int idTipoBandeja) {
        this.idTipoBandeja = idTipoBandeja;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }   
}