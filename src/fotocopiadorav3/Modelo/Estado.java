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
    
    ERROR_VALOR_NO_SETEADO(24),
    
    USSER_PASS_CORRECTOS(23),
    
    /**
     * Representa un documento para tutorias de una materia en partcular.
     * 
     *//**
     * Representa un documento para tutorias de una materia en partcular.
     * 
     */
    TUTORIAS(22),
    
    /**
     * Representa un documento para la catedra de una materia en particular.
     * 
     */
    CATEDRA(21),
    
    TAREA_SIN_ESTADO(20),
    SUSPENDIDA(19),
    NO_REALIZADA(18),
    REALIZADA(17),
    CANTIDAD_VALIDA(16),
    VENTA_REGISTRADA(15),
    ERROR_IO(14),
    ERROR_FILE_NOT_FOUND(13),
    SIN_ESTADO(12),
    INICIAL(11),
    EXITO(10),
    ERROR(9),
    
    ERROR_CODIGO_TRANSACCION_INEXISTENTE(113),
    EXISTE_CODIGO_TRANSACCION(112),
    EXISTE_USUARIO(111),

    DATOS_VALIDOS(8),
    ERROR_DATOS_INVALIDOS(7),

    ERROR_PASS_INEXISTENTE(62),
    ERROR_NOMBRE_INEXISTENTE(61),
    ERROR_NOMBRE(6),
    ERROR_APELLIDO(5),
    ERROR_CANTIDAD(4),
    ERROR_ELEMENTO(3),
    ERROR_COTIZACION(2),
    MENSAJE_MOSTRADO(1);

    private final int Id;

    private Estado(int identificador) {

        this.Id = identificador;

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
