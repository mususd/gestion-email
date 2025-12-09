package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class csTipoBandeja {
    // Inserción de datos con try-with-resources
    public int insertarTipoBandeja(String nombreTipo) {
        int respuesta = 0;
        csConexion c1 = new csConexion();

        String sql = "INSERT INTO TipoBandeja(nombreTipo) VALUES (?)";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, nombreTipo);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(); // muestra el error en consola
        }
        return respuesta;
    }
    
    //Actualización de datos
    public int actualizarTipoBandeja (String nombreTipo, int idTipoBandeja){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "UPDATE TipoBandeja SET nombreTipo = ? WHERE idTipoBandeja = ?";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, nombreTipo);
            pst.setInt(2, idTipoBandeja);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(); // muestra el error en consola
        }
        
        return respuesta;
    }
    
    //Eliminar datos
    public int eliminarTipoBandeja(int idTipoBandeja){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "DELETE FROM TipoBandeja WHERE idTipoBandeja = ?";
        
        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idTipoBandeja);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(); // muestra el error en consola
        }
        
        return respuesta;
    }
    // Listar
    public ArrayList<TipoBandeja> listarTipoBandeja() {
        ArrayList<TipoBandeja> lista = new ArrayList<>();
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM TipoBandeja";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            TipoBandeja b = new TipoBandeja(
                    rs.getInt("idTipoBandeja"),
                    rs.getString("nombreTipo")
                    );
            lista.add(b);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return lista;
    }
    // Listar por ID
    public TipoBandeja listarTipoBandejaPorID(int idTipoBandeja) {
        TipoBandeja b = null;
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM TipoBandeja WHERE idTipoBandeja = ?";

        try (Connection con = c1.conectar();
        PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, idTipoBandeja); //Asignar el valor al placeholder

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                b = new TipoBandeja(
                    rs.getInt("idTipoBandeja"),
                    rs.getString("nombreTipo")
                );
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return b;
    }
}