/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import com.mysql.jdbc.PreparedStatement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControladorImportarAlumnos {

    // Método para importar datos desde un archivo CSV a una tabla en la base de datos
    public void importarCSV(String nombreArchivo) {
        Conexion con = new Conexion();

        // Consulta SQL para verificar si el número de control del alumno ya existe y coincide con el idMaestro
        String consultaExistencia = "SELECT COUNT(*) FROM Alumno WHERE nControlAlum = ? AND idMaestro = ?";

        // Consulta SQL para insertar los datos en la tabla Alumno
        String sql = "INSERT INTO Alumno(nombAlum, apePatAlum, apeMatAlum, semestreAlum, fechaNacAlum, curpAlum, nControlAlum, correoAlum, idMaestro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (BufferedReader lectorCSV = new BufferedReader(new FileReader(nombreArchivo));
             PreparedStatement psConsultaExistencia = (PreparedStatement) con.prepareStatement(consultaExistencia);
             PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql)) {

            String linea;
            lectorCSV.readLine(); // Saltar la primera línea (encabezados)
            while ((linea = lectorCSV.readLine()) != null) {
                // Dividir la línea en campos utilizando la coma como delimitador
                String[] campos = linea.split(",");

                // Verificar si el número de control del alumno ya existe para el maestro especificado
                psConsultaExistencia.setString(1, campos[6]); // nControlAlum
                psConsultaExistencia.setInt(2, Integer.parseInt(campos[8].trim())); // idMaestro
                ResultSet rsExistencia = psConsultaExistencia.executeQuery();
                rsExistencia.next();
                int count = rsExistencia.getInt(1);
                rsExistencia.close();

                if (count > 0) {
                    // Si el número de control del alumno ya existe, mostrar un mensaje de advertencia y continuar con el siguiente registro
                    JOptionPane.showMessageDialog(null, "El número de control del alumno '" + campos[6] + "' ya existe para el maestro con ID '" + campos[8] + "'. Se omitirá este registro.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    continue;
                } else {
                   // Asignar los valores de los campos a los parámetros de la consulta SQL
                   ps.setString(1, campos[0]); // nombAlum
                   ps.setString(2, campos[1]); // apePatAlum
                   ps.setString(3, campos[2]); // apeMatAlum
                   ps.setInt(4, Integer.parseInt(campos[3].trim())); // semestreAlum
                   ps.setString(5, campos[4]); // fechaNacAlum
                   ps.setString(6, campos[5]); // curpAlum
                   ps.setString(7, campos[6]); // nControlAlum
                   ps.setString(8, campos[7]); // correoAlum
                   ps.setInt(9, Integer.parseInt(campos[8].trim())); // idMaestro

                   // Ejecutar la consulta SQL para insertar el registro en la tabla Alumno
                   ps.executeUpdate();

                   JOptionPane.showMessageDialog(null, "Importación completa. Los datos se han insertado en la base de datos correctamente.");   
                }
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al importar registros: " + e.toString());
        }
    }

    public void importarActCSV(String nombreArchivo) {
        Conexion con = new Conexion();

        // Consulta SQL para verificar si el número de control del alumno ya existe y coincide con el idMaestro
        String consultaExistencia = "SELECT COUNT(*) FROM Obtiene WHERE idMat = ? && idUnidad && idAlumno = ?";

        // Consulta SQL para insertar los datos en la tabla Alumno
        String sql = "INSERT INTO Alumno(idMat, idUnidad, idAlumno, califFinalUni, idMaestro) VALUES (?, ?, ?, ?, ?)";

        try (BufferedReader lectorCSV = new BufferedReader(new FileReader(nombreArchivo));
             PreparedStatement psConsultaExistencia = (PreparedStatement) con.prepareStatement(consultaExistencia);
             PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql)) {

            String linea;
            lectorCSV.readLine(); // Saltar la primera línea (encabezados)
            while ((linea = lectorCSV.readLine()) != null) {
                // Dividir la línea en campos utilizando la coma como delimitador
                String[] campos = linea.split(",");

                // Verificar si el número de control del alumno ya existe para el maestro especificado
                psConsultaExistencia.setString(1, campos[6]); // nControlAlum
                psConsultaExistencia.setInt(2, Integer.parseInt(campos[8].trim())); // idMaestro
                ResultSet rsExistencia = psConsultaExistencia.executeQuery();
                rsExistencia.next();
                int count = rsExistencia.getInt(1);
                rsExistencia.close();

                if (count > 0) {
                    // Si el número de control del alumno ya existe, mostrar un mensaje de advertencia y continuar con el siguiente registro
                    JOptionPane.showMessageDialog(null, "El número de control del alumno '" + campos[6] + "' ya existe para el maestro con ID '" + campos[8] + "'. Se omitirá este registro.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    continue;
                } else {
                   // Asignar los valores de los campos a los parámetros de la consulta SQL
                   ps.setString(1, campos[0]); // nombAlum
                   ps.setString(2, campos[1]); // apePatAlum
                   ps.setString(3, campos[2]); // apeMatAlum
                   ps.setInt(4, Integer.parseInt(campos[3].trim())); // semestreAlum
                   ps.setString(5, campos[4]); // fechaNacAlum
                   ps.setString(6, campos[5]); // curpAlum
                   ps.setString(7, campos[6]); // nControlAlum
                   ps.setString(8, campos[7]); // correoAlum
                   ps.setInt(9, Integer.parseInt(campos[8].trim())); // idMaestro

                   // Ejecutar la consulta SQL para insertar el registro en la tabla Alumno
                   ps.executeUpdate();

                   JOptionPane.showMessageDialog(null, "Importación completa. Los datos se han insertado en la base de datos correctamente.");   
                }
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al importar registros: " + e.toString());
        }
    }
}
