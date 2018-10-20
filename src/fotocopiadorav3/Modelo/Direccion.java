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
    
    private static final String NOMBRE_TABLA = "direccion";
    
    private static final String CAMPO_ID = "id";
    private static final String CAMPO_NUMERO = "numero";
    private static final String CAMPO_ID_CALLE = "id_alfanumerico";
    
    private static final int CANTIDAD_DE_CAMPOS = 3;
    private static final int LUGAR_DEL_CAMPO_ID = 1;
    private static final int LUGAR_DEL_CAMPO_NUMERO = 2;
    private static final int LUGAR_DEL_CAMPO_ID_CALLE = 3;

    private int id;
    private AlfaNumerico calle;
    private int numero;
    private int idCalle;
            
    public final static Direccion OBJETO_INVALIDO = new Direccion();

    protected static Set<Direccion> listaObjetos = new HashSet<>();
    
    //Rutinas
    
    protected static Direccion getForId(int idRecibido){
        
        Direccion direccionDevolver = OBJETO_INVALIDO;
        
        Estado seObtuvo = getInformacion();
        
        if(seObtuvo == Estado.EXITO){
            
            for(Direccion direccionActual : listaObjetos){
                
                if(direccionActual.id == idRecibido){
                    
                    direccionDevolver = direccionActual;
                    
                }else{
                    
                    //...se establecion un valor por defecto
                    
                }
            }
            
        }else{
            
            //TODO capturar el error producido por no haber capturado la info de la db
            System.out.println("Se rompio en Direccion.getForId();");
            
        }
        
        return direccionDevolver;
        
    }
    
    private static Direccion nuevo(int idActual, AlfaNumerico calleActual, int numeroActual, int idAlfaRecibido) {
        
        Direccion direccionDevolver = new Direccion();
        
        direccionDevolver.id = idActual;
        direccionDevolver.calle = calleActual;
        direccionDevolver.numero = numeroActual;
        direccionDevolver.idCalle = idAlfaRecibido;
        
        Estado seAgrego = Direccion.addNewObjeto(direccionDevolver);
        
        return direccionDevolver;
        
    }
    
    private static Estado getInformacion(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ResultSet rs = null;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(NOMBRE_TABLA);
        
        try {
            
            rs = prepared.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(CAMPO_ID);
                int numeroActual = rs.getInt(CAMPO_NUMERO);
                int idAlfaNumerico = rs.getInt(CAMPO_ID_CALLE);
                
                AlfaNumerico calleActual = AlfaNumerico.getForId(idAlfaNumerico);
                
                Direccion asd = nuevo(id, calleActual, numeroActual, idAlfaNumerico);
                
                //TODO quitar estos sout
//                System.out.println("Size: " + getSetSize());
//                
//                System.out.println("ID: " + id + ", Valor: " + valor);
                
            }
            
            estadoDevolver = Estado.EXITO;
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        //System.out.println(prepared.toString());
        
        return estadoDevolver;
        
    }
    
    private static int getLastId(){
        
        int ultimoID = 0;
        
        Estado estadoConsulta = getInformacion();

        if(listaObjetos != null){

            if(estadoConsulta == Estado.EXITO){

                for(Direccion direccionActual : listaObjetos){

                    if(direccionActual.id > ultimoID){

                        ultimoID = direccionActual.id;

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
    
    //Base de datos
    
    public static Estado guardar(int i){
        
        Estado estadoDevolver = Estado.ERROR;
        
        //AlfaNumerico alfa1 = AlfaNumerico.nuevo();
        //AlfaNumerico alfa2 = AlfaNumerico.nuevo();
        //AlfaNumerico alfa3 = AlfaNumerico.nuevo();
        //AlfaNumerico alfa4 = AlfaNumerico.nuevo();
        //AlfaNumerico alfa5 = AlfaNumerico.nuevo();
        
        
        
        //alfa5.setValor("sdhfkjlghsdklfjg");
        
        //System.out.println("ID: " + alfa5.getId());
        //estadoDevolver = alfa5.guardar();
        //estadoDevolver = AlfaNumerico.getInformacion();
        
        //System.out.println("Antes de pedir un objeto nuevo");
        
        int numero = 1194;
        AlfaNumerico asd = AlfaNumerico.nuevo("25 de mayo");
        Direccion asdd = Direccion.nuevo(asd, numero);
        Persona asddd = Persona.nuevo(asd, asd, numero, asdd);
        
        //System.out.println("Despues de pedir un objeto nuevo");
        
        
        
//        if(estadoDevolver == Estado.ERROR_PERSISTENCIA_INCORRECTA){
//            System.out.println("algo no anda");
//        }else{
//            System.out.println("funciona");
//        }
        
        return estadoDevolver;
        
    }
    
    private Estado guardar(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(CANTIDAD_DE_CAMPOS, NOMBRE_TABLA);
        
        try {
            
            prepared.setInt(LUGAR_DEL_CAMPO_ID, this.id);
            prepared.setInt(LUGAR_DEL_CAMPO_NUMERO, this.numero);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_CALLE, this.idCalle);
            prepared.executeUpdate();
            
            estadoDevolver = Estado.EXITO;
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        return estadoDevolver;
        
    }

    //Constructor

    private Direccion() {

        //Asignar un identificador
        //this.id = getNewId();


    }
    
    private Direccion(int idActual) {

        //Asignar un identificador
        this.id = idActual;


    }
    
    protected static Direccion nuevo(AlfaNumerico calle, int numero){

        //Crear un objeto a devolver
        Direccion objetoDevolver = Direccion.OBJETO_INVALIDO;

        //Obtener el siguiente identificador
        int identificador = getNewId();
        
        //Crear un nuevo objeto
        Direccion objetoNuevo = new Direccion(identificador);

        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);

        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){
            
            //Asignar el valor recibido por defecto
            Estado seSeteoCalle = objetoNuevo.setCalle(calle);
            Estado seSeteoNumero = objetoNuevo.setNumero(numero);
            
            Estado seSeteoIdAlfa = objetoNuevo.setIdAlfa(calle.getId());
            
            objetoDevolver = objetoNuevo;
            
            Estado seGuardo = objetoDevolver.guardar();

        }else{

            //TODO capturar el error generado por un ingreso erroneo a la lista
            listaObjetos.remove(objetoDevolver);
            //...se establecio un valor por defecto

        }

        //Devolver el objeto requerido
        return objetoDevolver;

    }

    private static Direccion nuevo(){

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
    
    private Estado setIdAlfa(int idAlfaRecibido){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.idCalle = idAlfaRecibido;
        
        return estadoDevolver;
        
    }

    private Estado setCalle(AlfaNumerico calle) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.calle = calle;
        
        return estadoDevolver;
        
    }

    private Estado setNumero(int numero) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.numero = numero;
        
        return estadoDevolver;
        
    }
    
    //Getter
    
    protected int getId(){
        
        return this.id;
    }

    /**
     *Devuelve la numeroActual de una direccion.
     * 
     * @return AlfaNUmerico numeroActual
     * 
     */

    public AlfaNumerico getCalle() {
        
        AlfaNumerico calleDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        calleDevolver = this.calle;
        
        return calleDevolver;
    }

    /**
     * Esta funcion devuelve el numeroActual de numeroActual de una direccion.
     * Se debe establecer su validez a traves de una
     * funcion de la interfaz del paquete contenedor.
     * 
     * @return int numeroActual
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
