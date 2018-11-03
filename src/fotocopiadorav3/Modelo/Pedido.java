/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;

import java.util.*;
import java.sql.*;

/**
 * Esta clase determina la transacción básica del dominio de negocio.
 * Puede tener varios documentos en un pedido.
 * 
 * @param Identificador
 * @param Fecha
 * @param Importe
 * @author Tomás Contreras
 */
public class Pedido {
    
    //atributos
    
    private static final String NOMBRE_TABLA = "pedido";
    
    private static final String CAMPO_ID = "id";
    private static final String CAMPO_FECHA = "fecha";
    private static final String CAMPO_IMPORTE = "importe";
    private static final String CAMPO_ID_ALUMNO = "id_alumno";
    private static final String CAMPO_ID_CODIGO_TRANSACCION = "id_codigo_transaccion";
    private static final String CAMPO_PAGO_ANTICIPADO = "pago_anticipado";
    
    private static final int CANTIDAD_DE_CAMPOS = 6;
    private static final int LUGAR_DEL_CAMPO_ID = 1;
    private static final int LUGAR_DEL_CAMPO_FECHA = 2;
    private static final int LUGAR_DEL_CAMPO_IMPORTE = 3;
    private static final int LUGAR_DEL_CAMPO_ID_ALUMNO = 4;
    private static final int LUGAR_DEL_CAMPO_ID_CODIGO_TRANSACCION = 5;
    private static final int LUGAR_DEL_CAMPO_PAGO_ANTICIPADO = 6;
    
    private int id;
    private java.sql.Date fecha;
    private double importe;
    private Alumno alumno;
    private AlfaNumerico codigoTransaccion;
    private double pagoAnticipado;
    
    private int idAlumno;
    private int idCodigoTransaccion;
            
    protected final static Pedido OBJETO_INVALIDO = new Pedido();

    private static Set<Pedido> listaObjetos = new HashSet<>();
    
    //Rutinas
    
