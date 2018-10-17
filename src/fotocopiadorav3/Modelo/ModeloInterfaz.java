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
    
    /**
     * Esta rutina verifica la existencia del password
     * para un usuario específico.
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
     *Esta rutina verifica la existencia de un usuario.
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
     *Este método devuelve el siguiente identificador de pedido
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
    
    public static Usuario getNuevoUsuario(){
        
        Persona personaFinal = Persona.nuevo();
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
