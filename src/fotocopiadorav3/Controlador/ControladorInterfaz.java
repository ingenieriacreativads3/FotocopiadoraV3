/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Controlador;

/**

 @author Alonso David
 */
public class ControladorInterfaz{
    protected GestionPedido GestorPedidos = new GestionPedido();
   
    /**
     * Clase que se encarga de la creacion del pedido
     * @parametros: nombre persona, apellido persona, ID fotocopia, seña.
     * Se calcula fecha actual?
     * @return: true si se creo el pedido, false en caso contrario
     */
    public String crearPedido(String _nombrePersona, String _apellidoPersona, String _IDFotocopia, double _seña){
        String IDPedido;//preguntar por out
        try{
            IDPedido = GestorPedidos.crearPedido(_nombrePersona, _apellidoPersona, _IDFotocopia, _seña);
            return IDPedido;
        }catch(Exception e){
            return null;
        }
    }
}
