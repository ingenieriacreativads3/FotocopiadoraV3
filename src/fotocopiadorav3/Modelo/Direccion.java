/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;
import java.util.*;
import fotocopiadorav3.*;
import java.sql.*;


/**

 @author Tomas
 */
public class Direccion{
    
    private final int id;
    private AlfaNumerico calle;
    private int numero;
            
    public final static Direccion OBJETO_INVALIDO = new Direccion();

    protected static Set<Direccion> listaObjetos = new HashSet<>();

    private static int getNewId(){

        //Crear un nuevo identificador
        int idActual = 0;

        //Obtener la cantidad de elementos no nulos del conjunto
        if(listaObjetos != null){

            if(listaObjetos.size() != 0){

                idActual = listaObjetos.size();

            }else{

                //...se establecio un valor por defecto

            }

        }else{

            //...se establecio unvalor por defecto

        }

        //Buscar el siguiente identificador
        int siguienteIdentificador = Valor.SIGUIENTE_IDENTIFICADOR;

        //Combinar ambos valores
        idActual = idActual + siguienteIdentificador;

        //Devolver el nuevo identificador
        return idActual;

    }
    
    //Base de datos
    
    public static Estado guardar(int i){
        
        Estado estadoDevolver = Estado.ERROR;
        
        
        
        return estadoDevolver;
        
    }
    
    public static Estado guardar(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        System.out.println(1.1);
        // Instancias la clase que hemos creado anteriormente
        ConexionMySql conexionLocalSQL = ConexionMySql.nuevo();
        
        System.out.println(1.2);
        // Llamas al método que tiene la clase y te devuelve una conexión
        Connection conector = conexionLocalSQL.conectarMySQL();
        
        System.out.println(1.3);
        // Query que usarás para hacer lo que necesites
        String sentenciaSQL = "";

        // Query
        sentenciaSQL =  "INSERT INTO alfanumerico (valor) VALUES (\"fghj\")";
        try{
            
            // PreparedStatement
            System.out.println(1.4);
            PreparedStatement pstm = conector.prepareStatement(sentenciaSQL);
            System.out.println(1.5);
            System.out.println(pstm);
            ResultSet asd = pstm.executeQuery();
            System.out.println(1.6);
            System.out.println("Funciona la conexion");
            
        }catch(Exception e){
            
            System.out.println("Fallo la consulta en modelo/direccion.guardar");
            
        }
        
        return estadoDevolver;
        
    }

    //Constructor

    private Direccion() {

        //Asignar un identificador
        this.id = getNewId();


    }

    protected static Direccion nuevo(){

        //Crear un objeto a devolver
        Direccion objetoDevolver = Direccion.OBJETO_INVALIDO;

        //Crear un nuevo objeto
        Direccion objetoNuevo = new Direccion();

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
        if(objetoActual.getClass() == Direccion.class){

            //Obtener el objeto requerido
            Direccion objetoAgregar = (Direccion)objetoActual;

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

    protected void setCalle(AlfaNumerico calle) {
        
        this.calle = calle;
        
    }

    protected void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
    //Getter

    /**
     *Devuelve la calle de una direccion.
     * 
     * @return AlfaNUmerico calle
     * 
     */

    public AlfaNumerico getCalle() {
        
        AlfaNumerico calleDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        calleDevolver = this.calle;
        
        return calleDevolver;
    }

    /**
     * Esta funcion devuelve el numero de calle de una direccion.
     * Se debe establecer su validez a traves de una
     * funcion de la interfaz del paquete contenedor.
     * 
     * @return int numero
     */
    public int getNumero() {
        
        int numeroDevolver = Valor.numeroDeCalleInvalido;
        
        numeroDevolver = numero;
        
        return numeroDevolver;
    }
    
    //Others
    
    @Override
    public boolean equals(Object objetoActual) {

        if(objetoActual == null){return false;}
        if(this.getClass() != objetoActual.getClass()){return false;}

        final Direccion objetoRecibido = (Direccion) objetoActual;

        if(this.hashCode() != objetoRecibido.hashCode()){return false;}

        return true;

    }

    @Override
    public int hashCode() {

        return this.id;

    }
    
    @Override
    public String toString() {
        
        return this.calle.toString() + " " + this.numero;
        
    }
    
}
