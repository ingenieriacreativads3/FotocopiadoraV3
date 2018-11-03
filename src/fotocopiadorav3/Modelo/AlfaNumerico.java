/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import java.sql.*;

/**

 @author Tomas
 */

@Entity
@Table(name = "alfanumerico")
public class AlfaNumerico implements Serializable{
    
    //Atributos
    
    private static final String NOMBRE_TABLA = "alfanumerico";
    private static final String CAMPO_ID = "id";
    private static final String CAMPO_VALOR = "valor";
    
    private static final int CANTIDAD_DE_CAMPOS = 2;
    private static final int LUGAR_DEL_CAMPO_ID = 1;
    private static final int LUGAR_DEL_CAMPO_VALOR = 2;
    
    @Id
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private int id;
    
    @Column(name = "valor")
    private String valor;
            
    protected final static AlfaNumerico OBJETO_INVALIDO = new AlfaNumerico();

    private static Set<AlfaNumerico> listaObjetos = new HashSet<>();
    
    //Rutinas
    
    public Estado modificar(String palabraRecibida){
        
        Estado estadoDevolver = Estado.ERROR;
        
        this.borrar();
        AlfaNumerico nuevoObjeto = AlfaNumerico.nuevo(palabraRecibida);
        nuevoObjeto.setId(this.id);
        
        if(nuevoObjeto.guardar() == Estado.EXITO){
            
            estadoDevolver = Estado.EXITO;
            
        }else{
            
            nuevoObjeto.borrar();
            
        }
        
        return estadoDevolver;
    }
    
