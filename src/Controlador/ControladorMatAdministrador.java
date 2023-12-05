/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
//import Vista.AltaAlumnos_Alumno;
//import Vista.Horario_Administrador;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ERIKA GARCIA
 */
public class ControladorMatAdministrador {

    public String getNomAlum() {
        return nomAlum;
    }

    public void setNomAlum(String nomAlum) {
        this.nomAlum = nomAlum;
    }
    String nomAlum; 

    public String getIdMat() {
        return idMat;
    }

    public void setIdMat(String idMat) {
        this.idMat = idMat;
    }

    public String getNombMat() {
        return nombMat;
    }

    public void setNombMat(String nombMat) {
        this.nombMat = nombMat;
    }

    public Integer gethTeoMat() {
        return hTeoMat;
    }

    public void sethTeoMat(Integer hTeoMat) {
        this.hTeoMat = hTeoMat;
    }

    public Integer gethPraMat() {
        return hPraMat;
    }

    public void sethPraMat(Integer hPraMat) {
        this.hPraMat = hPraMat;
    }
    
    String idMat;
    String nombMat;
    Integer hTeoMat;
    Integer hPraMat;
   
    
    
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
        String sql = "SELECT * FROM Materia";

        try {
            Statement st = con.conecta().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                String idMat = rs.getString("idMat");
                String nombMat = rs.getString("nombMat");
                String hTeoMat = rs.getString("hTeoMat");
                String hPraMat = rs.getString("hPraMat");
                model.addRow(new Object[]{idMat, nombMat, hTeoMat, hPraMat});
            }
            
            // Ajustar el tamaño de las columnas
            tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(10);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(10);
            
            // Centrar el contenido de las columnas excepto la primera columna
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER); // Establece la alineación al centro

            for (int i = 0; i < tabla.getColumnCount(); i++) {
                if (i != 1) { // Centra todas las columnas excepto la segunda
                    tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar registros: " + e.toString());
        }
    }



    public void seleccionarGrupoAlumno(JTable tablaga){
        String grupoSeleccionado = "";
        try {
            int recorre = tablaga.getSelectedRow();
            
            if (recorre >= 0) {
                grupoSeleccionado = (String) tablaga.getValueAt(recorre, 0);
                System.out.println("Grupo Seleccionado: " + grupoSeleccionado);
                
                
                
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

}
