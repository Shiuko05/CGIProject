package Modelo;

import Conexion.Conexion;
import Vista.Login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloAdministrador {
    private String nomProfesor;
    private String apePatProf;
    private String apeMatProf;
    private String nControlProf;
    private String correoProf;

    public String getNomProfesor() {
        return nomProfesor;
    }

    public void setNomProfesor(String nomProfesor) {
        this.nomProfesor = nomProfesor;
    }

    public String getApePatProf() {
        return apePatProf;
    }

    public void setApePatProf(String apePatProf) {
        this.apePatProf = apePatProf;
    }

    public String getApeMatProf() {
        return apeMatProf;
    }

    public void setApeMatProf(String apeMatProf) {
        this.apeMatProf = apeMatProf;
    }

    public String getnControlProf() {
        return nControlProf;
    }

    public void setnControlProf(String nControlProf) {
        this.nControlProf = nControlProf;
    }

    public String getCorreoProf() {
        return correoProf;
    }

    public void setCorreoProf(String correoProf) {
        this.correoProf = correoProf;
    }


    public void obtenerDatosProfesor() throws SQLException {
        ResultSet rs = null;
        PreparedStatement ps = null;

        Conexion objetoConexion = new Conexion();

        // Crear una instancia de la clase Login
        Login login = new Login();
        
        String consulta = "select * from profesor where nControlProf = (?);";

        ps = objetoConexion.conecta().prepareStatement(consulta);
        ps.setString(1, login.jTextField1.getText());

        rs = ps.executeQuery();

        if (rs.next()) {
            setnControlProf(rs.getString("nControlProf"));
            setNomProfesor(rs.getString("nombProf"));
            setApePatProf(rs.getString("apePatProf"));
            setApeMatProf(rs.getString("apeMatProf"));
            setCorreoProf(rs.getString("correoProf"));
        }
    }
}
