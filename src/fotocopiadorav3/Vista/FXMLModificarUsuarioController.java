/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Toshiba
 */
public class FXMLModificarUsuarioController implements Initializable {

    @FXML
    private TextField fx_nombre_TextField;
    @FXML
    private TextField fx_domicilio_TextField;
    @FXML
    private TextField fx_apellido_TextField;
    @FXML
    private TextField fx_dni_TextField;
    @FXML
    private TextField fx_nombre_usuario_TextField;
    @FXML
    private TextField fx_contrasenia_TextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public Node obtenerNodo() throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLModificarUsuario.fxml"));
        return root;
        
    }
    
    public void modificarUsuario(){
        
        String nombre = fx_nombre_TextField.getText();
        String apellido = fx_apellido_TextField.getText();
        String nombreUsuario = fx_nombre_usuario_TextField.getText();
        String contrasenia = fx_contrasenia_TextField.getText();
        String domicilio = fx_domicilio_TextField.getText();
        String dni = fx_dni_TextField.getText();
        
        if (validarDatos(nombre, apellido, nombreUsuario, contrasenia, domicilio, dni)) {
            
            VistaInterfaz.enviarDatosModificarUsuario(nombre, apellido, nombreUsuario, contrasenia, domicilio, dni);
            
        } else{
            
            //Informar datos incorrectos
            
        }
     }
    
    public boolean validarDatos(String nombre, String apellido, String nombreUsuario, String contrasenia, String domicilio, String dni){
        
        boolean datosValidos = false;
        Validador validador = new Validador();
        
        if (validador.validarNombre(nombre) && validador.validarNombre(apellido)
           && validador.validarNombreAlfanumerico(nombreUsuario) && validador.validarNombreAlfanumerico(contrasenia) 
           && validador.validarNombreAlfanumerico(domicilio) && validador.validarNumero(dni)) {
            
            datosValidos = true;
            
        }
        
        return datosValidos;
        
    }
    
}
