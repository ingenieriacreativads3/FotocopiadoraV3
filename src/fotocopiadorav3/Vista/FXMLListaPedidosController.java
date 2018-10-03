/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeTableColumn;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FXMLListaPedidosController extends Application implements Initializable{

    @FXML
    private TreeTableColumn<?, ?> fx_codigo_TreeTableColumn;
    @FXML
    private TreeTableColumn<?, ?> fx_alumno_TreeTableColumn;
    @FXML
    private TreeTableColumn<?, ?> fx_documentos_TreeTableColumn;
    @FXML
    private TreeTableColumn<?, ?> fx_estado_TreeTableColumn;
    @FXML
    private TreeTableColumn<?, ?> fx_senia_TreeTableColumn;
    @FXML
    private TreeTableColumn<?, ?> fx_importe_TreeTableColumn;
    @FXML
    private TreeTableColumn<?, ?> fx_fecha_TreeTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
