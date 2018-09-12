/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Controlador;

import fotocopiadorav3.Modelo.*;
import fotocopiadorav3.Vista.LoginController;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**

 @author Alonso David
 */
public class ControladorInterfaz extends Application{
    
    protected GestorPedido GestorPedidos = new GestorPedido();
    protected GestorCuenta GestorCuenta = new GestorCuenta();
    
    
    /**
     * Clase que se encarga de la creacion del pedido
     * @param nombreYApellidoPersona
     * @param identificadorDocumento
     * @param seña
     * Se calcula fecha actual?
     * @return: true si se creo el pedido, false en caso contrario
     */
    public String crearPedido(String nombreYApellidoPersona, String identificadorDocumento, double seña){
        
        String identificadorPedido;
        
        try {
            identificadorPedido = GestorPedidos.crearPedido (nombreYApellidoPersona, identificadorDocumento, seña);
            return identificadorPedido;
        }catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Metodo para verificar la existencia del usuario.
     * Verificar si el usuario y contraseña ingresada corresponden.
     * 
     * @param usuario
     * @param contraseña
     * @return Estado
     */
    public Estado VerificarUsuarioYContraseña(String usuario, String contraseña){
        
        Estado exitoAlIniciar = Estado.ERROR;
        //Primero se debe verificar si existe el usuario.
        //Luego se debe verificar si el usuairo y la contraseña son correctas
        try{
            if(ModeloInterfaz.existeUsuario(usuario)){
                exitoAlIniciar = ModeloInterfaz.verificaUsuarioPassword(usuario, contraseña);
            }
            else{
                exitoAlIniciar = Estado.ERROR_NOMBRE_INEXISTENTE;
            }
            return exitoAlIniciar;
        }catch(Exception e){
            return exitoAlIniciar;
        }
    }
    
    /*
    Este metodo es llamado cuando el usuario y la contraseña son correctos, se debe cargar la pagina principal
    con los pedidos cuyos estados sean pediente o terminados(no buscados)
    */
    public void cargarPaginaPrincipal(){
        //Se cargara entonces los pedidos con estado pendiente y terminado
        //Hay que definir como se cargaria
        //Digamos, le paso un objeto pedido
    }
    
    /*
    crea un pedido
    */
    public void nuevoPedido(String nombre, String apellido, List<String>documento, int cantidad, float seña){
        //se toman los datos de los parametros
        //se crea un pedido con sus items
        //ModeloInterfaz.
        
        //se genera un estado: Pendiente
        //se persisten
    }
    
    //En el modificar me deberia llegar un documento
    public void modificarPedido(){
        
    }
    
    //se cambia el estado de pedido, si ya esta impreso el pedido va al inventario como "cancelado"
    public void cancelarPedido(){
        
    }
    
    //Se cargara entonces los pedidos con estado impreso y cancelado
    public void cargarInventario(){
        
    }
    
    public static void comenzar(String[] args){
        
        launch(LoginController.class, args);
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
    }
    
}
