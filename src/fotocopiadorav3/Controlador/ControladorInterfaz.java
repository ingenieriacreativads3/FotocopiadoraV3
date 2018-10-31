/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Controlador;

import fotocopiadorav3.Modelo.*;
import fotocopiadorav3.Vista2.*;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;

/**

 @author Alonso David
 */
public class ControladorInterfaz extends Application{
    
    protected GestorPedido GestorPedidos = new GestorPedido();
    //protected GestorCuenta GestorCuenta = new GestorCuenta();
    protected GestorUsuario GestorUsuario = new GestorUsuario();
    protected GestorCliente GestorCliente = new GestorCliente();
    protected GestorArticulo GestorArticulo = new GestorArticulo();
    public static String[] argumentos;
    
    
    /*
    * 
    *   CUENTA
    *
    */
    
    public static void iniciarSesion(String usuario, String contrasenia){
        
        System.out.println("interfaz controlador");
        
        Estado estadoVerificacion;
        estadoVerificacion = GestorCuenta.VerificarUsuarioYContraseña(usuario, contrasenia);
        if(estadoVerificacion == Estado.USSER_PASS_CORRECTOS){
            
            cargarPaginaPrincipal();
            
        }else{
            
            String mensajeError = estadoVerificacion.toString();
            int IDError = estadoVerificacion.getID();
            cargarMensajeError(mensajeError, IDError);
            
        }
    }
    
    
    /*
    * 
    *   USUARIO
    *
    */
    
    public void altaUsuario(String nombreRecibido, String apellidoRecibido, String nombreUsuarioRecibido, String contraseniaRecibido, String calleDomicilioRecibido, String numeroDomicilioRecibido, String DNIRecibido){
        //se verifica que el que de de alta sea admin
        //si es admin, se crea el usuario
        //si no lo es, se deniega
        
        AlfaNumerico nombre = ModeloInterfaz.getNuevoAlfaNumerico(nombreRecibido);
        
        AlfaNumerico apellido = ModeloInterfaz.getNuevoAlfaNumerico(apellidoRecibido);
        
        AlfaNumerico nombreUsuario = ModeloInterfaz.getNuevoAlfaNumerico(nombreUsuarioRecibido);
        
        AlfaNumerico contrasenia = ModeloInterfaz.getNuevoAlfaNumerico(contraseniaRecibido);
        
        AlfaNumerico calleDomicilio = ModeloInterfaz.getNuevoAlfaNumerico(calleDomicilioRecibido);
        int numeroDomicilio = Integer.valueOf(numeroDomicilioRecibido);
        Direccion domicilio = ModeloInterfaz.getDireccion(calleDomicilio, numeroDomicilio);
        
        int DNI = Integer.valueOf(DNIRecibido);

        
        Estado exitoAlta = GestorUsuario.altaUsuario(nombre, apellido, nombreUsuario, contrasenia, domicilio, DNI);
        
        
        if(exitoAlta != Estado.DATOS_VALIDOS){
            String mensajeError = exitoAlta.toString();
            int IDError = exitoAlta.getID();
            cargarMensajeError(mensajeError, IDError);
        }
        
        
        
    }
    
    public void bajaUsuario(String IDusuario){
        //se verifica que el que de de alta sea admin
        //si es admin, se baja el usuario
        //si no lo es, se deniega
        AlfaNumerico IDusuarioRecibido = ModeloInterfaz.getAlfaNumerico(IDusuario);
        Estado exitoBaja = GestorUsuario.bajaUsuario(IDusuarioRecibido);
    }
    
    public void modificacionUsuario(String IDusuarioRecibido, String nombreRecibido, String apellidoRecibido, String nombreUsuarioRecibido, String contraseniaRecibido, String calleDomicilioRecibido, String numeroDomicilioRecibido, String DNIRecibido){
        //ningun atributo extra es necesario para automidificarse
        //para modificaciones extras:
        //se verifica que el que de de alta sea admin
        //si es admin, se baja el usuario
        //si no lo es, se deniega
        AlfaNumerico IDusuario = ModeloInterfaz.getAlfaNumerico(IDusuarioRecibido);
        
        AlfaNumerico nombre = ModeloInterfaz.getAlfaNumerico(nombreRecibido);
        
        AlfaNumerico apellido = ModeloInterfaz.getAlfaNumerico(apellidoRecibido);
        
        AlfaNumerico nombreUsuario = ModeloInterfaz.getAlfaNumerico(nombreUsuarioRecibido);
        
        AlfaNumerico contrasenia = ModeloInterfaz.getAlfaNumerico(contraseniaRecibido);
        
        AlfaNumerico calleDomicilio = ModeloInterfaz.getAlfaNumerico(calleDomicilioRecibido);
        int numeroDomicilio = Integer.valueOf(numeroDomicilioRecibido);
        Direccion domicilio = ModeloInterfaz.getDireccion(calleDomicilio, numeroDomicilio);
        
        int DNI = Integer.valueOf(DNIRecibido);
        
        Estado exitoModificacion = GestorUsuario.modificacionUsuario(IDusuario, nombre, apellido, nombreUsuario, contrasenia, domicilio, DNI);
        
        
        if(exitoModificacion != Estado.DATOS_VALIDOS){
            String mensajeError = exitoModificacion.toString();
            int IDError = exitoModificacion.getID();
            cargarMensajeError(mensajeError, IDError);
        }
        
    }
    
