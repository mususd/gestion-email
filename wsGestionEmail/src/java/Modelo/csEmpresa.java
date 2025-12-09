package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class csEmpresa {

    // Inserción de datos con try-with-resources
    public int insertar(String nombre, String direccion, String telefono, String email) {
        int respuesta = 0;
        csConexion c1 = new csConexion();

        String sql = "INSERT INTO empresa(nombre, direccion, telefono, email) VALUES (?, ?, ?, ?)";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, nombre);
            pst.setString(2, direccion);
            pst.setString(3, telefono);
            pst.setString(4, email);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(); // muestra el error en consola
        }

        return respuesta;
    }
    //Actualización de datos
    public int actualizar (String nombre, String direccion, String telefono, String email, int idEmpresa){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "UPDATE empresa SET nombre = ?, direccion = ?, telefono = ?, email = ? WHERE idEmpresa = ?";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, nombre);
            pst.setString(2, direccion);
            pst.setString(3, telefono);
            pst.setString(4, email);
            pst.setInt(5, idEmpresa);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(); // muestra el error en consola
        }
        
        return respuesta;
    }
    //Eliminar datos
    public int eliminar(int idEmpresa){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "DELETE FROM empresa WHERE idEmpresa = ?";
        
        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idEmpresa);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(); // muestra el error en consola
        }
        
        return respuesta;
    }
    // Listar
    public ArrayList<empresa> listarEmpresa() {
        ArrayList<empresa> lista = new ArrayList<>();
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM empresa";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            empresa e = new empresa(
                    rs.getString("nombre"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getInt("idEmpresa")
            );
            lista.add(e);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return lista;
    }
    // Listar por ID
    public empresa listarEmpresaPorID(int idEmpresa) {
        empresa e = null;
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM empresa WHERE idEmpresa = ?";

        try (Connection con = c1.conectar();
        PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, idEmpresa); //Asignar el valor al placeholder

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                e = new empresa(
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getInt("idEmpresa")
                );
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return e;
    }
}