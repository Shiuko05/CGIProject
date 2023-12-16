/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Vista.DocenteMateriasFrame;
import Vista.DocenteUnidadesFrame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class ControladorRealizaActividad {
    
    public void calificarActAlumno(JFrame frame, JComboBox jComboBox1, JComboBox jComboBox2, JComboBox jComboBox3, JComboBox jComboBox4, JTextField jTextField1, 
            JTextField jTextField2) {
        // Obtener los datos de los campos de texto
        String tituloAct = jComboBox1.getSelectedItem().toString();
        String idMat = jComboBox2.getSelectedItem().toString();
        int idUni = Integer.parseInt(jComboBox3.getSelectedItem().toString());
        int noControlAlumno = Integer.parseInt(jComboBox4.getSelectedItem().toString());
        int califObtAlum = Integer.parseInt(jTextField1.getText());
        String observa = jTextField2.getText();
        
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
        
        // Obtener el ID de la actividad
        String consultaIdActividad = "SELECT idActividad FROM actividad WHERE tituloAct = ?";
        int idActividad = -1; // Valor predeterminado en caso de no encontrar el ID

        try {
            PreparedStatement psIdActividad = con.conecta().prepareStatement(consultaIdActividad);
            psIdActividad.setString(1, tituloAct);
            ResultSet rsIdActividad = psIdActividad.executeQuery();

            if (rsIdActividad.next()) {
                idActividad = rsIdActividad.getInt("idActividad");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el ID de la actividad");
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ID de la actividad: " + e.toString());
            return;
        }

        String consultaInsercion = "INSERT INTO Realiza (idActividad, idMat, idUni, idAlumno, califObtAlum, observa) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            java.sql.CallableStatement csInsercion = con.conecta().prepareCall(consultaInsercion);
            csInsercion.setInt(1, idActividad);
            csInsercion.setString(2, idMat);
            csInsercion.setInt(3, idUni);
            csInsercion.setInt(4, idAlumno);
            csInsercion.setInt(5, califObtAlum);
            csInsercion.setString(6, observa);
            
            csInsercion.execute();

            JOptionPane.showMessageDialog(null, "La calificacion de la actividad se agregó exitosamente al alumno " + idAlumno);
            DocenteMateriasFrame Frame = new DocenteMateriasFrame();
            Frame.setVisible(true);
            frame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la calificacion a la actividad del alumno:  " + e.toString());
        }
    }
    
    public static ArrayList<Integer> obtenerUnidadesPorIdMat(String idMat) {
        Conexion objetoConexion = new Conexion();
        Statement stmt;
        ResultSet rs;
        ArrayList<Integer> unidades = new ArrayList<>();

        try {
            stmt = objetoConexion.createStatement();
            rs = stmt.executeQuery("SELECT numUni FROM Unidad WHERE idMat = '" + idMat + "'");

            while (rs.next()) {
                unidades.add(rs.getInt("numUni"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error: "+ e.toString());
        }

        return unidades;
    }
    
    public static ArrayList<Integer> obtenerRealizaPorNControl(String idMat) {
        Conexion objetoConexion = new Conexion();
        Statement stmt;
        ResultSet rs;
        ArrayList<Integer> unidades = new ArrayList<>();
        

        try {
            stmt = objetoConexion.createStatement();
            rs = stmt.executeQuery("SELECT numUni FROM Unidad WHERE idMat = '" + idMat + "'");

            while (rs.next()) {
                unidades.add(rs.getInt("numUni"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error: "+ e.toString());
        }

        return unidades;
    }

}
