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
    
    public Estado altaUsuario(String nombreRecibido, String apellidoRecibido, String nombreUsuarioRecibido, String contraseniaRecibido, String calleDomicilioRecibido, String numeroDomicilioRecibido, String DNIRecibido){
        //se verifica que el que de de alta sea admin
        //si es admin, se crea el usuario
        //si no lo es, se deniega
        
        AlfaNumerico nombre = ModeloInterfaz.getAlfaNumerico(nombreRecibido);
        nombre.guardar();
        AlfaNumerico apellido = ModeloInterfaz.getAlfaNumerico(apellidoRecibido);
        apellido.guardar();
        AlfaNumerico nombreUsuario = ModeloInterfaz.getAlfaNumerico(nombreUsuarioRecibido);
        nombreUsuario.guardar();
        AlfaNumerico contrasenia = ModeloInterfaz.getAlfaNumerico(contraseniaRecibido);
        contrasenia.guardar();
        AlfaNumerico calleDomicilio = ModeloInterfaz.getAlfaNumerico(calleDomicilioRecibido);
        calleDomicilio.guardar();
        int numeroDomicilio = Integer.valueOf(numeroDomicilioRecibido);
        Direccion domicilio = ModeloInterfaz.getDireccion(calleDomicilio, numeroDomicilio);
        
        int DNI = Integer.valueOf(DNIRecibido);

        
        Estado exitoAlta = GestorUsuario.altaUsuario(nombre, apellido, nombreUsuario, contrasenia, domicilio, DNI);
        
        
        if(exitoAlta != Estado.DATOS_VALIDOS){
            String mensajeError = exitoAlta.toString();
            int IDError = exitoAlta.getID();
            cargarMensajeError(mensajeError, IDError);
        }
        
        
        return exitoAlta;
    }
    
    public Estado bajaUsuario(String IDusuarioRecibido){
        //se verifica que el que de de alta sea admin
        //si es admin, se baja el usuario
        //si no lo es, se deniega
        int IDusuario = Integer.valueOf(IDusuarioRecibido);
        Estado exitoBaja = GestorUsuario.bajaUsuario(IDusuario);
        return exitoBaja;
    }
    
    public Estado modificacionUsuario(String IDusuarioRecibido, String nombreRecibido, String apellidoRecibido, String nombreUsuarioRecibido, String contraseniaRecibido, String calleDomicilioRecibido, String numeroDomicilioRecibido, String DNIRecibido){
        //ningun atributo extra es necesario para automidificarse
        //para modificaciones extras:
        //se verifica que el que de de alta sea admin
        //si es admin, se baja el usuario
        //si no lo es, se deniega
        int IDusuario = Integer.valueOf(IDusuarioRecibido);
        AlfaNumerico nombre = ModeloInterfaz.getAlfaNumerico(nombreRecibido);
        nombre.guardar();
        AlfaNumerico apellido = ModeloInterfaz.getAlfaNumerico(apellidoRecibido);
        apellido.guardar();
        AlfaNumerico nombreUsuario = ModeloInterfaz.getAlfaNumerico(nombreUsuarioRecibido);
        nombreUsuario.guardar();
        AlfaNumerico contrasenia = ModeloInterfaz.getAlfaNumerico(contraseniaRecibido);
        contrasenia.guardar();
        AlfaNumerico calleDomicilio = ModeloInterfaz.getAlfaNumerico(calleDomicilioRecibido);
        calleDomicilio.guardar();
        int numeroDomicilio = Integer.valueOf(numeroDomicilioRecibido);
        Direccion domicilio = ModeloInterfaz.getDireccion(calleDomicilio, numeroDomicilio);
        
        int DNI = Integer.valueOf(DNIRecibido);
        
        Estado exitoModificacion = GestorUsuario.modificacionUsuario(IDusuario, nombre, apellido, nombreUsuario, contrasenia, domicilio, DNI);
        
        
        if(exitoModificacion != Estado.DATOS_VALIDOS){
            String mensajeError = exitoModificacion.toString();
            int IDError = exitoModificacion.getID();
            cargarMensajeError(mensajeError, IDError);
        }
        
        return exitoModificacion;
    }
    
    /*
    * 
    *   CLIENTE
    *
    */
    
    public void adicionarClienteComoInvitado(String nombreClienteInvitado){
        //todo
    }
    
    public Estado adicionarClienteComoRegistrado(String legajoRecibido, String nombreClienteRecibido, String apellidoRecibido, String direccionRecibido, String numeroRecibido, String dniClienteRecibido){
        
        int legajo = Integer.valueOf(legajoRecibido);
        AlfaNumerico nombreCliente = ModeloInterfaz.getAlfaNumerico(nombreClienteRecibido);
        nombreCliente.guardar();
        AlfaNumerico apellidoCliente = ModeloInterfaz.getAlfaNumerico(apellidoRecibido);
        apellidoCliente.guardar();
        AlfaNumerico direccionCliente = ModeloInterfaz.getAlfaNumerico(direccionRecibido);
        direccionCliente.guardar();
        int numeroCalle = Integer.valueOf(numeroRecibido);
        int dniCliente = Integer.valueOf(dniClienteRecibido);
        
        Estado exitoAlta = GestorCliente.altaCliente(legajo, nombreCliente, apellidoCliente, direccionCliente, numeroCalle, dniCliente);
        return exitoAlta;
    }
    
    public Estado modificacionClienteComoRegistrado(String legajoRecibido, String nombreClienteRecibido, String apellidoRecibido, String direccionRecibido, String numeroRecibido, String dniClienteRecibido){
        int legajo = Integer.valueOf(legajoRecibido);
        AlfaNumerico nombreCliente = ModeloInterfaz.getAlfaNumerico(nombreClienteRecibido);
        nombreCliente.guardar();
        AlfaNumerico apellidoCliente = ModeloInterfaz.getAlfaNumerico(apellidoRecibido);
        apellidoCliente.guardar();
        AlfaNumerico direccionCliente = ModeloInterfaz.getAlfaNumerico(direccionRecibido);
        apellidoCliente.guardar();
        int numeroCalle = Integer.valueOf(numeroRecibido);
        int dniCliente = Integer.valueOf(dniClienteRecibido);
        
        Estado exitoAlta = GestorCliente.modificacionCliente(legajo, nombreCliente, apellidoCliente, direccionCliente, numeroCalle, dniCliente);
        return exitoAlta;
    }
    
    public Estado bajaClienteComoRegistrado(String legajoRecibido){
        int legajo = Integer.valueOf(legajoRecibido);
        Estado exitoBaja = GestorCliente.bajaCliente(legajo);
        return exitoBaja;
    }
    
    /*
    * 
    *   ARTICULO
    *
    */
    
    public Estado crearArticulo(String nombreRecibido, String autorRecibido, String precioRecibido, String materiaRecibido){
        
        AlfaNumerico nombre = ModeloInterfaz.getAlfaNumerico(nombreRecibido);
        nombre.guardar();
        AlfaNumerico autor = ModeloInterfaz.getAlfaNumerico(autorRecibido);
        autor.guardar();
        AlfaNumerico materia = ModeloInterfaz.getAlfaNumerico(materiaRecibido);
        materia.guardar();
        float precio = Float.valueOf(precioRecibido);
        
        
        Estado exitoAlta = GestorArticulo.altaArticulo(nombre, autor, precio, materia);
        return exitoAlta;
    }
    
    public Estado modificacionArticulo(String IDArticuloRecibido, String nombreRecibido, String autorRecibido, String precioRecibido, String materiaRecibido){
        int IDArticulo = Integer.valueOf(IDArticuloRecibido);
        
        AlfaNumerico nombre = ModeloInterfaz.getAlfaNumerico(nombreRecibido);
        nombre.guardar();
        AlfaNumerico autor = ModeloInterfaz.getAlfaNumerico(autorRecibido);
        autor.guardar();
        AlfaNumerico materia = ModeloInterfaz.getAlfaNumerico(materiaRecibido);
        materia.guardar();
        double precio = Double.valueOf(precioRecibido);
        
        
        Estado exito = GestorArticulo.modificacionArticulo(IDArticulo, nombre, autor, precio, materia);
        
        return exito;
        
    }
    
    public Estado bajaArticulo(String IDArticuloRecibido){
        int IDArticulo = Integer.valueOf(IDArticuloRecibido);
        Estado exito = GestorArticulo.bajaArticulo(IDArticulo);
        return exito;
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
        codigo.guardar();
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
