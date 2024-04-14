/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Vista.DocenteConexionAlta;
import Vista.Login;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author usuario
 */
public final class Conexion {
    
    Connection conexion = null;     
    
    public Conexion() {
        conexion = conecta();
        
    }
    
    public void crearBaseDeDatos(JFrame frame, JTextField ip, JTextField port, JTextField usuario, JTextField pass, JTextField bd) {
        
        String jip = ip.getText();
        String juser = usuario.getText();
        String jpass = pass.getText();
        String jbd = bd.getText();
        String jport = port.getText();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://" + jip + ":" + jport, juser, jpass);

            if (conexion!= null) {
                JOptionPane.showMessageDialog(null, "Conexión exitosa!.");
                Statement statement = conexion.createStatement();
                String sql = "CREATE DATABASE IF NOT EXISTS " + jbd;
                statement.executeUpdate(sql);
                
                DBTables dbTables = new DBTables();
                dbTables.createTables(conexion);
                
                guardarDatosEnArchivo(juser, jpass, jbd, jip, jport);
                
                conexion.close();
                
                frame.dispose();
                
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al hacer la conexión: " + e.toString());
        }
    }
    
    private void guardarDatosEnArchivo(String usuario, String pass, String bd, String ip, String port) {
        try {
            FileWriter fw = new FileWriter("conexion.txt");
            fw.write("Usuario: " + usuario + "\n");
            fw.write("Contraseña: " + pass + "\n");
            fw.write("Base de datos: " + bd + "\n");
            fw.write("IP: " + ip + "\n");
            fw.write("Puerto: " + port + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Connection conecta() {
        
        String archivo = "conexion.txt";
        
        try {
            
            File file = new File(archivo);
        
            if (!file.exists()) {
                return null;
            }
            
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            
            String fUsuario = br.readLine().split(": ")[1];
            String fPass = br.readLine().split(": ")[1];
            String fBd = br.readLine().split(": ")[1];
            String fIp = br.readLine().split(": ")[1];
            int fPort = Integer.parseInt(br.readLine().split(": ")[1]);
            
            String cadena = "jdbc:mysql://"+fIp+":"+fPort+"/"+fBd;
            
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(cadena, fUsuario, fPass);
            //JOptionPane.showMessageDialog(null, "Conexión exitosa");
            return conexion;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    
    public Connection getConexion() {
        Connection connection = conecta();
        if (connection == null) {
            JOptionPane.showMessageDialog(null, "No hay ninguna conexion establecida!", "Error", JOptionPane.ERROR_MESSAGE);

            // Abrir el JFrame que desees
            // Por ejemplo:
            DocenteConexionAlta conexionalta = new DocenteConexionAlta();
            conexionalta.setVisible(true);

            return null;
        }
        return connection;
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
