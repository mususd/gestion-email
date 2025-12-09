package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class csRecuperarContrasena {
    // Inserción de datos con try-with-resources
    public int insertarRecuperarContrasena(String usuario, String fechaSolicitud, String codigoRecuperacion, String estadoSolicitud){
        int respuesta = 0;
        csConexion c1 = new csConexion();

        String sql = "INSERT INTO RecuperarContrasena(usuario, fechaSolicitud, codigoRecuperacion, estadoSolicitud) VALUES (?, ?, ?, ?)";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, usuario);
            pst.setString(2, fechaSolicitud);
            pst.setString(3, codigoRecuperacion);
            pst.setString(4, estadoSolicitud);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(); // muestra el error en consola
        }
        return respuesta;
    }
    
    //Actualización de datos
    public int actualizarRecuperarContrasena(int idRecuperacion, String usuario, String fechaSolicitud, String codigoRecuperacion, String estadoSolicitud) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "UPDATE RecuperarContrasena SET usuario = ?, fechaSolicitud = ?, codigoRecuperacion = ?, estadoSolicitud = ? WHERE idRecuperacion = ?";

        try (Connection con = c1.conectar();
             PreparedStatement pst = con.prepareStatement(sql)) {

            // LOGS de depuración
            try {
                System.out.println("[csRecuperarContrasena] Conectado a: " + con.getMetaData().getURL());
            } catch (Exception e) {
                System.out.println("[csRecuperarContrasena] No se pudo obtener URL de conexión: " + e.getMessage());
            }
            System.out.println("[csRecuperarContrasena] SQL: " + sql);
            System.out.println("[csRecuperarContrasena] Params antes de set: id=" + idRecuperacion + ", usuario=" + usuario + ", fechaSolicitud=" + fechaSolicitud + ", codigo=" + codigoRecuperacion + ", estado=" + estadoSolicitud);

            // Si la columna fechaSolicitud es DATE, intentamos setDate; si falla usamos setString
            try {
                java.sql.Date fechaSql = java.sql.Date.valueOf(fechaSolicitud); // espera yyyy-MM-dd
                pst.setString(1, usuario);
                pst.setDate(2, fechaSql);
            } catch (IllegalArgumentException ex) {
                // no es yyyy-MM-dd o no se puede parsear -> usar String
                pst.setString(1, usuario);
                pst.setString(2, fechaSolicitud);
            }

            pst.setString(3, codigoRecuperacion);
            pst.setString(4, estadoSolicitud);
            pst.setInt(5, idRecuperacion);

            respuesta = pst.executeUpdate();
            System.out.println("[csRecuperarContrasena] Filas afectadas: " + respuesta);

        } catch (SQLException ex) {
            System.out.println("[csRecuperarContrasena] Error en la BD: " + ex.getMessage());
            ex.printStackTrace();
        }

        return respuesta;
    }
    
    //Eliminar datos
    public int eliminarRecuperarContrasena(int idRecuperacion){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        String sql = "DELETE FROM RecuperarContrasena WHERE idRecuperacion = ?";
        
        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idRecuperacion);

            respuesta = pst.executeUpdate();

        } catch (SQLException ex) {
        System.out.println("Error en la BD: " + ex.getMessage());
        ex.printStackTrace();
        }
        
        return respuesta;
    }
    // Listar
    public ArrayList<RecuperarContrasena> listarRecuperarContrasena() {
        ArrayList<RecuperarContrasena> lista = new ArrayList<>();
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM RecuperarContrasena";

        try (Connection con = c1.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            RecuperarContrasena rc = new RecuperarContrasena(
                    rs.getInt("idRecuperacion"),
                    rs.getString("usuario"),
                    rs.getString("fechaSolicitud"),
                    rs.getString("codigoRecuperacion"),
                    rs.getString("estadoSolicitud")
                    );
            lista.add(rc);
        }
    } catch (SQLException ex) {
        System.out.println("Error en la BD: " + ex.getMessage());
        ex.printStackTrace();
        }
    return lista;
    }
    // Listar por ID
    public RecuperarContrasena listarRecuperarContrasenaPorID(int idRecuperacion) {
        RecuperarContrasena rc = null;
        csConexion c1 = new csConexion();

        String sql = "SELECT * FROM RecuperarContrasena WHERE idRecuperacion = ?";

        try (Connection con = c1.conectar();
        PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, idRecuperacion); //Asignar el valor al placeholder

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                rc = new RecuperarContrasena(
                    rs.getInt("idRecuperacion"),
                    rs.getString("usuario"),
                    rs.getString("fechaSolicitud"),
                    rs.getString("codigoRecuperacion"),
                    rs.getString("estadoSolicitud")
                );
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error en la BD: " + ex.getMessage());
        ex.printStackTrace();
        }
    return rc;
    }
}