    /*
    * 
    *   CLIENTE
    *
    */
    
    public void adicionarClienteComoInvitado(String nombreClienteInvitado){
        //todo
    }
    
    public void adicionarClienteComoRegistrado(String legajoRecibido, String nombreClienteRecibido){
        AlfaNumerico nombreCliente = ModeloInterfaz.getAlfaNumerico(nombreClienteRecibido);
        int legajo = Integer.valueOf(legajoRecibido);
        
        Estado exitoAlta = GestorCliente.altaCliente(legajo, nombreCliente);
    }
    
    public void modificacionClienteComoRegistrado(String legajoRecibido, String nombreClienteRecibido){
        AlfaNumerico nombreCliente = ModeloInterfaz.getAlfaNumerico(nombreClienteRecibido);
        int legajo = Integer.valueOf(legajoRecibido);
        
        Estado exitoAlta = GestorCliente.modificacionCliente(legajo, nombreCliente);
    }
    
    public void bajaClienteComoRegistrado(String legajoRecibido){
        int legajo = Integer.valueOf(legajoRecibido);
        Estado exitoAlta = GestorCliente.bajaCliente(legajo);
    }
    
    /*
    * 
    *   ARTICULO
    *
    */
    
    public void crearArticulo(String nombreRecibido, String autorRecibido, String precioRecibido, String materiaRecibido){
        
        AlfaNumerico nombre = ModeloInterfaz.getAlfaNumerico(nombreRecibido);
        
        AlfaNumerico autor = ModeloInterfaz.getAlfaNumerico(autorRecibido);
        
        AlfaNumerico materia = ModeloInterfaz.getAlfaNumerico(materiaRecibido);
        
        float precio = Float.valueOf(precioRecibido);
        
        
        Estado exitoAlta = GestorArticulo.altaArticulo(nombre, autor, precio, materia);
    }
    
    public void modificacionArticulo(AlfaNumerico IDArticulo, String nombreRecibido, String autorRecibido, String precioRecibido, String materiaRecibido){
        AlfaNumerico nombre = ModeloInterfaz.getAlfaNumerico(nombreRecibido);
        
        AlfaNumerico autor = ModeloInterfaz.getAlfaNumerico(autorRecibido);
        
        AlfaNumerico materia = ModeloInterfaz.getAlfaNumerico(materiaRecibido);
        
        float precio = Float.valueOf(precioRecibido);
        
        
        GestorArticulo.modificacionArticulo(IDArticulo, nombre, autor, precio, materia);
        
        
        
    }
    
    public void bajaArticulo(AlfaNumerico IDArticulo){
        GestorArticulo.bajaArticulo(IDArticulo);
    }
    /*
    * 
    *   PEDIDO
    *
    */
    
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
    public void modificaconPedido(){
        
    }
    
    //se cambia el estado de pedido, si ya esta impreso el pedido va al inventario como "cancelado"
    public void cancelarPedido(){
        
    }
    
    protected String getNumeroDeTransaccion(){
        String IDPedido;
        
        AlfaNumerico codigo = ModeloInterfaz.getSiguienteCodigoTransaccion();
        
        IDPedido = codigo.toString();
        
        return IDPedido;
    }
    
    
    /*
    * 
    *   INTERFAZ
    *
    */
    
    /*
    Este method es llamado cuando el usuario y la contraseña son correctos, se debe cargar la pagina principal
    con los pedidos cuyos estados sean pediente o terminados(no buscados)
    */
    
    public static void comenzar(){
        
        Vista2Interfaz.renderizarLogin();
        
    }

    public static void cargarPaginaPrincipal(){
        Vista2Interfaz.renderizarPaginaPrincipal();
    }
    
    public static void cargarMensajeError(String mensajeError, int IDError){
        //Vista2Interfaz.renderizarMensajeError(mensajeError);
    }
    
    //Se cargara entonces los pedidos con estado impreso y cancelado
   
    @Override
    public void start(Stage primaryStage) throws Exception {}
    
    public static void salirAplicacion() {}
}
