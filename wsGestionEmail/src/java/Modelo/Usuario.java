package Modelo;

public class Usuario {
    private String usuario;
    private int idEmpresa;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String fechaRegistro;
    private String estado;
    
    //Constructor

    public Usuario(String usuario, int idEmpresa, String nombre, String apellido, String email, String contrasena, String fechaRegistro, String estado) {
        this.usuario = usuario;
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }
    
    //Métodos GET-SET
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}