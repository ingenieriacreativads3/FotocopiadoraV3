/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;

import java.util.*;

/**

 @author Tomas
 */
public enum Estado{
    
    /**
     * Este estado representa una solicitud de statement para obtener informacion
     */
    GET_PREPARED_STATEMENT_FOR_GET_INFORMATION(302, "Se solicita un PreparedStatement para pedir informacion"),
    
    /**
     * Este estado representa una solicitud de statement para guardar datos
     */
    GET_PREPARED_STATEMENT_FOR_SAVE(301, "Se solicita un PreparedStatement para guardar datos"),
    
    /**
     * Este estado representa un error de bd
     */
    ERROR_PERSISTENCIA_INCORRECTA(300, "La persistencia no anda"),
    ERROR_LISTA_REMOVE(299, "No se removio correctamente el objeto de la lista"),
    
    ITEM_PEDIDO_RETIRADO(225, "El item se encuentra retirado"),
    ITEM_PEDIDO_CANCELADO_SI_FOTOCOPIADO(224, "El item se encuentra cancelado con fotocopias realizadas"),
    ITEM_PEDIDO_CANCELADO_NO_FOTOCOPIADO(223, "El item se encuentra cancelado sin fotocopias realizadas"),
    ITEM_PEDIDO_FOTOCOPIADO(222, "El item se encuentra fotocopiado"),
    ITEM_PEDIDO_REGISTRADO(221, "El item se encuentra registrado"),
    
    ERROR_VALOR_NO_SETEADO(24, "Esta caracteristica no tiene un valor asignado"),
    
    USSER_PASS_CORRECTOS(23, "Usuario y contraseña ingresados conrrectamente"),
    
    /**
     * Representa un documento para tutorias de una materia en partcular.
     * 
     */
    TUTORIAS(22, "tutorias"),
    
    /**
     * Representa un documento para la catedra de una materia en particular.
     * 
     */
    CATEDRA(21, "Este documento corresponde a la catedra de la materia"),
    
    TAREA_SIN_ESTADO(20, "Tarea sin estado"),
    SUSPENDIDA(19, "Operacion suspendida"),
    NO_REALIZADA(18, "La operacion no se realizo"),
    REALIZADA(17, "Operacion realizada"),
    CANTIDAD_VALIDA(16, "La cantidad ingresada es valida"),
    VENTA_REGISTRADA(15, "La venta se registro con exito"),
    ERROR_IO(14, "Error en Input/Ouput"),
    ERROR_FILE_NOT_FOUND(13, "No se encontro el archivo en lo locacion ingresada"),
    SIN_ESTADO(12, "NO hay un estado"),
    INICIAL(11, "Estado inicial"),
    EXITO(10, "Exito!"),
    ERROR(9, "Existe un error"),
    
    ERROR_CODIGO_TRANSACCION_INEXISTENTE(113, "El codigo de transaccion es inexistente"),
    EXISTE_CODIGO_TRANSACCION(112, "Existe el codigo de transaccion"),
    EXISTE_USUARIO(111, "El usuario existe"),

    DATOS_VALIDOS(8, "Los datos ingresados son correctos"),
    ERROR_DATOS_INVALIDOS(7, "Los datos ingresados son incorrectos"),

    ERROR_USSER_INEXISTENTE(63, "El ususario ingresado es inexistente"),
    ERROR_PASS_INCORRECTA(62, "La contraseña ingresada es incorrecta"),
    ERROR_NOMBRE_INEXISTENTE(61, "Este nombre no existe"),
    ERROR_NOMBRE(6, "Nombre incorrecto"),
    ERROR_APELLIDO(5, "Apellido Incorrecto"),
    ERROR_CANTIDAD(4, "Arreglar esto en la linea /Modelo/Estado.java linea 64"),
    ERROR_ELEMENTO(3, "Arreglar esto en la linea /Modelo/Estado.java linea 65"),
    ERROR_COTIZACION(2, "Arreglar esto en la linea /Modelo/Estado.java linea 66"),
    MENSAJE_MOSTRADO(1, "Arreglar esto en la linea /Modelo/Estado.java linea 67");

    private final int id;
    private final String mensaje;
    private static Set<Estado> listaObjetos = new HashSet<>();

    private Estado(int identificador, String mensajeActual) {

        this.id = identificador;
        this.mensaje = mensajeActual;
        try {
            ConexionMySql.addNewEstado(this);
        } catch (Exception e) {
            
            System.out.println("no se agrega el estado");
        }
    }

    @Override
    public String toString(){

        return this.mensaje;

    }

    public int getId(){

        return this.id;

    }
    
    public String getMensaje(){
        
        return this.mensaje;
    }
    
    private void addNewObjeto(){
        
        listaObjetos.add(this);
        
    }
    
    protected static Set<Estado> getLista(){
        
        Set<Estado> listaDevolver = listaObjetos;
        
        return listaDevolver;
    }
    
    public static Estado getForId(int idRecibido){
        
        Estado estadoDevolver = ERROR;
        
        Set<Estado> lista = ConexionMySql.getListaEstado();
        
        for(Estado estadoActual : lista){
            
            if(estadoActual.getId() == idRecibido){
                
                estadoDevolver = estadoActual;
                
            }else{
                
                //...se establecio un valor por defecto
            }
        }
        
        return estadoDevolver;
    }
    
}
