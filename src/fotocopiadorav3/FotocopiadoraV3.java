/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3;

import fotocopiadorav3.Controlador.*;
import fotocopiadorav3.Modelo.*;
import javafx.application.*;
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
        System.out.println("entra");
        ConexionMySql.getAllInformacion();
        
        //int i = 1;
//        ControladorInterfaz.comenzar();
        try{
            Direccion.noUsarEstaFuncionJamas(0);
        }catch(Exception e){
            System.out.println("No entra");
        }
        
    }
    
}