    public Estado modificar(java.sql.Date fechaRecibida, double importeRecibida, Alumno alumnoRecibido, AlfaNumerico codigoTransaccionrecibido, double pagoAnticipadoRecibido){
        
        Estado estadoDevolver = Estado.ERROR;
        
        this.borrar();
        Pedido nuevoObjeto = Pedido.nuevo(fechaRecibida, importeRecibida, alumnoRecibido, codigoTransaccionrecibido, pagoAnticipadoRecibido);
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
    
    public static Pedido getForId(int idRecibido){
        
        Pedido pedidoDevolver = OBJETO_INVALIDO;
        
        Estado seObtuvo = Estado.EXITO;
        //Estado seObtuvo = getInformacion();
        
        if(listaObjetos != null){
            
            if(seObtuvo == Estado.EXITO){

                for(Pedido pedidoActual : listaObjetos){

                    if(pedidoActual.id == idRecibido){

                        pedidoDevolver = pedidoActual;

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
        return pedidoDevolver;
        
    }
    
    public Estado guardar(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(CANTIDAD_DE_CAMPOS, NOMBRE_TABLA);
        
        try {
            
            prepared.setInt(LUGAR_DEL_CAMPO_ID, this.id);
            //System.out.println("lugar del campo " + LUGAR_DEL_CAMPO_ID + " id " + this.id);
            prepared.setDate(LUGAR_DEL_CAMPO_FECHA, this.fecha);
            prepared.setDouble(LUGAR_DEL_CAMPO_IMPORTE, this.importe);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_ALUMNO, this.idAlumno);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_CODIGO_TRANSACCION, this.idCodigoTransaccion);
            prepared.setDouble(LUGAR_DEL_CAMPO_PAGO_ANTICIPADO, this.pagoAnticipado);
            
            System.out.println(prepared.toString());
            
            prepared.executeUpdate();
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            conn.closeConn(Usuario.class.toString() + "guardar");
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        return estadoDevolver;
        
    }
    
    protected static Estado getInformacion(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        //System.out.println("pregunta por los usuarios");
        
        ResultSet rs = null;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(NOMBRE_TABLA);
        
        try {
            
            rs = prepared.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(CAMPO_ID);
                java.sql.Date fechaObjeto = rs.getDate(CAMPO_FECHA);
                double importeObjeto = rs.getDouble(CAMPO_IMPORTE);
                int idAlumno = rs.getInt(CAMPO_ID_ALUMNO);
                int idCodigoTransaccion = rs.getInt(CAMPO_ID_CODIGO_TRANSACCION);
                double pagoAnticipadoObjeto = rs.getDouble(CAMPO_PAGO_ANTICIPADO);
                
                Alumno alumnoObjeto = Alumno.getForId(idAlumno);
                AlfaNumerico codigoTransaccionObjeto = AlfaNumerico.getForId(idCodigoTransaccion);
                
                Pedido asd = Pedido.nuevo(id, fechaObjeto, importeObjeto, alumnoObjeto, codigoTransaccionObjeto, pagoAnticipadoObjeto, alumnoObjeto.getId(), codigoTransaccionObjeto.getId());
                
                //System.out.println(id);
                
            }
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            conn.closeConn(Pedido.class.toString() + "getInformacion");
            
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

                for(Pedido pedidoActual : listaObjetos){

                    if(pedidoActual.id > ultimoID){

                        ultimoID = pedidoActual.id;

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
    
    private static Estado exiteCodigoTransaccion(){
        
        //Establecer un valor por defecto
        Estado estadoDevolver = Estado.ERROR_CODIGO_TRANSACCION_INEXISTENTE;
        
        
        
        return estadoDevolver;
        
    }
    
    private static AlfaNumerico getNewCodigoTransaccion(){
        
        AlfaNumerico alfaNumerico = AlfaNumerico.OBJETO_INVALIDO;
        
        
        
        return alfaNumerico;
        
    }

    //Constructor
    
    private static Pedido nuevo(int idRecibido, java.sql.Date fechaRecibida, double importeRecibido, Alumno alumnoRecibido, AlfaNumerico codigoTransaccionRecibido, double pagoAnticipadoRecibido, int idAlumnoRecibido, int idCodigotransaccionrecibido){
        
        Pedido pedidoDevolver = new Pedido();
        
        pedidoDevolver.id = idRecibido;
        pedidoDevolver.fecha = fechaRecibida;
        pedidoDevolver.importe = importeRecibido;
        pedidoDevolver.alumno = alumnoRecibido;
        pedidoDevolver.codigoTransaccion = codigoTransaccionRecibido;
        pedidoDevolver.pagoAnticipado = pagoAnticipadoRecibido;
        
        pedidoDevolver.idAlumno = idAlumnoRecibido;
        pedidoDevolver.idCodigoTransaccion = idCodigotransaccionrecibido;
        
        Estado seAgrego = Pedido.addNewObjeto(pedidoDevolver);
        
        if(!(seAgrego == Estado.EXITO)){
            
            //listaObjetos.remove(usuarioDevolver);
            
        }else{
            
            //...no hacer nada
            
        }
        
        return pedidoDevolver;
    }
    
    protected static Pedido nuevo(java.sql.Date fechaRecibida, double importeRecibida, Alumno alumnoRecibido, AlfaNumerico codigoTransaccionrecibido, double pagoAnticipadoRecibido){

        //Crear un objeto a devolver
        Pedido objetoDevolver = Pedido.OBJETO_INVALIDO;

        //Obtener el siguiente identificador
        int identificador = getNewId();
        
        //Crear un nuevo objeto
        Pedido objetoNuevo = new Pedido(identificador);

        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);

        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){
            
            //Asignar el valor recibido por defecto
            Estado seSeteoFecha = objetoNuevo.setFecha(fechaRecibida);
            Estado seSeteoImporte = objetoNuevo.setImporte(importeRecibida);
            Estado seSeteoAlumno = objetoNuevo.setAlumno(alumnoRecibido);
            Estado seSeteoCodigoTransaccion = objetoNuevo.setCodigoTransaccion(codigoTransaccionrecibido);
            Estado seSeteoPagoAnticipado = objetoNuevo.setPagoAnticipado(pagoAnticipadoRecibido);
            
            Estado seSeteoIdAlumno = objetoNuevo.setIdAlumno(alumnoRecibido.getId());
            Estado seSeteoIdCodigoTransaccion = objetoNuevo.setIdCodigoTransaccion(codigoTransaccionrecibido.getId());
            
            //System.out.println("se setean lso nuevos valores");
            objetoDevolver = objetoNuevo;
            
            //Estado seGuardo = objetoDevolver.guardar();

        }else{
            
            //System.out.println("se quita el objeto de la lista de pedidos");

            //TODO capturar el error generado por un ingreso erroneo a la lista
            listaObjetos.remove(objetoDevolver);
            //...se establecio un valor por defecto

        }

        //Devolver el objeto requerido
        return objetoDevolver;

    }

    private Pedido() {}
    
    private Pedido(int identificadorRecibido){
        
        this.id = identificadorRecibido;
        
    }

    private static Pedido nuevo(){

        //Crear un objeto a devolver
        Pedido objetoDevolver = Pedido.OBJETO_INVALIDO;

        //Crear un nuevo objeto
        Pedido objetoNuevo = new Pedido();

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
        if(objetoActual.getClass() == Pedido.class){

            //Obtener el objeto requerido
            Pedido objetoAgregar = (Pedido)objetoActual;

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

    private Estado setId(int id) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.id = id;
        
        return estadoDevolver;
    }

    private Estado setFecha(java.sql.Date fecha) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.fecha = fecha;
        
        return estadoDevolver;
    }

    private Estado setImporte(double importe) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.importe = importe;
        
        return estadoDevolver;
    }

    private Estado setAlumno(Alumno alumno) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.alumno = alumno;
        
        return estadoDevolver;
    }

    private Estado setCodigoTransaccion(AlfaNumerico codigoTransaccion) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.codigoTransaccion = codigoTransaccion;
        
        return estadoDevolver;
    }

    private Estado setPagoAnticipado(double pagoAnticipado) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.pagoAnticipado = pagoAnticipado;
        
        return estadoDevolver;
    }

    private Estado setIdCodigoTransaccion(int idCodigoTransaccion) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.idCodigoTransaccion = idCodigoTransaccion;
        
        return estadoDevolver;
    }

    private Estado setIdAlumno(int idAlumno) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.idAlumno = idAlumno;
        
        return estadoDevolver;
    }
    
    //Getter

    public int getId() {
        return id;
    }

    public java.sql.Date getFecha() {
        return fecha;
    }

    public double getImporte() {
        return importe;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public AlfaNumerico getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public double getPagoAnticipado() {
        return pagoAnticipado;
    }
    
    protected static Set<Pedido> getListaObjetos(){
        
        Set<Pedido> listaDevolver = listaObjetos;
        
        return listaDevolver;
    }
    
    //Others
    
    @Override
    public boolean equals(Object objetoActual) {

        if(objetoActual == null){return false;}
        if(this.getClass() != objetoActual.getClass()){return false;}

        final Pedido objetoRecibido = (Pedido) objetoActual;

        if(this.hashCode() != objetoRecibido.hashCode()){return false;}

        return true;

    }

    @Override
    public int hashCode() {

        return this.id;

    }
    
    @Override
    public String toString() {
        
        return "Definir";
        
    }
    
}
