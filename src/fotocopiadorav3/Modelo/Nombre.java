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
public class Nombre{
    
    private final int id;
    private String valor;
            
    private final static Nombre objetoInvalido = new Nombre();

    private static Set<Nombre> listaObjetos = new HashSet<>();
    
    public String getValor() {

        String valorDevolver = "Sin valor";

        //Si el valor requerido no nulo
        if(this.valor != null){

            valorDevolver = this.valor;

        }else{

            //...se establecio un valor por defecto

        }

        return valorDevolver;

    }

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

    private Nombre() {

        //Asignar un identificador
        this.id = getNewId();


    }

    protected static Nombre nuevo(){

        //Crear un objeto a devolver
        Nombre objetoDevolver = Nombre.objetoInvalido;

        //Crear un nuevo objeto
        Nombre objetoNuevo = new Nombre();

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
        if(objetoActual.getClass() == Nombre.class){

            //Obtener el objeto requerido
            Nombre objetoAgregar = (Nombre)objetoActual;

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
    
}
