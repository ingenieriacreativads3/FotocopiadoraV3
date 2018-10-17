/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista;

import fotocopiadorav3.Controlador.ControladorInterfaz;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;

/**

 @author Tomas
 */
public class VistaInterfaz extends Application{
    
    public static FXMLPaginaPrincipalController paginaPrincipalController = new FXMLPaginaPrincipalController();
    public static Stage stagePrincipal;
    
    public static void renderizarLogin(String[] args){
        
        launch(FXMLLoginController.class, args);
        
    }
    
    public static void renderizarPaginaPrincipal(){
        
        try {
            
            paginaPrincipalController.start(stagePrincipal);
            
        } catch (Exception e) {
            
        }
    }
    
    public static void renderizarInventario(){
        
        try {
            
            FXMLInventarioController inventarioController = new FXMLInventarioController();
            paginaPrincipalController.establecerPanelCentral(inventarioController.obtenerNodo());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void renderizarNuevoPedido(){
        
        try {
            
            FXMLNuevoPedidoController nuevoPedidoController = new FXMLNuevoPedidoController();
            paginaPrincipalController.establecerPanelCentral(nuevoPedidoController.obtenerNodo());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void renderizarModificarPedido(){
        
        try {
            
            FXMLModificarPedidoController modificarPedidoControllerController = new FXMLModificarPedidoController();
            paginaPrincipalController.establecerPanelCentral(modificarPedidoControllerController.obtenerNodo());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void renderizarCancelarPedido(){
        
        /*try {
            
            FXMLCancelarPedidoController cancelarPedidoController = new FXMLCancelarPedidoController();
            paginaPrincipalController.establecerPanelCentral(cancelarPedidoController.obtenerNodo());
            
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public static void renderizarNuevoDocumento(){
        
        try {
            
            FXMLNuevoDocumentoController nuevoDocumentoController = new FXMLNuevoDocumentoController();
            paginaPrincipalController.establecerPanelCentral(nuevoDocumentoController.obtenerNodo());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void renderizarModificarDocumento(){
        
        try {
            
            FXMLModificarDocumentoController modificarDocumentoController = new FXMLModificarDocumentoController();
            paginaPrincipalController.establecerPanelCentral(modificarDocumentoController.obtenerNodo());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void renderizarEliminarDocumento(){
        
        /*try {
            
            FXMLInventarioController inventarioController = new FXMLInventarioController();
            paginaPrincipalController.establecerPanelCentral(inventarioController.obtenerNodo());
            
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
    
    public static void enviarDatosInicioSesion(String nombreUsuario, String contrasenia){
        
        ControladorInterfaz controladorInterfaz = new ControladorInterfaz();
        controladorInterfaz.iniciarSecion(nombreUsuario, contrasenia);
        
    }
    
    public static void enviarDatosNuevoDocumento(String nombre, String editorial, String categoria, String autor, String edicion, String materia, String precio, String documento){
        
        //ControladorInterfaz.crearNuevoDocumento(nombre, editorial, categoria, autor, edicion, materia, precio, documento);
        
    }
    
    public static void enviarDatosModificarDocumento(String nombre, String editorial, String categoria, String autor, String edicion, String materia, String precio, String documento){
        
        //ControladorInterfaz.modificarDocumento(nombre, editorial, categoria, autor, edicion, materia, precio, documento);
        
    }
    
    public static void enviarDatosNuevoUsuario(String nombre, String apellido, String nombreUsuario, String contrasenia, String domicilio, String dni){
        
        //ControladorInterfaz.crearNuevoUsuario(nombre, apellido, nombreUsuario, contrasenia, domicilio, dni);
        
    }
    
    public static void enviarDatosModificarUsuario(String nombre, String apellido, String nombreUsuario, String contrasenia, String domicilio, String dni){
        
        //ControladorInterfaz.modificarUsuario(nombre, apellido, nombreUsuario, contrasenia, domicilio, dni);
        
    }
    
    public static void enviarDatosNuevoPedido(String alumno, ArrayList<String> nombresArticulos, ArrayList<String> fechaEstimadaArticulos, ArrayList<String> cantidadArticulos, ArrayList<String> precioUnitarioArticulos, ArrayList<String> precioTotalArticulos, String importeTotal, String senia){
        
        //ControladorInterfaz.crearNuevoPedido(alumno, nombresArticulos, fechaEstimadaArticulos, cantidadArticulos, precioUnitarioArticulos, precioTotalArticulos, importeTotal, senia);
        
    }
    
    public static void enviarDatosModificarPedido(String alumno, ArrayList<String> nombresArticulos, ArrayList<String> fechaEstimadaArticulos, ArrayList<String> cantidadArticulos, ArrayList<String> precioUnitarioArticulos, ArrayList<String> precioTotalArticulos, String importeTotal, String senia){
        
        //ControladorInterfaz.modificarPedido(alumno, nombresArticulos, fechaEstimadaArticulos, cantidadArticulos, precioUnitarioArticulos, precioTotalArticulos, importeTotal, senia);
        
    }
    
    public static ArrayList<String> obtenerListaInventario(){
        
        ArrayList<String> asd = new ArrayList<>();
        
        return asd;
        
        //return ControladorInterfaz.enviarDatosInventario();
        
        
    }
    
    public static ArrayList<String> obtenerListaDocumentos(){
        
        ArrayList<String> asd = new ArrayList<>();
        
        return asd;
        
        //return ControladorInterfaz.enviarDatosDocumentos();
        
    }
    
    public static ArrayList<String> obtenerListaPedidos(){
        
        ArrayList<String> asd = new ArrayList<>();
        
        return asd;
        
        //return ControladorInterfaz.enviarDatosPedidos();
        
    }
    
    
    
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {}
    
    
}
