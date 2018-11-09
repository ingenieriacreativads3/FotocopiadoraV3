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
public class Alumno{
    
    private static final String NOMBRE_TABLA = "alumno";
    private static final String CAMPO_ID = "id";
    private static final String CAMPO_LEGAJO = "legajo";
    private static final String CAMPO_ID_PERSONA = "id_persona";
    private static final int CANTIDAD_DE_CAMPOS = 3;
    private static final int LUGAR_DEL_CAMPO_ID = 1;
    private static final int LUGAR_DEL_CAMPO_LEGAJO = 2;
    private static final int LUGAR_DEL_CAMPO_ID_PERSONA = 3;
    
    private int id;
    private int legajo;
    private Persona persona;
    private int idPersona;
            
    public final static Alumno OBJETO_INVALIDO = new Alumno();

    private static Set<Alumno> listaObjetos = new HashSet<>();
    
    //Rutinas
    
    public Estado modificar(int legajoRecibido, Persona personaRecibida){
        
        Estado estadoDevolver = Estado.ERROR;
        
        this.borrar();
        Alumno nuevoObjeto = Alumno.nuevo(legajoRecibido, personaRecibida);
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
    
    protected static Alumno getForId(int idRecibido){
        
        Alumno alumnoDevolver = null;
        
        Estado seObtuvo = Estado.EXITO;
        //Estado seObtuvo = getInformacion();
        
        if(listaObjetos != null){
            
            System.out.println("la lista no es nula");
            if(seObtuvo == Estado.EXITO){

                for(Alumno alumnoActual : listaObjetos){

                    if(alumnoActual.id == idRecibido){

                        alumnoDevolver = alumnoActual;

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
        return alumnoDevolver;
        
    }
    
    public Estado guardar(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(CANTIDAD_DE_CAMPOS, NOMBRE_TABLA);
        
        try {
            
            prepared.setInt(LUGAR_DEL_CAMPO_ID, this.id);
            prepared.setInt(LUGAR_DEL_CAMPO_LEGAJO, this.legajo);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_PERSONA, this.idPersona);
            prepared.executeUpdate();
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            conn.closeConn(Alumno.class.toString() + "guardar");
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        return estadoDevolver;
        
    }

    protected static Estado getInformacion(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        //System.out.println("pregunta por los alumnos");
        
        ResultSet rs = null;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(NOMBRE_TABLA);
        
        try {
            
            rs = prepared.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(CAMPO_ID);
                int legajoActual = rs.getInt(CAMPO_LEGAJO);
                int idPersona = rs.getInt(CAMPO_ID_PERSONA);
                
                Persona personaObjeto = Persona.getForId(idPersona);
                
                Alumno asd = nuevo(id, legajoActual, personaObjeto, idPersona);
                
                //System.out.println(id);
            }
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            conn.closeConn(Alumno.class.toString() + "getInformacion");
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        //System.out.println(prepared.toString());
        
        return estadoDevolver;
        
    }
    
    private static int getLastId(){
        
        int ultimoID = 0;
        
        //Estado estadoConsulta = getInformacion();
        Estado estadoConsulta = Estado.EXITO;

        if(listaObjetos != null){

            if(estadoConsulta == Estado.EXITO){

                for(Alumno alumnoActual : listaObjetos){

                    if(alumnoActual.id > ultimoID){

                        ultimoID = alumnoActual.id;

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
    
    private static Alumno nuevo(int idActual, int legajoRecibido, Persona personaRecibida, int idPersonaRecibida) {
        
        Alumno alumnoDevolver = new Alumno();
        
        alumnoDevolver.id = idActual;
        alumnoDevolver.legajo = legajoRecibido;
        alumnoDevolver.persona = personaRecibida;
        alumnoDevolver.idPersona = idPersonaRecibida;
        
        Estado seAgrego = Alumno.addNewObjeto(alumnoDevolver);
        
        return alumnoDevolver;
        
    }
    
    protected static Alumno nuevo(int legajoRecibido, Persona personaRecibida){

        //Crear un objeto a devolver
        Alumno objetoDevolver = Alumno.OBJETO_INVALIDO;

        //Obtener el siguiente identificador
        int identificador = getNewId();
        
        //Crear un nuevo objeto
        Alumno objetoNuevo = new Alumno(identificador);

        System.out.println("antes de guardar size: " + listaObjetos.size());
        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);

        System.out.println("despues de guardar size: " + listaObjetos.size());
        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){
            
            //Asignar el valor recibido por defecto
            
            Estado seSeteoLegajo = objetoNuevo.setLegajo(legajoRecibido);
            Estado seSeteoPersona = objetoNuevo.setPersona(personaRecibida);
            Estado seSeteoIdPersona = objetoNuevo.setIdPersona(personaRecibida.getId());
            
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

    private Alumno(int identificadorRecibido){
        
        this.id = identificadorRecibido;
        
    }

    private Alumno() {

        //Asignar un identificador
        //this.id = getNewId();


    }

    private static Alumno nuevo(){

        //Crear un objeto a devolver
        Alumno objetoDevolver = Alumno.OBJETO_INVALIDO;

        //Crear un nuevo objeto
        Alumno objetoNuevo = new Alumno();

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
        if(objetoActual.getClass() == Alumno.class){

            //Obtener el objeto requerido
            Alumno objetoAgregar = (Alumno)objetoActual;

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
    
    private void setId(int id) {
        this.id = id;
    }
    
    private Estado setLegajo(int idLegajorecibido){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.legajo = idLegajorecibido;
        
        return estadoDevolver;
        
    }
    
    private Estado setPersona(Persona personaRecibida){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.persona = personaRecibida;
        
        return estadoDevolver;
        
    }
    
    private Estado setIdPersona(int idPersonaRecibida){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.idPersona = idPersonaRecibida;
        
        return estadoDevolver;
        
    }
    
    //Getter
    
    protected static Set<Alumno> getListaObjetos() {
        
        Set<Alumno> listaDevolver = new HashSet<>();
        
        listaDevolver = listaObjetos;
        
        return listaDevolver;
    }

    public int getId() {
        return id;
    }
    
    public int getLegajo() {
        return legajo;
    }
    
    public Persona getPersona(){
        
        Persona personaDevolver = Persona.OBJETO_INVALIDO;
        
        personaDevolver = this.persona;
        
        return personaDevolver;
    }
    
    //Others
    
    @Override
    public boolean equals(Object objetoActual) {

        if(objetoActual == null){return false;}
        if(this.getClass() != objetoActual.getClass()){return false;}

        final Alumno objetoRecibido = (Alumno) objetoActual;

        if(this.hashCode() != objetoRecibido.hashCode()){return false;}

        return true;

    }

    @Override
    public int hashCode() {

        return this.id;

    }
    
    @Override
    public String toString() {
        
        return super.toString();
        
    }

}
