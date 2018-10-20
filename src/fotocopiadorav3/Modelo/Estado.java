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
    GET_PREPARED_STATEMENT_FOR_GET_INFORMATION(301, "Se solicita un PreparedStatement para pedir informacion"),
    
    /**
     * Este estado representa una solicitud de statement para guardar datos
     */
    GET_PREPARED_STATEMENT_FOR_SAVE(301, "Se solicita un PreparedStatement para guardar datos"),
    
    /**
     * Este estado representa un error de bd
     */
    ERROR_PERSISTENCIA_INCORRECTA(300, "La persistencia no anda"),
    
    
    ITEM_PEDIDO_RETIRADO(224, "El item se encuentra retirado"),
    ITEM_PEDIDO_CANCELADO(223, "El item se encuentra cancelado"),
    ITEM_PEDIDO_FOTOCOPIADO(222, "El item se encuentra fotocopiado"),
    ITEM_PEDIDO_REGISTRADO(221, "El item se encuentra registrado"),
    
    ERROR_VALOR_NO_SETEADO(24, "Esta caracteristica no tiene un valor asignado"),
    
    USSER_PASS_CORRECTOS(23, "Usuario y contraseña ingresados conrrectamente"),
    
    /**
     * Representa un documento para tutorias de una materia en partcular.
     * 
     */
    TUTORIAS(22, "Este documento corresponde a las tutorias de la materia"),
    
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

    private final int Id;
    private final String mensaje;

    private Estado(int identificador, String mensajeActual) {

        this.Id = identificador;
        this.mensaje = mensajeActual;

    }

    private static boolean esIncial(Estado estadoActual){

        boolean respuesta = false;

        if(estadoActual == INICIAL){

            respuesta = true;

        }

        return respuesta;

    }

    private static boolean esExito(Estado estadoActual){

        boolean respuesta = false;

        if(estadoActual == EXITO){

            respuesta = true;

        }

        return respuesta;

    }

    private static boolean esFracaso(Estado estadoActual){

        boolean respuesta = false;

        if(estadoActual == ERROR){

            respuesta = true;

        }

        return respuesta;

    }

    private static boolean esErrorDatosIncorrectos(Estado estadoActual){

        boolean respuesta = false;

        if(estadoActual == ERROR_DATOS_INVALIDOS){

            respuesta = true;

        }

        return respuesta;

    }

    private static boolean esErrorApellido(Estado estadoActual){

        boolean respuesta = false;

        if(estadoActual == ERROR_APELLIDO){

            respuesta = true;

        }

        return respuesta;

    }

    private static boolean esErrorCantidad(Estado estadoActual){

        boolean respuesta = false;

        if(estadoActual == ERROR_CANTIDAD){

            respuesta = true;

        }

        return respuesta;

    }

    private static boolean esErrorElemento(Estado estadoActual){

        boolean respuesta = false;

        if(estadoActual == ERROR_ELEMENTO){

            respuesta = true;

        }

        return respuesta;

    }

    private static boolean esErrorCotizacion(Estado estadoActual){

        boolean respuesta = false;

        if(estadoActual == ERROR_COTIZACION){

            respuesta = true;

        }

        return respuesta;

    }

    private static boolean esMensaje(Estado estadoActual){

        boolean respuesta = false;

        if(estadoActual == MENSAJE_MOSTRADO){

            respuesta = true;

        }

        return respuesta;

    }

    @Override
    public String toString(){

        return this.name();

    }

    private int orden(){

        return this.Id;

    }
    
}
