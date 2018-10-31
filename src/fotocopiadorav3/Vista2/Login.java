/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista2;

import Otros.TextPrompt;

/**
 *
 * @author claudio
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
        TextPrompt textPromptUsuario = new TextPrompt("Ingrese su nombre de Usuario", jTextFieldUsuario);
        TextPrompt textPromptContrasenia = new TextPrompt("Ingrese su contraseña", jPasswordField1);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImagenPortada = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldUsuario = new javax.swing.JTextField();
        Titulo = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabelUsuario1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImagenPortada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fade.jpg"))); // NOI18N
        getContentPane().add(ImagenPortada, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setText("WASD CopyShop");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jPanel1.setBackground(new java.awt.Color(16, 16, 16));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldUsuario.setBackground(new java.awt.Color(16, 16, 16));
        jTextFieldUsuario.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jTextFieldUsuario.setForeground(new java.awt.Color(102, 0, 153));
        jTextFieldUsuario.setToolTipText("Ingrese su nombre de usuario");
        jPanel1.add(jTextFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 260, 40));

        Titulo.setFont(new java.awt.Font("Arial Black", 2, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(102, 0, 153));
        Titulo.setText("WASD CopyShop");
        jPanel1.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 230, -1));

        jLabelPassword.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(102, 0, 153));
        jLabelPassword.setText("Cotraseña");
        jPanel1.add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jButtonCancelar.setBackground(new java.awt.Color(42, 16, 16));
        jButtonCancelar.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(102, 0, 153));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jButtonAceptar.setBackground(new java.awt.Color(42, 16, 16));
        jButtonAceptar.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jButtonAceptar.setForeground(new java.awt.Color(102, 0, 153));
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.setMaximumSize(new java.awt.Dimension(100, 28));
        jButtonAceptar.setMinimumSize(new java.awt.Dimension(100, 28));
        jButtonAceptar.setPreferredSize(new java.awt.Dimension(100, 28));
        jButtonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonAceptarMousePressed(evt);
            }
        });
        jPanel1.add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        jPasswordField1.setBackground(new java.awt.Color(16, 16, 16));
        jPasswordField1.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(102, 0, 153));
        jPasswordField1.setToolTipText("Ingrese su contraseña");
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 260, 40));

        jLabelUsuario1.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jLabelUsuario1.setForeground(new java.awt.Color(102, 0, 153));
        jLabelUsuario1.setText("Usuario");
        jPanel1.add(jLabelUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 300, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceptarMousePressed
        
        String usuario = jTextFieldUsuario.getText();
        String contrasenia = jPasswordField1.getText();
        
        //if (validarDatos(usuario, contrasenia)) {
        if(true){
            
            Vista2Interfaz.enviarDatosInicioSesion(usuario, contrasenia);
            
        } else{
            
            //Informar datos incorrectos
            
        }
        
        Vista2Interfaz.renderizarPaginaPrincipal();
        
    }//GEN-LAST:event_jButtonAceptarMousePressed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImagenPortada;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsuario1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
