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
public class ControladorAlumnoAdministrador {
    
    
    public ArrayList<ControladorAltaAlumno> getNumcontrol(){
        Conexion objetoConexion = new Conexion();
        Statement stmt;
        ResultSet rs;
        ArrayList<ControladorAltaAlumno> listanControl = new ArrayList<>();
        
        try{
            stmt = objetoConexion.createStatement();
            rs = stmt.executeQuery("SELECT nControlAlum FROM Alumno");
            
            while(rs.next()){
                ControladorAltaAlumno alumno = new ControladorAltaAlumno();
                alumno.setNumcontrol(rs.getString("nControlAlum"));
                listanControl.add(alumno);
                System.out.println(alumno);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error: "+ e.toString());
        }
        return listanControl;
    }
    
    public ArrayList<ControladorAltaGrupo> getIdGrupo(){
        Conexion objetoConexion = new Conexion();
        Statement stmt;
        ResultSet rs;
        ArrayList<ControladorAltaGrupo> listaGrupo = new ArrayList<>();
        
        try{
            stmt = objetoConexion.createStatement();
            rs = stmt.executeQuery("SELECT idGrupo FROM Grupo");
            
            while(rs.next()){
                ControladorAltaGrupo grupo = new ControladorAltaGrupo();
                grupo.setIdGrupo(rs.getString("idGrupo"));
                listaGrupo.add(grupo);
                System.out.println(grupo);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error: "+ e.toString());
        }
        return listaGrupo;
    }

}
