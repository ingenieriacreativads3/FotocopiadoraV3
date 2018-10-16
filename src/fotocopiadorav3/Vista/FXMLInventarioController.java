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
import javafx.scene.control.TreeTableColumn;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FXMLInventarioController implements Initializable {

    @FXML
    private TreeTableColumn<?, ?> fx_documento_TreeTableColumn;
    @FXML
    private TreeTableColumn<?, ?> fx_tipo_TreeTableColumn;
    @FXML
    private TreeTableColumn<?, ?> fx_autor_TreeTableColumn;
    @FXML
    private TreeTableColumn<?, ?> fx_edicion_TreeTableColumn;
    @FXML
    private TreeTableColumn<?, ?> fx_carrera_TreeTableColumn;
    @FXML
    private TreeTableColumn<?, ?> fx_anio_TreeTableColumn;
    @FXML
    private TreeTableColumn<?, ?> fx_materia_TreeTableColumn;
    @FXML
    private TreeTableColumn<?, ?> fx_importe_TreeTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        VistaInterfaz.obtenerListaInventario();
        
    }    
    
    public Node obtenerNodo() throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLInventario.fxml"));
        return root;
        
    }
    
}
