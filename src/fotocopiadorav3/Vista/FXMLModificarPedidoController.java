/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Toshiba
 */
public class FXMLModificarPedidoController implements Initializable{

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
    private Button fx_aceptar_Button;
    @FXML
    private Button fx_limpiar_campos_Button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public Node obtenerNodo() throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLModificarPedido.fxml"));
        return root;
        
    }
    
    public void modificarDocumento(){
        
        String alumno=fx_nombre_apellido_TextField.getText();
        ArrayList<String> nombresArticulos = new ArrayList<>();
        ArrayList<String> fechaEstimadaArticulos = new ArrayList<>();
        ArrayList<String> cantidadArticulos = new ArrayList<>();
        ArrayList<String> precioUnitarioArticulos = new ArrayList<>();
        ArrayList<String> precioTotalArticulos = new ArrayList<>();
        String importeTotal=fx_total_TextField.getText();
        String senia=fx_senia_TextField.getText();
        
        VistaInterfaz.enviarDatosModificarPedido(alumno, nombresArticulos, fechaEstimadaArticulos, cantidadArticulos, precioUnitarioArticulos, precioTotalArticulos, importeTotal, senia);
        
    }
    
}
