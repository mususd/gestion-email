package Modelo;

public class DestinatarioEmail {
    private int idDestinatario;
    private int idBandeja;
    private String usuarioDestinatario;
    private String tipoDestinatario;
    
    //Constructor
    public DestinatarioEmail(int idDestinatario, int idBandeja, String usuarioDestinatario, String tipoDestinatario) {
        this.idDestinatario = idDestinatario;
        this.idBandeja = idBandeja;
        this.usuarioDestinatario = usuarioDestinatario;
        this.tipoDestinatario = tipoDestinatario;
    }
    
    //Métodos GET-SET
    public int getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(int idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    public int getIdBandeja() {
        return idBandeja;
    }

    public void setIdBandeja(int idBandeja) {
        this.idBandeja = idBandeja;
    }

    public String getUsuarioDestinatario() {
        return usuarioDestinatario;
    }

    public void setUsuarioDestinatario(String usuarioDestinatario) {
        this.usuarioDestinatario = usuarioDestinatario;
    }

    public String getTipoDestinatario() {
        return tipoDestinatario;
    }

    public void setTipoDestinatario(String tipoDestinatario) {
        this.tipoDestinatario = tipoDestinatario;
    }   
}