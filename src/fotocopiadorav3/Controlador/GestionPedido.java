/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Controlador;

/**
 * Esta clase se encarga de las cuestiones relacionadas con la gestion de los
 * pedidos. Crear pedidos, modificar pedidos, cancelar pedidos.
 * 
 * @author Alonso David
 */
public class GestionPedido {
    
    /**
     * Metodo para crear un pedido. 
     * Recive por parametro:
     * Un libro y su cantidad
     * Un legajo.
     * 
     * El metodo deberia devolver una clave de pedido.
     * La clave de pedido es el valor con el cual un cliente puede retirar
     * el pedido.
     */
    protected String crearPedido(String _nombrePresona, String _apellidoPersona, String _IDFotocopia, double _seña){
     
        /**
      * Se inicializan las variabes.
      * Generar  una clave de pedido "IDPedido"
      * Persistir en la base de datos un nuevo pedido.
      * Devolver un ID de pedido
      * 
      */
     String IDPedido=null;
     
     ClavePedido GeneradorDeClave = new ClavePedido();
     //IDPedido=GeneradorDeClave.GenerarClave();
     
     return IDPedido;
    }
    
    /**
         * Metodo para modificar un pedido.
         * 
         * Agrega libros o quita libros del pedido.
         * 
         */
    protected void modificarPedido(){
        
    }
    
    /**
    * Metodo que deja sentado que el fotocopiado de algun libro fue hecho
    */
    protected void registrarFotocopiado(){
        
    }
    /**
    * Metodo para cancelar pedido.
    */
    protected void cancelarPedido(){
        
    }
    /**
    * Metodo que registra un retiro de pedido.
    * Recibe como paremetro un numero de pedido.
    */
    protected void retirarPedido(){
        
    }
    
    
}
