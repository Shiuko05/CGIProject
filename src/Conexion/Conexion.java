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
 * @author ERIKA GARCIA
 */
public class Conexion {
    
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
    
    public Connection conecta(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(cadena,usuario,pass);
            //JOptionPane.showMessageDialog(null, "Conexión exitosa");
            
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: "+e.toString());
        }
        return conexion;
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
