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
    private AlfaNumerico nombre;
    private AlfaNumerico apellido;
    private int dni;
    private Direccion direccion;
    
    protected final static Persona OBJETO_INVALIDO = new Persona();

    private static Set<Persona> listaObjetos = new HashSet<>();

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
        Estado estadoDevolver= Estado.ERROR;

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
    
    //Setter

    public void setNombre(AlfaNumerico nombre) {
        
        AlfaNumerico alfaSet = AlfaNumerico.OBJETO_INVALIDO;
        
        
        this.nombre = nombre;
        
    }

    public void setApellido(AlfaNumerico apellido) {
        this.apellido = apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
    
    //Getter

    /**
     * Este función devulve el nombre de pila de la persona
     * 
     * @return AlfaNumerico nombre
     */

    public AlfaNumerico getNombre() {
        
        AlfaNumerico nombreDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        nombreDevolver = this.nombre;
        
        return nombreDevolver;
    }

    /**
     * Esta funcion devulve el apellido de la persona.
     * 
     * @return AlfaNUmerico apellido
     */
    public AlfaNumerico getApellido() {
        
        AlfaNumerico apellidoDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        apellidoDevolver = this.apellido;
        
        return apellidoDevolver;
    }

    /**
     * Esta funcion devulve el dni de la persona.
     * Se debe establecer su validez a traves de una
     * funcion de la interfaz del paquete contenedor.
     * 
     * @return int dni
     */
    public int getDni() {
        
        int dniDevolver = Valor.DNI_INVALIDO;
        
        dniDevolver = this.dni;
        
        return dniDevolver;
    }

    /**
     * Esta funcion devuelve la direccion de la persona.
     * 
     * @return Direccion direccion
     */
    public Direccion getDireccion() {
        
        Direccion direccionDevolver = Direccion.OBJETO_INVALIDO;
        
        direccionDevolver = this.direccion;
        
        return direccionDevolver;
    }
    
    
    
    //Others
    
    @Override
    public boolean equals(Object objetoActual) {

        if(objetoActual == null){return false;}
        if(this.getClass() != objetoActual.getClass()){return false;}

        final Persona objetoRecibido = (Persona) objetoActual;

        if(this.hashCode() != objetoRecibido.hashCode()){return false;}

        return true;

    }

    @Override
    public int hashCode() {

        return this.id;

    }

    @Override
    public String toString() {
        
        return this.nombre.toString();
        
    }
    
}
