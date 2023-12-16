/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControladorUnidadesAdministrador {
 
    public ArrayList<ControladorAltaUnidad> getUnidad(){
        Conexion objetoConexion = new Conexion();
        Statement stmt;
        ResultSet rs;
        ArrayList<ControladorAltaUnidad> listaUnidad = new ArrayList<>();
        
        try{
            stmt = objetoConexion.createStatement();
            rs = stmt.executeQuery("SELECT numUni FROM Unidad");
            
            while(rs.next()){
                ControladorAltaUnidad grupo = new ControladorAltaUnidad();
                grupo.setUnidad(rs.getInt("numUni"));
                listaUnidad.add(grupo);
                System.out.println(grupo);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error: "+ e.toString());
        }
        return listaUnidad;
    }
    
}
