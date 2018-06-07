/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista;

import java.net.URL;
import java.util.ResourceBundle;
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

    /**
     Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
    }    
    
}
