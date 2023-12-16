/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Vista.DocenteCalifUnidades;
import Vista.DocenteMateriasFrame;
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
public class ControladorAltaCalifUnidad {
    
    public void calificarUnidadAlumno(JFrame frame, JComboBox jComboBox2, JComboBox jComboBox3, JComboBox jComboBox4, JTextField jTextField1) {
        // Obtener los datos de los campos de texto
        String idMat = jComboBox2.getSelectedItem().toString();
        int idUni = Integer.parseInt(jComboBox3.getSelectedItem().toString());
        int noControlAlumno = Integer.parseInt(jComboBox4.getSelectedItem().toString());
        int califFinalUni = Integer.parseInt(jTextField1.getText());
        
        Conexion con = new Conexion();
        
        // Obtener el ID del Alumno
        String consultaIdAlumno = "SELECT idAlumno FROM alumno WHERE nControlAlum = ?";
        int idAlumno = -1; // Valor predeterminado en caso de no encontrar el ID

        try {
            PreparedStatement psIdAlumno = con.conecta().prepareStatement(consultaIdAlumno);
            psIdAlumno.setInt(1, noControlAlumno);
            ResultSet rsIdAlumno = psIdAlumno.executeQuery();

            if (rsIdAlumno.next()) {
                idAlumno = rsIdAlumno.getInt("idAlumno");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el ID del alumno con ese número de control");
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ID del alumno: " + e.toString());
            return;
        }

        String consultaInsercion = "INSERT INTO Obtiene (idMat, idUni, idAlumno, califFinalUni) VALUES (?, ?, ?, ?)";
        try {
            java.sql.CallableStatement csInsercion = con.conecta().prepareCall(consultaInsercion);
            csInsercion.setString(1, idMat);
            csInsercion.setInt(2, idUni);
            csInsercion.setInt(3, idAlumno);
            csInsercion.setInt(4, califFinalUni);
            
            csInsercion.execute();

            JOptionPane.showMessageDialog(null, "La calificacion de la unidadse agregó exitosamente al alumno " + noControlAlumno);
            DocenteCalifUnidades Frame = new DocenteCalifUnidades();
            Frame.setVisible(true);
            frame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la calificacion a la unidad del alumno:  " + e.toString());
        }
    }
}
