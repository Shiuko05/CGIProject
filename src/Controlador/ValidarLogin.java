package Controlador;

import Conexion.Conexion;
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

    public void validaUsuario(JFrame frame, JTextField usuario, JPasswordField password){
        try {
            ResultSet rs = null;
            PreparedStatement ps = null;

            Conexion objetoConexion = new Conexion();

            String consulta = "SELECT nControlAlum, paswd FROM alumno WHERE nControlAlum = ? AND paswd = ?";

            ps = objetoConexion.conecta().prepareStatement(consulta);

            String pswrd = String.valueOf(password.getPassword());

            ps.setString(1, usuario.getText());
            ps.setString(2, pswrd);

            rs = ps.executeQuery();

            if (rs.next()) {
                String tipoCuenta = rs.getString("nControlAlum");

                if (tipoCuenta.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Ingresando como administrador");
                    Inicio_Administrador vistaPrincipalMaestro = new Inicio_Administrador();
                    vistaPrincipalMaestro.setVisible(true);
                    frame.dispose();
                } else if (tipoCuenta.equals("alumno")) {
                    JOptionPane.showMessageDialog(null, "Ingresando como alumno");
                    
                }
            } else {
                JOptionPane.showMessageDialog(null,"Usuario incorrecto o contraseña inválida, intente de nuevo");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR: "+e.toString());
        }
    }


    
}