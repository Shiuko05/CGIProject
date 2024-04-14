/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Vista.DocenteActividadesFrame;
import Vista.Login;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class ControladorAltaMaestro {
    
    public void insertarMaestro(JFrame frame, JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, 
        JTextField jTextField4, JTextField jTextField5) {
        // Obtener los datos de los campos de texto
        String nombMae = jTextField1.getText();
        String apePatMae = jTextField2.getText();
        String apeMatMae = jTextField3.getText();
        String correoMae = jTextField4.getText();
        String nControlMae = jTextField5.getText();    

        Conexion con = new Conexion();
        
        String consultaInsercion = "INSERT INTO Maestro (nombMae, apePatMae, apeMatMae, correoMae, nControlMae) VALUES (?, ?, ?, ?, ?)";
        try {
            java.sql.CallableStatement csInsercion = con.conecta().prepareCall(consultaInsercion);
            csInsercion.setString(1, nombMae); 
            csInsercion.setString(2, apePatMae);
            csInsercion.setString(3, apeMatMae);
            csInsercion.setString(4, correoMae);
            csInsercion.setString(5, nControlMae);

            csInsercion.execute();

            JOptionPane.showMessageDialog(null, "El Maestro se agregó exitosamente");
            Login Frame = new Login();
            Frame.setVisible(true);
            frame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar al Maestro: " + e.toString());
        }
    }
}
