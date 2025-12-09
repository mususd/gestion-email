package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class csEstadoEmail {
    // Inserción de datos con try-with-resources
    public int insertarEstadoEmail(String nombreEstado) {
        int respuesta = 0;
        csConexion c1 = new csConexion();

        String sql = "INSERT INTO EstadoEmail(nombreEstado) VALUES (?)";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, nombreEstado);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(); // muestra el error en consola
        }
        return respuesta;
    }
    
    //Actualización de datos
    public int actualizarEstadoEmail (String nombreEstado, int idEstadoEmail){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "UPDATE EstadoEmail SET nombreEstado = ? WHERE idEstadoEmail = ?";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, nombreEstado);
            pst.setInt(2, idEstadoEmail);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(); // muestra el error en consola
        }
        
        return respuesta;
    }
    
    //Eliminar datos
    public int eliminarEstadoEmail(int idEstadoEmail){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "DELETE FROM EstadoEmail WHERE idEstadoEmail = ?";
        
        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idEstadoEmail);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(); // muestra el error en consola
        }
        
        return respuesta;
    }
    // Listar
    public ArrayList<EstadoEmail> listarEstadoEmail() {
        ArrayList<EstadoEmail> lista = new ArrayList<>();
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM EstadoEmail";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            EstadoEmail es = new EstadoEmail(
                    rs.getInt("idEstadoEmail"),
                    rs.getString("nombreEstado")
                    );
            lista.add(es);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return lista;
    }
    // Listar por ID
    public EstadoEmail listarEstadoEmailPorID(int idEstadoEmail) {
        EstadoEmail es = null;
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM EstadoEmail WHERE idEstadoEmail = ?";

        try (Connection con = c1.conectar();
        PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, idEstadoEmail); //Asignar el valor al placeholder

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                es = new EstadoEmail(
                    rs.getInt("idEstadoEmail"),
                    rs.getString("nombreEstado")
                );
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return es;
    }
}