/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista2;

import fotocopiadorav3.Vista2.Alumno.ListaAlumnos;
import fotocopiadorav3.Vista2.Articulo.ListaArticulos;
import fotocopiadorav3.Vista2.Usuario.ListaUsuarios;
import javax.swing.JTabbedPane;

/**
 *
 * @author claudio
 */
public class PaginaPrincipalMejorada extends javax.swing.JFrame {
    
    private static ListaAlumnos listaAlumnos;
    private static ListaArticulos listaArticulos;
    private static ListaUsuarios listaUsuarios;
    
    /**
     * Creates new form PaginaPrincipal
     */
    public PaginaPrincipalMejorada() {
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

        BarraMenuLateral = new javax.swing.JPanel();
        nuevoUsuario = new javax.swing.JButton();
        modificarUsuario = new javax.swing.JButton();
        nuevoPedido = new javax.swing.JButton();
        modificarPedido = new javax.swing.JButton();
        nuevoArticulo = new javax.swing.JButton();
        modificarArticulo = new javax.swing.JButton();
        nuevoCliente = new javax.swing.JButton();
        modificarCliente = new javax.swing.JButton();
        Pedidos = new javax.swing.JButton();
        Articulos = new javax.swing.JButton();
        Alumnos = new javax.swing.JButton();
        Usuarios = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        BarraMenuSuperior = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PanelPrincipalCentral = new javax.swing.JPanel();
        areaTrabajo = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BarraMenuLateral.setBackground(new java.awt.Color(26, 26, 26));
        BarraMenuLateral.setPreferredSize(new java.awt.Dimension(320, 100));
        BarraMenuLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nuevoUsuario.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        nuevoUsuario.setText("Nuevo Usuario");
        nuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoUsuarioActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(nuevoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 370, 30));

