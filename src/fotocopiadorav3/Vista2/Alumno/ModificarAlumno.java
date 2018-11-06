/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista2.Alumno;

import Otros.TextPrompt;
import fotocopiadorav3.Modelo.Alumno;
import fotocopiadorav3.Modelo.ModeloInterfaz;
import fotocopiadorav3.Vista2.Vista2Interfaz;

/**
 *
 * @author Toshiba
 */
public class ModificarAlumno extends javax.swing.JFrame {
    
    private int idAlumno;
    /**
     * Creates new form ModificarAlumno
     */
    public ModificarAlumno() {
        
        initComponents();
        
        TextPrompt textPromptNombre = new TextPrompt("Ingrese su nombre", nombreTF);
        TextPrompt textPromptApellido = new TextPrompt("Ingrese su apellido", apellidoTF);
        TextPrompt textPromptLegajo = new TextPrompt("Ingrese su legajo", legajoTF);
        TextPrompt textPromptDomicilio = new TextPrompt("Ingrese su domicilio actual", domicilioTF);
        TextPrompt textPromptAltura = new TextPrompt("Ingrese la altura de su domicilio", alturaTF);
        TextPrompt textPromptDni = new TextPrompt("Ingrese su número de documento", dniTF);
        
        cargarDatosAlumno(idAlumno);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        limpiarCampos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombreTF = new javax.swing.JTextField();
        apellidoTF = new javax.swing.JTextField();
        domicilioTF = new javax.swing.JTextField();
        legajoTF = new javax.swing.JTextField();
        dniTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        alturaTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nuevo Alumno");

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        limpiarCampos.setText("Limpiar Campos");
        limpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarCamposActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Legajo:");

        jLabel6.setText("Domicilio:");

        jLabel7.setText("Dni:");

        nombreTF.setToolTipText("Ingrese su nombre");

        apellidoTF.setToolTipText("Ingrese su apellido");

        domicilioTF.setToolTipText("Ingrese su domicilio actual");

        legajoTF.setToolTipText("Ingrese su legajo");

        dniTF.setToolTipText("Ingrese su número de documento");

        jLabel8.setText("N°:");

        alturaTF.setToolTipText("Ingrese la altura de su domicilio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(limpiarCampos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(domicilioTF, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(alturaTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(dniTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(apellidoTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(nombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(legajoTF)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(apellidoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(legajoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(domicilioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(alturaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dniTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(limpiarCampos))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed

        String nombre=nombreTF.getText();
        String apellido=apellidoTF.getText();
        String legajo=legajoTF.getText();
        String domicilio=domicilioTF.getText();
        String altura=alturaTF.getText();
        String dni=dniTF.getText();

        Vista2Interfaz.enviarDatosModificarAlumno(nombre, apellido, legajo, domicilio, altura, dni);
    }//GEN-LAST:event_aceptarActionPerformed

    private void limpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarCamposActionPerformed

        nombreTF.setText("");
        apellidoTF.setText("");
        legajoTF.setText("");
        domicilioTF.setText("");
        alturaTF.setText("");
        dniTF.setText("");
        
    }//GEN-LAST:event_limpiarCamposActionPerformed
    
    public void cargarDatosAlumno(int idAlumno){
        
        Alumno alumno = ModeloInterfaz.getAlumnoForId(idAlumno);
        
        //Verificar la existencia de todos los argumentos
        String nombre = alumno.getPersona().getNombre().toString();
        String apellido = alumno.getPersona().getApellido().toString();
        
        if(nombre != null){
            
            nombreTF.setText(nombre);
            
        }
        
        if(apellido != null){
            
            apellidoTF.setText(apellido);
        }
        
        //legajoTF.setText(Integer.toString(alumno.getLegajo()));
        //domicilioTF.setText(alumno.getPersona().getDireccion().getCalle().toString());
        //alturaTF.setText(Integer.toString(alumno.getPersona().getDireccion().getNumero()));
        //dniTF.setText(Integer.toString(alumno.getPersona().getDni()));
        
    }
    
    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModificarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JTextField alturaTF;
    private javax.swing.JTextField apellidoTF;
    private javax.swing.JTextField dniTF;
    private javax.swing.JTextField domicilioTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField legajoTF;
    private javax.swing.JButton limpiarCampos;
    private javax.swing.JTextField nombreTF;
    // End of variables declaration//GEN-END:variables
}
