/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista;

import javafx.application.Application;
import javafx.stage.Stage;

/**

 @author Tomas
 */
public class VistaInterfaz extends Application{
    
    public static FXMLPaginaPrincipalController paginaPrincipalController = new FXMLPaginaPrincipalController();
    public static Stage stagePrincipal;
    
    public static void renderizarLogin(String[] args){
        
        launch(LoginController.class, args);
        
    }
    
    public static void renderizarPaginaPrincipal(){
        try {
            
            paginaPrincipalController.start(stagePrincipal);
            
        } catch (Exception e) {
            
        }
    }
    
    public static void renderizarInventario(){
        
        try {
            
            FXMLInventarioController inventarioController = new FXMLInventarioController();
            paginaPrincipalController.establecerPanelCentral(inventarioController.obtenerNodo());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void renderizarNuevoPedido(){
        
        try {
            
            FXMLNuevoPedidoController nuevoPedidoController = new FXMLNuevoPedidoController();
            paginaPrincipalController.establecerPanelCentral(nuevoPedidoController.obtenerNodo());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void renderizarModificarPedido(){
        
        try {
            
            FXMLModificarPedidoController modificarPedidoControllerController = new FXMLModificarPedidoController();
            paginaPrincipalController.establecerPanelCentral(modificarPedidoControllerController.obtenerNodo());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void renderizarCancelarPedido(){
        
        /*try {
            
            FXMLCancelarPedidoController cancelarPedidoController = new FXMLCancelarPedidoController();
            paginaPrincipalController.establecerPanelCentral(cancelarPedidoController.obtenerNodo());
            
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
    }

    public static void renderizarNuevoDocumento(){
        
        try {
            
            FXMLNuevoDocumentoController nuevoDocumentoController = new FXMLNuevoDocumentoController();
            paginaPrincipalController.establecerPanelCentral(nuevoDocumentoController.obtenerNodo());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void renderizarModificarDocumento(){
        
        try {
            
            FXMLModificarDocumentoController modificarDocumentoController = new FXMLModificarDocumentoController();
            paginaPrincipalController.establecerPanelCentral(modificarDocumentoController.obtenerNodo());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void renderizarEliminarDocumento(){
        
        /*try {
            
            FXMLInventarioController inventarioController = new FXMLInventarioController();
            paginaPrincipalController.establecerPanelCentral(inventarioController.obtenerNodo());
            
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {}
    
    
}
