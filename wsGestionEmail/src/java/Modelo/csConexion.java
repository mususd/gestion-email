package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class csConexion {
    public String user, password;
    public String url, driver;
    public Connection cn;
    //Constructor
    public csConexion(){
        this.user = "SA";
        this.password = "Musus123";
        this.url = "jdbc:sqlserver://localhost:1433;databaseName=GestionEmail;encrypt=false;trustServerCertificate=true";
        this.driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.cn = null;
    }
    
    public Connection conectar(){
        try{
        Class.forName(this.driver);
        cn = DriverManager.getConnection(url, user, password);
        return cn;
        }catch(Exception ex){
        return null;    
        }
    }
    public void desconectar() throws SQLException{
        cn.close();
    }
}