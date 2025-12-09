package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class csDestinatarioEmail {
    // Inserción de datos con try-with-resources
    public int insertarDestinatarioEmail(int idBandeja, String usuarioDestinatario, String tipoDestinatario){
        int respuesta = 0;
        csConexion c1 = new csConexion();

        String sql = "INSERT INTO DestinatarioEmail(idBandeja, usuarioDestinatario, tipoDestinatario) VALUES (?, ?, ?)";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idBandeja);
            pst.setString(2, usuarioDestinatario);
            pst.setString(3, tipoDestinatario);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(); // muestra el error en consola
        }
        return respuesta;
    }
    
    // Actualización de datos
    public int actualizarDestinatarioEmail(int idDestinatario, int idBandeja, String usuarioDestinatario, String tipoDestinatario) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "UPDATE DestinatarioEmail SET idBandeja = ?, usuarioDestinatario = ?, tipoDestinatario = ? WHERE idDestinatario = ?";

        try (Connection con = c1.conectar();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idBandeja);
            pst.setString(2, usuarioDestinatario);
            pst.setString(3, tipoDestinatario);
            pst.setInt(4, idDestinatario);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en la BD: " + ex.getMessage());
            ex.printStackTrace();
        }
        return respuesta;
}
    
    //Eliminar datos
    public int eliminarDestinatarioEmail(int idDestinatario){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "DELETE FROM DestinatarioEmail WHERE idDestinatario = ?";
        
        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idDestinatario);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
        System.out.println("Error en la BD: " + ex.getMessage());
        ex.printStackTrace();
        }
        
        return respuesta;
    }
    // Listar
    public ArrayList<DestinatarioEmail> listarDestinatarioEmail() {
        ArrayList<DestinatarioEmail> lista = new ArrayList<>();
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM DestinatarioEmail";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            DestinatarioEmail d = new DestinatarioEmail(
                    rs.getInt("idDestinatario"),
                    rs.getInt("idBandeja"),
                    rs.getString("usuarioDestinatario"),
                    rs.getString("tipoDestinatario")
                    );
            lista.add(d);
        }
    } catch (SQLException ex) {
        System.out.println("Error en la BD: " + ex.getMessage());
        ex.printStackTrace();
        }
    return lista;
    }
    // Listar por ID
    public DestinatarioEmail listarDestinatarioEmailPorID(int idDestinatario) {
        DestinatarioEmail d = null;
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM DestinatarioEmail WHERE idDestinatario = ?";

        try (Connection con = c1.conectar();
        PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, idDestinatario); //Asignar el valor al placeholder

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                d = new DestinatarioEmail(
                    rs.getInt("idDestinatario"),
                    rs.getInt("idBandeja"),
                    rs.getString("usuarioDestinatario"),
                    rs.getString("tipoDestinatario")
                );
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error en la BD: " + ex.getMessage());
        ex.printStackTrace();
        }
    return d;
    }
}