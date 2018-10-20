/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fotocopiadorav3.Modelo;

/**
 * Esta clase determina la conexion con el exterior del paquete.
 * Aqui se reciben parametros y se solicitan datos por medio
 * de métdos estáticos. Desde ya muchas gracias.
 * 
 * 
 @author Tomas
 */
public class ModeloInterfaz {
    
    public static Direccion getDireccion(AlfaNumerico calleRecibida, int numeroRecibido){
        
        Direccion direccionDevolver = Direccion.OBJETO_INVALIDO;
        
        Direccion direccionNueva = Direccion.nuevo(calleRecibida, numeroRecibido);
        direccionDevolver = direccionNueva;
        
        return direccionDevolver;
        
    }
    
    public static AlfaNumerico getAlfaNumerico(String palabraRecibida){
        
        AlfaNumerico alfaNumericoDevolver = AlfaNumerico.nuevo(palabraRecibida);
        
        return alfaNumericoDevolver;
        
    }
    
    public static Usuario getUsuario(){
        
        Usuario usuarioDevolver = Usuario.nuevo(Persona.OBJETO_INVALIDO);
        
        return usuarioDevolver;
        
    }
    
    /**
     * Esta rutina verifica la existencia del password
 para un alfaNumericoDevolver específico.
     * 
     * @param nombreUsuario
     * @param passwordUsuario
     * @return boolean
     */
    public static Estado verificaUsuarioPassword(String nombreUsuario, String passwordUsuario){
        
        //Establecer un valor por defecto
        Estado usuarioVerificar = Estado.ERROR;
        
        if(nombreUsuario.getClass() == Valor.VERIFICADOR_DE_CLASE_STRING.getClass()){
            
            if(passwordUsuario.getClass() == Valor.VERIFICADOR_DE_CLASE_STRING.getClass()){
                
                usuarioVerificar = Usuario.verificarUsserPass(nombreUsuario, passwordUsuario);
                
            }else{
                
                usuarioVerificar = Estado.ERROR_DATOS_INVALIDOS;
                
            }
            
        }else{
            
            usuarioVerificar = Estado.ERROR_DATOS_INVALIDOS;
            
        }
        
        return usuarioVerificar;
        
    }
    
    /**
     *Esta rutina verifica la existencia de un alfaNumericoDevolver.
     * 
     * @param nombreActual
     * @return boolean
     */
    public static boolean existeUsuario(String nombreActual){
        
        boolean existe = false;
        
        if(Usuario.existeNombreUsuario(nombreActual)){
            
            //...establecer un valor de exitencia
            existe = true;
            
        }else{
            
            //...se establecio un valor por defecto
            
        }
        
        return existe;
        
    }
    
    /**
     *Este method devuelve el siguiente identificador de pedido
     * @return
     */
    public static AlfaNumerico getSiguienteCodigoTransaccion() {

        AlfaNumerico nombreDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        
        
        return nombreDevolver;

    }
    
    /**
     *
     * @return
     */
    public static Pedido getNuevoPedido() {

        Pedido pedidoDevolver = Pedido.nuevo();

        return pedidoDevolver;

    }
    
    public static Alumno getNuevoAlumno(){
        
        Alumno alumnoDevolver = Alumno.nuevo();
        
        
        
        return alumnoDevolver;
        
    }
    
    public static Usuario getNuevoUsuario(AlfaNumerico nombreRecibido, AlfaNumerico apellidoRecibido, int dniRecibido, Direccion direccionRecibida){
        
        Persona personaFinal = Persona.nuevo(nombreRecibido, apellidoRecibido, dniRecibido, direccionRecibida);
        Usuario usuarioDevolver = Usuario.nuevo(personaFinal);
        
        return usuarioDevolver;
        
    }
    
    
        // - David Alonso
    public static Estado adicionarArticulo(String nombre, String autor, float precio, String materia){
        Estado creacion = Estado.ERROR;
        
        //No entiendo tus clases
        
        return creacion;
    }
    
    public static Estado adicionarUsuario(String nombre, String permisos){
        Estado creacion = Estado.ERROR;
        
        //No entiendo tus clases
        
        return creacion;
    }
    
}
