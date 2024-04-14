/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Vista;

import Conexion.Conexion;
import Conexion.DBTables;
import java.io.File;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ClassAppProject {

    public static void main(String[] args) {
        Login loginWindow = new Login();
        loginWindow.setVisible(true);
        
        Conexion dbConnection = new Conexion();
        Connection connection = dbConnection.getConexion();
        
        // Intentar establecer la conexión
        if (connection != null) {
            System.out.println("Conexión exitosa a la base de datos desde el Main.");
            
            // Crear las tablas si la conexión es exitosa
            //dbTables.createTables(connection);
            //dbTables.crearMaestro();
        }
    }
}
