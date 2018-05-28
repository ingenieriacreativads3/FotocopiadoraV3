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
     * Esta rutina verifica la existencia del password para un usuario
     * específico.
     * @param password
     * @return
     */
    public static boolean existePass(String nombreUsuario, String passwordUsuario){
        
        //Establecer un valor por defecto
        boolean existe = false;
        
        
        
        return existe;
        
    }
    
    /**
     *Esta rutina verifica la existencia de un usuario.
     * @return
     */
    public static boolean existeUsuario(){
        
        boolean existe = false;
        
        
        
        return existe;
        
    }
    
    /**
     *Este método
     * @return
     */
    public static Nombre getSiguienteCodigoPedido() {

        Nombre nombreDevolver = Nombre.objetoInvalido;

        //TODO devolver el siguiente de la lista, no null
        return nombreDevolver;

    }
    
    public static Pedido getNuevoPedido() {

        Pedido pedidoDevolver = Pedido.nuevo();

        return pedidoDevolver;

    }
    
    public static Alumno getNuevoAlumno(){
        
        Alumno alumnoDevolver = Alumno.nuevo();
        
        
        
        return alumnoDevolver;
        
    }
    
    public static Nombre getNombreAlumnoByAlumno(Alumno alumnorecibido){
        
        Nombre nombreDevolver = Nombre.objetoInvalido;
        
        
        
        return nombreDevolver;
        
    }
    
}
