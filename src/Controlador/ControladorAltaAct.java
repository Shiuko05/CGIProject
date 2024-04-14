/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Vista.DocenteActividadesFrame;
import Vista.DocenteMateriasFrame;
import java.sql.CallableStatement;
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
public class ControladorAltaAct {
    
    String tituloAct;

    public String getTituloAct() {
        return tituloAct;
    }

    public void setTituloAct(String tituloAct) {
        this.tituloAct = tituloAct;
    }
    
    
    
    public void insertarActividad(JFrame frame, JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, 
            JComboBox jComboBox1, JTextField jTextField4, JTextField jTextField5) {
        // Obtener los datos de los campos de texto
        String tituloAct = jTextField1.getText();
        int califAsigAct = Integer.parseInt(jTextField2.getText());
        String descAct = jTextField3.getText();
        String tipoAct = jComboBox1.getSelectedItem().toString();
        String fechaEntAct = jTextField4.getText();
        int pesoAct = Integer.parseInt(jTextField5.getText());    

        Conexion con = new Conexion();

        // Consulta para verificar si la materia ya existe por su nombre
//        String consultaExistencia = "SELECT COUNT(*) AS count FROM Materia WHERE nombMat = ?";
//        try {
//            java.sql.CallableStatement csExistencia = con.conecta().prepareCall(consultaExistencia);
//            csExistencia.setString(1, nombreMateria);
//            ResultSet rs = csExistencia.executeQuery();
//
//            if (rs.next()) {
//                int count = rs.getInt("count");
//                if (count > 0) {
//                    JOptionPane.showMessageDialog(null, "La materia ya existe en la base de datos");
//                    return; // No se inserta si la materia ya existe
//                }
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al verificar existencia de la materia: " + e.toString());
//            return;
//        }

        // Si la materia no existe, se procede a insertarla
        String consultaInsercion = "INSERT INTO Actividad (tituloAct, tipoAct, descAct, califAsigAct, fechaEntAct, pesoAct, idMaestro) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            java.sql.CallableStatement csInsercion = con.conecta().prepareCall(consultaInsercion);
            csInsercion.setString(1, tituloAct); 
            csInsercion.setString(2, tipoAct);
            csInsercion.setString(3, descAct);
            csInsercion.setInt(4, califAsigAct);
            csInsercion.setString(5, fechaEntAct);
            csInsercion.setInt(6, pesoAct);
            csInsercion.setInt(7, Integer.parseInt(ControladorAlumnoAdministrador.getIdMaestro()));

            csInsercion.execute();

            JOptionPane.showMessageDialog(null, "La actividad se agregó exitosamente");
            DocenteActividadesFrame Frame = new DocenteActividadesFrame();
            Frame.setVisible(true);
            frame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la actividad: " + e.toString());
        }
    }
    
    public void modificarActividad(JFrame frame, JComboBox jComboBox3, JTextField jTextField2, JTextField jTextField6, JTextField jTextField3, 
            JComboBox jComboBox2, JTextField jTextField4, JTextField jTextField5) {
        // Obtener los datos de los campos de texto
        String tituloActC = jComboBox3.getSelectedItem().toString();
        String tituloAct = jTextField2.getText();
        int califAsigAct = Integer.parseInt(jTextField6.getText());
        String descAct = jTextField3.getText();
        String tipoAct = jComboBox2.getSelectedItem().toString();
        String fechaEntAct = jTextField4.getText();
        int pesoAct = Integer.parseInt(jTextField5.getText());    

        Conexion con = new Conexion();

        // Si la materia no existe, se procede a insertarla
        String updateActividad = "UPDATE Actividad SET tituloAct = ?, tipoAct = ?, descAct = ?, califAsigAct = ?, fechaEntAct = ?, pesoAct = ? WHERE tituloAct = ? ";

        try {
            java.sql.CallableStatement csInsercion = con.conecta().prepareCall(updateActividad);
            csInsercion.setString(1, tituloAct); 
            csInsercion.setString(2, tipoAct);
            csInsercion.setString(3, descAct);
            csInsercion.setInt(4, califAsigAct);
            csInsercion.setString(5, fechaEntAct);
            csInsercion.setInt(6, pesoAct);
            csInsercion.setString(7, tituloActC);

            csInsercion.execute();

            JOptionPane.showMessageDialog(null, "La actividad se agregó exitosamente");
            DocenteActividadesFrame Frame = new DocenteActividadesFrame();
            Frame.setVisible(true);
            frame.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la actividad: " + e.toString());
        }
    }
    
    public void eliminarActividad(JFrame frame, JComboBox jComboBox3){
        String tituloAct = jComboBox3.getSelectedItem().toString();
        
        Conexion con = new Conexion();
        String consulta = "DELETE FROM Actividad WHERE tituloAct = ?;";
        
        try {
            CallableStatement cs = con.conecta().prepareCall(consulta);
            cs.setString(1, tituloAct);
            
            cs.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado");
            
            DocenteActividadesFrame Frame = new DocenteActividadesFrame();
            Frame.setVisible(true);
            frame.dispose();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se eliminó, error: "+e.toString());
        }
    }
}
