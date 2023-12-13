/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public final class Conexion {
    
    Connection conexion = null; 
    
    String usuario = "abraham";
    String pass = "123456";
    String bd = "cgidatabase";
    String ip = "localhost";
    String port = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+port+"/"+bd;
    
    public Conexion() {
        conexion = conecta();
        
    }
    
    public void crearBaseDeDatos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection tempConexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port, usuario, pass);

            Statement statement = tempConexion.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS " + bd;
            statement.executeUpdate(sql);

            tempConexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection conecta() {
        crearBaseDeDatos();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection tempConexion = DriverManager.getConnection(cadena, usuario, pass);
            //JOptionPane.showMessageDialog(null, "Conexión exitosa");
            return tempConexion;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        if (conexion == null) {
            throw new SQLException("La conexión no está establecida.");
        }
        return conexion.prepareStatement(sql);
    }
    
    public Statement createStatement() throws SQLException {
        if (conexion == null) {
            throw new SQLException("La conexión no está establecida.");
        }
        return conexion.createStatement();
    }
}
