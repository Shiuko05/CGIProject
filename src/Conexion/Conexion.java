/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
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
}
