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
public class Materia {
    
    //Atributos
    
    private static final String NOMBRE_TABLA = "materia";
    
    private static final String CAMPO_ID = "id";
    private static final String CAMPO_ID_NOMBRE = "id_nombre";
    private static final String CAMPO_ANIO = "anio";
    private static final String CAMPO_ID_TITULAR = "id_titular";
    private static final String CAMPO_ID_AYUDANTE = "id_ayudante";
    private static final String CAMPO_ID_TUTOR = "id_tutor";
    private static final String CAMPO_ID_JTP = "id_jtp";
    private static final String CAMPO_ID_CARRERA = "id_carrera";
    
    private static final int CANTIDAD_DE_CAMPOS = 8;
    private static final int LUGAR_DEL_CAMPO_ID = 1;
    private static final int LUGAR_DEL_CAMPO_ID_NOMBRE = 2;
    private static final int LUGAR_DEL_CAMPO_ANIO = 3;
    private static final int LUGAR_DEL_CAMPO_ID_TITULAR = 4;
    private static final int LUGAR_DEL_CAMPO_ID_AYUDANTE = 5;
    private static final int LUGAR_DEL_CAMPO_ID_TUTOR = 6;
    private static final int LUGAR_DEL_CAMPO_ID_JTP = 7;
    private static final int LUGAR_DEL_CAMPO_ID_CARRERA = 8;
    
    private int id;           //tipo bd
    private AlfaNumerico nombre;    //id identificador
    private int anio;               //tipo bd
    private Persona titular;        //id identificador
    private Persona ayudante;       //id identificador
    private Persona tutor;          //id identificador
    private Persona jtp;            //id identificador
    private Carrera carrera;        //id identificador
    
    private int idNombre;
    private int idTitular;
    private int idAyudante;
    private int idTutor;
    private int idJtp;
    private int idCarrera;
            
    protected final static Materia OBJETO_INVALIDO = new Materia();

    private static Set<Materia> listaObjetos = new HashSet<>();
    
    //Rutinas
    
