package Modelo;

import Conexion.Conexion;
import Controlador.ControladorMatAdministrador;
import Vista.Inicio_Administrador;
import Vista.Login;
import com.mysql.jdbc.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ModeloAdministrador {
   
    private static String mCorreoMae;
    private static String mNombMae;
    private static String mNControlMae;
    private static String mPat;
    private static String mMat;

    public static String getmPat() {
        return mPat;
    }

    public static void setmPat(String mPat) {
        ModeloAdministrador.mPat = mPat;
    }

    public static String getmMat() {
        return mMat;
    }

    public static void setmMat(String mMat) {
        ModeloAdministrador.mMat = mMat;
    }
    

    public static String getMCorreoMae() {
        return mCorreoMae;
    }

    public static void setMCorreoMae(String correoMae) {
        mCorreoMae = correoMae;
    }
    
    public static String getmNombMae() {
        return mNombMae;
    }

    public static void setmNombMae(String mNombMae) {
        ModeloAdministrador.mNombMae = mNombMae;
    }

    public static String getmNControlMae() {
        return mNControlMae;
    }

    public static void setmNControlMae(String mNControlMae) {
        ModeloAdministrador.mNControlMae = mNControlMae;
    }
    
    public void guardarMaestroControlador(String correo, String nombreMae, String nControl, String pat, String mat) {
        setMCorreoMae(correo);
        setmNombMae(nombreMae);
        setmNControlMae(nControl);
        setmPat(pat);
        setmMat(mat);
    }
    
//    public void obtenerDatosProfesor(JTextField correoMae) {
//
//        String correo = correoMae.getText();
//        Conexion con = new Conexion();
//        
//        try {
//            String consulta = "select nombMae, nControlMae, apePatMae, apeMatMae, correoMae from Maestro where correoMae = '"+correo+"'";
//            
//            java.sql.Statement stmt = con.conecta().createStatement();
//            ResultSet rs = stmt.executeQuery(consulta);
//
//            if (rs.next()) {
//                // Verificar si el ResultSet tiene datos antes de recuperarlos
//                String nombMae = rs.getString("nombMae");
//                String nControlMae = rs.getString("nControlMae");
//                String apePatMae = rs.getString("apePatMae");
//                String apeMatMae = rs.getString("apeMatMae");
//                String correoMaestro = rs.getString("correoMae");
//
//                // Llamar al método guardarMaestro con los datos recuperados
//                Inicio_Administrador inicio = new Inicio_Administrador();
//                inicio.guardarMaestro(nombMae, nControlMae, apePatMae, apeMatMae, correoMaestro);
//                System.out.println(nombMae);
//            } else {
//                JOptionPane.showMessageDialog(null, "No se encontró ningún maestro con el correo proporcionado.");
//            }
//        } catch(SQLException e){
//            JOptionPane.showMessageDialog(null,"error: "+ e.toString());
//        }
//    }

 
}
