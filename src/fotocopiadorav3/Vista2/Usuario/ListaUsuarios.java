/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista2.Usuario;

import fotocopiadorav3.Modelo.Usuario;
import fotocopiadorav3.Vista2.Vista2Interfaz;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Toshiba
 */
public class ListaUsuarios extends javax.swing.JFrame {
    
    private boolean existe=false;
    
    /**
     * Creates new form ListaUsuarios
     */
    public ListaUsuarios() {
        
        initComponents();
        
        Set<Usuario> usuarios = Vista2Interfaz.obtenerListaUsuarios();
        
        cargarTabla(usuarios);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Nombre de Usuario", "Domicilio", "Altura", "Dni"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarTabla(Set<Usuario> usuarios){
        
        DefaultTableModel defaultTableModel = (DefaultTableModel) Tabla.getModel();
        
        int id=0;
        String nombre="";
        String apellido="";
        String nombreUsuario="";
        String domicilio="";
        int altura=0;
        int dni=0;
        
        if (!usuarios.isEmpty()) {
            
            for (Usuario usuario : usuarios) {

                id=usuario.getId();
                nombre=usuario.getPersona().getNombre().toString();
                apellido=usuario.getPersona().getApellido().toString();
                nombreUsuario=usuario.getNombreUsuario().toString();
                domicilio=usuario.getPersona().getDireccion().getCalle().toString();
                altura=usuario.getPersona().getDireccion().getNumero();
                dni=usuario.getPersona().getDni();

                defaultTableModel.addRow(new Object[]{id, nombre, apellido, nombreUsuario, domicilio, altura, dni});

            }
        }
    }
    
    public void recargarTabla(Set<Usuario> usuarios){
        
        DefaultTableModel defaultTableModel = (DefaultTableModel) Tabla.getModel();
        
        int cantidadFilas = defaultTableModel.getRowCount(); 
        
        for (int i = 0; i < cantidadFilas; i++) {
            
            defaultTableModel.removeRow(i);
            
        }
        
        int id=0;
        String nombre="";
        String apellido="";
        String nombreUsuario="";
        String domicilio="";
        int altura=0;
        int dni=0;
        
        if (!usuarios.isEmpty()) {
            
            for (Usuario usuario : usuarios) {

                id=usuario.getId();
                nombre=usuario.getPersona().getNombre().toString();
                apellido=usuario.getPersona().getApellido().toString();
                nombreUsuario=usuario.getNombreUsuario().toString();
                domicilio=usuario.getPersona().getDireccion().getCalle().toString();
                altura=usuario.getPersona().getDireccion().getNumero();
                dni=usuario.getPersona().getDni();

                defaultTableModel.addRow(new Object[]{id, nombre, apellido, nombreUsuario, domicilio, altura, dni});

            }
        }
    }
    
    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public JTable getTabla() {
        return Tabla;
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
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
