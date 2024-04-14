/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Vista.DocenteGruposFrame;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class ControladorAsignaAlumno {
    
    public void asignarAlumnoAGrupo(JFrame frame, JComboBox jComboBox2, JComboBox jComboBox3, JTextField jTextField10, JTextField jTextField11, JTextField jTextField12) {
        Conexion con = new Conexion();
        
        String numeroControlAlumno = jComboBox2.getSelectedItem().toString();
        String idGrupo = jComboBox3.getSelectedItem().toString();

        // Obtener el ID del Alumno
        String consultaIdAlumno = "SELECT idAlumno FROM alumno WHERE nControlAlum = ?";
        int idAlumno = -1; // Valor predeterminado en caso de no encontrar el ID

        try {
            PreparedStatement psIdAlumno = con.conecta().prepareStatement(consultaIdAlumno);
            psIdAlumno.setString(1, numeroControlAlumno);
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
        
        // Verificar si el número de control ya existe en la base de datos
        String consultaExistencia = "SELECT COUNT(*) AS count FROM inscribe WHERE idAlumno = ?";
        try {
            CallableStatement csExistencia = con.conecta().prepareCall(consultaExistencia);
            csExistencia.setInt(1, idAlumno);
            ResultSet rs = csExistencia.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "El Alumno ya ha sido asignado en el grupo");
                    return; // No se inserta si el número de control ya existe
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al verificar existencia del número de control: " + e.toString());
            return;
        }

        // Insertar el alumno en el grupo
        String consultaInsercion = "INSERT INTO Inscribe (idAlumno, idGrupo, califFinal, tipoEval, repite, idMaestro) VALUES (?,?,?,?,?,?);";

        try {
            PreparedStatement psInsercion = con.conecta().prepareStatement(consultaInsercion);
            psInsercion.setInt(1, idAlumno);
            psInsercion.setString(2, idGrupo);
            int calificacionFinal = Integer.parseInt(jTextField10.getText());
            psInsercion.setInt(3, calificacionFinal);
            int tipoEvaluacion = Integer.parseInt(jTextField11.getText());
            psInsercion.setInt(4, tipoEvaluacion);
            int oportunidad = Integer.parseInt(jTextField12.getText());
            psInsercion.setInt(5, oportunidad);
            psInsercion.setInt(6, Integer.parseInt(ControladorAlumnoAdministrador.getIdMaestro()));

            psInsercion.execute();

            JOptionPane.showMessageDialog(null, "El alumno se asignó al grupo exitosamente");
            DocenteGruposFrame Frame = new DocenteGruposFrame();
            Frame.setVisible(true);
            frame.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al asignar el alumno al grupo: " + e.toString());
        }
    }

}
