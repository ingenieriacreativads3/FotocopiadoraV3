/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Controlador;
import fotocopiadorav3.Modelo.*;
import java.util.*;
import jdk.nashorn.internal.objects.NativeArray;
/**
 * Esta clase se encarga de las cuestiones relacionadas con la gestion de los
 * pedidos. Crear pedidos, modificar pedidos, cancelar pedidos.
 *
 * @author Alonso David
 */
public class GestorPedido {

    /**
     * Method para crear un pedido. Recive por parametro: Un libro y su cantidad
     * Un legajo.
     *
     * El method deberia devolver una clave de pedido. La clave de pedido es el
     * valor con el cual un cliente puede retirar el pedido.
     * @param IDAlumno
     * @param fechaActual
     * @param importe
     * @param senia
     * @return 
     */
    protected Estado crearPedido(int IDAlumno, java.sql.Date fechaActual, double importe, double senia, List<Articulo>Articulos) {
        /**
         * Se inicializan las variabes. Generar una clave de pedido "IDPedido"
         * Persistir en la base de datos un nuevo pedido. Devolver un ID de
         * pedido
         *
         */

        Estado exitoAlta = Estado.ERROR;
        
        Alumno alumnoExistente = ModeloInterfaz.getAlumnoForId(IDAlumno);
        AlfaNumerico codTransaccion = ModeloInterfaz.getSiguienteCodigoTransaccion();
        codTransaccion.guardar();
        Pedido nuevoPedido = ModeloInterfaz.getNuevoPedido(fechaActual, importe, alumnoExistente, codTransaccion, importe);
        exitoAlta = nuevoPedido.guardar();

        for (Articulo Articuloitem : Articulos) {
            PedidoArticulo nuevoItemPedido = ModeloInterfaz.getNuevoPedidoArticulo(importe, 1, Estado.ITEM_PEDIDO_REGISTRADO, Articuloitem, nuevoPedido, importe, true);
            nuevoItemPedido.guardar();
        }
       
        return exitoAlta;
    }

    /**
     * Method para modificar un pedido.
     *
     * Agrega libros o quita libros del pedido.
     *
     */
    protected Estado modificarPedido(int IDPedido, int IDAlumno, double importe, double senia, java.sql.Date fechaPedido, AlfaNumerico codigoTransaccion, List<Articulo>Articulos) {
        Estado exitoModificado = Estado.ERROR;
        
        Pedido pedidoAModificar = ModeloInterfaz.getPedidoForId(IDPedido);
        Alumno alumnoDelPedido = ModeloInterfaz.getAlumnoForId(IDAlumno);
        exitoModificado = pedidoAModificar.modificar(fechaPedido, importe, alumnoDelPedido, codigoTransaccion, importe);
        
        for (Articulo Articuloitem : Articulos) {
            PedidoArticulo nuevoItemPedido = ModeloInterfaz.getNuevoPedidoArticulo(importe, 1, Estado.ITEM_PEDIDO_REGISTRADO, Articuloitem, pedidoAModificar, importe, true);
            nuevoItemPedido.guardar();
        }
        
        
        return exitoModificado;
    }
    
    
    
}
