/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;

import java.util.*;
import java.sql.*;

/**
 *
 * @author Tomás Contreras
 */
public class Carrera {
    
    //Atributos
    
    private static final String NOMBRE_TABLA = "carrera";
    
    private static final String CAMPO_ID = "id";
    private static final String CAMPO_ID_IDENTIFICADOR = "id_identificador";
    private static final String CAMPO_ID_NOMBRE = "id_nombre";
    
    private static final int CANTIDAD_DE_CAMPOS = 3;
    private static final int LUGAR_DEL_CAMPO_ID = 1;
    private static final int LUGAR_DEL_CAMPO_ID_IDENTIFICADOR = 2;
    private static final int LUGAR_DEL_CAMPO_ID_NOMBRE = 3;
    
    private int id;                   //tipo bd
    private AlfaNumerico identificador;     //id identificador
    private AlfaNumerico nombre;            //id identificador
    
    private int idIdentificador;
    private int idNombre;
            
    protected final static Carrera OBJETO_INVALIDO = new Carrera();

    private static Set<Carrera> listaObjetos = new HashSet<>();
    
    //Rutinas
    
    public Estado modificar(AlfaNumerico identificadorRecibido, AlfaNumerico nombreRecibido){
        
        Estado estadoDevolver = Estado.ERROR;
        
        this.borrar();
        Carrera nuevoObjeto = Carrera.nuevo(identificadorRecibido, nombreRecibido);
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

    protected static Carrera getForId(int idRecibido){
        
        Carrera carreraDevolver = OBJETO_INVALIDO;
        
        Estado seObtuvo = Estado.EXITO;
        //Estado seObtuvo = getInformacion();
        
        if(listaObjetos != null){
            
            if(seObtuvo == Estado.EXITO){

                for(Carrera carreraActual : listaObjetos){

                    if(carreraActual.id == idRecibido){

                        carreraDevolver = carreraActual;

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
        return carreraDevolver;
        
    }
    
    public Estado guardar(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(CANTIDAD_DE_CAMPOS, NOMBRE_TABLA);
        
        //System.out.println("entra a guardar");
        try {
            
            prepared.setInt(LUGAR_DEL_CAMPO_ID, this.id);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_IDENTIFICADOR, this.idIdentificador);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_NOMBRE, this.idNombre);
            
            //System.out.println(prepared.toString());
            
            prepared.executeUpdate();
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            conn.closeConn(PedidoArticulo.class.toString() + "guardar");
            
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            System.out.println("se rompe en la persistencia de " + Articulo.class.toString() + " guardar");
            e.printStackTrace();
            
        }
        
        return estadoDevolver;
        
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
                int idIdentificador = rs.getInt(CAMPO_ID_IDENTIFICADOR);
                int idNombre = rs.getInt(CAMPO_ID_NOMBRE);
                
                AlfaNumerico identificadorObjeto = AlfaNumerico.getForId(idIdentificador);
                AlfaNumerico nombreObjeto = AlfaNumerico.getForId(idNombre);
                
                Carrera asd = Carrera.nuevo(id, identificadorObjeto, nombreObjeto, identificadorObjeto.getId(), nombreObjeto.getId());
                
                //System.out.println("este es el pedidoArticulo numero: " + asd.id);
                
            }
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            conn.closeConn(PedidoArticulo.class.toString() + "getInformacion");
            
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
            
            //System.out.println("la lista no es nula");

            if(estadoConsulta == Estado.EXITO){

                for(Carrera carreraActual : listaObjetos){

                    if(carreraActual.id > ultimoID){

                        ultimoID = carreraActual.id;

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
        //System.out.println("el valor del siuiente id es " + idActual);

        //Devolver el nuevo identificador
        return idActual;

    }

    //Constructor
    
    private static Carrera nuevo(int idRecibido, AlfaNumerico identificadorrecibido, AlfaNumerico nombreRecibido, int idIdentificadorRecibido, int idNombreRecibido){
        
        Carrera carreraDevolver = new Carrera();
        
        carreraDevolver.id = idRecibido;
        carreraDevolver.identificador = identificadorrecibido;
        carreraDevolver.nombre = nombreRecibido;
        
        carreraDevolver.idIdentificador = idIdentificadorRecibido;
        carreraDevolver.idNombre = idNombreRecibido;
        
        Estado seAgrego = Carrera.addNewObjeto(carreraDevolver);
        
        if(!(seAgrego == Estado.EXITO)){
            
            //listaObjetos.remove(usuarioDevolver);
            
        }else{
            
            //...no hacer nada
            
        }
        
        return carreraDevolver;
    }
    
    private Carrera(int identificadorRecibido){
        
        this.id = identificadorRecibido;
    }
    
    protected static Carrera nuevo(AlfaNumerico identificadorRecibido, AlfaNumerico nombreRecibido){

        //Crear un objeto a devolver
        Carrera objetoDevolver = Carrera.OBJETO_INVALIDO;

        //Obtener el siguiente identificador
        int newId = getNewId();
        
        //Crear un nuevo objeto
        Carrera objetoNuevo = new Carrera(newId);

        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);

        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){
            
            //Asignar el valor recibido por defecto
            objetoNuevo.setNombre(nombreRecibido);
            objetoNuevo.setIdentificador(identificadorRecibido);
            
            objetoNuevo.setIdIdentificador(identificadorRecibido.getId());
            objetoNuevo.setIdNombre(nombreRecibido.getId());
            
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

    private Carrera() {}

    private static Carrera nuevo(){

        //Crear un objeto a devolver
        Carrera objetoDevolver = Carrera.OBJETO_INVALIDO;

        //Crear un nuevo objeto
        Carrera objetoNuevo = new Carrera();

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
        if(objetoActual.getClass() == Carrera.class){

            //Obtener el objeto requerido
            Carrera objetoAgregar = (Carrera)objetoActual;

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

    private void setIdentificador(AlfaNumerico identificador) {
        this.identificador = identificador;
    }

    private void setNombre(AlfaNumerico nombre) {
        this.nombre = nombre;
    }

    private void setIdIdentificador(int idIdentificador) {
        this.idIdentificador = idIdentificador;
    }

    private void setIdNombre(int idNombre) {
        this.idNombre = idNombre;
    }
    
    //Getter

    public int getId() {
        return id;
    }

    public AlfaNumerico getIdentificador() {
        return identificador;
    }

    public AlfaNumerico getNombre() {
        return nombre;
    }

    protected static Set<Carrera> getListaObjetos() {
        
        Set<Carrera> listaDevolver = listaObjetos;
        
        return listaDevolver;
    }
    
    
    
    //Others
    
    @Override
    public boolean equals(Object objetoActual) {

        if(objetoActual == null){return false;}
        if(this.getClass() != objetoActual.getClass()){return false;}

        final Carrera objetoRecibido = (Carrera) objetoActual;

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
