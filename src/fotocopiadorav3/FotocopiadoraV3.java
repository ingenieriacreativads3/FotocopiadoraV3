/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3;

import fotocopiadorav3.Controlador.ControladorInterfaz;
import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.Stage;
import fotocopiadorav3.Modelo.*;

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
        
        int i = 1;
        //ControladorInterfaz.comenzar();
        try{
            Direccion.guardar(2);
        }catch(Exception e){
            System.out.println("No entra");
        }
        
        
    }
    
}
