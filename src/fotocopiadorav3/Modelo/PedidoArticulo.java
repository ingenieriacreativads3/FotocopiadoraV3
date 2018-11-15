/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;

import java.util.*;
import java.sql.*;

/**
 *
 * @author Tomás Contreras
 */
public class PedidoArticulo {
    
    //Atributos
    
    private static final String NOMBRE_TABLA = "pedido_articulo";
    
    private static final String CAMPO_ID = "id";
    private static final String CAMPO_SUBTOTAL = "subtotal";
    private static final String CAMPO_CANTIDAD = "cantidad";
    private static final String CAMPO_ID_ESTADO = "id_estado";
    private static final String CAMPO_ID_ARTICULO = "id_articulo";
    private static final String CAMPO_ID_PEDIDO = "id_pedido";
    private static final String CAMPO_IMPORTE_CON_DESCUENTO = "importe_con_descuento";
    private static final String CAMPO_SE_COBRO_CON_DESCUENTO = "se_cobro_con_descuento";
    
    private static final int CANTIDAD_DE_CAMPOS = 8;
    private static final int LUGAR_DEL_CAMPO_ID = 1;
    private static final int LUGAR_DEL_CAMPO_SUBTOTAL = 2;
    private static final int LUGAR_DEL_CAMPO_CANTIDAD = 3;
    private static final int LUGAR_DEL_CAMPO_ID_ESTADO = 4;
    private static final int LUGAR_DEL_CAMPO_ID_ARTICULO = 5;
    private static final int LUGAR_DEL_CAMPO_ID_PEDIDO = 6;
    private static final int LUGAR_DEL_CAMPO_IMPORTE_CON_DESCUENTO = 7;
    private static final int LUGAR_DEL_CAMPO_SE_COBRO_CON_DESCUENTO = 8;
    
    private int id;                   //tipo bd
    private double subtotal;                //tipo bd
    private int cantidad;                   //tipo bd
    
    /**
     * Este permite identificar los diferentes estados de un item 
     * pedido. Esto es, las transiciones entre un item registrado,
     * fotocopiado, cancelado sin fotocopiar, 
     * cancelado fotocopiado y retirado.
     * 
     */
    private Estado estado;                  //id identificador
    private Articulo articulo;              //id identificador
    private Pedido pedido;                  //id identificador
    private double importeConDescuento;     //tipo bd
    private boolean seCobroConDescuento;    //tipo bd
    
    private int idEstado;
    private int idArticulo;
    private int idPedido;
            
    protected final static PedidoArticulo OBJETO_INVALIDO = new PedidoArticulo();

    private static Set<PedidoArticulo> listaObjetos = new HashSet<>();

    //Rutinas
    
    public Estado modificar(double subtotalRecibido, int cantidadRecibida, Estado estadoRecibido, Articulo articuloRecibido, Pedido pedidoRecibido, double importeConDescuentoRecibido, boolean  seCobroConDescuentoRecibido){
        
        Estado estadoDevolver = Estado.ERROR;
        
        this.borrar();
        PedidoArticulo nuevoObjeto = PedidoArticulo.nuevo(subtotalRecibido, cantidadRecibida, estadoRecibido, articuloRecibido, pedidoRecibido, importeConDescuentoRecibido, seCobroConDescuentoRecibido);
        nuevoObjeto.setId(this.id);
        
        if(nuevoObjeto.guardar() == Estado.EXITO){
            
            estadoDevolver = Estado.EXITO;
            
        }else{
            
            nuevoObjeto.borrar();
            
        }
        
        return estadoDevolver;
    }
    
