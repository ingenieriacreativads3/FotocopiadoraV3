/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista;

import fotocopiadorav3.Controlador.*;
import static fotocopiadorav3.Controlador.ControladorInterfaz.argumentos;
import fotocopiadorav3.Modelo.Estado;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
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
public class LoginController extends Application implements Initializable{

    @FXML
    private Button fx_iniciar_sesion_Button;
    @FXML
    private TextField fx_usuario_TextField;
    @FXML
    private TextField fx_contrasenia_TextField;
    @FXML
    private Button fx_salir_Button;

    private ControladorInterfaz controladorInterfaz;
    public static String[] argument;
    /**
     Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
    }    
    
    //Chicos, esto es una prueba que estoy haciendo con Jfx, van a ver estos metodos en varias clases
    //Este metodo toma el click del boton iniciar secion, y verifica el usuario y contraseña
    @FXML private void iniciarSesion(ActionEvent Event){
        
        
        
    }
    
    private void salir(ActionEvent Event){
        System.exit(0);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    @FXML
    private void iniciarSesion(MouseEvent event) {
        String usuario = fx_usuario_TextField.toString();
        String contraseña = fx_contrasenia_TextField.toString();
        
        Estado estadoInicioSesion = controladorInterfaz.VerificarUsuarioYContraseña(usuario, contraseña);
        
        if(estadoInicioSesion == Estado.DATOS_VALIDOS){
            ControladorInterfaz.iniciarSecion(argumentos);
        }
        else{
            //Informar que algo mal salio usando Estado.MENSAJE_ERROR
        }
    }
    
}