    public Estado borrar(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatementD(NOMBRE_TABLA);
        
        try {
            
            prepared.setInt(LUGAR_DEL_CAMPO_ID, this.id);
            
            //System.out.println(prepared.toString());
            
            if(listaObjetos.remove(this)){
                
                prepared.executeUpdate();
                estadoDevolver = Estado.EXITO;
                
            }else{
                
                estadoDevolver = Estado.ERROR_LISTA_REMOVE;
                
            }
            
            prepared.close();
            conn.closeConn("borrar");
            
        } catch (Exception e) {
            System.out.println("se rompe en borrar");
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        return estadoDevolver;
    }
    
    protected static AlfaNumerico getForId(int idRecibido){
        
        AlfaNumerico alfaDevolver = OBJETO_INVALIDO;
        
        Estado seObtuvo = Estado.EXITO;
        //Estado seObtuvo = getInformacion();
        
        if(listaObjetos != null){
        
            if(seObtuvo == Estado.EXITO){

                for(AlfaNumerico alfaActual : listaObjetos){

                    if(alfaActual.id == idRecibido){

                        alfaDevolver = alfaActual;

                    }else{

                        //...se establecion un valor por defecto

                    }
                }

            }else{

                //TODO capturar el error producido por no haber capturado la info de la db
                System.out.println("Se rompio en Alfanumerico.getForId();");

            }
            
        }else{
            
            //...no hacer nada
            
        }
        
        return alfaDevolver;
        
    }
    
    private static int getLastId(){
        
        int ultimoID = 0;
        
        //Estado estadoConsulta = getInformacion();
        Estado estadoConsulta = Estado.EXITO;

        if(listaObjetos != null){

            if(estadoConsulta == Estado.EXITO){

                for(AlfaNumerico alfaActual : listaObjetos){

                    if(alfaActual.id > ultimoID){

                        ultimoID = alfaActual.id;

                    }else{

                        //...no hacer nada

                    }

                }

            }else{

                //...no hacer nada

            }

        }else{

            //...se establecio unvalor por defecto

        }
        
        return ultimoID;
        
    }
    
    protected static Estado getInformacion(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ResultSet rs = null;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(NOMBRE_TABLA);
        
        try {
            
            rs = prepared.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(CAMPO_ID);
                String valor = rs.getString(CAMPO_VALOR);
                
                AlfaNumerico asd = nuevo(id, valor);
                
                //System.out.println(id);
                
               
//                TODO quitar estos sout
//                System.out.println("Size: " + getSetSize());
//                
//                System.out.println("ID: " + id + ", Valor: " + valor);
                
            }
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            
            conn.closeConn(AlfaNumerico.class.toString() + "getInformacion");
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        //System.out.println(prepared.toString());
        
        return estadoDevolver;
        
    }
    
    /**
     * Esta funcion guarda la informacion de esta clase en la BD
     * @return 
     */
    
    public Estado guardar(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(CANTIDAD_DE_CAMPOS, NOMBRE_TABLA);
        
        try {
            
            prepared.setInt(LUGAR_DEL_CAMPO_ID, this.id);
            prepared.setString(LUGAR_DEL_CAMPO_VALOR, this.valor);
            prepared.executeUpdate();
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            conn.closeConn(AlfaNumerico.class.toString() + "guardar");
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        return estadoDevolver;
    }
    
    protected static AlfaNumerico valueOf(String palabraRecibida){
        
        //Establecer un valor por defecto
        AlfaNumerico alfaNumericoDevolver = AlfaNumerico.nuevo(palabraRecibida);
        
        return alfaNumericoDevolver;
        
    }

    private static int getNewId(){

        //Obtener el ultimo identificador
        int idActual = getLastId();

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
    
    private AlfaNumerico(){}
    
    private static AlfaNumerico nuevo(int idActual, String valorActual) {
        
        AlfaNumerico alfaDevolver = new AlfaNumerico();
        
        alfaDevolver.id = idActual;
        alfaDevolver.valor = valorActual;
        
        Estado seAgrego = AlfaNumerico.addNewObjeto(alfaDevolver);
        
        if(!(seAgrego == Estado.EXITO)){
            
            //listaObjetos.remove(alfaDevolver);
            
        }else{
            
            //...no hacer nada
            
        }
        
        return alfaDevolver;
        
    }

    private AlfaNumerico(int idActual) {

        //Asignar un identificador
        this.id = idActual;


    }

    /**
     * Esta funcion fue reemplazada por
     * AlfaNumerico nuevo(String palabraRecibida);
     * 
     * Devuelve un objeto alfanumerico con el valor de la palabra
     * enviada.
     * 
     * 
     * @deprecated 
     * @return 
     */
    
    private static AlfaNumerico nuevo(){

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

        //Obtener el siguiente identificador
        int identificador = getNewId();
        
        //Crear un nuevo objeto
        AlfaNumerico objetoNuevo = new AlfaNumerico(identificador);

        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);
        
        //TODO quitar este sout
//        System.out.println("Size: " + listaObjetos.size());

        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){
            
            //Asignar el valor recibido por defecto
            Estado seSeteo = objetoNuevo.setValor(palabraRecibida);
            
            if(seSeteo == Estado.EXITO){
                
                //Establecer el objeto a devolver
                objetoDevolver = objetoNuevo;
                
                //TODO quitar este sout
                //System.out.println("anda bien el set");
                
//                Estado seGuardo = objetoDevolver.guardar();
//                
//                if(seGuardo == Estado.EXITO){
//                    
//                    //...no hacer nada
//                    
//                }else{
//                    
//                    listaObjetos.remove(objetoDevolver);
//                    
//                }
                
            }else{
                
                
                //TODO capturar el error recibido por no poder agregar el valor
                //al objeto
                
                listaObjetos.remove(objetoDevolver);
                
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
                
                //TODO quitar este sout
                //System.out.println("Se agrego este objeto: " + objetoAgregar.valor + " ID: " + objetoAgregar.id);

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
    
    private void setId(int id) {
        this.id = id;
    }
    
    private Estado setValor(String valorRecibido){
        
        //Establecer un valor por defecto
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.valor = valorRecibido;
        
//        //Verificar que la asignacion se realizo con exito
//        if(!this.equals(OBJETO_INVALIDO)){
//            
//            //...establecer el valor de dato no agregado
//            estadoDevolver = Estado.EXITO;
//            
//        }else{
//            
//            //...se establecio un valor por defecto
//            
//        }//..fin
//        
        return estadoDevolver;
        
    }
    
    //Getter
    
    protected static int getSetSize(){
        
        int size = listaObjetos.size();
        
        return size;
        
    }

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

        if(this.hashCode() != objetoRecibido.hashCode()){return false;}

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
