/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author usuario
 */
public class DBTables {

    public void createTables(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();

            statement.executeUpdate("USE CGIDataBase");
            
            String sqlMaeTable = """
                                 CREATE TABLE IF NOT EXISTS Maestro (
                                 idMaestro INT PRIMARY KEY AUTO_INCREMENT,
                                 nombMae VARCHAR(30) NOT NULL,
                                 nControlMae VARCHAR(9),
                                 apePatMae VARCHAR(30),
                                 apeMatMae VARCHAR(30),
                                 paswd VARCHAR(20));""";
            statement.execute(sqlMaeTable);

            String sqlAlumnTable = """
                                   CREATE TABLE IF NOT EXISTS Alumno (
                                   idAlumno INT PRIMARY KEY AUTO_INCREMENT, 
                                   nombAlum VARCHAR(30) NOT NULL, 
                                   apePatAlum VARCHAR(30), 
                                   apeMatAlum VARCHAR(30), 
                                   semestreAlum INT, 
                                   fechaNacAlum DATE, 
                                   curpAlum VARCHAR(18), 
                                   nControlAlum VARCHAR(9), 
                                   correoAlum VARCHAR(80),
                                   paswd INT,
                                   idMaestro INT,
                                   FOREIGN KEY (idMaestro) REFERENCES Maestro(idMaestro) ON DELETE CASCADE);""";
            statement.execute(sqlAlumnTable);

            String sqlMatTable = """
                                CREATE TABLE IF NOT EXISTS Materia (
                                idMat VARCHAR(3) PRIMARY KEY,
                                nombMat VARCHAR(40),
                                hTeoMat INT,
                                hPraMat INT,
                                CHECK (LENGTH(idMat) = 3),
                                idMaestro INT,
                                FOREIGN KEY (idMaestro) REFERENCES Maestro(idMaestro) ON DELETE CASCADE);""";
            statement.execute(sqlMatTable);

            String sqlGruTable = """
                                 CREATE TABLE IF NOT EXISTS Grupo (
                                 idGrupo VARCHAR(9) PRIMARY KEY,
                                 idMat VARCHAR(3),
                                 grupo VARCHAR(1),
                                 periodo VARCHAR(1),
                                 anio VARCHAR(4),
                                 hlun VARCHAR(11),
                                 hmar VARCHAR(11),
                                 hmie VARCHAR(11),
                                 hjue VARCHAR(11),
                                 hvie VARCHAR(11),
                                 slun VARCHAR(8),
                                 smar VARCHAR(8),
                                 smie VARCHAR(8),
                                 sjue VARCHAR(8),
                                 svie VARCHAR(8),
                                 idMaestro INT,
                                 FOREIGN KEY (idMat) REFERENCES Materia(idMat) ON DELETE CASCADE,
                                 FOREIGN KEY (idMaestro) REFERENCES Maestro(idMaestro) ON DELETE CASCADE);""";
            statement.execute(sqlGruTable);

            String sqlInsTable = """
                                 CREATE TABLE IF NOT EXISTS Inscribe (
                                 idInscribe INT PRIMARY KEY AUTO_INCREMENT,
                                 IdAlumno INT,
                                 idGrupo VARCHAR(9),
                                 califFinal INT,
                                 tipoEval VARCHAR(1),
                                 repite VARCHAR(1),
                                 idMaestro INT,
                                 FOREIGN KEY (idMaestro) REFERENCES Maestro(idMaestro) ON DELETE CASCADE,
                                 FOREIGN KEY (idAlumno) REFERENCES Alumno(idAlumno) ON DELETE CASCADE,
                                 FOREIGN KEY (idGrupo) REFERENCES Grupo(idGrupo) ON DELETE CASCADE);""";
            statement.execute(sqlInsTable);
            
            String sqlActTable = """
                                 CREATE TABLE IF NOT EXISTS Actividad (
                                 idActividad INT PRIMARY KEY AUTO_INCREMENT,
                                 tituloAct VARCHAR(30) NOT NULL,
                                 tipoAct VARCHAR(20),
                                 descAct VARCHAR(100),
                                 califAsigAct INT,
                                 fechaEntAct DATE,
                                 pesoAct INT,
                                 idMaestro INT,
                                 FOREIGN KEY (idMaestro) REFERENCES Maestro(idMaestro) ON DELETE CASCADE);""";
            statement.execute(sqlActTable);
            
            String sqlUniTable = """                                 
                                 CREATE TABLE IF NOT EXISTS Unidad (
                                 idUnidad VARCHAR(4) PRIMARY KEY,
                                 idMat VARCHAR(3),
                                 numUni INT,
                                 tituloUni VARCHAR(45),
                                 descUni VARCHAR(250),
                                 hprog INT,
                                 idMaestro INT,
                                 FOREIGN KEY (idMaestro) REFERENCES Maestro(idMaestro) ON DELETE CASCADE,
                                 FOREIGN KEY (idMat) REFERENCES Materia(idMat) ON DELETE CASCADE);""";
            statement.execute(sqlUniTable);
            
            String sqlRealizaTable = """
                                     CREATE TABLE IF NOT EXISTS Realiza (
                                     idRealiza INT PRIMARY KEY AUTO_INCREMENT,
                                     idActividad INT,
                                     idMat VARCHAR(3),
                                     idUnidad VARCHAR(4),
                                     idAlumno INT,
                                     califObtAlum INT,
                                     observa VARCHAR(100),
                                     idMaestro INT,
                                     FOREIGN KEY (idMaestro) REFERENCES Maestro(idMaestro) ON DELETE CASCADE,
                                     FOREIGN KEY (idActividad) REFERENCES Actividad(idActividad) ON DELETE CASCADE,
                                     FOREIGN KEY (idMat) REFERENCES Materia(idMat) ON DELETE CASCADE,
                                     FOREIGN KEY (idUnidad) REFERENCES Unidad(idUnidad) ON DELETE CASCADE,
                                     FOREIGN KEY (idAlumno) REFERENCES Alumno(idAlumno) ON DELETE CASCADE);""";
            statement.execute(sqlRealizaTable);
            
            String sqlObtieneTable = """
                                     CREATE TABLE IF NOT EXISTS Obtiene (
                                     idObtiene INT PRIMARY KEY AUTO_INCREMENT,
                                     idMat VARCHAR(3),
                                     idUnidad VARCHAR(4),
                                     idAlumno INT,
                                     califFinalUni INT,
                                     idMaestro INT,
                                     FOREIGN KEY (idMaestro) REFERENCES Maestro(idMaestro) ON DELETE CASCADE,
                                     FOREIGN KEY (idMat) REFERENCES Materia(idMat) ON DELETE CASCADE,
                                     FOREIGN KEY (idUnidad) REFERENCES Unidad(idUnidad) ON DELETE CASCADE,
                                     FOREIGN KEY (idAlumno) REFERENCES Alumno(idAlumno) ON DELETE CASCADE);""";
            statement.execute(sqlObtieneTable);
            
        } catch (SQLException error) {
            System.out.println("Error al crear las tablas: " + error.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException error) {
                System.out.println("Error al cerrar el statement: " + error.getMessage());
            }
        }
    }
    
//    public void crearMaestro() {
//        Conexion con = new Conexion();
//        String consultaVerificacion = "SELECT COUNT(*) FROM Maestro WHERE idMaestro = ?";
//        String consultaInsercion = "INSERT INTO Maestro(idMaestro, nombMae, nControlMae, paswd) VALUES (?, ?, ?, ?)";
//
//        try {
//            PreparedStatement psVerificacion = con.conecta().prepareStatement(consultaVerificacion);
//            psVerificacion.setInt(1, 1); // Cambiar "admin" por el valor que deseas verificar
//            ResultSet rs = psVerificacion.executeQuery();
//            rs.next();
//            int count = rs.getInt(1);
//
//            if (count > 0) {
//                // El usuario ya existe
//            } else {
//                PreparedStatement psInsercion = con.conecta().prepareStatement(consultaInsercion);
//                psInsercion.setInt(1, 1);
//                psInsercion.setString(2, "administrador");
//                psInsercion.setString(3, "admin");
//                psInsercion.setInt(4, 12345);
//
//                int filasAfectadas = psInsercion.executeUpdate();
//
//                if (filasAfectadas > 0) {
//                    JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Error al crear usuario");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error al crear usuario");
//        }
//    }


}