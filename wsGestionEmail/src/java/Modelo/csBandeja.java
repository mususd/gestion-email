package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class csBandeja {
    // Inserción de datos con try-with-resources
    public int insertarBandeja(String usuarioRemitente, int idTipoBandeja, int idEstadoEmail, String asunto, String mensaje, String fechaEnvio,
            String adjunto){
        int respuesta = 0;
        csConexion c1 = new csConexion();

        String sql = "INSERT INTO Bandeja(usuarioRemitente, idTipoBandeja, idEstadoEmail, asunto, mensaje, fechaEnvio, adjunto) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, usuarioRemitente);
            pst.setInt(2, idTipoBandeja);
            pst.setInt(3, idEstadoEmail);
            pst.setString(4, asunto);
            pst.setString(5, mensaje);
            pst.setString(6, fechaEnvio);
            pst.setString(7, adjunto);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(); // muestra el error en consola
        }
        return respuesta;
    }
    
    // Actualización de datos
    public int actualizarBandeja(int idBandeja, String usuarioRemitente, int idTipoBandeja, int idEstadoEmail, 
            String asunto, String mensaje, String fechaEnvio, String adjunto) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "UPDATE Bandeja SET usuarioRemitente = ?, idTipoBandeja = ?, idEstadoEmail = ?, " +
                     "asunto = ?, mensaje = ?, fechaEnvio = ?, adjunto = ? WHERE idBandeja = ?";

        try (Connection con = c1.conectar();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, usuarioRemitente);
            pst.setInt(2, idTipoBandeja);
            pst.setInt(3, idEstadoEmail);
            pst.setString(4, asunto);
            pst.setString(5, mensaje);
            pst.setString(6, fechaEnvio);
            pst.setString(7, adjunto);
            pst.setInt(8, idBandeja);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en la BD: " + ex.getMessage());
            ex.printStackTrace();
        }
        return respuesta;
}
    
    //Eliminar datos
    public int eliminarBandeja(int idBandeja){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "DELETE FROM Bandeja WHERE idBandeja = ?";
        
        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idBandeja);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(); // muestra el error en consola
        }
        
        return respuesta;
    }
    // Listar
    public ArrayList<Bandeja> listarBandeja() {
        ArrayList<Bandeja> lista = new ArrayList<>();
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM Bandeja";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            Bandeja cb = new Bandeja(
                    rs.getInt("idBandeja"),
                    rs.getString("usuarioRemitente"),
                    rs.getInt("idTipoBandeja"),
                    rs.getInt("idEstadoEmail"),
                    rs.getString("asunto"),
                    rs.getString("mensaje"),
                    rs.getString("fechaEnvio"),
                    rs.getString("adjunto")
                    );
            lista.add(cb);
        }
    } catch (SQLException ex) {
        System.out.println("Error en la BD: " + ex.getMessage());
        ex.printStackTrace();
        }
    return lista;
    }
    // Listar por ID
    public Bandeja listarBandejaPorID(int idBandeja) {
        Bandeja cb = null;
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM Bandeja WHERE idBandeja = ?";

        try (Connection con = c1.conectar();
        PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, idBandeja); //Asignar el valor al placeholder

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                cb = new Bandeja(
                    rs.getInt("idBandeja"),
                    rs.getString("usuarioRemitente"),
                    rs.getInt("idTipoBandeja"),
                    rs.getInt("idEstadoEmail"),
                    rs.getString("asunto"),
                    rs.getString("mensaje"),
                    rs.getString("fechaEnvio"),
                    rs.getString("adjunto")
                );
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error en la BD: " + ex.getMessage());
        ex.printStackTrace();
        }
    return cb;
    }
}