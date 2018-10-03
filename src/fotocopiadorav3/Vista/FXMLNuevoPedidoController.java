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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Toshiba
 */
public class FXMLNuevoPedidoController extends Application implements Initializable {

    @FXML
    private TextField fx_nombre_apellido_TextField;
    @FXML
    private TableColumn<?, ?> fx_documento_TableColumn;
    @FXML
    private TableColumn<?, ?> fx_cantidad_TableColumn;
    @FXML
    private TableColumn<?, ?> fx_precio_unitario_TableColumn;
    @FXML
    private TableColumn<?, ?> fx_precio_total_TableColumn;
    @FXML
    private TableColumn<?, ?> fx_fecha_estimada_TableColumn;
    @FXML
    private TextField fx_total_TextField;
    @FXML
    private TextField fx_senia_TextField;
    @FXML
    private Button fx_cancelar_Button;
    @FXML
    private Button fx_aceptar_Button;
    @FXML
    private Button fx_cancelar_pedido_Button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void start(Stage primaryStage) throws Exception {
        
    }
    
}
