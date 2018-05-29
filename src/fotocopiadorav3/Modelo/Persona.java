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
public class Persona{
    
    private final int id;
    private Nombre nombre;
    private Nombre apellido;
    private int dni;
    private Direccion direccion;
    
    protected final static Persona OBJETO_INVALIDO = new Persona();

    private static Set<Persona> listaObjetos = new HashSet<>();

    private int getNewId(){

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

    protected Persona() {

        //Asignar un identificador
        this.id = getNewId();


    }

    protected static Persona nuevo(){

        //Crear un objeto a devolver
        Persona objetoDevolver = Persona.OBJETO_INVALIDO;

        //Crear un nuevo objeto
        Persona objetoNuevo = new Persona();

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
        Estado estadoDevolver= Estado.FRACASO;

        //Si el objeto recibido es del tipo correcto
        if(objetoActual.getClass() == Persona.class){

            //Obtener el objeto requerido
            Persona objetoAgregar = (Persona)objetoActual;

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

    protected int getId(){
        return id;
    }
    
    
    
}
