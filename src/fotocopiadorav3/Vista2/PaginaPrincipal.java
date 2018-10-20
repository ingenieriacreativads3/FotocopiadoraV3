/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista2;

/**
 *
 * @author claudio
 */
public class PaginaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PaginaPrincipal
     */
    public PaginaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        NuevoUsuario = new javax.swing.JButton();
        ModificarUsuario = new javax.swing.JButton();
        NuevoDocumento = new javax.swing.JButton();
        ModificarDocumento = new javax.swing.JButton();
        NuevoPedido = new javax.swing.JButton();
        ModificarPedido = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setRollover(true);

        NuevoUsuario.setText("Nuevo Usuario");
        NuevoUsuario.setFocusable(false);
        NuevoUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NuevoUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        NuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoUsuarioActionPerformed(evt);
            }
        });
        jToolBar1.add(NuevoUsuario);

        ModificarUsuario.setText("Modificar Usuario");
        ModificarUsuario.setFocusable(false);
        ModificarUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ModificarUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarUsuarioActionPerformed(evt);
            }
        });
        jToolBar1.add(ModificarUsuario);

        NuevoDocumento.setText("Nuevo Documento");
        NuevoDocumento.setFocusable(false);
        NuevoDocumento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NuevoDocumento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        NuevoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoDocumentoActionPerformed(evt);
            }
        });
        jToolBar1.add(NuevoDocumento);

        ModificarDocumento.setText("Modificar Documento");
        ModificarDocumento.setFocusable(false);
        ModificarDocumento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ModificarDocumento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ModificarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarDocumentoActionPerformed(evt);
            }
        });
        jToolBar1.add(ModificarDocumento);

        NuevoPedido.setText("Nuevo Pedido");
        NuevoPedido.setFocusable(false);
        NuevoPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NuevoPedido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        NuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoPedidoActionPerformed(evt);
            }
        });
        jToolBar1.add(NuevoPedido);

        ModificarPedido.setText("Modificar Pedido");
        ModificarPedido.setFocusable(false);
        ModificarPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ModificarPedido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ModificarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarPedidoActionPerformed(evt);
            }
        });
        jToolBar1.add(ModificarPedido);

        jMenu1.setText("File");

        jMenuItem3.setText("jMenuItem3");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("jMenuItem4");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");
        jMenu2.add(jCheckBoxMenuItem1);

        jMenuItem1.setText("jMenuItem1");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 470, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoUsuarioActionPerformed
        Vista2Interfaz.renderizarNuevoUsuario();
    }//GEN-LAST:event_NuevoUsuarioActionPerformed

    private void NuevoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoDocumentoActionPerformed
        Vista2Interfaz.renderizarNuevoDocumento();
    }//GEN-LAST:event_NuevoDocumentoActionPerformed

    private void ModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarUsuarioActionPerformed
        Vista2Interfaz.renderizarModificarUsuario();
    }//GEN-LAST:event_ModificarUsuarioActionPerformed

    private void ModificarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarDocumentoActionPerformed
        Vista2Interfaz.renderizarModificarDocumento();
    }//GEN-LAST:event_ModificarDocumentoActionPerformed

    private void NuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoPedidoActionPerformed
        Vista2Interfaz.renderizarNuevoPedido();
    }//GEN-LAST:event_NuevoPedidoActionPerformed

    private void ModificarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarPedidoActionPerformed
        Vista2Interfaz.renderizarModificarPedido();
    }//GEN-LAST:event_ModificarPedidoActionPerformed

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
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ModificarDocumento;
    private javax.swing.JButton ModificarPedido;
    private javax.swing.JButton ModificarUsuario;
    private javax.swing.JButton NuevoDocumento;
    private javax.swing.JButton NuevoPedido;
    private javax.swing.JButton NuevoUsuario;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}