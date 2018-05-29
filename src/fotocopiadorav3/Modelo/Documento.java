/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;

import java.util.*;

/**
 *
 * @author Tomás Contreras
 */
public class Documento {
    
    private final int id;
    private Archivo documento;
    private Estado categoria;
    private double precio;
    private Date fechaIngreso;
    
    private Nombre nombre;
    private Nombre autor;
    private Nombre editorial;
    private Nombre edicion;
    
            
    protected final static Documento OBJETO_INVALIDO = new Documento();

    private static Set<Documento> listaObjetos = new HashSet<>();

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

    private Documento() {

        //Asignar un identificador
        this.id = getNewId();


    }

    protected static Documento nuevo(){

        //Crear un objeto a devolver
        Documento objetoDevolver = Documento.OBJETO_INVALIDO;

        //Crear un nuevo objeto
        Documento objetoNuevo = new Documento();

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
        if(objetoActual.getClass() == Documento.class){

            //Obtener el objeto requerido
            Documento objetoAgregar = (Documento)objetoActual;

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

        final Documento objetoRecibido = (Documento) objetoActual;

        if(this.hashCode() != objetoRecibido.hashCode()){return false;}

        return true;

    }

    @Override
    public int hashCode() {

        return this.id;

    }
    
    @Override
    public String toString() {
        
        return this.documento.toString();
        
    }
    
}
