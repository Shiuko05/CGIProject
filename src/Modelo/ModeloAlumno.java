package Modelo;

import Conexion.Conexion;
import Vista.Login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloAlumno {

    private int idAlumno;
    private String nomAlum;
    private String apePatAlum;
    private String apeMatAlum;
    private int semestreAlum;

    private String nControlAlum;
    private String correoAlum;

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNomAlum() {
        return nomAlum;
    }

    public void setNomAlum(String nomAlum) {
        this.nomAlum = nomAlum;
    }

    public String getApePatAlum() {
        return apePatAlum;
    }

    public void setApePatAlum(String apePatAlum) {
        this.apePatAlum = apePatAlum;
    }

    public String getApeMatAlum() {
        return apeMatAlum;
    }

    public void setApeMatAlum(String apeMatAlum) {
        this.apeMatAlum = apeMatAlum;
    }

    public int getSemestreAlum() {
        return semestreAlum;
    }

    public void setSemestreAlum(int semestreAlum) {
        this.semestreAlum = semestreAlum;
    }

    public String getnControlAlum() {
        return nControlAlum;
    }

    public void setnControlAlum(String nControlAlum) {
        this.nControlAlum = nControlAlum;
    }

    public String getCorreoAlum() {
        return correoAlum;
    }

    public void setCorreoAlum(String correoAlum) {
        this.correoAlum = correoAlum;
    }

    public void obtenerDatosAlumno() throws SQLException {
        ResultSet rs = null;
        PreparedStatement ps = null;

        Conexion objetoConexion = new Conexion();

        String consulta = "select * from alumno where nControlAlum = (?);";


        // Crear una instancia de la clase Login
        Login login = new Login();

        ps = objetoConexion.conecta().prepareStatement(consulta);

        // Acceder a jTextField1 a través de la instancia de Login
        ps.setString(1, login.jTextField1.getText());

        rs = ps.executeQuery();

        if (rs.next()) {
            setnControlAlum(rs.getString("nControlAlum"));
            setNomAlum(rs.getString("nombAlum"));
            setApePatAlum(rs.getString("apePatAlum"));
            setApeMatAlum(rs.getString("apeMatAlum"));
            setCorreoAlum(rs.getString("correoAlum"));
            setSemestreAlum(rs.getInt("semestreAlum"));
        }
    }

}
