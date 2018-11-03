/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;

import java.sql.*;
import java.util.*;

/**

 @author Tomas
 */
public class Persona{
    
    private static final String NOMBRE_TABLA = "persona";
    
    private static final String CAMPO_ID = "id";
    private static final String CAMPO_DNI = "dni";
    private static final String CAMPO_ID_NOMBRE = "id_nombre";
    private static final String CAMPO_ID_APELLIDO = "id_apellido";
    private static final String CAMPO_ID_DIRECCION = "id_direccion";
    
    private static final int CANTIDAD_DE_CAMPOS = 5;
    private static final int LUGAR_DEL_CAMPO_ID = 1;
    private static final int LUGAR_DEL_CAMPO_DNI = 2;
    private static final int LUGAR_DEL_CAMPO_ID_NOMBRE = 3;
    private static final int LUGAR_DEL_CAMPO_ID_APELLIDO = 4;
    private static final int LUGAR_DEL_CAMPO_ID_DIRECCION = 5;
    
    private int id;
    private AlfaNumerico nombre;
    private AlfaNumerico apellido;
    private int dni;
    private Direccion direccion;
    private int idNombre;
    private int idApellido;
    private int idDireccion;
    
    protected final static Persona OBJETO_INVALIDO = new Persona();

    private static Set<Persona> listaObjetos = new HashSet<>();
    
    //Rutinas
    
