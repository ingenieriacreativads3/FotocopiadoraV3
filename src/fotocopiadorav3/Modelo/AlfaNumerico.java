/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;
import java.io.*;
import java.util.*;
import javax.persistence.*;

/**

 @author Tomas
 */

@Entity
@Table(name = "alfanumerico")
public class AlfaNumerico implements Serializable{
    
    protected static String NOMBRE_TABLA = "alfanumerico";
    protected static String CAMPO_ID = "id";
    protected static String CAMPO_VALOR = "valor";
    
    @Id
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private int id;
    
    @Column(name = "valor")
    private String valor;
            
    protected final static AlfaNumerico OBJETO_INVALIDO = new AlfaNumerico();

    private static Set<AlfaNumerico> listaObjetos = new HashSet<>();
    
    //Rutinas
    
    protected static AlfaNumerico valueOf(String palabra){
        
        //Establecer un valor por defecto
        AlfaNumerico alfaNumericoDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        
        
        return alfaNumericoDevolver;
        
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

    /**
     * @deprecated 
     * 
     * Esta funcion esta fuera de uso . Fue reemplazada por
     * AlfaNumerico.nuevo();
     * 
     * @return AlfaNumerico alfanumerico
     */
    
    public AlfaNumerico(){}

    private AlfaNumerico(int idActual) {

        //Asignar un identificador
        this.id = idActual;


    }

    protected static AlfaNumerico nuevo(){

        //Crear un objeto a devolver
        AlfaNumerico objetoDevolver = AlfaNumerico.OBJETO_INVALIDO;

        //Obtener el siguiente identificador
        int identificador = getNewId();
        
        //Crear un nuevo objeto
        AlfaNumerico objetoNuevo = new AlfaNumerico(identificador);

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
    
    protected static AlfaNumerico nuevo(String palabraRecibida){

        //Crear un objeto a devolver
        AlfaNumerico objetoDevolver = AlfaNumerico.OBJETO_INVALIDO;

        //Crear un nuevo objeto
        AlfaNumerico objetoNuevo = new AlfaNumerico();

        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);

        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){
            
            //Asignar el valor recibido por defecto
            Estado seSeteo = objetoDevolver.setValor(palabraRecibida);
            
            if(seAgrego == Estado.EXITO){
                
                //Establecer el objeto a devolver
                objetoDevolver = objetoNuevo;
                
            }else{
                
                //TODO aqui capturar el error producido por no setear el valor
                //recibido como argumento
                
                //...se establecio un valor por defecto
                
            }//...fin

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
            AlfaNumerico objetoAgregar = (AlfaNumerico)objetoActual;

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

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public Estado setValor(String valorRecibido){
        
        //Establecer un valor por defecto
        Estado estadoDevolver = Estado.ERROR_VALOR_NO_SETEADO;
        
        //Asignar el valor recibido
        this.valor = valorRecibido;
        
        //Verificar que la asignacion se realizo con exito
        if(!this.equals(OBJETO_INVALIDO)){
            
            //...establecer el valor de dato no agregado
            estadoDevolver = Estado.EXITO;
            
        }else{
            
            //...se establecio un valor por defecto
            
        }//..fin
        
        return estadoDevolver;
        
    }
    
    //Getter

    public int getId() {
        return id;
    }
    
    
    
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
    
    //Others
    
    @Override
    public boolean equals(Object objetoActual) {

        if(objetoActual == null){return false;}
        if(this.getClass() != objetoActual.getClass()){return false;}

        final AlfaNumerico objetoRecibido = (AlfaNumerico) objetoActual;

        if(!this.valor.equals(objetoRecibido.valor)){return false;}

        return true;

    }

    @Override
    public int hashCode() {

        return this.id;

    }
    
    @Override
    public String toString() {
        
        return this.valor;
        
    }
    
    /**
     * Esta funcion devuelve el nombre de la clase
     * @return String clase = "AlfaNumerico";
     */
    public static String getClase(){
        
        return "AlfaNumerico";
        
    }
    
}
