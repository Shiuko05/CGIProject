/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import static Controlador.ControladorAlumnoAdministrador.getIdMaestro;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControladorExportarAlumnos {

    public void exportarCSV(String nombreArchivo) {
        Conexion con = new Conexion();

        String sql = "SELECT nombAlum, apePatAlum, apeMatAlum, semestreAlum, fechaNacAlum, curpAlum, nControlAlum, correoAlum, idMaestro FROM Alumno WHERE idMaestro = '" + getIdMaestro() + "'";
        System.out.println(sql);

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql);
             FileWriter archivoCSV = new FileWriter(nombreArchivo)) {

            // Escribir las cabeceras en el archivo CSV
            int numColumnas = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= numColumnas; i++) {
                archivoCSV.append(rs.getMetaData().getColumnName(i));
                if (i < numColumnas) {
                    archivoCSV.append(',');
                } else {
                    archivoCSV.append('\n');
                }
            }

            // Escribir los datos en el archivo CSV
            while (rs.next()) {
                for (int i = 1; i <= numColumnas; i++) {
                    archivoCSV.append(rs.getString(i));
                    if (i < numColumnas) {
                        archivoCSV.append(',');
                    } else {
                        archivoCSV.append('\n');
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Exportación completa. El archivo CSV se ha creado correctamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar registros: " + e.toString());
        }
    }
    
    public void exportarActCSV(String nombreArchivo) {
        Conexion con = new Conexion();

        String sql = "SELECT idObtiene, idMat, idUnidad, idAlumno, califFinalUni, idMaestro FROM Obtiene WHERE idMaestro = '" + getIdMaestro() + "'";
        System.out.println(sql);

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql);
             FileWriter archivoCSV = new FileWriter(nombreArchivo)) {

            // Escribir las cabeceras en el archivo CSV
            int numColumnas = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= numColumnas; i++) {
                archivoCSV.append(rs.getMetaData().getColumnName(i));
                if (i < numColumnas) {
                    archivoCSV.append(',');
                } else {
                    archivoCSV.append('\n');
                }
            }

            // Escribir los datos en el archivo CSV
            while (rs.next()) {
                for (int i = 1; i <= numColumnas; i++) {
                    archivoCSV.append(rs.getString(i));
                    if (i < numColumnas) {
                        archivoCSV.append(',');
                    } else {
                        archivoCSV.append('\n');
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Exportación completa. El archivo CSV se ha creado correctamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar registros: " + e.toString());
        }
    }
}