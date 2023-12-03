/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Vista;

import Conexion.Conexion;
import Conexion.DBTables;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ClassAppProject {

    public static void main(String[] args) {
        Login loginWindow = new Login();
        loginWindow.setVisible(true);
        
        Conexion dbConnection = new Conexion();
        Connection connection = dbConnection.conecta();
        DBTables dbTables = new DBTables();
        
        // Intentar establecer la conexión
        if (connection != null) {
            System.out.println("Conexión exitosa a la base de datos desde el Main.");
            
            // Crear las tablas si la conexión es exitosa
            dbTables.createTables(connection);
            
        }
    }
}
