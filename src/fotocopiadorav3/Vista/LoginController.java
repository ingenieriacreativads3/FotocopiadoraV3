/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista;

import fotocopiadorav3.Controlador.ControladorInterfaz;
import fotocopiadorav3.Modelo.Estado;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 FXML Controller class

 @author Tomas
 */
public class LoginController implements Initializable{

    @FXML
    private Button fx_iniciar_sesion_Button;
    @FXML
    private TextField fx_usuario_TextField;
    @FXML
    private TextField fx_contrasenia_TextField;
    @FXML
    private Button fx_salir_Button;

    private ControladorInterfaz controladorInterfaz;
    
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
        
        String usuario = fx_usuario_TextField.toString();
        String contraseña = fx_contrasenia_TextField.toString();
        
        Estado estadoInicioSesion = controladorInterfaz.VerificarUsuarioYContraseña(usuario, contraseña);
        
        if(estadoInicioSesion == Estado.DATOS_VALIDOS){
            //cambiar interfaz
        }
        else{
            //Informar que algo mal salio usando Estado.MENSAJE_ERROR
        }
        
    }
    
    @FXML private void salir(ActionEvent Event){
        System.exit(0);
    }
    
}
