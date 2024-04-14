/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Vista.DocenteEditarAct;
import Vista.DocenteEditarAlumno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ControladorAlumnoAdministrador {
    
    private static String idMaestro;

    public static String getIdMaestro() {
        return idMaestro;
    }

    public static void setIdMaestro(String id) {
        idMaestro = id;
    }
    
    public void guardarIdMaestro(String idMaestro) {
        setIdMaestro(idMaestro);
    }
    
    public void mostrarAlumno(JTable tablaprueba, String grupo) {
        
        Conexion con = new Conexion();
        DefaultTableModel modelP = new DefaultTableModel(
                new Object[]{"Nombre", "Apellido Paterno", "Apellido Materno", "Número de Control", "Calificación Final", "Tipo Evaluación", "Oportunidad"},
                0);
        System.out.println(getIdMaestro());
        try {
            String sql = "SELECT Alumno.idMaestro, Alumno.nombAlum, Alumno.apePatAlum, Alumno.apeMatAlum, Alumno.nControlAlum, " +
             "Inscribe.califFinal, Inscribe.tipoEval, Inscribe.repite " +
             "FROM Alumno " +
             "INNER JOIN Inscribe ON Alumno.idAlumno = Inscribe.idAlumno " +
             "WHERE Alumno.idMaestro = '" + getIdMaestro() + "' && Inscribe.idGrupo = '" + grupo + "'";

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
    
//    public void mostrarAlumnoTotal(JTable tablaprueba) {
//        Conexion con = new Conexion();
//        DefaultTableModel modelP = new DefaultTableModel(
//                new Object[]{"Nombre", "Apellido Paterno", "Apellido Materno", "Número de Control", "Calificación Final", "Tipo Evaluación", "Oportunidad"},
//                0);
//
//        try {
//            String sql = "SELECT Alumno.nombAlum, Alumno.apePatAlum, Alumno.apeMatAlum, Alumno.nControlAlum, " +
//             "Inscribe.califFinal, Inscribe.tipoEval, Inscribe.repite " +
//             "FROM Alumno " +
//             "INNER JOIN Inscribe ON Alumno.idAlumno = Inscribe.idAlumno;";
//
//            Statement stmt = con.conecta().createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
//                Object[] rowData = {
//                        rs.getString("nombAlum"),
//                        rs.getString("apePatAlum"),
//                        rs.getString("apeMatAlum"),
//                        rs.getString("nControlAlum"),
//                        rs.getString("califFinal"),
//                        rs.getString("tipoEval"),
//                        rs.getString("repite")
//                };
//                modelP.addRow(rowData);
//            }
//
//            tablaprueba.setModel(modelP);
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al mostrar registros" + e.toString());
//        }
//    }
    
    public void mostrarAlumnoTotal(JTable tablaprueba) {
        Conexion con = new Conexion();
        DefaultTableModel modelP = new DefaultTableModel(
                new Object[]{"Nombre", "Apellido Paterno", "Apellido Materno", "Número de Control", "semestre", "correoAlum"},
                0);

        try {
            String sql = "SELECT nombAlum, apePatAlum, apeMatAlum, nControlAlum, semestreAlum, correoAlum FROM Alumno " +
             "WHERE idMaestro = '" + getIdMaestro() + "'";

            Statement stmt = con.conecta().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Object[] rowData = {
                        rs.getString("nombAlum"),
                        rs.getString("apePatAlum"),
                        rs.getString("apeMatAlum"),
                        rs.getString("nControlAlum"),
                        rs.getString("semestreAlum"),
                        rs.getString("correoAlum")
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
    
//    public void seleccionarAlumno(JFrame frame, JTable tablaga){
//        String AlumnoSeleccionado = "";
//        try {
//            int recorre = tablaga.getSelectedRow();
//
//            if (recorre >= 0) {
//                AlumnoSeleccionado = (String) tablaga.getValueAt(recorre, 3);
//                System.out.println("Alumno Seleccionado: " + AlumnoSeleccionado);
//
//                DocenteEditarAlumno Frame = new DocenteEditarAlumno(AlumnoSeleccionado);
//                Frame.setVisible(true);
//                frame.dispose();
//                //AltaAlumnos_Alumno Frame = new AltaAlumnos_Alumno(grupoSeleccionado);
//                //Frame.setVisible(true);
//                //Frame.dispose();
//
//                //Frame.txtnombre.setText((String) tablaga.getValueAt(recorre, 2));
//               // paraid.setText(paratabla.getValueAt(recorre, 0).toString());
//
//
//            } else {
//                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
//            }
//
//        } catch (Exception e){
//            JOptionPane.showMessageDialog(null, "Error al seleccionar :"+e.toString());
//        }
//    }

}
