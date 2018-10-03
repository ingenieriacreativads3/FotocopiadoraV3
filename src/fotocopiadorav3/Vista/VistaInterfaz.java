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

    @Override
    public void start(Stage primaryStage) throws Exception {}
    
    
}
