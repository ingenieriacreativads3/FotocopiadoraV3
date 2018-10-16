/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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
public class FXMLNuevoPedidoController implements Initializable {

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
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLNuevoPedido.fxml"));
        return root;
        
    }
    
    public void nuevoDocumento(){
        
        String alumno=fx_nombre_apellido_TextField.getText();
        ArrayList<String> nombresArticulos = new ArrayList<>();
        ArrayList<String> fechaEstimadaArticulos = new ArrayList<>();
        ArrayList<String> cantidadArticulos = new ArrayList<>();
        ArrayList<String> precioUnitarioArticulos = new ArrayList<>();
        ArrayList<String> precioTotalArticulos = new ArrayList<>();
        String importeTotal=fx_total_TextField.getText();
        String senia=fx_senia_TextField.getText();
        
        if (validarDatos(alumno, nombresArticulos, fechaEstimadaArticulos, cantidadArticulos, precioUnitarioArticulos, precioTotalArticulos, importeTotal, senia)) {
            
            VistaInterfaz.enviarDatosNuevoPedido(alumno, nombresArticulos, fechaEstimadaArticulos, cantidadArticulos, precioUnitarioArticulos, precioTotalArticulos, importeTotal, senia);
            
        } else{
            
            //Informar datos incorrectos
            
        }
    }
    
    public boolean validarDatos(String alumno, ArrayList<String> nombresArticulos, ArrayList<String> fechaEstimadaArticulos, ArrayList<String> cantidadArticulos, ArrayList<String> precioUnitarioArticulos, ArrayList<String> precioTotalArticulos, String importeTotal, String senia){
        
        boolean datosValidos = false;
        Validador validador = new Validador();
        
        if (validador.validarNombre(alumno) && validador.validarNombre(nombresArticulos.get(0))
           && validador.validarFechaEstimada(Date.valueOf(fechaEstimadaArticulos.get(0))) && validador.validarNumero(cantidadArticulos.get(0)) 
           && validador.validarPrecio(precioUnitarioArticulos.get(0)) && validador.validarPrecio(precioTotalArticulos.get(0))
           && validador.validarPrecio(importeTotal) && validador.validarPrecio(senia)) {
            
            datosValidos = true;
            
        }
        
        return datosValidos;
        
    }
    
}
