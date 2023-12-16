/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Vista.DocenteAlumnosFrame;
import Vista.DocenteGruposFrame;
import Vista.DocenteMateriasFrame;
import Vista.Inicio_Administrador;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class ControladorAltaGrupo {
    String idGrupo;
    String idMat;
    String grupo;
    String periodo;
    String anio;
    String hlun;
    String hmar;
    String hmie;
    String hjue;
    String hvie;
    String slun;
    String smar;
    String smie;
    String sjue;
    String svie;

    public String getIdGrupo() {
        return idGrupo;
    }
    
    public void setIdGrupo(String idGrupo){
        this.idGrupo = idGrupo;
    }
    
    public String getIdMat() {
        return idMat;
    }

    public void setIdMat(String idMat) {
        this.idMat = idMat;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getHlun() {
        return hlun;
    }

    public void setHlun(String hlun) {
        this.hlun = hlun;
    }

    public String getHmar() {
        return hmar;
    }

    public void setHmar(String hmar) {
        this.hmar = hmar;
    }

    public String getHmie() {
        return hmie;
    }

    public void setHmie(String hmie) {
        this.hmie = hmie;
    }

    public String getHjue() {
        return hjue;
    }

    public void setHjue(String hjue) {
        this.hjue = hjue;
    }

    public String getHvie() {
        return hvie;
    }

    public void setHvie(String hvie) {
        this.hvie = hvie;
    }

    public String getSlun() {
        return slun;
    }

    public void setSlun(String slun) {
        this.slun = slun;
    }

    public String getSmar() {
        return smar;
    }

    public void setSmar(String smar) {
        this.smar = smar;
    }

    public String getSmie() {
        return smie;
    }

    public void setSmie(String smie) {
        this.smie = smie;
    }

    public String getSjue() {
        return sjue;
    }

    public void setSjue(String sjue) {
        this.sjue = sjue;
    }

    public String getSvie() {
        return svie;
    }

    public void setSvie(String svie) {
        this.svie = svie;
    }
    
    
    
    // Función para insertar datos en la tabla de Grupos de la base de datos
    public void insertarGrupo(JFrame frame, JComboBox jComboBox1, JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, 
            JTextField jTextField4, JTextField jTextField5, JTextField jTextField6, JTextField jTextField7, JTextField jTextField8, 
            JTextField jTextField13, JTextField jTextField12, JTextField jTextField11, JTextField jTextField10, JTextField jTextField9) {
        // Obtener los datos de los campos de texto
        String idMat = jComboBox1.getSelectedItem().toString();
        String grupo = jTextField1.getText();
        String periodo = jTextField2.getText();
        
        String anio = jTextField3.getText();
        String hlun = jTextField4.getText();
        String hmar = jTextField5.getText();
        String hmie = jTextField6.getText();
        String hjue = jTextField7.getText();
        String hvie = jTextField8.getText();
        
        String slun = jTextField13.getText();
        String smar = jTextField12.getText();
        String smie = jTextField11.getText();
        String sjue = jTextField10.getText();
        String svie = jTextField9.getText();

        Conexion con = new Conexion();

        // Consulta para verificar si el grupo ya existe por su nombre
        String consultaExistencia = "SELECT COUNT(*) AS count FROM Grupo WHERE idGrupo = ?";
        try {
            java.sql.CallableStatement csExistencia = con.conecta().prepareCall(consultaExistencia);
            csExistencia.setString(1, generarIdGrupo(idMat, grupo, Integer.parseInt(periodo), Integer.parseInt(anio)));
            ResultSet rs = csExistencia.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "La materia ya existe en la base de datos");
                    return; // No se inserta si la materia ya existe
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al verificar existencia de la materia: " + e.toString());
            return;
        }

        // Si la materia no existe, se procede a insertarla
        String consultaInsercion = "INSERT INTO Grupo (idGrupo, idMat, grupo, periodo, anio, hlun, hmar, hmie, hjue, hvie, slun, smar, smie, "
                + "sjue, svie) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            java.sql.CallableStatement csInsercion = con.conecta().prepareCall(consultaInsercion);
            csInsercion.setString(1, generarIdGrupo(idMat, grupo, Integer.parseInt(periodo), Integer.parseInt(anio))); // Genera un id para la materia
            csInsercion.setString(2, idMat);
            csInsercion.setString(3, grupo);
            csInsercion.setString(4, periodo);
            csInsercion.setString(5, anio);
            csInsercion.setString(6, hlun);
            csInsercion.setString(7, hmar);
            csInsercion.setString(8, hmie);
            csInsercion.setString(9, hjue);
            csInsercion.setString(10, hvie);
            csInsercion.setString(11, slun);
            csInsercion.setString(12, smar);
            csInsercion.setString(13, smie);
            csInsercion.setString(14, sjue);
            csInsercion.setString(15, svie);
            
            csInsercion.execute();

            JOptionPane.showMessageDialog(null, "El grupo se agregó exitosamente");
            DocenteGruposFrame Frame = new DocenteGruposFrame();
            Frame.setVisible(true);
            frame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el grupo: " + e.toString());
        }
    }
    
    private String generarIdGrupo(String idMat, String grupo, int periodo, int anio) {
        // Concatenar los parámetros en una cadena
        String concatenatedId = idMat + grupo + periodo + anio;

        // Verificar y ajustar la longitud máxima a 9 caracteres
        if (concatenatedId.length() > 9) {
            concatenatedId = concatenatedId.substring(0, 9); // Limitar la longitud a 9 caracteres si es mayor
        } else {
            // Si la longitud es menor a 9, agregar 'X' como relleno
            while (concatenatedId.length() < 9) {
                concatenatedId += "X";
            }
        }

        return concatenatedId.toUpperCase(); // Convertir a mayúsculas
    }
    
    public void modificarGrupo(JFrame frame, JComboBox jComboBox1, JComboBox jComboBox2, JTextField jTextField2, JTextField jTextField3, 
            JTextField jTextField4, JTextField jTextField5, JTextField jTextField6, JTextField jTextField7, JTextField jTextField8, 
            JTextField jTextField13, JTextField jTextField12, JTextField jTextField11, JTextField jTextField10, JTextField jTextField9) {
        // Obtener los datos de los campos de texto
        String idMat = jComboBox1.getSelectedItem().toString();
        String idGrupoC = jComboBox2.getSelectedItem().toString();
        String periodo = jTextField2.getText();
        
        String anio = jTextField3.getText();
        String hlun = jTextField4.getText();
        String hmar = jTextField5.getText();
        String hmie = jTextField6.getText();
        String hjue = jTextField7.getText();
        String hvie = jTextField8.getText();
        
        String slun = jTextField13.getText();
        String smar = jTextField12.getText();
        String smie = jTextField11.getText();
        String sjue = jTextField10.getText();
        String svie = jTextField9.getText();

        Conexion con = new Conexion();

        // Consulta para verificar si el grupo ya existe por su nombre
        String consultaExistencia = "SELECT COUNT(*) AS count FROM Grupo WHERE idGrupo = ?";
        try {
            java.sql.CallableStatement csExistencia = con.conecta().prepareCall(consultaExistencia);
            csExistencia.setString(1, generarIdGrupo(idMat, grupo, Integer.parseInt(periodo), Integer.parseInt(anio)));
            ResultSet rs = csExistencia.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "La materia ya existe en la base de datos");
                    return; // No se inserta si la materia ya existe
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al verificar existencia de la materia: " + e.toString());
            return;
        }

        // Si la materia no existe, se procede a insertarla
        String consultaInsercion = "UPDATE grupo SET hlun = ?, hmar = ?, hmie = ?, hjue = ?, "
                + "hvie = ?, slun = ?, smar = ?, smie = ?, sjue = ?, svie = ? WHERE idGrupo = ?";
        
        try {
            java.sql.CallableStatement csInsercion = con.conecta().prepareCall(consultaInsercion);
            csInsercion.setString(1, hlun);
            csInsercion.setString(2, hmar);
            csInsercion.setString(3, hmie);
            csInsercion.setString(4, hjue);
            csInsercion.setString(5, hvie);
            csInsercion.setString(6, slun);
            csInsercion.setString(7, smar);
            csInsercion.setString(8, smie);
            csInsercion.setString(9, sjue);
            csInsercion.setString(10, svie);
            csInsercion.setString(11, idGrupoC);
            
            csInsercion.execute();

            JOptionPane.showMessageDialog(null, "El grupo se actualizó exitosamente");
            DocenteGruposFrame Frame = new DocenteGruposFrame();
            Frame.setVisible(true);
            frame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el grupo: " + e.toString());
        }
    }

    public static ArrayList<String> obtenerGrupoPorIdMat(String idMat) {
        Conexion objetoConexion = new Conexion();
        Statement stmt;
        ResultSet rs;
        ArrayList<String> unidades = new ArrayList<>();

        try {
            stmt = objetoConexion.createStatement();
            rs = stmt.executeQuery("SELECT idGrupo FROM grupo WHERE idMat = '" + idMat + "'");

            while (rs.next()) {
                unidades.add(rs.getString("idGrupo"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error: "+ e.toString());
        }

        return unidades;
    }

}
