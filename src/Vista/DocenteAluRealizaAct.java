/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorActAdministrador;
import Controlador.ControladorAltaAct;
import Controlador.ControladorAltaAlumno;
import Controlador.ControladorAltaUnidad;
import Controlador.ControladorAlumnoAdministrador;
import Controlador.ControladorExportarAlumnos;
import Controlador.ControladorGruposAdministrador;
import Controlador.ControladorImportarAlumnos;
import Controlador.ControladorMatAdministrador;
import Controlador.ControladorRealizaActividad;
import Controlador.ControladorUnidadesAdministrador;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Usuario
 */
public class DocenteAluRealizaAct extends javax.swing.JFrame {

    /**
     * Creates new form DocenteAltaAct
     */
    public DocenteAluRealizaAct() {
        initComponents();
        llenarMaterias();
        llenarAlumnos();
        llenarActividades();
    }
    
    private void llenarMaterias(){
        ControladorGruposAdministrador grupos = new ControladorGruposAdministrador();
        ArrayList<ControladorMatAdministrador> listaMateria = grupos.getIdMat();
        jComboBox2.removeAllItems();
        
        for(int i = 0; i < listaMateria.size(); i++){
            jComboBox2.addItem(listaMateria.get(i).getIdMat());
        }
    }
    
    private void llenarAlumnos(){
        ControladorAlumnoAdministrador alumno = new ControladorAlumnoAdministrador();
        ArrayList<ControladorAltaAlumno> listanControl = alumno.getNumcontrol();
        jComboBox4.removeAllItems();
        
        for(int i = 0; i < listanControl.size(); i++){
            jComboBox4.addItem(listanControl.get(i).getNumcontrol());
        }
    }
    
    private void llenarActividades(){
        ControladorActAdministrador actividad = new ControladorActAdministrador();
        ArrayList<ControladorAltaAct> listaAct = actividad.getTituloAct();
        jComboBox1.removeAllItems();
        
        for(int i = 0; i < listaAct.size(); i++){
            jComboBox1.addItem(listaAct.get(i).getTituloAct());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(36, 47, 155));
        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Inicio");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 21, 125, 32));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 6, -1, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 70));

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(720, 450));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Calificar Actividad");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 23, 240, -1));

