/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Vista.DocenteGruposFrame;
import Vista.DocenteUnidadesFrame;
import java.sql.CallableStatement;
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
    
    Integer unidad;

    public Integer getUnidad() {
        return unidad;
    }

    public void setUnidad(Integer unidad) {
        this.unidad = unidad;
    }
    
    
    
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
        String consultaExistencia = "SELECT COUNT(*) AS count FROM Unidad WHERE numUni = ? AND idMat = ?";
        try {
            java.sql.CallableStatement csExistencia = con.conecta().prepareCall(consultaExistencia);
            csExistencia.setInt(1, numUni);
            csExistencia.setString(2, idMat);
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
        String consultaInsercion = "INSERT INTO Unidad (idUnidad, idMat, numUni, tituloUni, descUni, hprog) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            java.sql.CallableStatement csInsercion = con.conecta().prepareCall(consultaInsercion);
            csInsercion.setString(1, generarIdUni(idMat, numUni));
            csInsercion.setString(2, idMat);
            csInsercion.setInt(3, numUni);
            csInsercion.setString(4, tituloUni);
            csInsercion.setString(5, descUni);
            csInsercion.setInt(6, hprog);
            
            csInsercion.execute();

            JOptionPane.showMessageDialog(null, "La unidad se agregó exitosamente");
            DocenteUnidadesFrame Frame = new DocenteUnidadesFrame();
            Frame.setVisible(true);
            frame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la unidad: " + e.toString());
        }
    }
    
    public void modificarUnidadAMateria(JFrame frame, JComboBox jComboBox1, JComboBox jComboBox2, JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, 
            JTextField jTextField4) {
        // Obtener los datos de los campos de texto
        String idMat = jComboBox1.getSelectedItem().toString();
        String numUniC = jComboBox2.getSelectedItem().toString();
        String tituloUni = jTextField1.getText();   
        int numUni = Integer.parseInt(jTextField2.getText());
        String descUni = jTextField4.getText();
        int hprog = Integer.parseInt(jTextField3.getText());

        Conexion con = new Conexion();
        
        // Consulta para verificar si el grupo ya existe por su nombre
        String consultaExistencia = "SELECT * FROM Unidad WHERE numUni = ? AND idMat = ?";
        try {
            java.sql.CallableStatement csExistencia = con.conecta().prepareCall(consultaExistencia);
            csExistencia.setInt(1, numUni);
            csExistencia.setString(2, idMat);
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
        
        String consultaIdUnidad = "SELECT idUnidad FROM unidad WHERE numUni = ? AND idMat = ?";
        String idUnidad = null; // Valor predeterminado en caso de no encontrar el ID

        try {
            PreparedStatement psIdAlumno = con.conecta().prepareStatement(consultaIdUnidad);
            psIdAlumno.setString(1, numUniC);
            psIdAlumno.setString(2, idMat);
            ResultSet rsIdAlumno = psIdAlumno.executeQuery();

            if (rsIdAlumno.next()) {
                idUnidad = rsIdAlumno.getString("idUnidad");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el ID del alumno con ese número de control");
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ID del alumno: " + e.toString());
            return;
        }

        // Si la materia no existe, se procede a insertarla
        String consultaInsercion = "UPDATE Unidad SET idUnidad = ?, idMat = ?, numUni = ?, tituloUni = ?, descUni = ?, hprog = ? WHERE idUnidad = ? ";
        try {
            java.sql.CallableStatement csInsercion = con.conecta().prepareCall(consultaInsercion);
            csInsercion.setString(1, generarIdUni(idMat, numUni));
            csInsercion.setString(2, idMat);
            csInsercion.setInt(3, numUni);
            csInsercion.setString(4, tituloUni);
            csInsercion.setString(5, descUni);
            csInsercion.setInt(6, hprog);
            csInsercion.setString(7, idUnidad);
            
            csInsercion.execute();

            JOptionPane.showMessageDialog(null, "La unidad se agregó exitosamente");
            DocenteUnidadesFrame Frame = new DocenteUnidadesFrame();
            Frame.setVisible(true);
            frame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la unidad: " + e.toString());
        }
    }
    
    public void eliminarUnidad(JFrame frame, JComboBox ptxtncontrol, JComboBox jComboBox2){
        String idMat = ptxtncontrol.getSelectedItem().toString();
        String numUni = jComboBox2.getSelectedItem().toString();
         
        Conexion con = new Conexion();
        String consulta = "DELETE FROM unidad WHERE numUni = ? AND idMat = ?;";
        
        try {
            CallableStatement cs = con.conecta().prepareCall(consulta);
            cs.setString(1, numUni);
            cs.setString(2, idMat);
            
            cs.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado");
            DocenteUnidadesFrame Frame = new DocenteUnidadesFrame();
            Frame.setVisible(true);
            frame.dispose();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se eliminó, error: "+e.toString());
        }
    }
    
    private String generarIdUni(String idMat, Integer numUni) {
        // Concatenar los parámetros en una cadena
        String concatenatedId = idMat + numUni;

        // Verificar y ajustar la longitud máxima a 9 caracteres
        if (concatenatedId.length() > 4) {
            concatenatedId = concatenatedId.substring(0, 4); // Limitar la longitud a 9 caracteres si es mayor
        } else {
            // Si la longitud es menor a 9, agregar 'X' como relleno
            while (concatenatedId.length() < 4) {
                concatenatedId += "X";
            }
        }

        return concatenatedId.toUpperCase(); // Convertir a mayúsculas
    }
    
}
