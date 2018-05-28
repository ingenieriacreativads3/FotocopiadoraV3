/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fotocopiadorav3.Modelo;

/**

 @author Tomas
 */
public class ModeloInterfaz{
    
    public static Nombre getSiguienteCodigoPedido(){
        
        Nombre nombreDevolver = Nombre.objetoInvalido;
        
        //TODO devolver el siguiente de la lista, no null
        
        return nombreDevolver;
        
    }
    
    public static Pedido getNuevoPedido(){
        
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
    //Tomas, necesito un metodo que verifique que el usuario y la contraseña
    //Son validos.
}
