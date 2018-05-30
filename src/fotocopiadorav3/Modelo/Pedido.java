/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;

import java.util.*;

/**
 * Esta clase determina la transacción básica del dominio de negocio.
 * Puede tener varios documentos en un pedido.
 * 
 * @param Identificador
 * @param Fecha
 * @param Importe
 * @author Tomás Contreras
 */
public class Pedido {
    
    private final int id;
    private Date fecha;
    private double importe;
    
    private Alumno alumno;
    private AlfaNumerico codigoTransaccion;
            
    protected final static Pedido OBJETO_INVALIDO = new Pedido();

    private static Set<Pedido> listaObjetos = new HashSet<>();
    
    //Rutinas
    
    private static Estado exiteCodigoTransaccion(){
        
        //Establecer un valor por defecto
        Estado estadoDevolver = Estado.ERROR_CODIGO_TRANSACCION_INEXISTENTE;
        
        
        
        return estadoDevolver;
        
    }
    
    private static AlfaNumerico getNewCodigoTransaccion(){
        
        AlfaNumerico alfaNumerico = AlfaNumerico.OBJETO_INVALIDO;
        
        
        
        return alfaNumerico;
        
    }

    private static int getNewId(){

        //Crear un nuevo identificador
        int idActual = listaObjetos.size();

        //Buscar el siguiente identificador
        int siguienteIdentificador = Valor.SIGUIENTE_IDENTIFICADOR;

        //Combinar ambos valores
        idActual = idActual + siguienteIdentificador;

        //Devolver el nuevo identificador
        return idActual;

    }

    //Constructor

    private Pedido() {

        //Asignar un identificador
        this.id = getNewId();


    }

    protected static Pedido nuevo(){

        //Crear un objeto a devolver
        Pedido objetoDevolver = Pedido.OBJETO_INVALIDO;

        //Crear un nuevo objeto
        Pedido objetoNuevo = new Pedido();

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
        if(objetoActual.getClass() == AlfaNumerico.class){

            //Obtener el objeto requerido
            Pedido objetoAgregar = (Pedido)objetoActual;

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
    
    //Getter
    
    //Others
    
    @Override
    public boolean equals(Object objetoActual) {

        if(objetoActual == null){return false;}
        if(this.getClass() != objetoActual.getClass()){return false;}

        final Pedido objetoRecibido = (Pedido) objetoActual;

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