    public Estado modificar(AlfaNumerico nombreRecibido, AlfaNumerico apellidoRecibido, int dniRecibido, Direccion direccionRecibida){
        
        Estado estadoDevolver = Estado.ERROR;
        
        this.borrar();
        Persona nuevoObjeto = Persona.nuevo(nombreRecibido, apellidoRecibido, dniRecibido, direccionRecibida);
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
    
    protected static Persona getForId(int idRecibido){
        
        Persona personaDevolver = OBJETO_INVALIDO;
        
        //Estado seObtuvo = getInformacion();
        Estado seObtuvo = Estado.EXITO;
        
        if(listaObjetos != null){
        
            if(seObtuvo == Estado.EXITO){

                for(Persona personaActual : listaObjetos){

                    if(personaActual.id == idRecibido){

                        personaDevolver = personaActual;

                    }else{

                        //...se establecion un valor por defecto

                    }
                }

            }else{

                //TODO capturar el error producido por no haber capturado la info de la db
                System.out.println("Se rompio en Direccion.getForId();");

            }
        }else{
            
            //...no hacer nada
            
        }
        
        return personaDevolver;
        
    }
    
    public Estado guardar(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(CANTIDAD_DE_CAMPOS, NOMBRE_TABLA);
        
        try {
            
            prepared.setInt(LUGAR_DEL_CAMPO_ID, this.id);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_NOMBRE, this.idNombre);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_APELLIDO, this.idApellido);
            prepared.setInt(LUGAR_DEL_CAMPO_DNI, this.dni);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_DIRECCION, this.idDireccion);
            prepared.executeUpdate();
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            conn.closeConn(Persona.class.toString() + "guardar");
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        return estadoDevolver;
        
    }
    
    private static Persona nuevo(int idRecibido, AlfaNumerico nombreRecibido, AlfaNumerico apellidoRecibido, int dniRecibido, Direccion direccionRecibida, int idNombreRecibido, int idApellidoRecibido, int idDireccionrecibido) {
        
        Persona personaDevolver = new Persona();
        
        personaDevolver.id = idRecibido;
        personaDevolver.nombre = nombreRecibido;
        personaDevolver.apellido = apellidoRecibido;
        personaDevolver.dni = dniRecibido;
        personaDevolver.direccion = direccionRecibida;
        personaDevolver.idNombre = idNombreRecibido;
        personaDevolver.idApellido = idApellidoRecibido;
        personaDevolver.idDireccion = idDireccionrecibido;
        
        Estado seAgrego = Persona.addNewObjeto(personaDevolver);
        
        if(!(seAgrego == Estado.EXITO)){
            
            //listaObjetos.remove(personaDevolver);
            
        }else{
            
            //...no hacer nada
            
        }
        
        return personaDevolver;
        
    }
    
    protected static Estado getInformacion(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        //System.out.println("pregunta por las personas");
        
        ResultSet rs = null;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(NOMBRE_TABLA);
        
        try {
            
            rs = prepared.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(CAMPO_ID);
                int dniObjeto = rs.getInt(CAMPO_DNI);
                int id_nombre = rs.getInt(CAMPO_ID_NOMBRE);
                int id_apellido = rs.getInt(CAMPO_ID_APELLIDO);
                int id_direccion = rs.getInt(CAMPO_ID_DIRECCION);
                
                AlfaNumerico nombreObjeto = AlfaNumerico.getForId(id_nombre);
                AlfaNumerico apellidoObjeto = AlfaNumerico.getForId(id_apellido);
                Direccion direccionObjeto = Direccion.getForId(id_direccion);
                
                Persona asd = Persona.nuevo(id, nombreObjeto, apellidoObjeto, dniObjeto, direccionObjeto, nombreObjeto.getId(), apellidoObjeto.getId(), direccionObjeto.getId());
                
                //System.out.println(id);
                
            }
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            conn.closeConn(Persona.class.toString() + "getInformacion");
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        return estadoDevolver;
        
    }
    
    private static int getLastId(){
        
        int ultimoID = 0;
        
        Estado estadoConsulta = Estado.EXITO;
        //Estado estadoConsulta = getInformacion();

        if(listaObjetos != null){

            if(estadoConsulta == Estado.EXITO){

                for(Persona personaActual : listaObjetos){

                    if(personaActual.id > ultimoID){

                        ultimoID = personaActual.id;

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

    //Constructor
    
    private Persona(){}

    private Persona(int idRecibido) {

        //Asignar un identificador
        this.id = idRecibido;


    }
    
    protected static Persona nuevo(AlfaNumerico nombreRecibido, AlfaNumerico apellidoRecibido, int dniRecibido, Direccion direccionRecibida){

        //Crear un objeto a devolver
        Persona objetoDevolver = Persona.OBJETO_INVALIDO;

        //Obtener el siguiente identificador
        int identificador = getNewId();
        
        //Crear un nuevo objeto
        Persona objetoNuevo = new Persona(identificador);

        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);

        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){
            
            //Asignar el valor recibido por defecto
            Estado seSeteoNombre = objetoNuevo.setNombre(nombreRecibido);
            Estado seSeteoApellido = objetoNuevo.setApellido(apellidoRecibido);
            Estado seSeteoDni = objetoNuevo.setDni(dniRecibido);
            Estado seSeteoDireccion = objetoNuevo.setDireccion(direccionRecibida);
            
            Estado seSeteoIdNombre = objetoNuevo.setIdNombre(nombreRecibido.getId());
            Estado seSeteoIdApellido = objetoNuevo.setIdApellido(apellidoRecibido.getId());
            Estado seSeteoIdDireccion = objetoNuevo.setIdDireccion(direccionRecibida.getId());
            
            objetoDevolver = objetoNuevo;
            
            //Estado seGuardo = objetoDevolver.guardar();

        }else{

            //TODO capturar el error generado por un ingreso erroneo a la lista
            listaObjetos.remove(objetoDevolver);
            //...se establecio un valor por defecto

        }

        //Devolver el objeto requerido
        return objetoDevolver;

    }

    private static Persona nuevo(){

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
    
    private void setId(int id) {
        this.id = id;
    }

    private Estado setIdNombre(int idNombre) {
        
        this.idNombre = idNombre;
        
        return Estado.EXITO;
    }

    private Estado setIdApellido(int idApellido) {
        
        this.idApellido = idApellido;
        
        return Estado.EXITO;
    }

    private Estado setIdDireccion(int idDireccion) {
        
        this.idDireccion = idDireccion;
        
        return Estado.EXITO;
    }
    
    private Estado setNombre(AlfaNumerico objetoRecibido) {
        
        Estado estadoDevolver = Estado.ERROR;
        AlfaNumerico alfaSet = AlfaNumerico.OBJETO_INVALIDO;
        
        if(objetoRecibido != null){
            
            alfaSet = objetoRecibido;
            estadoDevolver = Estado.EXITO;
            
        }else{
            
            //..se establecio un valor por defecto
        }
        
        this.nombre = alfaSet;
        
        return estadoDevolver;
        
    }

    private Estado setApellido(AlfaNumerico objetoRecibido) {
        
        Estado estadoDevolver = Estado.ERROR;
        AlfaNumerico alfaSet = AlfaNumerico.OBJETO_INVALIDO;
        
        if(objetoRecibido != null){
            
            alfaSet = objetoRecibido;
            estadoDevolver = Estado.EXITO;
            
        }else{
            
            //..se establecio un valor por defecto
        }
        
        this.apellido = alfaSet;
        
        return estadoDevolver;
        
    }

    private Estado setDni(int dni) {
        
        this.dni = dni;
        
        return Estado.EXITO;
    }

    private Estado setDireccion(Direccion objetoRecibido) {
        
        Estado estadoDevolver = Estado.ERROR;
        Direccion alfaSet = Direccion.OBJETO_INVALIDO;
        
        if(objetoRecibido != null){
            
            alfaSet = objetoRecibido;
            estadoDevolver = Estado.EXITO;
            
        }else{
            
            //..se establecio un valor por defecto
        }
        
        this.direccion = alfaSet;
        
        return estadoDevolver;
        
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
     * Esta funcion devulve el dniObjeto de la persona.
     * Se debe establecer su validez a traves de una
     * funcion de la interfaz del paquete contenedor.
     * 
     * @return int dniObjeto
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
    
    protected static Set<Persona> getListaObjetos() {
        
        Set<Persona> listaDevolver = new HashSet<>();
        
        listaDevolver = listaObjetos;
        
        return listaDevolver;
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
