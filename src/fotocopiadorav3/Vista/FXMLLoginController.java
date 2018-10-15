/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista;

import fotocopiadorav3.Controlador.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 FXML Controller class

 @author Tomas
 */
public class FXMLLoginController extends Application implements Initializable{

    @FXML
    private Button fx_iniciar_sesion_Button;
    @FXML
    private TextField fx_usuario_TextField;
    @FXML
    private TextField fx_contrasenia_TextField;
    @FXML
    private Button fx_salir_Button;
    
    /**
     Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
    }    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
       
        VistaInterfaz.stagePrincipal = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    @FXML
    private void salir(MouseEvent Event) throws Throwable{
        ControladorInterfaz.salirAplicacion();
    }

    @FXML
    private void iniciarSesion(MouseEvent event) {
        /*
        Estado estadoInicioSesion = controladorInterfaz.VerificarUsuarioYContraseña(usuario, contraseña);
        
        if(estadoInicioSesion == Estado.DATOS_VALIDOS){
            ControladorInterfaz.iniciarSecion();
        }
        else{
            //Informar que algo mal salio usando Estado.MENSAJE_ERROR
        }

        */
        
        String usuario = fx_usuario_TextField.toString();
        String contrasenia = fx_contrasenia_TextField.toString();
        
        VistaInterfaz.enviarDatosInicioSesion(usuario, contrasenia);
        
    }
    
}
