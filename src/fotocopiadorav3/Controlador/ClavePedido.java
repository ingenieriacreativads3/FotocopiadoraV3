/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Controlador;

/**
 * Esta clase genera una clave de pedido
 * 
 * Tiene en cuenta si el cliente es de UTN o USES.
 * Tiene en cuenta de que carrera es el cliente
 * @author Alonso David
 */
public class ClavePedido {
    protected char facultad;
    protected char carrera;
    protected int cantFotocopias;
    
    
    
    protected int primerProximoNumeroFotocopias(){
        /**
         * Metodo que devuelve el proximo valor para anexar a la clave
         * 
         * Hace una consulta unica a la base de datos, una sola vez por
         * inicio de secion.
         * Guarda el valor para su posterior uso.
         * 
         */
        
        return cantFotocopias;
    }
}
