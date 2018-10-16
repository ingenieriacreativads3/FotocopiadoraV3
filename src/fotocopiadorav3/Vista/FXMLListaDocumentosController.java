/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FXMLListaDocumentosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        VistaInterfaz.obtenerListaDocumentos();
        
    }    

    public Node obtenerNodo() throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLListaDocumentos.fxml"));
        return root;
        
    }
    
}