    public Estado borrar(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatementD(NOMBRE_TABLA);
        
        try {
            
            prepared.setInt(LUGAR_DEL_CAMPO_ID, this.id);
            
            //System.out.println(prepared.toString());
            
            if(listaObjetos.remove(this)){
                
                prepared.executeUpdate();
                estadoDevolver = Estado.EXITO;
                
            }else{
                
                estadoDevolver = Estado.ERROR_LISTA_REMOVE;
                
            }
            
            prepared.close();
            conn.closeConn("borrar");
            
        } catch (Exception e) {
            System.out.println("se rompe en borrar");
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        return estadoDevolver;
    }
    
    protected static PedidoArticulo getForId(int idRecibido){
        
        PedidoArticulo pedidoArticuloDevolver = OBJETO_INVALIDO;
        
        Estado seObtuvo = Estado.EXITO;
        //Estado seObtuvo = getInformacion();
        
        if(listaObjetos != null){
            
            if(seObtuvo == Estado.EXITO){

                for(PedidoArticulo pedidoArticuloActual : listaObjetos){

                    if(pedidoArticuloActual.id == idRecibido){

                        pedidoArticuloDevolver = pedidoArticuloActual;

                    }else{

                        //...se establecion un valor por defecto

                    }
                }

            }else{

                //TODO capturar el error producido por no haber capturado la info de la db
                System.out.println("Se rompio en Direccion.getForId();");

            }
            
        }else{
            
            //...no hacer nada
            
        }
        return pedidoArticuloDevolver;
        
    }
    
    public Estado guardar(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(CANTIDAD_DE_CAMPOS, NOMBRE_TABLA);
        
        //System.out.println("entra a guardar");
        try {
            
            prepared.setInt(LUGAR_DEL_CAMPO_ID, this.id);
            prepared.setDouble(LUGAR_DEL_CAMPO_SUBTOTAL, this.subtotal);
            prepared.setInt(LUGAR_DEL_CAMPO_CANTIDAD, this.cantidad);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_ESTADO, this.idEstado);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_ARTICULO, this.idArticulo);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_PEDIDO, this.idPedido);
            prepared.setDouble(LUGAR_DEL_CAMPO_IMPORTE_CON_DESCUENTO, this.importeConDescuento);
            prepared.setBoolean(LUGAR_DEL_CAMPO_SE_COBRO_CON_DESCUENTO, this.seCobroConDescuento);
            
            System.out.println(prepared.toString());
            
