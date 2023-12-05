/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Usuario
 */
public class ControladorHorarioAdministrador {
    
    public void mostrarGrupoAlumno(JTable tabla) {
        Conexion con = new Conexion();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        // Borra las filas existentes en el modelo
        model.setRowCount(0);

        // Consulta SQL para obtener datos de la tabla Grupo con concatenación
        String sql = "SELECT idGrupo, idMat, grupo, periodo, anio, " +
                     "hlun, slun, hmar, smar, hmie, smie, hjue, sjue, hvie, svie " +
                     "FROM Grupo";

        try {
            Statement st = con.conecta().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                String idGrupo = rs.getString("idGrupo");
                String idMat = rs.getString("idMat");
                String grupo = rs.getString("grupo");
                String anio = rs.getString("anio");

                // Obtener el número de periodo
                int numeroPeriodo = rs.getInt("periodo");
                String textoPeriodo = "";

                // Asignar texto correspondiente al número de periodo
                switch(numeroPeriodo) {
                    case 1:
                        textoPeriodo = "ENE-JUN";
                        break;
                    case 2:
                        textoPeriodo = "AGO-DIC";
                        break;
                    case 3:
                        textoPeriodo = "VERANO";
                        break;
                    default:
                        textoPeriodo = "Periodo no definido";
                        break;
                }

                // Crear una cadena HTML para mostrar los datos concatenados con formato
                String lun = "<html>" + rs.getString("hlun") + "<br>" + rs.getString("slun") + "</html>";
                String mar = "<html>" + rs.getString("hmar") + "<br>" + rs.getString("smar") + "</html>";
                String mie = "<html>" + rs.getString("hmie") + "<br>" + rs.getString("smie") + "</html>";
                String jue = "<html>" + rs.getString("hjue") + "<br>" + rs.getString("sjue") + "</html>";
                String vie = "<html>" + rs.getString("hvie") + "<br>" + rs.getString("svie") + "</html>";

                // Agregar los datos al modelo de la tabla
                model.addRow(new Object[]{idGrupo, idMat, grupo, textoPeriodo, anio, lun, mar, mie, jue, vie});
            }
            
            // Centrar el contenido de las columnas excepto la primera columna
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER); // Establece la alineación al centro

            for (int i = 1; i < 5; i++) {
                tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar registros: " + e.toString());
        }
    }



}
