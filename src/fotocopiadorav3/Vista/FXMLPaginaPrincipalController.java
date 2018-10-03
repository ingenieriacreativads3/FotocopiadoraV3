/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista;

import fotocopiadorav3.Controlador.ControladorInterfaz;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FXMLPaginaPrincipalController extends Application implements Initializable {

    @FXML
    private Button fx_nuevo_pedido_Button;
    @FXML
    private Button fx_modificar_pedido_Button;
    @FXML
    private Button fx_cancelar_pedido_Button;
    @FXML
    private Button fx_inventario_Button;
   
    private BorderPane paginaPrincipal;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
       
        paginaPrincipal = (BorderPane) FXMLLoader.load(getClass().getResource("FXMLPaginaPrincipal.fxml"));
        
        Scene scene = new Scene(paginaPrincipal);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    @FXML
    private void abrirInventario(ActionEvent event) {
        
        ControladorInterfaz.cargarInventario();
        
    }
    
    @FXML
    private void nuevoPedido(ActionEvent event) {
        
        ControladorInterfaz.cargarNuevoPedido();
        
    }
    
    @FXML
    private void modificarPedido(ActionEvent event) {
        
        ControladorInterfaz.cargarModificarPedido();
        
    }
    
    @FXML
    private void cancelarPedido(ActionEvent event) {
        
        ControladorInterfaz.cargarCancelarPedido();
        
    }

    @FXML
    private void nuevoDocumento(ActionEvent event) {
        
        ControladorInterfaz.cargarNuevoDocumento();
        
    }

    @FXML
    private void modificarDocumento(ActionEvent event) {
        
        ControladorInterfaz.cargarModificarDocumento();
        
    }

    @FXML
    private void eliminarDocumento(ActionEvent event) {
        
        ControladorInterfaz.cargarEliminarDocumento();
        
    }

    public void establecerPanelCentral(Node nodo) {
        paginaPrincipal.setCenter(nodo);
    }
    
}
