package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class csHistorialIngresos {
    // Inserción de datos con try-with-resources
    public int insertarHistorialIngresos(String usuario, String fechaIngreso, String fechaSalida){
        int respuesta = 0;
        csConexion c1 = new csConexion();

        String sql = "INSERT INTO HistorialIngresos(usuario, fechaIngreso, fechaSalida) VALUES (?, ?, ?)";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, usuario);
            pst.setString(2, fechaIngreso);
            pst.setString(3, fechaSalida);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(); // muestra el error en consola
        }
        return respuesta;
    }
    
    // Actualización de datos
    public int actualizarHistorialIngresos(int idHistorial, String usuario, String fechaIngreso, String fechaSalida) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "UPDATE HistorialIngresos SET usuario = ?, fechaIngreso = ?, fechaSalida = ? WHERE idHistorial = ?";

        try (Connection con = c1.conectar();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, usuario);
            pst.setString(2, fechaIngreso);
            pst.setString(3, fechaSalida);
            pst.setInt(4, idHistorial);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en la BD: " + ex.getMessage());
            ex.printStackTrace();
        }
        return respuesta;
}
    
    //Eliminar datos
    public int eliminarHistorialIngresos(int idHistorial){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "DELETE FROM HistorialIngresos WHERE idHistorial = ?";
        
        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idHistorial);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
        System.out.println("Error en la BD: " + ex.getMessage());
        ex.printStackTrace();
        }
        
        return respuesta;
    }
    // Listar
    public ArrayList<HistorialIngresos> listarHistorialIngresos() {
        ArrayList<HistorialIngresos> lista = new ArrayList<>();
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM HistorialIngresos";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            HistorialIngresos h = new HistorialIngresos(
                    rs.getInt("idHistorial"),
                    rs.getString("usuario"),
                    rs.getString("fechaIngreso"),
                    rs.getString("fechaSalida")
                    );
            lista.add(h);
        }
    } catch (SQLException ex) {
        System.out.println("Error en la BD: " + ex.getMessage());
        ex.printStackTrace();
        }
    return lista;
    }
    // Listar por ID
    public HistorialIngresos listarHistorialIngresosPorID(int idHistorial) {
        HistorialIngresos h = null;
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM HistorialIngresos WHERE idHistorial = ?";

        try (Connection con = c1.conectar();
        PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, idHistorial); //Asignar el valor al placeholder

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                h = new HistorialIngresos(
                    rs.getInt("idHistorial"),
                    rs.getString("usuario"),
                    rs.getString("fechaIngreso"),
                    rs.getString("fechaSalida")
                );
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error en la BD: " + ex.getMessage());
        ex.printStackTrace();
        }
    return h;
    }
}
