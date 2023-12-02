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
 * @author TeamPiña
 */
public class DBTables {

    public void createTables(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();

            statement.executeUpdate("USE CGIDataBase");

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
                                   correoAlum VARCHAR(20),
                                   fotoAlum BLOB, 
                                   paswd INT);""";
            statement.execute(sqlAlumnTable);

            String sqlMaeTable = """
                                 CREATE TABLE IF NOT EXISTS Profesor (
                                 idProfesor INT PRIMARY KEY AUTO_INCREMENT, 
                                 nombProf VARCHAR(30) NOT NULL, 
                                 apePatProf VARCHAR(30), 
                                 apeMatProf VARCHAR(30), 
                                 fechaNacProf DATE, 
                                 nControlProf VARCHAR(9), 
                                 correoProf VARCHAR(20),
                                 fotoProf BLOB, 
                                 paswd INT);""";
            statement.execute(sqlMaeTable);
            
            String sqlMatTable = """
                                CREATE TABLE IF NOT EXISTS Materia (
                                idMat VARCHAR(3) PRIMARY KEY,
                                nombMat VARCHAR(40),
                                hTeoMat INT,
                                hPraMat INT,
                                CHECK (LENGTH(idMat) = 3)
                                )""";
            statement.execute(sqlMatTable);
            
            String sqlGruTable = """
                                 CREATE TABLE IF NOT EXISTS Grupo (
                                 idGrupo VARCHAR(9) PRIMARY KEY,
                                 idMat VARCHAR(3),
                                 grupo VARCHAR(1),
                                 periodo VARCHAR(1),
                                 anio VARCHAR(4),
                                 FOREIGN KEY (idMat) REFERENCES Materia(idMat) ON DELETE CASCADE);""";
            statement.execute(sqlGruTable);
            
            String sqlInsTable = """
                                 CREATE TABLE IF NOT EXISTS Inscribe (
                                 idInscribe INT PRIMARY KEY AUTO_INCREMENT,
                                 IdAlumno INT,
                                 idGrupo VARCHAR(9),
                                 califFinal INT,
                                 tipoEval VARCHAR(1),
                                 repite VARCHAR(1),
                                 FOREIGN KEY (idAlumno) REFERENCES Alumno(idAlumno) ON DELETE CASCADE,
                                 FOREIGN KEY (idGrupo) REFERENCES Grupo(idGrupo) ON DELETE CASCADE);""";
            statement.execute(sqlInsTable);
            
        } catch(SQLException error){
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
}
