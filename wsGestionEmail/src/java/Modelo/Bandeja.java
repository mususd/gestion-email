package Modelo;

public class Bandeja {
    private int idBandeja;
    private String usuarioRemitente;
    private int idTipoBandeja;
    private int idEstadoEmail;
    private String asunto;
    private String mensaje;
    private String fechaEnvio;
    private String adjunto;
    
    //Constructor
    public Bandeja(int idBandeja, String usuarioRemitente, int idTipoBandeja, int idEstadoEmail, String asunto, String mensaje, String fechaEnvio, String adjunto) {
        this.idBandeja = idBandeja;
        this.usuarioRemitente = usuarioRemitente;
        this.idTipoBandeja = idTipoBandeja;
        this.idEstadoEmail = idEstadoEmail;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.adjunto = adjunto;
    }
    
    //Métodos GET-SET
    public int getIdBandeja() {
        return idBandeja;
    }

    public void setIdBandeja(int idBandeja) {
        this.idBandeja = idBandeja;
    }

    public String getUsuarioRemitente() {
        return usuarioRemitente;
    }

    public void setUsuarioRemitente(String usuarioRemitente) {
        this.usuarioRemitente = usuarioRemitente;
    }

    public int getIdTipoBandeja() {
        return idTipoBandeja;
    }

    public void setIdTipoBandeja(int idTipoBandeja) {
        this.idTipoBandeja = idTipoBandeja;
    }

    public int getIdEstadoEmail() {
        return idEstadoEmail;
    }

    public void setIdEstadoEmail(int idEstadoEmail) {
        this.idEstadoEmail = idEstadoEmail;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }
}