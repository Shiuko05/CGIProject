/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Vista.Inicio_Administrador;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class ControladorAltaMateria {
    
    // Función para insertar datos en la tabla de Materias de la base de datos
    public void insertarMateria(JFrame frame, JTextField txtncontrol, JTextField txtncontrol1, JTextField txtncontrol2) {
        // Obtener los datos de los campos de texto
        String nombreMateria = txtncontrol.getText();
        int horasTeoricas = Integer.parseInt(txtncontrol1.getText());
        int horasPracticas = Integer.parseInt(txtncontrol2.getText());

        Conexion con = new Conexion();

        // Consulta para verificar si la materia ya existe por su nombre
        String consultaExistencia = "SELECT COUNT(*) AS count FROM Materia WHERE nombMat = ?";
        try {
            java.sql.CallableStatement csExistencia = con.conecta().prepareCall(consultaExistencia);
            csExistencia.setString(1, nombreMateria);
            ResultSet rs = csExistencia.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "La materia ya existe en la base de datos");
                    return; // No se inserta si la materia ya existe
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al verificar existencia de la materia: " + e.toString());
            return;
        }

        // Si la materia no existe, se procede a insertarla
        String consultaInsercion = "INSERT INTO Materia (idMat, nombMat, hTeoMat, hPraMat) VALUES (?, ?, ?, ?)";
        try {
            java.sql.CallableStatement csInsercion = con.conecta().prepareCall(consultaInsercion);
            csInsercion.setString(1, generarIdMateria(nombreMateria)); // Genera un id para la materia
            csInsercion.setString(2, nombreMateria);
            csInsercion.setInt(3, horasTeoricas);
            csInsercion.setInt(4, horasPracticas);

            csInsercion.execute();

            JOptionPane.showMessageDialog(null, "La materia se agregó exitosamente");
            Inicio_Administrador vistaPrincipalMaestro = new Inicio_Administrador();
            vistaPrincipalMaestro.setVisible(true);
            frame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la materia: " + e.toString());
        }
    }
    
    private String generarIdMateria(String nombreMateria) {
        String[] palabras = nombreMateria.split("\\s+"); // Dividir el nombre por espacios en blanco

        if (palabras.length > 1) { // Si hay más de una palabra
            StringBuilder idAbreviada = new StringBuilder();

            for (String palabra : palabras) {
                if (!palabra.isEmpty()) {
                    idAbreviada.append(palabra.charAt(0)); // Tomar la primera letra de cada palabra
                }
            }

            // Asegurar que la ID abreviada tenga una longitud mínima de 3 caracteres
            while (idAbreviada.length() < 3) {
                idAbreviada.append("X"); // Agregar 'X' como relleno si la ID es demasiado corta
            }

            return idAbreviada.toString().toUpperCase(); // Convertir la ID a mayúsculas
        } else if (palabras.length == 1) { // Si solo hay una palabra
            String id = palabras[0].substring(0, Math.min(palabras[0].length(), 3)); // Tomar los primeros 3 caracteres
            return id.toUpperCase(); // Convertir la ID a mayúsculas
        }

        return ""; // En caso de que no haya palabras
    }

}