    public Estado modificar(AlfaNumerico nombreRecibido, int anioRecibido, Persona titularRecibido, Persona ayudanteRecibido, Persona tutorRecibido, Persona jtpRecibido, Carrera carreraRecibida){
        
        Estado estadoDevolver = Estado.ERROR;
        
        this.borrar();
        Materia nuevoObjeto = Materia.nuevo(nombreRecibido, anioRecibido, titularRecibido, ayudanteRecibido, tutorRecibido, jtpRecibido, carreraRecibida);
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
    
    protected static Materia getForNombre(String nombreRecibido){
        
        Materia materiaDevolver = OBJETO_INVALIDO;
        
        Estado seObtuvo = Estado.EXITO;
        //Estado seObtuvo = getInformacion();
        
        if(listaObjetos != null){
            
            if(seObtuvo == Estado.EXITO){

                for(Materia materiaActual : listaObjetos){

                    if(materiaActual.nombre.getValor().equals(nombreRecibido)){

                        materiaDevolver = materiaActual;

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
        return materiaDevolver;
        
    }

    protected static Materia getForId(int idRecibido){
        
        Materia materiaDevolver = OBJETO_INVALIDO;
        
        Estado seObtuvo = Estado.EXITO;
        //Estado seObtuvo = getInformacion();
        
        if(listaObjetos != null){
            
            if(seObtuvo == Estado.EXITO){

                for(Materia materiaActual : listaObjetos){

                    if(materiaActual.id == idRecibido){

                        materiaDevolver = materiaActual;

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
        return materiaDevolver;
        
    }
    
    public Estado guardar(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(CANTIDAD_DE_CAMPOS, NOMBRE_TABLA);
        
        //System.out.println("entra a guardar");
        try {
            
            prepared.setInt(LUGAR_DEL_CAMPO_ID, this.id);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_NOMBRE, this.idNombre);
            prepared.setInt(LUGAR_DEL_CAMPO_ANIO, this.anio);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_TITULAR, this.idTitular);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_AYUDANTE, this.idAyudante);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_TUTOR, this.idTutor);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_JTP, this.idJtp);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_CARRERA, this.idCarrera);
            
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
                int idNombre = rs.getInt(CAMPO_ID_NOMBRE);
                int anioObjeto = rs.getInt(CAMPO_ANIO);
                int idTitular = rs.getInt(CAMPO_ID_TITULAR);
                int idAyudante = rs.getInt(CAMPO_ID_AYUDANTE);
                int idTutor = rs.getInt(CAMPO_ID_TUTOR);
                int idJtp = rs.getInt(CAMPO_ID_JTP);
                int idCarrera = rs.getInt(CAMPO_ID_CARRERA);
                
                AlfaNumerico nombreObjeto = AlfaNumerico.getForId(idNombre);
                Persona titularObjeto = Persona.getForId(idTitular);
                Persona ayudanteObjeto = Persona.getForId(idAyudante);
                Persona tutorObjeto = Persona.getForId(idTutor);
                Persona jtpObjeto = Persona.getForId(idJtp);
                Carrera carreraObjeto = Carrera.getForId(idCarrera);
                
                Materia asd = Materia.nuevo(id, nombreObjeto, anioObjeto, titularObjeto, ayudanteObjeto, tutorObjeto, jtpObjeto, carreraObjeto, nombreObjeto.getId(), titularObjeto.getId(), ayudanteObjeto.getId(), tutorObjeto.getId(), jtpObjeto.getId(), carreraObjeto.getId());
                
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

                for(Materia materiaActual : listaObjetos){

                    if(materiaActual.id > ultimoID){

                        ultimoID = materiaActual.id;

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
    
    private static Materia nuevo(int idRecibido, AlfaNumerico nombrerecibidorecibido, int anioRecibido, Persona titularRecibido, Persona ayudanteRecibido, Persona tutorRecibido, Persona jtpRecibido, Carrera carreraRecibida, int idNombreRecibido, int idTitularRecibido, int idAyudanteRecibido, int idTutorRecibido, int idJtpRecibido, int idCarreraRecibida){
        
        Materia materiaDevolver = new Materia();
        
        materiaDevolver.id = idRecibido;
        materiaDevolver.nombre = nombrerecibidorecibido;
        materiaDevolver.anio = anioRecibido;
        materiaDevolver.titular = titularRecibido;
        materiaDevolver.ayudante = ayudanteRecibido;
        materiaDevolver.tutor = tutorRecibido;
        materiaDevolver.jtp = jtpRecibido;
        materiaDevolver.carrera = carreraRecibida;
        
        materiaDevolver.idNombre = idNombreRecibido;
        materiaDevolver.idTitular = idTitularRecibido;
        materiaDevolver.idAyudante = idAyudanteRecibido;
        materiaDevolver.idTutor = idTutorRecibido;
        materiaDevolver.idJtp = idJtpRecibido;
        materiaDevolver.idCarrera = idCarreraRecibida;
        
        Estado seAgrego = Materia.addNewObjeto(materiaDevolver);
        
        if(!(seAgrego == Estado.EXITO)){
            
            //listaObjetos.remove(usuarioDevolver);
            
        }else{
            
            //...no hacer nada
            
        }
        
        return materiaDevolver;
    }
    
    private Materia(int identificadorRecibido){
        
        this.id = identificadorRecibido;
        
    }
    
    protected static Materia nuevo(AlfaNumerico nombreRecibido, int anioRecibido, Persona titularRecibido, Persona ayudanteRecibido, Persona tutorRecibido, Persona jtpRecibido, Carrera carreraRecibida){

        //Crear un objeto a devolver
        Materia objetoDevolver = Materia.OBJETO_INVALIDO;

        //Obtener el siguiente identificador
        int newId = getNewId();
        
        //Crear un nuevo objeto
        Materia objetoNuevo = new Materia(newId);

        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);

        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){
            
            //Asignar el valor recibido por defecto
            objetoNuevo.setNombre(nombreRecibido);
            objetoNuevo.setAnio(anioRecibido);
            objetoNuevo.setTitular(titularRecibido);
            objetoNuevo.setAyudante(ayudanteRecibido);
            objetoNuevo.setTutor(tutorRecibido);
            objetoNuevo.setJtp(jtpRecibido);
            objetoNuevo.setCarrera(carreraRecibida);
            
            objetoNuevo.setIdNombre(nombreRecibido.getId());
            objetoNuevo.setIdTitular(titularRecibido.getId());
            objetoNuevo.setIdAyudante(ayudanteRecibido.getId());
            objetoNuevo.setIdTutor(tutorRecibido.getId());
            objetoNuevo.setIdJtp(jtpRecibido.getId());
            objetoNuevo.setIdCarrera(carreraRecibida.getId());
            
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

    private Materia() {}

    private static Materia nuevo(){

        //Crear un objeto a devolver
        Materia objetoDevolver = Materia.OBJETO_INVALIDO;

        //Crear un nuevo objeto
        Materia objetoNuevo = new Materia();

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
        if(objetoActual.getClass() == Materia.class){

            //Obtener el objeto requerido
            Materia objetoAgregar = (Materia)objetoActual;

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

    private void setNombre(AlfaNumerico nombre) {
        this.nombre = nombre;
    }

    private void setAnio(int anio) {
        this.anio = anio;
    }

    private void setTitular(Persona titular) {
        this.titular = titular;
    }

    private void setAyudante(Persona ayudante) {
        this.ayudante = ayudante;
    }

    private void setTutor(Persona tutor) {
        this.tutor = tutor;
    }

    private void setJtp(Persona jtp) {
        this.jtp = jtp;
    }

    private void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    private void setIdNombre(int idNombre) {
        this.idNombre = idNombre;
    }

    private void setIdTitular(int idTitular) {
        this.idTitular = idTitular;
    }

    private void setIdAyudante(int idAyudante) {
        this.idAyudante = idAyudante;
    }

    private void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    private void setIdJtp(int idJtp) {
        this.idJtp = idJtp;
    }

    private void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }
    
    //Getter

    public int getId() {
        return id;
    }

    public AlfaNumerico getNombre() {
        
        AlfaNumerico alfanumericoDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        alfanumericoDevolver = this.nombre;
        
        return alfanumericoDevolver;
    }

    public int getAnio() {
        return anio;
    }

    public Persona getTitular() {
        
        Persona personaDevolver = Persona.OBJETO_INVALIDO;
        
        personaDevolver = this.titular;
        
        return personaDevolver;
    }

    public Persona getAyudante() {
        
        Persona personaDevolver = Persona.OBJETO_INVALIDO;
        
        personaDevolver = this.ayudante;
        
        return personaDevolver;
    }

    public Persona getTutor() {
        
        Persona personaDevolver = Persona.OBJETO_INVALIDO;
        
        personaDevolver = this.tutor;
        
        return personaDevolver;
    }

    public Carrera getCarrera() {
        
        Carrera carreraDevolver = Carrera.OBJETO_INVALIDO;
        
        carreraDevolver = this.carrera;
        
        return carreraDevolver;
    }

    protected static Set<Materia> getListaObjetos() {
        
        Set<Materia> listaDevolver = new HashSet<>();
        
        listaDevolver = listaObjetos;
        
        return listaDevolver;
    }

    public Persona getJtp() {
        
        Persona personaDevolver = Persona.OBJETO_INVALIDO;
        
        personaDevolver = this.jtp;
        
        return personaDevolver;
    }
    
    //Others
    
    @Override
    public boolean equals(Object objetoActual) {

        if(objetoActual == null){return false;}
        if(this.getClass() != objetoActual.getClass()){return false;}

        final Materia objetoRecibido = (Materia) objetoActual;

        if(this.hashCode() != objetoRecibido.hashCode()){return false;}

        return true;

    }

    @Override
    public int hashCode() {

        return this.id;

    }
    
    @Override
    public String toString() {
        
        String nombreDevolver = "no tiene valor materia.tostring";
        
        if(this != null){
            
            if(this.nombre != null){
                
                if(this.nombre.toString() != null){
                    
                    nombreDevolver = this.nombre.toString();
                    
                }else{
                    
                    //...se establecio un valor por defecto
                }
                
            }else{
                
                //...se establecio un valor por defecto
                
            }
            
        }
        return nombreDevolver;
        
    }
    
}
