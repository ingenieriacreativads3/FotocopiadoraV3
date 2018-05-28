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
    
    protected GestorPedido GestorPedidos = new GestorPedido();
    
    
    /**
     * Clase que se encarga de la creacion del pedido
     * @param nombrePersona
     * @param apellidoPersona
     * @param identificadorDocumento
     * @param seña
     * Se calcula fecha actual?
     * @return: true si se creo el pedido, false en caso contrario
     */
    public String crearPedido(String nombrePersona, String apellidoPersona, String identificadorDocumento, double seña){
        
        String IDPedido;
        
        try {
            IDPedido = GestorPedidos.crearPedido (nombrePersona, apellidoPersona, identificadorDocumento, seña);
            return IDPedido;
        }catch (Exception e) {
            return null;
        }
    }
    
    
    
    
}
