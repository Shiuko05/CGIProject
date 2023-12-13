/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Vista.DocenteGruposFrame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class ControladorAltaUnidad {
    
    public void asignarUnidadAMateria(JFrame frame, JComboBox jComboBox1, JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, 
            JTextField jTextField4) {
        // Obtener los datos de los campos de texto
        String idMat = jComboBox1.getSelectedItem().toString();
        String tituloUni = jTextField1.getText();   
        int numUni = Integer.parseInt(jTextField2.getText());
        String descUni = jTextField4.getText();
        int hprog = Integer.parseInt(jTextField3.getText());

        Conexion con = new Conexion();

        // Consulta para verificar si el grupo ya existe por su nombre
        String consultaExistencia = "SELECT COUNT(*) AS count FROM Unidad WHERE numUni = ?";
        try {
            java.sql.CallableStatement csExistencia = con.conecta().prepareCall(consultaExistencia);
            csExistencia.setString(1, idMat);
            ResultSet rs = csExistencia.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "La unidad ya esta establecida en la materia");
                    return; // No se inserta si la materia ya existe
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al verificar existencia de la unidad: " + e.toString());
            return;
        }

        // Si la materia no existe, se procede a insertarla
        String consultaInsercion = "INSERT INTO Unidad (idMat, numUni, tituloUni, descUni, hprog) VALUES (?, ?, ?, ?, ?)";
        try {
            java.sql.CallableStatement csInsercion = con.conecta().prepareCall(consultaInsercion);
            csInsercion.setString(1, idMat);
            csInsercion.setInt(2, numUni);
            csInsercion.setString(3, tituloUni);
            csInsercion.setString(4, descUni);
            csInsercion.setInt(5, hprog);
            
            csInsercion.execute();

            JOptionPane.showMessageDialog(null, "La unidad se agregó exitosamente");
            DocenteGruposFrame Frame = new DocenteGruposFrame();
            Frame.setVisible(true);
            frame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la unidad: " + e.toString());
        }
    }
}
