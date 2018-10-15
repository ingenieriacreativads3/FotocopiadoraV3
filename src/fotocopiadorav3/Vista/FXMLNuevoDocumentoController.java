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
public class FXMLNuevoDocumentoController implements Initializable{

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
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLNuevoDocumento.fxml"));
        return root;
        
    }
    
    public void nuevoDocumento(){
        
        String nombre=fx_nombre_TextField.getText();
        String categoria=fx_categoria_TextField.getText();
        String editorial=fx_editorial_TextField.getText();
        String edicion=fx_edicion_TextField.getText();
        String autor=fx_autor_TextField.getText();
        String materia=fx_materia_TextField.getText();
        String precio=fx_precio_TextField.getText();
        String documento=fx_documento_TextField.getText();
        
        VistaInterfaz.enviarDatosNuevoDocumento(nombre, editorial, categoria, autor, edicion, materia, precio, documento);
        
    }
    
}