        jTextField2.setBackground(new java.awt.Color(245, 245, 245));
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 138, 166)));
        jTextField2.setPreferredSize(new java.awt.Dimension(316, 36));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 83, -1, 259));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Actividad");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 130, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Observaciones");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 62, -1, -1));

        jComboBox1.setBackground(new java.awt.Color(245, 245, 245));
        jComboBox1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 138, 166)));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 142, 36));

        jButton1.setBackground(new java.awt.Color(36, 47, 155));
        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Guardar");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(566, 398, 125, 32));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Materia");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 130, -1));

        jComboBox2.setBackground(new java.awt.Color(245, 245, 245));
        jComboBox2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 138, 166)));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 142, 36));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Unidad");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, -1));

        jComboBox3.setBackground(new java.awt.Color(245, 245, 245));
        jComboBox3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 138, 166)));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 142, 36));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Alumno");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 130, -1));

        jComboBox4.setBackground(new java.awt.Color(245, 245, 245));
        jComboBox4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 138, 166)));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 142, 36));

        jTextField1.setBackground(new java.awt.Color(245, 245, 245));
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 138, 166)));
        jTextField1.setPreferredSize(new java.awt.Dimension(316, 36));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 142, -1));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Calificación");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 150, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 640));

        jMenuBar2.setBackground(new java.awt.Color(0, 51, 153));

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Alumnos");

        jMenuItem12.setText("Lista alumnos");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuItem1.setText("Alta alumno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem10.setText("Editar alumno");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem9.setText("Eliminar alumno");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem30.setText("Exportar Alumnos");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem30);

        jMenuItem31.setText("Importar Alumnos");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem31);

        jMenuBar2.add(jMenu3);

        jMenu4.setForeground(new java.awt.Color(255, 255, 255));
        jMenu4.setText("Materias");

        jMenuItem8.setText("Lista materias");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem2.setText("Alta materia");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem23.setText("Editar materia");
        jMenuItem23.setToolTipText("");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem23);

        jMenuItem22.setText("Eliminar materia");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem22);

        jMenu6.setText("Unidades");

        jMenuItem14.setText("Lista unidades");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem14);

        jMenuItem29.setText("Alta unidad");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem29);

        jMenuItem15.setText("Editar unidad");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem15);

        jMenuItem24.setText("Eliminar unidad");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem24);

        jMenu8.setText("Calificaciones");

        jMenuItem25.setText("Lista calificaciones");
        jMenu8.add(jMenuItem25);

        jMenuItem26.setText("Obtener calificaciones");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem26);

        jMenuItem27.setText("Editar calificaciones");
        jMenu8.add(jMenuItem27);

        jMenuItem28.setText("Eliminar calificaciones");
        jMenu8.add(jMenuItem28);

        jMenu6.add(jMenu8);

        jMenu4.add(jMenu6);

        jMenu5.setText("Grupos");

        jMenuItem13.setText("Lista grupos");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);

        jMenuItem6.setText("Alta grupo");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuItem19.setText("Editar grupo");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem19);

        jMenuItem20.setText("Eliminar grupo");
        jMenu5.add(jMenuItem20);

        jMenu7.setText("Asignados");

        jMenuItem3.setText("Asignar alumno");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem3);

        jMenuItem18.setText("Editar alumno asignado");
        jMenu7.add(jMenuItem18);

        jMenuItem21.setText("Eliminar alumno asignado");
        jMenu7.add(jMenuItem21);

        jMenu5.add(jMenu7);

        jMenu4.add(jMenu5);

        jMenuItem5.setText("Horario");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar2.add(jMenu4);

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Actividades");

        jMenuItem16.setText("Lista actividades");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem16);

        jMenuItem4.setText("Alta actividad");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem7.setText("Editar actividad");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem11.setText("Eliminar actividad");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuItem17.setText("Calificar actividad");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem17);

        jMenuBar2.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Utilerías");
        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);
        //jMenuBar2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        jMenuBar2.setLayout(new FlowLayout(FlowLayout.CENTER, 10,4));

        // Configurar espacio a la izquierda y derecha de cada menú
        jMenu3.setBorder(new EmptyBorder(0, 10, 0, 10));
        jMenu4.setBorder(new EmptyBorder(0, 10, 0, 10));
        jMenu1.setBorder(new EmptyBorder(0, 10, 0, 10));
        jMenu2.setBorder(new EmptyBorder(0, 10, 0, 10));

        Font menuFont = new Font("Arial Rounded MT", Font.BOLD, 14);
        jMenu3.setFont(menuFont);
        jMenu4.setFont(menuFont);
        jMenu1.setFont(menuFont);
        jMenu2.setFont(menuFont);

        // Agregar menús a la barra de menú
        jMenuBar2.add(jMenu3);
        jMenuBar2.add(jMenu4);
        jMenuBar2.add(jMenu1);
        jMenuBar2.add(jMenu2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ControladorRealizaActividad CRA = new ControladorRealizaActividad();
        CRA.calificarActAlumno(this, jComboBox1, jComboBox2, jComboBox3, jComboBox4, jTextField1, jTextField2);
//        DocenteUnidadesAluFrame Frame = new DocenteUnidadesAluFrame();
//        Frame.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Inicio_Administrador Frame = new Inicio_Administrador();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        String idMatSeleccionado = (String) jComboBox2.getSelectedItem();

        if (idMatSeleccionado != null) {
            // Obtener las unidades asociadas a ese idMat desde ControladorAltaUnidad
            ArrayList<Integer> unidades = ControladorRealizaActividad.obtenerUnidadesPorIdMat(idMatSeleccionado);

            // Limpiar el jComboBox3
            jComboBox3.removeAllItems();

            // Llenar el jComboBox3 con las unidades obtenidas
            for (Integer unidad : unidades) {
                jComboBox3.addItem(String.valueOf(unidad));
            }
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        DocenteAlumnosFrame Frame = new DocenteAlumnosFrame();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DocenteAltaAlumno Frame = new DocenteAltaAlumno();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        DocenteEditarAlumno Frame = new DocenteEditarAlumno();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        DocenteEliminarAlumno Frame = new DocenteEliminarAlumno();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        DocenteMateriasFrame Frame = new DocenteMateriasFrame();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        DocenteAltaMatFrame Frame = new DocenteAltaMatFrame();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        // TODO add your handling code here:
        DocenteEditarMat Frame = new DocenteEditarMat();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        // TODO add your handling code here:
        DocenteEliminarMat Frame = new DocenteEliminarMat();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        DocenteUnidadesFrame Frame = new DocenteUnidadesFrame();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        // TODO add your handling code here:
        DocenteAltaUnidad Frame = new DocenteAltaUnidad();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        DocenteEditarUnidad Frame = new DocenteEditarUnidad();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        // TODO add your handling code here:
        DocenteEliminarUnidad Frame = new DocenteEliminarUnidad();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        // TODO add your handling code here:
        DocenteAltaCalifUnidad Frame = new DocenteAltaCalifUnidad();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        DocenteGruposFrame Frame = new DocenteGruposFrame();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        DocenteAltaGrupo Frame = new DocenteAltaGrupo();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        DocenteEditarGrupo Frame = new DocenteEditarGrupo();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        DocenteAsignaAlumno Frame = new DocenteAsignaAlumno();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        DocenteHorarioGrupos Frame = new DocenteHorarioGrupos();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        DocenteActividadesFrame Frame = new DocenteActividadesFrame();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        DocenteAltaAct Frame = new DocenteAltaAct();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        DocenteEditarAct Frame = new DocenteEditarAct();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        DocenteEliminarAct Frame = new DocenteEliminarAct();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        DocenteAluRealizaAct Frame = new DocenteAluRealizaAct();
        Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        // TODO add your handling code here:
        ControladorExportarAlumnos exportar = new ControladorExportarAlumnos();
        exportar.exportarCSV("datos.csv");
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        // TODO add your handling code here:
        ControladorImportarAlumnos controlador = new ControladorImportarAlumnos();
        controlador.importarCSV("datos.csv");
    }//GEN-LAST:event_jMenuItem31ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
