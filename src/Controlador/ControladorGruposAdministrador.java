/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Vista.DocenteAlumnosGrupo;
//import Vista.AltaAlumnos_Alumno;
//import Vista.Horario_Administrador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import javax.swing.JFrame;

/**
 *
 * @author ERIKA GARCIA
 */
public class ControladorGruposAdministrador {

    public String getNomAlum() {
        return nomAlum;
    }

    public void setNomAlum(String nomAlum) {
        this.nomAlum = nomAlum;
    }
    String nomAlum; 
   
    
    
    //------------------------TABLA AUXILIAR
    /*public void alumno(){
        Conexion con = new Conexion(); //--
        DefaultTableModel modelP = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTable = new TableRowSorter<TableModel>(modelP);
        
        String sql2 = "";
        modelP.addColumn("Nombre");
        modelP.addColumn("AP");
        modelP.addColumn("AM");
          modelP.addColumn("Semes");
        modelP.addColumn("Nac");
        modelP.addColumn("Curp");
        modelP.addColumn("Ncontrol");
        
        String sql2 = "SELECT nombAlum, apePatAlum, apeMatAlum, semestreAlum, fechaNacAlum, nControlAlum FROM alumno;";
        Statement st2; 
         try {
            //st = con.getConnection().createStatement();
            st2 = con.conecta().createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al mostrar registros" + e.toString());    
    }
    */
    
    //------------------------
    
    public void mostrarGrupoAlumno(JTable tabla) {
        Conexion con = new Conexion();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        // Borra las filas existentes en el modelo
        model.setRowCount(0);

        // Consulta SQL para obtener datos de Materia y Grupo
        String sql = "SELECT Materia.nombMat, Grupo.idGrupo, Grupo.grupo " +
                     "FROM Materia INNER JOIN Grupo ON Materia.idMat = Grupo.idMat;";

        try {
            Statement st = con.conecta().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                String nombMat = rs.getString("nombMat");
                String idMat = rs.getString("idGrupo");
                String grupo = rs.getString("grupo");
                model.addRow(new Object[]{nombMat, idMat, grupo});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar registros: " + e.toString());
        }
    }



    public void seleccionarGrupoAlumno(JFrame frame, JTable tablaga){
        String grupoSeleccionado = "";
        try {
            int recorre = tablaga.getSelectedRow();
            
            if (recorre >= 0) {
                grupoSeleccionado = (String) tablaga.getValueAt(recorre, 1);
                System.out.println("Grupo Seleccionado: " + grupoSeleccionado);
                
                DocenteAlumnosGrupo Frame = new DocenteAlumnosGrupo(grupoSeleccionado);
                Frame.setVisible(true);
                frame.dispose();
                //AltaAlumnos_Alumno Frame = new AltaAlumnos_Alumno(grupoSeleccionado);
                //Frame.setVisible(true);
                //Frame.dispose();
                
                //Frame.txtnombre.setText((String) tablaga.getValueAt(recorre, 2));
               // paraid.setText(paratabla.getValueAt(recorre, 0).toString());
               
                
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al seleccionar :"+e.toString());
        }
    }    

    public ArrayList<ControladorMatAdministrador> getIdMat(){
        Conexion objetoConexion = new Conexion();
        Statement stmt;
        ResultSet rs;
        ArrayList<ControladorMatAdministrador> listaMateria = new ArrayList<>();
        
        try{
            stmt = objetoConexion.createStatement();
            rs = stmt.executeQuery("SELECT idMat FROM Materia");
            
            while(rs.next()){
                ControladorMatAdministrador materia = new ControladorMatAdministrador();
                materia.setIdMat(rs.getString("idMat"));
                listaMateria.add(materia);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error: "+ e.toString());
        }
        return listaMateria;
    }
    
}
