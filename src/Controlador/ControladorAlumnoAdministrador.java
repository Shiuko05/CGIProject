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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ControladorAlumnoAdministrador {
    
    public void mostrarAlumno(JTable tablaprueba, String grupo) {
        Conexion con = new Conexion();
        DefaultTableModel modelP = new DefaultTableModel(
                new Object[]{"Nombre", "Apellido Paterno", "Apellido Materno", "Número de Control", "Calificación Final", "Tipo Evaluación", "Oportunidad"},
                0);

        try {
            String sql = "SELECT Alumno.nombAlum, Alumno.apePatAlum, Alumno.apeMatAlum, Alumno.nControlAlum, " +
             "Inscribe.califFinal, Inscribe.tipoEval, Inscribe.repite " +
             "FROM Alumno " +
             "INNER JOIN Inscribe ON Alumno.idAlumno = Inscribe.idAlumno " +
             "WHERE Inscribe.idGrupo = '"+ grupo +"'";

            Statement stmt = con.conecta().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Object[] rowData = {
                        rs.getString("nombAlum"),
                        rs.getString("apePatAlum"),
                        rs.getString("apeMatAlum"),
                        rs.getString("nControlAlum"),
                        rs.getString("califFinal"),
                        rs.getString("tipoEval"),
                        rs.getString("repite")
                };
                modelP.addRow(rowData);
            }

            tablaprueba.setModel(modelP);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar registros" + e.toString());
        }
    }
    
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
