package Controlador;

import Conexion.Conexion;
import Modelo.ModeloAdministrador;
import Vista.Inicio_Administrador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author equipo
 */
public class ValidarLogin {

    public void validaUsuario(JFrame frame, JTextField correoMae, JTextField nControlMae){
        try {
                        
            ResultSet rs = null;
            PreparedStatement ps = null;

            Conexion objetoConexion = new Conexion();

            String consulta = "SELECT nombMae, apePatMae, apeMatMae, nControlMae, correoMae, "
                    + "idMaestro FROM Maestro WHERE nControlMae = ? AND correoMae = ?";

            ps = objetoConexion.conecta().prepareStatement(consulta);

            ps.setString(1, correoMae.getText());
            ps.setString(2, nControlMae.getText());

            rs = ps.executeQuery();
           
            if (rs.next()) {
                String maestroId = rs.getString("idMaestro");
                String correo = rs.getString("correoMae");
                String nombreMae = rs.getString("nombMae");
                String nControl = rs.getString("nControlMae");
                String pat = rs.getString("apePatMae");
                String mat = rs.getString("apeMatMae");
                System.out.println(maestroId);
                
                ControladorAlumnoAdministrador CAA = new ControladorAlumnoAdministrador();
                CAA.guardarIdMaestro(maestroId);
                
                ModeloAdministrador modelo = new ModeloAdministrador();
                modelo.guardarMaestroControlador(correo, nombreMae, nControl, pat, mat);
                
                //JOptionPane.showMessageDialog(null, "Ingresando");
                Inicio_Administrador vistaPrincipalMaestro = new Inicio_Administrador();
                //vistaPrincipalMaestro.guardarMaestro(correo, nombreMae, nControl);
                vistaPrincipalMaestro.setVisible(true);
                frame.dispose();
                
            } else {
                JOptionPane.showMessageDialog(null,"Usuario incorrecto o contraseña inválida, intente de nuevo");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR (ValidarLogin): "+e.toString());
        }
    }


    
}