        modificarUsuario.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        modificarUsuario.setText("Modificar Usuario");
        modificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarUsuarioActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(modificarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 370, 30));

        nuevoPedido.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        nuevoPedido.setText("Nuevo Pedido");
        nuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoPedidoActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(nuevoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 370, 30));

        modificarPedido.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        modificarPedido.setText("Modificar Pedido");
        modificarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPedidoActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(modificarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 370, 30));

        nuevoArticulo.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        nuevoArticulo.setText("Nuevo Artículo");
        nuevoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoArticuloActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(nuevoArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 370, 30));

        modificarArticulo.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        modificarArticulo.setText("Modificar Artículo");
        modificarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarArticuloActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(modificarArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 370, 30));

        nuevoCliente.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        nuevoCliente.setText("Nuevo Alumno");
        nuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoClienteActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(nuevoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 370, 30));

        modificarCliente.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        modificarCliente.setText("Modificar Alumno");
        modificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarClienteActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(modificarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 370, 30));

        Pedidos.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        Pedidos.setText("Pedidos");
        Pedidos.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        Pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PedidosActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(Pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 60));

        Articulos.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        Articulos.setText("Artículos");
        Articulos.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        Articulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArticulosActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(Articulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 370, 60));

        Alumnos.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        Alumnos.setText("Alumnos");
        Alumnos.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        Alumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlumnosActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(Alumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 370, 60));

        Usuarios.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        Usuarios.setText("Usuarios");
        Usuarios.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuariosActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(Usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 370, 60));

        Guardar.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        Guardar.setText("Guardar");
        Guardar.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 370, 50));

        jButton1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton1.setText("Eliminar Pedido");
        BarraMenuLateral.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 370, -1));

        jButton2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton2.setText("Eliminar Artículo");
        BarraMenuLateral.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 370, -1));

        jButton3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton3.setText("Eliminar Alumno");
        BarraMenuLateral.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 370, -1));

        getContentPane().add(BarraMenuLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 370, 620));

        BarraMenuSuperior.setBackground(new java.awt.Color(16, 16, 16));
        BarraMenuSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ajustes.png"))); // NOI18N
        BarraMenuSuperior.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 20, -1, -1));

        getContentPane().add(BarraMenuSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 100));

        PanelPrincipalCentral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        areaTrabajo.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        PanelPrincipalCentral.add(areaTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 620));

        getContentPane().add(PanelPrincipalCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 910, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoPedidoActionPerformed
        Vista2Interfaz.renderizarNuevoPedido();
    }//GEN-LAST:event_nuevoPedidoActionPerformed

    private void modificarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPedidoActionPerformed
        Vista2Interfaz.renderizarModificarPedido();
    }//GEN-LAST:event_modificarPedidoActionPerformed

    private void nuevoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoArticuloActionPerformed
        Vista2Interfaz.renderizarNuevoArticulo();
    }//GEN-LAST:event_nuevoArticuloActionPerformed

    private void modificarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarArticuloActionPerformed
        Vista2Interfaz.renderizarModificarArticulo();
    }//GEN-LAST:event_modificarArticuloActionPerformed

    private void nuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoClienteActionPerformed
        Vista2Interfaz.renderizarNuevoAlumno();
    }//GEN-LAST:event_nuevoClienteActionPerformed

    private void modificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarClienteActionPerformed
        
        if (listaAlumnos.getTabla().getModel().getValueAt(listaAlumnos.getTabla().getSelectedRow(), 0)!=null) {
            
            
            int idAlumno = (int) listaAlumnos.getTabla().getModel().getValueAt(listaAlumnos.getTabla().getSelectedRow(), 0);
            System.out.println("id alumno: " + idAlumno);
            Vista2Interfaz.renderizarModificarAlumno(idAlumno);
            
        }
    }//GEN-LAST:event_modificarClienteActionPerformed

    private void nuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoUsuarioActionPerformed
        Vista2Interfaz.renderizarNuevoUsuario();
    }//GEN-LAST:event_nuevoUsuarioActionPerformed

    private void modificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarUsuarioActionPerformed
        Vista2Interfaz.renderizarModificarUsuario();
    }//GEN-LAST:event_modificarUsuarioActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        Vista2Interfaz.guardar();
    }//GEN-LAST:event_GuardarActionPerformed

    private void PedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PedidosActionPerformed
        Vista2Interfaz.renderizarListadoPedidos();
    }//GEN-LAST:event_PedidosActionPerformed

    private void ArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArticulosActionPerformed
        Vista2Interfaz.renderizarListadoArticulos();
    }//GEN-LAST:event_ArticulosActionPerformed

    private void AlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlumnosActionPerformed
        Vista2Interfaz.renderizarListadoAlumnos();
    }//GEN-LAST:event_AlumnosActionPerformed

    private void UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosActionPerformed
        Vista2Interfaz.renderizarListadoUsuarios();
    }//GEN-LAST:event_UsuariosActionPerformed
    
    public void establecerListados(ListaAlumnos listaAlumnos, ListaArticulos listaArticulos, ListaUsuarios listaUsuarios){
        
        this.listaAlumnos = listaAlumnos;
        this.listaArticulos = listaArticulos;
        this.listaUsuarios = listaUsuarios;
        
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
            java.util.logging.Logger.getLogger(PaginaPrincipalMejorada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipalMejorada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipalMejorada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipalMejorada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaPrincipalMejorada().setVisible(true);
            }
        });
    }
    
    public JTabbedPane getAreaTrabajo(){
        return areaTrabajo;
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alumnos;
    private javax.swing.JButton Articulos;
    private javax.swing.JPanel BarraMenuLateral;
    private javax.swing.JPanel BarraMenuSuperior;
    private javax.swing.JButton Guardar;
    private javax.swing.JPanel PanelPrincipalCentral;
    private javax.swing.JButton Pedidos;
    private javax.swing.JButton Usuarios;
    private javax.swing.JTabbedPane areaTrabajo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton modificarArticulo;
    private javax.swing.JButton modificarCliente;
    private javax.swing.JButton modificarPedido;
    private javax.swing.JButton modificarUsuario;
    private javax.swing.JButton nuevoArticulo;
    private javax.swing.JButton nuevoCliente;
    private javax.swing.JButton nuevoPedido;
    private javax.swing.JButton nuevoUsuario;
    // End of variables declaration//GEN-END:variables
}