            prepared.executeUpdate();
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            conn.closeConn(PedidoArticulo.class.toString() + "guardar");
            
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            System.out.println("se rompe en la persistencia de " + Articulo.class.toString() + " guardar");
            e.printStackTrace();
            
        }
        
        return estadoDevolver;
        
    }
    
    protected static Estado getInformacion(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ResultSet rs = null;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(NOMBRE_TABLA);
        
        try {
            
            rs = prepared.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(CAMPO_ID);
                double subtotal = rs.getDouble(CAMPO_SUBTOTAL);
                int cantidad = rs.getInt(CAMPO_CANTIDAD);
                int idEstado = rs.getInt(CAMPO_ID_ESTADO);
                int idArticulo = rs.getInt(CAMPO_ID_ARTICULO);
                int idPedido = rs.getInt(CAMPO_ID_PEDIDO);
                double importeConDescuento = rs.getDouble(CAMPO_IMPORTE_CON_DESCUENTO);
                boolean seCobroConDescuento = rs.getBoolean(CAMPO_SE_COBRO_CON_DESCUENTO);
                
                Estado estadoObjeto = Estado.getForId(idEstado);
                Articulo articuloObjeto = Articulo.getForId(idArticulo);
                Pedido pedidoObjeto = Pedido.getForId(idPedido);
                
                PedidoArticulo asd = PedidoArticulo.nuevo(id, subtotal, cantidad, estadoObjeto, articuloObjeto, pedidoObjeto, importeConDescuento, seCobroConDescuento, estadoObjeto.getId(), articuloObjeto.getId(), pedidoObjeto.getId());
                
                //System.out.println("este es el pedidoArticulo numero: " + asd.id);
                
            }
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            conn.closeConn(PedidoArticulo.class.toString() + "getInformacion");
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        return estadoDevolver;
        
    }
    
    private static int getLastId(){
        
        int ultimoID = 0;
        
        Estado estadoConsulta = Estado.EXITO;
        //Estado estadoConsulta = getInformacion();

        if(listaObjetos != null){
            
            System.out.println("la lista no es nula");

            if(estadoConsulta == Estado.EXITO){

                for(PedidoArticulo pedidoArticuloActual : listaObjetos){

                    if(pedidoArticuloActual.id > ultimoID){

                        ultimoID = pedidoArticuloActual.id;

                    }else{

                        //...no hacer nada

                    }

                }

            }else{

                //...no hacer nada

            }

        }else{

            //...se establecio unvalor por defecto

        }
        
        return ultimoID;
        
    }

    private static int getNewId(){

        //Obtener el ultimo identificador
        int idActual = getLastId();

        //Buscar el siguiente identificador
        int siguienteIdentificador = Valor.SIGUIENTE_IDENTIFICADOR;

        //Combinar ambos valores
        idActual = idActual + siguienteIdentificador;
        //System.out.println("el valor del siuiente id es " + idActual);

        //Devolver el nuevo identificador
        return idActual;

    }

    //Constructor
    
    private static PedidoArticulo nuevo(int idRecibido, double subtotalRecibido, int cantidadRecibida, Estado estadorecibido, Articulo articuloRecibido, Pedido pedidoRecibido, double importeConDescuentoRecibido, boolean seCobroConDescuentoRecibido, int idEstadorecibido, int idArticuloRecibido, int idPedidoRecibido){
        
        PedidoArticulo pedidoArticuloDevolver = new PedidoArticulo();
        
        pedidoArticuloDevolver.id = idRecibido;
        pedidoArticuloDevolver.subtotal = subtotalRecibido;
        pedidoArticuloDevolver.cantidad = cantidadRecibida;
        pedidoArticuloDevolver.estado = estadorecibido;
        pedidoArticuloDevolver.articulo = articuloRecibido;
        pedidoArticuloDevolver.pedido = pedidoRecibido;
        pedidoArticuloDevolver.importeConDescuento = importeConDescuentoRecibido;
        pedidoArticuloDevolver.seCobroConDescuento = seCobroConDescuentoRecibido;
        
        pedidoArticuloDevolver.idEstado = idEstadorecibido;
        pedidoArticuloDevolver.idArticulo = idArticuloRecibido;
        pedidoArticuloDevolver.idPedido = idPedidoRecibido;
        
        Estado seAgrego = PedidoArticulo.addNewObjeto(pedidoArticuloDevolver);
        
        if(!(seAgrego == Estado.EXITO)){
            
            //listaObjetos.remove(usuarioDevolver);
            
        }else{
            
            //...no hacer nada
            
        }
        
        return pedidoArticuloDevolver;
    }
    
    private PedidoArticulo(int identificadorRecibido){
        
        this.id = identificadorRecibido;
        
    }
    
    protected static PedidoArticulo nuevo(double subtotalRecibido, int cantidadRecibida, Estado estadoRecibido, Articulo articuloRecibido, Pedido pedidoRecibido, double importeConDescuentoRecibido, boolean  seCobroConDescuentoRecibido){

        //Crear un objeto a devolver
        PedidoArticulo objetoDevolver = PedidoArticulo.OBJETO_INVALIDO;

        //Obtener el siguiente identificador
        int identificador = getNewId();
        
        //Crear un nuevo objeto
        PedidoArticulo objetoNuevo = new PedidoArticulo(identificador);

        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);

        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){
            
            //Asignar el valor recibido por defecto
            objetoNuevo.setSubtotal(subtotalRecibido);
            objetoNuevo.setCantidad(cantidadRecibida);
            Estado seSeteoEstado = objetoNuevo.setEstado(estadoRecibido);
            objetoNuevo.setArticulo(articuloRecibido);
            objetoNuevo.setPedido(pedidoRecibido);
            objetoNuevo.setImporteConDescuento(importeConDescuentoRecibido);
            objetoNuevo.setSeCobroConDescuento(seCobroConDescuentoRecibido);
            
            objetoNuevo.setIdEstado(estadoRecibido.getId());
            objetoNuevo.setIdArticulo(articuloRecibido.getId());
            objetoNuevo.setIdPedido(pedidoRecibido.getId());
            
            objetoDevolver = objetoNuevo;
            
            //Estado seGuardo = objetoDevolver.guardar();

        }else{

            //TODO capturar el error generado por un ingreso erroneo a la lista
            listaObjetos.remove(objetoDevolver);
            //...se establecio un valor por defecto

        }

        //Devolver el objeto requerido
        return objetoDevolver;

    }

    private PedidoArticulo() {}

    private static PedidoArticulo nuevo(){

        //Crear un objeto a devolver
        PedidoArticulo objetoDevolver = PedidoArticulo.OBJETO_INVALIDO;

        //Crear un nuevo objeto
        PedidoArticulo objetoNuevo = new PedidoArticulo();

        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);

        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){

            //Establecer el objeto a devolver
            objetoDevolver = objetoNuevo;

        }else{

            //TODO capturar el error generado por un ingreso erroneo a la lista
            //...se establecio un valor por defecto

        }

        //Devolver el objeto requerido
        return objetoDevolver;

    }

    //Manejo de lista

    private static Estado addNewObjeto(Object objetoActual){

        //Establecer un valor por defecto
        Estado estadoDevolver= Estado.ERROR;

        //Si el objeto recibido es del tipo correcto
        if(objetoActual.getClass() == PedidoArticulo.class){

            //Obtener el objeto requerido
            PedidoArticulo objetoAgregar = (PedidoArticulo)objetoActual;

            //Agregar el nuevo elemento a la lista
            boolean seAgrego;
            seAgrego = listaObjetos.add(objetoAgregar);

            if(seAgrego){

                //...asignar el estado correspondiente
                estadoDevolver = Estado.EXITO;

            }else{

                //...se establecio un valor por defecto

            }//...fin if


        }else{

            //...se establecio un valor por defecto

        }//...fin if

        //Devolver el estado correspondiente
        return estadoDevolver;

    }//...fin funcion
    
    //Setter
    
    private void setId(int id) {
        this.id = id;
    }

    private void setSubtotal(double subtotalRecibido) {
        this.subtotal = subtotalRecibido;
    }

    private void setCantidad(int cantidadRecibido) {
        this.cantidad = cantidadRecibido;
    }

    public Estado setEstado(Estado estadoRecibido) {
        
        Estado estadoDevolver = Estado.ERROR;
        
        //TODO verificar la entrada de un tipo de dato, tipo estado.
        
        //if(isEstado(estadoRecibido)){
        if(true){
            
            this.estado = estadoRecibido;
            estadoDevolver = Estado.EXITO;
            
        }else{
            
            //...se establecio un valor por defecto
            
        }
        
        return estadoDevolver;
    }

    private void setArticulo(Articulo articuloRecibido) {
        this.articulo = articuloRecibido;
    }

    private void setPedido(Pedido pedidoRecibido) {
        this.pedido = pedidoRecibido;
    }

    private void setImporteConDescuento(double importeConDescuentoRecibido) {
        this.importeConDescuento = importeConDescuentoRecibido;
    }

    private void setSeCobroConDescuento(boolean seCobroConDescuentoRecibido) {
        this.seCobroConDescuento = seCobroConDescuentoRecibido;
    }

    private void setIdEstado(int idEstadoRecibido) {
        this.idEstado = idEstadoRecibido;
    }

    private void setIdArticulo(int idArticuloRecibido) {
        this.idArticulo = idArticuloRecibido;
    }

    private void setIdPedido(int idPedidoRecibido) {
        this.idPedido = idPedidoRecibido;
    }
    
    //Getter

    public int getId() {
        return id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Estado getEstado() {
        
        Estado estadoDevolver = Estado.ERROR;
        
        estadoDevolver = this.estado;
        
        return estadoDevolver;
    }

    public Articulo getArticulo() {
        
        Articulo articuloDevolver = Articulo.OBJETO_INVALIDO;
        
        articuloDevolver = this.articulo;
        
        return articuloDevolver;
    }

    public Pedido getPedido() {
        
        Pedido pedidoDevolver = Pedido.OBJETO_INVALIDO;
        
        pedidoDevolver = this.pedido;
        
        return pedidoDevolver;
    }

    public double getImporteConDescuento() {
        return importeConDescuento;
    }

    public boolean isSeCobroConDescuento() {
        return seCobroConDescuento;
    }

    protected static Set<PedidoArticulo> getListaObjetos() {
        
        Set<PedidoArticulo> listaDevolver = new HashSet<>();
        
        listaDevolver = listaObjetos;
        
        return listaDevolver;
    }
    
    //Others
    
    @Override
    public boolean equals(Object objetoActual) {

        if(objetoActual == null){return false;}
        if(this.getClass() != objetoActual.getClass()){return false;}

        final PedidoArticulo objetoRecibido = (PedidoArticulo) objetoActual;

        if(this.hashCode() != objetoRecibido.hashCode()){return false;}

        return true;

    }

    @Override
    public int hashCode() {

        return this.id;

    }
    
    @Override
    public String toString() {
        
        return "Definir";
        
    }
    
}
