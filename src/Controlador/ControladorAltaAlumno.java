/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author ERIKA GARCIA
 */
public class ControladorAltaAlumno {
    
    String nombAlum;
    String apellidopatalum;
    String apellidomatalum;
    int semestrealum;
    String fechanacimientoalum; 
    String curp;
    String numcontrol;
    String correo;
    
    ControladorGruposAdministrador cga = new ControladorGruposAdministrador();
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getNombAlum() {
        return nombAlum;
    }

    public void setNombAlum(String nombAlum) {
        this.nombAlum = nombAlum;
    }

    public String getApellidopatalum() {
        return apellidopatalum;
    }

    public void setApellidopatalum(String apellidopatalum) {
        this.apellidopatalum = apellidopatalum;
    }

    public String getApellidomatalum() {
        return apellidomatalum;
    }

    public void setApellidomatalum(String apellidomatalum) {
        this.apellidomatalum = apellidomatalum;
    }

    public int getSemestrealum() {
        return semestrealum;
    }

    public void setSemestrealum(int semestrealum) {
        this.semestrealum = semestrealum;
    }

    public String getFechanacimientoalum() {
        return fechanacimientoalum;
    }

    public void setFechanacimientoalum(String fechanacimientoalum) {
        this.fechanacimientoalum = fechanacimientoalum;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNumcontrol() {
        return numcontrol;
    }

    public void setNumcontrol(String numcontrol) {
        this.numcontrol = numcontrol;
    }
   
     public void insertarAlumno(JTextField jTextField2, JTextField jTextField4, JTextField jTextField3, JTextField jTextField5, JTextField jTextField6, JTextField jTextField7, 
             JTextField jTextField8, JTextField jTextField9) {
        setNombAlum(jTextField2.getText());
        setApellidopatalum(jTextField4.getText());   
        setApellidomatalum(jTextField3.getText());
        setSemestrealum(Integer.parseInt(jTextField7.getText()));
        setFechanacimientoalum(jTextField8.getText());   
        setCurp(jTextField5.getText());
        setNumcontrol(jTextField6.getText());
        setCorreo(jTextField9.getText());
        Conexion con = new Conexion();

        // Verificar si el número de control ya existe en la base de datos
        String consultaExistencia = "SELECT COUNT(*) AS count FROM alumno WHERE nControlAlum = ?";
        try {
            CallableStatement csExistencia = con.conecta().prepareCall(consultaExistencia);
            csExistencia.setString(1, getNumcontrol());
            ResultSet rs = csExistencia.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "El número de control ya existe en la base de datos");
                    return; // No se inserta si el número de control ya existe
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al verificar existencia del número de control: " + e.toString());
            return;
        }

        // Si el número de control no existe, se procede a insertar el alumno
        String consultaInsercion = "INSERT INTO alumno (nombAlum, apePatAlum, apeMatAlum, semestreAlum, fechaNacAlum, curpAlum, nControlAlum, correoAlum) VALUES (?,?,?,?,?,?,?,?);";
        try {
            CallableStatement csInsercion = con.conecta().prepareCall(consultaInsercion);
            csInsercion.setString(1, getNombAlum());
            csInsercion.setString(2, getApellidopatalum());       
            csInsercion.setString(3, getApellidomatalum());   
            csInsercion.setInt(4, getSemestrealum());   
            csInsercion.setString(5, getFechanacimientoalum());   
            csInsercion.setString(6, getCurp());   
            csInsercion.setString(7, getNumcontrol());  
            csInsercion.setString(8, getCorreo());

            csInsercion.execute();

            JOptionPane.showMessageDialog(null, "El alumno se agregó exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar: " + e.toString());
        }
    }

     
     public void eliminarAlumno(JTextField ptxtncontrol){
         setNumcontrol(ptxtncontrol.getText());
         
         
        Conexion con = new Conexion();
        String consulta = "DELETE FROM alumno WHERE alumno.nControlAlum = ?;";
        
        try {
            CallableStatement cs = con.conecta().prepareCall(consulta);
            cs.setString(1, getNumcontrol());
            
            cs.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se eliminó, error: "+e.toString());
        }
    }
     
     
}
