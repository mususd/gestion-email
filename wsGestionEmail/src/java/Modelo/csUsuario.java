package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class csUsuario {
    // Inserción de datos con try-with-resources
    public int insertarUsuario(String usuario, int idEmpresa, String nombre, String apellido, String email, String contrasena, String fechaRegistro, String estado){
        int respuesta = 0;
        csConexion c1 = new csConexion();

        String sql = "INSERT INTO usuario(usuario, idEmpresa, nombre, apellido, email, contrasena, fechaRegistro, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, usuario);
            pst.setInt(2, idEmpresa);
            pst.setString(3, nombre);
            pst.setString(4, apellido);
            pst.setString(5, email);
            pst.setString(6, contrasena);
            pst.setString(7, fechaRegistro);
            pst.setString(8, estado);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(); // muestra el error en consola
        }
        return respuesta;
    }
    
    //Actualización de datos
    public int actualizarUsuario (int idEmpresa, String nombre, String apellido, String email, String contrasena, String fechaRegistro, String estado, String usuario){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "UPDATE usuario SET idEmpresa = ?, nombre = ?, apellido = ?, email = ?, contrasena = ?, fechaRegistro = ?, estado = ? WHERE usuario = ?";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idEmpresa);
            pst.setString(2, nombre);
            pst.setString(3, apellido);
            pst.setString(4, email);
            pst.setString(5, contrasena);
            pst.setString(6, fechaRegistro);
            pst.setString(7, estado);
            pst.setString(8, usuario);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
        System.out.println("Error en la BD: " + ex.getMessage());
        ex.printStackTrace();
        }
        
        return respuesta;
    }
    
    //Eliminar datos
    public int eliminarUsuario(String usuario){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "DELETE FROM usuario WHERE usuario = ?";
        
        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, usuario);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
        System.out.println("Error en la BD: " + ex.getMessage());
        ex.printStackTrace();
        }
        
        return respuesta;
    }
    // Listar
    public ArrayList<Usuario> listarUsuario() {
        ArrayList<Usuario> lista = new ArrayList<>();
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM usuario";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            Usuario u = new Usuario(
                    rs.getString("usuario"),
                    rs.getInt("idEmpresa"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getString("contrasena"),
                    rs.getString("fechaRegistro"),
                    rs.getString("estado")
                    );
            lista.add(u);
        }
    } catch (SQLException ex) {
        System.out.println("Error en la BD: " + ex.getMessage());
        ex.printStackTrace();
        }
    return lista;
    }
    // Listar por ID
    public Usuario listarUsuarioPorID(String usuario) {
        Usuario u = null;
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM usuario WHERE usuario = ?";

        try (Connection con = c1.conectar();
        PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, usuario); //Asignar el valor al placeholder

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                u = new Usuario(
                    rs.getString("usuario"),
                    rs.getInt("idEmpresa"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getString("contrasena"),
                    rs.getString("fechaRegistro"),
                    rs.getString("estado")
                );
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error en la BD: " + ex.getMessage());
        ex.printStackTrace();
        }
    return u;
    }
    // Autenticación de usuario
    public Usuario autenticar(String usuario, String contrasena) {
        Usuario u = null;
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM usuario WHERE usuario = ? AND contrasena = ? AND estado = 'activo'";

        try (Connection con = c1.conectar();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, usuario);
            pst.setString(2, contrasena);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    u = new Usuario(
                        rs.getString("usuario"),
                        rs.getInt("idEmpresa"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("contrasena"),
                        rs.getString("fechaRegistro"),
                        rs.getString("estado")
                    );
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error en la BD: " + ex.getMessage());
            ex.printStackTrace();
        }

        return u;
    }
}