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
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

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
    
    public void mostrarGrupos(JTable tablaga) {
        Conexion con = new Conexion();
        DefaultTableModel model = new DefaultTableModel();
        tablaga.setModel(model);

        // Añadir columnas a la tabla en el orden solicitado
        model.addColumn("Nombre de la Materia");
        model.addColumn("Materia");
        model.addColumn("Grupo");
        model.addColumn("Alumnos Inscritos"); // Nueva columna para mostrar la cantidad de alumnos inscritos

        // Consulta SQL para obtener datos de Materia, Grupo y contar alumnos inscritos
        String sql = "SELECT Materia.nombMat, Grupo.idGrupo, Grupo.grupo, COUNT(Inscribe.idAlumno) AS alumnos_inscritos " +
                     "FROM (Materia INNER JOIN Grupo ON Materia.idMat = Grupo.idMat) " +
                     "LEFT JOIN Inscribe ON Grupo.idGrupo = Inscribe.idGrupo " +
                     "GROUP BY Materia.nombMat, Grupo.idGrupo, Grupo.grupo;";

        try {
            Statement st = con.conecta().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                String nombMat = rs.getString("nombMat");
                String idMat = rs.getString("idGrupo");
                String grupo = rs.getString("grupo");
                int alumnosInscritos = rs.getInt("alumnos_inscritos");

                model.addRow(new Object[]{nombMat, idMat, grupo, alumnosInscritos});
            }
            
            // Ajustar el tamaño de las columnas
            tablaga.getColumnModel().getColumn(0).setPreferredWidth(200); // Columna 0: Nombre de la Materia
            tablaga.getColumnModel().getColumn(1).setPreferredWidth(20);  // Columna 1: Materia
            tablaga.getColumnModel().getColumn(2).setPreferredWidth(10);  // Columna 2: Grupo
            tablaga.getColumnModel().getColumn(3).setPreferredWidth(10); // Columna 3: Alumnos Inscritos
            
            // Centrar el contenido de las columnas excepto la primera columna
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER); // Establece la alineación al centro

            for (int i = 1; i < tablaga.getColumnCount(); i++) { // Comienza desde la segunda columna
                tablaga.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
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
