/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3;

import fotocopiadorav3.Controlador.ControladorInterfaz;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**

 @author Tomas
 */
public class FotocopiadoraV3 extends Application{
    
    @Override
    public void start(Stage stage) throws Exception{
        
    }

    /**
     @param args the command line arguments
     */
    public static void main(String[] args){
        //launch(args);
        
        ControladorInterfaz.comenzar(args);
        
    }
    
}
