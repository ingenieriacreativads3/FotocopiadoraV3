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
public class FXMLModificarDocumentoController implements Initializable{

    @FXML
    private TextField fx_nombre_TextField;
    @FXML
    private TextField fx_editorial_TextField;
    @FXML
    private TextField fx_categoria_TextField;
    @FXML
    private TextField fx_autor_TextField;
    @FXML
    private TextField fx_edicion_TextField;
    @FXML
    private TextField fx_materia_TextField;
    @FXML
    private TextField fx_precio_TextField;
    @FXML
    private TextField fx_documento_TextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public Node obtenerNodo() throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLModificarDocumento.fxml"));
        return root;
        
    }
    
    public void modificarDocumento(){
        
        String nombre=fx_nombre_TextField.getText();
        String categoria=fx_categoria_TextField.getText();
        String editorial=fx_editorial_TextField.getText();
        String edicion=fx_edicion_TextField.getText();
        String autor=fx_autor_TextField.getText();
        String materia=fx_materia_TextField.getText();
        String precio=fx_precio_TextField.getText();
        String documento=fx_documento_TextField.getText();
        
        if (validarDatos(nombre, editorial, categoria, autor, edicion, materia, precio, documento)) {
            
            VistaInterfaz.enviarDatosModificarDocumento(nombre, editorial, categoria, autor, edicion, materia, precio, documento);
            
        } else{
            
            //Informar datos incorrectos
            
        }
    }
    
    public boolean validarDatos(String nombre, String editorial, String categoria, String autor, String edicion, String materia, String precio, String documento){
        
        boolean datosValidos = false;
        Validador validador = new Validador();
        
        if (validador.validarNombre(nombre) && validador.validarNombre(edicion)
           && validador.validarNombre(categoria) && validador.validarNombre(autor) 
           && validador.validarNumero(edicion) && validador.validarNombre(materia)
           && validador.validarPrecio(precio) && validador.validarRutaDocumento(documento)) {
            
            datosValidos = true;
            
        }
        
        return datosValidos;
        
    }
    
}
