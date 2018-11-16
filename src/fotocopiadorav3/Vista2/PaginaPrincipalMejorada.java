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
    private static ListaUsuarios listaPedidos;
    
    /**
     * Creates new form PaginaPrincipal
     */
    public PaginaPrincipalMejorada() {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        
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
        eliminarPedido = new javax.swing.JButton();
        eliminarArticulo = new javax.swing.JButton();
        eliminarAlumno = new javax.swing.JButton();
        eliminarUsuario = new javax.swing.JButton();
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

        eliminarPedido.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        eliminarPedido.setText("Eliminar Pedido");
        eliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPedidoActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(eliminarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 370, 30));

        eliminarArticulo.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        eliminarArticulo.setText("Eliminar Artículo");
        eliminarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarArticuloActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(eliminarArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 370, 30));

        eliminarAlumno.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        eliminarAlumno.setText("Eliminar Alumno");
        eliminarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAlumnoActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(eliminarAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 370, 30));

        eliminarUsuario.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        eliminarUsuario.setText("Eliminar Usuario");
        eliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarUsuarioActionPerformed(evt);
            }
        });
        BarraMenuLateral.add(eliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 370, 30));

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
        
        int idPedido = getIdPedido();
        
        Vista2Interfaz.renderizarModificarPedido(idPedido);
        
    }//GEN-LAST:event_modificarPedidoActionPerformed

    private void nuevoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoArticuloActionPerformed
        Vista2Interfaz.renderizarNuevoArticulo();
    }//GEN-LAST:event_nuevoArticuloActionPerformed

    private void modificarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarArticuloActionPerformed
        
        int idArticulo = getIdArticulo();
        
        Vista2Interfaz.renderizarModificarArticulo(idArticulo);
        
    }//GEN-LAST:event_modificarArticuloActionPerformed

    private void nuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoClienteActionPerformed
        Vista2Interfaz.renderizarNuevoAlumno();
    }//GEN-LAST:event_nuevoClienteActionPerformed

    private void modificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarClienteActionPerformed
        
        int idAlumno = getIdAlumno();
        
        Vista2Interfaz.renderizarModificarAlumno(idAlumno);
        
    }//GEN-LAST:event_modificarClienteActionPerformed

    private void nuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoUsuarioActionPerformed
        Vista2Interfaz.renderizarNuevoUsuario();
    }//GEN-LAST:event_nuevoUsuarioActionPerformed

    private void modificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarUsuarioActionPerformed
        
        int idUsuario = getIdUsuario();
        
        Vista2Interfaz.renderizarModificarUsuario(idUsuario);
        
    }//GEN-LAST:event_modificarUsuarioActionPerformed

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

    private void eliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPedidoActionPerformed
        
        int idPedido = getIdPedido();
        
        Vista2Interfaz.renderizarMensajeConfirmacion(0, idPedido);
        
    }//GEN-LAST:event_eliminarPedidoActionPerformed

    private void eliminarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarArticuloActionPerformed
        
        int idArticulo = getIdArticulo();
        
        Vista2Interfaz.renderizarMensajeConfirmacion(1, idArticulo);
        
    }//GEN-LAST:event_eliminarArticuloActionPerformed

    private void eliminarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarAlumnoActionPerformed
        
        int idAlumno = getIdAlumno();
        
        Vista2Interfaz.renderizarMensajeConfirmacion(2, idAlumno);
        
    }//GEN-LAST:event_eliminarAlumnoActionPerformed

    private void eliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarUsuarioActionPerformed
        
        int idUsuario = getIdUsuario();
        
        Vista2Interfaz.renderizarMensajeConfirmacion(3, idUsuario);
        
    }//GEN-LAST:event_eliminarUsuarioActionPerformed
    
    public void establecerListados(ListaAlumnos listaAlumnos, ListaArticulos listaArticulos, ListaUsuarios listaUsuarios){
        
        this.listaAlumnos = listaAlumnos;
        this.listaArticulos = listaArticulos;
        this.listaUsuarios = listaUsuarios;
//        this.listaPedidos = listaPedidos;
        
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
    
    private int getIdAlumno(){
        
        int idAlumno = 0;
        
        if (alumnoSeleccionado()) {
            
            idAlumno = (int) listaAlumnos.getTabla().getModel().getValueAt(listaAlumnos.getTabla().getSelectedRow(), 0);
            
        }
        
        return idAlumno;
    }
    
    private int getIdArticulo(){
        
        int idArticulo = 0;
        
        if (articuloSeleccionado()) {
            
            idArticulo = (int) listaArticulos.getTabla().getModel().getValueAt(listaArticulos.getTabla().getSelectedRow(), 0);
            
        }
        
        return idArticulo;
    }
    
    private int getIdUsuario(){
        
        int idUsuario = 0;
        
        if (usuarioSeleccionado()) {
            
            idUsuario = (int) listaUsuarios.getTabla().getModel().getValueAt(listaUsuarios.getTabla().getSelectedRow(), 0);
            
        }
        
        return idUsuario;
    }
    
    private int getIdPedido(){
        
        int idPedido = 0;
        
        if (pedidoSeleccionado()) {
            
            idPedido = (int) listaPedidos.getTabla().getModel().getValueAt(listaPedidos.getTabla().getSelectedRow(), 0);
            
        }
        
        return idPedido;
    }
    
    private boolean alumnoSeleccionado(){
        
        boolean hayAlumnoSeleccionado = listaAlumnos.getTabla().getModel().getValueAt(listaAlumnos.getTabla().getSelectedRow(), 0)!=null;
        
        return hayAlumnoSeleccionado;
    }
    
    private boolean pedidoSeleccionado(){
        
        boolean hayPedidoSeleccionado = listaPedidos.getTabla().getModel().getValueAt(listaPedidos.getTabla().getSelectedRow(), 0)!=null;
        
        return hayPedidoSeleccionado;
    }
    
    private boolean articuloSeleccionado(){
        
        boolean hayArticuloSeleccionado = listaArticulos.getTabla().getModel().getValueAt(listaArticulos.getTabla().getSelectedRow(), 0)!=null;
        
        return hayArticuloSeleccionado;
    }
    
    private boolean usuarioSeleccionado(){
        
        boolean hayUsuarioSeleccionado = listaUsuarios.getTabla().getModel().getValueAt(listaUsuarios.getTabla().getSelectedRow(), 0)!=null;
        
        return hayUsuarioSeleccionado;
    }
    
    public JTabbedPane getAreaTrabajo(){
        return areaTrabajo;
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alumnos;
    private javax.swing.JButton Articulos;
    private javax.swing.JPanel BarraMenuLateral;
    private javax.swing.JPanel BarraMenuSuperior;
    private javax.swing.JPanel PanelPrincipalCentral;
    private javax.swing.JButton Pedidos;
    private javax.swing.JButton Usuarios;
    private javax.swing.JTabbedPane areaTrabajo;
    private javax.swing.JButton eliminarAlumno;
    private javax.swing.JButton eliminarArticulo;
    private javax.swing.JButton eliminarPedido;
    private javax.swing.JButton eliminarUsuario;
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
