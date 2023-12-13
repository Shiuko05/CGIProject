/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Vista.DocenteAlumnosGrupo;
import Vista.DocenteEditarAct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ControladorActAdministrador {
    
    public void mostrarActividades(JTable tablaga) {
        Conexion con = new Conexion();
        DefaultTableModel model = new DefaultTableModel();
        tablaga.setModel(model);

        // Añadir columnas a la tabla en el orden solicitado
        model.addColumn("Titulo");
        model.addColumn("Tipo de Actividad");
        model.addColumn("Calificación");
        model.addColumn("Fecha de Entrega");
        model.addColumn("Porcentaje");

        String sql = "SELECT tituloAct, tipoAct, califAsigAct, fechaEntAct, pesoAct FROM Actividad;";

        try {
            Statement st = con.conecta().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                String tituloAct = rs.getString("tituloAct");
                String tipoAct = rs.getString("tipoAct");
                int califAsigAct = rs.getInt("califAsigAct");
                String fechaEntAct = rs.getString("fechaEntAct");
                int pesoAct = rs.getInt("pesoAct");

                model.addRow(new Object[]{tituloAct, tipoAct, califAsigAct, fechaEntAct, pesoAct});
            }
            
            // Ajustar el tamaño de las columnas
//            tablaga.getColumnModel().getColumn(0).setPreferredWidth(200); // Columna 0: Nombre de la Materia
//            tablaga.getColumnModel().getColumn(1).setPreferredWidth(20);  // Columna 1: Materia
//            tablaga.getColumnModel().getColumn(2).setPreferredWidth(10);  // Columna 2: Grupo
//            tablaga.getColumnModel().getColumn(3).setPreferredWidth(10); // Columna 3: Alumnos Inscritos
            
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
    
    public ArrayList<ControladorAltaAct> getTituloAct(){
        Conexion objetoConexion = new Conexion();
        Statement stmt;
        ResultSet rs;
        ArrayList<ControladorAltaAct> listaAct = new ArrayList<>();
        
        try{
            stmt = objetoConexion.createStatement();
            rs = stmt.executeQuery("SELECT tituloAct FROM Actividad");
            
            while(rs.next()){
                ControladorAltaAct actividad = new ControladorAltaAct();
                actividad.setTituloAct(rs.getString("tituloAct"));
                listaAct.add(actividad);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error: "+ e.toString());
        }
        return listaAct;
    }
    
    public void seleccionarGrupoAlumno(JFrame frame, JTable tablaga){
        String grupoSeleccionado = "";
        try {
            int recorre = tablaga.getSelectedRow();

            if (recorre >= 0) {
                grupoSeleccionado = (String) tablaga.getValueAt(recorre, 0);
                System.out.println("Actividad Seleccionada: " + grupoSeleccionado);

                DocenteEditarAct Frame = new DocenteEditarAct(grupoSeleccionado);
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
}
